package spss.gui;

import org.apache.lucene.document.Document;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Saeid Dadkhah on 2016-03-16 4:42 AM.
 * Project: SPSS
 */
public class SPSS_Results extends JDialog {
    public SPSS_Results(Document[] results) {
        setModal(true);
        setLayout(new GridBagLayout());

        init(results);

        setVisible(true);
    }

    private void init(Document[] results) {
    }
}
