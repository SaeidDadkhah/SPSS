package spss.gui;

import org.apache.lucene.document.Document;
import spss.SPSS_Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Saeid Dadkhah on 2016-03-14 5:49 PM.
 * Project: SPSS
 */
public class SPSS_GUI extends JFrame {

    private SPSS_Interface spss_interface;
    private SPSS_MainSearch spss_mainSearch;
    private SPSS_AdvancedSearch spss_advancedSearch;

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

        setTitle("SPSS®");
        setLayout(null);

        Dimension ss = getToolkit().getScreenSize();
        setSize(5 * (int) ss.getWidth() / 7, 5 * (int) ss.getHeight() / 7);
        setLocation((int) ss.getWidth() / 7, (int) ss.getHeight() / 7);
        setResizable(false);
        setIconImage(new ImageIcon("./files/mainSearch.png").getImage());

        turnToMain(false);
        turnToAdvanced();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            spss_mainSearch.setSize(getSize());
        } catch (NullPointerException ignored) {
        }
    }

    public void search(String query) {
        Document[] res = null;
        try {
            res = spss_interface.search(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new SPSS_Results(res);
    }

    public void turnToMain(boolean remove) {
        if (remove)
            getContentPane().remove(spss_advancedSearch);
        spss_mainSearch = new SPSS_MainSearch(this);
        spss_mainSearch.setSize(getSize());
        spss_mainSearch.setPreferredSize(getSize());
        spss_mainSearch.setBackground(Color.WHITE);
        spss_mainSearch.setLocation(0, 0);
        getContentPane().add(spss_mainSearch);
        this.dispatchEvent(new ActionEvent(this, ActionEvent.RESERVED_ID_MAX + 1, null));
    }

    public void turnToAdvanced() {
        getContentPane().remove(spss_mainSearch);
        spss_advancedSearch = new SPSS_AdvancedSearch(this);
        spss_advancedSearch.setSize((int) getSize().getWidth() - 6, (int) getSize().getHeight() - 28);
        spss_advancedSearch.setLocation(0, 0);
        getContentPane().add(spss_advancedSearch);
        this.dispatchEvent(new ActionEvent(this, ActionEvent.RESERVED_ID_MAX + 1, null));
    }

    @Override
    protected void processEvent(AWTEvent e) {
        super.processEvent(e);
        switch (e.getID()) {
            case ActionEvent.RESERVED_ID_MAX + 1:
                setSize(getWidth(), getHeight() - 1);
                setSize(getWidth(), getHeight() + 1);
                repaint();
        }
    }
}
