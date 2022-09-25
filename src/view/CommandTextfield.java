package view;

import control.CommandController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class CommandTextfield extends JTextField {

    private CommandController commandController;//um dem CommandController den Text zu geben

    public CommandTextfield(CommandController commandController){
        this.commandController = commandController;//Conroller wird benötigt für später
        Border border = BorderFactory.createLineBorder(Color.white);//Umrandung
        this.setHorizontalAlignment(JTextField.LEFT);//Wo ist der Text
        this.setForeground(Color.WHITE);//Text und Cursor Farbe
        this.setCaretColor(Color.WHITE);
        this.setBackground(new Color(184,115,51));//Ffeldfarbe
        this.setBounds(0,525,540,40);//Ort
        this.setBorder(border);
    }

    public String getCommand(){
        String command = this.getText();//command enthält den String des Felds
        this.setText("");//Text wird entfernt
        return command;
    }

    public CommandController getCommandController() {
        return commandController;
    }
}
