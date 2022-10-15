package view;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    /**
     * Ein Bereich des Bildschirms wird eingeteilt, wo dann ein Label hinzugefügt wird
     * @param outputLabel um das Label im Panel zu erstellen
     * @param x
     * @param y für die Koordinaten
     */
    public OutputPanel(OutputLabel outputLabel, int x, int y){
        this.setBounds(x, y, 1000, 40);
        this.setBackground(new Color(34, 37, 41));
        this.add(outputLabel);
    }
}
