import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw with Us");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton signInButton = new JButton("Sign In");
        JButton signUpButton = new JButton("Sign Up");

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = JOptionPane.showInputDialog(frame, "Enter User ID:");
                String email = JOptionPane.showInputDialog(frame, "Enter Email:");

                if (userId != null && !userId.isEmpty() && email != null && !email.isEmpty()) {
                    // Successful sign-in
                    JOptionPane.showMessageDialog(frame,
                            "Sign In Successful!\nUser ID: " + userId + "\nEmail: " + email);
                    chooseDrawingOption();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please try again.");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = JOptionPane.showInputDialog(frame, "Enter User ID:");

                if (userId != null && !userId.isEmpty()) {
                    // Successful sign-up
                    JOptionPane.showMessageDialog(frame, "Sign Up Successful!\nUser ID: " + userId);
                    chooseDrawingOption();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please try again.");
                }
            }
        });

        panel.add(signInButton);
        panel.add(signUpButton);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void chooseDrawingOption() {
        Object[] options = { "2D", "3D" };
        int choice = JOptionPane.showOptionDialog(null, "Choose drawing option:", "Drawing Option",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            // Launch the 2D drawing generator
            TwoGenerator.main(new String[] {});
        } else if (choice == 1) {
            // Launch the 3D drawing generator
            ThreeDGenerator.main(new String[] {});
        }
    }
}
