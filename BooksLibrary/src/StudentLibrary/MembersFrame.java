package StudentLibrary;

import java.awt.EventQueue;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


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
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MembersFrame extends JFrame {

	private JPanel contentPanel;
	static JTable tableMembers = new JTable();
	JScrollPane scroller = new JScrollPane(tableMembers);
	static int idMembers = 0;
    Connection conn=null;
    PreparedStatement state=null;
    ResultSet result=null;
    private final Action addMember = new PopUpAddMember();
    static MembersFrame membersFrame = null;
    @SuppressWarnings("unused")
	private final Action goToMainMenu = new GoToMainMenu();
    private final Action goBack = new GOBack();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					membersFrame = new MembersFrame();
					membersFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MembersFrame() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JULIEN\\Uni\\Java\\BooksLibrary\\Icons\\People icon icon (1).png"));
		setTitle("Members");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 100,769,423);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		scroller.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scroller.setBackground(new Color(135, 206, 235));
		contentPanel.add(scroller);
		scroller.setBounds(27, 31, 704, 188);
		tableMembers.setBorder(new CompoundBorder());
		tableMembers.setBackground(new Color(255, 255, 255));
		tableMembers.addMouseListener(new TableAction());
		refreshTable(tableMembers, "MEMBERS");
		
		JButton addMemberButtonMemberFrame = new JButton("Add");
		addMemberButtonMemberFrame.setOpaque(false);
		addMemberButtonMemberFrame.setBackground(new Color(135, 206, 235));
		addMemberButtonMemberFrame.setBorder(new CompoundBorder());
		addMemberButtonMemberFrame.setAction(addMember);
		addMemberButtonMemberFrame.setIcon(new ImageIcon(MembersFrame.class.getResource("/resources/Icons/icons8-add-48.png")));
		addMemberButtonMemberFrame.setBounds(68, 278, 127, 48);
		contentPanel.add(addMemberButtonMemberFrame);
		
		JButton editMemberButtonMemberFrame = new JButton("Update");
		editMemberButtonMemberFrame.setOpaque(false);
		editMemberButtonMemberFrame.setBackground(new Color(135, 206, 235));
		editMemberButtonMemberFrame.setBorder(new CompoundBorder());
		editMemberButtonMemberFrame.addActionListener(new EditAction());
		editMemberButtonMemberFrame.setIcon(new ImageIcon(MembersFrame.class.getResource("/resources/Icons/EDIT.png")));
		editMemberButtonMemberFrame.setBounds(241, 278, 166, 48);
		contentPanel.add(editMemberButtonMemberFrame);
		
		JButton deleteMemberButtonMemberFrame = new JButton("Delete");
		deleteMemberButtonMemberFrame.setOpaque(false);
		deleteMemberButtonMemberFrame.setBackground(new Color(135, 206, 235));
		deleteMemberButtonMemberFrame.setBorder(new CompoundBorder());
		deleteMemberButtonMemberFrame.addActionListener(new DeleteMemberAction());
		deleteMemberButtonMemberFrame.setIcon(new ImageIcon(MembersFrame.class.getResource("/resources/Icons/DELETE.png")));
		deleteMemberButtonMemberFrame.setBounds(430, 278, 127, 48);
		contentPanel.add(deleteMemberButtonMemberFrame);
		
		JButton btnGoback = new JButton("goBack");
		btnGoback.setOpaque(false);
		btnGoback.setBackground(new Color(135, 206, 235));
		btnGoback.setBorder(new CompoundBorder());
		btnGoback.setAction(goBack);
		btnGoback.setIcon(new ImageIcon(MembersFrame.class.getResource("/resources/Icons/BACK.png")));
		btnGoback.setBounds(588, 278, 120, 48);
		contentPanel.add(btnGoback);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MembersFrame.class.getResource("/resources/Icons/Blue_gaussian_blur_1920x1200.jpg")));
		lblNewLabel.setBounds(0, 0, 763, 397);
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
	   			int row = tableMembers.getSelectedRow();
	   			idMembers = Integer.parseInt(tableMembers.getValueAt(row, 0).toString());						
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
	       

	private class PopUpAddMember extends AbstractAction {
		public PopUpAddMember() {
			putValue(NAME, "Add Member");
			putValue(SHORT_DESCRIPTION, "Add new Member");
		}
		public void actionPerformed(ActionEvent e) {
			AddMemberFrame.addMemberFrame = new AddMemberFrame();
			AddMemberFrame.addMemberFrame.setVisible(true);
			MembersFrame.membersFrame.dispose();
			
		}
	}
	class DeleteMemberAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String sql = "DELETE FROM MEMBERS WHERE MEMMBER_ID=?;";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, idMembers);
				state.execute();
				refreshTable(tableMembers, "MEMBERS");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	class EditAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			EditMemberFrame.editMemberFrame = new EditMemberFrame();
			EditMemberFrame.editMemberFrame.setVisible(true);
			MembersFrame.membersFrame.dispose();
			String editfn="FIRSTNAME";   
			String editln="LASTNAME";
			String editfac="FACNUM";
			String editSpecialty="SPECIALTY";
			String editSEX="SEX";
			String editEmail="EMAIL";
			String editTel="TELEPHONE";
			conn = DBConnector.getConnection();
			String sql = "SELECT * FROM MEMBERS WHERE MEMMBER_ID=?;";
			try {
			   state = conn.prepareStatement(sql);
			   state.setInt(1, idMembers);
			   state.executeQuery();
			   result=state.executeQuery();
				if(result.next())
				{
					 EditMemberFrame.firstNameTextFieldEditMemberFrame.setText(result.getString(editfn));
					 EditMemberFrame.lastNameTextFieldEditMemberFrame.setText(result.getString(editln));
					 EditMemberFrame.facNummTextFieldEditMemberFrame.setText(result.getString(editfac));
					 EditMemberFrame.editSpecialitiesComboBox.setSelectedItem(result.getString(editSpecialty));
					 EditMemberFrame.editSexcomboBox.setSelectedItem(result.getString(editSEX));
					 EditMemberFrame.emailTextFieldEditMemberFrame.setText(result.getString(editEmail));
					EditMemberFrame.telephoneTextFieldEditMemberFrame.setText(result.getString(editTel));
				}
				refreshTable(tableMembers, "MEMBERS");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class GoToMainMenu extends AbstractAction {
		public GoToMainMenu() {
			putValue(NAME, "Go Back");
			putValue(SHORT_DESCRIPTION, "Return To main menu");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	private class GOBack extends AbstractAction {
		public GOBack() {
			putValue(NAME, "Go back");
			putValue(SHORT_DESCRIPTION, "return to main menu");
		}
		public void actionPerformed(ActionEvent e) {
			LibraryFrame.libraryFrame =new LibraryFrame();
			LibraryFrame.libraryFrame.setVisible(true);
			MembersFrame.membersFrame.dispose();
		}
	}
}
