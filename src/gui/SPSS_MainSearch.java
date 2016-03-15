package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-16 1:03 AM.
 * Project: SPSS
 */
public class SPSS_MainSearch extends JPanel {

    public SPSS_MainSearch(){
        setLayout(new GridBagLayout());

        init();
    }

    private void init(){
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        JLabel lLogo = new JLabel(){

            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawImage((new ImageIcon("./files/mainSearch.png")).getImage(), 0, 0, 200, 50, null);
            }
        };

        add(lLogo, gbc);
    }

}
