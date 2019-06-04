import javax.swing.*;
import java.awt.*;
//Создаем ячейку списка контакта
public class MyListCellRendererComponent implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel renderer = (JPanel) value;

        if (isSelected) {
            renderer.setBackground(new Color(250, 250, 250));
            renderer.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, new Color(0, 190, 228)));


        } else {
            renderer.setBackground(new Color(230, 230, 230));
            renderer.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(100, 100, 100)));

        }
        return renderer;
    }
}
