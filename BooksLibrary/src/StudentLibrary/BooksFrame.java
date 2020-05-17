package StudentLibrary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BooksFrame extends JFrame {
	static JTable tableBooks = new JTable();
	JScrollPane scroller = new JScrollPane(tableBooks);
	static int idBOOKS = 0;
	private JPanel contentPanel;
    Connection conn=null;
    PreparedStatement state=null;
    ResultSet result=null;
    private final Action add = new PopUpAddBook();
    private final Action goBack = new GoBack();
    static  BooksFrame booksFrame =null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booksFrame = new BooksFrame();
					booksFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BooksFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JULIEN\\Uni\\Java\\BooksLibrary\\Icons\\book shelf, books icon icon.png"));
		setType(Type.POPUP);
		setTitle("Books");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 100,720, 400);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.add(scroller);
		scroller.setBounds(32, 36, 659, 166);
		tableBooks.addMouseListener(new TableAction());
		refreshTable(tableBooks, "BOOKS");
		
		
		JButton addBookButtonBooksFrame = new JButton("");
		addBookButtonBooksFrame.setOpaque(false);
		addBookButtonBooksFrame.setBorder(new CompoundBorder());
		addBookButtonBooksFrame.setBackground(new Color(135, 206, 235));
		addBookButtonBooksFrame.setAction(add);
		addBookButtonBooksFrame.setIcon(new ImageIcon(BooksFrame.class.getResource("/resources/Icons/icons8-add-48.png")));
		addBookButtonBooksFrame.setBounds(69, 239, 129, 48);
		contentPanel.add(addBookButtonBooksFrame);
		
		JButton editBookButtonBooksFrame = new JButton("Edit");
		editBookButtonBooksFrame.setOpaque(false);
		editBookButtonBooksFrame.setBorder(new CompoundBorder());
		editBookButtonBooksFrame.setBackground(new Color(135, 206, 235));
		editBookButtonBooksFrame.setIcon(new ImageIcon(BooksFrame.class.getResource("/resources/Icons/EDIT.png")));
		editBookButtonBooksFrame.setBounds(231, 239, 99, 48);
		editBookButtonBooksFrame.addActionListener(new EditAction());
		contentPanel.add(editBookButtonBooksFrame);
		
		JButton deleteBookButtonBooks = new JButton("Delete");
		deleteBookButtonBooks.setOpaque(false);
		deleteBookButtonBooks.setBorder(new CompoundBorder());
		deleteBookButtonBooks.setBackground(new Color(135, 206, 235));
		deleteBookButtonBooks.setIcon(new ImageIcon(BooksFrame.class.getResource("/resources/Icons/DELETE.png")));
		deleteBookButtonBooks.setBounds(389, 239, 111, 48);
		deleteBookButtonBooks.addActionListener(new DeleteBookAction());
		contentPanel.add(deleteBookButtonBooks);
		
		JButton btnGoBack = new JButton("");
		btnGoBack.setOpaque(false);
		btnGoBack.setBorder(new CompoundBorder());
		btnGoBack.setBackground(new Color(135, 206, 235));
		btnGoBack.setAction(goBack);
		btnGoBack.setIcon(new ImageIcon(BooksFrame.class.getResource("/resources/Icons/BACK.png")));
		btnGoBack.setBounds(530, 239, 111, 48);
		contentPanel.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BooksFrame.class.getResource("/resources/Icons/Blue_gaussian_blur_1920x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 714, 374);
		contentPanel.add(lblNewLabel);
	}
	private void refreshTable(JTable table, String tableName) {
		try {
			table.setModel(new MyModel(getAllFromTable(tableName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	class TableAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableBooks.getSelectedRow();
			idBOOKS = Integer.parseInt(tableBooks.getValueAt(row, 0).toString());						
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
	private class PopUpAddBook extends AbstractAction {
		public PopUpAddBook() {
			putValue(NAME, "Add Book");
			putValue(SHORT_DESCRIPTION, "Add new book");
		}
		public void actionPerformed(ActionEvent e) {
			AddBookFrame.addBookFrame = new AddBookFrame();
			AddBookFrame.addBookFrame.setVisible(true);
			BooksFrame.booksFrame.dispose();
		}
	}
	class DeleteBookAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String sql = "DELETE FROM BOOKS WHERE BOOKS_ID=?;";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, idBOOKS);
				state.execute();
				refreshTable(tableBooks, "BOOKS");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "You cant delete a book, where is used!");
			}
			
		}
	}
	class EditAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			EditBookFrame.editBookFrame = new EditBookFrame();
			EditBookFrame.editBookFrame.setVisible(true);
			BooksFrame.booksFrame.dispose();
			String editHeadline="HEADLINE";   
			String editAuthor="AUTHOR";
			String editPublisher="PUBLISHER";
			String editPrice="PRICE";
			String editYear="YEAR";
			conn = DBConnector.getConnection();
			String sql = "SELECT * FROM BOOKS WHERE BOOKS_ID=?;";
			try {
			   state = conn.prepareStatement(sql);
			   state.setInt(1, idBOOKS);
			   state.executeQuery();
			   result=state.executeQuery();
				if(result.next())
				{
					 EditBookFrame.headlineTextFieldEditFrame.setText(result.getString(editHeadline));
					 EditBookFrame.authorTextFieldEditFrame.setText(result.getString(editAuthor));
					 EditBookFrame.publisherTextFieldEditFrame.setText(result.getString(editPublisher));
					 EditBookFrame.priceTextFieldEditFrame.setText(result.getString(editPrice));
					 EditBookFrame.yearTextFieldEditFrame.setText(result.getString(editYear));
				}
				refreshTable(tableBooks, "BOOKS");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class GoBack extends AbstractAction {
		public GoBack() {
			putValue(NAME, "Go back");
			putValue(SHORT_DESCRIPTION, "Return to main menu");
		}
		public void actionPerformed(ActionEvent e) {
			LibraryFrame.libraryFrame= new LibraryFrame();
		    LibraryFrame.libraryFrame.setVisible(true);
		    BooksFrame.booksFrame.dispose();
		}
	}
}
