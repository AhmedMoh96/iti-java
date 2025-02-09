package Counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterPanel extends JPanel {
    private int counter = 0;
    private JLabel counterLabel;

    public CounterPanel() {
        setLayout(new BorderLayout());

        counterLabel = new JLabel(String.valueOf(counter), SwingConstants.CENTER);
        counterLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(counterLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton incButton = new JButton("+");
        incButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                counterLabel.setText(String.valueOf(counter));
            }
        });

        JButton decButton = new JButton("-");
        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                counterLabel.setText(String.valueOf(counter));
            }
        });

        buttonPanel.add(incButton);
        buttonPanel.add(decButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
