package DrawLine;

import javax.swing.*;

public class DrawLineApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Line");
        frame.setSize(500, 400);
        
        DrawLinePanel panel = new DrawLinePanel();
        frame.setContentPane(panel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
