package myClasses;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//import myInterface.tableDataReader;

public class ManageRoom extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField roomNum_fld;
    private JTextField price_fld;
    private JButton logOut_btn;
    private JButton back_btn;
    private JButton add_btn;
    private JComboBox roomType_box;
    private JComboBox bed_box;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageRoom();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ManageRoom() {
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

        back_btn = new JButton("Back");
        back_btn.setBounds(702, 11, 89, 23);
        back_btn.setFocusable(false);
        contentPane.add(back_btn);

        JLabel manageRoom_lbl = new JLabel("Manage Room");
        manageRoom_lbl.setForeground(Color.LIGHT_GRAY);
        manageRoom_lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        manageRoom_lbl.setBounds(10, 3, 180, 34);
        contentPane.add(manageRoom_lbl);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 91, 536, 366);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        model = new DefaultTableModel(new Object[][] {},
                new String[] { "Room Number", "Room Type", "Bed", "Price", "Status" });
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(82);

        //readData(model);

        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals("Rooms Details")) {
                    String[] rowData = new String[5]; // create an array with 5 elements
                    rowData[0] = line; // add the first element to the Room Number column
                    for (int i = 1; i < 5; i++) {
                        // read the next 4 lines and add the data to the corresponding column
                        rowData[i] = br.readLine();
                    }
                    model.addRow(rowData); // add the row to the JTable
                    br.readLine();
                    br.readLine();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JLabel roomNumber_lbl = new JLabel("Room Number");
        roomNumber_lbl.setForeground(Color.BLACK);
        roomNumber_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
        roomNumber_lbl.setBounds(631, 86, 89, 23);
        contentPane.add(roomNumber_lbl);

        roomNum_fld = new JTextField();
        roomNum_fld.setBounds(631, 121, 151, 20);
        contentPane.add(roomNum_fld);
        roomNum_fld.setColumns(10);

        JLabel roomType_lbl = new JLabel("Room Type");
        roomType_lbl.setForeground(Color.BLACK);
        roomType_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
        roomType_lbl.setBounds(631, 152, 72, 23);
        contentPane.add(roomType_lbl);

        roomType_box = new JComboBox();
        roomType_box.setModel(new DefaultComboBoxModel(new String[] { "AC", "Non-Ac" }));
        roomType_box.setBounds(631, 186, 156, 22);
        contentPane.add(roomType_box);

        JLabel bed_lbl = new JLabel("Bed");
        bed_lbl.setForeground(Color.BLACK);
        bed_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
        bed_lbl.setBounds(631, 220, 72, 23);
        contentPane.add(bed_lbl);

        bed_box = new JComboBox();
        bed_box.setModel(new DefaultComboBoxModel(new String[] { "Single", "Double", "Triple" }));
        bed_box.setBounds(631, 248, 156, 22);
        contentPane.add(bed_box);

        JLabel price_lbl = new JLabel("Price");
        price_lbl.setForeground(Color.BLACK);
        price_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
        price_lbl.setBounds(631, 281, 97, 26);
        contentPane.add(price_lbl);

        price_fld = new JTextField();
        price_fld.setColumns(10);
        price_fld.setBounds(631, 318, 160, 20);
        contentPane.add(price_fld);

        add_btn = new JButton("Add Room");
        add_btn.setBounds(631, 382, 111, 34);
        add_btn.setFocusable(false);
        contentPane.add(add_btn);

        logOut_btn.addActionListener(this);
        back_btn.addActionListener(this);
        add_btn.addActionListener(this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String romNum = roomNum_fld.getText();
        String romType = (String) roomType_box.getSelectedItem();
        String bed = (String) bed_box.getSelectedItem();
        String price = price_fld.getText();

        boolean romNumEmpty = roomNum_fld.getText().isEmpty();
        boolean priceEmpty = price_fld.getText().isEmpty();

        if (e.getSource() == logOut_btn) {
            setVisible(false);
            // new Login();
        } else if (e.getSource() == back_btn) {
            setVisible(false);
            // new DashBoard();
        } else if (e.getSource() == add_btn) {
            if (romNumEmpty == false && priceEmpty == false) {
                try {
                    int p = Integer.parseInt(price);
                    String line = "./files/rooms.txt";
                    try {
                        File file = new File(line);
                        if (!file.exists()) {
                            file.createNewFile();
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);
                            printWriter.close();
                        }

                        BufferedReader rdfile3 = new BufferedReader(new FileReader("./files/rooms.txt"));
                        int ttlLines3 = 0;
                        while (rdfile3.readLine() != null) {
                            ttlLines3++;
                        }
                        rdfile3.close();

                        boolean flag = true;
                        for (int k = 0; k < ttlLines3; k++) {
                            String linek = Files.readAllLines(Paths.get("./files/rooms.txt")).get(k);
                            if (linek.equals(roomNum_fld)) {
                                flag = false;
                                break;
                            }

                        }
                        if (flag == true) {
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);
                            printWriter.println("Rooms Details");
                            printWriter.println(romNum);
                            printWriter.println(romType);
                            printWriter.println(bed);
                            printWriter.println(price);
                            printWriter.println("Not Booked");
                            printWriter.println();
                            printWriter.close();

                            roomNum_fld.setText(null);
                            price_fld.setText(null);

                        } else {
                            JOptionPane.showMessageDialog(null, "Same room number already exist", "Error",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Fill all the box", "Error", JOptionPane.WARNING_MESSAGE);
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.equals("Rooms Details")) {
                        String[] rowData = new String[5]; // create an array with 5 elements
                        rowData[0] = line; // add the first element to the Room Number column
                        for (int i = 1; i < 5; i++) {
                            // read the next 4 lines and add the data to the corresponding column
                            rowData[i] = br.readLine();
                        }
                        model.addRow(rowData); // add the row to the JTable
                        br.readLine();
                        br.readLine();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    // @Override
    // public void readData(DefaultTableModel model) {
    //     model.setRowCount(0);

    //     try (BufferedReader br = new BufferedReader(new FileReader(".\\files\\rooms.txt"))) {
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             if (!line.equals("Rooms Details")) {
    //                 String[] rowData = new String[5]; // create an array with 5 elements
    //                 rowData[0] = line; // add the first element to the Room Number column
    //                 for (int i = 1; i < 5; i++) {
    //                     // read the next 4 lines and add the data to the corresponding column
    //                     rowData[i] = br.readLine();
    //                 }
    //                 model.addRow(rowData); // add the row to the JTable
    //                 br.readLine();
    //                 br.readLine();
    //             }
    //         }
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }
    // }
}
