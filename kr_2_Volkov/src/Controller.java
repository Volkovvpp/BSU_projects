import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Controller {
    MySet mySet = new MySet();
    public void powerBut(JButton button, JTextField textArea1, JComboBox<String> dropdown) {
        button.addActionListener(e -> {
            PowerStrategy powerStrategy = null;
            switch (dropdown.getSelectedIndex()) {
                case 0:
                    powerStrategy = new PowerOption1(mySet);
                    break;
                case 1:
                    powerStrategy = new PowerOption1(mySet);
                    break;
            }
            textArea1.setText(String.valueOf(mySet.cardinality(powerStrategy)));
        });
    }

    public void addBut(JButton addBut, JTextField textArea1, JTextField textArea2, JTextField textArea3) {
        addBut.addActionListener(e -> {
            try {
                mySet.add(Integer.parseInt(textArea3.getText()));
                textArea1.setText(mySet.toString());
                MySet.MyIterator iter = mySet.iterator();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; iter.hasNext(); i++) {
                    if (mySet.base.get(i).integer == 1) {
                        stringBuilder.append(iter.current + mySet.minimum).append(" ");
                    }
                    iter.next();
                }
                textArea2.setText(String.valueOf(stringBuilder));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Input correct values", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    public void save(JMenuItem save) {
        save.addActionListener(e -> {
            String chosenSavingPath;
            JFileChooser fileChooser = new JFileChooser("/Images");
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                chosenSavingPath = fileChooser.getSelectedFile().getPath();
                if (!chosenSavingPath.endsWith(".jpg")) {
                    chosenSavingPath += ".jpg";
                }
                File saveFile = new File(chosenSavingPath);
                mySet.save(chosenSavingPath);
            }
        });
    }

    public void clear(JMenuItem clear, JTextField textField, JTextField textField1, JTextField textField2) {
        clear.addActionListener(e -> {
            textField.setText("");
            textField1.setText("");
            textField2.setText("");
            mySet.base.clear();
            mySet.minimum = 0;
        });

    }
}
