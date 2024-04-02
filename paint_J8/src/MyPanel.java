import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    Graphics2D graphics;
    BufferedImage image;
    int startX;
    int startY;
    Color color = Color.WHITE;
    MyPanel() {
        image = new BufferedImage(600, 500, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.fillRect(0, 0, 600, 500);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int endX = e.getX();
                int endY = e.getY();
                graphics.setColor(color);
                graphics.setStroke(new BasicStroke(3));
                graphics.drawLine(startX, startY, endX, endY);
                startX = endX;
                startY = endY;
                repaint();
            }
        });

    }
    public void clearWindow() {
        color = Color.WHITE;
        image = new BufferedImage(600, 500, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.fillRect(0, 0, 600, 500);
        repaint();
    }
    public Dimension getImageDimension() {
        return new Dimension(image.getWidth(), image.getHeight());
    }
    public void setImage(String pathName) throws IOException {
        image = ImageIO.read(new File(pathName));
        graphics = image.createGraphics();
        repaint();
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, this);
    }
}
