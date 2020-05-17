package OnlineShop;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OnlineShopGrame extends JFrame {

	private JPanel container;
	static Object[] row= new Object[4];
	DefaultMutableTreeNode selectedNode=null;
	DefaultMutableTreeNode node_1=null;
	static JPanel maleJackesPanel=null;
	static	 JPanel maleShirtsPanel=null;
	static JPanel womenDressPanel=null;
	static JPanel treePanel;
	static JTree onlineShop; 
	static JLabel lblBackgroundTree;
	 static JLabel lblManJacketsProduct1;
	 static JLabel lblManJacketsProduct2;
	 static JLabel lblManJacketsProduct3;
	 static JLabel lblManJacketsProduct4;
	 static JLabel lblManJacketsProductBackground1;
	 static JLabel lblManJacketsProductBackground2;
	 static JLabel lblManJacketsProductBackground3;
	 static JLabel lblManJacketsProductBackground4;
	 static JLabel lblManJacketsProductPrice1;
	 static JLabel lblManJacketsProductPrice2;
	 static JLabel lblManJacketsProductPrice3;
	 static JLabel lblManJacketsProductPrice4;
	 static JLabel lblBacgroundMaleJacket;
	 static JComboBox comboBoxSortJackets;
	
	 static JTextPane countManJacketProduct1;
	 static JTextPane countManJacketProduct2;
	 static JTextPane countManJacketProduct3;
	 static JTextPane countManJacketProduct4;
	 static JButton btnManJacketAddProduct1;
	 static JButton btnManJacketAddProduct2;
	 static JButton btnManJacketAddProduct3;
	 static JButton btnManJacketAddProduct4;
	 static JLabel lblShirtsProductName1;
	 static JLabel lblShirtsProductName2;
	 static JLabel lblShirtsProductName3;
	 static JLabel lblShirtsProductName4;
	 static JLabel lblShirtsProductBackground1;
	 static JLabel lblShirtsProductBackground2;
	 static JLabel lblShirtsProductBackground3;
	 static JLabel lblShirtsProductBackground4;
	 static JLabel lblShirtsProductPrice1;
	 static JLabel lblShirtsProductPrice2;
	 static JLabel lblShirtsProductPrice3;
	 static JLabel lblShirtsProductPrice4;
	 static JButton btnViewCard;
	 static JComboBox comboBoxSortShirts;
	 static JTextPane caunterManShirtsProduct1;
	 static JTextPane caunterManShirtsProduct2;
	 static JTextPane caunterManShirtsProduct3;
	 static JTextPane caunterManShirtsProduct4;
	 static JButton btnManShirtsAddProduct1;
	 static JButton btnManShirtsAddProduct2;
	 static JButton btnManShirtsAddProduct3;
	 static JButton btnManShirtsAddProduct4;
	 static JButton btnViewCardShirts;
	 
	 static JLabel lblWomenDressName1;
	 static JLabel lblWomenDressName2;
	 static JLabel lblWomenDressName3;
	 static JLabel lblWomenDressName4;
	 static JLabel lblWomenDressBackground1;
	 static JLabel lblWomenDressBackground2;
	 static JLabel lblWomenDressBackground3;
	 static JLabel lblWomenDressBackground4;
	 static JLabel lblWomenDressPrice1;
	 static JLabel lblWomenDressPrice2;
	 static JLabel lblWomenDressPrice3;
	 static JLabel lblWomenDressPrice4;
	 static JComboBox comboBoxSortDress;
	 static JTextPane countWomenDressProduct1;
	 static JTextPane countWomenDressProduct2;
	 static JTextPane countWomenDressProduct3;
	 static JTextPane countWomenDressProduct4;
	 static JButton btnAddWomenDressProduct1;
	 static JButton btnAddWomenDressProduct2;
	 static JButton btnAddWomenDressProduct3;
	 static JButton btnAddWomenDressProduct4;
	 static JButton btnViewCardDress;
	 private JLabel lblwelcome;
	 private JLabel lblArrowLeft1;
	 private JLabel lblArrowUP2;
	 private JLabel lblArrowLEFT3;
	 private JLabel lblArrowLeft2;
	 private JLabel lblLine;
	 static JLabel lblClock;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnlineShopGrame frame = new OnlineShopGrame();
					frame.setVisible(true);
					ReadXMLFile();
					SortJacketsByPrice();
					SortShirtsByPrice();
					SortDressByPrice();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OnlineShopGrame() {
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1138, 620);
		container = new JPanel();
		container.setBackground(new Color(0, 0, 51));
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);
		
		treePanel = new JPanel();
		treePanel.setBounds(10, 94, 193, 476);
		treePanel.setBackground(new Color(0, 153, 204));
		container.add(treePanel);
		treePanel.setLayout(null);
		
	    onlineShop = new JTree();
	    onlineShop.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		onlineShop.setBackground(new Color(255, 255, 255));
		 DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) onlineShop.getCellRenderer();
		  Icon closedIcon = new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\list.png");
	        Icon openIcon = new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\store.png");
	        Icon leafIcon = new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\pricetag.png");
	        renderer.setClosedIcon(closedIcon);
	        renderer.setOpenIcon(openIcon);
	        renderer.setLeafIcon(leafIcon);
		onlineShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			selectedNode=(DefaultMutableTreeNode) onlineShop.getSelectionPath().getLastPathComponent();
			String selectedNodeToString= selectedNode.toString();
				if(selectedNodeToString.equals("Jackets"))
				{
					maleJackesPanel.setVisible(true);
					maleShirtsPanel.setVisible(false);
					womenDressPanel.setVisible(false);

				}else if(selectedNodeToString.equals("Shirts"))
				{
					maleJackesPanel.setVisible(false);
					maleShirtsPanel.setVisible(true);
					womenDressPanel.setVisible(false);
				}else if(selectedNodeToString.equals("Dress"))
				{
					maleJackesPanel.setVisible(false);
					maleShirtsPanel.setVisible(false);
					womenDressPanel.setVisible(true);
				}else if(selectedNodeToString.equals("T-Shirts"))
				{
					maleJackesPanel.setVisible(false);
					maleShirtsPanel.setVisible(false);
					womenDressPanel.setVisible(false);
				}
				else {
					maleJackesPanel.setVisible(false);
					maleShirtsPanel.setVisible(false);
					womenDressPanel.setVisible(false);
				}
			}
		});
		onlineShop.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("OnlineShop") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Man");
						node_1.add(new DefaultMutableTreeNode("Jackets"));
						node_1.add(new DefaultMutableTreeNode("Shirts"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Women");
						node_1.add(new DefaultMutableTreeNode("Dress"));
					add(node_1);
				}
			}
		));
		new Thread() {
			public void run()
			{
				while(true)
				{
					 Calendar call = new GregorianCalendar();
					int hour=call.get(Calendar.HOUR);
					int min= call.get(Calendar.MINUTE);
					int sec= call.get(Calendar.SECOND);
					int am_pm= call.get(Calendar.AM_PM);
				    
					int day=call.get(Calendar.DAY_OF_MONTH);
					int month= call.get(Calendar.JANUARY);
					int year= call.get(Calendar.YEAR);
					
				  
					String day_night="";
					if (am_pm==1) {
						day_night="PM";
					}else
					{
						day_night="AM";
					}
					String dateTime = hour+":"+min+":"+sec+" "+day_night+" "+day+"/"+month+"/"+year+" "; 
				    lblClock.setText(dateTime);
				}   
			}
		}.start();
		onlineShop.setBounds(10, 11, 173, 175);
		treePanel.add(onlineShop);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("DS-Digital", Font.PLAIN, 20));
		lblClock.setBounds(10, 198, 173, 82);
		treePanel.add(lblClock);
		
		lblBackgroundTree = new JLabel("New label");
		lblBackgroundTree.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\rsz_128.jpg"));
		lblBackgroundTree.setBounds(0, 0, 193, 476);
		treePanel.add(lblBackgroundTree);
		
		maleJackesPanel = new JPanel();
		maleJackesPanel.setVisible(false);
		maleJackesPanel.setBackground(Color.WHITE);
		maleJackesPanel.setBounds(213, 94, 861, 476);
		container.add(maleJackesPanel);
		maleJackesPanel.setLayout(null);
		
		lblManJacketsProduct1 = new JLabel("");
		lblManJacketsProduct1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblManJacketsProduct1.setBounds(43, 24, 138, 41);
		maleJackesPanel.add(lblManJacketsProduct1);
		
		lblManJacketsProduct3 = new JLabel("");
		lblManJacketsProduct3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblManJacketsProduct3.setBounds(425, 24, 138, 41);
		maleJackesPanel.add(lblManJacketsProduct3);
		
		lblManJacketsProduct2 = new JLabel("");
		lblManJacketsProduct2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblManJacketsProduct2.setBounds(236, 24, 138, 41);
		maleJackesPanel.add(lblManJacketsProduct2);
		
		lblManJacketsProduct4 = new JLabel("");
		lblManJacketsProduct4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblManJacketsProduct4.setBounds(616, 24, 138, 41);
		maleJackesPanel.add(lblManJacketsProduct4);
		
		lblManJacketsProductBackground2 = new JLabel("");
		lblManJacketsProductBackground2.setIcon(null);
		lblManJacketsProductBackground2.setForeground(Color.WHITE);
		lblManJacketsProductBackground2.setBounds(236, 65, 164, 161);
		maleJackesPanel.add(lblManJacketsProductBackground2);
		
		lblManJacketsProductBackground3 = new JLabel("");
		lblManJacketsProductBackground3.setIcon(null);
		lblManJacketsProductBackground3.setForeground(Color.WHITE);
		lblManJacketsProductBackground3.setBounds(425, 65, 164, 161);
		maleJackesPanel.add(lblManJacketsProductBackground3);
		
		lblManJacketsProductBackground4 = new JLabel("");
		lblManJacketsProductBackground4.setIcon(null);
		lblManJacketsProductBackground4.setForeground(Color.WHITE);
		lblManJacketsProductBackground4.setBounds(616, 65, 164, 161);
		maleJackesPanel.add(lblManJacketsProductBackground4);
		
		lblManJacketsProductBackground1 = new JLabel("");
		lblManJacketsProductBackground1.setIcon(null);
		lblManJacketsProductBackground1.setForeground(Color.WHITE);
		lblManJacketsProductBackground1.setBounds(43, 65, 164, 161);
		maleJackesPanel.add(lblManJacketsProductBackground1);
		
		lblManJacketsProductPrice1 = new JLabel("");
		lblManJacketsProductPrice1.setIcon(null);
		lblManJacketsProductPrice1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblManJacketsProductPrice1.setBounds(43, 226, 94, 41);
		maleJackesPanel.add(lblManJacketsProductPrice1);
		
		lblManJacketsProductPrice2 = new JLabel("");
		lblManJacketsProductPrice2.setIcon(null);
		lblManJacketsProductPrice2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblManJacketsProductPrice2.setBounds(236, 226, 94, 41);
		maleJackesPanel.add(lblManJacketsProductPrice2);
		
		lblManJacketsProductPrice3 = new JLabel("");
		lblManJacketsProductPrice3.setIcon(null);
		lblManJacketsProductPrice3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblManJacketsProductPrice3.setBounds(425, 226, 94, 41);
		maleJackesPanel.add(lblManJacketsProductPrice3);
		
		lblManJacketsProductPrice4 = new JLabel("");
		lblManJacketsProductPrice4.setIcon(null);
		lblManJacketsProductPrice4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblManJacketsProductPrice4.setBounds(616, 226, 94, 41);
		maleJackesPanel.add(lblManJacketsProductPrice4);
		
		comboBoxSortJackets = new JComboBox();
		comboBoxSortJackets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxSortJackets.getSelectedItem().equals("Name")) {
					SortJacketsByName();
				}else if (comboBoxSortJackets.getSelectedItem().equals("Price")) {
					SortJacketsByPrice();
				}
			}
		});
		comboBoxSortJackets.setModel(new DefaultComboBoxModel(new String[] {"Price", "Name"}));
		comboBoxSortJackets.setBounds(550, 345, 119, 34);
		maleJackesPanel.add(comboBoxSortJackets);
		
		countManJacketProduct1 = new JTextPane();
		countManJacketProduct1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		countManJacketProduct1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		countManJacketProduct1.setText("0");
		countManJacketProduct1.setBounds(147, 231, 60, 24);
		maleJackesPanel.add(countManJacketProduct1);
		
		countManJacketProduct2 = new JTextPane();
		countManJacketProduct2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		countManJacketProduct2.setText("0");
		countManJacketProduct2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		countManJacketProduct2.setBounds(340, 231, 60, 24);
		maleJackesPanel.add(countManJacketProduct2);
		
		countManJacketProduct3 = new JTextPane();
		countManJacketProduct3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		countManJacketProduct3.setText("0");
		countManJacketProduct3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		countManJacketProduct3.setBounds(530, 231, 60, 24);
		maleJackesPanel.add(countManJacketProduct3);
		
		countManJacketProduct4 = new JTextPane();
		countManJacketProduct4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		countManJacketProduct4.setText("0");
		countManJacketProduct4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		countManJacketProduct4.setBounds(720, 231, 60, 24);
		maleJackesPanel.add(countManJacketProduct4);
		
		btnManJacketAddProduct1 = new JButton("");
		btnManJacketAddProduct1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                     row[0]=lblManJacketsProduct1.getText();
            		 row[1]=countManJacketProduct1.getText(); 
            		 row[2]=lblManJacketsProductPrice1.getText();
            		 row[3]= "ˆ "+Integer.parseInt(countManJacketProduct1.getText())*Integer.parseInt(lblManJacketsProductPrice1.getText().substring(2));
            		 ViewCard.model.insertRow(0, row);
            		 ViewCard.getOverAllSumOfOrders();
        
 
            		 
			}
		});
		btnManJacketAddProduct1.setContentAreaFilled(false);
		btnManJacketAddProduct1.setBorder(new CompoundBorder());
		btnManJacketAddProduct1.setBorderPainted(false);
		btnManJacketAddProduct1.setOpaque(false);
		btnManJacketAddProduct1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnManJacketAddProduct1.setBounds(147, 251, 48, 48);
		maleJackesPanel.add(btnManJacketAddProduct1);
		
		btnManJacketAddProduct2 = new JButton("");
		btnManJacketAddProduct2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 row[0]=lblManJacketsProduct2.getText();
        		 row[1]=countManJacketProduct2.getText(); 
        		 row[2]=lblManJacketsProductPrice2.getText();
        		 row[3]= "ˆ "+Integer.parseInt(countManJacketProduct2.getText())*Integer.parseInt(lblManJacketsProductPrice2.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
     
			}
		});
		btnManJacketAddProduct2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnManJacketAddProduct2.setOpaque(false);
		btnManJacketAddProduct2.setContentAreaFilled(false);
		btnManJacketAddProduct2.setBorderPainted(false);
		btnManJacketAddProduct2.setBorder(new CompoundBorder());
		btnManJacketAddProduct2.setBounds(340, 251, 48, 48);
		maleJackesPanel.add(btnManJacketAddProduct2);
		
		btnManJacketAddProduct3 = new JButton("");
		btnManJacketAddProduct3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 row[0]=lblManJacketsProduct3.getText();
        		 row[1]=countManJacketProduct3.getText(); 
        		 row[2]=lblManJacketsProductPrice3.getText();
        		 row[3]= "ˆ "+Integer.parseInt(countManJacketProduct3.getText())*Integer.parseInt(lblManJacketsProductPrice3.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
        	
			}
		});
		btnManJacketAddProduct3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnManJacketAddProduct3.setOpaque(false);
		btnManJacketAddProduct3.setContentAreaFilled(false);
		btnManJacketAddProduct3.setBorderPainted(false);
		btnManJacketAddProduct3.setBorder(new CompoundBorder());
		btnManJacketAddProduct3.setBounds(530, 251, 48, 48);
		maleJackesPanel.add(btnManJacketAddProduct3);
		
		btnManJacketAddProduct4 = new JButton("");
		btnManJacketAddProduct4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 row[0]=lblManJacketsProduct4.getText();
        		 row[1]=countManJacketProduct4.getText(); 
        		 row[2]=lblManJacketsProductPrice4.getText();
        		 row[3]= "ˆ "+Integer.parseInt(countManJacketProduct3.getText())*Integer.parseInt(lblManJacketsProductPrice3.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
 
			}
		});
		btnManJacketAddProduct4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnManJacketAddProduct4.setOpaque(false);
		btnManJacketAddProduct4.setContentAreaFilled(false);
		btnManJacketAddProduct4.setBorderPainted(false);
		btnManJacketAddProduct4.setBorder(new CompoundBorder());
		btnManJacketAddProduct4.setBounds(720, 251, 48, 48);
		maleJackesPanel.add(btnManJacketAddProduct4);
		
		btnViewCard = new JButton("View Card");
		btnViewCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ViewCard.getAllElementsCount();
			}
		});
		btnViewCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ViewCard.frame = new ViewCard();
        		 ViewCard.frame.setVisible(true);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnViewCard.setBorder(new CompoundBorder());
		btnViewCard.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 13));
		btnViewCard.setContentAreaFilled(false);
		btnViewCard.setOpaque(false);
		btnViewCard.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\storeBag.png"));
		btnViewCard.setBounds(79, 343, 197, 96);
		maleJackesPanel.add(btnViewCard);
		
		lblBacgroundMaleJacket = new JLabel("");
		lblBacgroundMaleJacket.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\rsz_128.jpg"));
		lblBacgroundMaleJacket.setBounds(0, 0, 861, 476);
		maleJackesPanel.add(lblBacgroundMaleJacket);
		
		maleShirtsPanel= new JPanel();
		maleShirtsPanel.setVisible(false);
		maleShirtsPanel.setBackground(Color.WHITE);
		maleShirtsPanel.setBounds(213, 94, 861, 476);
		container.add(maleShirtsPanel);
		maleShirtsPanel.setLayout(null);
		
		lblShirtsProductName1 = new JLabel("");
		lblShirtsProductName1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblShirtsProductName1.setBounds(43, 24, 138, 41);
		maleShirtsPanel.add(lblShirtsProductName1);
		
		lblShirtsProductName2 = new JLabel("");
		lblShirtsProductName2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblShirtsProductName2.setBounds(236, 24, 138, 41);
		maleShirtsPanel.add(lblShirtsProductName2);
		
		lblShirtsProductName3 = new JLabel("");
		lblShirtsProductName3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblShirtsProductName3.setBounds(425, 24, 138, 41);
		maleShirtsPanel.add(lblShirtsProductName3);
		
		lblShirtsProductName4 = new JLabel("");
		lblShirtsProductName4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblShirtsProductName4.setBounds(616, 24, 138, 41);
		maleShirtsPanel.add(lblShirtsProductName4);
		
		lblShirtsProductBackground1 = new JLabel("");
		lblShirtsProductBackground1.setForeground(Color.WHITE);
		lblShirtsProductBackground1.setBounds(43, 65, 164, 161);
		maleShirtsPanel.add(lblShirtsProductBackground1);
		
		lblShirtsProductBackground2 = new JLabel("");
		lblShirtsProductBackground2.setForeground(Color.WHITE);
		lblShirtsProductBackground2.setBounds(236, 65, 164, 161);
		maleShirtsPanel.add(lblShirtsProductBackground2);
		
		lblShirtsProductBackground3 = new JLabel("");
		lblShirtsProductBackground3.setForeground(Color.WHITE);
		lblShirtsProductBackground3.setBounds(425, 65, 164, 161);
		maleShirtsPanel.add(lblShirtsProductBackground3);
		
		lblShirtsProductBackground4 = new JLabel("");
		lblShirtsProductBackground4.setForeground(Color.WHITE);
		lblShirtsProductBackground4.setBounds(616, 65, 164, 161);
		maleShirtsPanel.add(lblShirtsProductBackground4);
		
		lblShirtsProductPrice1 = new JLabel("");
		lblShirtsProductPrice1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblShirtsProductPrice1.setBounds(43, 226, 94, 41);
		maleShirtsPanel.add(lblShirtsProductPrice1);
		
		lblShirtsProductPrice2 = new JLabel("");
		lblShirtsProductPrice2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblShirtsProductPrice2.setBounds(236, 226, 94, 41);
		maleShirtsPanel.add(lblShirtsProductPrice2);
		
		lblShirtsProductPrice3 = new JLabel("");
		lblShirtsProductPrice3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblShirtsProductPrice3.setBounds(425, 226, 94, 41);
		maleShirtsPanel.add(lblShirtsProductPrice3);
		
		lblShirtsProductPrice4 = new JLabel("");
		lblShirtsProductPrice4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblShirtsProductPrice4.setBounds(616, 226, 94, 41);
		maleShirtsPanel.add(lblShirtsProductPrice4);
		
		comboBoxSortShirts = new JComboBox();
		comboBoxSortShirts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxSortShirts.getSelectedItem().equals("Name")) {
					SortShirtsByName();
					
				}else if(comboBoxSortShirts.getSelectedItem().equals("Price"))
				{
					SortShirtsByPrice();
				}
			}
		});
		comboBoxSortShirts.setModel(new DefaultComboBoxModel(new String[] {"Price", "Name"}));
		comboBoxSortShirts.setBounds(550, 345, 119, 34);
		maleShirtsPanel.add(comboBoxSortShirts);
		
		caunterManShirtsProduct1 = new JTextPane();
		caunterManShirtsProduct1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		caunterManShirtsProduct1.setText("0");
		caunterManShirtsProduct1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		caunterManShirtsProduct1.setBounds(147, 231, 60, 24);
		maleShirtsPanel.add(caunterManShirtsProduct1);
		
		caunterManShirtsProduct2 = new JTextPane();
		caunterManShirtsProduct2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		caunterManShirtsProduct2.setText("0");
		caunterManShirtsProduct2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		caunterManShirtsProduct2.setBounds(340, 231, 60, 24);
		maleShirtsPanel.add(caunterManShirtsProduct2);
		
		caunterManShirtsProduct3 = new JTextPane();
		caunterManShirtsProduct3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		caunterManShirtsProduct3.setText("0");
		caunterManShirtsProduct3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		caunterManShirtsProduct3.setBounds(530, 231, 60, 24);
		maleShirtsPanel.add(caunterManShirtsProduct3);
		
		caunterManShirtsProduct4 = new JTextPane();
		caunterManShirtsProduct4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		caunterManShirtsProduct4.setText("0");
		caunterManShirtsProduct4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		caunterManShirtsProduct4.setBounds(720, 231, 60, 24);
		maleShirtsPanel.add(caunterManShirtsProduct4);
		
		btnManShirtsAddProduct1 = new JButton("");
		btnManShirtsAddProduct1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 row[0]=lblShirtsProductName1.getText();
        		 row[1]=caunterManShirtsProduct1.getText(); 
        		 row[2]=lblShirtsProductPrice1.getText();
        		 row[3]= "ˆ "+Integer.parseInt(caunterManShirtsProduct1.getText())*Integer.parseInt(lblShirtsProductPrice1.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnManShirtsAddProduct1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnManShirtsAddProduct1.setOpaque(false);
		btnManShirtsAddProduct1.setContentAreaFilled(false);
		btnManShirtsAddProduct1.setBorderPainted(false);
		btnManShirtsAddProduct1.setBorder(new CompoundBorder());
		btnManShirtsAddProduct1.setBounds(147, 251, 48, 48);
		maleShirtsPanel.add(btnManShirtsAddProduct1);
		
		btnManShirtsAddProduct2 = new JButton("");
		btnManShirtsAddProduct2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 row[0]=lblShirtsProductName2.getText();
        		 row[1]=caunterManShirtsProduct2.getText(); 
        		 row[2]=lblShirtsProductPrice2.getText();
        		 row[3]= "ˆ "+Integer.parseInt(caunterManShirtsProduct2.getText())*Integer.parseInt(lblShirtsProductPrice2.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnManShirtsAddProduct2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnManShirtsAddProduct2.setOpaque(false);
		btnManShirtsAddProduct2.setContentAreaFilled(false);
		btnManShirtsAddProduct2.setBorderPainted(false);
		btnManShirtsAddProduct2.setBorder(new CompoundBorder());
		btnManShirtsAddProduct2.setBounds(340, 251, 48, 48);
		maleShirtsPanel.add(btnManShirtsAddProduct2);
		
		btnManShirtsAddProduct3 = new JButton("");
		btnManShirtsAddProduct3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 row[0]=lblShirtsProductName3.getText();
        		 row[1]=caunterManShirtsProduct3.getText(); 
        		 row[2]=lblShirtsProductPrice3.getText();
        		 row[3]= "ˆ "+Integer.parseInt(caunterManShirtsProduct3.getText())*Integer.parseInt(lblShirtsProductPrice3.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnManShirtsAddProduct3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnManShirtsAddProduct3.setOpaque(false);
		btnManShirtsAddProduct3.setContentAreaFilled(false);
		btnManShirtsAddProduct3.setBorderPainted(false);
		btnManShirtsAddProduct3.setBorder(new CompoundBorder());
		btnManShirtsAddProduct3.setBounds(530, 251, 48, 48);
		maleShirtsPanel.add(btnManShirtsAddProduct3);
		
		btnManShirtsAddProduct4 = new JButton("");
		btnManShirtsAddProduct4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 row[0]=lblShirtsProductName4.getText();
        		 row[1]=caunterManShirtsProduct4.getText(); 
        		 row[2]=lblShirtsProductPrice4.getText();
        		 row[3]= "ˆ "+Integer.parseInt(caunterManShirtsProduct4.getText())*Integer.parseInt(lblShirtsProductPrice4.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnManShirtsAddProduct4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnManShirtsAddProduct4.setOpaque(false);
		btnManShirtsAddProduct4.setContentAreaFilled(false);
		btnManShirtsAddProduct4.setBorderPainted(false);
		btnManShirtsAddProduct4.setBorder(new CompoundBorder());
		btnManShirtsAddProduct4.setBounds(720, 251, 48, 48);
		maleShirtsPanel.add(btnManShirtsAddProduct4);
		
		btnViewCardShirts = new JButton("View Card");
		btnViewCardShirts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 ViewCard.getAllElementsCount();
				
			}
		});
		btnViewCardShirts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ViewCard.frame = new ViewCard();
        		 ViewCard.frame.setVisible(true);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnViewCardShirts.setBorder(new CompoundBorder());
		btnViewCardShirts.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\storeBag.png"));
		btnViewCardShirts.setOpaque(false);
		btnViewCardShirts.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 13));
		btnViewCardShirts.setContentAreaFilled(false);
		btnViewCardShirts.setBounds(79, 343, 197, 96);
		maleShirtsPanel.add(btnViewCardShirts);
		
		JLabel lblBacgroundMaleShirts = new JLabel("");
		lblBacgroundMaleShirts.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\rsz_128.jpg"));
		lblBacgroundMaleShirts.setBounds(0, 0, 861, 476);
		maleShirtsPanel.add(lblBacgroundMaleShirts);
		
		womenDressPanel = new JPanel();
		womenDressPanel.setVisible(false);
		womenDressPanel.setBackground(Color.WHITE);
		womenDressPanel.setBounds(213, 94, 861, 476);
		container.add(womenDressPanel);
		womenDressPanel.setLayout(null);
		
		lblWomenDressName1 = new JLabel("");
		lblWomenDressName1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblWomenDressName1.setBounds(43, 24, 138, 41);
		womenDressPanel.add(lblWomenDressName1);
		
		lblWomenDressName2 = new JLabel("");
		lblWomenDressName2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblWomenDressName2.setBounds(236, 24, 138, 41);
		womenDressPanel.add(lblWomenDressName2);
		
		lblWomenDressName3 = new JLabel("");
		lblWomenDressName3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblWomenDressName3.setBounds(425, 24, 138, 41);
		womenDressPanel.add(lblWomenDressName3);
		
		lblWomenDressName4 = new JLabel("");
		lblWomenDressName4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblWomenDressName4.setBounds(616, 24, 138, 41);
		womenDressPanel.add(lblWomenDressName4);
		
		lblWomenDressBackground1 = new JLabel("");
		lblWomenDressBackground1.setForeground(Color.WHITE);
		lblWomenDressBackground1.setBounds(43, 65, 164, 161);
		womenDressPanel.add(lblWomenDressBackground1);
		
		lblWomenDressBackground2 = new JLabel("");
		lblWomenDressBackground2.setForeground(Color.WHITE);
		lblWomenDressBackground2.setBounds(236, 65, 164, 161);
		womenDressPanel.add(lblWomenDressBackground2);
		
		lblWomenDressBackground3 = new JLabel("");
		lblWomenDressBackground3.setForeground(Color.WHITE);
		lblWomenDressBackground3.setBounds(425, 65, 164, 161);
		womenDressPanel.add(lblWomenDressBackground3);
		
		lblWomenDressBackground4 = new JLabel("");
		lblWomenDressBackground4.setForeground(Color.WHITE);
		lblWomenDressBackground4.setBounds(616, 65, 164, 161);
		womenDressPanel.add(lblWomenDressBackground4);
		
		lblWomenDressPrice1 = new JLabel("");
		lblWomenDressPrice1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblWomenDressPrice1.setBounds(43, 226, 94, 41);
		womenDressPanel.add(lblWomenDressPrice1);
		
		lblWomenDressPrice2 = new JLabel("");
		lblWomenDressPrice2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblWomenDressPrice2.setBounds(236, 226, 94, 41);
		womenDressPanel.add(lblWomenDressPrice2);
		
		lblWomenDressPrice3 = new JLabel("");
		lblWomenDressPrice3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblWomenDressPrice3.setBounds(425, 226, 94, 41);
		womenDressPanel.add(lblWomenDressPrice3);
		
		lblWomenDressPrice4 = new JLabel("");
		lblWomenDressPrice4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblWomenDressPrice4.setBounds(616, 226, 94, 41);
		womenDressPanel.add(lblWomenDressPrice4);
		
		comboBoxSortDress = new JComboBox();
		comboBoxSortDress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxSortDress.getSelectedItem().equals("Name")) {
					SortDressByName();
					
				}else if(comboBoxSortShirts.getSelectedItem().equals("Price"))
				{
					SortDressByPrice();
				}
			}
		});
		comboBoxSortDress.setModel(new DefaultComboBoxModel(new String[] {"Price", "Name"}));
		comboBoxSortDress.setBounds(550, 345, 119, 34);
		womenDressPanel.add(comboBoxSortDress);
		
		countWomenDressProduct1 = new JTextPane();
		countWomenDressProduct1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		countWomenDressProduct1.setText("0");
		countWomenDressProduct1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		countWomenDressProduct1.setBounds(147, 231, 60, 24);
		womenDressPanel.add(countWomenDressProduct1);
		
		countWomenDressProduct2 = new JTextPane();
		countWomenDressProduct2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		countWomenDressProduct2.setText("0");
		countWomenDressProduct2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		countWomenDressProduct2.setBounds(340, 231, 60, 24);
		womenDressPanel.add(countWomenDressProduct2);
		
		countWomenDressProduct3 = new JTextPane();
		countWomenDressProduct3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		countWomenDressProduct3.setText("0");
		countWomenDressProduct3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		countWomenDressProduct3.setBounds(530, 231, 60, 24);
		womenDressPanel.add(countWomenDressProduct3);
		
		countWomenDressProduct4 = new JTextPane();
		countWomenDressProduct4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbersAlloweed(e);
			}
		});
		countWomenDressProduct4.setText("0");
		countWomenDressProduct4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		countWomenDressProduct4.setBounds(720, 231, 60, 24);
		womenDressPanel.add(countWomenDressProduct4);
		
		btnAddWomenDressProduct1 = new JButton("");
		btnAddWomenDressProduct1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 row[0]=lblWomenDressName1.getText();
        		 row[1]=countWomenDressProduct1.getText(); 
        		 row[2]=lblWomenDressPrice1.getText();
        		 row[3]= "ˆ "+Integer.parseInt(countWomenDressProduct1.getText())*Integer.parseInt(lblWomenDressPrice1.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnAddWomenDressProduct1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnAddWomenDressProduct1.setOpaque(false);
		btnAddWomenDressProduct1.setContentAreaFilled(false);
		btnAddWomenDressProduct1.setBorderPainted(false);
		btnAddWomenDressProduct1.setBorder(new CompoundBorder());
		btnAddWomenDressProduct1.setBounds(147, 251, 48, 48);
		womenDressPanel.add(btnAddWomenDressProduct1);
		
		btnAddWomenDressProduct2 = new JButton("");
		btnAddWomenDressProduct2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 row[0]=lblWomenDressName2.getText();
        		 row[1]=countWomenDressProduct2.getText(); 
        		 row[2]=lblWomenDressPrice2.getText();
        		 row[3]= "ˆ "+Integer.parseInt(countWomenDressProduct2.getText())*Integer.parseInt(lblWomenDressPrice2.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnAddWomenDressProduct2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnAddWomenDressProduct2.setOpaque(false);
		btnAddWomenDressProduct2.setContentAreaFilled(false);
		btnAddWomenDressProduct2.setBorderPainted(false);
		btnAddWomenDressProduct2.setBorder(new CompoundBorder());
		btnAddWomenDressProduct2.setBounds(340, 251, 48, 48);
		womenDressPanel.add(btnAddWomenDressProduct2);
		
		btnAddWomenDressProduct3 = new JButton("");
		btnAddWomenDressProduct3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 row[0]=lblWomenDressName3.getText();
        		 row[1]=countWomenDressProduct3.getText(); 
        		 row[2]=lblWomenDressPrice1.getText();
        		 row[3]= "ˆ "+Integer.parseInt(countWomenDressProduct3.getText())*Integer.parseInt(lblWomenDressPrice3.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnAddWomenDressProduct3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnAddWomenDressProduct3.setOpaque(false);
		btnAddWomenDressProduct3.setContentAreaFilled(false);
		btnAddWomenDressProduct3.setBorderPainted(false);
		btnAddWomenDressProduct3.setBorder(new CompoundBorder());
		btnAddWomenDressProduct3.setBounds(530, 251, 48, 48);
		womenDressPanel.add(btnAddWomenDressProduct3);
		
		btnAddWomenDressProduct4 = new JButton("");
		btnAddWomenDressProduct4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 row[0]=lblWomenDressName4.getText();
        		 row[1]=countWomenDressProduct4.getText(); 
        		 row[2]=lblWomenDressPrice1.getText();
        		 row[3]= "ˆ "+Integer.parseInt(countWomenDressProduct4.getText())*Integer.parseInt(lblWomenDressPrice4.getText().substring(2));
        		 ViewCard.model.insertRow(0, row);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnAddWomenDressProduct4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\addProduct.png"));
		btnAddWomenDressProduct4.setOpaque(false);
		btnAddWomenDressProduct4.setContentAreaFilled(false);
		btnAddWomenDressProduct4.setBorderPainted(false);
		btnAddWomenDressProduct4.setBorder(new CompoundBorder());
		btnAddWomenDressProduct4.setBounds(720, 251, 48, 48);
		womenDressPanel.add(btnAddWomenDressProduct4);
		
		btnViewCardDress = new JButton("View Card");
		btnViewCardDress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 ViewCard.getAllElementsCount();
			}
		});
		btnViewCardDress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ViewCard.frame = new ViewCard();
        		 ViewCard.frame.setVisible(true);
        		 ViewCard.getOverAllSumOfOrders();
			}
		});
		btnViewCardDress.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\storeBag.png"));
		btnViewCardDress.setOpaque(false);
		btnViewCardDress.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 13));
		btnViewCardDress.setContentAreaFilled(false);
		btnViewCardDress.setBorder(new CompoundBorder());
		btnViewCardDress.setBounds(79, 343, 197, 96);
		womenDressPanel.add(btnViewCardDress);
		
		JLabel lblWomenDress = new JLabel("");
		lblWomenDress.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\rsz_128.jpg"));
		lblWomenDress.setBounds(0, 0, 861, 476);
		womenDressPanel.add(lblWomenDress);
		
		lblArrowLeft2 = new JLabel("");
		lblArrowLeft2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\Webp.net-resizeimage (2).gif"));
		lblArrowLeft2.setBounds(213, 94, 72, 70);
		container.add(lblArrowLeft2);
		
		lblArrowLEFT3 = new JLabel("");
		lblArrowLEFT3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\Webp.net-resizeimage (2).gif"));
		lblArrowLEFT3.setBounds(285, 94, 72, 70);
		container.add(lblArrowLEFT3);
		
		lblArrowUP2 = new JLabel("");
		lblArrowUP2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\Webp.net-resizeimage (7).gif"));
		lblArrowUP2.setBounds(285, 164, 72, 72);
		container.add(lblArrowUP2);
		
		lblArrowLeft1 = new JLabel("");
		lblArrowLeft1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\Webp.net-resizeimage (2).gif"));
		lblArrowLeft1.setBounds(357, 164, 72, 72);
		container.add(lblArrowLeft1);
		
		lblwelcome = new JLabel("New label");
		lblwelcome.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\welcome.gif"));
		lblwelcome.setBounds(429, 136, 488, 253);
		container.add(lblwelcome);
		
		lblLine = new JLabel("");
		lblLine.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\line.gif"));
		lblLine.setBounds(370, 234, 612, 322);
		container.add(lblLine);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\Blue_gaussian_blur_1920x1200.jpg"));
		lblBackground.setBounds(0, 0, 1130, 592);
		container.add(lblBackground);
	}
	public static void ReadXMLFile()
	{
		try {

			File fXmlFile = new File("D:\\JULIEN\\Uni\\Java\\OnlineShop\\XML\\DataBaseMyShop.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			doc.getDocumentElement().normalize();
					
			NodeList nListJackets = doc.getElementsByTagName("Jackets");

			for (int i = 0; i < nListJackets.getLength(); i++) {
				Node nJackets = nListJackets.item(i);		
				if ((nJackets).getNodeType() == Node.ELEMENT_NODE) {
					Element elementJackets = (Element) nJackets;
					lblManJacketsProduct1.setText(elementJackets.getElementsByTagName("FirstJacketName").item(0).getTextContent());
					lblManJacketsProduct2.setText(elementJackets.getElementsByTagName("SecondJacketName").item(0).getTextContent());
					lblManJacketsProduct3.setText(elementJackets.getElementsByTagName("ThirdJacketName").item(0).getTextContent());
					lblManJacketsProduct4.setText(elementJackets.getElementsByTagName("ForthJacketName").item(0).getTextContent());
					lblManJacketsProductBackground1.setIcon(new ImageIcon(elementJackets.getElementsByTagName("FirstJacketPathImage").item(0).getTextContent()));
					lblManJacketsProductBackground2.setIcon(new ImageIcon(elementJackets.getElementsByTagName("SecondJacketPathImage").item(0).getTextContent()));
					lblManJacketsProductBackground3.setIcon(new ImageIcon(elementJackets.getElementsByTagName("ThirdJacketPathImage").item(0).getTextContent()));
					lblManJacketsProductBackground4.setIcon(new ImageIcon(elementJackets.getElementsByTagName("ForthJacketPathImage").item(0).getTextContent()));
					lblManJacketsProductPrice1.setText(elementJackets.getElementsByTagName("FirstJacketPrice").item(0).getTextContent());
					lblManJacketsProductPrice2.setText(elementJackets.getElementsByTagName("SecondJacketPrice").item(0).getTextContent());
					lblManJacketsProductPrice3.setText(elementJackets.getElementsByTagName("ThirdJacketPrice").item(0).getTextContent());
					lblManJacketsProductPrice4.setText(elementJackets.getElementsByTagName("ForthJacketPrice").item(0).getTextContent());
				}
			}
			NodeList nListShirts = doc.getElementsByTagName("Shirts");
			for (int i = 0; i < nListShirts.getLength(); i++) {
				Node nShirts = nListShirts.item(i);		
				if ((nShirts).getNodeType() == Node.ELEMENT_NODE) {

					Element elementJackets = (Element) nShirts;
					lblShirtsProductName1.setText(elementJackets.getElementsByTagName("FirstShirtName").item(0).getTextContent());
					lblShirtsProductName2.setText(elementJackets.getElementsByTagName("SecondShirtName").item(0).getTextContent());
					lblShirtsProductName3.setText(elementJackets.getElementsByTagName("ThirdShirtName").item(0).getTextContent());
					lblShirtsProductName4.setText(elementJackets.getElementsByTagName("ForthShirtName").item(0).getTextContent());
					lblShirtsProductBackground1.setIcon(new ImageIcon( elementJackets.getElementsByTagName("FirstShirtPathImage").item(0).getTextContent()));
					lblShirtsProductBackground2.setIcon(new ImageIcon( elementJackets.getElementsByTagName("SecondShirtPathImage").item(0).getTextContent()));
					lblShirtsProductBackground3.setIcon(new ImageIcon( elementJackets.getElementsByTagName("ThirdShirtPathImage").item(0).getTextContent()));
					lblShirtsProductBackground4.setIcon(new ImageIcon( elementJackets.getElementsByTagName("ForthShirtPathImage").item(0).getTextContent()));
					lblShirtsProductPrice1.setText(elementJackets.getElementsByTagName("FirstShirtPrice").item(0).getTextContent());
					lblShirtsProductPrice2.setText(elementJackets.getElementsByTagName("SecondShirtPrice").item(0).getTextContent());
					lblShirtsProductPrice3.setText(elementJackets.getElementsByTagName("ThirdShirtPrice").item(0).getTextContent());
					lblShirtsProductPrice4.setText(elementJackets.getElementsByTagName("ForthShirtPrice").item(0).getTextContent());
				}
			}
			NodeList nListDress = doc.getElementsByTagName("Dress");
			for (int i = 0; i < nListDress.getLength(); i++) {
				Node nDress = nListDress.item(i);		
				if ((nDress).getNodeType() == Node.ELEMENT_NODE) {

					Element elementJackets = (Element) nDress;
					lblWomenDressName1.setText(elementJackets.getElementsByTagName("FirstDressName").item(0).getTextContent());
					lblWomenDressName2.setText(elementJackets.getElementsByTagName("SecondDressName").item(0).getTextContent());
					lblWomenDressName3.setText(elementJackets.getElementsByTagName("ThirdDressName").item(0).getTextContent());
					lblWomenDressName4.setText(elementJackets.getElementsByTagName("ForthDressName").item(0).getTextContent());
					lblWomenDressBackground1.setIcon(new ImageIcon(elementJackets.getElementsByTagName("FirstDressPathImage").item(0).getTextContent()));
					lblWomenDressBackground2.setIcon(new ImageIcon(elementJackets.getElementsByTagName("SecondDressPathImage").item(0).getTextContent()));
					lblWomenDressBackground3.setIcon(new ImageIcon(elementJackets.getElementsByTagName("ThirdDressPathImage").item(0).getTextContent()));
					lblWomenDressBackground4.setIcon(new ImageIcon(elementJackets.getElementsByTagName("ForthDressPathImage").item(0).getTextContent()));
					lblWomenDressPrice1.setText(elementJackets.getElementsByTagName("FirstDressPrice").item(0).getTextContent());
					lblWomenDressPrice2.setText(elementJackets.getElementsByTagName("SecondDressPrice").item(0).getTextContent());
					lblWomenDressPrice3.setText(elementJackets.getElementsByTagName("ThirdtDressPrice").item(0).getTextContent());
					lblWomenDressPrice4.setText(elementJackets.getElementsByTagName("ForthDressPrice").item(0).getTextContent());
				}
			}
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  }
	public static void SortJacketsByName()
	{
		ArrayList<String> listJacketsName = new ArrayList<String>();
		ArrayList<String> listJacketsPrice= new ArrayList<String>();
			listJacketsName.add(lblManJacketsProduct1.getText());
			listJacketsName.add(lblManJacketsProduct2.getText());
			listJacketsName.add(lblManJacketsProduct3.getText());
			listJacketsName.add(lblManJacketsProduct4.getText());
		         	 Collections.sort(listJacketsName);
							System.out.println(listJacketsName);
				 lblManJacketsProduct1.setText(listJacketsName.get(0));
				 lblManJacketsProduct2.setText(listJacketsName.get(1));
				 lblManJacketsProduct3.setText(listJacketsName.get(2));
				 lblManJacketsProduct4.setText(listJacketsName.get(3));
				 lblManJacketsProductBackground1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manJacket2.jpg"));
				 lblManJacketsProductBackground2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manJacket3.jpg"));
			      lblManJacketsProductBackground3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manJacket1.jpg"));
		          lblManJacketsProductBackground4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manJacket4.jpg"));
		     
		      	listJacketsPrice.add(lblManJacketsProductPrice1.getText());
		      	listJacketsPrice.add(lblManJacketsProductPrice2.getText());
		      	listJacketsPrice.add(lblManJacketsProductPrice3.getText());
		      	listJacketsPrice.add(lblManJacketsProductPrice4.getText());
			         	 Collections.sort(listJacketsPrice);
					 lblManJacketsProductPrice1.setText(listJacketsPrice.get(0));
					 lblManJacketsProductPrice2.setText(listJacketsPrice.get(3));
					 lblManJacketsProductPrice3.setText(listJacketsPrice.get(1));
					 lblManJacketsProductPrice4.setText(listJacketsPrice.get(2));
		}
	public static void SortJacketsByPrice()
	{
		ArrayList<String> listJacketsName = new ArrayList<String>();
		ArrayList<String> listJacketsPrice= new ArrayList<String>();
			listJacketsName.add(lblManJacketsProduct1.getText());
			listJacketsName.add(lblManJacketsProduct2.getText());
			listJacketsName.add(lblManJacketsProduct3.getText());
			listJacketsName.add(lblManJacketsProduct4.getText());
			 Collections.sort(listJacketsName);
				 lblManJacketsProduct1.setText(listJacketsName.get(0));
				 lblManJacketsProduct2.setText(listJacketsName.get(2));
				 lblManJacketsProduct3.setText(listJacketsName.get(3));
				 lblManJacketsProduct4.setText(listJacketsName.get(1));
				 lblManJacketsProductBackground1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manJacket2.jpg"));
				 lblManJacketsProductBackground2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manJacket1.jpg"));
			     lblManJacketsProductBackground3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manJacket4.jpg"));
		         lblManJacketsProductBackground4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manJacket3.jpg"));
		      	listJacketsPrice.add(lblManJacketsProductPrice1.getText());
		      	listJacketsPrice.add(lblManJacketsProductPrice2.getText());
		      	listJacketsPrice.add(lblManJacketsProductPrice3.getText());
		      	listJacketsPrice.add(lblManJacketsProductPrice4.getText());
			         	 Collections.sort(listJacketsPrice);
					 lblManJacketsProductPrice1.setText(listJacketsPrice.get(0));
					 lblManJacketsProductPrice2.setText(listJacketsPrice.get(1));
					 lblManJacketsProductPrice3.setText(listJacketsPrice.get(2));
					 lblManJacketsProductPrice4.setText(listJacketsPrice.get(3));
	}
	public static void SortShirtsByPrice()
	{
		ArrayList<String> listShirtsName = new ArrayList<String>();
		ArrayList<String> listShirtsPrice= new ArrayList<String>();
		listShirtsName.add(lblShirtsProductName1.getText());
		listShirtsName.add(lblShirtsProductName2.getText());
		listShirtsName.add(lblShirtsProductName3.getText());
		listShirtsName.add(lblShirtsProductName4.getText());
		Collections.sort(listShirtsName);
							lblShirtsProductName1.setText(listShirtsName.get(1));
							lblShirtsProductName2.setText(listShirtsName.get(3));
							lblShirtsProductName3.setText(listShirtsName.get(2));
							lblShirtsProductName4.setText(listShirtsName.get(0));
							lblShirtsProductBackground1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manShirt3.jpg"));
							lblShirtsProductBackground2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manShirt4.jpg"));
							lblShirtsProductBackground3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manShirt2.jpg"));
							lblShirtsProductBackground4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manShirt1.jpg"));
							listShirtsPrice.add(lblShirtsProductPrice1.getText());
							listShirtsPrice.add(lblShirtsProductPrice2.getText());
							listShirtsPrice.add(lblShirtsProductPrice3.getText());
							listShirtsPrice.add(lblShirtsProductPrice4.getText());
							Collections.sort(listShirtsPrice);
							lblShirtsProductPrice1.setText(listShirtsPrice.get(0));
							lblShirtsProductPrice2.setText(listShirtsPrice.get(1));
							lblShirtsProductPrice3.setText(listShirtsPrice.get(2));
							lblShirtsProductPrice4.setText(listShirtsPrice.get(3));
	}
	public static void SortShirtsByName()
	{
		ArrayList<String> listShirtsName = new ArrayList<String>();
		ArrayList<String> listShirtsPrice= new ArrayList<String>();
		listShirtsName.add(lblShirtsProductName1.getText());
		listShirtsName.add(lblShirtsProductName2.getText());
		listShirtsName.add(lblShirtsProductName3.getText());
		listShirtsName.add(lblShirtsProductName4.getText());
		Collections.sort(listShirtsName);
							lblShirtsProductName1.setText(listShirtsName.get(0));
							lblShirtsProductName2.setText(listShirtsName.get(1));
							lblShirtsProductName3.setText(listShirtsName.get(2));
							lblShirtsProductName4.setText(listShirtsName.get(3));
							
							lblShirtsProductBackground1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manShirt1.jpg"));
							lblShirtsProductBackground2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manShirt3.jpg"));
							lblShirtsProductBackground3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manShirt2.jpg"));
							lblShirtsProductBackground4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\manShirt4.jpg"));
							listShirtsPrice.add(lblShirtsProductPrice1.getText());
							listShirtsPrice.add(lblShirtsProductPrice2.getText());
							listShirtsPrice.add(lblShirtsProductPrice3.getText());
							listShirtsPrice.add(lblShirtsProductPrice4.getText());
							Collections.sort(listShirtsPrice);
							lblShirtsProductPrice1.setText(listShirtsPrice.get(3));
							lblShirtsProductPrice2.setText(listShirtsPrice.get(0));
							lblShirtsProductPrice3.setText(listShirtsPrice.get(2));
							lblShirtsProductPrice4.setText(listShirtsPrice.get(1));
	}
	public static void SortDressByName()
	{
		ArrayList<String> listDressName = new ArrayList<String>();
		ArrayList<String> listDressPrice= new ArrayList<String>();
		listDressName.add(lblWomenDressName1.getText());
		listDressName.add(lblWomenDressName2.getText());
		listDressName.add(lblWomenDressName3.getText());
		listDressName.add(lblWomenDressName4.getText());
		Collections.sort(listDressName);
		lblWomenDressName1.setText(listDressName.get(0));
		lblWomenDressName2.setText(listDressName.get(1));
		lblWomenDressName3.setText(listDressName.get(2));
		lblWomenDressName4.setText(listDressName.get(3));
							
							lblWomenDressBackground1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\dress2.jpg"));
							lblWomenDressBackground2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\dress1.jpg"));
							lblWomenDressBackground3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\dress3.jpg"));
							lblWomenDressBackground4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\dress4.jpg"));
							listDressPrice.add(lblWomenDressPrice1.getText());
							listDressPrice.add(lblWomenDressPrice2.getText());
							listDressPrice.add(lblWomenDressPrice3.getText());
							listDressPrice.add(lblWomenDressPrice4.getText());
							Collections.sort(listDressPrice);
							lblWomenDressPrice1.setText(listDressPrice.get(3));
							lblWomenDressPrice2.setText(listDressPrice.get(2));
							lblWomenDressPrice3.setText(listDressPrice.get(1));
							lblWomenDressPrice4.setText(listDressPrice.get(0));
	}
	public static void SortDressByPrice()
	{
		ArrayList<String> listDressName = new ArrayList<String>();
		ArrayList<String> listDressPrice= new ArrayList<String>();
		listDressName.add(lblWomenDressName1.getText());
		listDressName.add(lblWomenDressName2.getText());
		listDressName.add(lblWomenDressName3.getText());
		listDressName.add(lblWomenDressName4.getText());
		Collections.sort(listDressName);
		lblWomenDressName1.setText(listDressName.get(3));
		lblWomenDressName2.setText(listDressName.get(2));
		lblWomenDressName3.setText(listDressName.get(1));
		lblWomenDressName4.setText(listDressName.get(0));
							
							lblWomenDressBackground1.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\dress4.jpg"));
							lblWomenDressBackground2.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\dress3.jpg"));
							lblWomenDressBackground3.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\dress1.jpg"));
							lblWomenDressBackground4.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\dress2.jpg"));
							listDressPrice.add(lblWomenDressPrice1.getText());
							listDressPrice.add(lblWomenDressPrice2.getText());
							listDressPrice.add(lblWomenDressPrice3.getText());
							listDressPrice.add(lblWomenDressPrice4.getText());
							Collections.sort(listDressPrice);
							lblWomenDressPrice1.setText(listDressPrice.get(0));
							lblWomenDressPrice2.setText(listDressPrice.get(1));
							lblWomenDressPrice3.setText(listDressPrice.get(2));
							lblWomenDressPrice4.setText(listDressPrice.get(3));
	}
	static void onlyNumbersAlloweed(KeyEvent evt)
	{
		char c= evt.getKeyChar();
		if(!(Character.isDigit(c))||(c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)
		{
			evt.consume();
		}
		 Toolkit.getDefaultToolkit().beep();
	}
}
