package spss.gui;

import spss.SPSS_Fields;
import spss.gui.component.Key;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Saeid Dadkhah on 2016-03-16 1:03 AM.
 * Project: SPSS
 */
public class SPSS_AdvancedSearch extends JPanel {

    private static final int MAX_ROW = 14;
    private static final int MAX_COL = 5;

    private SPSS_GUI spss_gui;

    private ArrayList<ArrayList<JTextField>> values;
    private ArrayList<Key> keys;
    private JButton bSearch;
    private JPanel pAtt;

    public SPSS_AdvancedSearch(SPSS_GUI spss_gui) {
        this.spss_gui = spss_gui;

        values = new ArrayList<>();
        keys = new ArrayList<>();

        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        init();

        addValue(1, 1);
    }

    private void init() {
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
        JLabel lHeaderColor = new JLabel() {

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
        pAtt = new JPanel();
        initAttPanel(pAtt);
        add(pAtt, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        bSearch = new JButton("SPSearchS");
        add(bSearch, gbc);
        bSearch.addActionListener(e -> {
            try {
                if (keys.size() == 1) {
                    // TODO: 2016-03-30 show error message
                } else if (keys.size() == 2) {
                    spss_gui.search(keyInfo(0));
                } else {
                    String query = "(" + keyInfo(0) + ")";
                    for (int i = 1; i < keys.size() - 1; i++)
                        query += ", (" + keyInfo(i) + ")";
                    spss_gui.search(query);
                }
            } catch (Exception exc) {
                // TODO: 2016-03-30 show error message
                if (!exc.getMessage().equals("Illegal key"))
                    try {
                        throw exc;
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                else {

                }
            }
        });

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

    private void initAttPanel(JPanel pAtt) {
        GridBagConstraints gbc = new GridBagConstraints();
        pAtt.setLayout(new GridBagLayout());

        pAtt.setBackground(Color.BLACK);
        pAtt.setBackground(Color.WHITE);

        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < 6; i++) {
            gbc.gridx = i;
            pAtt.add(new JButton(), gbc);
        }

        gbc.gridx = 1;
        gbc.gridy = 15;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.ipadx = 0;
        pAtt.add(new JLabel(), gbc);
    }

    /* (1, 1)              (1, 2)           ... (1, MAX_COL -1)
    *  (2, 1)              (2, 2)           ... (2, MAX_COL -1)
    *     .                   .                          .
    *     .                   .                          .
    *     .                   .                          .
    *  (MAX_ROW - 1, 1)    (MAX_ROW - 1, 2) ... (MAX_ROW - 1, MAX_COL -1)
    * */
    private void addValue(int row, int col) {
        if (col == 0 || col > MAX_COL)
            return;
        if (col == 1)
            if (!addKey(row))
                return;

        JTextField value = new JTextField();
        values.get(row - 1).add(value);
        value.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (col >= values.get(row - 1).size())
                    addValue(row, col + 1);
                if (row >= values.size())
                    addValue(row + 1, 1);
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    bSearch.doClick();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.BOTH;
        pAtt.add(value, gbc);
        spss_gui.dispatchEvent(new ActionEvent(this, ActionEvent.RESERVED_ID_MAX + 1, null));
    }

    private boolean addKey(int row) {
        if (row == 0 || row > MAX_ROW)
            return false;

        Key key = new Key();
        keys.add(key);
        values.add(new ArrayList<>());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.BOTH;
        pAtt.add(key, gbc);

        return true;
    }

    private String keyInfo(int keyNum) throws Exception {
        String key = keys.get(keyNum).getText();

        if (SPSS_Fields.getId(key) == -1)
            throw new Exception("Illegal key");

        if (values.get(keyNum).size() == 1)
            return null;
        else if (values.get(keyNum).size() == 2)
            return key + '\"' + values.get(keyNum).get(0).getText().trim() + '\"';
        else {
            String res = key + '\"' + values.get(keyNum).get(0).getText().trim() + '\"';
            for (int i = 1; i < values.get(keyNum).size() - 1; i++)
                res += " or " + key + '\"' + values.get(keyNum).get(i).getText().trim() + '\"';
            return res;
        }
    }

}
