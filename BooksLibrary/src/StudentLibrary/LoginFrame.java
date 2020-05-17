package StudentLibrary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField UserTextfield;
	private JPasswordField passwordField;
	JLabel lblUser;
	JLabel lblLogin;
	JSeparator passwordSeperator;
	JLabel lblPassword ;
	JSeparator separator;
	private JLabel lblNotHaveA;
	private JButton btnSignIn;
	ResultSet result=null;
    Connection conn=null;
    PreparedStatement state =null;
    static LoginFrame loginFrame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame = new LoginFrame();
					loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 730, 372);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(211, 211, 211));
		lblLogin.setFont(new Font("Steamy", Font.PLAIN, 75));
		lblLogin.setBounds(50, 128, 258, 77);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/resources/Icons/rsz_line-shadow-png-2.png")));
		lblNewLabel_1.setBounds(297, -70, 73, 460);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(369, 0, 417, 356);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNotHaveA = new JLabel("Not have a login? Then");
		lblNotHaveA.setForeground(new Color(211, 211, 211));
		lblNotHaveA.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNotHaveA.setBounds(40, 296, 178, 25);
		panel.add(lblNotHaveA);
		
		btnSignIn = new JButton("Sign up now");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignIn.setForeground(new Color(211, 211, 211));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignIn.setForeground(new Color(255, 69, 0));
			}
		});
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(false);
				SignUP.signUPframe = new SignUP();
				SignUP.signUPframe.setVisible(true);
				
			}
		});
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnSignIn.setBorder(new CompoundBorder());
		btnSignIn.setBorderPainted(false);
		btnSignIn.setContentAreaFilled(false);
		btnSignIn.setOpaque(false);
		btnSignIn.setForeground(new Color(211, 211, 211));
		btnSignIn.setBounds(159, 294, 104, 23);
		panel.add(btnSignIn);
		
		separator = new JSeparator();
		separator.setBackground(new Color(211, 211, 211));
		separator.setBounds(40, 86, 279, 25);
		panel.add(separator);
		
		UserTextfield = new JTextField();
		UserTextfield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblUser.setForeground(new Color(0, 64, 255));
				separator.setBackground(new Color(0, 64, 255));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblUser.setForeground(new Color(211, 211, 211));
				separator.setBackground(new Color(211, 211, 211));
			}
		});
		
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user=UserTextfield.getText();
				String firtsname="FIRSTNAME";
				String family="FAMILY";
				String password=passwordField.getText();
				conn=DBConnector.getConnection();
				String userEmptyString="";
				String passwordEmptyString="";
	            String sql="SELECT *FROM REGISTRATION WHERE USERNAME=? AND PASSWORD=?";
	           
	            	try {
						state= conn.prepareStatement(sql);
						state.setString(1, user);
					    state.setString(2, password);
					    result=state.executeQuery();
						   if(result.next())
					    {
					    	JOptionPane.showMessageDialog(null, "Welcome " + result.getString(firtsname)+" "+ result.getString(family) +" Nice to meet you again!<3 ");
					    	LibraryFrame.libraryFrame= new LibraryFrame();
					    	 LibraryFrame.libraryFrame.setVisible(true);
					         loginFrame.setVisible(false);
					    	
					    } else if(user.equals(userEmptyString) || password.equals(passwordEmptyString)){
					    	JOptionPane.showMessageDialog(null, "Some of the fields are empty! Please fill it!", "Warning!" , JOptionPane.WARNING_MESSAGE);
					    }else
					    {
					    	JOptionPane.showMessageDialog(null, "Wrong username or password! Please try again!", "Cant Access!" , JOptionPane.ERROR_MESSAGE);
					    }
						   
	            	}
					 
					 catch (SQLException e) {
						
						e.printStackTrace();
		
					}
			}
		});
		button.setBorder(new CompoundBorder());
		button.setIcon(new ImageIcon(LoginFrame.class.getResource("/resources/Icons/rsz_login-button-png-icon-1.png")));
		button.setBounds(82, 209, 178, 53);
		panel.add(button);
		UserTextfield.setForeground(new Color(255, 255, 224));
		UserTextfield.setBorder(new CompoundBorder());
		UserTextfield.setOpaque(false);
		UserTextfield.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		UserTextfield.setBounds(40, 52, 279, 43);
		panel.add(UserTextfield);
		UserTextfield.setColumns(10);
		
		lblUser = new JLabel("USER:");
		lblUser.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblUser.setForeground(new Color(211, 211, 211));
		lblUser.setBounds(40, 22, 166, 53);
		panel.add(lblUser);
		
		passwordSeperator = new JSeparator();
		passwordSeperator.setBackground(new Color(211, 211, 211));
		passwordSeperator.setBounds(40, 186, 279, 25);
		panel.add(passwordSeperator);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		passwordField.setForeground(new Color(255, 255, 224));
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblPassword.setForeground(new Color(0, 64, 255));
				passwordSeperator.setBackground(new Color(0, 64, 255));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblPassword.setForeground(new Color(211, 211, 211));
				passwordSeperator.setBackground(new Color(211, 211, 211));
			}
		});
		passwordField.setBorder(new CompoundBorder());
		passwordField.setOpaque(false);
		passwordField.setBounds(41, 155, 278, 43);
		panel.add(passwordField);
		
		lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(211, 211, 211));
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblPassword.setBounds(40, 122, 178, 53);
		panel.add(lblPassword);
		
		JLabel back = new JLabel("");
		back.setBounds(-236, -36, 800, 456);
		panel.add(back);
		back.setIcon(new ImageIcon(LoginFrame.class.getResource("/resources/Icons/circular-metallic-achtergrond-behang-800x480-168_12.jpg")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/resources/Icons/rsz_low-poly-texturesplash.png")));
		lblNewLabel.setBounds(0, -20, 722, 385);
		contentPane.add(lblNewLabel);
	}
}
