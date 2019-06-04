import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyApplication extends JFrame {
    private Screen1 screen1 = new Screen1();
    private Screen2 screen2 = new Screen2();
    private Screen3 screen3 = new Screen3();
    private Screen22 screen22 = new Screen22();
    private Screen4 profileSetting = new Screen4();
    private Screen5 addContactForm = new Screen5();
    private Screen6 contactEditForm = new Screen6();

    private ButtonPlusContact buttonPlusContact = new ButtonPlusContact();
    private ContactListForm contactListForm = new ContactListForm();
    private BackGround backGround = new BackGround();

    private JLayeredPane mLayeredPane;
    private JLayeredPane layeredPaneContacts;

    {
        setMyLayeredPane();


        setContentPane(screen1.getRootPanel1());
        setSize(800, 600);

        // переключатели окон и переходы на всплывающие окна
        screen1.switcherAction(e -> switchScreen1());
        screen2.switcherAction(e -> switchScreen2());
        screen22.switcherAction(e -> switchOnMainForm());

        screen3.editContactProfile(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mLayeredPane.setLayer(contactEditForm.getRootPanelScreen6(), 5);
                mLayeredPane.setLayer(backGround.getRootPanelBackGround(), 4);
                mLayeredPane.setLayer(screen3.getRootPanel3(), 3);
                mLayeredPane.setLayer(addContactForm.getRootPanelScreen5(), 2);
                mLayeredPane.setLayer(profileSetting.getRootPanelScreen4(), 1);
            }
        });

        screen3.openSettingProfile(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mLayeredPane.setLayer(contactEditForm.getRootPanelScreen6(), 2);
                mLayeredPane.setLayer(backGround.getRootPanelBackGround(), 4);
                mLayeredPane.setLayer(screen3.getRootPanel3(), 3);
                mLayeredPane.setLayer(addContactForm.getRootPanelScreen5(), 1);
                mLayeredPane.setLayer(profileSetting.getRootPanelScreen4(), 5);

            }
        });
        buttonPlusContact.openEnterAddContact(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mLayeredPane.setLayer(contactEditForm.getRootPanelScreen6(), 1);
                mLayeredPane.setLayer(backGround.getRootPanelBackGround(), 4);
                mLayeredPane.setLayer(screen3.getRootPanel3(), 3);
                mLayeredPane.setLayer(addContactForm.getRootPanelScreen5(), 5);
                mLayeredPane.setLayer(profileSetting.getRootPanelScreen4(), 2);
            }
        });
        profileSetting.switcherExitFromSettingProfile(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchBackOnMainForm();
            }
        });
        addContactForm.switcherExitFromAddContact(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchBackOnMainForm();
            }

        });
        contactEditForm.switcherExitFromAddContact(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchBackOnMainForm();
            }
        });

        screen3.addSendMessageActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = screen3.getEnterYourMessageTextFiald().getText();
                screen3.getEnterYourMessageTextFiald().setText("");
                if (!message.isEmpty()) {
                    //Здесь отправим сообщение на сервер

                    MyMessageRenderer myMs = new MyMessageRenderer();
                    myMs.getTextPane().setText(message);
                    screen3.getRootPanelWithMessage().add(myMs);
                    screen3.getScrollPanel().getViewport().setViewPosition(new Point(
                            0, screen3.getScrollPanel().getVerticalScrollBar().getMaximum()));
                }
            }
        });


        //вывод диалога с пользователем
        contactListForm.getContactList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                screen3.getMessage();
            }
        });
    }

    //кнопки возврата на Screen3 с прозрачных подменю
    public void switchBackOnMainForm() {
        mLayeredPane.setLayer(contactEditForm.getRootPanelScreen6(), 1);
        mLayeredPane.setLayer(backGround.getRootPanelBackGround(), 4);
        mLayeredPane.setLayer(screen3.getRootPanel3(), 5);
        mLayeredPane.setLayer(addContactForm.getRootPanelScreen5(), 3);
        mLayeredPane.setLayer(profileSetting.getRootPanelScreen4(), 2);
    }

    // главный метод запускающий JLayeredPane
    public void setMyLayeredPane() {
        mLayeredPane = new MyLayeredPane();
        mLayeredPane.add(screen3.getRootPanel3(), 5, -1);
        mLayeredPane.add(profileSetting.getRootPanelScreen4(), 4, -1);
        mLayeredPane.add(addContactForm.getRootPanelScreen5(), 3, -1);
        mLayeredPane.add(contactEditForm.getRootPanelScreen6(), 2, -1);
        mLayeredPane.add(backGround.getRootPanelBackGround(), 1, -1);

        mLayeredPane.setVisible(true);

        layeredPaneContacts = new MyLayeredPane();
        layeredPaneContacts.add(buttonPlusContact.getRootPanelButton(), 2, -1);
        layeredPaneContacts.add(contactListForm.getRootContactListForm(), 1, -1);
        screen3.getRootPanelContactListForm().add(layeredPaneContacts, BorderLayout.CENTER);
    }

    public void switchScreen1() {
        screen1.getRootPanel11();
//        try {
//            screen1.authSentCode();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        screen2.setJlabelWithNumberPhone(screen1.getTextFieldInputNumberPhone());
        setContainerPlane(screen2.getRootPanel2());
    }

    public void switchScreen2() {
//        screen2.getRootPanel2();
//        try {
//            screen2.authChekedPhone();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        screen3.getContactsUsers();
        setContainerPlane(screen22.getRootPanel222());
    }

    public void switchOnMainForm() {

        setContainerPlane(mLayeredPane);
        mLayeredPane.revalidate();
        mLayeredPane.repaint();
    }

    public void setContainerPlane(Container container) {
        setContentPane(container);
        getContentPane().revalidate();
        getContentPane().repaint();

    }


}
