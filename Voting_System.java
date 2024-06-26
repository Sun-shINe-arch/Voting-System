import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Data_Entry extends JFrame implements ActionListener {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/ARPIT?user=root";
    private static final String username = "root";
    private static final String password = "Crossroad@09";
    static private JComboBox<String> cityComboBox;
    JButton Button;
    JButton button;
    JTextField text1, text2, text3, text4, text5, text6;
    JLabel label1, label2, label3, label4, label5, label6;

    void launchpage(int id, String name, int age, String address, String fatherName) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(499, 318);
        frame.setLayout(null);

        JLabel backgroundImageLabel = new JLabel();
        backgroundImageLabel.setIcon(new ImageIcon("card.png"));
        backgroundImageLabel.setBounds(0, 0, 499, 318);
        frame.add(backgroundImageLabel);

        JLabel voterIDLabel = new JLabel("Voter ID");
        voterIDLabel.setFont(new Font("Arial", Font.BOLD, 30));
        voterIDLabel.setForeground(Color.BLUE);
        voterIDLabel.setBounds(200, 30, 150, 30);
        backgroundImageLabel.add(voterIDLabel);

        JLabel nameLabel = new JLabel("Name: " + name);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        nameLabel.setBounds(50, 100, 399, 20);
        backgroundImageLabel.add(nameLabel);

        JLabel ageLabel = new JLabel("Age: " + age);
        ageLabel.setForeground(Color.BLACK);
        ageLabel.setFont(new Font("Arial", Font.BOLD, 22));
        ageLabel.setBounds(50, 130, 300, 20);
        backgroundImageLabel.add(ageLabel);

        JLabel addressLabel = new JLabel("Address: " + address);
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 22));
        addressLabel.setBounds(50, 160, 300, 20);
        backgroundImageLabel.add(addressLabel);

        JLabel fatherNameLabel = new JLabel("Father's Name: " + fatherName);
        fatherNameLabel.setForeground(Color.BLACK);
        fatherNameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        fatherNameLabel.setBounds(50, 190, 399, 20);
        backgroundImageLabel.add(fatherNameLabel);

        JButton printButton = new JButton("Print");
        printButton.setBounds(160, 230, 100, 30);
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    captureAndSaveScreenshot(frame, name + ".png");
                } catch (AWTException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        backgroundImageLabel.add(printButton);

        JButton backButton = new JButton("Close");
        backButton.setBounds(280, 230, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        backgroundImageLabel.add(backButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void captureAndSaveScreenshot(JFrame frame, String fileName) throws AWTException, IOException {
        Rectangle bounds = frame.getBounds();
        Insets insets = frame.getInsets();
        bounds.x += insets.left;
        bounds.y += insets.top;
        bounds.width -= insets.left + insets.right;
        bounds.height -= insets.top + insets.bottom;
        int buttonHeight = 55;
        Rectangle contentBounds = new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height - buttonHeight);

        BufferedImage image = new Robot().createScreenCapture(contentBounds);
        ImageIO.write(image, "png", new File(fileName));
        JOptionPane.showMessageDialog(null, "Screenshot saved as " + fileName);
    }

    Data_Entry() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(5, 1, 10, 10));
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(360, 40));
        panel1.setBackground(Color.lightGray);
        label1 = new JLabel();
        label1.setText(" ID                     ");
        panel1.add(label1);
        text1 = new JTextField();
        text1.setPreferredSize(new Dimension(250, 30));
        text1.setFont(new Font("Consolas", Font.PLAIN, 25));
        text1.setBackground(Color.BLACK);
        text1.setForeground(Color.white);
        text1.setCaretColor(Color.RED);
        panel1.add(text1);
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(360, 40));
        panel2.setBackground(Color.lightGray);
        label2 = new JLabel();
        label2.setText("NAME               ");
        panel2.add(label2);
        text2 = new JTextField();
        text2.setPreferredSize(new Dimension(250, 30));
        text2.setFont(new Font("Consolas", Font.PLAIN, 25));
        text2.setBackground(Color.BLACK);
        text2.setForeground(Color.white);
        text2.setCaretColor(Color.RED);
        panel2.add(text2);
        add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(360, 40));
        panel3.setBackground(Color.lightGray);
        label3 = new JLabel();
        label3.setText("AGE                 ");
        panel3.add(label3);
        text3 = new JTextField();
        text3.setPreferredSize(new Dimension(250, 30));
        text3.setFont(new Font("Consolas", Font.PLAIN, 25));
        text3.setBackground(Color.BLACK);
        text3.setForeground(Color.white);
        text3.setCaretColor(Color.RED);
        panel3.add(text3);
        add(panel3);

        JPanel panel4 = new JPanel();
        text4 = new JTextField();
        String[] cities = { "Patna", "Kolkata", "Mumbai", "Chennai", "Surat", "Amritsar", "Bengaluru", "Hyderabad",
                "Ahmedabad", "Mathura", "Gaya", "Raipur", "Ranchi", "Kota", "Prayagraj", "Greater Noida", "Delhi",
                "Jammu", "Gawahati", "Shillong" };
        cityComboBox = new JComboBox<>(cities);
        Button = new JButton("Select");
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCity = (String) cityComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, "You selected: " + selectedCity);
                text4.setText(selectedCity);
            }
        });

        panel4.add(new JLabel("Select a city: "));
        panel4.add(cityComboBox);
        panel4.add(Button);
        add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(360, 40));
        panel5.setBackground(Color.lightGray);
        label5 = new JLabel();
        label5.setText("FATHER_NAME");
        panel5.add(label5);
        text5 = new JTextField();
        text5.setPreferredSize(new Dimension(250, 30));
        text5.setFont(new Font("Consolas", Font.PLAIN, 25));
        text5.setBackground(Color.BLACK);
        text5.setForeground(Color.white);
        text5.setCaretColor(Color.RED);
        panel5.add(text5);
        add(panel5);

        JPanel panel6 = new JPanel();
        panel6.setPreferredSize(new Dimension(360, 40));
        panel6.setBackground(Color.lightGray);
        label6 = new JLabel();
        label6.setText("PASSWORD     ");
        panel6.add(label6);
        text6 = new JTextField();
        text6.setPreferredSize(new Dimension(250, 30));
        text6.setFont(new Font("Consolas", Font.PLAIN, 25));
        text6.setBackground(Color.BLACK);
        text6.setForeground(Color.white);
        text6.setCaretColor(Color.RED);
        panel6.add(text6);
        add(panel6);

        button = new JButton("Submit");
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 13));
        button.addActionListener(this);

        setResizable(false);
        add(button);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            button.setEnabled(false);
            String id = text1.getText();
            int ID = Integer.parseInt(id);
            String Name = text2.getText();
            String age = text3.getText();
            int Age = Integer.parseInt(age);
            String Address = text4.getText();
            String Father_Name = text5.getText();
            String Password = text6.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException x) {
                x.printStackTrace();
            }
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                String query = "INSERT INTO PERSONAL_DETAIL VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, ID);
                ps.setString(2, Name);
                ps.setInt(3, Age);
                ps.setString(4, Address);
                ps.setString(5, Father_Name);
                ps.setString(6, Password);
                int rowsaffected = ps.executeUpdate();
                if (rowsaffected > 0) {
                    launchpage(ID, Name, Age, Address, Father_Name);
                } else {

                }
            } catch (SQLException x) {
                System.out.println(x.getMessage());
            }
        } else if (e.getSource() == Button) {
            String selectedCity = (String) cityComboBox.getSelectedItem();
            text4.setText(selectedCity);
        }
    }
}

