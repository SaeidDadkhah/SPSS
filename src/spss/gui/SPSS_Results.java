package spss.gui;

import org.apache.lucene.document.Document;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-16 4:42 AM.
 * Project: SPSS
 */
public class SPSS_Results extends JDialog {

    private static final int BASE_HEIGHT = 200;

    private JPanel pMain;

    public SPSS_Results(Document[] results) {
        setModal(true);
        setTitle("SPSS: Result");
        setIconImage(new ImageIcon("./files/mainSearch.png").getImage());

        setLayout(new GridBagLayout());

        init();
        if (results.length == 0) // TODO: 2016-03-16 results should be checked with null or it's length with zero!
            noResult();
        else
            showResults(results);

        setVisible(true);
    }

    private void init() {
        Dimension ss = getToolkit().getScreenSize();
        int width = 3 * (int) ss.getWidth() / 5;
        int height = BASE_HEIGHT;
        setSize(width, height);
        setLocation((int) (ss.getWidth() - width) / 2, (int) (ss.getHeight() - height) / 2);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        JLabel lHeader = new JLabel() {

            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawImage((new ImageIcon("./Files/header.png")).getImage(),
                        0, 0, (int) (getHeight() * 2.5), getHeight(), null);
            }
        };
        lHeader.setPreferredSize(new Dimension(200, 80));
        getContentPane().add(lHeader, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        JLabel lHeaderColor = new JLabel() {

            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawImage((new ImageIcon("./Files/color.jpg")).getImage(), 0, 0, getWidth(), getHeight(), null);
            }

        };
        getContentPane().add(lHeaderColor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        pMain = new JPanel();
        pMain.setBackground(Color.WHITE);
        pMain.setLayout(new GridBagLayout());
        getContentPane().add(pMain, gbc);

        JLabel lBackground = new JLabel() {

            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawImage((new ImageIcon("./Files/background.jpg")).getImage(), 0, 0, getWidth(), getHeight(), null);
            }

        };
        getContentPane().add(lBackground, gbc);
    }

    private void noResult() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        pMain.add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        pMain.add(new JLabel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        JLabel lNoRes = new JLabel("Your search did not match any documents.");
        lNoRes.setFont(lNoRes.getFont().deriveFont((float) 18));
        pMain.add(lNoRes, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        pMain.add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        pMain.add(new JLabel(), gbc);
    }

    private void showResults(Document[] results) {
    }
}
