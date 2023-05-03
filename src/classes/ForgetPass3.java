

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class ForgetPass3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JToggleButton EyeBtn2;
	private JToggleButton EyeBtn1;
	private JButton next2;
	private ImageIcon on;
	private ImageIcon off;
	private JPasswordField newPass;
	private JPasswordField confpass;
	private JButton exitButton;
	private JButton backButton;

	public ForgetPass3() {
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

		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		exitButton.setBounds(809, 486, 70, 21);
		contentPane.add(exitButton);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		backButton.setBounds(10, 486, 70, 21);
		contentPane.add(backButton);

		JLabel forget = new JLabel("Reset Password");
		forget.setForeground(Color.WHITE);
		forget.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		forget.setBounds(363, 10, 147, 50);
		contentPane.add(forget);

		JLabel newPasslabel = new JLabel("New Password :");
		newPasslabel.setForeground(Color.WHITE);
		newPasslabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		newPasslabel.setBounds(469, 224, 147, 37);
		contentPane.add(newPasslabel);

		newPass = new JPasswordField();
		newPass.setBounds(648, 224, 180, 37);
		Font newPasslFont = new Font("Monospace", Font.BOLD, 18);
		newPass.setFont(newPasslFont);
		newPass.setVisible(true);
		newPass.setOpaque(false);
		newPass.setForeground(new Color(219, 226, 233));
		newPass.setBorder(BorderFactory.createEmptyBorder());
		Border redBorder2 = BorderFactory.createMatteBorder(2, 2, 2, 0, new Color(179, 63, 64));
		newPass.setBorder(redBorder2);
		newPass.setEchoChar('*');
		contentPane.add(newPass);

		JLabel confpasslabel = new JLabel("Confirm Password :");
		confpasslabel.setForeground(Color.WHITE);
		confpasslabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		confpasslabel.setBounds(469, 276, 184, 37);
		contentPane.add(confpasslabel);

		confpass = new JPasswordField();
		confpass.setBounds(648, 277, 180, 36);
		Font confpassFont = new Font("Monospace", Font.BOLD, 18);
		confpass.setFont(confpassFont);
		confpass.setOpaque(false);
		confpass.setForeground(new Color(219, 226, 233));
		confpass.setBorder(BorderFactory.createEmptyBorder());
		Border redBorder3 = BorderFactory.createMatteBorder(2, 2, 2, 0, new Color(179, 63, 64));
		confpass.setBorder(redBorder3);
		confpass.setVisible(true);
		confpass.setEchoChar('*');
		contentPane.add(confpass);

		next2 = new JButton("Next");
		next2.setBounds(758, 356, 70, 21);
		contentPane.add(next2);

		on = new ImageIcon("images/tg1.png");
		off = new ImageIcon("images/tg2.png");
		EyeBtn2 = new JToggleButton(off);
		EyeBtn2.setBounds(827, 276, 35, 37);
		EyeBtn2.setBackground(new Color(0, 0, 0, 0));
		EyeBtn2.setForeground(new Color(0, 0, 0, 0));
		EyeBtn2.setOpaque(false);
		EyeBtn2.setBorder(BorderFactory.createEmptyBorder());
		Border redBorder5 = BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(179, 63, 64));
		EyeBtn2.setBorder(redBorder5);
		contentPane.add(EyeBtn2);

		EyeBtn1 = new JToggleButton(off);
		EyeBtn1.setBounds(827, 224, 35, 37);
		EyeBtn1.setBackground(new Color(0, 0, 0, 0));
		EyeBtn1.setForeground(new Color(0, 0, 0, 0));
		EyeBtn1.setOpaque(false);
		EyeBtn1.setBorder(BorderFactory.createEmptyBorder());
		Border redBorder6 = BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(179, 63, 64));
		EyeBtn1.setBorder(redBorder6);
		contentPane.add(EyeBtn1);

		EyeBtn1.addActionListener(this);
		EyeBtn2.addActionListener(this);
		next2.addActionListener(this);
		backButton.addActionListener(this);
		exitButton.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next2) {
			try {
				File userfile = new File(".\\files\\user_login.txt");
				if (userfile.exists()) {
					BufferedReader readFile = new BufferedReader(new FileReader(".\\files\\user_login.txt"));

					while (readFile.readLine() != null) {
					}
					readFile.close();
				}

				String newpass1 = String.valueOf(newPass.getPassword());
				boolean newpass3 = newpass1.isEmpty();

				String confpass1 = String.valueOf(confpass.getPassword());
				String confpass2 = "Password : " + String.valueOf(confpass.getPassword());
				boolean confpass3 = confpass1.isEmpty();
				boolean check = newpass1.equals(confpass1);

				if (newpass3 == true || confpass3 == true) {
					JOptionPane.showMessageDialog(null, "Enter password", "Error", JOptionPane.WARNING_MESSAGE);
				} else if (check == false) {
					JOptionPane.showMessageDialog(null, "Password not matching", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					String tempfile = ".\\files\\temp.txt";
					File oldFile = new File(".\\files\\user_login.txt");
					File newFile = new File(".\\files\\temp.txt");
					int l = 0;

					String currentline;

					FileWriter fileWriter = new FileWriter(tempfile, true);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					PrintWriter printWriter = new PrintWriter(bufferedWriter);

					FileReader fr = new FileReader(".\\files\\user_login.txt");
					BufferedReader br = new BufferedReader(fr);

					int n = (ForgetPass.deleteLine) + 2;
					while ((currentline = br.readLine()) != null) {
						l++;
						if (n != l) {
							printWriter.println(currentline);
						} else {
							printWriter.println(confpass2);
						}
					}
					printWriter.flush();
					printWriter.close();
					fr.close();
					br.close();
					bufferedWriter.close();
					fileWriter.close();

					oldFile.delete();
					File dumb = new File(".\\files\\user_login.txt");
					newFile.renameTo(dumb);
					this.setVisible(false);
					new Login();

				}
			} catch (Exception ex) {
				System.out.println(ex);

			}

		} else if (e.getSource() == exitButton) {
			int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!", JOptionPane.YES_NO_OPTION);

			if (yesORno == 0) {
				System.exit(1);
			}
		} else if (e.getSource() == backButton) {
			this.setVisible(false);
			new ForgetPass();
		} else if (e.getSource() == EyeBtn2) {
			if (EyeBtn2.isSelected()) {
				EyeBtn2.setIcon(on);
				confpass.setEchoChar((char) 0);
			} else {
				EyeBtn2.setIcon(off);
				confpass.setEchoChar('*');
			}
		}

		else if (e.getSource() == EyeBtn1) {
			if (EyeBtn1.isSelected()) {
				EyeBtn1.setIcon(on);
				newPass.setEchoChar((char) 0);
			} else {
				EyeBtn1.setIcon(off);
				newPass.setEchoChar('*');
			}
		}

	}

}
