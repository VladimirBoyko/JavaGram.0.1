import org.javagram.response.AuthSentCode;

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

//Первое окно с вводом номера телефона
public class Screen1 extends JPanel {
    private JPanel rootPanel1;
    private JButton buttonHide;
    private JButton buttonExit;
    private JPanel rootPanel11;
    private JTextArea textArea1;
    private JTextPane textPaneJavaGram;
    private JTextPane textPaneImmutable;
    private JButton buttonContinue;
    private JPanel rootPanel12;
    private JTextPane textPaneNumberPhone;
    private AuthSentCode sendCode;
    private BufferedImage background;
    private BufferedImage logo;
    private BufferedImage iconPhone;
    private BufferedImage iconClose;
    private BufferedImage iconHide;
    private BufferedImage buttonBackground;


    {
        StyledDocument doc = textPaneImmutable.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

//загрузка иконок для контента
        try {
            background = ImageIO.read(new File("res/img/background.png"));
            logo = ImageIO.read(new File("res/img/logo.png"));
            iconPhone = ImageIO.read(new File("res/img/icon-phone.png"));
            iconClose = ImageIO.read(new File("res/img/icon-close.png"));
            buttonExit.setIcon(new ImageIcon(iconClose));
            buttonExit.setBorder(BorderFactory.createEmptyBorder());
            iconHide = ImageIO.read(new File("res/img/icon-hide.png"));
            buttonHide.setIcon(new ImageIcon(iconHide));
            buttonHide.setBorder(BorderFactory.createEmptyBorder());
            buttonBackground = ImageIO.read(new File("res/img/button-background.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createUIComponents() {
        rootPanel12 = new JPanel() {
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
                g.drawImage(logo, 0, 0, null);
            }
        };
        textPaneNumberPhone = new JTextPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconPhone, 0, 12, null);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.setColor(Color.WHITE);
                g.drawLine(0, 55, 300, 55);
            }
        };

    }

//При конечном варианте приложения здесь будет проходить аутенфикация номера телефона
    //    public String getTextFieldInputNumberPhone() {
//        String strNumberPhone =  textFieldInputNumberPhone.getText().trim();
//        strNumberPhone = strNumberPhone.replaceAll("\\D+", "");
//        return strNumberPhone;
//    }
//    public void authSentCode () throws IOException {
//        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443", 502288, "3fdd8fdcc9fc8f2761065b45143473fe");
//        sendCode = bridge.authSendCode(getTextFieldInputNumberPhone());
//
//    }
    public void switcherAction(ActionListener actionListener) {
        buttonContinue.addActionListener(actionListener);
    }


    public JPanel getRootPanel1() {
        return rootPanel1;
    }

    public JPanel getRootPanel11() {
        return rootPanel11;
    }

    public JPanel getRootPanel12() {
        return rootPanel12;
    }

}
