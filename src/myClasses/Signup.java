package myClasses;



import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class Signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField, confirmPassField;
    private JToggleButton EyeBtn, EyeBtn2;
    private JTextField fullField;
    private ImageIcon on, off;
    private JButton signin, signup;
    private JButton exitButton;
    private JTextField phoneNumberField;



    public Signup() {
        setTitle("The Tipon Hotel Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("../images/titleIcon.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 903, 554);
        contentPane = new JPanel();
        contentPane.setForeground(Color.LIGHT_GRAY);
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel SignUpText = new JLabel("SIGN UP");
        SignUpText.setForeground(new Color(215, 210, 203));
        SignUpText.setFont(new Font("Verdana", Font.BOLD, 22));
        SignUpText.setBounds(373, 10, 114, 30);
        contentPane.add(SignUpText);

        JLabel fullName = new JLabel("Full Name :");
        fullName.setForeground(Color.WHITE);
        fullName.setFont(new Font("Verdana", Font.PLAIN, 17));
        fullName.setBounds(191, 68, 106, 30);
        contentPane.add(fullName);

        fullField = new JTextField();
        fullField.setBounds(373, 68, 248, 30);
        Font fullFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        fullField.setFont(fullFieldFont);
        fullField.setOpaque(false);
        fullField.setForeground(new Color(219, 226, 233));
        fullField.setBorder(BorderFactory.createEmptyBorder());
        Border Border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
        fullField.setBorder(Border);
        contentPane.add(fullField);

        JLabel username = new JLabel("User Name :");
        username.setBounds(191, 105, 114, 30);
        Font usernameFont = new Font("Verdana", Font.PLAIN, 17);
        username.setFont(usernameFont);
        username.setForeground(Color.white);
        contentPane.add(username);

        usernameField = new JTextField();
        usernameField.setBounds(373, 105, 248, 30);
        Font userfieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        usernameField.setFont(userfieldFont);
        usernameField.setOpaque(false);
        usernameField.setForeground(new Color(219, 226, 233));
        usernameField.setBorder(BorderFactory.createEmptyBorder());
        usernameField.setBorder(Border);
        contentPane.add(usernameField);

        JLabel phoneNumber = new JLabel("Phone Number :");
        phoneNumber.setForeground(Color.WHITE);
        phoneNumber.setFont(new Font("Verdana", Font.PLAIN, 17));
        phoneNumber.setBounds(191, 148, 150, 27);
        contentPane.add(phoneNumber);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(373, 148, 248, 30);
        Font emailFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
        phoneNumberField.setFont(emailFieldFont);
        phoneNumberField.setOpaque(false);
        phoneNumberField.setForeground(new Color(219, 226, 233));
        phoneNumberField.setBorder(BorderFactory.createEmptyBorder());
        phoneNumberField.setBorder(Border);
        contentPane.add(phoneNumberField);

        JLabel password = new JLabel("Password :");
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Verdana", Font.PLAIN, 17));
        password.setBounds(191, 189, 106, 30);
        contentPane.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(373, 189, 248, 30);
        Font passfieldFont = new Font("Verdana", Font.PLAIN, 18);
        passwordField.setFont(passfieldFont);
        passwordField.setEchoChar('*');
        passwordField.setOpaque(false);
        passwordField.setForeground(new Color(219, 226, 233));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setBorder(Border);
        contentPane.add(passwordField);

        JLabel confirmPassTxt = new JLabel("Confirm Password :");
        confirmPassTxt.setForeground(Color.WHITE);
        confirmPassTxt.setFont(new Font("Verdana", Font.PLAIN, 17));
        confirmPassTxt.setBounds(190, 229, 173, 30);
        contentPane.add(confirmPassTxt);

        confirmPassField = new JPasswordField();
        confirmPassField.setBounds(373, 229, 248, 30);
        Font confirmPassFieldFont = new Font("Verdana", Font.PLAIN, 18);
        confirmPassField.setFont(confirmPassFieldFont);
        confirmPassField.setEchoChar('*');
        confirmPassField.setOpaque(false);
        confirmPassField.setForeground(new Color(219, 226, 233));
        confirmPassField.setBorder(BorderFactory.createEmptyBorder());
        confirmPassField.setBorder(Border);
        contentPane.add(confirmPassField);

        BufferedImage imgOn = null;
        BufferedImage imgOff = null;
        try {
            imgOn = ImageIO.read(Login.class.getResource("../images/show.png"));

            imgOff = ImageIO.read(Login.class.getResource("../images/hide.png"));

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
        EyeBtn.setBounds(624, 189, 29, 30);
        contentPane.add(EyeBtn);

        EyeBtn2 = new JToggleButton(off);
        EyeBtn2.setOpaque(false);
        EyeBtn2.setOpaque(false);
        EyeBtn2.setForeground(Color.DARK_GRAY);
        EyeBtn2.setBackground(Color.DARK_GRAY);
        EyeBtn2.setBounds(624, 229, 29, 30);
        contentPane.add(EyeBtn2);

        signin = new JButton("Already have an account?");
        signin.setForeground(Color.LIGHT_GRAY);
        signin.setBackground(Color.DARK_GRAY);
        signin.setBounds(327, 378, 196, 47);
        contentPane.add(signin);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        exitButton.setBounds(809, 486, 70, 21);
        contentPane.add(exitButton);

        signup = new JButton("Sign up");
        signup.setBounds(380, 303, 85, 21);
        contentPane.add(signup);

        exitButton.addActionListener(this);
        signin.addActionListener(this);
        EyeBtn.addActionListener(this);
        EyeBtn2.addActionListener(this);
        signup.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = String.valueOf(passwordField.getPassword());
        String confpass = String.valueOf(confirmPassField.getPassword());
        String name = fullField.getText();
        String em = phoneNumberField.getText();
        boolean userEmpty = user.isEmpty();
        boolean passEmpty = pass.isEmpty();
        boolean confEmpty = confpass.isEmpty();
        boolean nameEmpty = name.isEmpty();
        boolean emailEmpty = em.isEmpty();
        boolean check = pass.equals(confpass);
        int numcount = 0;

        try {

            if (em.length() != 11)
                numcount++;
        } catch (Exception ex) {
            numcount = 1;
        }

        if (e.getSource() == signup) {

            if (userEmpty == true || passEmpty == true || confEmpty == true || nameEmpty == true
                    || emailEmpty == true) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Error!",
                        JOptionPane.WARNING_MESSAGE);
            } else if (numcount > 0) {
                JOptionPane.showMessageDialog(null, "Invalid Phone Number", " Error!", JOptionPane.WARNING_MESSAGE);
            } else if (check == false) {
                JOptionPane.showMessageDialog(null, "Password is not matching", " Error!", JOptionPane.WARNING_MESSAGE);
            }

            else {
                try {
                    File file = new File("./files/user_login.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);

                    LocalDateTime myDateObj = LocalDateTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                    String timeAndDate = myDateObj.format(myFormatObj);

                    // User Login file checked
                    int totalLines = 0;
                    BufferedReader readFile = new BufferedReader(new FileReader("./files/user_login.txt"));
                    while (readFile.readLine() != null) {
                        totalLines++;
                    }
                    readFile.close();

                    // Admin login file checked
                    BufferedReader adminFile = new BufferedReader(new FileReader("./files/admin_login.txt"));
                    int totalLines2 = 0;
                    while (adminFile.readLine() != null) {
                        totalLines2++;
                    }
                    adminFile.close();

                    boolean userflag = false;
                    boolean adminflag = false;

                    // for user
                    for (int i = 0; i < totalLines; i++) {
                        String line = Files.readAllLines(Paths.get("./files/user_login.txt")).get(i);
                        if (line.equals("User Name : " + user)) {
                            userflag = true;
                            break;
                        }
                    }

                    // for admin
                    for (int i = 0; i < totalLines2; i++) {
                        String line = Files.readAllLines(Paths.get("./files/admin_login.txt")).get(i);
                        if (line.equals("User Name : " + user)) {
                            adminflag = true;
                            break;
                        }
                    }
                    if (userflag == false && adminflag == false) {
                        printWriter.println("===============================================");
                        printWriter.println("Full Name : " + name);
                        printWriter.println("User Name : " + user);
                        printWriter.println("Password : " + pass);
                        printWriter.println("Phone : " + em);
                        printWriter.println("Time & Date : " + timeAndDate);
                        printWriter.println("===============================================");
                        this.setVisible(false);
                        new Login();

                    } else {
                        JOptionPane.showMessageDialog(null, "User name already taken", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }

                    printWriter.close();

                } catch (Exception ex) {
                    System.out.print(ex);
                }

            }

        }

        else if (e.getSource() == EyeBtn) {
            if (EyeBtn.isSelected()) {
                EyeBtn.setIcon(on);
                passwordField.setEchoChar((char) 0);
            } else {
                EyeBtn.setIcon(off);
                passwordField.setEchoChar('*');
            }
        }

        else if (e.getSource() == EyeBtn2) {
            if (EyeBtn2.isSelected()) {
                EyeBtn2.setIcon(on);
                confirmPassField.setEchoChar((char) 0);
            } else {
                EyeBtn2.setIcon(off);
                confirmPassField.setEchoChar('*');
            }
        }

        else if (e.getSource() == signin) {
            this.setVisible(false);
            new Login();
        }

        else if (e.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Alart!", JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        }

    }

}
