using Draw.src.Processors;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Windows.Forms;
using System.Windows.Media.Media3D;

namespace Draw
{
	/// <summary>
	/// Върху главната форма е поставен потребителски контрол,
	/// в който се осъществява визуализацията
	/// </summary>
	public partial class MainForm : Form
	{
		/// <summary>
		/// Агрегирания диалогов процесор във формата улеснява манипулацията на модела.
		/// </summary>
		private DialogProcessor dialogProcessor = new DialogProcessor();
        private GeometricProcessor geometricProcessor = new GeometricProcessor();
		private Bitmap bm;
		private Image Files;

		public MainForm()
		{
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}

		/// <summary>
		/// Изход от програмата. Затваря главната форма, а с това и програмата.
		/// </summary>
		void ExitToolStripMenuItemClick(object sender, EventArgs e)
		{
			Close();
		}
		
		/// <summary>
		/// Събитието, което се прихваща, за да се превизуализира при изменение на модела.
		/// </summary>
		void ViewPortPaint(object sender, PaintEventArgs e)
		{
			dialogProcessor.ReDraw(sender, e);
		}
		
		/// <summary>
		/// Бутон, който поставя на произволно място правоъгълник със зададените размери.
		/// Променя се лентата със състоянието и се инвалидира контрола, в който визуализираме.
		/// </summary>
		void DrawRectangleSpeedButtonClick(object sender, EventArgs e)
		{
			dialogProcessor.AddRandomRectangle();
			
			statusBar.Items[0].Text = "Последно действие: Рисуване на правоъгълник";
			
			viewPort.Invalidate();
		}

		/// <summary>
		/// Прихващане на координатите при натискането на бутон на мишката и проверка (в обратен ред) дали не е
		/// щракнато върху елемент. Ако е така то той се отбелязва като селектиран и започва процес на "влачене".
		/// Промяна на статуса и инвалидиране на контрола, в който визуализираме.
		/// Реализацията се диалогът с потребителя, при който се избира "най-горния" елемент от екрана.
		/// </summary>
		void ViewPortMouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			if (pickUpSpeedButton.Checked) {
				
                var sel = dialogProcessor.ContainsPoint(e.Location);
                if (sel == null) return;
                if (dialogProcessor.Selection.Contains(sel))
                {
                    dialogProcessor.Selection.Remove(sel);
                }
                else
                {
                    dialogProcessor.Selection.Add(sel);
                }
					statusBar.Items[0].Text = "Последно действие: Селекция на примитив";
					dialogProcessor.IsDragging = true;
					dialogProcessor.LastLocation = e.Location;
					viewPort.Invalidate();
				
			}
		}

		/// <summary>
		/// Прихващане на преместването на мишката.
		/// Ако сме в режм на "влачене", то избрания елемент се транслира.
		/// </summary>
		void ViewPortMouseMove(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			if (dialogProcessor.IsDragging) {
				if (dialogProcessor.Selection != null) statusBar.Items[0].Text = "Последно действие: Преместване";
				dialogProcessor.TranslateTo(e.Location);
				viewPort.Invalidate();
				
			}
		}

		/// <summary>
		/// Прихващане на отпускането на бутона на мишката.
		/// Излизаме от режим "влачене".
		/// </summary>
		void ViewPortMouseUp(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			dialogProcessor.IsDragging = false;
		}

        private void fillColorButton_Click(object sender, EventArgs e)
        {
            if(colorDialog1.ShowDialog() == DialogResult.OK)
            {
                dialogProcessor.SetFillColor(colorDialog1.Color);
				statusBar.Items[0].Text = "Последно действие: Запълване с цвят";
				viewPort.Invalidate();
            }
        }

		private void addElipse_Click(object sender, EventArgs e)
		{
            dialogProcessor.AddRandomElipse();

            statusBar.Items[0].Text = "Последно действие: Рисуване на елипса";

            viewPort.Invalidate();
		}

		private void speedMenu_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
		{

		}

		private void addOvalButton_Click(object sender, EventArgs e)
		{
            dialogProcessor.AddRandomOval();

            statusBar.Items[0].Text = "Последно действие: Рисуване на кръг";

            viewPort.Invalidate();
        }

