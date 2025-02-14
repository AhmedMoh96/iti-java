package paintproject;

import java.awt.*;
import java.util.ArrayList;

public class Shape {
    private final String type;
    private final ArrayList<Point> points = new ArrayList<>();
    private final Color color;
    private final boolean isFilled;
    private final boolean isDotted;
    private final int eraserSize = 15; 

    public Shape(String type, int x1, int y1, int x2, int y2, Color color, boolean isFilled, boolean isDotted) {
        this.type = type;
        this.color = type.equals("Eraser") ? Color.WHITE : color; 
        this.isFilled = isFilled;
        this.isDotted = isDotted;
        points.add(new Point(x1, y1));
        points.add(new Point(x2, y2));
    }

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);

        if (isDotted) {
            float[] dashPattern = {5, 5};
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, dashPattern, 0));
        } else {
            g2d.setStroke(new BasicStroke(2));
        }

        if (type.equals("Pencil")) {
            for (int i = 1; i < points.size(); i++) {
                g2d.drawLine(points.get(i - 1).x, points.get(i - 1).y, points.get(i).x, points.get(i).y);
            }
        } else if (type.equals("Eraser")) {
            for (Point p : points) {
                g2d.fillOval(p.x - eraserSize / 2, p.y - eraserSize / 2, eraserSize, eraserSize); 
            }
        } else {
            int startX = points.get(0).x;
            int startY = points.get(0).y;
            int endX = points.get(1).x;
            int endY = points.get(1).y;
            int width = Math.abs(endX - startX);
            int height = Math.abs(endY - startY);
            int minX = Math.min(startX, endX);
            int minY = Math.min(startY, endY);

            switch (type) {
                case "Line":
                    g2d.drawLine(startX, startY, endX, endY);
                    break;
                case "Rectangle":
                    if (isFilled) {
                        g2d.fillRect(minX, minY, width, height);
                    } else {
                        g2d.drawRect(minX, minY, width, height);
                    }
                    break;
                case "Oval":
                    if (isFilled) {
                        g2d.fillOval(minX, minY, width, height);
                    } else {
                        g2d.drawOval(minX, minY, width, height);
                    }
                    break;
            }
        }
    }
}