class Voting extends JFrame implements ActionListener {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/ARPIT?user=root";
    private static final String username = "root";
    private static final String password = "Crossroad@09";
    JTextField text1, text2, text_m;
    JLabel label1, label2;
    JButton button;
    JButton button_a, button_b, button_c, button_d, button_e, button_f;
    JFrame frame;
    static String name, address, candidate;
    int ID;

    private void read(int id, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT Name, Address FROM personal_detail WHERE ID = ? AND Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                name = rs.getString("Name");
                address = rs.getString("Address");
                Part1();
            } else {
                System.out.println("Wrong ID or Password");
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void read2(String party) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT Candidate_Name FROM party WHERE Party_Name = ? AND Address = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, party);
            pstmt.setString(2, address);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                candidate = rs.getString("Candidate_Name");
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void vote(String party) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO VOTING_DETAIL VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ID);
            ps.setString(2, name);
            ps.setString(3, party);
            ps.setString(4, candidate);
            ps.setString(5, address);
            int rowsaffected = ps.executeUpdate();
            if (rowsaffected > 0) {
                System.out.println("Data Inserted Successfully");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        }
    }

    public void Part1() {

        ImageIcon icon_a = new ImageIcon("bjp.png");
        ImageIcon icon_b = new ImageIcon("congress.png");
        ImageIcon icon_c = new ImageIcon("aap.png");
        ImageIcon icon_d = new ImageIcon("shiv.png");
        ImageIcon icon_e = new ImageIcon("tmc.png");
        ImageIcon icon_f = new ImageIcon("none.png");

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 650);
        frame.setLayout(new GridLayout(6, 1, 10, 10));

        button_a = new JButton();
        button_a.setBounds(10, 10, 150, 50);
        button_a.addActionListener(this);
        button_a.setText("Bharatiya Janta Party");
        button_a.setFocusable(false);
        button_a.setIcon(icon_a);
        button_a.setFont(new Font("Comic Sans", Font.BOLD, 27));
        button_a.setForeground(Color.RED);
        button_a.setBorder(BorderFactory.createEtchedBorder());
        frame.add(button_a);

        button_b = new JButton();
        button_b.setBounds(10, 10, 150, 50);
        button_b.addActionListener(this);
        button_b.setText("         Congress          ");
        button_b.setFocusable(false);
        button_b.setIcon(icon_b);
        button_b.setFont(new Font("Comic Sans", Font.BOLD, 27));
        button_b.setForeground(Color.RED);
        button_b.setBorder(BorderFactory.createEtchedBorder());
        frame.add(button_b);

        button_c = new JButton();
        button_c.setBounds(10, 10, 150, 50);
        button_c.addActionListener(this);
        button_c.setText("    Aam Aadmi Partys    ");
        button_c.setFocusable(false);
        button_c.setIcon(icon_c);
        button_c.setFont(new Font("Comic Sans", Font.BOLD, 27));
        button_c.setForeground(Color.RED);
        button_c.setBorder(BorderFactory.createEtchedBorder());
        frame.add(button_c);

        button_d = new JButton();
        button_d.setBounds(10, 10, 150, 50);
        button_d.addActionListener(this);
        button_d.setText("          Shiv Sena          ");
        button_d.setFocusable(false);
        button_d.setIcon(icon_d);
        button_d.setFont(new Font("Comic Sans", Font.BOLD, 27));
        button_d.setForeground(Color.RED);
        button_d.setBorder(BorderFactory.createEtchedBorder());
        frame.add(button_d);

        button_e = new JButton();
        button_e.setBounds(10, 10, 150, 50);
        button_e.addActionListener(this);
        button_e.setText(" Trinamool Congress ");
        button_e.setFocusable(false);
        button_e.setIcon(icon_e);
        button_e.setFont(new Font("Comic Sans", Font.BOLD, 27));
        button_e.setForeground(Color.RED);
        button_e.setBorder(BorderFactory.createEtchedBorder());
        frame.add(button_e);

        button_f = new JButton();
        button_f.setBounds(10, 10, 150, 50);
        button_f.addActionListener(this);
        button_f.setText("              None               ");
        button_f.setFocusable(false);
        button_f.setIcon(icon_f);
        button_f.setFont(new Font("Comic Sans", Font.BOLD, 27));
        button_f.setForeground(Color.RED);
        button_f.setBorder(BorderFactory.createEtchedBorder());
        frame.add(button_f);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    Voting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setLayout(new GridLayout(3, 1, 10, 10));
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(360, 40));
        panel1.setBackground(Color.lightGray);
        label1 = new JLabel();
        label1.setText("VOTER ID           ");
        panel1.add(label1);
        text1 = new JTextField();
        text1.setPreferredSize(new Dimension(250, 30));
        text1.setFont(new Font("Consolas", Font.PLAIN, 25));
        text1.setBackground(Color.BLACK);
        text1.setForeground(Color.white);
        text1.setCaretColor(Color.RED);
        panel1.add(text1);
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(360, 40));
        panel2.setBackground(Color.lightGray);
        label2 = new JLabel();
        label2.setText("PASSWORD       ");
        panel2.add(label2);
        text2 = new JTextField();
        text2.setPreferredSize(new Dimension(250, 30));
        text2.setFont(new Font("Consolas", Font.PLAIN, 25));
        text2.setBackground(Color.BLACK);
        text2.setForeground(Color.white);
        text2.setCaretColor(Color.RED);
        panel2.add(text2);
        add(panel2);

        button = new JButton("Submit");
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 13));
        button.addActionListener(this);

        setResizable(false);
        setLocationRelativeTo(null);
        add(button);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String id = text1.getText();
            ID = Integer.parseInt(id);
            String pass = text2.getText();
            read(ID, pass);
            dispose();
        }
        if (e.getSource() == button_a) {
            int x = JOptionPane.showConfirmDialog(null, "WOULD YOU LIKE TO FINALIZE YOUR VOTE", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                read2("Bharatiya Janta Party");
                vote("Bharatiya Janta Party");
                frame.dispose();
            }
            frame.dispose();
        }
        if (e.getSource() == button_b) {
            int x = JOptionPane.showConfirmDialog(null, "WOULD YOU LIKE TO FINALIZE YOUR VOTE", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                read2("Congress");
                vote("Congress");
                frame.dispose();
            }
            frame.dispose();
        }
        if (e.getSource() == button_c) {
            int x = JOptionPane.showConfirmDialog(null, "WOULD YOU LIKE TO FINALIZE YOUR VOTE", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                read2("Aam Aadmi Partys");
                vote("Aam Aadmi Partys");
                frame.dispose();
            }
            frame.dispose();
        }
        if (e.getSource() == button_d) {
            int x = JOptionPane.showConfirmDialog(null, "WOULD YOU LIKE TO FINALIZE YOUR VOTE", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                read2("Shiv Sena");
                vote("Shiv Sena");
                frame.dispose();
            }
            frame.dispose();
        }
        if (e.getSource() == button_e) {
            int x = JOptionPane.showConfirmDialog(null, "WOULD YOU LIKE TO FINALIZE YOUR VOTE", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                read2("Trinamool Congress");
                vote("Trinamool Congress");
                frame.dispose();
            }
            frame.dispose();
        }
        if (e.getSource() == button_f) {
            int X = JOptionPane.showConfirmDialog(null, "WOULD YOU LIKE TO FINALIZE YOUR VOTE", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (X == 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException x) {
                    x.printStackTrace();
                }
                try {
                    Connection conn = DriverManager.getConnection(url, username, password);
                    String query = "INSERT INTO VOTING_DETAIL VALUES(?,?,?,?,?)";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setInt(1, ID);
                    ps.setString(2, name);
                    ps.setString(3, "None");
                    ps.setString(4, "None");
                    ps.setString(5, address);
                    int rowsaffected = ps.executeUpdate();
                    if (rowsaffected > 0) {
                        System.out.println("Data Inserted Successfully");
                    } else {
                        System.out.println("Failed");
                    }
                } catch (SQLException x) {
                    System.out.println(x.getMessage());
                }
                frame.dispose();
            }
            frame.dispose();
        }
    }
}

