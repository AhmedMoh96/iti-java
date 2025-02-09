package MoveString;

import javax.swing.*;

public class MoveStringApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Move String");
        frame.setSize(400, 400);
        
        MoveStringPanel panel = new MoveStringPanel();
        frame.setContentPane(panel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
}
