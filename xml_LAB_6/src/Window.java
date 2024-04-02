import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Window extends JFrame {
    List<Student> names = new ArrayList<>();
    String chosenFile = "";
    ReadingStudents reader = new ReadingStudents();
    StringBuilder students = new StringBuilder();
    JComboBox sortBox;
    JComboBox sortBox1;
    List<String> listOfNames = new ArrayList<>();
    Window(String name) throws IOException, ParserConfigurationException, SAXException {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem add = new JMenuItem("Add");
        JMenuItem save = new JMenuItem("Save");
        menuBar.add(file);
        file.add(open);
        file.add(add);
        file.add(save);
        setJMenuBar(menuBar);

        JButton sort = new JButton("Sort");
        JTextArea area = new JTextArea(15, 30);
        area.setEditable(false);

        JTextArea area1 = new JTextArea(15, 30);
        JTextField inputSubjects = new JTextField("numOfSem subj1 subj2");

        String[] items = {"Stream API", "My own sort"};
        sortBox = new JComboBox(items);

        String[] items1 = {"SAX", "DOM"};
        sortBox1 = new JComboBox(items1);

        JPanel contents = new JPanel();
        contents.add(area);
        contents.add(new JScrollPane(area1));
        contents.add(sortBox1);
        contents.add(inputSubjects);
        contents.add(sort);
        contents.add(sortBox);
        area1.setEditable(false);
        setContentPane(contents);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                students = new StringBuilder();
                JFileChooser fileChooser = new JFileChooser("src");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files","txt");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    chosenFile = fileChooser.getSelectedFile().getPath();
                    try {
                        reader = new ReadingStudents(chosenFile, sortBox1.getSelectedIndex());
                    } catch (IOException | ParserConfigurationException | SAXException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                for (int i = 0; i < reader.listOfAllStudents.size(); i++) {
                    students.append(reader.listOfAllStudents.get(i).toString()).append("\n");
                }
                area.setText(students.toString());
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String newStudent = JOptionPane.showInputDialog(null);
                    reader.addNewStudent(newStudent);
                    students.append(reader.listOfAllStudents.get(reader.listOfAllStudents.size() - 1)).append("\n");
                    area.setText(students.toString());
                } catch (NullPointerException ignored) { }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("src");
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    chosenFile = fileChooser.getSelectedFile().getPath();
                    FileXMLWriter fileXMLWriter = new FileXMLWriter();
                    fileXMLWriter.names = listOfNames;
                    fileXMLWriter.createFile(chosenFile);
                }
            }
        });

        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    reader.getStringForSort(inputSubjects.getText());
                    StrategyChoice strategyChoice = null;
                    switch (sortBox.getSelectedIndex()) {
                        case 0:
                            strategyChoice = new Option1();
                            break;
                        case 1:
                            strategyChoice = new Option2();
                            break;
                    }
                    names = strategyChoice.sorting(reader.listOfAllStudents, reader.numOfSemester, reader.theFirstSubj, reader.theSecondSubj);
                    StringBuilder strNames = new StringBuilder();
                    for (int i = 0; i < names.size(); i++) {
                        strNames.append(names.get(i).surname).append("\n");
                        listOfNames.add(names.get(i).surname);
                    }
                    area1.setText("");
                    area1.setText(String.valueOf(strNames));
                } catch (NoSuchElementException | NumberFormatException | NullPointerException exception) {
                    JOptionPane.showMessageDialog(null, "Input correct values", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        try {
            JFrame frame = new Window("Students");
            frame.setVisible(true);
            frame.setSize(700, 600);
            frame.setLocation(400, 150);
        } catch (NoSuchElementException exception) {
            JOptionPane.showMessageDialog(null, "Input all values in your file", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
