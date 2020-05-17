package StudentLibrary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AddMemberFrame extends JFrame {

	private JPanel addMemberFrameContPane;
	private JTextField firstNameTextFieldAddMemberFrame;
	private JTextField lastNameTextFieldAddMemberFrame;
	private JTextField facNummTextFieldAddMemberFrame;
	private JTextField emailTextFieldAddMemberFrame;
	private JTextField telephoneTextFieldAddMemberFrame;
	 @SuppressWarnings("rawtypes")
	JComboBox addSpecialltyComboBox;
	 @SuppressWarnings("rawtypes")
	JComboBox addSexComboBox;
	 private final Action action = new AddMemberToDB();
	 ResultSet result=null;
	    Connection conn=null;
	    PreparedStatement state =null;
	   static  AddMemberFrame addMemberFrame = null;
	   private JButton backToMenuMember;
	   private final Action goBackMember = new GoBackMember();
	   private JLabel labelBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMemberFrame = new AddMemberFrame();
					addMemberFrame.setVisible(true);
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
	public AddMemberFrame() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JULIEN\\Uni\\Java\\BooksLibrary\\Icons\\People icon icon.png"));
		setVisible(true);
		setResizable(false);
		setTitle("AddMember");
		setBounds(240, 100,697, 516);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMemberFrameContPane = new JPanel();
		addMemberFrameContPane.setBackground(new Color(135, 206, 235));
		addMemberFrameContPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addMemberFrameContPane);
		addMemberFrameContPane.setLayout(null);
		
		JLabel firstNameLabelAddMemberFrame = new JLabel("First Name:");
		firstNameLabelAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameLabelAddMemberFrame.setBounds(49, 39, 97, 30);
		addMemberFrameContPane.add(firstNameLabelAddMemberFrame);
		
		JLabel lastNameLabelAddMemberFrame = new JLabel("Last Name:");
		lastNameLabelAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastNameLabelAddMemberFrame.setBounds(49, 102, 97, 30);
		addMemberFrameContPane.add(lastNameLabelAddMemberFrame);
		
		JLabel fakNummerLabelAddMemberFrame = new JLabel("Fac\u2116:");
		fakNummerLabelAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fakNummerLabelAddMemberFrame.setBounds(49, 156, 97, 30);
		addMemberFrameContPane.add(fakNummerLabelAddMemberFrame);
		
		JLabel specialtyLabelAddMemberFrame = new JLabel("Specialty");
		specialtyLabelAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		specialtyLabelAddMemberFrame.setBounds(49, 219, 97, 30);
		addMemberFrameContPane.add(specialtyLabelAddMemberFrame);
		
		JLabel sexLabelAddMemberFrame = new JLabel("Sex:");
		sexLabelAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sexLabelAddMemberFrame.setBounds(50, 289, 97, 30);
		addMemberFrameContPane.add(sexLabelAddMemberFrame);
		
		JLabel emailLabelAddMemberFrame = new JLabel("Email:");
		emailLabelAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailLabelAddMemberFrame.setBounds(49, 348, 97, 30);
		addMemberFrameContPane.add(emailLabelAddMemberFrame);
		
		JLabel telLabelAddMemberFrame = new JLabel("Telephone:");
		telLabelAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		telLabelAddMemberFrame.setBounds(49, 421, 97, 30);
		addMemberFrameContPane.add(telLabelAddMemberFrame);
		
        firstNameTextFieldAddMemberFrame = new JTextField();
        firstNameTextFieldAddMemberFrame.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		LibraryFrame.onlyLettersAlloweedand(e);
        	}
        });
		firstNameTextFieldAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameTextFieldAddMemberFrame.setBounds(201, 39, 263, 30);
		addMemberFrameContPane.add(firstNameTextFieldAddMemberFrame);
		firstNameTextFieldAddMemberFrame.setColumns(10);
		
		lastNameTextFieldAddMemberFrame = new JTextField();
		lastNameTextFieldAddMemberFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				LibraryFrame.onlyLettersAlloweedand(e);
			}
		});
		lastNameTextFieldAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameTextFieldAddMemberFrame.setColumns(10);
		lastNameTextFieldAddMemberFrame.setBounds(201, 101, 263, 30);
		addMemberFrameContPane.add(lastNameTextFieldAddMemberFrame);
		
		facNummTextFieldAddMemberFrame = new JTextField();
		facNummTextFieldAddMemberFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				LibraryFrame.onlyNumbersAlloweed(event);
			}
		});
		facNummTextFieldAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		facNummTextFieldAddMemberFrame.setColumns(10);
		facNummTextFieldAddMemberFrame.setBounds(201, 155, 263, 30);
		addMemberFrameContPane.add(facNummTextFieldAddMemberFrame);
		
	    addSpecialltyComboBox = new JComboBox();
		addSpecialltyComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addSpecialltyComboBox.setModel(new DefaultComboBoxModel(new String[] {"Software technologies and design", "Business IT", "Informatics", "Software engineering", "Mathematics", "Mathematics, Informatics and Information Technologies", "Applied Mathematics", "Business Mathematics", "Information Technology, Mathematics and Educational Management"}));
		addSpecialltyComboBox.setBounds(204, 215, 260, 40);
		addMemberFrameContPane.add(addSpecialltyComboBox);
		

		
		emailTextFieldAddMemberFrame = new JTextField();
		emailTextFieldAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTextFieldAddMemberFrame.setBounds(204, 349, 260, 30);
		addMemberFrameContPane.add(emailTextFieldAddMemberFrame);
		emailTextFieldAddMemberFrame.setColumns(10);
		
		telephoneTextFieldAddMemberFrame = new JTextField();
		telephoneTextFieldAddMemberFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				LibraryFrame.onlyNumbersAlloweed(arg0);
			}
		});
		telephoneTextFieldAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		telephoneTextFieldAddMemberFrame.setColumns(10);
		telephoneTextFieldAddMemberFrame.setBounds(201, 421, 263, 30);
		addMemberFrameContPane.add(telephoneTextFieldAddMemberFrame);
		
		JButton addMemberButtonAddMemberFrame = new JButton("Add Member");
		addMemberButtonAddMemberFrame.setOpaque(false);
		addMemberButtonAddMemberFrame.setBackground(new Color(135, 206, 235));
		addMemberButtonAddMemberFrame.setBorder(new CompoundBorder());
		addMemberButtonAddMemberFrame.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addMemberButtonAddMemberFrame.setAction(action);
		addMemberButtonAddMemberFrame.setIcon(new ImageIcon(AddMemberFrame.class.getResource("/resources/Icons/ADD.png")));
		addMemberButtonAddMemberFrame.setBounds(504, 61, 133, 56);
		addMemberFrameContPane.add(addMemberButtonAddMemberFrame);
		
		addSexComboBox = new JComboBox();
		addSexComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addSexComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		addSexComboBox.setBounds(205, 286, 259, 40);
		addMemberFrameContPane.add(addSexComboBox);
		
		backToMenuMember = new JButton("BackToMenu");
		backToMenuMember.setOpaque(false);
		backToMenuMember.setBackground(new Color(135, 206, 235));
		backToMenuMember.setBorder(new CompoundBorder());
		backToMenuMember.setAction(goBackMember);
		backToMenuMember.setIcon(new ImageIcon(AddMemberFrame.class.getResource("/resources/Icons/BACK.png")));
		backToMenuMember.setBounds(504, 373, 133, 56);
		addMemberFrameContPane.add(backToMenuMember);
		
		labelBack = new JLabel("");
		labelBack.setIcon(new ImageIcon(AddMemberFrame.class.getResource("/resources/Icons/Blue_gaussian_blur_1920x1200.jpg")));
		labelBack.setBounds(0, 0, 992, 490);
		addMemberFrameContPane.add(labelBack);
		
	}
	private void resetForm() {
		firstNameTextFieldAddMemberFrame.setText("");
		lastNameTextFieldAddMemberFrame.setText("");
		facNummTextFieldAddMemberFrame.setText("");
		emailTextFieldAddMemberFrame.setText("");
		telephoneTextFieldAddMemberFrame.setText("");
	}
	private class AddMemberToDB extends AbstractAction {
		
		public AddMemberToDB() {
			putValue(NAME, "Add Member");
			putValue(SHORT_DESCRIPTION, "Add information MEMBER to table");
		}
		public void actionPerformed(ActionEvent e) {
			 MembersFrame.membersFrame =new MembersFrame();
		     MembersFrame.membersFrame.setVisible(true);
		    	AddMemberFrame.addMemberFrame.dispose();
             String addfn=firstNameTextFieldAddMemberFrame.getText();
             String addln=lastNameTextFieldAddMemberFrame.getText();
             String addfac=facNummTextFieldAddMemberFrame.getText();
             String tel=telephoneTextFieldAddMemberFrame.getText();
             String email=emailTextFieldAddMemberFrame.getText();
             String spec = addSpecialltyComboBox.getSelectedItem().toString();
             String sex = addSexComboBox.getSelectedItem().toString();
             conn=DBConnector.getConnection();
             String sql="INSERT INTO MEMBERS VALUES(null,?,?,?,?,?,?,?);";
             try {
				state= conn.prepareStatement(sql);
				state.setString(1, addfn);
				state.setString(2, addln);
				state.setString(3, addfac);
				state.setString(4, spec);
				state.setString(5, sex);
				state.setString(6, email);
				state.setString(7, tel);
				state.execute();
				resetForm();
				refreshTable(MembersFrame.tableMembers, "MEMBERS");
				JOptionPane.showMessageDialog(null,"Successfully added "+ addfn +" "+addln+"  into the Members");
			} catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Some of the fields"
						+ " are empty. Try again!","Warning",JOptionPane.ERROR_MESSAGE);
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
			putValue(NAME, "Go back");
			putValue(SHORT_DESCRIPTION, "return to Member menu");
		}
		public void actionPerformed(ActionEvent e) {
			MembersFrame.membersFrame =new MembersFrame();
			MembersFrame.membersFrame.setVisible(true);
			AddMemberFrame.addMemberFrame.dispose();
		}
	}
}
