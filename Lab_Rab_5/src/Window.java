import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Window extends JFrame {
    Series series;
    Window(String win) {
        super(win);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JTextField text1 = new JTextField("the first member");
        add(text1);
        JTextField text2 = new JTextField("delta");
        add(text1);
        JTextField text3 = new JTextField("sum number");
        add(text1);
        JTextField text5 = new JTextField("Path");
        add(text5);

        Box box1 = Box.createVerticalBox();
        box1.add(text1);
        box1.add(text2);
        box1.add(text3);
        box1.add(text5);
        add(box1);

        JButton count = new JButton("count");
        add(count);

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton linearButton = new JRadioButton("linear");
        linearButton.setSelected(true);
        add(linearButton);

        JRadioButton expButton = new JRadioButton("exponential");
        add(expButton);

        JButton saveInFile = new JButton("save in file");
        add(saveInFile);

        buttonGroup.add(linearButton);
        buttonGroup.add(expButton);

        Box box2 = Box.createVerticalBox();
        box2.add(linearButton);
        box2.add(expButton);
        box2.add(count);
        box2.add(saveInFile);
        add(box2);

        JTextField text4 = new JTextField("sequence and sum");

        text4.setEditable(false);
        add(text4);

        count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double theFirstMember = Double.parseDouble(text1.getText());
                    double delta = Double.parseDouble(text2.getText());
                    int number = Integer.parseInt(text3.getText());
                    if (linearButton.isSelected()) {
                        series = new Liner(theFirstMember, delta, number);

                    } else if (expButton.isSelected()) {
                        series = new Exponential(theFirstMember, delta, number);
                    }
                    text4.setText(series.toString());
                } catch (NumberFormatException exception) {
                    JDialog wrongInput = new JDialog();
                    JOptionPane.showMessageDialog(wrongInput, "Input correct values", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        saveInFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tmp = text5.getText();
                    String path = Objects.equals(tmp, "") ? "src/output" : tmp;
                    series.saveInFile(new File(path));
                } catch (IOException ex) {
                    System.out.println("No file");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new Window("Series");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setLocation(450, 150);
    }
}