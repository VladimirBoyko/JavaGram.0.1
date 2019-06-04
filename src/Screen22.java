import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//окно с завершением регистрации в Telegram и вводом своих контактных данных
public class Screen22 {
    private JTextPane textPaneJavaGram22;
    private JTextPane textPaneInvitation;
    private JTextField textFieldFirstName;
    private JTextField textFieldSecondName;
    private JButton buttonContinue;
    private JPanel rootPanel222;
    private JPanel rootPanel21;
    private JButton buttonHide;
    private JButton buttonClose;
    private JPanel rootPanel22;
    private BufferedImage iconLogo;
    private BufferedImage background;
    private BufferedImage iconClose;
    private BufferedImage iconHide;


    {
        StyledDocument doc = textPaneInvitation.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);


        try {
            background = ImageIO.read(new File("res/img/background.png"));
            iconLogo = ImageIO.read(new File("res/img/logo-mini.png"));
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
        buttonContinue.setBorder(BorderFactory.createLineBorder(color, 1, true));
    }

    public Screen22() {
        textFieldFirstName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textFieldFirstName.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                textFieldFirstName.setText("Имя");
            }
        });
        textFieldSecondName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textFieldSecondName.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                textFieldSecondName.setText("Фамилия");
            }
        });
    }

    private void createUIComponents() {
        rootPanel22 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };

        textPaneJavaGram22 = new JTextPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconLogo, 0, 0, null);
            }
        };
        textFieldFirstName = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.setColor(Color.WHITE);
                g.drawLine(0, 50, 250, 50);
                textFieldFirstName.setBorder(BorderFactory.createEmptyBorder());
            }
        };
        textFieldSecondName = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ((Graphics2D) g).setStroke(new BasicStroke(2.0f));
                g.setColor(Color.WHITE);
                g.drawLine(0, 60, 250, 60);
                textFieldSecondName.setBorder(BorderFactory.createEmptyBorder());
            }
        };
    }

    public void switcherAction(ActionListener actionListener) {
        buttonContinue.addActionListener(actionListener);
    }

    public JPanel getRootPanel222() {
        return rootPanel222;
    }
}
