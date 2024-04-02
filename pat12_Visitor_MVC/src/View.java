import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class View extends JFrame{
    MyQueue<MyInteger> myQueue = new MyQueue<>();
    JList<MyInteger> list = new JList<>();
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<JLabel> labels = new ArrayList<>();
    ArrayList<JTextArea> areas = new ArrayList<>();
    View() throws NumberFormatException {
        super("app");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton size = new JButton("size");
        buttons.add(size);
        JButton isEmpty = new JButton("isEmpty");
        buttons.add(isEmpty);
        JButton clear = new JButton("clear");
        buttons.add(clear);
        JButton equals = new JButton("equals");
        buttons.add(equals);
        JButton toString = new JButton("toString");
        buttons.add(toString);
        JButton average = new JButton("average");
        buttons.add(average);
        Box box1 = new Box(1);
        box1.add(size);
        box1.add(isEmpty);
        box1.add(clear);
        box1.add(equals);
        box1.add(toString);
        box1.add(average);
        add(box1, BorderLayout.WEST);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("standard method:");
        labels.add(label1);
        JTextArea textArea1 = new JTextArea("standard method");
        areas.add(textArea1);
        JLabel label2 = new JLabel("method for queue:");
        labels.add(label2);
        JTextArea textArea2 = new JTextArea("method for queue");
        areas.add(textArea2);
        panel.add(label1);
        panel.add(textArea1);
        panel.add(label2);
        panel.add(textArea2);
        panel.add(list);
        add(panel, BorderLayout.CENTER);

        Box box2 = new Box(1);
        JButton front = new JButton("front");
        buttons.add(front);
        JButton back = new JButton("back");
        buttons.add(back);
        JButton push = new JButton("push");
        buttons.add(push);
        JButton pop = new JButton("pop");
        buttons.add(pop);
        JButton pushAll = new JButton("pushAll");
        buttons.add(pushAll);
        JButton toList = new JButton("toList");
        buttons.add(toList);
        box2.add(front);
        box2.add(back);
        box2.add(push);
        box2.add(pop);
        box2.add(pushAll);
        box2.add(toList);
        add(box2, BorderLayout.EAST);

        Controller controller = new Controller(buttons, areas, labels, myQueue, list);
        controller.includeComponents();

    }
}