class Voting_receipt extends JFrame implements ActionListener {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/ARPIT?user=root";
    private static final String username = "root";
    private static final String password = "Crossroad@09";
    JTextField text1, text2, text_m;
    JLabel label1, label2;
    JButton button;
    String name, party, candidate_name, address;

    private void read(int id, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM voting_detail WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                name = rs.getString("NAME");
                party = rs.getString("PARTY_NAME");
                candidate_name = rs.getString("CANDIDATE_NAME");
                address = rs.getString("Address");
                receipt(id, name, address, party, candidate_name);
            } else {
                System.out.println("Wrong ID or Password");
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void receipt(int id, String name, String addr, String party, String can) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 360);
        frame.setLayout(null);

        JLabel backgroundImageLabel = new JLabel();
        backgroundImageLabel.setIcon(new ImageIcon("receipt.png"));
        backgroundImageLabel.setBounds(0, 0, 499, 318);
        frame.add(backgroundImageLabel);

        JLabel voter_id = new JLabel("ID: " + id);
        voter_id.setForeground(Color.BLACK);
        voter_id.setFont(new Font("Arial", Font.BOLD, 22));
        voter_id.setBounds(50, 50, 399, 25);
        backgroundImageLabel.add(voter_id);

        JLabel nameLabel = new JLabel("Name : " + name);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        nameLabel.setBounds(50, 100, 300, 25);
        backgroundImageLabel.add(nameLabel);

