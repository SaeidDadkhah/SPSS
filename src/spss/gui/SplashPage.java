package spss.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-14 5:24 PM.
 * Project: SPSS
 */
public class SplashPage extends JFrame implements Runnable {

    private int size;

    public SplashPage(int size) {
        this.size = size;
        Thread thread = new Thread(this);
        thread.start();
    }

    // TODO: 2016-03-14 change icon
    @Override
    public void run() {
        setTitle("SPSS");
        setUndecorated(true);
        setLayout(null);

        setIconImage(new ImageIcon("./files/mainSearch.png").getImage());

        setResizable(false);
        setSize(size, size);
        Dimension ss = getToolkit().getScreenSize();
        setLocation((int) (ss.getWidth() - size) / 2 - 40, (int) (ss.getHeight() - size) / 2);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        Image logo = (new ImageIcon("./Files/splashPage.png")).getImage();
        g.drawImage(logo, 0, 0, size, size, null);
    }

    public void closeSP(){
        this.dispose();
    }

}
