package classes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private ImageIcon on;
    private ImageIcon off;
    private ImageIcon login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("The Tipon Hotel Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/titleIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 554);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LoginTxt = new JLabel("LOGIN");
		LoginTxt.setForeground(new Color(215, 210, 203));
		LoginTxt.setFont(new Font("Verdana", Font.BOLD, 22));
		LoginTxt.setBounds(675, 132, 83, 30);
		contentPane.add(LoginTxt);
		
		JLabel UsernameTxt = new JLabel("Username");
		UsernameTxt.setForeground(new Color(215, 210, 203));
		UsernameTxt.setFont(new Font("Verdana", Font.PLAIN, 18));
		UsernameTxt.setBounds(601, 194, 94, 30);
		contentPane.add(UsernameTxt);
		
		usernameField = new JTextField();
		usernameField.setOpaque(false);
		usernameField.setForeground(new Color(219, 226, 233));
		usernameField.setFont(new Font("Times New Roman", Font.BOLD, 17));
		usernameField.setBounds(601, 234, 246, 30);
		usernameField.setBorder(BorderFactory.createEmptyBorder());
        Border userBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
        usernameField.setBorder(userBorder);
		contentPane.add(usernameField);
		
		JLabel PasswordTxt = new JLabel("Password");
		PasswordTxt.setForeground(new Color(215, 210, 203));
		PasswordTxt.setFont(new Font("Verdana", Font.PLAIN, 18));
		PasswordTxt.setBounds(601, 276, 94, 30);
		contentPane.add(PasswordTxt);
		
		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setForeground(new Color(219, 226, 233));
		passwordField.setFont(new Font("Verdana", Font.BOLD, 17));
		passwordField.setEchoChar('*');
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		Border passBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
        passwordField.setBorder(passBorder);
		passwordField.setBounds(601, 329, 246, 30);
		contentPane.add(passwordField);
		
		BufferedImage imgOn=null;
		BufferedImage imgOff=null;
		try {
			imgOn=ImageIO.read(Login.class.getResource("/images/show.png"));
			
			imgOff=ImageIO.read(Login.class.getResource("/images/hide.png"));
			
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imgON =imgOn.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image imgOFF =imgOff.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		on = new ImageIcon(imgON);
        off = new ImageIcon(imgOFF);
		JToggleButton EyeBtn = new JToggleButton(off);
		EyeBtn.setOpaque(false);
		EyeBtn.setForeground(Color.DARK_GRAY);
		EyeBtn.setBackground(Color.DARK_GRAY);
		EyeBtn.setBounds(807, 319, 40, 40);
		contentPane.add(EyeBtn);
		
		JButton forgot = new JButton("Forgotten Password ?");
		forgot.setOpaque(false);
		forgot.setForeground(Color.GRAY);
		forgot.setFont(new Font("Dialog", Font.BOLD, 10));
		forgot.setBorder(BorderFactory.createEmptyBorder());
		forgot.setBackground(new Color(0, 0, 0, 0));
		forgot.setBounds(727, 369, 120, 19);
		contentPane.add(forgot);
		
		JButton signup = new JButton("Don't have an account?");
		signup.setForeground(new Color(220, 20, 60));
		signup.setFont(new Font("Calibri", Font.BOLD, 14));
		signup.setBackground(Color.GRAY);
		signup.setBounds(639, 436, 187, 36);
		contentPane.add(signup);
		
		BufferedImage imgLogin=null;
		try {
			imgLogin=ImageIO.read(Login.class.getResource("/images/LoginBackground.png"));
			
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imgLOGIN =imgLogin.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
		JLabel LoginPageImage = new JLabel("New label");
		LoginPageImage.setForeground(Color.DARK_GRAY);
		LoginPageImage.setBackground(Color.DARK_GRAY);
		LoginPageImage.setIcon(new ImageIcon(imgLOGIN));
		LoginPageImage.setBounds(37, 170, 500, 300);
		contentPane.add(LoginPageImage);
		
		JLabel LoginLblTxt = new JLabel("The Tipton Hotel");
		LoginLblTxt.setForeground(Color.LIGHT_GRAY);
		LoginLblTxt.setFont(new Font("Modern No. 20", Font.PLAIN, 54));
		LoginLblTxt.setBounds(72, 42, 404, 82);
		contentPane.add(LoginLblTxt);
		
		
	}

}
