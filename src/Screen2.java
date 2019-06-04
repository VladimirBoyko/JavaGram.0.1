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

public class Screen2 extends JPanel {
    private JPanel rootPanel2;
    private JPanel rootPanel21;
    private JButton buttonHide;
    private JButton buttonClose;
    private JTextArea textArea1;
    private JPanel rootPanel22;
    private JTextPane textPaneJavaGram;
    private JTextPane textPaneIInfoText;
    private JButton buttonContinue;
    private JLabel jlabelWithNumberPhone;
    private JPasswordField passwordField1;
    private BufferedImage background;
    private BufferedImage logoMini;
    private BufferedImage iconLock;
    private BufferedImage iconClose;
    private BufferedImage iconHide;

    {
        StyledDocument doc = textPaneIInfoText.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        //загрузка картинок в контент
        try {
            background = ImageIO.read(new File("res/img/background.png"));
            logoMini = ImageIO.read(new File("res/img/logo-mini.png"));
            iconLock = ImageIO.read(new File("res/img/icon-lock.png"));
            iconClose = ImageIO.read(new File("res/img/icon-close.png"));
            buttonClose.setIcon(new ImageIcon(iconClose));
            buttonClose.setBorder(BorderFactory.createEmptyBorder());
            iconHide = ImageIO.read(new File("res/img/icon-hide.png"));
            buttonHide.setIcon(new ImageIcon(iconHide));
            buttonHide.setBorder(BorderFactory.createEmptyBorder());


            passwordField1.setBorder(BorderFactory.createEmptyBorder());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Color color = new Color(0, 190, 228);
        buttonContinue.setBorder(BorderFactory.createLineBorder(color, 1, true));
    }

    private void createUIComponents() {
        rootPanel22 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };
        textPaneJavaGram = new JTextPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logoMini, 0, 0, null);
            }
        };
        passwordField1 = new JPasswordField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconLock, 2, 15, null);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.setColor(Color.WHITE);
                g.drawLine(0, 55, 150, 55);
            }
        };
    }


//    public String getPasswordField1() {
//        String strCodeSms = passwordField1.toString();
//        return strCodeSms;
//    }
//
//    public void authChekedPhone() throws IOException {
//        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443", 502288, "3fdd8fdcc9fc8f2761065b45143473fe");
//        AuthCheckedPhone checkedPhone = bridge.authCheckPhone(getPasswordField1());
//        //System.out.println(checkedPhone.isRegistered());
//    }

    public void switcherAction(ActionListener actionListener) {
        buttonContinue.addActionListener(actionListener);
    }


    public JPanel getRootPanel2() {
        return rootPanel2;
    }

    public JPanel getRootPanel21() {
        return rootPanel21;
    }

    public JPanel getRootPanel22() {
        return rootPanel22;
    }


}


