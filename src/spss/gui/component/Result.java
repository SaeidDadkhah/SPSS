package spss.gui.component;

import spss.gui.SPSS_Results;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-16 4:33 PM.
 * Project: SPSS
 */
public class Result extends JPanel {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 50;

    private SPSS_Results spss_results;
    private String docAddress;
    private String body;

    public Result(SPSS_Results spss_results, String docAddress, String body) {
        this.spss_results = spss_results;
        this.docAddress = docAddress;
        this.body = body;

        init();
    }

    private void init() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.CYAN);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        JLabel lFile = new JLabel(docAddress.substring(docAddress.lastIndexOf('/') + 1));
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
        add(new JLabel(body), gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
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
                System.out.println(getSize());
            }
        };
        bOpen.setPreferredSize(new Dimension(HEIGHT, HEIGHT));
        bOpen.setSize(HEIGHT, HEIGHT);
        add(bOpen, gbc);
    }

}
