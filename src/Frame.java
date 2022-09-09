import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(){
        this.setSize(1080,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("TopGs get rich");
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(89,47,34));
    }
}
