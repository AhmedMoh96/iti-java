package DrawLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawLinePanel extends JPanel {
    private int x1, y1, x2, y2; 
    private boolean isDrawn = false; 

    public DrawLinePanel() {
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
                isDrawn = true;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isDrawn) {
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
