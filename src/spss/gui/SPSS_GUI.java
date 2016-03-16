package spss.gui;

import org.apache.lucene.document.Document;
import spss.SPSS_Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-14 5:49 PM.
 * Project: SPSS
 */
public class SPSS_GUI extends JFrame {

    private SPSS_Interface spss_interface;

    public SPSS_GUI(SPSS_Interface spss_interface) {
        this.spss_interface = spss_interface;

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        }

        setTitle("SPSS");
        setLayout(null);

        Dimension ss = getToolkit().getScreenSize();
        setSize(5 * (int) ss.getWidth() / 7, 5 * (int) ss.getHeight() / 7);
        setLocation((int) ss.getWidth() / 7, (int) ss.getHeight() / 7);
//        setResizable(false);
        setIconImage(new ImageIcon("./files/mainSearch.png").getImage());

        spss_mainSearch = new SPSS_MainSearch(this);
        spss_mainSearch.setSize(getSize());
        spss_mainSearch.setPreferredSize(getSize());
        spss_mainSearch.setBackground(Color.WHITE);
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

    SPSS_MainSearch spss_mainSearch;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            spss_mainSearch.setSize(getSize());
        } catch (NullPointerException ignored) {
        }
    }

    public void search(String query){
        Document[] res = null;
        try {
//            res = spss_interface.search(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        res = new Document[3];
        new SPSS_Results(res);
    }

}
