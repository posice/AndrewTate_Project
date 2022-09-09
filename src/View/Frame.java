package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

    public Frame(){
        this.setSize(1080,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("TopGs get rich");
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(89,47,34));

        ImageIcon imageIcon = new ImageIcon("TATE.webp");
        this.setIconImage(imageIcon.getImage());

        CommandTextfield commandTextfield = new CommandTextfield();
        commandTextfield.addKeyListener(this);
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
