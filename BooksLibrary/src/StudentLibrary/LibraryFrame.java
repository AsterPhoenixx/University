package StudentLibrary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.Calendar;
import java.util.GregorianCalendar;
@SuppressWarnings("serial")
public class LibraryFrame extends JFrame {

	private JPanel contentPanel;
	private final Action bookAdd = new BooksAdd();
	private final Action memberAdd = new MemberAdd();
	private final Action orderAdd = new OrderAdd();
    static LibraryFrame libraryFrame=null;
    int timeRun=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
				   
					libraryFrame = new LibraryFrame();
					libraryFrame.setVisible(true); 
 				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibraryFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JULIEN\\Uni\\Java\\BooksLibrary\\Icons\\Library icon icon.png"));
		setTitle("Library");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 150, 836, 253);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JButton booksButtonLibraryFrame = new JButton("Books");
		booksButtonLibraryFrame.setOpaque(false);
		booksButtonLibraryFrame.setBorder(new CompoundBorder());
		booksButtonLibraryFrame.setBackground(new Color(135, 206, 235));
		booksButtonLibraryFrame.setAction(bookAdd);
		booksButtonLibraryFrame.setIcon(new ImageIcon(LibraryFrame.class.getResource("/resources/Icons/icons8-add-book-96.png")));
		booksButtonLibraryFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		booksButtonLibraryFrame.setBounds(37, 71, 199, 105);
		contentPanel.add(booksButtonLibraryFrame);
		
		JButton membersButtonLibraryFrame = new JButton("Members");
		membersButtonLibraryFrame.setOpaque(false);
		membersButtonLibraryFrame.setBackground(new Color(135, 206, 235));
		membersButtonLibraryFrame.setBorder(new CompoundBorder());
		membersButtonLibraryFrame.setAction(memberAdd);
		membersButtonLibraryFrame.setIcon(new ImageIcon(LibraryFrame.class.getResource("/resources/Icons/members.png")));
		membersButtonLibraryFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		membersButtonLibraryFrame.setBounds(289, 71, 205, 105);
		contentPanel.add(membersButtonLibraryFrame);
		
		JButton ordersButtonLibraryFrame = new JButton("Orders");
		ordersButtonLibraryFrame.setOpaque(false);
		ordersButtonLibraryFrame.setBackground(new Color(135, 206, 235));
		ordersButtonLibraryFrame.setBorder(new CompoundBorder());
		ordersButtonLibraryFrame.setAction(orderAdd);
		ordersButtonLibraryFrame.setIcon(new ImageIcon(LibraryFrame.class.getResource("/resources/Icons/orders.png")));
		ordersButtonLibraryFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ordersButtonLibraryFrame.setBounds(555, 71, 205, 105);
		contentPanel.add(ordersButtonLibraryFrame);
		
		JLabel clockLb = new JLabel("");
		clockLb.setForeground(new Color(25, 25, 112));
		clockLb.setFont(new Font("Digital-7", Font.PLAIN, 25));
		clockLb.setHorizontalAlignment(SwingConstants.CENTER);
		clockLb.setBounds(470, -13, 230, 73);
		contentPanel.add(clockLb);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LibraryFrame.class.getResource("/resources/Icons/Blue_gaussian_blur_1920x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 830, 227);
		contentPanel.add(lblNewLabel);
		
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
				    clockLb.setText(dateTime);
				}   
			}
		}.start();
		
	}
	private class BooksAdd extends AbstractAction {
		public BooksAdd() {
			putValue(NAME, "Books");
			putValue(SHORT_DESCRIPTION, "Here is the information of every Books");
		}
		public void actionPerformed(ActionEvent e) {
			
			BooksFrame.booksFrame = new BooksFrame();
			BooksFrame.booksFrame.setVisible(true);
			LibraryFrame.libraryFrame.dispose();
			
		}
	}
	private class MemberAdd extends AbstractAction {
		public MemberAdd() {
			putValue(NAME, "Members");
			putValue(SHORT_DESCRIPTION, "Create new Member");
		}
		public void actionPerformed(ActionEvent e) {
			MembersFrame.membersFrame = new MembersFrame();
			MembersFrame.membersFrame.setVisible(true);
			LibraryFrame.libraryFrame.dispose();
			 
		}
	}
	private class OrderAdd extends AbstractAction {
		public OrderAdd() {
			putValue(NAME, "Orders");
			putValue(SHORT_DESCRIPTION, "Create new Order");
		}
		public void actionPerformed(ActionEvent e) {
			OrdersFrame.orderframe = new OrdersFrame();
			OrdersFrame.orderframe.setVisible(true);
			LibraryFrame.libraryFrame.dispose();
		    OrdersFrame.UpdateComboBoxBook();
			OrdersFrame.UpdateComboBoxMember();
			OrdersFrame.SearchComboOrders();
			OrdersFrame. SearchComboBoxMembers();
		}
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
	static void onlyNumbersAlloweedandDote(KeyEvent evt)
	{
		char c= evt.getKeyChar();
		if((Character.isLetter(c))&&!evt.isAltDown())
		{
			evt.consume();
		}
		 Toolkit.getDefaultToolkit().beep();
	}
	static void onlyLettersAlloweedand(KeyEvent evt)
	{
		char c=evt.getKeyChar();

	    if((Character.isLetter(c) || (Character.isWhitespace(c)))) {
	    	evt = evt;
	        }
	        else {

	        	evt.consume();
	        }

	}

}
