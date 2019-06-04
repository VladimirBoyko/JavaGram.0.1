import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.BoxLayout.Y_AXIS;

public class Screen3 extends JPanel {
    private JPanel rootPanel3;
    private JButton buttonHide;
    private JButton buttonClose;
    private JPanel rootPanel31;
    private JPanel rootPanel32;
    private JPanel rootPanel33;
    private JButton buttonSetting;
    private JPanel rootPanel34;
    private JButton buttonAddContact;
    private JPanel rootPanelContactListForm;
    private JPanel rootPanel37;
    private JPanel rootPanel38;
    private JButton buttonOpenEditContact;
    private JPanel rootPane39;
    private JTextArea enterYourMessageTextFiald;
    private JButton buttonSendMessage;
    private JTextField textFieldSearch;
    private JLabel labelLogoMicro;
    private JLabel labelPhoto;
    private JPanel rootPanelWithPhotoAndLabel;
    private JLabel labelWithName;
    private JPanel rootPanelWithSearch;
    private JLabel labelSearch;
    private JLabel jLabelWithName;
    private JLabel labelUsers;
    private JPanel rootPanelWithMessage;
    private JScrollPane scrollPanel;
    private JScrollPane scrollContactPane;
    private BufferedImage iconClose;
    private BufferedImage iconHide;
    private BufferedImage iconSetting;
    private BufferedImage iconEdit;
    private BufferedImage buttonSend;
    private BufferedImage iconSearch;
    private BufferedImage logoMicro;
    private BufferedImage logoVinni;
    private BufferedImage iconVinni;
    private BufferedImage logoSova;
    private BufferedImage iconSova;
    private String fullName;

    {
        //Загрука картинок и иконок в скрин
        try {
            iconClose = ImageIO.read(new File("res/img/icon-close.png"));
            iconHide = ImageIO.read(new File("res/img/icon-hide.png"));
            iconSetting = ImageIO.read(new File("res/img/icon-settings.png"));
            iconEdit = ImageIO.read(new File("res/img/icon-edit.png"));
            buttonSend = ImageIO.read(new File("res/img/button-send.png"));
            iconSearch = ImageIO.read(new File("res/img/icon-search.png"));
            logoMicro = ImageIO.read(new File("res/img/logo-micro.png"));
            logoVinni = ImageIO.read(new File("res/img/logo-vinni.png"));
            iconVinni = ImageIO.read(new File("res/img/icon-vinni.png"));
            logoSova = ImageIO.read(new File("res/img/logo-sova.png"));
            iconSova = ImageIO.read(new File("res/img/icon-sova.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonClose.setIcon(new ImageIcon(iconClose));
        buttonClose.setBorder(BorderFactory.createEmptyBorder());

        buttonHide.setIcon(new ImageIcon(iconHide));
        buttonHide.setBorder(BorderFactory.createEmptyBorder());

        buttonSetting.setIcon(new ImageIcon(iconSetting));
        buttonSetting.setBorder(BorderFactory.createEmptyBorder());

        buttonOpenEditContact.setIcon(new ImageIcon(iconEdit));
        buttonOpenEditContact.setBorder(BorderFactory.createEmptyBorder());

        buttonSendMessage.setIcon(new ImageIcon(buttonSend));
        buttonSendMessage.setBorder(BorderFactory.createEmptyBorder());

        textFieldSearch.setBorder(BorderFactory.createEmptyBorder());

        labelUsers.setIcon(new ImageIcon("res/img/mask-white-mini.png"));

    }

    // метод выводящий сообщения
    public void getMessage() {
        getRootPanelWithMessage().removeAll();
        getRootPanelWithMessage().setLayout(new BoxLayout(getRootPanelWithMessage(), BoxLayout.Y_AXIS));

        //добавляем пустую панель, для смещения сообщений вниз
        JPanel panel = new JPanel();
        panel.setSize(200, 60);
        getRootPanelWithMessage().add(panel);

        UserMessageForm userForm = new UserMessageForm();
        userForm.getTextPane().setText("Погода класс!");
        getRootPanelWithMessage().add(userForm.getRootPanelMessage());

        MyMessageRenderer myRenderer = new MyMessageRenderer();
        myRenderer.getTextPane().setText("first");
        getRootPanelWithMessage().add(myRenderer.getRootPanel());


        scrollPanel.getVerticalScrollBar().setValue(scrollPanel.getVerticalScrollBar().getMaximum());
        rootPanelWithMessage.repaint();
        rootPanelWithMessage.revalidate();
    }

    @Override
    public String toString() {
        return fullName;
    }

    //помещаем фокус в окна, чтобы при вводе текста надпись стиралась
    public Screen3() {
        getRootPanelContactListForm().setLayout(new BoxLayout(getRootPanelContactListForm(), Y_AXIS));
        textFieldSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textFieldSearch.setText("");
            }
        });
        textFieldSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                textFieldSearch.setText("Поиск");
            }
        });
        enterYourMessageTextFiald.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                enterYourMessageTextFiald.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                enterYourMessageTextFiald.setText("Enter your message...");
            }
        });
    }

    public JPanel getRootPanel3() {
        return rootPanel3;
    }

    public JPanel getRootPanelContactListForm() {
        return rootPanelContactListForm;
    }

    //помещаем иконки в экране на место
    private void createUIComponents() {
        labelLogoMicro = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logoMicro, 10, 7, null);
            }
        };
        labelPhoto = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconVinni, 0, 0, null);
            }
        };
        labelSearch = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconSearch, 0, 3, null);
            }
        };
    }

    //прикркпляем слушатели к кнопкам
    public void openSettingProfile(ActionListener actionListener) {
        buttonSetting.addActionListener(actionListener);
    }

    public void editContactProfile(ActionListener actionListener) {
        buttonOpenEditContact.addActionListener(actionListener);
    }

    public void addSendMessageActionListener(ActionListener actionListener) {
        buttonSendMessage.addActionListener(actionListener);
        enterYourMessageTextFiald.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) buttonSendMessage.doClick();
            }
        });
    }

    public JPanel getRootPanelWithMessage() {
        return rootPanelWithMessage;
    }

    public JTextArea getEnterYourMessageTextFiald() {
        return enterYourMessageTextFiald;
    }

    public JScrollPane getScrollPanel() {
        return scrollPanel;
    }
}
