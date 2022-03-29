

namespace Draw
{
	partial class MainForm
	{
		/// <summary>
		/// Designer variable used to keep track of non-visual components.
		/// </summary>
		private System.ComponentModel.IContainer components = null;
		
		/// <summary>
		/// Disposes resources used by the form.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing) {
				if (components != null) {
					components.Dispose();
				}
			}
			base.Dispose(disposing);
		}
		
		/// <summary>
		/// This method is required for Windows Forms designer support.
		/// Do not change the method contents inside the source code editor. The Forms designer might
		/// not be able to load this method if it was changed manually.
		/// </summary>
		private void InitializeComponent()
		{
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
			this.mainMenu = new System.Windows.Forms.MenuStrip();
			this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.safeAsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.openToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.editToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.cutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.copyToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.pasteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.deleteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.selectAllToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.groupItemsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.ungroupItemsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.selectorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.imageToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.newToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
			this.rectangleToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.eclipseToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.ovalToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.transformToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.rotateToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.adjusmentsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.fillColorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.borderColorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.scaleUpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.scaleDownToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.helpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.aboutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.statusBar = new System.Windows.Forms.StatusStrip();
			this.currentStatusLabel = new System.Windows.Forms.ToolStripStatusLabel();
			this.speedMenu = new System.Windows.Forms.ToolStrip();
			this.drawRectangleSpeedButton = new System.Windows.Forms.ToolStripButton();
			this.drawOvalButton = new System.Windows.Forms.ToolStripButton();
			this.drawElipseButton = new System.Windows.Forms.ToolStripButton();
			this.pickUpSpeedButton = new System.Windows.Forms.ToolStripButton();
			this.fillColorButton = new System.Windows.Forms.ToolStripButton();
			this.borderColorButton = new System.Windows.Forms.ToolStripButton();
			this.groupButton = new System.Windows.Forms.ToolStripButton();
			this.ungroupButton = new System.Windows.Forms.ToolStripButton();
			this.deleteButton = new System.Windows.Forms.ToolStripButton();
			this.selectAllButton = new System.Windows.Forms.ToolStripButton();
			this.RotateButton = new System.Windows.Forms.ToolStripButton();
			this.toolStripButton3 = new System.Windows.Forms.ToolStripButton();
			this.colorDialog1 = new System.Windows.Forms.ColorDialog();
			this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
			this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
			this.viewPort = new Draw.DoubleBufferedPanel();
			this.mainMenu.SuspendLayout();
			this.statusBar.SuspendLayout();
			this.speedMenu.SuspendLayout();
			this.SuspendLayout();
			// 
			// mainMenu
			// 
			this.mainMenu.GripMargin = new System.Windows.Forms.Padding(2, 2, 0, 2);
			this.mainMenu.ImageScalingSize = new System.Drawing.Size(40, 40);
			this.mainMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.editToolStripMenuItem,
            this.imageToolStripMenuItem,
            this.helpToolStripMenuItem});
			this.mainMenu.Location = new System.Drawing.Point(0, 0);
			this.mainMenu.Name = "mainMenu";
			this.mainMenu.Padding = new System.Windows.Forms.Padding(16, 5, 0, 5);
			this.mainMenu.Size = new System.Drawing.Size(1925, 60);
			this.mainMenu.TabIndex = 1;
			this.mainMenu.Text = "menuStrip1";
			// 
			// fileToolStripMenuItem
			// 
			this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.exitToolStripMenuItem,
            this.safeAsToolStripMenuItem,
            this.openToolStripMenuItem});
			this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
			this.fileToolStripMenuItem.Size = new System.Drawing.Size(87, 50);
			this.fileToolStripMenuItem.Text = "File";
			this.fileToolStripMenuItem.Click += new System.EventHandler(this.fileToolStripMenuItem_Click);
			// 
			// exitToolStripMenuItem
			// 
			this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
			this.exitToolStripMenuItem.Size = new System.Drawing.Size(382, 54);
			this.exitToolStripMenuItem.Text = "Exit";
			this.exitToolStripMenuItem.Click += new System.EventHandler(this.ExitToolStripMenuItemClick);
			// 
			// safeAsToolStripMenuItem
			// 
			this.safeAsToolStripMenuItem.Name = "safeAsToolStripMenuItem";
			this.safeAsToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.S)));
			this.safeAsToolStripMenuItem.Size = new System.Drawing.Size(382, 54);
			this.safeAsToolStripMenuItem.Text = "Save as";
			this.safeAsToolStripMenuItem.Click += new System.EventHandler(this.safeAsToolStripMenuItem_Click);
			// 
			// openToolStripMenuItem
			// 
			this.openToolStripMenuItem.Name = "openToolStripMenuItem";
			this.openToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.O)));
			this.openToolStripMenuItem.Size = new System.Drawing.Size(382, 54);
			this.openToolStripMenuItem.Text = "Open";
			this.openToolStripMenuItem.Click += new System.EventHandler(this.openToolStripMenuItem_Click);
			// 
			// editToolStripMenuItem
			// 
			this.editToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.cutToolStripMenuItem,
            this.copyToolStripMenuItem,
            this.pasteToolStripMenuItem,
            this.deleteToolStripMenuItem,
            this.selectAllToolStripMenuItem,
            this.groupItemsToolStripMenuItem,
            this.ungroupItemsToolStripMenuItem,
            this.selectorToolStripMenuItem});
			this.editToolStripMenuItem.Name = "editToolStripMenuItem";
			this.editToolStripMenuItem.Size = new System.Drawing.Size(92, 50);
			this.editToolStripMenuItem.Text = "Edit";
			// 
			// cutToolStripMenuItem
			// 
			this.cutToolStripMenuItem.Name = "cutToolStripMenuItem";
			this.cutToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.X)));
			this.cutToolStripMenuItem.Size = new System.Drawing.Size(486, 54);
			this.cutToolStripMenuItem.Text = "Cut";
			this.cutToolStripMenuItem.Click += new System.EventHandler(this.cutToolStripMenuItem_Click);
			// 
			// copyToolStripMenuItem
			// 
			this.copyToolStripMenuItem.Name = "copyToolStripMenuItem";
			this.copyToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.C)));
			this.copyToolStripMenuItem.Size = new System.Drawing.Size(486, 54);
			this.copyToolStripMenuItem.Text = "Copy";
			this.copyToolStripMenuItem.Click += new System.EventHandler(this.copyToolStripMenuItem_Click);
			// 
			// pasteToolStripMenuItem
			// 
			this.pasteToolStripMenuItem.Name = "pasteToolStripMenuItem";
			this.pasteToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.V)));
			this.pasteToolStripMenuItem.Size = new System.Drawing.Size(486, 54);
			this.pasteToolStripMenuItem.Text = "Paste";
			this.pasteToolStripMenuItem.Click += new System.EventHandler(this.pasteToolStripMenuItem_Click);
			// 
			// deleteToolStripMenuItem
			// 
			this.deleteToolStripMenuItem.Name = "deleteToolStripMenuItem";
			this.deleteToolStripMenuItem.ShortcutKeys = System.Windows.Forms.Keys.Delete;
			this.deleteToolStripMenuItem.Size = new System.Drawing.Size(486, 54);
			this.deleteToolStripMenuItem.Text = "Delete";
			this.deleteToolStripMenuItem.Click += new System.EventHandler(this.DeleteButton_Click);
			// 
			// selectAllToolStripMenuItem
			// 
			this.selectAllToolStripMenuItem.Name = "selectAllToolStripMenuItem";
			this.selectAllToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.A)));
			this.selectAllToolStripMenuItem.Size = new System.Drawing.Size(486, 54);
			this.selectAllToolStripMenuItem.Text = "Select All";
			this.selectAllToolStripMenuItem.Click += new System.EventHandler(this.SelectAllButton_Click);
			// 
			// groupItemsToolStripMenuItem
			// 
			this.groupItemsToolStripMenuItem.Name = "groupItemsToolStripMenuItem";
			this.groupItemsToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.G)));
			this.groupItemsToolStripMenuItem.Size = new System.Drawing.Size(486, 54);
			this.groupItemsToolStripMenuItem.Text = "Group Items";
			this.groupItemsToolStripMenuItem.Click += new System.EventHandler(this.groupButton_Click);
			// 
			// ungroupItemsToolStripMenuItem
			// 
			this.ungroupItemsToolStripMenuItem.Name = "ungroupItemsToolStripMenuItem";
			this.ungroupItemsToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.Y)));
			this.ungroupItemsToolStripMenuItem.Size = new System.Drawing.Size(486, 54);
			this.ungroupItemsToolStripMenuItem.Text = "Ungroup Items";
			this.ungroupItemsToolStripMenuItem.Click += new System.EventHandler(this.ungroupItemsToolStripMenuItem_Click);
			// 
			// selectorToolStripMenuItem
			// 
			this.selectorToolStripMenuItem.Name = "selectorToolStripMenuItem";
			this.selectorToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.D1)));
			this.selectorToolStripMenuItem.Size = new System.Drawing.Size(486, 54);
			this.selectorToolStripMenuItem.Text = "Selector";
			this.selectorToolStripMenuItem.Click += new System.EventHandler(this.selectorToolStripMenuItem_Click);
			// 
			// imageToolStripMenuItem
			// 
			this.imageToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newToolStripMenuItem1,
            this.transformToolStripMenuItem,
            this.adjusmentsToolStripMenuItem});
			this.imageToolStripMenuItem.Name = "imageToolStripMenuItem";
			this.imageToolStripMenuItem.Size = new System.Drawing.Size(125, 50);
			this.imageToolStripMenuItem.Text = "Image";
			this.imageToolStripMenuItem.Click += new System.EventHandler(this.imageToolStripMenuItem_Click);
			// 
			// newToolStripMenuItem1
			// 
			this.newToolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.rectangleToolStripMenuItem,
            this.eclipseToolStripMenuItem,
            this.ovalToolStripMenuItem});
			this.newToolStripMenuItem1.Name = "newToolStripMenuItem1";
			this.newToolStripMenuItem1.Size = new System.Drawing.Size(448, 54);
			this.newToolStripMenuItem1.Text = "New";
			// 
			// rectangleToolStripMenuItem
			// 
			this.rectangleToolStripMenuItem.Name = "rectangleToolStripMenuItem";
			this.rectangleToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.R)));
			this.rectangleToolStripMenuItem.Size = new System.Drawing.Size(417, 54);
			this.rectangleToolStripMenuItem.Text = "Rectangle";
			this.rectangleToolStripMenuItem.Click += new System.EventHandler(this.RectangleToolStripMenuItem_Click);
			// 
			// eclipseToolStripMenuItem
			// 
			this.eclipseToolStripMenuItem.Name = "eclipseToolStripMenuItem";
			this.eclipseToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.E)));
			this.eclipseToolStripMenuItem.Size = new System.Drawing.Size(417, 54);
			this.eclipseToolStripMenuItem.Text = "Eclipse";
			this.eclipseToolStripMenuItem.Click += new System.EventHandler(this.addElipse_Click);
			// 
			// ovalToolStripMenuItem
			// 
			this.ovalToolStripMenuItem.Name = "ovalToolStripMenuItem";
			this.ovalToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.W)));
			this.ovalToolStripMenuItem.Size = new System.Drawing.Size(417, 54);
			this.ovalToolStripMenuItem.Text = "Circle";
			this.ovalToolStripMenuItem.Click += new System.EventHandler(this.addOvalButton_Click);
			// 
			// transformToolStripMenuItem
			// 
			this.transformToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.rotateToolStripMenuItem});
			this.transformToolStripMenuItem.Name = "transformToolStripMenuItem";
			this.transformToolStripMenuItem.Size = new System.Drawing.Size(448, 54);
			this.transformToolStripMenuItem.Text = "Transform";
			// 
			// rotateToolStripMenuItem
			// 
			this.rotateToolStripMenuItem.Name = "rotateToolStripMenuItem";
			this.rotateToolStripMenuItem.ShortcutKeyDisplayString = "";
			this.rotateToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.R)));
			this.rotateToolStripMenuItem.Size = new System.Drawing.Size(448, 54);
			this.rotateToolStripMenuItem.Text = "Rotate";
			this.rotateToolStripMenuItem.Click += new System.EventHandler(this.rotateToolStripMenuItem_Click);
			// 
			// adjusmentsToolStripMenuItem
			// 
			this.adjusmentsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fillColorToolStripMenuItem,
            this.borderColorToolStripMenuItem,
            this.scaleUpToolStripMenuItem,
            this.scaleDownToolStripMenuItem});
			this.adjusmentsToolStripMenuItem.Name = "adjusmentsToolStripMenuItem";
			this.adjusmentsToolStripMenuItem.Size = new System.Drawing.Size(448, 54);
			this.adjusmentsToolStripMenuItem.Text = "Adjusments";
			// 
			// fillColorToolStripMenuItem
			// 
			this.fillColorToolStripMenuItem.Name = "fillColorToolStripMenuItem";
			this.fillColorToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.F)));
			this.fillColorToolStripMenuItem.Size = new System.Drawing.Size(445, 54);
			this.fillColorToolStripMenuItem.Text = "Fill Color";
			this.fillColorToolStripMenuItem.Click += new System.EventHandler(this.fillColorButton_Click);
			// 
			// borderColorToolStripMenuItem
			// 
			this.borderColorToolStripMenuItem.Name = "borderColorToolStripMenuItem";
			this.borderColorToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.B)));
			this.borderColorToolStripMenuItem.Size = new System.Drawing.Size(445, 54);
			this.borderColorToolStripMenuItem.Text = "Border Color";
			this.borderColorToolStripMenuItem.Click += new System.EventHandler(this.borderColorButton_Click);
			// 
			// scaleUpToolStripMenuItem
			// 
			this.scaleUpToolStripMenuItem.Name = "scaleUpToolStripMenuItem";
			this.scaleUpToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.D9)));
			this.scaleUpToolStripMenuItem.Size = new System.Drawing.Size(445, 54);
			this.scaleUpToolStripMenuItem.Text = "Scale Up";
			this.scaleUpToolStripMenuItem.Click += new System.EventHandler(this.scaleUpToolStripMenuItem_Click);
			// 
			// scaleDownToolStripMenuItem
			// 
			this.scaleDownToolStripMenuItem.Name = "scaleDownToolStripMenuItem";
			this.scaleDownToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.D0)));
			this.scaleDownToolStripMenuItem.Size = new System.Drawing.Size(445, 54);
			this.scaleDownToolStripMenuItem.Text = "Scale Down";
			this.scaleDownToolStripMenuItem.Click += new System.EventHandler(this.scaleDownToolStripMenuItem_Click);
			// 
			// helpToolStripMenuItem
			// 
			this.helpToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.aboutToolStripMenuItem});
			this.helpToolStripMenuItem.Name = "helpToolStripMenuItem";
			this.helpToolStripMenuItem.Size = new System.Drawing.Size(104, 50);
			this.helpToolStripMenuItem.Text = "Help";
			// 
			// aboutToolStripMenuItem
			// 
			this.aboutToolStripMenuItem.Name = "aboutToolStripMenuItem";
			this.aboutToolStripMenuItem.Size = new System.Drawing.Size(287, 54);
			this.aboutToolStripMenuItem.Text = "About...";
			// 
			// statusBar
			// 
			this.statusBar.ImageScalingSize = new System.Drawing.Size(40, 40);
			this.statusBar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.currentStatusLabel});
			this.statusBar.Location = new System.Drawing.Point(0, 1032);
			this.statusBar.Name = "statusBar";
			this.statusBar.Padding = new System.Windows.Forms.Padding(3, 0, 37, 0);
			this.statusBar.Size = new System.Drawing.Size(1925, 22);
			this.statusBar.TabIndex = 2;
			this.statusBar.Text = "statusStrip1";
			// 
			// currentStatusLabel
			// 
			this.currentStatusLabel.Name = "currentStatusLabel";
			this.currentStatusLabel.Size = new System.Drawing.Size(0, 9);
			// 
			// speedMenu
			// 
			this.speedMenu.BackColor = System.Drawing.SystemColors.ActiveCaption;
			this.speedMenu.Dock = System.Windows.Forms.DockStyle.Bottom;
			this.speedMenu.ImageScalingSize = new System.Drawing.Size(40, 40);
			this.speedMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.drawRectangleSpeedButton,
            this.drawOvalButton,
            this.drawElipseButton,
            this.pickUpSpeedButton,
            this.fillColorButton,
            this.borderColorButton,
            this.groupButton,
            this.ungroupButton,
            this.deleteButton,
            this.selectAllButton,
            this.RotateButton,
            this.toolStripButton3});
			this.speedMenu.Location = new System.Drawing.Point(0, 970);
			this.speedMenu.Name = "speedMenu";
			this.speedMenu.Padding = new System.Windows.Forms.Padding(0, 0, 5, 0);
			this.speedMenu.Size = new System.Drawing.Size(1925, 62);
			this.speedMenu.TabIndex = 3;
			this.speedMenu.Text = "Rotate";
			this.speedMenu.ItemClicked += new System.Windows.Forms.ToolStripItemClickedEventHandler(this.speedMenu_ItemClicked);
			// 
			// drawRectangleSpeedButton
			// 
			this.drawRectangleSpeedButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.drawRectangleSpeedButton.Image = global::Draw.Properties.Resources.geometric_figure;
			this.drawRectangleSpeedButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.drawRectangleSpeedButton.Name = "drawRectangleSpeedButton";
			this.drawRectangleSpeedButton.Size = new System.Drawing.Size(58, 55);
			this.drawRectangleSpeedButton.Text = "Draw Rectangle";
			this.drawRectangleSpeedButton.Click += new System.EventHandler(this.DrawRectangleSpeedButtonClick);
			// 
			// drawOvalButton
			// 
			this.drawOvalButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.drawOvalButton.Image = global::Draw.Properties.Resources.circle;
			this.drawOvalButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.drawOvalButton.Name = "drawOvalButton";
			this.drawOvalButton.Size = new System.Drawing.Size(58, 55);
			this.drawOvalButton.Text = "Draw Oval";
			this.drawOvalButton.Click += new System.EventHandler(this.addOvalButton_Click);
			// 
			// drawElipseButton
			// 
			this.drawElipseButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.drawElipseButton.Image = global::Draw.Properties.Resources.oval__1_;
			this.drawElipseButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.drawElipseButton.Name = "drawElipseButton";
			this.drawElipseButton.Size = new System.Drawing.Size(58, 55);
			this.drawElipseButton.Text = "Draw Elipse";
			this.drawElipseButton.Click += new System.EventHandler(this.addElipse_Click);
			// 
			// pickUpSpeedButton
			// 
			this.pickUpSpeedButton.CheckOnClick = true;
			this.pickUpSpeedButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.pickUpSpeedButton.Image = global::Draw.Properties.Resources.click;
			this.pickUpSpeedButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.pickUpSpeedButton.Name = "pickUpSpeedButton";
			this.pickUpSpeedButton.Size = new System.Drawing.Size(58, 55);
			this.pickUpSpeedButton.Text = "Select";
			this.pickUpSpeedButton.Click += new System.EventHandler(this.pickUpSpeedButton_Click);
			// 
			// fillColorButton
			// 
			this.fillColorButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.fillColorButton.Image = global::Draw.Properties.Resources.bucket;
			this.fillColorButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.fillColorButton.Name = "fillColorButton";
			this.fillColorButton.Size = new System.Drawing.Size(58, 55);
			this.fillColorButton.Text = "Fill Color";
			this.fillColorButton.Click += new System.EventHandler(this.fillColorButton_Click);
			// 
			// borderColorButton
			// 
			this.borderColorButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.borderColorButton.Image = global::Draw.Properties.Resources.pantone;
			this.borderColorButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.borderColorButton.Name = "borderColorButton";
			this.borderColorButton.Size = new System.Drawing.Size(58, 55);
			this.borderColorButton.Text = "Fill Border Color";
			this.borderColorButton.Click += new System.EventHandler(this.borderColorButton_Click);
			// 
			// groupButton
			// 
			this.groupButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.groupButton.Image = global::Draw.Properties.Resources.geometric_shapes_group_with_down_arrow;
			this.groupButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.groupButton.Name = "groupButton";
			this.groupButton.Size = new System.Drawing.Size(58, 55);
			this.groupButton.Text = "Group Items";
			this.groupButton.Click += new System.EventHandler(this.groupButton_Click);
			// 
			// ungroupButton
			// 
			this.ungroupButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.ungroupButton.Image = global::Draw.Properties.Resources._1112715_2001;
			this.ungroupButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.ungroupButton.Name = "ungroupButton";
			this.ungroupButton.Size = new System.Drawing.Size(58, 44);
			this.ungroupButton.Text = "Ungroup";
			this.ungroupButton.Click += new System.EventHandler(this.unGroupButton_Click);
			// 
			// deleteButton
			// 
			this.deleteButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.deleteButton.Image = global::Draw.Properties.Resources._627249_delete3_512;
			this.deleteButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.deleteButton.Name = "deleteButton";
			this.deleteButton.Size = new System.Drawing.Size(58, 55);
			this.deleteButton.Text = "toolStripButton3";
			this.deleteButton.ToolTipText = "Delete a figure";
			this.deleteButton.Click += new System.EventHandler(this.DeleteButton_Click);
			// 
			// selectAllButton
			// 
			this.selectAllButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.selectAllButton.Image = global::Draw.Properties.Resources.icons8_select_all_64;
			this.selectAllButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.selectAllButton.Name = "selectAllButton";
			this.selectAllButton.Size = new System.Drawing.Size(58, 55);
			this.selectAllButton.Text = "toolStripButton4";
			this.selectAllButton.ToolTipText = "Select All";
			this.selectAllButton.Click += new System.EventHandler(this.SelectAllButton_Click);
			// 
			// RotateButton
			// 
			this.RotateButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.RotateButton.Image = ((System.Drawing.Image)(resources.GetObject("RotateButton.Image")));
			this.RotateButton.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.RotateButton.Name = "RotateButton";
			this.RotateButton.Size = new System.Drawing.Size(58, 55);
			this.RotateButton.Text = "Rotation";
			this.RotateButton.Click += new System.EventHandler(this.RotationButton_Click);
			// 
			// toolStripButton3
			// 
			this.toolStripButton3.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
			this.toolStripButton3.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButton3.Image")));
			this.toolStripButton3.ImageTransparentColor = System.Drawing.Color.Magenta;
			this.toolStripButton3.Name = "toolStripButton3";
			this.toolStripButton3.Size = new System.Drawing.Size(58, 55);
			this.toolStripButton3.Text = "toolStripButton3";
			this.toolStripButton3.Click += new System.EventHandler(this.rotationButton2_Click);
			// 
			// saveFileDialog1
			// 
			this.saveFileDialog1.FileOk += new System.ComponentModel.CancelEventHandler(this.saveFileDialog1_FileOk);
			// 
			// openFileDialog1
			// 
			this.openFileDialog1.FileName = "openFileDialog1";
			// 
			// viewPort
			// 
			this.viewPort.Dock = System.Windows.Forms.DockStyle.Fill;
			this.viewPort.Location = new System.Drawing.Point(0, 60);
			this.viewPort.Margin = new System.Windows.Forms.Padding(21, 17, 21, 17);
			this.viewPort.Name = "viewPort";
			this.viewPort.Size = new System.Drawing.Size(1925, 910);
			this.viewPort.TabIndex = 4;
			this.viewPort.Load += new System.EventHandler(this.viewPort_Load);
			this.viewPort.Paint += new System.Windows.Forms.PaintEventHandler(this.ViewPortPaint);
			this.viewPort.MouseDown += new System.Windows.Forms.MouseEventHandler(this.ViewPortMouseDown);
			this.viewPort.MouseMove += new System.Windows.Forms.MouseEventHandler(this.ViewPortMouseMove);
			this.viewPort.MouseUp += new System.Windows.Forms.MouseEventHandler(this.ViewPortMouseUp);
			// 
			// MainForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(1925, 1054);
			this.Controls.Add(this.viewPort);
			this.Controls.Add(this.speedMenu);
			this.Controls.Add(this.statusBar);
			this.Controls.Add(this.mainMenu);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MainMenuStrip = this.mainMenu;
			this.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.Name = "MainForm";
			this.Text = "Draw";
			this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
			this.Load += new System.EventHandler(this.MainForm_Load);
			this.mainMenu.ResumeLayout(false);
			this.mainMenu.PerformLayout();
			this.statusBar.ResumeLayout(false);
			this.statusBar.PerformLayout();
			this.speedMenu.ResumeLayout(false);
			this.speedMenu.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

		}
		
		private System.Windows.Forms.ToolStripStatusLabel currentStatusLabel;
		private Draw.DoubleBufferedPanel viewPort;
		private System.Windows.Forms.ToolStripButton pickUpSpeedButton;
		private System.Windows.Forms.ToolStripButton drawRectangleSpeedButton;
		private System.Windows.Forms.ToolStripMenuItem aboutToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem helpToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem imageToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem editToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
		private System.Windows.Forms.ToolStrip speedMenu;
		private System.Windows.Forms.StatusStrip statusBar;
		private System.Windows.Forms.MenuStrip mainMenu;
        private System.Windows.Forms.ToolStripButton fillColorButton;
        private System.Windows.Forms.ColorDialog colorDialog1;
        private System.Windows.Forms.ToolStripButton drawElipseButton;
        private System.Windows.Forms.ToolStripButton borderColorButton;
        private System.Windows.Forms.ToolStripButton drawOvalButton;
        private System.Windows.Forms.ToolStripButton groupButton;
        private System.Windows.Forms.ToolStripButton ungroupButton;
        private System.Windows.Forms.ToolStripMenuItem newToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem rectangleToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem eclipseToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ovalToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem transformToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem rotateToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem deleteToolStripMenuItem;
        private System.Windows.Forms.ToolStripButton deleteButton;
        private System.Windows.Forms.ToolStripMenuItem selectAllToolStripMenuItem;
        private System.Windows.Forms.ToolStripButton selectAllButton;
        private System.Windows.Forms.ToolStripMenuItem adjusmentsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem fillColorToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem borderColorToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem groupItemsToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem safeAsToolStripMenuItem;
		private System.Windows.Forms.SaveFileDialog saveFileDialog1;
		private System.Windows.Forms.ToolStripMenuItem openToolStripMenuItem;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.ToolStripMenuItem ungroupItemsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem copyToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem pasteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cutToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem scaleUpToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem scaleDownToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem selectorToolStripMenuItem;
		private System.Windows.Forms.ToolStripButton RotateButton;
		private System.Windows.Forms.ToolStripButton toolStripButton3;
	}
}
