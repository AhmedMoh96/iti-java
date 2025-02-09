package MoveString;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveStringPanel extends JPanel implements KeyListener {
    private int x = 150, y = 150;
    private String text = "Hello!";

    public MoveStringPanel() {
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(text, x, y);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) x -= 10;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) x += 10;
        if (e.getKeyCode() == KeyEvent.VK_UP) y -= 10;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) y += 10;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
