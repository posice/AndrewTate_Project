package view;

import javax.swing.*;
import java.awt.*;

public class WinningFrame extends JFrame {

    private ImageIcon win;

    private JLabel winningLabel;

    public WinningFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLayout(new FlowLayout());

        win = new ImageIcon("Download.jfif");
        winningLabel = new JLabel(win);
        this.add(winningLabel);
        this.setVisible(true);
    }
}