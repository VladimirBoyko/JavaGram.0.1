import javax.swing.*;

//Формат одгого контакта в списке контактов
public class ContactRenderer {
    private JPanel rootPanelContactForm;
    private JPanel rootPanelContact;
    private JTextField textFieldTextMessage;
    private JTextField textFieldFullName;
    private JLabel dataLabel;
    private JLabel labelPhoto;


    public ContactRenderer(String name, String textMessage, Icon label) {
        textFieldFullName.setText(name);
        textFieldTextMessage.setText(textMessage);
        labelPhoto.setIcon(label);

        textFieldFullName.setBorder(BorderFactory.createEmptyBorder());
        textFieldTextMessage.setBorder(BorderFactory.createEmptyBorder());
    }

    public JPanel getRootPanelContactForm() {
        return rootPanelContactForm;
    }

}