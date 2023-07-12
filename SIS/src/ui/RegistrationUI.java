package ui;

import controller.SISController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Response;
import common.UserDTO;

public class RegistrationUI extends JFrame {

    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    SISController sisController;

    public static void main(String[] args) {
        new RegistrationUI().setVisible(true);
    }

    public RegistrationUI() {
        sisController = new SISController();
        setTitle("SIS - Registration");
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

        JLabel titleLabel = new JLabel("Registration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(41, 128, 185));
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;
        JLabel usernameLabel = new JLabel("Username:");
        mainPanel.add(usernameLabel, gbc);

        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        mainPanel.add(emailLabel, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx++;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(20);
        mainPanel.add(usernameField, gbc);

        gbc.gridy++;
        emailField = new JTextField(20);
        mainPanel.add(emailField, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(20);
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton registerButton = new JButton("Register");
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(41, 128, 185));
        registerButton.setFocusPainted(false);
        registerButton.setFont(new Font("Arial", Font.BOLD, 12));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        registerButton.putClientProperty("JButton.selectedBackground", new Color(52, 152, 219));
        mainPanel.add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDTO user = new UserDTO(usernameField.getText(), emailField.getText(), new String(passwordField.getPassword()));
                user.setRole("student");
                Response res = new Response();
                sisController.saveUser(user, res);
                if (res.isSuccessfull()) {
                    JOptionPane.showMessageDialog(null, res.getInfoMessages());
                    new LoginUI().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, res.getErrorMessages());
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

}
