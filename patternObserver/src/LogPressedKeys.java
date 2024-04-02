import javax.swing.*;

public class LogPressedKeys implements MyObserver {
    JTextArea textArea = new JTextArea(15,30);
    @Override
    public void update(String key) {
        textArea.append(key + " ");
    }
}
