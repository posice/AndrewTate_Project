package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandTextfield extends JTextField implements KeyListener {

    private boolean commandTyped;

    public CommandTextfield(){
        Border border = BorderFactory.createLineBorder(Color.white);
        this.setHorizontalAlignment(JTextField.LEFT);
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setBackground(new Color(89,47,34));
        this.setBounds(0,525,540,40);
        this.setBorder(border);
        this.addKeyListener(this);
        this.setVisible(true);
    }

    public String getCommand(){
        String command = this.getText();
        this.setText("");
        return command;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            commandTyped = true;
            String message = this.getCommand();
            System.out.println(message);
            commandTyped = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
