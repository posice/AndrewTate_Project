package view;

import control.CommandController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class CommandTextfield extends JTextField {

    /**
     * Das Textfeld zum eigeben der Befehle
     * Das Aussehen wird hier festgelegt
     */
    public CommandTextfield(){
        Border border = BorderFactory.createLineBorder(Color.white);
        this.setHorizontalAlignment(JTextField.LEFT);
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setBackground(new Color(184,115,51));
        this.setBounds(0,525,540,40);
        this.setBorder(border);
    }

    /**
     * Man erhält den Text des Textfeldes und löscht den nach Aufruf
     * @return den Text bei Aurfuf der Methode
     */
    public String getCommand(){
        String command = this.getText();
        this.setText("");
        return command;
    }
}
