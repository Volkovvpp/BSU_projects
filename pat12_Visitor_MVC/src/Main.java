import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        try {
            View window = new View();
            window.setVisible(true);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}