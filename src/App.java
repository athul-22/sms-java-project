import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame mainFrame = new JFrame("Login Page");
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set main frame background color
        mainFrame.getContentPane().setBackground(new Color(206, 206, 206));

        // Add a gap between the main frame and the panel
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(Box.createRigidArea(new Dimension(100, 100)), BorderLayout.NORTH);

        // Create a white container panel with rounded corners
        JPanel containerPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(10, 10);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setColor(getBackground());
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
            }
        };

        containerPanel.setBackground(Color.WHITE);
        containerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainFrame.add(containerPanel, BorderLayout.CENTER);

        // Email input box
        JTextField emailTextField = new JTextField();
        emailTextField.setPreferredSize(new Dimension(200, 30));
        containerPanel.add(emailTextField, BorderLayout.NORTH);

        // Password input box
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100,100,100,50);
        passwordField.setPreferredSize(new Dimension(200, 30));
        containerPanel.add(passwordField, BorderLayout.CENTER);

        // Blue login button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);
        containerPanel.add(loginButton, BorderLayout.SOUTH);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your login logic here
                JOptionPane.showMessageDialog(mainFrame, "Login button clicked!");
            }
        });

        // Image on the right side
        try {
            // Replace the URL with the actual URL of your image
            URL imageUrl = new URL("https://example.com/your-image.jpg");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            JLabel imageLabel = new JLabel(imageIcon);
            containerPanel.add(imageLabel, BorderLayout.EAST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the size and make the frame visible
        mainFrame.setLocationRelativeTo(null); // Center the frame on the screen
        mainFrame.setVisible(true);
    }
}
