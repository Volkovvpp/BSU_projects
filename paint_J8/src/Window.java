import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {
    MyPanel myPanel = new MyPanel();
    JScrollPane paneForDrawing;
    Dimension dimension = new Dimension(700,600);
    Window(String name) {
        super(name);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton redButton = new JButton("red");
        JButton greenButton = new JButton("green");
        JButton blackButton = new JButton("black");
        JButton save = new JButton("save");
        JButton open = new JButton("open");
        JButton clear = new JButton("clear");

        JPanel colorPane = new JPanel();
        colorPane.add(open);
        colorPane.add(save);
        colorPane.add(clear);
        colorPane.add(redButton);
        colorPane.add(greenButton);
        colorPane.add(blackButton);
        add(colorPane, BorderLayout.NORTH);

        paneForDrawing = new JScrollPane(myPanel);
        myPanel.setPreferredSize(new Dimension(dimension));
        add(new JScrollPane(myPanel));

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPanel.setColor(Color.GREEN);
            }
        });

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPanel.setColor(Color.RED);
            }
        });

        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPanel.setColor(Color.BLACK);
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenFile;
                JFileChooser fileChooser = new JFileChooser("/Images");
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    chosenFile = fileChooser.getSelectedFile().getAbsolutePath();
                    if (chosenFile.endsWith(".jpg")) {
                        try {
                            myPanel.setImage(chosenFile);
                            dimension = myPanel.getImageDimension();
                            myPanel.setPreferredSize(dimension);
                            System.out.println(chosenFile);
                        } catch (IOException ex) {
                            JOptionPane.showInputDialog(null, "Wrong image", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Wrong image format\nChoose files with \".jpg\" format", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenSavingPath;
                JFileChooser fileChooser = new JFileChooser("/Images");
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    chosenSavingPath = fileChooser.getSelectedFile().getPath();
                    if (!chosenSavingPath.endsWith(".jpg")) {
                        chosenSavingPath += ".jpg";
                    }
                    File saveFile = new File(chosenSavingPath);
                    try {
                        ImageIO.write(myPanel.image, "jpg", saveFile);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPanel.clearWindow();
            }
        });
    }

    public static void main(String[] args) {
        Window window = new Window("Paint");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}