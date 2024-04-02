import javax.swing.*;
import java.awt.*;

public class PressedKeyObserver implements MyObserver{
    JTextArea textArea = new JTextArea(3,5);
    @Override
    public void update(String key) {
        textArea.setFont(new Font("Times new roman",Font.PLAIN, 35));
        textArea.setText(String.valueOf(key));
    }
}
