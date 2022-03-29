using Draw.src.Processors;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Windows.Forms;

namespace Draw
{
	/// <summary>
	/// Класът, който ще бъде използван при управляване на диалога.
	/// </summary>
	public class DialogProcessor : GeometricProcessor
	{
		#region Constructor
		
		public DialogProcessor()
		{
		}

		#endregion

		#region Properties
		private MemoryStream ms = new MemoryStream();
		/// <summary>
		/// Избран елемент.
		/// </summary>
		private List<Shape> selection = new List<Shape>();
		public List<Shape> Selection {
			get { return selection; }
			set { selection = value; }
		}
		
		/// <summary>
		/// Дали в момента диалога е в състояние на "влачене" на избрания елемент.
		/// </summary>
		private bool isDragging;
		public bool IsDragging {
			get { return isDragging; }
			set { isDragging = value; }
		}
		
		/// <summary>
		/// Последна позиция на мишката при "влачене".
		/// Използва се за определяне на вектора на транслация.
		/// </summary>
		private PointF lastLocation;

		public PointF LastLocation {
			get { return lastLocation; }
			set { lastLocation = value; }
		}
		
		#endregion
		
		/// <summary>
		/// Добавя примитив - правоъгълник на произволно място върху клиентската област.
		/// </summary>
		public void AddRandomRectangle()
		{
			Random rnd = new Random();
			int x = rnd.Next(100,1000);
			int y = rnd.Next(100,600);
			
			RectangleShape rect = new RectangleShape(new Rectangle(x,y,100,200));
			rect.FillColor = Color.White;
            rect.BorderColor = Color.Blue;
			ShapeList.Add(rect);
		}
        public void AddRandomLine()
        {
            Random rnd = new Random();
            int x = rnd.Next(100, 1000);
            int y = rnd.Next(100, 600);

            RectangleShape rect = new RectangleShape(new Rectangle(x, y, 100, 200));
            rect.FillColor = Color.White;
            rect.BorderColor = Color.Blue;
            ShapeList.Add(rect);
        }
		public void AddRandomElipse()
        {
            Random rnd = new Random();
            int x = rnd.Next(100, 1000);
            int y = rnd.Next(100, 600);

            ElipseShape elip = new ElipseShape(new Rectangle(x, y, 200, 100));
            elip.FillColor = Color.White;
            elip.BorderColor = Color.Blue;
            ShapeList.Add(elip);
			
        }
        public void AddRandomOval()
        {
            Random rnd = new Random();
            int x = rnd.Next(100, 1000);
            int y = rnd.Next(100, 600);

            ElipseShape elip = new ElipseShape(new Rectangle(x, y, 200, 200));
            elip.FillColor = Color.White;
            elip.BorderColor = Color.Blue;
            ShapeList.Add(elip);
        }


		/// <summary>
		/// Проверява дали дадена точка е в елемента.
		/// Обхожда в ред обратен на визуализацията с цел намиране на
		/// "най-горния" елемент т.е. този който виждаме под мишката.
		/// </summary>
		/// <param name="point">Указана точка</param>
		/// <returns>Елемента на изображението, на който принадлежи дадената точка.</returns>
		public Shape ContainsPoint(PointF point)
		{
			for(int i = ShapeList.Count - 1; i >= 0; i--){
				if (ShapeList[i].Contains(point)){

                    return ShapeList[i];
				}	
			}
			return null;
		}
		
		/// <summary>
		/// Транслация на избраният елемент на вектор определен от <paramref name="p>p</paramref>
		/// </summary>
		/// <param name="p">Вектор на транслация.</param>
		public void TranslateTo(PointF p)
		{
            foreach(var item in Selection)
			 {
                    item.Location = new PointF(item.Location.X + p.X - lastLocation.X, item.Location.Y + p.Y - lastLocation.Y);
				
			}
            lastLocation = p;
		}

