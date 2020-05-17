package StudentLibrary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AddBookFrame extends JFrame   {
	private JPanel contentPane;
	private JTextField headlineTextFieldAd;
	private JTextField authorTextFieldAdBookFrame;
	private JTextField publisherTextFieldAdBookFrame;
	private JTextField priceTextFieldAddBookFrame;
	private JTextField yearTextFieldAddBookFrame;
	private final Action action = new AddBookToDB();
	ResultSet result=null;
    Connection conn=null;
    PreparedStatement state =null;
    static AddBookFrame addBookFrame = null;
    private JButton btnGoback;
    private final Action action_1 = new GoBacktoBook();
    private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addBookFrame = new AddBookFrame();
					addBookFrame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddBookFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JULIEN\\Uni\\Java\\BooksLibrary\\Icons\\book icon icon.png"));
		setTitle("AddBook");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 100,687, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headlineLabelAddbookFrame = new JLabel("Headline:");
		headlineLabelAddbookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headlineLabelAddbookFrame.setBounds(51, 51, 142, 27);
		contentPane.add(headlineLabelAddbookFrame);
		
		JLabel authorLabelAddbookFrame = new JLabel("Author:");
		authorLabelAddbookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		authorLabelAddbookFrame.setBounds(51, 114, 142, 27);
		contentPane.add(authorLabelAddbookFrame);
		
		JLabel publisherLabelAddBookFrame = new JLabel("Publisher:");
		publisherLabelAddBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		publisherLabelAddBookFrame.setBounds(51, 179, 142, 27);
		contentPane.add(publisherLabelAddBookFrame);
		
		JLabel yearLabelAddBookFrame = new JLabel("Year:");
		yearLabelAddBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		yearLabelAddBookFrame.setBounds(51, 289, 142, 27);
		contentPane.add(yearLabelAddBookFrame);
		
		JLabel priceLabelAddBookFrame = new JLabel("Price:");
		priceLabelAddBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceLabelAddBookFrame.setBounds(51, 231, 142, 27);
		contentPane.add(priceLabelAddBookFrame);
		
		headlineTextFieldAd = new JTextField();
		headlineTextFieldAd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		headlineTextFieldAd.setBounds(164, 51, 294, 27);
		contentPane.add(headlineTextFieldAd);
		headlineTextFieldAd.setColumns(10);
		
		authorTextFieldAdBookFrame = new JTextField();
		authorTextFieldAdBookFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyLettersAlloweedand(e);
			}
		});
		authorTextFieldAdBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		authorTextFieldAdBookFrame.setColumns(10);
		authorTextFieldAdBookFrame.setBounds(164, 115, 294, 27);
		contentPane.add(authorTextFieldAdBookFrame);
		
		publisherTextFieldAdBookFrame = new JTextField();
		publisherTextFieldAdBookFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyLettersAlloweedand(e);
			}
		});
		publisherTextFieldAdBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		publisherTextFieldAdBookFrame.setColumns(10);
		publisherTextFieldAdBookFrame.setBounds(164, 179, 294, 27);
		contentPane.add(publisherTextFieldAdBookFrame);
		
		priceTextFieldAddBookFrame = new JTextField();
		priceTextFieldAddBookFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				LibraryFrame.onlyNumbersAlloweedandDote(e);
			}
		});
		priceTextFieldAddBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		priceTextFieldAddBookFrame.setColumns(10);
		priceTextFieldAddBookFrame.setBounds(164, 232, 294, 27);
		contentPane.add(priceTextFieldAddBookFrame);
		
		yearTextFieldAddBookFrame = new JTextField();
		yearTextFieldAddBookFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyNumbersAlloweed(e);
			}
		});
		yearTextFieldAddBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yearTextFieldAddBookFrame.setColumns(10);
		yearTextFieldAddBookFrame.setBounds(164, 290, 294, 27);
		contentPane.add(yearTextFieldAddBookFrame);
		
		JButton addBookButtonAddBookFrame = new JButton("Add Book");
		addBookButtonAddBookFrame.setOpaque(false);
		addBookButtonAddBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addBookButtonAddBookFrame.setBorder(new CompoundBorder());
		addBookButtonAddBookFrame.setBackground(new Color(135, 206, 235));
		addBookButtonAddBookFrame.setAction(action);
		addBookButtonAddBookFrame.setIcon(new ImageIcon(AddBookFrame.class.getResource("/resources/Icons/ADD.png")));
		addBookButtonAddBookFrame.setBounds(500, 68, 133, 58);
		contentPane.add(addBookButtonAddBookFrame);
		
		btnGoback = new JButton("GoBack");
		btnGoback.setOpaque(false);
		btnGoback.setBackground(new Color(135, 206, 235));
		btnGoback.setBorder(new CompoundBorder());
		btnGoback.setAction(action_1);
		btnGoback.setIcon(new ImageIcon(AddBookFrame.class.getResource("/resources/Icons/BACK.png")));
		btnGoback.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGoback.setBounds(500, 243, 133, 58);
		contentPane.add(btnGoback);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddBookFrame.class.getResource("/resources/Icons/Blue_gaussian_blur_1920x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 681, 379);
		contentPane.add(lblNewLabel);
	}
	private void resetForm() {
		headlineTextFieldAd.setText("");
		authorTextFieldAdBookFrame.setText("");
		publisherTextFieldAdBookFrame.setText("");
		priceTextFieldAddBookFrame.setText("");
		yearTextFieldAddBookFrame.setText("");
	}
	private class AddBookToDB extends AbstractAction {
		
		public AddBookToDB() {
			putValue(NAME, "Add Book");
			putValue(SHORT_DESCRIPTION, "Add information book to table");
		}
		public void actionPerformed(ActionEvent e) {
             BooksFrame.booksFrame = new BooksFrame();
			 BooksFrame.booksFrame.setVisible(true);
			 AddBookFrame.addBookFrame.dispose();	
             String addHeadline=headlineTextFieldAd.getText();
             String addAuthor=authorTextFieldAdBookFrame.getText();
             String addPublisher=publisherTextFieldAdBookFrame.getText();
             float addPrice=Float.parseFloat(priceTextFieldAddBookFrame.getText());
             int addYear=Integer.parseInt(yearTextFieldAddBookFrame.getText());
             conn=DBConnector.getConnection();
             String sql="INSERT INTO BOOKS VALUES(null,?,?,?,?,?);";
             try {
				state= conn.prepareStatement(sql);
				state.setString(1, addHeadline);
				state.setString(2, addAuthor);
				state.setString(3, addPublisher);
				state.setFloat(4, addPrice);
				state.setInt(5, addYear);
				state.execute();
				resetForm();
				refreshTable(BooksFrame.tableBooks, "BOOKS");
				JOptionPane.showMessageDialog(null,"Successfully added "+ addHeadline +" book into the Library");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Some of the fields"
						+ " are empty. Try again!","Warning",JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			}
		}
	}
	private ResultSet getAllFromTable(String tableName) {
		conn = DBConnector.getConnection();
		String sql = "select * from " + tableName;
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private void refreshTable(JTable table, String tableName) {
		try {
			table.setModel(new MyModel(getAllFromTable(tableName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class GoBacktoBook extends AbstractAction {
		public GoBacktoBook() {
			putValue(NAME, "Go Back");
			putValue(SHORT_DESCRIPTION, "return to Book menu");
		}
		public void actionPerformed(ActionEvent e) {
			 BooksFrame.booksFrame = new BooksFrame();
			 BooksFrame.booksFrame.setVisible(true);
			 AddBookFrame.addBookFrame.dispose();
		}
	}
}
