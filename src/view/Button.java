package view;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    /**
     * Der Button, den man drückt, um den command zu bestätigen, hier wird nur das Aussehen gesetzt
     */
    public Button() {
        this.setText("enter");
        this.setForeground(Color.white);
        this.setFont(new Font("Uni Sans", Font.PLAIN, 15));
        this.setBounds(550, 450, 100, 100);
        this.setBackground(Color.black);
    }
}