        JLabel voted = new JLabel("Voted : " + party);
        voted.setForeground(Color.BLACK);
        voted.setFont(new Font("Arial", Font.BOLD, 22));
        voted.setBounds(50, 150, 400, 25);
        backgroundImageLabel.add(voted);

        JLabel candidateNameLabel = new JLabel("Candidate_Name : " + can);
        candidateNameLabel.setForeground(Color.BLACK);
        candidateNameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        candidateNameLabel.setBounds(50, 200, 399, 25);
        backgroundImageLabel.add(candidateNameLabel);

        JLabel address = new JLabel("Address : " + addr);
        address.setForeground(Color.BLACK);
        address.setFont(new Font("Arial", Font.BOLD, 22));
        address.setBounds(50, 250, 300, 25);
        backgroundImageLabel.add(address);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    Voting_receipt() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setLayout(new GridLayout(3, 1, 10, 10));
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(360, 40));
        panel1.setBackground(Color.lightGray);
        label1 = new JLabel();
        label1.setText("VOTER ID           ");
        panel1.add(label1);
        text1 = new JTextField();
        text1.setPreferredSize(new Dimension(250, 30));
        text1.setFont(new Font("Consolas", Font.PLAIN, 25));
        text1.setBackground(Color.BLACK);
        text1.setForeground(Color.white);
        text1.setCaretColor(Color.RED);
        panel1.add(text1);
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(360, 40));
        panel2.setBackground(Color.lightGray);
        label2 = new JLabel();
        label2.setText("PASSWORD       ");
        panel2.add(label2);
        text2 = new JTextField();
        text2.setPreferredSize(new Dimension(250, 30));
        text2.setFont(new Font("Consolas", Font.PLAIN, 25));
        text2.setBackground(Color.BLACK);
        text2.setForeground(Color.white);
        text2.setCaretColor(Color.RED);
        panel2.add(text2);
        add(panel2);

        button = new JButton("Submit");
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 13));
        button.addActionListener(this);

        setResizable(false);
        setLocationRelativeTo(null);
        add(button);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String id = text1.getText();
            int ID = Integer.parseInt(id);
            String pass = text2.getText();
            read(ID, pass);
            dispose();
        }
    }
}

