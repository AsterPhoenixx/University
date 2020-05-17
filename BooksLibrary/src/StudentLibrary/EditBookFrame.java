package StudentLibrary;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class EditBookFrame extends JFrame {

	private JPanel contentPane;
	static JTextField headlineTextFieldEditFrame;
	static JTextField authorTextFieldEditFrame;
	static JTextField publisherTextFieldEditFrame;
	static JTextField priceTextFieldEditFrame;
	static JTextField yearTextFieldEditFrame;
	ResultSet result=null;
    Connection conn=null;
    PreparedStatement state =null;
	private final Action action = new UpdateBook();
	 static EditBookFrame editBookFrame = null; 
	 private JButton btnGoBack;
	 private final Action goback = new GoBackToBook();
	 private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editBookFrame = new EditBookFrame();
					editBookFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditBookFrame() {
		setType(Type.POPUP);
		setTitle("Edit Book");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JULIEN\\Uni\\Java\\BooksLibrary\\Icons\\Books Shelf icon icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 100,714, 405);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		 
		JLabel headlineLabelEditbookFrame = new JLabel("Headline:");
		headlineLabelEditbookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headlineLabelEditbookFrame.setBounds(60, 49, 142, 27);
		contentPane.add(headlineLabelEditbookFrame);
		
		JLabel authorLabelEditbookFrame = new JLabel("Author:");
		authorLabelEditbookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		authorLabelEditbookFrame.setBounds(60, 111, 142, 27);
		contentPane.add(authorLabelEditbookFrame);
		
		JLabel publisherLabelEditbookFrame = new JLabel("Publisher:");
		publisherLabelEditbookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		publisherLabelEditbookFrame.setBounds(60, 170, 142, 27);
		contentPane.add(publisherLabelEditbookFrame);
		
		JLabel yearLabelEditbookFrame = new JLabel("Year:");
		yearLabelEditbookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		yearLabelEditbookFrame.setBounds(60, 298, 142, 27);
		contentPane.add(yearLabelEditbookFrame);
		
		JLabel priceLabelEditbookFrame = new JLabel("Price:");
		priceLabelEditbookFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceLabelEditbookFrame.setBounds(60, 233, 142, 27);
		contentPane.add(priceLabelEditbookFrame);
		
		headlineTextFieldEditFrame = new JTextField();
		headlineTextFieldEditFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		headlineTextFieldEditFrame.setBounds(187, 49, 294, 27);
		contentPane.add(headlineTextFieldEditFrame);
		headlineTextFieldEditFrame.setColumns(10);
		
		authorTextFieldEditFrame = new JTextField();
		authorTextFieldEditFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyLettersAlloweedand(e);
			}
		});
		authorTextFieldEditFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		authorTextFieldEditFrame.setColumns(10);
		authorTextFieldEditFrame.setBounds(187, 117, 294, 27);
		contentPane.add(authorTextFieldEditFrame);
		
		publisherTextFieldEditFrame = new JTextField();
		publisherTextFieldEditFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyLettersAlloweedand(e);
			}
		});
		publisherTextFieldEditFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		publisherTextFieldEditFrame.setColumns(10);
		publisherTextFieldEditFrame.setBounds(187, 176, 294, 27);
		contentPane.add(publisherTextFieldEditFrame);
		
		priceTextFieldEditFrame = new JTextField();
		priceTextFieldEditFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyNumbersAlloweedandDote(e);
			}
		});
		priceTextFieldEditFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		priceTextFieldEditFrame.setColumns(10);
		priceTextFieldEditFrame.setBounds(187, 239, 294, 27);
		contentPane.add(priceTextFieldEditFrame);
		
		yearTextFieldEditFrame = new JTextField();
		yearTextFieldEditFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyNumbersAlloweed(e);
			}
		});
		yearTextFieldEditFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yearTextFieldEditFrame.setColumns(10);
		yearTextFieldEditFrame.setBounds(187, 298, 294, 27);
		contentPane.add(yearTextFieldEditFrame);
		
		JButton editBookButtonEditBookFrame = new JButton("Edit Book");
		editBookButtonEditBookFrame.setOpaque(false);
		editBookButtonEditBookFrame.setBorder(new CompoundBorder());
		editBookButtonEditBookFrame.setBackground(new Color(135, 206, 235));
		editBookButtonEditBookFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editBookButtonEditBookFrame.setAction(action);
		editBookButtonEditBookFrame.setIcon(new ImageIcon(EditBookFrame.class.getResource("/resources/Icons/update.png")));
		editBookButtonEditBookFrame.setBounds(519, 67, 133, 58);
		contentPane.add(editBookButtonEditBookFrame);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setOpaque(false);
		btnGoBack.setBorder(new CompoundBorder());
		btnGoBack.setBackground(new Color(135, 206, 235));
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGoBack.setAction(goback);
		btnGoBack.setIcon(new ImageIcon(EditBookFrame.class.getResource("/resources/Icons/BACK.png")));
		btnGoBack.setBounds(519, 255, 133, 58);
		contentPane.add(btnGoBack);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditBookFrame.class.getResource("/resources/Icons/Blue_gaussian_blur_1920x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 708, 379);
		contentPane.add(lblNewLabel);
		
	}
	
	class TableAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = BooksFrame.tableBooks.getSelectedRow();
			BooksFrame.idBOOKS = Integer.parseInt(BooksFrame.tableBooks.getValueAt(row, 0).toString());						
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
	private class UpdateBook extends AbstractAction {
		public UpdateBook() {
			putValue(NAME, "Update");
			putValue(SHORT_DESCRIPTION, "Change the book information");
		}
		public void actionPerformed(ActionEvent e) {
				 BooksFrame.booksFrame = new BooksFrame();
				 BooksFrame.booksFrame.setVisible(true);
				 EditBookFrame.editBookFrame.dispose();
			     String editHeadline=headlineTextFieldEditFrame.getText();
	             String editAuthor=authorTextFieldEditFrame.getText();
	             String editPublisher=publisherTextFieldEditFrame.getText();
	             float editPrice=Float.parseFloat(priceTextFieldEditFrame.getText());
	             int editYear=Integer.parseInt(yearTextFieldEditFrame.getText());
	             conn=DBConnector.getConnection();
	             String sql="UPDATE BOOKS SET HEADLINE=?, AUTHOR=?, "
	             		+ "PUBLISHER=?, PRICE=?,YEAR=? WHERE BOOKS_ID=?;";
	             try {
					state= conn.prepareStatement(sql);
					state.setString(1, editHeadline);
					state.setString(2, editAuthor);
					state.setString(3, editPublisher);
					state.setFloat(4, editPrice);
					state.setInt(5, editYear);
					state.setInt(6, BooksFrame.idBOOKS);
					state.execute();
					refreshTable(BooksFrame.tableBooks, "BOOKS");
				} catch (SQLException e1) {
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
	private class GoBackToBook extends AbstractAction {
		public GoBackToBook() {
			putValue(NAME, "Go Back");
			putValue(SHORT_DESCRIPTION, "Return to Book menu");
		}
		public void actionPerformed(ActionEvent e) {
			 BooksFrame.booksFrame = new BooksFrame();
			 BooksFrame.booksFrame.setVisible(true);
			 EditBookFrame.editBookFrame.dispose();
		}
	}
}
