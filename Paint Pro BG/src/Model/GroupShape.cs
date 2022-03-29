using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms.VisualStyles;

namespace Draw
{
	[Serializable]
	public class GroupShape : Shape
    {
        #region Constructor

        public GroupShape(RectangleF rect) : base(rect)
        {
        }

        public GroupShape(RectangleShape rectangle) : base(rectangle)
        {
        }

        #endregion

        public List<Shape> SubItems { get; set; }

        public override Color FillColor
        {
            set
            {
                foreach (var item in SubItems)
                {
                    item.FillColor = value;
                }
            }
        }

        public override Color BorderColor
        {
            set
            {
                foreach (var item in SubItems)
                {
                    item.BorderColor = value;
                }
            }
        }

        public override PointF Location
        {
            set
            {
                float dx = value.X - Location.X;
                float dy = value.Y - Location.Y;
                foreach (var item in SubItems)
                {
                    item.Location=new PointF(item.Location.X+dx,item.Location.Y+dy);
                }

                base.Location = value;
            }
        }
        public override bool Contains(PointF point)
        {
            if (base.Contains(point))
            {
                foreach (var item in SubItems)
                {
                    if (item.Contains(point))
                        return true;
                }

                return false;
            }
            else
                return false;
        }

        public override void DrawSelf(Graphics grfx)
        {
            base.DrawSelf(grfx);
            foreach (var item in SubItems)
            {
                item.DrawSelf(grfx);
            }
        }
    }
}