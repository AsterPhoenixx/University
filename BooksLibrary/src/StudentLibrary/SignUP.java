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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUP extends JFrame {
	private JTextField FirtsNameTxt;
	private JTextField familyTxt;
	private JTextField emailTxt;
	private JTextField usernameTxt;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	ResultSet result=null;
	PreparedStatement state=null;
	Connection conn=null;
     static SignUP signUPframe;
     JPanel contentPane;
     JLabel lblNow;
     JLabel lblSignUp;
     JLabel lblNewLabel;
     JLabel label;
     JLabel lblFirstName ;
     JLabel lblFamily;
     JLabel lblEmail;
     JLabel lblCreateUsername;
     JLabel lblPassword ;
     JLabel lblPasswordConfirm ;
     JLabel lblCountry;
     JLabel lblday;
     JLabel lblMonth;
     JLabel lblYear;
     JComboBox comboBoxCountry;
     JComboBox comboBoxDay;
     JComboBox comboBoxMonth;
     JComboBox comboBoxYear;
     JSeparator separator;
     JSeparator separator_1;
     JSeparator separator_2;
     JSeparator separator_3;
     JSeparator separator_4;
     JSeparator separator_5;
     
     
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUPframe = new SignUP();
					signUPframe.setVisible(true);
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
	public SignUP() {
		setBackground(new Color(236, 236, 236));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 504);
		setResizable(false);
		
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNow = new JLabel("NOW");
		lblNow.setForeground(new Color(211, 211, 211));
		lblNow.setFont(new Font("Steamy", Font.PLAIN, 75));
		lblNow.setBounds(88, 258, 237, 103);
		contentPane.add(lblNow);
		
		lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setForeground(new Color(211, 211, 211));
		lblSignUp.setFont(new Font("Steamy", Font.PLAIN, 75));
		lblSignUp.setBounds(51, 124, 330, 136);
		contentPane.add(lblSignUp);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUP.class.getResource("/resources/Icons/rsz_line-shadow-png-2566.png")));
		lblNewLabel.setBounds(352, 0, 105, 476);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("");
		label.setBounds(-92, 0, 549, 542);
		contentPane.add(label);
		label.setIcon(new ImageIcon(SignUP.class.getResource("/resources/Icons/rsz_low-poly-texturesplash.png")));
		
		lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblFirstName.setForeground(new Color(211, 211, 211));
		lblFirstName.setBackground(new Color(0, 0, 0));
		lblFirstName.setBounds(478, 11, 128, 65);
		contentPane.add(lblFirstName);
		
		lblFamily = new JLabel("Family:");
		lblFamily.setForeground(new Color(211, 211, 211));
		lblFamily.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblFamily.setBackground(Color.BLACK);
		lblFamily.setBounds(478, 60, 158, 65);
		contentPane.add(lblFamily);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(211, 211, 211));
		lblEmail.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblEmail.setBackground(Color.BLACK);
		lblEmail.setBounds(478, 112, 158, 65);
		contentPane.add(lblEmail);
		
		lblCreateUsername = new JLabel("Create Username:");
		lblCreateUsername.setForeground(new Color(211, 211, 211));
		lblCreateUsername.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblCreateUsername.setBackground(Color.BLACK);
		lblCreateUsername.setBounds(478, 159, 158, 65);
		contentPane.add(lblCreateUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(211, 211, 211));
		
		lblPassword.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setBounds(478, 208, 158, 65);
		contentPane.add(lblPassword);
		
		lblPasswordConfirm = new JLabel("Password confirm:");
		lblPasswordConfirm.setForeground(new Color(211, 211, 211));
		lblPasswordConfirm.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblPasswordConfirm.setBackground(Color.BLACK);
		lblPasswordConfirm.setBounds(478, 258, 158, 65);
		contentPane.add(lblPasswordConfirm);
		
		lblCountry = new JLabel("Country:");
		lblCountry.setForeground(new Color(211, 211, 211));
		lblCountry.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblCountry.setBackground(Color.BLACK);
		lblCountry.setBounds(478, 306, 158, 65);
		contentPane.add(lblCountry);
		
		lblday = new JLabel("Day:");
		lblday.setForeground(new Color(211, 211, 211));
		lblday.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblday.setBackground(Color.BLACK);
		lblday.setBounds(478, 353, 158, 65);
		contentPane.add(lblday);
		
	    lblMonth = new JLabel("Month:");
		lblMonth.setForeground(new Color(211, 211, 211));
		lblMonth.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblMonth.setBackground(Color.BLACK);
		lblMonth.setBounds(605, 353, 158, 65);
		contentPane.add(lblMonth);
		
		lblYear = new JLabel("Year:");
		lblYear.setForeground(new Color(211, 211, 211));
		lblYear.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		lblYear.setBackground(Color.BLACK);
		lblYear.setBounds(748, 353, 158, 65);
		contentPane.add(lblYear);
		
		FirtsNameTxt = new JTextField();
		FirtsNameTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblFirstName.setForeground(new Color(0, 64, 255));
				separator.setBackground(new Color(0, 64, 255));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblFirstName.setForeground(new Color(211, 211, 211));
				separator.setBackground(new Color(211, 211, 211));
			}
		});

		separator = new JSeparator();
		separator.setBounds(646, 60, 260, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(646, 112, 260, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(646, 161, 260, 2);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(646, 208, 260, 2);
		contentPane.add(separator_3);
		
		 separator_4 = new JSeparator();
		 separator_4.setBounds(646, 258, 260, 2);
		 contentPane.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(646, 306, 260, 2);
		contentPane.add(separator_5);
		FirtsNameTxt.setForeground(new Color(211, 211, 211));
		FirtsNameTxt.setDisabledTextColor(new Color(255, 255, 255));
		FirtsNameTxt.setCaretColor(new Color(255, 255, 255));
		FirtsNameTxt.setBackground(new Color(255, 255, 240));
		FirtsNameTxt.setBorder(new CompoundBorder());
		FirtsNameTxt.setOpaque(false);
		FirtsNameTxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		FirtsNameTxt.setBounds(646, 32, 260, 27);
		contentPane.add(FirtsNameTxt);
		FirtsNameTxt.setColumns(10);
		
		familyTxt = new JTextField();
		familyTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblFamily.setForeground((new Color(0, 64, 255)));
				separator_1.setBackground((new Color(0, 64, 255)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblFamily.setForeground((new Color(211, 211, 211)));
				separator_1.setBackground((new Color(211, 211, 211)));
			}
		});
		familyTxt.setForeground(new Color(211, 211, 211));
		familyTxt.setDisabledTextColor(new Color(255, 255, 255));
		familyTxt.setCaretColor(new Color(255, 255, 255));
		familyTxt.setBackground(new Color(255, 255, 240));
		familyTxt.setBorder(new CompoundBorder());
		familyTxt.setOpaque(false);
		familyTxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		familyTxt.setColumns(10);
		familyTxt.setBounds(646, 84, 260, 27);
		contentPane.add(familyTxt);
		
		emailTxt = new JTextField();
		emailTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblEmail.setForeground((new Color(0, 64, 255)));
				separator_2.setBackground((new Color(0, 64, 255)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblEmail.setForeground((new Color(211, 211, 211)));
				separator_2.setBackground((new Color(211, 211, 211)));
			}
		});
		emailTxt.setForeground(new Color(211, 211, 211));
		emailTxt.setDisabledTextColor(new Color(255, 255, 255));
		emailTxt.setCaretColor(new Color(255, 255, 255));
		emailTxt.setBackground(new Color(255, 255, 240));
		emailTxt.setBorder(new CompoundBorder());
		emailTxt.setOpaque(false);
		emailTxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		emailTxt.setColumns(10);
		emailTxt.setBounds(646, 136, 262, 27);
		contentPane.add(emailTxt);
		
		usernameTxt = new JTextField();
		usernameTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblCreateUsername.setForeground((new Color(0, 64, 255)));
				separator_3.setBackground((new Color(0, 64, 255)));
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblCreateUsername.setForeground((new Color(211, 211, 211)));
				separator_3.setBackground((new Color(211, 211, 211)));
			}
		});
		usernameTxt.setForeground(new Color(211, 211, 211));
		usernameTxt.setDisabledTextColor(new Color(255, 255, 255));
		usernameTxt.setCaretColor(new Color(255, 255, 255));
		usernameTxt.setBackground(new Color(255, 255, 240));
		usernameTxt.setBorder(new CompoundBorder());
		usernameTxt.setOpaque(false);
		usernameTxt.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(646, 180, 262, 27);
		contentPane.add(usernameTxt);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblPassword.setForeground((new Color(0, 64, 255)));
				separator_4.setBackground((new Color(0, 64, 255)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblPassword.setForeground((new Color(211, 211, 211)));
				separator_4.setBackground((new Color(211, 211, 211)));
			}
		});
		passwordField.setToolTipText("<html>\r\nAt least 8 chars<br>\r\n\u2743 Contains at least one digit<br>\r\n\u2743 Contains at least one lower alpha char and one upper alpha char<br>\r\n\u2743 Contains at least one char within a set of special chars (@#%$^ etc.)<br>\r\n\u2743 Does not contain space, tab, etc.<br>\r\n</html>");

		passwordField.setForeground(new Color(211, 211, 211));
		passwordField.setDisabledTextColor(new Color(255, 255, 255));
		passwordField.setCaretColor(new Color(255, 255, 255));
		passwordField.setBackground(new Color(255, 255, 240));
		passwordField.setBorder(new CompoundBorder());
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		passwordField.setBounds(646, 232, 262, 27);
		contentPane.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblPasswordConfirm.setForeground((new Color(0, 64, 255)));
				separator_5.setBackground((new Color(0, 64, 255)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblPasswordConfirm.setForeground((new Color(211, 211, 211)));
				separator_5.setBackground((new Color(211, 211, 211)));
			}
		});
		passwordFieldConfirm.setForeground(new Color(211, 211, 211));
		passwordFieldConfirm.setDisabledTextColor(new Color(255, 255, 255));
		passwordFieldConfirm.setCaretColor(new Color(255, 255, 255));
		passwordFieldConfirm.setBackground(new Color(255, 255, 240));
		passwordFieldConfirm.setBorder(new CompoundBorder());
		passwordFieldConfirm.setOpaque(false);
		passwordFieldConfirm.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		passwordFieldConfirm.setBounds(646, 279, 260, 27);
		contentPane.add(passwordFieldConfirm);
		
		comboBoxCountry = new JComboBox();
		comboBoxCountry.setModel(new DefaultComboBoxModel(new String[] {"Afghanistan", "Albania", "Algeria", "Andorra", 
				"Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", 
				"Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia",
				"Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", 
				"Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros",
				"Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", 
				"Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", 
				"Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece",
				"Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia",
				"Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya",
				"Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", 
				"Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", 
				"Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", 
				"Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", 
				"Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", 
				"Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe",
				"Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", 
				"South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", 
				"Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", 
				"Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", 
				"Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"}));
		comboBoxCountry.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		comboBoxCountry.setBounds(646, 315, 158, 27);
		contentPane.add(comboBoxCountry);
		
		comboBoxDay = new JComboBox();
		comboBoxDay.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setBounds(478, 407, 71, 27);
		contentPane.add(comboBoxDay);
		
		comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBoxMonth.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		comboBoxMonth.setBounds(605, 407, 98, 27);
		contentPane.add(comboBoxMonth);
		
		comboBoxYear = new JComboBox();
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900"}));
		comboBoxYear.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		comboBoxYear.setBounds(748, 407, 98, 27);
		contentPane.add(comboBoxYear);
		
		JButton buttonSignUp = new JButton("");
		buttonSignUp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		buttonSignUp.setContentAreaFilled(false);
		buttonSignUp.setOpaque(false);
		buttonSignUp.setBorderPainted(false);
		buttonSignUp.setIcon(new ImageIcon(SignUP.class.getResource("/resources/Icons/rsz_orange-sign-up-button-png-21.png")));
		buttonSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   
		             String firstName=FirtsNameTxt.getText();
		             String family=familyTxt.getText();
		             String email=emailTxt.getText();
		             String username=usernameTxt.getText();
		             @SuppressWarnings("deprecation")
					String password =passwordField.getText();
		             String passwordFieldAgain=passwordFieldConfirm.getText();
		             String countryString=comboBoxCountry.getSelectedItem().toString();
		             String day=comboBoxDay.getSelectedItem().toString();
		             String month=comboBoxMonth.getSelectedItem().toString();
		             String year=comboBoxYear.getSelectedItem().toString(); 
		           
		             conn=DBConnector.getConnection();
		             String sql="INSERT INTO REGISTRATION VALUES(null,?,?,?,?,?,?,?,?,?,?);";
		              if(password.equals(passwordFieldAgain))
		            	 {
		                 try {
		            	
							state= conn.prepareStatement(sql);
							state.setString(1, firstName);
							state.setString(2, family);
							state.setString(3, email);
							state.setString(4, username);
							state.setString(5, password);
							state.setString(6, passwordFieldAgain);
							state.setString(7, countryString);
							state.setString(8, day);
							state.setString(9, month);
							state.setString(10, year);
							state.execute();
							JOptionPane.showMessageDialog(null,"Successfully added "+ username +" user into the Library");
							signUPframe.setVisible(false);
							LoginFrame.loginFrame = new LoginFrame();
							LoginFrame.loginFrame.setVisible(true);
		            	 }
						
					 catch (SQLException e1) {
					e1.printStackTrace();
					}
		            	 }else 
		            	 {
		            		 JOptionPane.showMessageDialog(null, "The Passwords are not the same. Please try again!");
		            	 }
				}
			});

		buttonSignUp.setBounds(959, 84, 147, 93);
		contentPane.add(buttonSignUp);
		
		JLabel lblYouHaveAlready = new JLabel("You have already Account. Great");
		lblYouHaveAlready.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		lblYouHaveAlready.setForeground(new Color(211, 211, 211));
		lblYouHaveAlready.setBounds(901, 353, 204, 27);
		contentPane.add(lblYouHaveAlready);
		
		JLabel lblThenGoTo = new JLabel("Then go to                         to get starrted");
		lblThenGoTo.setForeground(new Color(211, 211, 211));
		lblThenGoTo.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		lblThenGoTo.setBounds(901, 373, 227, 27);
		contentPane.add(lblThenGoTo);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLogIn.setForeground(new Color(211, 211, 211));
				btnLogIn.setForeground(new Color(255, 140, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogIn.setForeground(new Color(211, 211, 211));
			}
		});
		btnLogIn.setContentAreaFilled(false);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signUPframe.setVisible(false);
				LoginFrame.loginFrame =new LoginFrame();
				LoginFrame.loginFrame.setVisible(true);
			}
		});
		btnLogIn.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 12));
		btnLogIn.setForeground(new Color(211, 211, 211));
		btnLogIn.setBorderPainted(false);
		btnLogIn.setOpaque(false);
		btnLogIn.setBounds(953, 373, 89, 27);
		contentPane.add(btnLogIn);
		
		JLabel backgroundRegisterPanel = new JLabel("");
		backgroundRegisterPanel.setBounds(449, -92, 838, 665);
		contentPane.add(backgroundRegisterPanel);
		backgroundRegisterPanel.setIcon(new ImageIcon(SignUP.class.getResource("/resources/Icons/circular-metallic-achtergrond-behang-800x480-168_12.jpg")));
	}
}
