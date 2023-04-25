package classes;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ForgetPass2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton backButton;
	private JButton exitButton;
	private JButton next2;
	private JTextField phoneField;

	public ForgetPass2() {
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

		JTextField phoneField = new JTextField();
		phoneField.setBounds(592, 247, 180, 30);
		Font phoneFieldFont = new Font("Times New Roman", Font.BOLD, 18);
		phoneField.setFont(phoneFieldFont);
		phoneField.setOpaque(false);
		phoneField.setForeground(new Color(219, 226, 233));
		phoneField.setBorder(BorderFactory.createEmptyBorder());
		Border redBorder1 = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(179, 63, 64));
		phoneField.setBorder(redBorder1);
		phoneField.setVisible(true);
		contentPane.add(phoneField);

		next2 = new JButton("Next");
		next2.setBounds(702, 287, 70, 21);
		contentPane.add(next2);

		JLabel phone = new JLabel("Phone No :");
		phone.setForeground(Color.WHITE);
		phone.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		phone.setBounds(473, 248, 109, 25);
		contentPane.add(phone);

		try {
			int k = ((ForgetPass.deleteLine) + 2);
			String line1 = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(k);
			String line2 = "";
			line2 = line2 + line1.charAt(16);
			line2 = line2 + line1.charAt(17);
			line2 = line2 + line1.charAt(18);

			JLabel hintphn = new JLabel("Hint :xxxxxxxx" + line2);
			hintphn.setBounds(592, 207, 180, 30);
			hintphn.setForeground(new Color(245, 242, 208, 150));
			Font hintphnFont = new Font("Verdana", Font.BOLD, 14);
			hintphn.setFont(hintphnFont);
			hintphn.setVisible(true);
			contentPane.add(hintphn);

			exitButton = new JButton("Exit");
			exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
			exitButton.setBounds(809, 486, 70, 21);
			contentPane.add(exitButton);

			backButton = new JButton("Back");
			backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
			backButton.setBounds(10, 486, 70, 21);
			contentPane.add(backButton);

			JLabel imgLabel = new JLabel("New label");
			imgLabel.setBounds(10, 105, 453, 343);
			BufferedImage imgForget = null;
			try {
				imgForget = ImageIO.read(Login.class.getResource("/images/Forget2.png"));

			} catch (IOException e) {
				e.printStackTrace();
			}
			Image imgFORGET = imgForget.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(),
					Image.SCALE_SMOOTH);
			imgLabel.setIcon(new ImageIcon(imgFORGET));
			contentPane.add(imgLabel);

			JLabel forget = new JLabel("Reset Password");
			forget.setForeground(Color.WHITE);
			forget.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			forget.setBounds(363, 10, 147, 50);
			contentPane.add(forget);

		} catch (Exception e) {
			System.out.println(e);
		}

		next2.addActionListener(this);
		backButton.addActionListener(this);
		exitButton.addActionListener(this);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = "Phone : " + phoneField.getText();
		String user1 = phoneField.getText();
		boolean userEmpty = user1.isEmpty();
		boolean isFound = false;
		if (e.getSource() == next2) {

			try {
				if (userEmpty == true) {

					JOptionPane.showMessageDialog(null, "Enter phone number", "Error", JOptionPane.WARNING_MESSAGE);

				} else if (userEmpty == false) {

					int n = ((ForgetPass.deleteLine) + 2);
					BufferedReader readFile = new BufferedReader(new FileReader(".\\files\\user_login.txt"));
					String line = Files.readAllLines(Paths.get(".\\files\\user_login.txt")).get(n);
					if (line.equals(user)) {
						isFound = true;

					} else {
						isFound = false;
					}

					if (isFound == false) {
						JOptionPane.showMessageDialog(null, "Phone number not found!", "Error",
								JOptionPane.WARNING_MESSAGE);
					} else {
						this.setVisible(false);
						new ForgetPass3();
					}
					readFile.close();

				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Phone number not found!", "Error", JOptionPane.WARNING_MESSAGE);

			}
		} else if (e.getSource() == exitButton) {
			int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!", JOptionPane.YES_NO_OPTION);

			if (yesORno == 0) {
				System.exit(1);
			}
		} else if (e.getSource() == backButton) {
			this.setVisible(false);
			new ForgetPass();
		}

	}
}
