package answers;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class LambdaForSwing {
    private int count;
    
    public LambdaForSwing() {
        JFrame frame = new JFrame("Swing Lambda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton button = new JButton("Count");
        frame.add(button, BorderLayout.NORTH);
        
        final JLabel counter = new JLabel(String.valueOf(count));
        frame.add(counter, BorderLayout.CENTER);
        
/*
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                counter.setText(String.valueOf(count));
            }
        });
*/

        // Answer
        button.addActionListener(e -> {
            count++;
            counter.setText(String.valueOf(count));
        });
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String... args) {
/*        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LambdaForSwing();
            }
        });
*/

        // Answer 1
//        SwingUtilities.invokeLater(() -> new LambdaForSwing());

        // Answer 2
        SwingUtilities.invokeLater(LambdaForSwing::new);
    }
}
