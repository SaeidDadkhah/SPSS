package spss.gui.component;

import spss.SPSS_Fields;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Saeid Dadkhah on 2016-03-30 3:09 AM.
 * Project: SPSS
 */
public class Key extends JComboBox<String> {

    public Key() {
        setEditable(true);

        Key.this.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                updateItems();
            }
        });

        updateItems();
    }

    private void updateItems() {
        String typed = getText();
        Key.this.removeAllItems();
        Key.this.addItem(typed);

        for (int i = 0; i < SPSS_Fields.NUM_OF_FIELDS; i++) {
            String str = SPSS_Fields.getName(i);
            if (str != null && str.startsWith(typed)) {
                Key.this.addItem(SPSS_Fields.getName(i));
            }
        }
    }

    public String getText(){
        return ((JTextComponent) getEditor().getEditorComponent()).getText();
    }

}
