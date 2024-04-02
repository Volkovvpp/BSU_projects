import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Application2 extends JPanel {
    private final int COLUMS = 5;
    private final int ROWS = 5;
    Application2() {
        setLayout(new GridLayout(ROWS, COLUMS));
        MouseAdapter adapter = new MouseAdapter() {
            String old = "";
            Color oldColor;
            @Override
            public void mousePressed(MouseEvent e) {
                JButton currButton = (JButton) e.getSource();
                old = currButton.getText();
                currButton.setText("Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JButton currButton = (JButton) e.getSource();
                currButton.setText(old);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JButton currButton = (JButton) e.getSource();
                oldColor = currButton.getBackground();
                currButton.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton currButton = (JButton) e.getSource();
                currButton.setBackground(oldColor);
            }
        };

        for (int i = 1; i <= COLUMS * ROWS; i++) {
            JButton button = new JButton(String.format("%s", i));
            add(button);
            button.addMouseListener(adapter);
        }
    }
}