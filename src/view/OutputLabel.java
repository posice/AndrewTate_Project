package view;import javax.swing.*;
import java.awt.*;

public class OutputLabel extends JLabel {
    public OutputLabel(String output){
        this.setForeground(Color.white);
        this.setBackground(Color.cyan);
        this.setFont(new Font("Uni Sans", Font.PLAIN, 13));
        this.setText(output);
    }
}
