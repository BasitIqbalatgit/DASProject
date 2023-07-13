package ui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import controller.SISController;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import model.Response;
import common.UserDTO;



public class LoginUI extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    public SISController sisController;

    public LoginUI() {
        sisController=new SISController();
        setTitle("SIS - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(22, 160, 133));
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        mainPanel.add(emailLabel, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx++;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        emailField = new JTextField(20);
        emailField.setText("basit.sardar.comsian@gmail.com");
        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!emailField.getText().isEmpty()) {
                        passwordField.requestFocusInWindow();
                    }
                }
            }
        });
        mainPanel.add(emailField, gbc);
        
        gbc.gridy++;
        passwordField = new JPasswordField(20);
        passwordField.setText("123");
        JButton loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(22, 160, 133));
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        loginButton.putClientProperty("JButton.selectedBackground", new Color(52, 152, 219));

        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick(); // Trigger the login button event
            }
        });
        mainPanel.add(passwordField, gbc);
  
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

// Existing code...
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                Response res=new Response();
                UserDTO user=new UserDTO(email,password);
               sisController.verifyUser(user, res);
                if (res.isSuccessfull()) {
                    switch(user.getRole()){
                        case "faculty":
                            new AdminDashboard().setVisible(true);
                            dispose();
                            break;
                        case "student":
                            new StudentDashBoard().setVisible(true);
                            dispose();
                            break;  
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane,  res.getErrorMessages());
                }
                
                
            }
        });
        
        JLabel registerLabel = new JLabel("Not registered? Click here to register.");
        registerLabel.setForeground(Color.BLUE);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 10, 0, 0);
        mainPanel.add(registerLabel, gbc);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegistrationUI registrationUI = new RegistrationUI();
                registrationUI.setVisible(true);
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf: " + ex.getMessage());
        }
        new LoginUI().setVisible(true);
    }
}
