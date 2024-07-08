import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private List<Shape> shapes;
    private int shapeType; // 0: Line, 1: Rectangle, 2: Circle
    private int x1, y1, x2, y2;
    private Color currentColor;

    public DrawingPanel() {
        shapes = new ArrayList<>();
        shapeType = 0; // Default shape is a line
        currentColor = Color.BLACK; // Default color is black

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();

                // Create the shape and add it to the list
                Shape shape = createShape();
                shapes.add(shape);

                repaint(); // Trigger the paintComponent method to redraw the shapes
            }
        });
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void clearDrawing() {
        shapes.clear();
        repaint();
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    private Shape createShape() {
        Shape shape = null;

        switch (shapeType) {
            case 0:
                // Create a line
                shape = new Line(x1, y1, x2, y2, currentColor);
                break;
            case 1:
                // Create a rectangle
                shape = new Rectangle(Math.min(x1, x2), Math.min(y1, y2),
                        Math.abs(x2 - x1), Math.abs(y2 - y1), currentColor);
                break;
            case 2:
                // Create a circle
                shape = new Circle(Math.min(x1, x2), Math.min(y1, y2),
                        Math.abs(x2 - x1), Math.abs(y2 - y1), currentColor);
                break;
            default:
                // Unsupported shape
                break;
        }

        return shape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }

    interface Shape {
        void draw(Graphics2D g);
    }

    static class Line implements Shape {
        private int x1, y1, x2, y2;
        private Color color;

        public Line(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    static class Rectangle implements Shape {
        private int x, y, width, height;
        private Color color;

        public Rectangle(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(color);
            g.drawRect(x, y, width, height);
        }
    }

    static class Circle implements Shape {
        private int x, y, width, height;
        private Color color;

        public Circle(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(color);
            g.drawOval(x, y, width, height);
        }
    }
}
