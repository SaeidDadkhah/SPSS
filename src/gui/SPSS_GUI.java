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
        setLayout(new GridBagLayout());

        Dimension ss = getToolkit().getScreenSize();
        setSize(5 * (int) ss.getWidth() / 7, 5 * (int) ss.getHeight() / 7);
        setLocation((int) ss.getWidth() / 7, (int) ss.getHeight() / 7);
//        setResizable(false);

        init();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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

                g.drawImage((new ImageIcon("./Files/Header.png")).getImage(), 0, 0, (int) (getHeight() * 2.5), getHeight(), null);
//                System.out.println(getSize());
            }
        };
        lHeader.setPreferredSize(new Dimension(200, 80));
        getContentPane().add(lHeader, gbc);

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
        getContentPane().add(lHeaderColor, gbc);

        gbc.insets = new Insets(2, 20, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipady = 20;
        getContentPane().add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        getContentPane().add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        getContentPane().add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        getContentPane().add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        getContentPane().add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.ipadx = 0;
        getContentPane().add(new JLabel(), gbc);

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
        getContentPane().add(lBackground, gbc);
    }

}
