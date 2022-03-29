using System;
using System.Drawing;

namespace Draw
{
	[Serializable]
	public class ElipseShape : Shape
    {
        #region Constructor

        public ElipseShape(RectangleF elip) : base(elip)
        {
        }

        public ElipseShape(RectangleShape elipse) : base(elipse)
        {
        }

        #endregion
        public override bool Contains(PointF point)
        {
            if (base.Contains(point))

                return true;
            else

                return false;
        }


        public override void DrawSelf(Graphics grfx)
        {
            base.DrawSelf(grfx);

            grfx.FillEllipse(new SolidBrush(FillColor), Rectangle.X, Rectangle.Y, Rectangle.Width, Rectangle.Height);
            grfx.DrawEllipse(new Pen(BorderColor), Rectangle.X, Rectangle.Y, Rectangle.Width, Rectangle.Height);
        }
    }
}