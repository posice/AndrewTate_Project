package view;

import control.CommandController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandTextfield extends JTextField implements KeyListener {

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
        this.addKeyListener(this);
    }

    public String getCommand(){
        String command = this.getText();//command enthält den String des Felds
        this.setText("");//Text wird entfernt
        return command;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && getCommand()!= ""){
            commandController.controlCommand(this.getCommand());// wenn man enter drückt, wird controlCommand aufgerufen und das Feld geleert
        }
    }
// wenn man enter drückt, wird controlCommand aufgerufen und das Feld geleert
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
