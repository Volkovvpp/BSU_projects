import javax.swing.*;

public class Main extends JFrame {
    Main(String str) {
        super(str);
        setSize(600,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea area1;
        JTextArea area2;

        EventProcessing process = new EventProcessing();
        PressedKeyObserver keyObserver = new PressedKeyObserver();
        LogPressedKeys logPressedKeys = new LogPressedKeys();

        area1 = keyObserver.textArea;
        area2 = logPressedKeys.textArea;

        process.attach(keyObserver);
        process.attach(logPressedKeys);

        JPanel contents = new JPanel();
        contents.add(area1);
        contents.add(area2);
        setContentPane(contents);

        area1.addKeyListener(process.adapter);
        area2.addKeyListener(process.adapter);
        area1.setEditable(false);
        area2.setEditable(false);
    }

    public static void main(String[] args) {
        Main window = new Main("Application");
        window.setVisible(true);
    }
}