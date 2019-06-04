import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

//Форма для отправки сообщений "от меня"
public class MyMessageRenderer extends JPanel  {
    private JPanel rootPanel;
    private JTextArea textPane;
    private JPanel botPanel;
    private JPanel topPanel;
    private JPanel rightPanel;
    private JLabel timeLabel;
    private JPanel rootPanel1;
    private BufferedImage top;
    private BufferedImage bottom;
    private BufferedImage rigth;

    {
        try {
            top = ImageIO.read(new File("res/img/message-out-top.png"));
            bottom = ImageIO.read(new File("res/img/message-out-bottom.png"));
            rigth = ImageIO.read(new File("res/img/message-out-right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeLabel.setText(new Date().toString());
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = this;

        topPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(top, 0, 0, null);
            }
        };
        rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(rigth, 0, 12, null);
            }
        };
        botPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bottom, 0, 0, null);
            }
        };
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextArea getTextPane() {
        return textPane;
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public JPanel getRootPanel1() {
        return rootPanel1;
    }
}
