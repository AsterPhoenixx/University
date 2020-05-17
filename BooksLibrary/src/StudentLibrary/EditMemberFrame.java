package StudentLibrary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@SuppressWarnings("serial")
public class EditMemberFrame extends JFrame {

	private JPanel editMemberFrameContentPanel;
	static JTextField  firstNameTextFieldEditMemberFrame;
	static JTextField lastNameTextFieldEditMemberFrame;
	static JTextField facNummTextFieldEditMemberFrame;
	static JTextField emailTextFieldEditMemberFrame;
	static JTextField telephoneTextFieldEditMemberFrame;
	@SuppressWarnings("rawtypes")
	static JComboBox editSpecialitiesComboBox;
	@SuppressWarnings("rawtypes")
	static JComboBox editSexcomboBox;
	ResultSet result=null;
    Connection conn=null;
    PreparedStatement state =null;
	private final Action updateMember = new UpdateMember();
	static EditMemberFrame editMemberFrame = null;
	private JButton btnGoback;
	private final Action goBackMember = new GoBackMember();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editMemberFrame = new EditMemberFrame();
					editMemberFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EditMemberFrame() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("EditMember");
		setBounds(240, 100,687,530);
		editMemberFrameContentPanel = new JPanel();
		editMemberFrameContentPanel.setBackground(new Color(135, 206, 235));
		editMemberFrameContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(editMemberFrameContentPanel);
		editMemberFrameContentPanel.setLayout(null);
		
		JLabel firstNameLabelEditMemberFrame = new JLabel("First Name:");
		firstNameLabelEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameLabelEditMemberFrame.setBounds(55, 51, 97, 30);
		editMemberFrameContentPanel.add(firstNameLabelEditMemberFrame);
		
		JLabel lastNameLabelEditMemberFrame = new JLabel("Last Name:");
		lastNameLabelEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastNameLabelEditMemberFrame.setBounds(55, 112, 97, 30);
		editMemberFrameContentPanel.add(lastNameLabelEditMemberFrame);
		
		JLabel fakNummerLabelEditMemberFrame = new JLabel("Fac\u2116:");
		fakNummerLabelEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fakNummerLabelEditMemberFrame.setBounds(55, 172, 97, 30);
		editMemberFrameContentPanel.add(fakNummerLabelEditMemberFrame);
		
		JLabel specialtyLabelEditMemberFrame = new JLabel("Specialty");
		specialtyLabelEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		specialtyLabelEditMemberFrame.setBounds(55, 241, 97, 30);
		editMemberFrameContentPanel.add(specialtyLabelEditMemberFrame);
		
		JLabel sexLabelEditMemberFrame = new JLabel("Sex:");
		sexLabelEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sexLabelEditMemberFrame.setBounds(55, 301, 97, 30);
		editMemberFrameContentPanel.add(sexLabelEditMemberFrame);
		
		JLabel emailLabelEditMemberFrame = new JLabel("Email:");
		emailLabelEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailLabelEditMemberFrame.setBounds(55, 358, 97, 30);
		editMemberFrameContentPanel.add(emailLabelEditMemberFrame);
		
		JLabel telLabelEditMemberFrame = new JLabel("Telephone:");
		telLabelEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		telLabelEditMemberFrame.setBounds(55, 412, 97, 30);
		editMemberFrameContentPanel.add(telLabelEditMemberFrame);
		
