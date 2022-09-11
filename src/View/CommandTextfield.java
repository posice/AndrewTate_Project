package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandTextfield extends JTextField implements KeyListener{
    public CommandTextfield(){
        Border border = BorderFactory.createLineBorder(Color.white);
        this.setHorizontalAlignment(JTextField.LEFT);
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setBackground(new Color(89,47,34));
        this.setBounds(0,0,540,40);
        this.setBorder(border);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            this.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
