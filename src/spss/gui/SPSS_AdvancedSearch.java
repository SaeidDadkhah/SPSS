package spss.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-16 1:03 AM.
 * Project: SPSS
 */
public class SPSS_AdvancedSearch extends JPanel {

    public SPSS_AdvancedSearch(){
        setLayout(new GridBagLayout());

        init();
    }

    private void init(){
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

                g.drawImage((new ImageIcon("./Files/header.png")).getImage(), 0, 0, (int) (getHeight() * 2.5), getHeight(), null);
            }
        };
        lHeader.setPreferredSize(new Dimension(200, 80));
        add(lHeader, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;

        JLabel lHeaderColor = new JLabel(){

            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawImage((new ImageIcon("./Files/color.jpg")).getImage(), 0, 0, getWidth(), getHeight(), null);
            }

        };
        add(lHeaderColor, gbc);

        gbc.insets = new Insets(2, 20, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipady = 20;
        add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.ipadx = 0;
        add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4; // 4 + # of value
        gbc.gridheight = 2; // 1 + # of keys
        gbc.weightx = 1;
        gbc.weighty = 1;
        JLabel lBackground = new JLabel(){

            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawImage((new ImageIcon("./Files/background.jpg")).getImage(), 0, 0, getWidth(), getHeight(), null);
            }

        };
        add(lBackground, gbc);
    }


}
