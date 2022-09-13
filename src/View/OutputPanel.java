package View;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    public OutputPanel(){
        this.setBounds(0,0,400,200);
        this.setBackground(Color.black);
        OutputLabel outputLabel = new OutputLabel();
        this.add(outputLabel);
    }
}
