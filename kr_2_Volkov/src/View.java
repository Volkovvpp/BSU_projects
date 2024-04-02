import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame {
    List<JButton> buttons = new ArrayList<>();
    public View (String name) {
        super(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,400);

        Controller controller = new Controller();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem clear = new JMenuItem("clear");
        menuBar.add(file);
        file.add(save);
        file.add(clear);
        setJMenuBar(menuBar);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel label1 = new JLabel("0 1 elements:");
        panel.add(label1, gbc);

        gbc.gridx = 1;
        JTextField textField1 = new JTextField(15);
        panel.add(textField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel label2 = new JLabel("Set:");
        panel.add(label2, gbc);

        gbc.gridx = 1;
        JTextField textField2 = new JTextField(15);
        panel.add(textField2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel label3 = new JLabel("Set power:");
        panel.add(label3, gbc);

        gbc.gridx = 1;
        JTextField textField3 = new JTextField(15);
        panel.add(textField3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel label4 = new JLabel("Add element:");
        panel.add(label4, gbc);

        gbc.gridx = 1;
        JTextField textField4 = new JTextField(15);
        panel.add(textField4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel dropdownLabel = new JLabel("Choose power option:");
        panel.add(dropdownLabel, gbc);

        gbc.gridx = 1;
        String[] options = {"Visitor", "Iterator"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        panel.add(dropdown, gbc);

        gbc.gridx = 2;
        JButton button1 = new JButton("Count power");
        buttons.add(button1);
        panel.add(button1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        JButton button2 = new JButton("Add element");
        buttons.add(button2);
        panel.add(button2, gbc);


        controller.addBut(button2, textField1, textField2, textField4);
        controller.powerBut(button1, textField3, dropdown);
        controller.save(save);
        controller.clear(clear, textField1, textField2, textField3);

        getContentPane().add(panel);
    }
}
