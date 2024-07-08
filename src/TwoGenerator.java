import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoGenerator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("2D Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DrawingPanel drawingPanel = new DrawingPanel();

            JButton draw2DButton = new JButton("Draw 2D");
            draw2DButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame drawingFrame = new JFrame("2D Drawing Panel");
                    drawingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    drawingFrame.getContentPane().add(drawingPanel, BorderLayout.CENTER);
                    drawingFrame.setSize(500, 500);
                    drawingFrame.setLocationRelativeTo(null);
                    drawingFrame.setVisible(true);
                }
            });

            // Button to clear the drawing
            JButton clearButton = new JButton("Clear Drawing");
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawingPanel.clearDrawing();
                }
            });

            // Combo box to choose the shape dynamically
            JComboBox<String> shapeComboBox = new JComboBox<>(new String[] { "Line", "Rectangle", "Circle" });
            shapeComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedShape = shapeComboBox.getSelectedIndex();
                    drawingPanel.setShapeType(selectedShape);
                }
            });

            // Color chooser button
            JButton colorButton = new JButton("Choose Color");
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Color color = JColorChooser.showDialog(frame, "Choose a color", Color.BLACK);
                    if (color != null) {
                        drawingPanel.setCurrentColor(color);
                    }
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(draw2DButton);
            buttonPanel.add(clearButton);
            buttonPanel.add(new JLabel("Select Shape:"));
            buttonPanel.add(shapeComboBox);
            buttonPanel.add(colorButton);

            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
