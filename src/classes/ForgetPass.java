package classes;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ForgetPass extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField userField;
	private JButton exitButton;
	private JButton next;
	private JButton backButton;
	protected static boolean loginFlag;
	protected static int deleteLine;

	public ForgetPass() {
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

		JLabel forget = new JLabel("Reset Password");
		forget.setForeground(Color.WHITE);
		forget.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		forget.setBounds(363, 10, 147, 50);
		contentPane.add(forget);

		JLabel username = new JLabel("Username:");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		username.setBounds(504, 236, 94, 25);
		contentPane.add(username);

		userField = new JTextField();
		userField.setBounds(608, 237, 180, 25);
		Font userfieldFont = new Font("Times New Roman", Font.BOLD, 18);
		userField.setFont(userfieldFont);
		userField.setVisible(true);
		userField.setOpaque(false);
		userField.setForeground(new Color(219, 226, 233));
		userField.setBorder(BorderFactory.createEmptyBorder());
		Border redBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(179, 63, 64));
		userField.setBorder(redBorder);
		contentPane.add(userField);

		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		exitButton.setBounds(809, 486, 70, 21);
		contentPane.add(exitButton);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		backButton.setBounds(10, 486, 70, 21);
		contentPane.add(backButton);

		JLabel imgLabel = new JLabel("New label");
		imgLabel.setBounds(10, 70, 456, 369);
		BufferedImage imgForget = null;
		try {
			imgForget = ImageIO.read(Login.class.getResource("/images/Forget1.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Image imgFORGET = imgForget.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
		imgLabel.setIcon(new ImageIcon(imgFORGET));
		contentPane.add(imgLabel);

		next = new JButton("Next");
		next.setBounds(715, 272, 70, 21);
		contentPane.add(next);

		next.addActionListener(this);
		backButton.addActionListener(this);
		exitButton.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = "User Name : " + userField.getText();
		String user1 = userField.getText();
		boolean userEmpty = user1.isEmpty();
		boolean isFound = false;
		int totalLines = 0;

		if (e.getSource() == next) {
			try {
				File userfile = new File(".\\files\\user_login.txt");
				if (userfile.exists()) {
					BufferedReader readFile = new BufferedReader(new FileReader(".\\files\\user_login.txt"));

					while (readFile.readLine() != null) {
						totalLines++;
					}
					readFile.close();
				}

				if (userEmpty == true) {
					JOptionPane.showMessageDialog(null, "Enter User Name", "Error", JOptionPane.WARNING_MESSAGE);
					isFound = false;
				} else {

					for (int i = 0; i < totalLines; i++) {

						String line = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(i);
						if (line.equals(user)) {
							deleteLine = i;
							isFound = true;
							break;

						}
					}
					if (isFound == true) {
						this.setVisible(false);
						new ForgetPass2();
					} else {
						JOptionPane.showMessageDialog(null, "Username not found", "Error", JOptionPane.WARNING_MESSAGE);
					}

				}

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(null, "Username not found", "Error", JOptionPane.WARNING_MESSAGE);

			}

		} else if (e.getSource() == exitButton) {
			int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!", JOptionPane.YES_NO_OPTION);

			if (yesORno == 0) {
				System.exit(1);
			}
		} else if (e.getSource() == backButton) {
			this.setVisible(false);
			new Login();
		}

	}
}