public class Voting_System extends JFrame implements ActionListener {
    JButton button1, button2, button3, button4;
    JFrame frame;

    Voting_System() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 424);
        frame.setLayout(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("voter_frame.png"));
        backgroundLabel.setBounds(0, 0, 300, 424);
        frame.add(backgroundLabel);

        button1 = new JButton();
        button1.addActionListener(this);
        button1.setText("     Voter ID Creation     ");
        button1.setFocusable(false);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 15));
        button1.setBounds(20, 100, 250, 40);
        backgroundLabel.add(button1);

        button2 = new JButton();
        button2.addActionListener(this);
        button2.setText("            Vote           ");
        button2.setForeground(Color.RED);
        button2.setFocusable(false);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 15));
        button2.setBounds(20, 160, 250, 40);
        backgroundLabel.add(button2);

        button3 = new JButton();
        button3.addActionListener(this);
        button3.setText("       Voting Recipt       ");
        button3.setFocusable(false);
        button3.setFont(new Font("Comic Sans", Font.BOLD, 15));
        button3.setBounds(20, 220, 250, 40);
        backgroundLabel.add(button3);

        button4 = new JButton();
        button4.addActionListener(this);
        button4.setText("           Cancel          ");
        button4.setFocusable(false);
        button4.setFont(new Font("Comic Sans", Font.BOLD, 15));
        button4.setBounds(20, 280, 250, 40);
        backgroundLabel.add(button4);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Voting_System();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            new Data_Entry();
            frame.dispose();
        }
        if (e.getSource() == button2) {
            new Voting();
            frame.dispose();
        }
        if (e.getSource() == button3) {
            new Voting_receipt();
            frame.dispose();
        }
        if (e.getSource() == button4) {
            System.exit(0);
        }
    }
}