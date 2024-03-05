import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {

    JButton b1 = new JButton("Log In");
    JPanel outerPanel = new JPanel();
    JPanel innerPanel = new JPanel();
    JPanel loginPanel = new JPanel();  // Panel for login components
    JPanel imagePanel = new JPanel();  // Panel for the image
    JFrame frame = new JFrame();
    JTextField uid = new JTextField();
    JPasswordField pw = new JPasswordField();
    JLabel imageLabel;

    App() {
        frame.setVisible(true);
        frame.setSize(800, 600); // Set an initial size for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Outer Panel with BorderLayout
        outerPanel.setLayout(new BorderLayout());
        outerPanel.setBackground(Color.WHITE); // White background color

        // Inner Panel with BorderLayout
        innerPanel.setLayout(new BorderLayout());
        innerPanel.setBackground(new Color(225,225,225)); // #cecece background color
        innerPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); // 100-pixel gap

        // Create a panel for login components
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);
        imagePanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Set the components to the left column
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Center the components
        gbc.insets = new Insets(5, 5, 5, 5); // Adjusted insets for better spacing

        // UID Text
        JLabel s = new JLabel("User ID: ");
        s.setForeground(Color.black);
        s.setFont(new Font("Arial", Font.PLAIN, 16));
        loginPanel.add(s, gbc);

        // UID TextBox
        gbc.gridy++;
        uid.setPreferredSize(new Dimension(300, 30));
        uid.setFont(new Font("Arial", Font.PLAIN, 14));
        uid.setBorder(new RoundedBorder(15, Color.WHITE)); // White border color
        loginPanel.add(uid, gbc);

        // Pw Box
        gbc.gridy++;
        JLabel p = new JLabel("Password: ");
        p.setFont(new Font("Arial", Font.PLAIN, 16));
        p.setForeground(Color.black);
        loginPanel.add(p, gbc);

        gbc.gridy++;
        pw.setPreferredSize(new Dimension(300, 30));
        pw.setFont(new Font("Arial", Font.PLAIN, 14));
        pw.setBorder(new RoundedBorder(15, Color.WHITE)); // White border color
        loginPanel.add(pw, gbc);

        // Log in button
        gbc.gridy++;
        b1.setFont(new Font("Arial", Font.PLAIN, 16));
        b1.setPreferredSize(new Dimension(200, 30));
        b1.setBackground(Color.WHITE); // White background color
        b1.setForeground(Color.black);
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setBorder(new RoundedBorder(15, Color.WHITE)); // White border color
        b1.setOpaque(true);
        b1.addActionListener(this);
        loginPanel.add(b1, gbc);

        // Add the login panel to the center of the inner panel
        innerPanel.add(loginPanel, BorderLayout.CENTER);

        // Panel for the image on the right side
        imagePanel.setLayout(new BorderLayout());
        // Load and set the image with a specific size
        ImageIcon originalImageIcon = new ImageIcon("lib/images/1.png");
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledImageIcon);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Add the image panel to the right of the inner panel
        innerPanel.add(imagePanel, BorderLayout.EAST);

        // Add the inner panel to the outer panel
        outerPanel.add(innerPanel, BorderLayout.CENTER);

        // Add the outer panel to the frame
        frame.add(outerPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());
    }
}

class RoundedBorder implements Border {
    private int radius;
    private Color borderColor;

    public RoundedBorder(int radius, Color borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(borderColor);
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
