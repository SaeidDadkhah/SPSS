package spss.gui.component;

import spss.gui.SPSS_Results;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Saeid Dadkhah on 2016-03-16 4:33 PM.
 * Project: SPSS
 */
public class Result extends JPanel {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 50;

    private SPSS_Results spss_results;
    private KeyListener kl;
    private String docAddress;
    private String body;

    public Result(SPSS_Results spss_results, KeyListener kl, String docAddress, String body) {
        this.spss_results = spss_results;
        this.docAddress = docAddress;
        this.body = body;
        this.kl = kl;

        init();
    }

    private void init() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(0xd70033));

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        JLabel lFile = new JLabel(docAddress.substring(docAddress.lastIndexOf('\\') + 1));
        Font font = lFile.getFont();
        lFile.setFont(font.deriveFont(Font.BOLD, (float) font.getSize() + 2));
        add(lFile, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JLabel(body.substring(0, 41)), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JLabel(body.substring(41)), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.ipadx = 36;
        gbc.ipady = 20;
        gbc.fill = GridBagConstraints.BOTH;
        JButton bOpen = new JButton() {
            @Override
            public void paint(Graphics g) {
//                super.paint(g);
                g.drawImage(new ImageIcon("./files/open.png").getImage(), 5, 5, 40, 40, null);
            }
        };
        bOpen.addActionListener(e -> spss_results.open(docAddress));
        bOpen.addKeyListener(kl);
        add(bOpen, gbc);
    }

}
