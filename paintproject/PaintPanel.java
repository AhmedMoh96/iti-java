package paintproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaintPanel extends JPanel {
    private final ArrayList<Shape> shapes = new ArrayList<>();
    private Shape currentShape = null;
    private Color currentColor = Color.BLACK;
    private boolean isFilled = false;
    private boolean isDotted = false;
    private boolean isEraser = false;
    private String currentTool = "Pencil";

    public PaintPanel() {
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton pencilButton = new JButton("Free Hand");
        JButton lineButton = new JButton("Line");
        JButton rectButton = new JButton("Rectangle");
        JButton ovalButton = new JButton("Oval");
        JButton eraserButton = new JButton("Eraser");
        JButton clearButton = new JButton("Clear");

        JButton redButton = new JButton("Red");
        JButton greenButton = new JButton("Green");
        JButton blueButton = new JButton("Blue");

        JCheckBox fillCheckBox = new JCheckBox("Fill");
        JCheckBox dottedCheckBox = new JCheckBox("Dotted");

        
        pencilButton.addActionListener(e -> setCurrentTool("Pencil"));
        lineButton.addActionListener(e -> setCurrentTool("Line"));
        rectButton.addActionListener(e -> setCurrentTool("Rectangle"));
        ovalButton.addActionListener(e -> setCurrentTool("Oval"));
        eraserButton.addActionListener(e -> setCurrentTool("Eraser"));
        clearButton.addActionListener(e -> clearCanvas());

        redButton.addActionListener(e -> setCurrentColor(Color.RED));
        greenButton.addActionListener(e -> setCurrentColor(Color.GREEN));
        blueButton.addActionListener(e -> setCurrentColor(Color.BLUE));

        fillCheckBox.addItemListener(e -> isFilled = fillCheckBox.isSelected());
        dottedCheckBox.addItemListener(e -> isDotted = dottedCheckBox.isSelected());


        add(pencilButton);
        add(lineButton);
        add(rectButton);
        add(ovalButton);
        add(eraserButton);
        add(clearButton);
        add(redButton);
        add(greenButton);
        add(blueButton);
        add(fillCheckBox);
        add(dottedCheckBox);


        MouseAdapter mouseHandler = new MouseAdapter() {
            private int startX, startY;

            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                if (currentTool.equals("Pencil") || currentTool.equals("Eraser")) {
                    currentShape = new Shape(currentTool, startX, startY, startX, startY, currentColor, isFilled, isDotted);
                    shapes.add(currentShape);
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int endX = e.getX();
                int endY = e.getY();
                if (currentTool.equals("Pencil") || currentTool.equals("Eraser")) {
                    currentShape.addPoint(endX, endY);
                } else {
                    currentShape = new Shape(currentTool, startX, startY, endX, endY, currentColor, isFilled, isDotted);
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!currentTool.equals("Pencil") && !currentTool.equals("Eraser")) {
                    shapes.add(currentShape);
                }
                currentShape = null;
                repaint();
            }
        };

        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    private void setCurrentTool(String tool) {
        currentTool = tool;
        isEraser = tool.equals("Eraser");
    }

    private void setCurrentColor(Color color) {
        currentColor = color;
    }

    private void clearCanvas() {
        shapes.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
        if (currentShape != null) {
            currentShape.draw(g2d);
        }
    }
}