	    firstNameTextFieldEditMemberFrame = new JTextField();
	    firstNameTextFieldEditMemberFrame.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyTyped(KeyEvent e) {
	    		LibraryFrame.onlyLettersAlloweedand(e);
	    	}
	    });
		firstNameTextFieldEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameTextFieldEditMemberFrame.setBounds(203, 51, 263, 30);
		editMemberFrameContentPanel.add(firstNameTextFieldEditMemberFrame);
		firstNameTextFieldEditMemberFrame.setColumns(10);
		
		lastNameTextFieldEditMemberFrame = new JTextField();
		lastNameTextFieldEditMemberFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyLettersAlloweedand(e);
			}
		});
		lastNameTextFieldEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameTextFieldEditMemberFrame.setColumns(10);
		lastNameTextFieldEditMemberFrame.setBounds(203, 111, 263, 30);
		editMemberFrameContentPanel.add(lastNameTextFieldEditMemberFrame);
		
		facNummTextFieldEditMemberFrame = new JTextField();
		facNummTextFieldEditMemberFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			LibraryFrame.onlyNumbersAlloweed(e);
			}
		});
		facNummTextFieldEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		facNummTextFieldEditMemberFrame.setColumns(10);
		facNummTextFieldEditMemberFrame.setBounds(203, 171, 263, 30);
		editMemberFrameContentPanel.add(facNummTextFieldEditMemberFrame);
		
		editSpecialitiesComboBox = new JComboBox();
		editSpecialitiesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editSpecialitiesComboBox.setModel(new DefaultComboBoxModel(new String[] {"Software technologies and design", "Business IT", "Informatics", "Software engineering", "Mathematics", "Mathematics, Informatics and Information Technologies", "Applied Mathematics", "Business Mathematics", "Information Technology, Mathematics and Educational Management"}));
		editSpecialitiesComboBox.setBounds(206, 236, 260, 40);
		editMemberFrameContentPanel.add(editSpecialitiesComboBox);
		

		
		emailTextFieldEditMemberFrame = new JTextField();
		emailTextFieldEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTextFieldEditMemberFrame.setBounds(206, 358, 260, 30);
		editMemberFrameContentPanel.add(emailTextFieldEditMemberFrame);
		emailTextFieldEditMemberFrame.setColumns(10);
		
		telephoneTextFieldEditMemberFrame = new JTextField();
		telephoneTextFieldEditMemberFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyNumbersAlloweed(e);
			}
		});
		telephoneTextFieldEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		telephoneTextFieldEditMemberFrame.setColumns(10);
		telephoneTextFieldEditMemberFrame.setBounds(206, 412, 260, 30);
		editMemberFrameContentPanel.add(telephoneTextFieldEditMemberFrame);
		
		JButton editMemberButtonEditMemberFrame = new JButton("Done");
		editMemberButtonEditMemberFrame.setOpaque(false);
		editMemberButtonEditMemberFrame.setBorder(new CompoundBorder());
		editMemberButtonEditMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editMemberButtonEditMemberFrame.setAction(updateMember);
		editMemberButtonEditMemberFrame.setIcon(new ImageIcon(EditMemberFrame.class.getResource("/resources/Icons/update.png")));
		editMemberButtonEditMemberFrame.setBounds(495, 73, 133, 56);
		editMemberFrameContentPanel.add(editMemberButtonEditMemberFrame);
		
		editSexcomboBox = new JComboBox();
		editSexcomboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editSexcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		editSexcomboBox.setBounds(206, 298, 259, 40);
		editMemberFrameContentPanel.add(editSexcomboBox);
		
		btnGoback = new JButton("GoBack");
		btnGoback.setOpaque(false);
		btnGoback.setBorder(new CompoundBorder());
		btnGoback.setBackground(new Color(135, 206, 235));
		btnGoback.setAction(goBackMember);
		btnGoback.setIcon(new ImageIcon(EditMemberFrame.class.getResource("/resources/Icons/BACK.png")));
		btnGoback.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoback.setBounds(495, 372, 133, 56);
		editMemberFrameContentPanel.add(btnGoback);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditMemberFrame.class.getResource("/resources/Icons/Blue_gaussian_blur_1920x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 681, 504);
		editMemberFrameContentPanel.add(lblNewLabel);
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
	private class UpdateMember extends AbstractAction {
		public UpdateMember() {
			putValue(NAME, "Update");
			putValue(SHORT_DESCRIPTION, "Change the book information");
		}
		public void actionPerformed(ActionEvent e) {
			 MembersFrame.membersFrame =new MembersFrame();
	 			 MembersFrame.membersFrame.setVisible(true);
	 			 EditMemberFrame.editMemberFrame.dispose();
			     String editfn=firstNameTextFieldEditMemberFrame.getText();
	             String editln=lastNameTextFieldEditMemberFrame.getText();
	             String editfacn=facNummTextFieldEditMemberFrame.getText();
	             String editspec=editSpecialitiesComboBox.getSelectedItem().toString();
	             String editSex=editSexcomboBox.getSelectedItem().toString();
	             String editTel=telephoneTextFieldEditMemberFrame.getText();
	             String email=emailTextFieldEditMemberFrame.getText();
	             conn=DBConnector.getConnection();
	             String sql="UPDATE MEMBERS SET FIRSTNAME=?, LASTNAME=?, "
	             		+ "FACNUM=?, SPECIALTY=?,SEX=? ,EMAIL=? ,TELEPHONE=? WHERE MEMMBER_ID=?;";
	             try {
					state= conn.prepareStatement(sql);
					state.setString(1, editfn);
					state.setString(2, editln);
					state.setString(3, editfacn);
					state.setString(4, editspec);
					state.setString(5, editSex);
					state.setString(6, email);
					state.setString(7, editTel);
					state.setInt(8, MembersFrame.idMembers);
					state.execute();
					refreshTable(MembersFrame.tableMembers, "MEMBERS");
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

	private class GoBackMember extends AbstractAction {
		public GoBackMember() {
			putValue(NAME, "Go Back");
			putValue(SHORT_DESCRIPTION, "Return to Member menu");
		}
		public void actionPerformed(ActionEvent e) {
			MembersFrame.membersFrame =new MembersFrame();
			MembersFrame.membersFrame.setVisible(true);
			EditMemberFrame.editMemberFrame.dispose();
		}
	}
}
