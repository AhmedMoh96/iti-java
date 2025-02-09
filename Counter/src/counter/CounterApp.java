package Counter;

import javax.swing.*;

public class CounterApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Counter App");
        frame.setSize(300, 200);
        
        CounterPanel panel = new CounterPanel();
        frame.setContentPane(panel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
