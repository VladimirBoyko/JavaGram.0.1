import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
//задний фон у приложения для полупрозрачных окон
public class BackGround extends JPanel{
    private JPanel rootPanelBackGround;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanelBackGround = this;
        addMouseListener( new MouseAdapter() {} );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        // 50% transparent Alpha
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.90f));

        g2d.setColor(Color.BLACK);
        g2d.fillRect( 0, 0, getWidth(), getHeight() );

        g2d.dispose();

    }

    public JPanel getRootPanelBackGround() {
        return rootPanelBackGround;
    }
}
