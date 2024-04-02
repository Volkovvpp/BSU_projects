import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public class Main extends JFrame {
    MyQueue<String> myQueue = new MyQueue<>();
    JList<String> list = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    Main() {
        super("app");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton size = new JButton("size");
        JButton isEmpty = new JButton("isEmpty");
        JButton clear = new JButton("clear");
        JButton equals = new JButton("equals");
        JButton toString = new JButton("toString");
        Box box1 = new Box(1);
        box1.add(size);
        box1.add(isEmpty);
        box1.add(clear);
        box1.add(equals);
        box1.add(toString);
        add(box1, BorderLayout.WEST);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("standard method:");
        JTextArea textArea1 = new JTextArea("standard method");
        JLabel label2 = new JLabel("method for queue:");
        JTextArea textArea2 = new JTextArea("method for queue");
        panel.add(label1);
        panel.add(textArea1);
        panel.add(label2);
        panel.add(textArea2);
        panel.add(list);
        add(panel, BorderLayout.CENTER);

        Box box2 = new Box(1);
        JButton front = new JButton("front");
        JButton back = new JButton("back");
        JButton push = new JButton("push");
        JButton pop = new JButton("pop");
        JButton pushAll = new JButton("pushAll");
        JButton toList = new JButton("toList");
        box2.add(front);
        box2.add(back);
        box2.add(push);
        box2.add(pop);
        box2.add(pushAll);
        box2.add(toList);
        add(box2, BorderLayout.EAST);

        size.addActionListener(e -> {
            label1.setText(size.getText() + ":");
            textArea1.setText(String.valueOf(myQueue.size()));
        });

        isEmpty.addActionListener(e -> {
            label1.setText(clear.getText() + ":");
            if (myQueue.isEmpty()) {
                textArea1.setText("empty");
            } else {
                textArea1.setText("not empty");
            }
        });

        clear.addActionListener(e -> {
            label1.setText(clear.getText() + ":");
            myQueue.clear();
        });

        equals.addActionListener(e -> {
            MyQueue<String> newQueue = new MyQueue<>();
            String newStrQueue = JOptionPane.showInputDialog("Input new queue");
            StringTokenizer tokenizer = new StringTokenizer(newStrQueue, " ");
            while (tokenizer.hasMoreTokens()) {
                newQueue.push(tokenizer.nextToken());
            }
            textArea1.setText(String.valueOf(myQueue.equals(newQueue)));
        });

        toString.addActionListener(e -> {
            label1.setText(toString.getText() + ":");
            textArea1.setText(myQueue.toString());
        });

        front.addActionListener(e -> {
            label2.setText(front.getText() + ":");
            try {
                textArea2.setText(myQueue.front());
            } catch (NullPointerException exception) {
                textArea2.setText("Nothing");
                JOptionPane.showMessageDialog(null, "Queue is empty", "", JOptionPane.WARNING_MESSAGE);
            }
        });

        back.addActionListener(e -> {
            label2.setText(back.getText() + ":");
            try {
                textArea2.setText(myQueue.back());
            } catch (NullPointerException exception) {
                textArea2.setText("Nothing");
                JOptionPane.showMessageDialog(null, "Queue is empty", "", JOptionPane.WARNING_MESSAGE);
            }
        });

        push.addActionListener(e -> {
            try {
                String inputStr = JOptionPane.showInputDialog("Input value");
                if (inputStr != null) {
                    myQueue.push(inputStr);
                }
            } catch (NullPointerException ex) {

            }
        });

        pop.addActionListener(e -> {
            label2.setText(pop.getText() + ":");
            try {
                myQueue.pop();
            } catch (NullPointerException exception) {
                textArea2.setText("Nothing");
                JOptionPane.showMessageDialog(null, "Queue is empty", "", JOptionPane.WARNING_MESSAGE);
            }
        });

        pushAll.addActionListener(e -> {
            try {
                MyQueue<String> newQueue = new MyQueue<>();
                String newStrQueue = JOptionPane.showInputDialog("Input new queue");
                StringTokenizer tokenizer = new StringTokenizer(newStrQueue, " ");
                while (tokenizer.hasMoreTokens()) {
                    newQueue.push(tokenizer.nextToken());
                }
                myQueue.pushAll(newQueue);
            } catch (NullPointerException ex) {

            }
        });

        toList.addActionListener(e -> {
            model = myQueue.getListModel();
            list.setModel(model);
        });
    }

    public static void main(String[] args) {
        Main window = new Main();
        window.setVisible(true);
    }
}
