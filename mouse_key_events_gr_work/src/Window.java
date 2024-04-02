import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    JLabel statusLabel;
    JButton but1;
    public Window(String str) {
        super(str);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        statusLabel = new JLabel();
        add(statusLabel, BorderLayout.SOUTH);

        JPanel pan1 = new JPanel();
        pan1.setLayout(null);
        but1 = new JButton("I'm a button");
        but1.setSize(100,40);
        pan1.add(but1);
        but1.setLocation(this.getX() + 200, this.getY() + 100);
        add(pan1, BorderLayout.CENTER);

        pan1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                statusLabel.setText("x = " + e.getX() + " " + "y = " + e.getY());
            }
        });

        but1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                statusLabel.setText("x = " + (but1.getX() + e.getX()) + " " + "y = " + (but1.getY() + e.getY()));
            }
        });

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but1.setText("I'm a button");
                but1.setSize(100, 40);
            }
        });

        but1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xCord = e.getXOnScreen() - getX() - 7;
                int yCord = e.getYOnScreen() - getY() - 30;
                statusLabel.setText("x = " + xCord + " " + "y = " + yCord);

                if (e.isControlDown()) {
                    but1.setLocation(xCord, yCord);
                }

            }
        });

        pan1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xCord = e.getXOnScreen() - getX() - 7;
                int yCord = e.getYOnScreen() - getY() - 30;
                statusLabel.setText("x = " + xCord + " " + "y = " + yCord);
            }
        });

        pan1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                but1.setLocation(e.getX(), e.getY());
            }
        });

        but1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    String text = but1.getText();
                    if (text.length() > 0) {
                        but1.setText(text.substring(0, text.length() - 1));
                        but1.setSize(but1.getWidth() - 6, but1.getHeight());
                    }
                } else {
                    char c = e.getKeyChar();
                    if (Character.isLetterOrDigit(c)) {
                        but1.setText(but1.getText() + c);
                        but1.setSize(but1.getWidth() + 8, but1.getHeight());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Window window = new Window("");
        window.setSize(500, 400);
        window.setLocation(500, 150);
        window.setVisible(true);
    }
}