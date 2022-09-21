package view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    private int width;
    private int height;
    private CommandTextfield commandTextfield;
    private OutputLabel outputLabel;

    public Frame(){
        OutputLabel label = new OutputLabel();
        this.setSize(1080,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("TopGs get rich");
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(89,47,34));

        commandTextfield = new CommandTextfield();
        this.setVisible(true);
        this.add(label);
        this.add(commandTextfield);
    }

    public CommandTextfield getCommandTextfield(){
        return commandTextfield;
    }
}
