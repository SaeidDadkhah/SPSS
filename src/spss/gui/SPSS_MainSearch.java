package spss.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Saeid Dadkhah on 2016-03-16 1:03 AM.
 * Project: SPSS
 */
public class SPSS_MainSearch extends JPanel {

    private static final int MID_SIZE = 350;

    private SPSS_GUI spss_gui;

    private JTextField tFQuery;
    private JButton bSearch;

    public SPSS_MainSearch(SPSS_GUI spss_gui) {
        this.spss_gui = spss_gui;
        setLayout(new GridBagLayout());
        init();
    }

    private void init() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel pTop = new JPanel();
        pTop.setBackground(Color.WHITE);
        initPTop(pTop);
        add(pTop, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0;
        JPanel pMiddle = new JPanel();
        pMiddle.setBackground(Color.WHITE);
        initPMiddle(pMiddle);
        add(pMiddle, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.7;
        JPanel pDown = new JPanel();
        pDown.setBackground(Color.WHITE);
        initPDown(pDown);
        add(pDown, gbc);
    }

    private void initPTop(JPanel pTop) {
        pTop.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        pTop.add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        pTop.add(new JLabel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0, 0, 40, 0);
        JLabel lLogo = new JLabel() {

            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawImage((new ImageIcon("./files/mainSearch.png")).getImage(), 0, 0, MID_SIZE, (int) (MID_SIZE * 0.3385), null);
            }
        };
        lLogo.setPreferredSize(new Dimension(MID_SIZE, (int) (MID_SIZE * 0.3385)));
        pTop.add(lLogo, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        pTop.add(new JLabel(), gbc);
    }

    private void initPMiddle(JPanel pMiddle) {
        pMiddle.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.3;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        pMiddle.add(new JLabel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.4;
        gbc.weighty = 0;
        gbc.ipadx = MID_SIZE;
        gbc.ipady = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        tFQuery = new JTextField();
        Font font = tFQuery.getFont().deriveFont((float) 20);
        tFQuery.setFont(font);
        tFQuery.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    bSearch.doClick();
            }
        });
        pMiddle.add(tFQuery, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.3;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        pMiddle.add(new JLabel(), gbc);
    }

    private void initPDown(JPanel pDown) {
        pDown.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Color bColor = new Color(117, 120, 136);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        pDown.add(new JLabel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(0, 0, 0, 5);
        bSearch = new JButton("SPSearchS");
        Font font = bSearch.getFont().deriveFont((float) 20);
        bSearch.setFont(font);
        bSearch.setForeground(bColor);
        pDown.add(bSearch, gbc);
        bSearch.addActionListener(e -> spss_gui.search(tFQuery.getText()));

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(0, 5, 0, 0);
        JButton bAdvancedSearch = new JButton("Advanced SPSS");
        bAdvancedSearch.setFont(font);
        bAdvancedSearch.setForeground(bColor);
        pDown.add(bAdvancedSearch, gbc);
        bAdvancedSearch.addActionListener(e -> spss_gui.turnToAdvanced());

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        pDown.add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        pDown.add(new JLabel(), gbc);
    }

}
