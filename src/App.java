import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Main Page");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button
        JButton nextButton = new JButton("Next Page");

        // Add action listener to the button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNextPage();
            }
        });

        // Add the button to the main frame
        frame.getContentPane().add(nextButton);

        // Set the size and make the frame visible
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    private static void openNextPage() {
        // Create the next frame
        JFrame nextFrame = new JFrame("Next Page");
        nextFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a label for the next page
        JLabel label = new JLabel("Welcome to the Next Page!");

        // Add the label to the next frame
        nextFrame.getContentPane().add(label);

        // Set the size and make the next frame visible
        nextFrame.setSize(300, 200);
        nextFrame.setLocationRelativeTo(null); // Center the frame on the screen
        nextFrame.setVisible(true);
    }
}
