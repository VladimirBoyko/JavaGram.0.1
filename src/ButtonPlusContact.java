import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Кнопка "Add contact" на слой выше списка контактов
public class ButtonPlusContact {
    private JPanel rootPanel36;
    private JButton buttonAddContact;
    private JPanel rootPanelButton;
    private BufferedImage iconPlus;


    {
        try {
            iconPlus = ImageIO.read(new File("res/img/icon-plus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonAddContact.setIcon(new ImageIcon(iconPlus));
        buttonAddContact.setBorder(BorderFactory.createEmptyBorder());

    }

    public void openEnterAddContact(ActionListener actionListener) {
        buttonAddContact.addActionListener(actionListener);
    }



    public JButton getButtonAddContact() {
        return buttonAddContact;
    }

    public JPanel getRootPanelButton() {
        return rootPanelButton;
    }
}