		private void borderColorButton_Click(object sender, EventArgs e)
		{
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                dialogProcessor.SetBorderColor(colorDialog1.Color);
				statusBar.Items[0].Text = "Последно действие: Промяна на цвета на обвивката";
				viewPort.Invalidate();
            }
		}

		private void pickUpSpeedButton_Click(object sender, EventArgs e)
		{

		}

		private void groupButton_Click(object sender, EventArgs e)
        {
            dialogProcessor.Group();
			statusBar.Items[0].Text = "Последно действие: Групиране на елементи";
			viewPort.Invalidate();
        }

		private void unGroupButton_Click(object sender, EventArgs e)
		{

			dialogProcessor.Ungroup();
			statusBar.Items[0].Text = "Последно действие: Премахване на селекцията";
			viewPort.Invalidate();


		}

		private void viewPort_Load(object sender, EventArgs e)
		{

		}

        private void RectangleToolStripMenuItem_Click(object sender, EventArgs e)
        {
            dialogProcessor.AddRandomRectangle();

            statusBar.Items[0].Text = "Последно действие: Рисуване на правоъгълник";

            viewPort.Invalidate();
        }

        private void DeleteButton_Click(object sender, EventArgs e)
        {
            dialogProcessor.Delete();
			statusBar.Items[0].Text = "Последно действие: Изтриване на всичко";
			viewPort.Invalidate();
        }

        private void SelectAllButton_Click(object sender, EventArgs e)
        {
            dialogProcessor.SelectAll();
			statusBar.Items[0].Text = "Последно действие: Селекция на всички елементи";
			viewPort.Invalidate();
        }

		private void safeAsToolStripMenuItem_Click(object sender, EventArgs e)
		{
			Bitmap bm = new Bitmap(viewPort.Width, viewPort.Height);
			Graphics graph = Graphics.FromImage(bm);
			Rectangle rect = viewPort.RectangleToScreen(viewPort.ClientRectangle);
			graph.CopyFromScreen(rect.Location, Point.Empty, viewPort.Size);
			viewPort.Dispose();


			//saveFileDialog1.Filter = "jpeg files| *jpeg|Png files| *.png|  bitmaps| *bmp";
			saveFileDialog1.Filter = "JPG(*.JPG)|*.jpg| PNG(*.PNG)|*.png | BMP(*.BMP)|*.bmp";

			if (saveFileDialog1.ShowDialog() == DialogResult.OK)
			{
				try
				{
					if (File.Exists(saveFileDialog1.FileName))
					{
						File.Delete(saveFileDialog1.FileName);
					}
					if (saveFileDialog1.FileName.Contains(".jpg"))
					{
						bm.Save(saveFileDialog1.FileName, ImageFormat.Jpeg);
					}
					else if (saveFileDialog1.FileName.Contains(".png"))
					{
						bm.Save(saveFileDialog1.FileName, ImageFormat.Png);
					}
					else if (saveFileDialog1.FileName.Contains(".bmp"))
					{
						bm.Save(saveFileDialog1.FileName, ImageFormat.Bmp);
					}
				}
				catch (Exception ex)
				{
					MessageBox.Show("File save error : " + ex.Message);
				}
			}
		}

		private void saveFileDialog1_FileOk(object sender, System.ComponentModel.CancelEventArgs e)
		{

		}
		private void openToolStripMenuItem_Click(object sender, EventArgs e)
		{
			//OpenFileDialog open = new OpenFileDialog();
			openFileDialog1.Filter = "Png files| *.png| jpeg files| *jpg| bitmaps| *bmp";
			if (openFileDialog1.ShowDialog() == DialogResult.OK)
			{
				try
				{
					Files = Image.FromFile(openFileDialog1.FileName);
					viewPort.BackgroundImage = Files;
				}
				catch (Exception ex)
				{
					MessageBox.Show("Error loading image " + ex.Message);
				}

			}
		}
		private void fileToolStripMenuItem_Click(object sender, EventArgs e)
		{

		}

		private void MainForm_Load(object sender, EventArgs e)
		{

		}

		private void copyToolStripMenuItem_Click(object sender, EventArgs e)
		{
			dialogProcessor.Copy();
			viewPort.Invalidate();
		}

		private void cutToolStripMenuItem_Click(object sender, EventArgs e)
		{
			dialogProcessor.Cut();
			viewPort.Invalidate();
		}

		private void pasteToolStripMenuItem_Click(object sender, EventArgs e)
		{
			dialogProcessor.Paste();
			viewPort.Invalidate();
		}

		private void scaleUpToolStripMenuItem_Click(object sender, EventArgs e)
		{
			dialogProcessor.ScaleUP();
			statusBar.Items[0].Text = "Последно действие: Смаляване ";
			viewPort.Invalidate();
		}

		private void scaleDownToolStripMenuItem_Click(object sender, EventArgs e)
		{
			dialogProcessor.ScaleDOWN();
			statusBar.Items[0].Text = "Последно действие: Увеличаване ";
			viewPort.Invalidate();
		}

		private void selectorToolStripMenuItem_Click(object sender, EventArgs e)
		{
			pickUpSpeedButton.PerformClick();
		}

		private void RotationButton_Click(object sender, EventArgs e)
		{
			dialogProcessor.Rorate();
			statusBar.Items[0].Text = "Последно действие: Ротация";
			viewPort.Invalidate();
		}


		private void imageToolStripMenuItem_Click(object sender, EventArgs e)
		{

		}

		private void rotateToolStripMenuItem_Click(object sender, EventArgs e)
		{
			dialogProcessor.Rorate();
			statusBar.Items[0].Text = "Последно действие: Ротация";
			viewPort.Invalidate();
		}

		private void rotationButton2_Click(object sender, EventArgs e)
		{
			dialogProcessor.Rorate2();
			
			viewPort.Invalidate();
		}

		private void ungroupItemsToolStripMenuItem_Click(object sender, EventArgs e)
		{
			dialogProcessor.Ungroup();
			statusBar.Items[0].Text = "Последно действие: Премахване на селекцията";
			viewPort.Invalidate();
		}
	}
}

