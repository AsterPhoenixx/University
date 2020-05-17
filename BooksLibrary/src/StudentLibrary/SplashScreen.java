package StudentLibrary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	public JLabel prgressCount;
	public JProgressBar progressBar;
	static SplashScreen frame;
	private JLabel lblThisProgramIs;
	private JLabel lblCopyright;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frame = new SplashScreen();
			frame.setVisible(true);
					loading();	
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 587, 404);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(230, 230, 250));
		progressBar.setForeground(new Color(169, 169, 169));
		progressBar.setBounds(48, 196, 500, 24);
		contentPane.add(progressBar);
		
		lblCopyright = new JLabel("Copyright \u00A9 2019 Plovdiv Bulgaria , Inc. All rights reserved.");
		lblCopyright.setForeground(new Color(211, 211, 211));
		lblCopyright.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		lblCopyright.setBounds(254, 370, 333, 34);
		contentPane.add(lblCopyright);
		
		lblThisProgramIs = new JLabel("<html>This program is developed by Zhulien Tonchev and Nikolai Spasov with Eclipse. <br>Olimpus Library is all you want to create your own library with simple interface<br>and high capasity. With simple clicks you you do the hard work easy</html>\r\n\r\n\r\n\r\n\r\n");
		lblThisProgramIs.setForeground(new Color(211, 211, 211));
		lblThisProgramIs.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		lblThisProgramIs.setBounds(58, 231, 529, 94);
		contentPane.add(lblThisProgramIs);
		
		JLabel lblOlimpusLibrary = new JLabel("Olimpus Library");
		lblOlimpusLibrary.setFont(new Font("Steamy", Font.PLAIN, 57));
		lblOlimpusLibrary.setForeground(new Color(169, 169, 169));
		lblOlimpusLibrary.setBounds(84, 11, 419, 152);
		contentPane.add(lblOlimpusLibrary);
		
		prgressCount = new JLabel("99%");
		prgressCount.setForeground(new Color(169, 169, 169));
		prgressCount.setFont(new Font("DS-Digital", Font.PLAIN, 55));
		prgressCount.setBounds(239, 124, 174, 61);
		contentPane.add(prgressCount);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/resources/Icons/rsz_low-poly-texturesplash.png")));
		lblNewLabel.setBounds(-32, -13, 642, 417);
		contentPane.add(lblNewLabel);
	}
	private static void loading() {
		try {
			 for (int i = 0; i <= 100; i++) {
					Thread.sleep(75);
				   
					frame.prgressCount.setText(Integer.toString(i)+ " %");
				    frame.progressBar.setValue(i);
					if(i==100)
					{
						frame.setVisible(false);
						LoginFrame.loginFrame = new  LoginFrame();
						LoginFrame.loginFrame.setVisible(true);
					}
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


