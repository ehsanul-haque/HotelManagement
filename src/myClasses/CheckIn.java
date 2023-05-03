package myClasses;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CheckIn extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField name_field;
    private JTextField mbl_fld;
    private JTextField nationality_fld;
    private JTextField gmail_fld;
    private JTextField address_fld;
    private JTextField date_fld;
    private JTextField cost_fld;
    private JLabel Address;
    private JLabel Date;
    private JLabel bed_lbl;
    private JLabel roomType_lbl;
    private JLabel roomNo_lbl;
    private JLabel cost_lbl;
    private JComboBox bed_Box;
    private JComboBox roomType_Box;
    private JComboBox roomNo_Box;
    private JComboBox gender_Box;
    private JButton back_btn;
    private JButton confirm_btn;
    private JButton clear_btn;
    private JButton logOut_Btn;

    /**
     * Launch the application.
     //  */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckIn frame = new CheckIn();
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
    public CheckIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 927, 533);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel checkIn_lbl = new JLabel("Check In");
        checkIn_lbl.setForeground(Color.LIGHT_GRAY);
        checkIn_lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        checkIn_lbl.setBounds(10, 3, 180, 34);
        contentPane.add(checkIn_lbl);

        JLabel fullName_lbl = new JLabel("Full Name");
        fullName_lbl.setForeground(Color.WHITE);
        fullName_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        fullName_lbl.setBounds(10, 74, 141, 34);
        contentPane.add(fullName_lbl);

        name_field = new JTextField();
        name_field.setBounds(10, 109, 218, 20);
        contentPane.add(name_field);
        name_field.setColumns(10);

        JLabel mblNum_lbl = new JLabel("Mobile Number");
        mblNum_lbl.setForeground(Color.WHITE);
        mblNum_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        mblNum_lbl.setBounds(10, 151, 141, 34);
        contentPane.add(mblNum_lbl);

        JLabel nationality_lbl = new JLabel("Nationality");
        nationality_lbl.setForeground(Color.WHITE);
        nationality_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        nationality_lbl.setBounds(10, 231, 141, 34);
        contentPane.add(nationality_lbl);

        JLabel gender_lbl = new JLabel("Gender");
        gender_lbl.setForeground(Color.WHITE);
        gender_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        gender_lbl.setBounds(10, 298, 141, 34);
        contentPane.add(gender_lbl);

        JLabel gmail_lbl = new JLabel("Gmail");
        gmail_lbl.setForeground(Color.WHITE);
        gmail_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        gmail_lbl.setBounds(10, 379, 141, 34);
        contentPane.add(gmail_lbl);

        mbl_fld = new JTextField();
        mbl_fld.setColumns(10);
        mbl_fld.setBounds(10, 187, 218, 20);
        contentPane.add(mbl_fld);

        nationality_fld = new JTextField();
        nationality_fld.setColumns(10);
        nationality_fld.setBounds(10, 267, 218, 20);
        contentPane.add(nationality_fld);

        gmail_fld = new JTextField();
        gmail_fld.setColumns(10);
        gmail_fld.setBounds(10, 415, 218, 20);
        contentPane.add(gmail_fld);

        gender_Box = new JComboBox();
        gender_Box.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
        gender_Box.setBounds(10, 342, 76, 22);
        contentPane.add(gender_Box);

        Address = new JLabel("Address");
        Address.setForeground(Color.WHITE);
        Address.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        Address.setBounds(324, 74, 141, 34);
        contentPane.add(Address);

        address_fld = new JTextField();
        address_fld.setColumns(10);
        address_fld.setBounds(324, 109, 218, 20);
        contentPane.add(address_fld);

        date_fld = new JTextField();
        date_fld.setColumns(10);
        date_fld.setBounds(324, 187, 218, 20);
        date_fld.setEditable(false);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        date_fld.setText(myFormat.format(cal.getTime()));
        contentPane.add(date_fld);

        Date = new JLabel("Date(Today)");
        Date.setForeground(Color.WHITE);
        Date.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        Date.setBounds(324, 151, 141, 34);
        contentPane.add(Date);

        bed_lbl = new JLabel("Bed");
        bed_lbl.setForeground(Color.WHITE);
        bed_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        bed_lbl.setBounds(650, 74, 141, 34);
        contentPane.add(bed_lbl);

        roomType_lbl = new JLabel("Room Type");
        roomType_lbl.setForeground(Color.WHITE);
        roomType_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        roomType_lbl.setBounds(650, 152, 141, 34);
        contentPane.add(roomType_lbl);

        roomNo_lbl = new JLabel("Room No");
        roomNo_lbl.setForeground(Color.WHITE);
        roomNo_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        roomNo_lbl.setBounds(650, 231, 141, 34);
        contentPane.add(roomNo_lbl);

        cost_lbl = new JLabel("Total Cost");
        cost_lbl.setForeground(Color.WHITE);
        cost_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        cost_lbl.setBounds(650, 309, 141, 34);
        contentPane.add(cost_lbl);

        cost_fld = new JTextField();
        cost_fld.setEditable(false);
        cost_fld.setColumns(10);
        cost_fld.setText("1000");
        cost_fld.setBounds(650, 344, 218, 20);
        contentPane.add(cost_fld);

        bed_Box = new JComboBox();
        bed_Box.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Triple"}));
        bed_Box.setBounds(650, 108, 133, 22);
        contentPane.add(bed_Box);

        roomType_Box = new JComboBox();
        roomType_Box.setModel(new DefaultComboBoxModel(new String[] {"AC", "Non AC"}));
        roomType_Box.setBounds(650, 186, 133, 22);
        contentPane.add(roomType_Box);

        roomNo_Box = new JComboBox();
        roomNo_Box.setBounds(650, 266, 133, 22);
        contentPane.add(roomNo_Box);

        back_btn = new JButton("Back");
        back_btn.setBounds(779, 435, 89, 23);
        contentPane.add(back_btn);

        confirm_btn = new JButton("Confirm Book");
        confirm_btn.setBackground(Color.DARK_GRAY);
        confirm_btn.setForeground(Color.WHITE);
        confirm_btn.setBounds(261, 399, 176, 52);
        confirm_btn.setFocusable(false);
        contentPane.add(confirm_btn);

        clear_btn = new JButton("Clear All");
        clear_btn.setBackground(Color.DARK_GRAY);
        clear_btn.setForeground(Color.WHITE);
        clear_btn.setBounds(473, 399, 176, 52);
        clear_btn.setFocusable(false);
        contentPane.add(clear_btn);

        logOut_Btn = new JButton("Log Out");
        logOut_Btn.setBounds(812, 11, 89, 23);
        contentPane.add(logOut_Btn);

        back_btn.addActionListener(this);
        confirm_btn.addActionListener(this);
        clear_btn.addActionListener(this);
        logOut_Btn.addActionListener(this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        String name = name_field.getText();
        String mblnum = mbl_fld.getText();
        String nationality = nationality_fld.getText();
        String gamil = gmail_fld.getText();
        String address = address_fld.getText();
        String chkindate = date_fld.getText();
        String cost = cost_fld.getText();

        boolean nameEmpty = name_field.getText().isEmpty();
        boolean mblnumEmpty = mbl_fld.getText().isEmpty();
        boolean nationalityEmpty = nationality_fld.getText().isEmpty();
        boolean gamilEmpty = gmail_fld.getText().isEmpty();
        boolean addressEmpty = address_fld.getText().isEmpty();
        boolean chkindateEmpty = date_fld.getText().isEmpty();
        boolean costEmpty = cost_fld.getText().isEmpty();


        if(e.getSource() == back_btn){
            this.setVisible(false);
            new DashBoard();
        }else if(e.getSource() == logOut_Btn){
            setVisible(false);
            //new Login
        }else if(e.getSource() == clear_btn){
            name_field.setText(null);
            mbl_fld.setText(null);
            nationality_fld.setText(null);
            gmail_fld.setText(null);
            address_fld.setText(null);
            cost_fld.setText(null);
            gender_Box.setSelectedIndex(0);
            bed_Box.setSelectedIndex(0);
            roomType_Box.setSelectedIndex(0);
            roomNo_Box.setSelectedIndex(0);
        }else if(e.getSource() == confirm_btn){
            if(nameEmpty == false && mblnumEmpty == false && nationalityEmpty == false && gamilEmpty == false && addressEmpty == false && chkindateEmpty == false && 	costEmpty == false){
                try{
                    int p = Integer.parseInt(cost);
                    String line = "D://hotel//files//checkIn.txt";
                    try{
                        File file = new File(line );
                        if (!file.exists()) {
                            file.createNewFile();
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);
                            printWriter.close();
                        }
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        PrintWriter printWriter = new PrintWriter(bufferedWriter);
                        printWriter.println("Check In Details");
                        printWriter.println(name);
                        printWriter.println(mblnum);
                        printWriter.println(nationality);
                        printWriter.println(gamil);
                        printWriter.println(address);
                        printWriter.println(chkindate);
                        printWriter.println(cost);
                        printWriter.println("Not Booked");
                        printWriter.println();
                        printWriter.close();

                        JOptionPane.showMessageDialog(null, "Congratulation Check In successful", "Congratulation", JOptionPane.INFORMATION_MESSAGE);

                        name_field.setText(null);
                        mbl_fld.setText(null);
                        nationality_fld.setText(null);
                        gmail_fld.setText(null);
                        address_fld.setText(null);
                        cost_fld.setText(null);
                        gender_Box.setSelectedIndex(0);
                        bed_Box.setSelectedIndex(0);
                        roomType_Box.setSelectedIndex(0);
                        roomNo_Box.setSelectedIndex(0);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }catch (Exception ex) {
                    System.out.println(ex);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Please Fill all the box", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
