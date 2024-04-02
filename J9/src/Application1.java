import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Application1 extends JPanel {
    Vector<String> forList1 = new Vector<>();
    Vector<String> forList2 = new Vector<>();
    Vector<String> bufferedValues = new Vector<>();
    JList<String> list1 = new JList<>(forList1);
    JList<String> list2 = new JList<>(forList2);
    Application1() {
        JPanel bufPanel = new JPanel();
        setLayout(new BorderLayout());

        for (int i = 0; i < 6; i++) {
            forList1.add("number " + i);
        }
        for (int i = 0; i < 7; i++) {
            forList2.add("letter " + i);
        }

        list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        add(list1, BorderLayout.WEST);
        add(list2, BorderLayout.EAST);

        JButton leftBut = new JButton("<");
        JButton rightBut = new JButton(">");
        bufPanel.setLayout(new BorderLayout());
        bufPanel.add(rightBut, BorderLayout.NORTH);
        JPanel bufPan2 = new JPanel();
        bufPanel.add(bufPan2, BorderLayout.CENTER);
        bufPanel.add(leftBut, BorderLayout.SOUTH);
        add(bufPanel, BorderLayout.CENTER);

        rightBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] indicesOfList = list1.getSelectedIndices();
                int counter = 0;
                for (int i = 0; i < indicesOfList.length; i++) {
                    bufferedValues.add(forList1.get(indicesOfList[i] - counter));
                    forList1.remove(indicesOfList[i] - counter);
                    counter++;
                }
                forList2.addAll(bufferedValues);
                bufferedValues.clear();

                list1.setListData(forList1);
                list2.setListData(forList2);
            }
        });

        leftBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] indicesOfList = list2.getSelectedIndices();
                int counter = 0;
                for (int i = 0; i < indicesOfList.length; i++) {
                    bufferedValues.add(forList2.get(indicesOfList[i] - counter));
                    forList2.remove(indicesOfList[i] - counter);
                    counter++;
                }
                forList1.addAll(bufferedValues);
                bufferedValues.clear();

                list1.setListData(forList1);
                list2.setListData(forList2);
            }
        });
    }
}
