package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-14 5:49 PM.
 * Project: SPSS
 */
public class SPSS_GUI extends JFrame {

    private static final Color baseColor = new Color(215, 0, 51);

    public SPSS_GUI() {
        setLayout(null);

        Dimension ss = getToolkit().getScreenSize();
        setSize(5 * (int) ss.getWidth() / 7, 5 * (int) ss.getHeight() / 7);
        setLocation((int) ss.getWidth() / 7, (int) ss.getHeight() / 7);
//        setResizable(false);

        SPSS_MainSearch spss_mainSearch = new SPSS_MainSearch();
        spss_mainSearch.setSize(getSize());
        spss_mainSearch.setLocation(0, 0);
        getContentPane().add(spss_mainSearch);

//        SPSS_AdvancedSearch spss_advancedSearch = new SPSS_AdvancedSearch();
//        spss_advancedSearch.setSize(getSize());
//        spss_advancedSearch.setLocation(0, 0);
//        getContentPane().add(spss_advancedSearch);

//        init();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
