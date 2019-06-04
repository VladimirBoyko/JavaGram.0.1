import javax.swing.*;

/**Приложение является десктопной версией аналогом Telegram, использующий немного измененные его API.
 * Проект еще недописан, поэтому некоторые функции еще представляют собой муляж.
 */

public class Main {
    public static void main(String[] args) throws Exception{

        MyApplication application = new MyApplication();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //application.setUndecorated(true);
        application.setResizable(false);

        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
