package StudentLibrary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

@SuppressWarnings("serial")
public class OrdersFrame extends JFrame {
	static JTable tableOrders= new JTable();
	JScrollPane scroller = new JScrollPane(tableOrders);
	private JPanel contentPane;
	static Connection conn=null;
	int idORDERS=0;
	static ResultSet result=null;
	static ResultSet result2=null;
	static ResultSet result3=null;
    static PreparedStatement state =null;
    static PreparedStatement state2 =null;
    static PreparedStatement state3=null;
    private final Action addToOrders = new AddToORDERS();
    @SuppressWarnings("rawtypes")
	static JComboBox searchSelection;;
    static  OrdersFrame orderframe = null;
    static JComboBox bookID ;
    static JComboBox memberID;
    private final Action goBack = new goBack();
	 static JComboBox searchSecondSelection;
	static JComboBox secondSearchComboBoxChoicees;
	private JLabel lblNewLabel;
	static JComboBox searchComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderframe = new OrdersFrame();
					orderframe.setVisible(true);
					UpdateComboBoxBook();
					UpdateComboBoxMember();
					SearchComboBooks();
					SearchComboOrders();
					 SearchComboBoxMembers();
					AutoCompleteDecorator.decorate(searchComboBox);
					AutoCompleteDecorator.decorate(secondSearchComboBoxChoicees);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public OrdersFrame() {
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setType(Type.POPUP);
		setTitle("Orders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 1124, 547);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(scroller);
		scroller.setBounds(25, 309, 1079, 166);
		tableOrders.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableOrders.addMouseListener(new TableAction());
		refreshTable(tableOrders);
		
		JLabel lblMemberORDER = new JLabel("Book");
		lblMemberORDER.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMemberORDER.setBounds(368, 86, 93, 31);
		contentPane.add(lblMemberORDER);
		
		JLabel lblBookORDER_ID = new JLabel("Member");
		lblBookORDER_ID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBookORDER_ID.setBounds(25, 91, 68, 20);
		contentPane.add(lblBookORDER_ID);
		
		JButton addToOrder = new JButton("");
		addToOrder.setOpaque(false);
		addToOrder.setBorder(new CompoundBorder());
		addToOrder.setBackground(new Color(135, 206, 235));
		addToOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addToOrder.setAction(addToOrders);
		addToOrder.setIcon(new ImageIcon(OrdersFrame.class.getResource("/resources/Icons/icons8-add-48.png")));
		addToOrder.setBounds(232, 125, 68, 53);
		
		contentPane.add(addToOrder);
		
		JButton btnClear = new JButton("Finish Order");
		btnClear.setOpaque(false);
		btnClear.setBorder(new CompoundBorder());
		btnClear.setBackground(new Color(135, 206, 235));
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClear.setBounds(543, 159, 153, 53);
		btnClear.addActionListener(new ClearOrderAction());
		btnClear.setIcon(new ImageIcon(OrdersFrame.class.getResource("/resources/Icons/clean.png")));
		contentPane.add(btnClear);
		
		searchSelection = new JComboBox();
		searchSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchComboBooks();
				SearchComboBoxMembers();
			}
		});
		
		JButton backButton = new JButton("Go Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backButton.setOpaque(false);
		backButton.setAction(goBack);
		backButton.setBorder(new CompoundBorder());
		backButton.setIcon(new ImageIcon(OrdersFrame.class.getResource("/resources/Icons/BACK.png")));
		backButton.setBackground(new Color(135, 206, 235));
		backButton.setBounds(706, 159, 174, 53);
		contentPane.add(backButton);
		searchSelection.setBackground(new Color(0, 255, 255));
		searchSelection.setModel(new DefaultComboBoxModel(new String[] {"FirstName", "LastName", "FacNum", "Headline", "Author"}));
		searchSelection.setFont(new Font("Tahoma", Font.PLAIN, 13));
		searchSelection.setBounds(35, 185, 164, 31);
		contentPane.add(searchSelection);
		
		bookID = new JComboBox();
		bookID.setBounds(320, 125, 164, 31);
		contentPane.add(bookID);
		
		searchComboBox = new JComboBox();
		searchComboBox.setBounds(35, 243, 164, 31);
		contentPane.add(searchComboBox);
		
		 secondSearchComboBoxChoicees = new JComboBox();
		secondSearchComboBoxChoicees.setBounds(320, 243, 164, 31);
		contentPane.add(secondSearchComboBoxChoicees);
		
		memberID = new JComboBox();
		memberID.setBounds(35, 123, 164, 31);
		contentPane.add(memberID);
		
		searchSecondSelection = new JComboBox();
		searchSecondSelection.setBackground(new Color(0, 255, 255));
		searchSecondSelection.setFont(new Font("Tahoma", Font.PLAIN, 13));
		searchSecondSelection.setModel(new DefaultComboBoxModel(new String[] {"Order_date"}));
		searchSecondSelection.setBounds(320, 185, 164, 31);
		contentPane.add(searchSecondSelection);
		
		JButton button = new JButton("");
		button.setOpaque(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conn = DBConnector.getConnection();
			     	String firstselection =searchSelection.getSelectedItem().toString();
			     	String secondSelection =searchSecondSelection.getSelectedItem().toString();
			     	String firstsListOFWords =searchComboBox.getSelectedItem().toString();
			     	String secondListOFWords =secondSearchComboBoxChoicees.getSelectedItem().toString();
			     	
			     		String sql = "SELECT o.ORDER_ID,o.ORDER_DATE,m.FACNUM , m.FIRSTNAME,m.LASTNAME,b.HEADLINE,b.AUTHOR \r\n" + 
						"FROM ORDERS o \r\n" + 
						"INNER JOIN MEMBERS m on o.MEMBER_ID=m.MEMMBER_ID\r\n" + 
						"INNER JOIN BOOKS b on  o.BOOK_ID=b.BOOKS_ID "+
						"WHERE "+firstselection+" like ? and "+ secondSelection+" like ?  \r\n" ;
					state = conn.prepareStatement(sql);
					state.setString(1,firstsListOFWords);
					state.setString(2,secondListOFWords);
					result = state.executeQuery();
				    tableOrders.setModel(new MyModel(result));
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
		});
		button.setIcon(new ImageIcon(OrdersFrame.class.getResource("/resources/Icons/search.png")));
		button.setBorder(new CompoundBorder());
		button.setBackground(new Color(135, 206, 235));
		button.setBounds(232, 223, 68, 51);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				refreshTable(tableOrders);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(OrdersFrame.class.getResource("/resources/Icons/Blue_gaussian_blur_1920x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 1130, 521);
		contentPane.add(lblNewLabel);

	}
	private static ResultSet getJOINFromTable() {
		conn = DBConnector.getConnection();
		String sql = "SELECT o.ORDER_ID,o.ORDER_DATE ,m.FACNUM, m.FIRSTNAME,m.LASTNAME,b.HEADLINE,b.AUTHOR \r\n" + 
				"FROM ORDERS o \r\n" + 
				"INNER JOIN MEMBERS m on o.MEMBER_ID=m.MEMMBER_ID\r\n" + 
				"INNER JOIN BOOKS b on  o.BOOK_ID=b.BOOKS_ID";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static void refreshTable(JTable table) {
		try {
			table.setModel(new MyModel(getJOINFromTable()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private class AddToORDERS extends AbstractAction {
		public AddToORDERS() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "add to the list");
		}
		public void actionPerformed(ActionEvent e) {
			String book_ID =bookID.getSelectedItem().toString().substring(0,2); 
			String MemberID =memberID.getSelectedItem().toString().substring(0,2); 
             conn=DBConnector.getConnection();
             String sql="INSERT INTO ORDERS VALUES(null,?,?,now());";
         	try {
				state= conn.prepareStatement(sql);
				state.setString(1, MemberID);
				state.setString(2, book_ID);
				state.execute();
				refreshTable(tableOrders);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
         	
		}
	}
	class TableAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableOrders.getSelectedRow();
			idORDERS = Integer.parseInt(tableOrders.getValueAt(row, 0).toString());						
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class ClearOrderAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String sql = "DELETE FROM ORDERS WHERE ORDER_ID=?;";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, idORDERS);
				state.execute();
				refreshTable(tableOrders);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	private class goBack extends AbstractAction {
		public goBack() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			LibraryFrame.libraryFrame=new LibraryFrame();
			LibraryFrame.libraryFrame.setVisible(true);
			OrdersFrame.orderframe.dispose();
		}
	}
	@SuppressWarnings("unchecked")
	static void UpdateComboBoxMember() {
		 conn = DBConnector.getConnection();
		   String sql = "SELECT * FROM MEMBERS;";
		   try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			   while(result.next()) {
				   memberID.addItem(result.getString("Memmber_id")+" "+result.getString("FirstName")+" "+result.getString("LastName"));
				 
			    }
			   refreshTable(MembersFrame.tableMembers);
		} catch (Exception e) {
			// TODO: handle exception
	}
	}
   @SuppressWarnings("unchecked")
static  void UpdateComboBoxBook() {
	   conn = DBConnector.getConnection();
	   String sql = "SELECT * FROM BOOKS;";
	   try { 
		state=conn.prepareStatement(sql);
		result=state.executeQuery();
		   while(result.next()) {
			   bookID.addItem(result.getString("Books_id")+" "+result.getString("HEADLINE"));
		    }
			refreshTable(BooksFrame.tableBooks);
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
   @SuppressWarnings("unchecked")
   static  void SearchComboBooks() {
   	   conn = DBConnector.getConnection();
   	   String sqlBook = "SELECT * FROM BOOKS;";
   	  
   	   try { 
   		  state=conn.prepareStatement(sqlBook);
   		  result=state.executeQuery();
   		  while(result.next()) {
   			  if(searchSelection.getSelectedItem().equals("Author")) {
   				 searchComboBox.addItem(result.getString("Author"));
   				 searchComboBox.removeItem(result.getString("Headline"));
   			  }else if(searchSelection.getSelectedItem().equals("Headline")) {
   				 searchComboBox.addItem(result.getString("Headline"));
   			     searchComboBox.removeItem(result.getString("Author"));
   			  }
   		
   		    }
   			refreshTable(BooksFrame.tableBooks);
   	} catch (Exception e) {
   		// TODO: handle exception
   	}
   	}
   @SuppressWarnings("unchecked")
   static  void SearchComboOrders() {
   	   conn = DBConnector.getConnection();
   	   String sqlorder = "SELECT * FROM Orders;";
   	  
   	   try { 
   		  state=conn.prepareStatement(sqlorder);
   		  result=state.executeQuery();
   		  while(result.next()) {
   			  if(searchSecondSelection.getSelectedItem().equals("Order_date")) {
   				secondSearchComboBoxChoicees.addItem(result.getString("Order_Date"));
   		    }
   		  }
   	} catch (Exception e) {
   		// TODO: handle exception
   	}
   	}
   @SuppressWarnings("unchecked")
   static  void SearchComboBoxMembers() {
   	   conn = DBConnector.getConnection();
   	   String sqlMembers = "SELECT * FROM Members;";
   	   try { 
   		   
   		  state=conn.prepareStatement(sqlMembers);
   		  result=state.executeQuery();
   		  while(result.next()) {
   			  if(searchSelection.getSelectedItem().equals("FirstName")) {
   				 searchComboBox.addItem(result.getString("Firstname"));
   				 searchComboBox.removeItem(result.getString("LastName"));
   				 searchComboBox.removeItem(result.getString("FacNum"));
   			  }else if(searchSelection.getSelectedItem().equals("LastName")) {
   				 searchComboBox.addItem(result.getString("LastName"));
   			     searchComboBox.removeItem(result.getString("Firstname"));
   			    searchComboBox.removeItem(result.getString("FacNum"));
   			  }else if(searchSelection.getSelectedItem().equals("FacNum")) {
    				 searchComboBox.addItem(result.getString("FacNum"));
       			     searchComboBox.removeItem(result.getString("Firstname"));
       			  searchComboBox.removeItem(result.getString("LastName"));
   			  }
   		
   		    }
   			refreshTable(MembersFrame.tableMembers);
   	} catch (Exception e) {
   	}
   	}
   
}
