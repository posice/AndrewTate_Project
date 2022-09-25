package view;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    public OutputPanel(OutputLabel outputLabel, int x, int y){//erstellt ein label wenn aufgerufen, an den gegebenen koordinaten
        this.setBounds(x, y, 450, 40);
        this.setBackground(new Color(34, 37, 41));
        this.add(outputLabel);
    }
}
