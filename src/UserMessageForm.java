import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

//форма отправки сообения "от пользователя"
public class UserMessageForm extends JPanel {
    private JLabel timeLabel;
    private JTextArea textPane;
    private JPanel rootPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel botPanel;
    private JPanel rootPanelMessage;
    private BufferedImage top;
    private BufferedImage bottom;
    private BufferedImage left;

    {
        try {
            top = ImageIO.read(new File("res/img/message-in-top.png"));
            bottom = ImageIO.read(new File("res/img/message-in-bottom.png"));
            left = ImageIO.read(new File("res/img/message-in-left.png"));
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
                g.drawImage(left, 0, 12, null);
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

    public JPanel getRootPanelMessage() {
        return rootPanelMessage;
    }
}
