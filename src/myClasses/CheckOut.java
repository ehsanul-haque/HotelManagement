package myClasses;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CheckOut extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField custName_fld;
    private JTextField custNum_fld;
    private JTextField checkInDate_fld;
    private JTextField checkOut_fld;
    private JTextField pricePerDay_fld;
    private JTextField dayStay_fld;
    private JTextField totalAmount_fld;
    private JTextField email_fld;
    private JTextField roomNum_fld;
    private JButton logOut_btn;
    private JButton back_btn;
    private JButton checkOut_btn;
    private JButton clear_btn;
    private JButton search_btn;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOut frame = new CheckOut();
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
    public CheckOut() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 927, 533);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        setContentPane(contentPane);
        contentPane.setLayout(null);

        logOut_btn = new JButton("Log Out");
        logOut_btn.setBounds(812, 11, 89, 23);
        logOut_btn.setFocusable(false);
        contentPane.add(logOut_btn);

        JLabel checkOut_lbl = new JLabel("CheckOut");
        checkOut_lbl.setForeground(Color.LIGHT_GRAY);
        checkOut_lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        checkOut_lbl.setBounds(10, 3, 180, 34);
        contentPane.add(checkOut_lbl);

        back_btn = new JButton("Back");
        back_btn.setBounds(702, 11, 89, 23);
        back_btn.setFocusable(false);
        contentPane.add(back_btn);

        JLabel custName_lbl = new JLabel("Customer Name");
        custName_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        custName_lbl.setForeground(Color.WHITE);
        custName_lbl.setBounds(21, 80, 150, 23);
        contentPane.add(custName_lbl);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 318, 891, 139);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);


        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Name", "Mobile Number", "Nationality", "Gender", "Email", "Address", "Check In Data", "Room Number", "Bed", "Room Type", "Price Per Day"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(82);

        JLabel checkInDate_lbl = new JLabel("Check In Date");
        checkInDate_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        checkInDate_lbl.setForeground(Color.WHITE);
        checkInDate_lbl.setBounds(251, 80, 97, 23);
        contentPane.add(checkInDate_lbl);

        JLabel checkOutDate_lbl = new JLabel("Check Out (Today)");
        checkOutDate_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        checkOutDate_lbl.setForeground(Color.WHITE);
        checkOutDate_lbl.setBounds(479, 80, 150, 23);
        contentPane.add(checkOutDate_lbl);

        JLabel custNum_lbl = new JLabel("Customer Mobile Number");
        custNum_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        custNum_lbl.setForeground(Color.WHITE);
        custNum_lbl.setBounds(702, 78, 180, 26);
        contentPane.add(custNum_lbl);

        custName_fld = new JTextField();
        custName_fld.setBounds(21, 113, 151, 20);
        custName_fld.setEditable(false);
        contentPane.add(custName_fld);
        custName_fld.setColumns(10);

        custNum_fld = new JTextField();
        custNum_fld.setColumns(10);
        custNum_fld.setEditable(false);
        custNum_fld.setBounds(702, 113, 160, 20);
        contentPane.add(custNum_fld);

        checkOut_btn = new JButton("Check Out");
        checkOut_btn.setBounds(25, 284, 97, 23);
        checkOutDate_lbl.setFocusable(false);
        contentPane.add(checkOut_btn);

        checkInDate_fld = new JTextField();
        checkInDate_fld.setColumns(10);
        checkInDate_fld.setEditable(false);
        checkInDate_fld.setBounds(251, 114, 151, 20);
        contentPane.add(checkInDate_fld);

        checkOut_fld = new JTextField();
        checkOut_fld.setColumns(10);
        checkOut_fld.setEditable(false);
        checkOut_fld.setBounds(479, 113, 151, 20);
        contentPane.add(checkOut_fld);

        JLabel priceDay_lbl = new JLabel("Price Per Day");
        priceDay_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        priceDay_lbl.setForeground(Color.WHITE);
        priceDay_lbl.setBounds(21, 168, 89, 23);
        contentPane.add(priceDay_lbl);

        JLabel numberOfDays_lbl = new JLabel("Number Of Days Stay");
        numberOfDays_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        numberOfDays_lbl.setForeground(Color.WHITE);
        numberOfDays_lbl.setBounds(251, 168, 180, 23);
        contentPane.add(numberOfDays_lbl);

        JLabel totalAmount_lbl = new JLabel("Total Amount");
        totalAmount_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        totalAmount_lbl.setForeground(Color.WHITE);
        totalAmount_lbl.setBounds(479, 168, 126, 23);
        contentPane.add(totalAmount_lbl);

        JLabel email_lbl = new JLabel("Email");
        email_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        email_lbl.setForeground(Color.WHITE);
        email_lbl.setBounds(702, 166, 44, 26);
        contentPane.add(email_lbl);

        pricePerDay_fld = new JTextField();
        pricePerDay_fld.setColumns(10);
        pricePerDay_fld.setEditable(false);
        pricePerDay_fld.setBounds(21, 201, 151, 20);
        contentPane.add(pricePerDay_fld);

        dayStay_fld = new JTextField();
        dayStay_fld.setColumns(10);
        dayStay_fld.setEditable(false);
        dayStay_fld.setBounds(251, 202, 151, 20);
        contentPane.add(dayStay_fld);

        totalAmount_fld = new JTextField();
        totalAmount_fld.setColumns(10);
        totalAmount_fld.setEditable(false);
        totalAmount_fld.setBounds(479, 201, 151, 20);
        contentPane.add(totalAmount_fld);

        email_fld = new JTextField();
        email_fld.setColumns(10);
        email_fld.setEditable(false);
        email_fld.setBounds(702, 201, 160, 20);
        contentPane.add(email_fld);

        JLabel roomNum_lbl = new JLabel("Room Number");
        roomNum_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
        roomNum_lbl.setForeground(Color.WHITE);
        roomNum_lbl.setBounds(187, 32, 106, 23);
        contentPane.add(roomNum_lbl);

        roomNum_fld = new JTextField();
        roomNum_fld.setColumns(10);
        roomNum_fld.setBounds(303, 35, 151, 20);
        contentPane.add(roomNum_fld);

        search_btn = new JButton("Search");
        search_btn.setBounds(491, 32, 89, 23);
        search_btn.setFocusable(false);
        contentPane.add(search_btn);

        clear_btn = new JButton("Clear");
        clear_btn.setBounds(160, 284, 97, 23);
        clear_btn.setFocusable(false);
        contentPane.add(clear_btn);

        logOut_btn.addActionListener(this);
        back_btn.addActionListener(this);
        checkOut_btn.addActionListener(this);
        clear_btn.addActionListener(this);
        search_btn.addActionListener(this);

        this.setVisible(true);

    }

    // private JButton logOut_btn;
    // private JButton back_btn;
    // private JButton clear_btn;
    // private JButton search_btn;
    // private JButton checkOut_btn;

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == logOut_btn){
            setVisible(false);
            //new SignIn
        }else if(e.getSource() == back_btn){
            setVisible(false);
            new DashBoard();
        }else if(e.getSource() == clear_btn){
            custName_fld.setText(null);
            custNum_fld.setText(null);
            checkInDate_fld.setText(null);
            checkOut_fld.setText(null);
            pricePerDay_fld.setText(null);
            dayStay_fld.setText(null);
            totalAmount_fld.setText(null);
            email_fld.setText(null);
            roomNum_fld.setText(null);
        }else if(e.getSource() == search_btn){

        }else if(e.getSource() == checkOut_btn){

        }
    }
}