        internal void SetFillColor(Color color)
        {
            foreach (var item in Selection)
            {
                item.FillColor = color;
            }
        }
        internal void SetBorderColor(Color color)
        {
            foreach (var item in Selection)
            {
                item.BorderColor = color;
            }
        }
        public override void Draw(Graphics grfx)
    {
        base.Draw(grfx);
            foreach (var item in Selection)
            {
                grfx.DrawRectangle(Pens.Black, item.Location.X -3, item.Location.Y -3, item.Width+6, item.Height+6);
            }
         }
       public void Ungroup()
        {

				Selection.Clear(); 
			
		}
        public void Group()
        {
            if (Selection.Count < 2)
                return;
            float minX =float.PositiveInfinity;
            float minY =float.PositiveInfinity;
            float maxX =float.NegativeInfinity;
            float maxY =float.NegativeInfinity;
            foreach (var item in Selection)
            {
                if (minX > item.Location.X) minX = item.Location.X;
                if (minY > item.Location.Y) minY = item.Location.Y;
                if (maxX < item.Location.X+item.Width) maxX = item.Location.X+item.Width;
				if (maxY < item.Location.Y + item.Height) maxY = item.Location.Y + item.Height;

			}
			var group = new GroupShape(new RectangleF(minX,minY,maxX-minX,maxY-minY));
            group.SubItems = Selection;
			Selection = new List<Shape>();
            Selection.Add(group);
            //foreach (var item in group.SubItems)
            //{
            //    ShapeList.Remove(item);
                
            //}
			

			//ShapeList.Add(group);
        }

 

		/*internal void SafeAs(object fileName)
		{
			throw new NotImplementedException();
		}*/

		internal void SelectAs(object fileName)
		{
			throw new NotImplementedException();
		}

		public void Delete()
        {
            foreach (var item in Selection)
            {
                ShapeList.Remove(item);
              
            }
             ShapeList.Clear();
            Selection.Clear();
        }

        public void SelectAll()
        {
            Selection = new List<Shape>(ShapeList);
        }

		public void SaveAs(string fileName)
		{
			FileStream fs = new FileStream(fileName, FileMode.Create);
			BinaryFormatter bf = new BinaryFormatter();
			bf.Serialize(fs, ShapeList);
			fs.Close();
		}
		internal void Copy()
		{
			ms = new MemoryStream();
			BinaryFormatter bf = new BinaryFormatter();
			bf.Serialize(ms, Selection);

			Clipboard.SetData("My Format", ms);
		}
		internal void Paste()
		{
			BinaryFormatter bf = new BinaryFormatter();
			ms.Position = 0;
			List<Shape> pastedShapeList = new List<Shape>();
			try
			{
				pastedShapeList = (List<Shape>)bf.Deserialize(ms);
				foreach (var item in pastedShapeList)
				{
					ShapeList.Add(item);
				}
				Clipboard.SetData("My Format", ms);
			}
			catch (IOException e)
			{
				MessageBox.Show("something happened");
			}
			catch (SerializationException e)
			{
				MessageBox.Show("copy something so you can paste it");
			}

		}
		internal void Cut()
		{
			ms = new MemoryStream();

			BinaryFormatter bf = new BinaryFormatter();
			List<Shape> cutShapes = new List<Shape>();
			foreach (var item in Selection.ToList())
			{
				if (ShapeList.Contains(item))
				{
					Selection.Clear();
					ShapeList.Remove(item);
					cutShapes.Add(item);
				}
			}
			bf.Serialize(ms, cutShapes);

			Clipboard.SetData("My Format", ms);
		}
		internal void ScaleUP()
		{
			foreach (var item in Selection)
			{
				item.Height = item.Height + 15;
				item.Width = item.Width + 15;

			}
		}

		internal void ScaleDOWN()
		{
			foreach (var item in Selection)
			{
				item.Height = item.Height - 15;
				item.Width = item.Width - 15;

			}
		}

		internal void Rorate()
		{
			foreach (var item in Selection)
			{
				var temp = item.Height;
				item.Height = item.Width;
				item.Width = temp;

			}
		}

		internal void Rorate2()
		{
			
			int[,] array = new int[4, 4] {
				{ 1,2,3,4 },
				{ 5,6,7,8 },
				{ 9,0,1,2 },
				{ 3,4,5,6 }
				};
			foreach (var item in Selection)
			{
				int[,] rotated = RotateMatrix(array, 4);

				int[,] RotateMatrix(int[,] matrix, int n)
				{
					int[,] ret = new int[n, n];

					for (int i = 0; i < n; ++i)
					{
						for (int j = 0; j < n; ++j)
						{
							ret[i, j] = matrix[n - j - 1, i];

						}
					}

					return ret;
				}
			}
		}
	}

   
}
