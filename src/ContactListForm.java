import javax.swing.*;

//здесь пока происходит генерация списа контактов, далее они будут заполняться реальными
public class ContactListForm {
    private JPanel rootContactListForm;
    private JList contactList;
    private JScrollPane ScrollListPane;

    {
        DefaultListModel defModel = new DefaultListModel();
        for (String itemName: getArrayContacts()){
            defModel.addElement(new ContactRenderer(itemName.toString(),
                    "Текст сообщения", new ImageIcon("res/img/mask-gray-online.png")).getRootPanelContactForm());

        }

        getContactList().setCellRenderer(new MyListCellRendererComponent());
        getContactList().setModel(defModel);

    }


    public String [] getArrayContacts (){
        return new String[] {"Ivan Orlov", "Fedor Emelyanenko", "Vasya Kozlov", "Petya Ivanov", "Masha Buynova", "Misha Samoilov",
        "Sergey Frolov", "Anton Loshmanov"};
    }

    public JList getContactList() {
        return contactList;
    }

    public JPanel getRootContactListForm() {
        return rootContactListForm;
    }
}
