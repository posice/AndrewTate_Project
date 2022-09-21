package view;

import javax.swing.*;
import java.awt.*;

public class OutputLabel extends JLabel {
    public OutputLabel(){
        this.setText("siu");
    }

    public void refresh(String text){
        this.setText(text);
        this.setVisible(false);
        this.setVisible(true);
    }
}
