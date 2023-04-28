package classes;

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField name_field;
	private JTextField mbl_fld;
	private JTextField nationality_fld;
	private JTextField gmail_box;
	private JLabel Address;
	private JTextField address_fld;
	private JTextField date_fld;
	private JLabel Date;
	private JLabel bed_lbl;
	private JLabel roomType_lbl;
	private JLabel roomNo_lbl;
	private JLabel cost_lbl;
	private JTextField cost_fld;
	private JComboBox bed_Box;
	private JComboBox roomType_Box;
	private JComboBox roomNo_Box;

	/**
	 * Launch the application.
	//  */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				CheckIn frame = new CheckIn();
	// 				frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

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
		
		gmail_box = new JTextField();
		gmail_box.setColumns(10);
		gmail_box.setBounds(10, 415, 218, 20);
		contentPane.add(gmail_box);
		
		JComboBox gender_box = new JComboBox();
		gender_box.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		gender_box.setBounds(10, 342, 76, 22);
		contentPane.add(gender_box);
		
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
		
		JButton back_btn = new JButton("Back");
		back_btn.setBounds(779, 435, 89, 23);
		contentPane.add(back_btn);
		
		JButton confirm_btn = new JButton("Confirm Book");
		confirm_btn.setBackground(Color.DARK_GRAY);
        confirm_btn.setForeground(Color.WHITE);
		confirm_btn.setBounds(261, 399, 176, 52);
        confirm_btn.setFocusable(false);
		contentPane.add(confirm_btn);
		
		JButton clear_btn = new JButton("Clear All");
		clear_btn.setBackground(Color.DARK_GRAY);
        clear_btn.setForeground(Color.WHITE);
		clear_btn.setBounds(473, 399, 176, 52);
        clear_btn.setFocusable(false);
		contentPane.add(clear_btn);
		
		JButton logOut_Btn = new JButton("Log Out");
		logOut_Btn.setBounds(812, 11, 89, 23);
		contentPane.add(logOut_Btn);

		this.setVisible(true);
		
	}
}
