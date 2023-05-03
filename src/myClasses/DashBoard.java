package myClasses;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class DashBoard extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField chkField_2;
    private JTextField textField;
    private JTextField manage_lbl;
    private JButton Manage_btn;
    private JButton userButton;
    private JButton logoutButton;
    private JButton chkinButton;
    private JButton chkoutButton;

    // public static void main(String[] args) {
    // 	new Main();
    // 	// EventQueue.invokeLater(new Runnable() {
    // 	// 	public void run() {
    // 	// 		try {
    // 	// 			new Main();
    // 	// 		} catch (Exception e) {
    // 	// 			e.printStackTrace();
    // 	// 		}
    // 	// 	}
    // 	// });
    // }

    /**
     * Create the frame.
     */
    public DashBoard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 819, 580);
        contentPane = new JPanel();
        contentPane.setForeground(Color.LIGHT_GRAY);
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        userButton = new JButton("User");
        userButton.setBackground(Color.DARK_GRAY);
        userButton.setForeground(Color.WHITE);
        userButton.setFocusable(false);
        userButton.setBounds(10, 11, 72, 31);
        contentPane.add(userButton);

        logoutButton = new JButton("Log Out");
        // logoutButton.setForeground(Color.WHITE);
        // logoutButton.setBackground(Color.DARK_GRAY);
        logoutButton.setFocusable(false);
        logoutButton.setBounds(704, 15, 89, 23);
        contentPane.add(logoutButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBackground(Color.DARK_GRAY);
        scrollPane.setBounds(161, 49, 632, 481);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "Customer Name", "Room Number", "Room Type", "Bed", "Price", "Status" }));
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);

        chkinButton = new JButton("Start Booking");
        chkinButton.setBounds(34, 150, 90, 70);
        chkoutButton = new JButton("Cancel Booking");
        chkoutButton.setBounds(34, 271, 90, 70);

        BufferedImage checkIn = null;
        BufferedImage checkOut = null;
        BufferedImage mngRoomPhoto = null;
        try {


            checkIn = ImageIO.read(DashBoard.class.getResource("../images/check_in.png"));

            checkOut = ImageIO.read(DashBoard.class.getResource("../images/check_out.png"));

            mngRoomPhoto = ImageIO.read(DashBoard.class.getResource("../images/room.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Image chkIn = checkIn.getScaledInstance(chkinButton.getWidth(), chkinButton.getHeight(), Image.SCALE_SMOOTH);
        Image chkOut = checkOut.getScaledInstance(chkoutButton.getWidth(), chkoutButton.getHeight(),Image.SCALE_SMOOTH);

        chkinButton.setIcon(new ImageIcon(chkIn));
        chkinButton.setForeground(Color.WHITE);
        chkinButton.setBackground(Color.DARK_GRAY);

        chkoutButton.setIcon(new ImageIcon(chkOut));
        chkoutButton.setForeground(Color.WHITE);
        chkoutButton.setBackground(Color.DARK_GRAY);

        contentPane.add(chkinButton);
        contentPane.add(chkoutButton);

        chkField_2 = new JTextField();
        chkField_2.setHorizontalAlignment(SwingConstants.CENTER);
        chkField_2.setBorder(null);
        chkField_2.setText("Check Out");
        chkField_2.setForeground(Color.WHITE);
        chkField_2.setBackground(Color.DARK_GRAY);
        chkField_2.setBounds(34, 349, 89, 20);
        contentPane.add(chkField_2);
        chkField_2.setColumns(10);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setText("Check In");
        textField.setForeground(Color.WHITE);
        textField.setColumns(10);
        textField.setBorder(null);
        textField.setBackground(Color.DARK_GRAY);
        textField.setBounds(34, 216, 89, 23);
        contentPane.add(textField);

        Manage_btn = new JButton("Manage Room");
        Manage_btn.setBounds(34, 379, 90, 70);
        Image mngRoom = mngRoomPhoto.getScaledInstance(Manage_btn.getWidth(), Manage_btn.getHeight(),Image.SCALE_SMOOTH);
        Manage_btn.setIcon(new ImageIcon(mngRoom));
        Manage_btn.setForeground(Color.WHITE);
        Manage_btn.setBackground(Color.DARK_GRAY);
        contentPane.add(Manage_btn);

        manage_lbl = new JTextField();
        manage_lbl.setText("Manage Room");
        manage_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        manage_lbl.setForeground(Color.WHITE);
        manage_lbl.setColumns(10);
        manage_lbl.setBorder(null);
        manage_lbl.setBackground(Color.DARK_GRAY);
        manage_lbl.setBounds(34, 459, 89, 20);
        contentPane.add(manage_lbl);

        logoutButton.addActionListener(this);
        chkinButton.addActionListener(this);
        chkoutButton.addActionListener(this);
        Manage_btn.addActionListener(this);
        setVisible(true);
    }

    // private JButton Manage_btn;
    // private JButton userButton;
    // private JButton logoutButton;
    // private JButton chkinButton;
    // private JButton chkoutButton;

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == logoutButton){
            setVisible(false);
            //new login
        }else if(e.getSource() == chkinButton){
            setVisible(false);
            new CheckIn();
        }else if(e.getSource() == chkoutButton){
            setVisible(false);
            new CheckOut();
        }else if(e.getSource() == Manage_btn){
            setVisible(false);
            //new ManageRoom();
        }
    }
}
