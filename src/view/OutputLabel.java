package view;

import javax.swing.*;
import java.awt.*;

public class OutputLabel extends JLabel {
    public OutputLabel(){
        this.setBackground(Color.green);
        this.setForeground(Color.cyan);
        this.setFont(new Font("Uni Sans", Font.PLAIN, 13));
        this.setText("siu");
    }

    public void refresh(String text){
        this.setText(text);
        this.setVisible(false);
        this.setVisible(true);
    }
}
