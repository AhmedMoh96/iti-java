package DrawLines; 

import javax.swing.*;

public class DrawMultiLineApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Multiple Lines");
        frame.setSize(500, 400);
        
        DrawMultiLinePanel panel = new DrawMultiLinePanel();
        frame.setContentPane(panel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
