package classes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Color;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private ImageIcon on;
	private ImageIcon off;
	private JToggleButton EyeBtn;
	private JButton signup;
	private JButton exitButton;
	private JButton guestButton;
	private JButton loginButton;
	private JButton forgot;
	protected static boolean loginFlag;
	public static String USERNAME;
	protected static String fullName;
	protected static String oldPassword;
	protected static String phoneNumber;
	protected static String fullUsername;

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
		LoginTxt.setBounds(677, 79, 83, 30);
		contentPane.add(LoginTxt);

		JLabel UsernameTxt = new JLabel("Username");
		UsernameTxt.setForeground(new Color(215, 210, 203));
		UsernameTxt.setFont(new Font("Verdana", Font.PLAIN, 18));
		UsernameTxt.setBounds(603, 141, 94, 30);
		contentPane.add(UsernameTxt);

		usernameField = new JTextField();
		usernameField.setOpaque(false);
		usernameField.setForeground(new Color(219, 226, 233));
		usernameField.setFont(new Font("Times New Roman", Font.BOLD, 17));
		usernameField.setBounds(603, 181, 205, 30);
		usernameField.setBorder(BorderFactory.createEmptyBorder());
		Border userBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
		usernameField.setBorder(userBorder);
		contentPane.add(usernameField);

		guestButton = new JButton("Guest View");
		guestButton.setOpaque(false);
		guestButton.setForeground(Color.GRAY);
		guestButton.setFont(new Font("Dialog", Font.BOLD, 14));
		guestButton.setBorder(BorderFactory.createEmptyBorder());
		guestButton.setBackground(Color.LIGHT_GRAY);
		guestButton.setBounds(769, 0, 120, 19);
		contentPane.add(guestButton);

		JLabel PasswordTxt = new JLabel("Password");
		PasswordTxt.setForeground(new Color(215, 210, 203));
		PasswordTxt.setFont(new Font("Verdana", Font.PLAIN, 18));
		PasswordTxt.setBounds(603, 223, 94, 30);
		contentPane.add(PasswordTxt);

		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setForeground(new Color(219, 226, 233));
		passwordField.setFont(new Font("Verdana", Font.BOLD, 17));
		passwordField.setEchoChar('*');
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		Border passBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
		passwordField.setBorder(passBorder);
		passwordField.setBounds(603, 276, 205, 30);
		contentPane.add(passwordField);

		BufferedImage imgOn = null;
		BufferedImage imgOff = null;
		try {
			imgOn = ImageIO.read(Login.class.getResource("/images/show.png"));

			imgOff = ImageIO.read(Login.class.getResource("/images/hide.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imgON = imgOn.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image imgOFF = imgOff.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		on = new ImageIcon(imgON);
		off = new ImageIcon(imgOFF);
		EyeBtn = new JToggleButton(off);
		EyeBtn.setOpaque(false);
		EyeBtn.setForeground(Color.DARK_GRAY);
		EyeBtn.setBackground(Color.DARK_GRAY);
		EyeBtn.setBounds(818, 287, 33, 19);
		contentPane.add(EyeBtn);

		forgot = new JButton("Forgotten Password ?");
		forgot.setOpaque(false);
		forgot.setForeground(Color.GRAY);
		forgot.setFont(new Font("Dialog", Font.BOLD, 10));
		forgot.setBorder(BorderFactory.createEmptyBorder());
		forgot.setBackground(new Color(0, 0, 0, 0));
		forgot.setBounds(729, 316, 120, 19);
		contentPane.add(forgot);

		signup = new JButton("Don't have an account?");
		signup.setForeground(new Color(220, 20, 60));
		signup.setBorder(BorderFactory.createEmptyBorder());
		signup.setFont(new Font("Calibri", Font.BOLD, 14));
		signup.setBackground(Color.DARK_GRAY);
		signup.setBounds(637, 410, 189, 30);
		contentPane.add(signup);

		BufferedImage imgLogin = null;
		try {
			imgLogin = ImageIO.read(Login.class.getResource("/images/LoginBackground.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imgLOGIN = imgLogin.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
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

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginButton.setBounds(653, 345, 153, 40);
		contentPane.add(loginButton);

		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		exitButton.setBounds(809, 486, 70, 21);
		contentPane.add(exitButton);

		EyeBtn.addActionListener(this);
		signup.addActionListener(this);
		exitButton.addActionListener(this);
		loginButton.addActionListener(this);
		guestButton.addActionListener(this);
		forgot.addActionListener(this);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = usernameField.getText();
		String pass = String.valueOf(passwordField.getPassword());
		boolean userEmpty = user.isEmpty();
		boolean passEmpty = pass.isEmpty();

		if (e.getSource() == EyeBtn) {
			if (EyeBtn.isSelected()) {
				EyeBtn.setIcon(on);
				passwordField.setEchoChar((char) 0);
			} else {
				EyeBtn.setIcon(off);
				passwordField.setEchoChar('*');
			}
		}

		else if (e.getSource() == signup) {
			this.setVisible(false);
			// new Signup();
		}

		else if (e.getSource() == guestButton) {
			this.setVisible(false);
			// new Guest();

		}

		else if (e.getSource() == exitButton) {
			int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!", JOptionPane.YES_NO_OPTION);

			if (yesORno == 0) {
				System.exit(1);
			}
		} else if (e.getSource() == loginButton) {
			if (userEmpty == true || passEmpty == true) {
				JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			}

			else {
				boolean userbool = false;
				boolean adminbool = false;
				try {
					File file = new File(".\\files\\admin_login.txt");
					if (!file.exists()) {
						file.createNewFile();
						FileWriter fileWriter = new FileWriter(file, true);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						PrintWriter printWriter = new PrintWriter(bufferedWriter);

						printWriter.println("===============================================");
						printWriter.println("User Name : admin");
						printWriter.println("Password : admin");
						printWriter.println("===============================================");
						printWriter.close();
					}

					String uname = "User Name : " + user;
					String pin = "Password : " + pass;

					// for admin
					BufferedReader readFile1 = new BufferedReader(new FileReader(".\\files\\admin_login.txt"));

					// for admin
					int totalLines1 = 0;
					while (readFile1.readLine() != null) {
						totalLines1++;
					}
					readFile1.close();

					// for admin login
					for (int i = 0; i < totalLines1; i++) {

						String line = Files.readAllLines(Paths.get(".\\files\\admin_login.txt")).get(i);
						if (line.equals(uname)) {
							String line2 = Files.readAllLines(Paths.get(".\\files\\admin_login.txt")).get((i + 1));
							if (line2.equals(pin)) {

								this.setVisible(false);
								// new AdminHome();

								loginFlag = true;
								adminbool = true;
								USERNAME = user;
								break;
							} else {
								adminbool = false;
							}
						} else {
							adminbool = false;
						}
					}

					// for user
					if (adminbool == false) {
						File userfile = new File(".\\files\\user_login.txt");
						if (userfile.exists()) {
							BufferedReader readFile = new BufferedReader(new FileReader(".\\files\\user_login.txt"));
							int totalLines = 0;
							while (readFile.readLine() != null) {
								totalLines++;
							}
							readFile.close();

							// for user login
							for (int i = 0; i < totalLines; i++) {

								String line = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(i);
								if (line.equals(uname)) {
									String line2 = Files.readAllLines(Paths.get(".\\files\\user_login.txt"))
											.get((i + 1));
									if (line2.equals(pin)) {

										loginFlag = true;
										userbool = true;
										USERNAME = user;

										fullName = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(i - 1);
										phoneNumber = Files.readAllLines(Paths.get(".\\files\\user_login.txt"))
												.get(i + 2);
										oldPassword = Files.readAllLines(Paths.get(".\\files\\user_login.txt"))
												.get(i + 1);
										fullUsername = uname;

										File file3 = new File(".\\files\\" + USERNAME + "_shops.txt");
										if (!file3.exists()) {
											file3.createNewFile();
										}

										this.setVisible(false);
										// new CustomerHome();

										break;
									} else {
										userbool = false;
									}
								} else {
									userbool = false;
								}
							}
						} else {
							userbool = false;
						}
					}
					if (userbool == false && adminbool == false) {
						JOptionPane.showMessageDialog(null, "Invalid Name or Password!", "Warning!",
								JOptionPane.WARNING_MESSAGE);
					}

				}

				catch (Exception ex) {
					if (userbool == false && adminbool == false) {
						JOptionPane.showMessageDialog(null, "Invalid Name or Password!", "Warning!",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		} else if (e.getSource() == forgot) {
			this.setVisible(false);
			// new ForgetPass();
		}

	}

	public static boolean getloginFlag() {
		return loginFlag;
	}

}
