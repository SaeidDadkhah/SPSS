package spss.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-16 1:03 AM.
 * Project: SPSS
 */
public class SPSS_AdvancedSearch extends JPanel {

    private SPSS_GUI spss_gui;

    public SPSS_AdvancedSearch(SPSS_GUI spss_gui){
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        this.spss_gui = spss_gui;

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
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        JLabel lHeaderColor = new JLabel(){

            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawImage((new ImageIcon("./Files/color.png")).getImage(), 0, 0, getWidth(), getHeight(), null);
            }

        };
        add(lHeaderColor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        JPanel pAtt = new JPanel();
        initAttPanel(pAtt);
        add(pAtt, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(new JButton("SPSearchS"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        JButton bMainSearch = new JButton("Main SPSS");
        add(bMainSearch, gbc);
        bMainSearch.addActionListener(e -> spss_gui.turnToMain(true));
    }

    private void initAttPanel(JPanel pAtt){
        GridBagConstraints gbc = new GridBagConstraints();
        pAtt.setLayout(new GridBagLayout());

        pAtt.setBackground(Color.BLACK);
        pAtt.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.ipadx = 10;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        pAtt.add(new JLabel(), gbc);

        gbc.gridy = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        for(int i = 0; i < 6; i++){
            gbc.gridx = i + 1;
            pAtt.add(new JLabel(), gbc);
        }

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        for(int i = 0; i< 13; i++){ // 14
            gbc.gridy = 2 + i;
            pAtt.add(new JTextField(), gbc);
        }

        gbc.gridx = 1;
        gbc.gridy = 16;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.ipadx = 0;
        pAtt.add(new JLabel(), gbc);
    }

}
