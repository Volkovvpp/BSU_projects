import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {
    Main(String name) {
        super(name);
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(600,500);
            JTabbedPane tabsLeft = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
            Application1 window1 = new Application1();
            Application2 window2 = new Application2();
            Application3 window3 = new Application3();
            tabsLeft.addTab("Tab 1", window1);
            tabsLeft.addTab("Tab 2", window2);
            tabsLeft.addTab("Tab 3", window3);
            add(tabsLeft);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Main window = new Main("App");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
