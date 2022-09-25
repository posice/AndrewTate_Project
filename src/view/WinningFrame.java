package view;

import javax.swing.*;
import java.awt.*;

public class WinningFrame extends JFrame {


    public WinningFrame(){
        ImageIcon win = new ImageIcon("src/view/Download.png");//Man instanziiert ein Bild

        JLabel winningLabel = new JLabel();
        winningLabel.setIcon(win);//Das Bild wird zum Label hinzugefügt

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(322,197);
        this.setResizable(false);
        this.setVisible(true);
        this.add(winningLabel);
    }
}