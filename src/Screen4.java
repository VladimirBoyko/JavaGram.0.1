import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Полупрозрачное окно с настройками профиля
public class Screen4 {
    private JPanel rootPanelScreen4;
    private JPanel rootPanelTitle;
    private JPanel rootPanelBackground;
    private JButton buttonClose;
    private JButton buttonHide;
    private JTextField textFieldFirstName;
    private JButton buttonSave;
    private JLabel labelSettingProfile;
    private JPanel rootPanelLower;
    private JButton buttonBack;
    private JButton buttonExitIsProfile;
    private JPanel rootPanelWithButttonBackSettingProfile;
    private JTextPane textPaneSecondName;
    private BufferedImage iconBack;
    private BufferedImage iconClose;
    private BufferedImage iconHide;


    {
        try {
            iconBack = ImageIO.read(new File("res/img/icon-back.png"));
            iconClose = ImageIO.read(new File("res/img/icon-close.png"));
            iconHide = ImageIO.read(new File("res/img/icon-hide.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonClose.setIcon(new ImageIcon(iconClose));
        buttonClose.setBorder(BorderFactory.createEmptyBorder());

        buttonHide.setIcon(new ImageIcon(iconHide));
        buttonHide.setBorder(BorderFactory.createEmptyBorder());

        Color color = new Color(0, 190, 228);
        buttonSave.setBorder(BorderFactory.createLineBorder(color, 1, true));

    }

    private void createUIComponents() {
        buttonBack = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconBack, 0, 0, null);
            }
        };

        textFieldFirstName = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.drawLine(0, 50, 200, 50);
                textFieldFirstName.setBorder(BorderFactory.createEmptyBorder());
            }
        };
        textPaneSecondName = new JTextPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.drawLine(0, 40, 200, 40);
            }
        };
        buttonExitIsProfile = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Color color = new Color(0, 172, 211, 180);
                g.setColor(color);
                g.drawLine(20, 30, 100, 30);
            }
        };
    }

    public void switcherExitFromSettingProfile(ActionListener actionListener) {
        buttonBack.addActionListener(actionListener);
        buttonSave.addActionListener(actionListener);
    }

    public JPanel getRootPanelScreen4() {
        return rootPanelScreen4;
    }
}
