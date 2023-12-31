package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import ui.panels.AddDetails;
import ui.panels.EnrollStudents;


public class AdminDashboard extends JFrame {

    private JPanel headerPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public static void main(String[] args) {
        new AdminDashboard().setVisible(true);
    }
    public AdminDashboard() {
       

            setTitle("Student Information System - Admin Dashboard");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLayout(new BorderLayout());

            // Header Panel
            createHeaderPanel();

            // Menu Panel
            createMenuPanel();

            // Content Panel
            createContentPanel();

            pack();
            setLocationRelativeTo(null);
        
    }

    private void createHeaderPanel() {
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(22, 160, 133));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(800, 75));
        add(headerPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Student Information System");
        titleLabel.setForeground(new Color(250, 250, 250));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        headerPanel.add(titleLabel, BorderLayout.CENTER);
    }
    
    private void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(0, 204, 153));
        menuPanel.setPreferredSize(new Dimension(220, 600));
        menuPanel.setLayout(new GridBagLayout());
        add(menuPanel, BorderLayout.WEST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton enrollStudentsButton = createMenuButton("Enroll Students");
        JButton viewStudentsButton = createMenuButton("View Students");
        JButton viewCoursesButton = createMenuButton("View Courses");
        
        menuPanel.add(enrollStudentsButton, gbc);
        gbc.gridy++;
        menuPanel.add(viewStudentsButton, gbc);
        gbc.gridy++;
        menuPanel.add(viewCoursesButton, gbc);
        gbc.gridy++;
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(22, 160, 133));
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 12));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        logoutButton.putClientProperty("JButton.selectedBackground", new Color(255, 255, 255));

        // Add ActionListener to handle logout functionality
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginUI().setVisible(true);
            }
        });

        menuPanel.add(logoutButton, gbc);
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 35));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(22, 160, 133));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        button.putClientProperty("JButton.selectedBackground", new Color(52, 152, 219));

        // Hover Effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {

        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event or navigate to the corresponding page
                String buttonText = button.getText();

                contentPanel.removeAll();
                if (buttonText.equals("Enroll Students")) {
                    contentPanel.add(new AddDetails());
                } else if (buttonText.equals("View Students")) {
                    try {
                        contentPanel.add(new StudentList());
                    } catch (IOException ex) {
                        //Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (buttonText.equals("View Courses")) {
                   
                    try {
                        contentPanel.add(new CourseList());
                    } catch (IOException ex) {
                        //Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } 
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });
        return button;
    }
    private void createContentPanel() {
        contentPanel = new EnrollStudents();

        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        
        
    }
}
