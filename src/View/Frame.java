package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

    private int width;
    private int height;
    private CommandTextfield commandTextfield;

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

        commandTextfield = new CommandTextfield();
        commandTextfield.addKeyListener(this);
        this.add(commandTextfield);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println(commandTextfield.getText());
            commandTextfield.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
