package paintproject;

import javax.swing.*;

public class PaintApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint Brush");
        frame.add(new PaintPanel());
        frame.setSize(800, 600);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
