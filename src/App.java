import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load and set the image with a specific size
        ImageIcon originalImageIcon = new ImageIcon("lib/images/1.png");
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledImageIcon);

        // Main frame background color
        frame.getContentPane().setBackground(new Color(6, 206, 206));

        // Outer Panel with BorderLayout
        outerPanel.setLayout(new BorderLayout());
        outerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // Inner Panel with GridBagLayout
        innerPanel.setLayout(new GridBagLayout());
        innerPanel.setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Set the components to the left column
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5); // Adjusted insets for better spacing

        // Create a panel for login components
        loginPanel.setLayout(new GridBagLayout());

        // UID Text
        JLabel s = new JLabel("User ID: ");
        s.setForeground(Color.black);
        s.setFont(new Font("Arial", Font.PLAIN, 16));
        loginPanel.add(s, gbc);

        // UID TextBox
        gbc.gridy++;
        uid.setPreferredSize(new Dimension(300, 50));
        uid.setFont(new Font("Arial", Font.PLAIN, 17));
        uid.setBorder(new RoundedBorder(20, Color.GRAY));
        loginPanel.add(uid, gbc);

        // Pw Box
        gbc.gridy++;
        JLabel p = new JLabel("Password: ");
        p.setFont(new Font("Arial", Font.PLAIN, 16));
        p.setForeground(Color.black);
        loginPanel.add(p, gbc);

        gbc.gridy++;
        pw.setPreferredSize(new Dimension(300, 50));
        pw.setFont(new Font("Arial", Font.PLAIN, 17));
        pw.setBorder(new RoundedBorder(20, Color.GRAY));
        loginPanel.add(pw, gbc);

        // Log in button
        gbc.gridy++;
        b1.setFont(new Font("Arial", Font.PLAIN, 17));
        b1.setPreferredSize(new Dimension(300, 50));
        b1.setBackground(new Color(0, 163, 255));
        b1.setForeground(Color.white);
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setBorder(new RoundedBorder(20, new Color(0, 163, 255)));
        b1.setOpaque(true);
        loginPanel.add(b1, gbc);

        // Add the login panel to the left of the inner panel
        innerPanel.add(loginPanel, gbc);

        // Panel for the image on the right side
        imagePanel.setLayout(new BorderLayout());
        imagePanel.setBackground(Color.white);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Add the image panel to the right of the inner panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 20, 5, 5);  // Adjusted insets for better spacing
        innerPanel.add(imagePanel, gbc);

        // Add the inner panel to the outer panel
        innerPanel.setBorder(new RoundedBorder(40, Color.white));
        outerPanel.add(innerPanel, BorderLayout.WEST);

        // Add the outer panel to the frame
        frame.add(outerPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if needed
    }

    public static void main(String[] args) {
        new App();
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
