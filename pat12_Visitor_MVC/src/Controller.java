import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Controller {
    MyQueue<MyInteger> myQueue = new MyQueue<>();
    JList<MyInteger> list = new JList<>();
    DefaultListModel<MyInteger> model = new DefaultListModel<>();
    java.util.List<JButton> buttons = new ArrayList<>();
    java.util.List<JLabel> labels = new ArrayList<>();
    List<JTextArea> areas = new ArrayList<>();

    Controller(ArrayList<JButton> buttons, ArrayList<JTextArea> areas, ArrayList<JLabel> labels, MyQueue<MyInteger> myQueue, JList<MyInteger> list) {
        this.buttons = buttons;
        this.areas = areas;
        this.labels = labels;
        this.myQueue = myQueue;
        this.list = list;
    }
    public void includeComponents() {
        sizeBut(buttons.get(0));
        isEmptyBut(buttons.get(1));
        clearBut(buttons.get(2));
        equalsBut(buttons.get(3));
        toStringBut(buttons.get(4));
        averageBut(buttons.get(5));
        frontBut(buttons.get(6));
        backBut(buttons.get(7));
        pushBut(buttons.get(8));
        popBut(buttons.get(9));
        pushAllBut(buttons.get(10));
        toLisBut(buttons.get(11));
    }

    public void sizeBut(JButton button) {
        button.addActionListener(e -> {
            labels.get(0).setText(button.getText() + ":");
            areas.get(0).setText(String.valueOf(myQueue.size()));
        });
    }

    public void isEmptyBut(JButton button) {
        button.addActionListener(e -> {
            labels.get(0).setText(button.getText() + ":");
            if (myQueue.isEmpty()) {
                areas.get(0).setText("empty");
            } else {
                areas.get(0).setText("not empty");
            }
        });
    }

    public void clearBut(JButton button) {
        button.addActionListener(e -> {
            labels.get(0).setText(button.getText() + ":");
            myQueue.clear();
        });
    }
    public void equalsBut(JButton button) {
        button.addActionListener(e -> {
            MyQueue<MyInteger> newQueue = new MyQueue<>();
            String newStrQueue = JOptionPane.showInputDialog("Input new queue");
            StringTokenizer tokenizer = new StringTokenizer(newStrQueue, " ");
            while (tokenizer.hasMoreTokens()) {
                newQueue.push((new MyInteger(tokenizer.nextToken())).parseIntElem());
            }
            areas.get(0).setText(String.valueOf(myQueue.equals(newQueue)));
        });
    }
    public void toStringBut(JButton button) {
        button.addActionListener(e -> {
            labels.get(0).setText(button.getText() + ":");
            areas.get(0).setText(myQueue.toString());
        });
    }
    public void frontBut(JButton button) {
        button.addActionListener(e -> {
            labels.get(1).setText(button.getText() + ":");
            try {
                areas.get(1).setText(String.valueOf(myQueue.front()));
            } catch (NullPointerException exception) {
                areas.get(1).setText("Nothing");
                JOptionPane.showMessageDialog(null, "Queue is empty", "", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    public void backBut(JButton button) {
        button.addActionListener(e -> {
            labels.get(1).setText(button.getText() + ":");
            try {
                areas.get(1).setText(String.valueOf(myQueue.back()));
            } catch (NullPointerException exception) {
                areas.get(1).setText("Nothing");
                JOptionPane.showMessageDialog(null, "Queue is empty", "", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    public void pushBut(JButton button) {
        button.addActionListener(e -> {
            try {
                String inputStr = JOptionPane.showInputDialog("Input value");
                if (inputStr != null) {
                    myQueue.push((new MyInteger(inputStr)).parseIntElem());
                }
            } catch (NullPointerException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input correct values", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    public void popBut(JButton button) {
        button.addActionListener(e -> {
            labels.get(1).setText(button.getText() + ":");
            try {
                myQueue.pop();
            } catch (NullPointerException exception) {
                areas.get(1).setText("Nothing");
                JOptionPane.showMessageDialog(null, "Queue is empty", "", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    public void pushAllBut(JButton button) {
        button.addActionListener(e -> {
            try {
                MyQueue<MyInteger> newQueue = new MyQueue<>();
                String newStrQueue = JOptionPane.showInputDialog("Input new queue");
                StringTokenizer tokenizer = new StringTokenizer(newStrQueue, " ");
                while (tokenizer.hasMoreTokens()) {
                    newQueue.push((new MyInteger(tokenizer.nextToken())).parseIntElem());
                }
                myQueue.pushAll(newQueue);
            } catch (NullPointerException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input correct values", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    public void toLisBut(JButton button) {
        button.addActionListener(e -> {
            model = myQueue.getListModel();
            list.setModel(model);
        });
    }
    public void averageBut(JButton button) {
        button.addActionListener(e -> {
            labels.get(0).setText(button.getText());
            areas.get(0).setText(String.valueOf(getAverage()));
        });
    }
    public double getAverage() {
        MyVisitor visitor = new MyVisitor();
        MyQueue<MyInteger>.MyIterator iterator = myQueue.iterator();
        while (iterator.hasNext()) {
            iterator.current().accept(visitor);
            iterator.next();
        }
        return visitor.getAver();
    }
}