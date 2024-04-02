import javax.swing.*;
import java.io.IOException;

public class Application3 extends JPanel{
    Application3() throws IOException {
        ButtonGroup group = new ButtonGroup();
        Icon icon1 = new ImageIcon("D:\\Images\\im1.jpg");
        Icon icon2 = new ImageIcon("D:\\Images\\im2.jpg");
        Icon icon3 = new ImageIcon("D:\\Images\\im3.jpg");
        Icon icon4 = new ImageIcon("D:\\Images\\im4.jpg");
        Icon icon5 = new ImageIcon("D:\\Images\\im5.jpg");

        for (int i = 0; i < 3; i++) {
            JRadioButton radioButton = new JRadioButton(icon2);
            radioButton.setPressedIcon(icon3);
            radioButton.setRolloverIcon(icon1);
            radioButton.setSelectedIcon(icon5);
            radioButton.setRolloverSelectedIcon(icon4);
            group.add(radioButton);
            add(radioButton);
        }
    }
}
