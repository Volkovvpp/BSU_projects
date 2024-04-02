import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main extends JFrame {
    JButton buttonNo;
    Main(String str) {
        super(str);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("Do you like your salary?");
        label.setHorizontalAlignment(JLabel.CENTER); // выравнивание по центру
        add(label, BorderLayout.CENTER); // добавляем метку в центр окна

        buttonNo = new JButton("NO");
        JButton buttonYes = new JButton("YES");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 160));
        buttonPanel.add(buttonNo);
        buttonPanel.add(buttonYes);
        add(buttonPanel, BorderLayout.SOUTH);

        JDialog rightAnswer = new JDialog();
        rightAnswer.setSize(200, 100);
        rightAnswer.setLocationRelativeTo(null);
        JLabel upbeatAnswer = new JLabel("Thank you for your rate.");
        upbeatAnswer.setHorizontalAlignment(JLabel.CENTER);
        rightAnswer.add(upbeatAnswer);

        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightAnswer.setVisible(true);
                revalidate();
            }
        });

        Random random = new Random();
        buttonNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int randX = random.nextInt(getWidth() - 100);
                int randY = random.nextInt(getHeight() - 160);
                buttonNo.setLocation(randX, randY);
                System.out.println(randX + " " + randY);
            }
        });
    }

    public static void main(String[] args) {
        Main window = new Main("Catch me if you can");
    }
}