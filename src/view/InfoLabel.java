package view;

import javax.swing.*;

public class InfoLabel extends JLabel {

    public InfoLabel(){
    }

    public void refresh(String text){
        this.setText(text);
        this.setVisible(false);
        this.setVisible(true);
    }
}