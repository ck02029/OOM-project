import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreeDGenerator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("3D Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();

            JButton show3DButton = new JButton("Show 3D Shapes");
            show3DButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    show3DOptions();
                }
            });

            panel.add(show3DButton);

            frame.getContentPane().add(panel);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static void show3DOptions() {
        JFrame optionsFrame = new JFrame("3D Options");
        optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel optionsPanel = new JPanel();

        JComboBox<String> shapeComboBox = new JComboBox<>(new String[] { "Cube", "Cuboid", "Sphere", "Cylinder" });
        optionsPanel.add(new JLabel("Select 3D Shape:"));
        optionsPanel.add(shapeComboBox);

        JButton show3DShapeButton = new JButton("Show 3D Shape");
        show3DShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedShape = (String) shapeComboBox.getSelectedItem();
                show3DShape(selectedShape);
            }
        });

        optionsPanel.add(show3DShapeButton);

        optionsFrame.getContentPane().add(optionsPanel);
        optionsFrame.setSize(300, 200);
        optionsFrame.setLocationRelativeTo(null);
        optionsFrame.setVisible(true);
    }

    private static void show3DShape(String shape) {
        JFrame threeDFrame = new JFrame("3D Drawing Panel");
        threeDFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ThreeDDrawingPanel threeDDrawingPanel = new ThreeDDrawingPanel(shape);

        threeDFrame.getContentPane().add(threeDDrawingPanel);
        threeDFrame.setSize(800, 600);
        threeDFrame.setLocationRelativeTo(null);
        threeDFrame.setVisible(true);
    }
}
