package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

    private int width;
    private int height;

    public Frame(){
        width = 1080;
        height = 600;
        this.setSize(1080,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("TopGs get rich");
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(89,47,34));

        CommandTextfield commandTextfield = new CommandTextfield();
        this.add(commandTextfield);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
