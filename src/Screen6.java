import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Полупрозрачное окно с формой редактирования контакта
public class Screen6 {
    private JPanel rootPanelTitle;
    private JButton buttonHide;
    private JButton buttonClose;
    private JLabel labelEditContact;
    private JTextField textFieldFullName;
    private JButton buttonDeleteUsers;
    private JPanel rootPanelWithNumberAndButton;
    private JLabel labelWithNumber;
    private JButton buttonSave;
    private JPanel rootPanelWithFieldFullName;
    private JLabel labelLogoUsers;
    private JPanel rootPanelLower;
    private JPanel rootPanelWithButttonBackSettingProfile;
    private JButton buttonBack;
    private JPanel rootPanelScreen6;
    private BufferedImage logoSova;
    private BufferedImage iconBack;
    private BufferedImage iconTrash;

    {
        try {
            logoSova = ImageIO.read(new File("res/img/logo-sova.png"));
            iconBack = ImageIO.read(new File("res/img/icon-back.png"));
            iconTrash = ImageIO.read(new File("res/img/icon-trash.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonDeleteUsers.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        Color color = new Color(0, 190, 228);
        buttonSave.setBorder(BorderFactory.createLineBorder(color, 1, true));

        buttonBack.setIcon(new ImageIcon(iconBack));
        buttonBack.setBorder(BorderFactory.createEmptyBorder());

        buttonDeleteUsers.setIcon(new ImageIcon(iconTrash));

        textFieldFullName.setBorder(BorderFactory.createEmptyBorder());


    }

    private void createUIComponents() {
        labelLogoUsers = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logoSova, 0, 0, null);
            }
        };
        textFieldFullName = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.setColor(Color.WHITE);
                g.drawLine(0, 45, 350, 45);
            }
        };
    }

    public void switcherExitFromAddContact(ActionListener actionListener) {
        buttonBack.addActionListener(actionListener);
        buttonSave.addActionListener(actionListener);
    }

    public JPanel getRootPanelScreen6() {
        return rootPanelScreen6;
    }
}
