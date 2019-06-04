import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Полкпрозрачное окно с формой добавления контакта
public class Screen5 {
    private JPanel rootPanelTitle;
    private JButton buttonHide;
    private JButton buttonClose;
    private JPanel rootPanelBackground;
    private JLabel labelAddContacts;
    private JTextField textFieldFirstName;
    private JButton buttonAdd;
    private JPanel rootPanelLower;
    private JPanel rootPanelWithButttonBackSettingProfile;
    private JButton buttonBack;
    private JTextPane textPaneInfo;
    private JTextPane textPaneSecondName;
    private JTextPane textPanePhoneNumber;
    private JPanel rootPanelScreen5;
    private BufferedImage iconBack;
    private BufferedImage iconPhone;

    {
        StyledDocument doc = textPaneInfo.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        StyledDocument doc2 = textPaneSecondName.getStyledDocument();
        doc2.setParagraphAttributes(0, doc2.getLength(), center, false);

        try {
            iconBack = ImageIO.read(new File("res/img/icon-back.png"));
            iconPhone = ImageIO.read(new File("res/img/icon-phone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonBack.setIcon(new ImageIcon(iconBack));
        buttonBack.setBorder(BorderFactory.createEmptyBorder());
        Color color = new Color(0, 190, 228);
        buttonAdd.setBorder(BorderFactory.createLineBorder(color, 1, true));

        textFieldFirstName.setBorder(BorderFactory.createEmptyBorder());
    }

    private void createUIComponents() {
        textFieldFirstName = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.setColor(Color.WHITE);
                g.drawLine(0, 46, 300, 46);
            }
        };
        textPaneSecondName = new JTextPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.setColor(Color.WHITE);
                g.drawLine(0, 46, 300, 46);
            }
        };
        textPanePhoneNumber = new JTextPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconPhone, 0, 2, null);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.setColor(Color.WHITE);
                g.drawLine(0, 46, 300, 46);
            }
        };
    }

    public void switcherExitFromAddContact(ActionListener actionListener) {
        buttonBack.addActionListener(actionListener);
        buttonAdd.addActionListener(actionListener);
    }

    public JPanel getRootPanelScreen5() {
        return rootPanelScreen5;
    }
}
