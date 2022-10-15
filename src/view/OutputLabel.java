package view;import javax.swing.*;
import java.awt.*;

public class OutputLabel extends JLabel {
    /**
     * Das Label mit den Nachrichten für den Spieler
     * @param output für den Output, der auf dem Label zu sehen ist
     */
    public OutputLabel(String output){//Grunbau des Labels
        this.setForeground(Color.white);
        this.setBackground(Color.cyan);
        this.setFont(new Font("Uni Sans", Font.PLAIN, 13));
        this.setText(output);
    }
}
