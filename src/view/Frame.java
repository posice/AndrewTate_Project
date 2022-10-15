package view;

import control.CommandController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class Frame extends JFrame implements ActionListener {
    /**
     * Das Frame, das Fenster wo alles ausgegeben wird
     * Dazu werden hier alle nötigen View Klassen erstellt
     */
    private CommandTextfield commandTextfield;
    private OutputPanel[] outputPanels;
    private int yPosOfPanel;
    private WinningFrame winningFrame;
    private Button button;
    private CommandController commandController;

    /**
     * man erstellt das Frame
     * Dazu einen Button
     * Dazu alle Grundprinuzipien
     * null Layout für spezifische x,y,z Koordinaten
     * @param commandController wird vom Maincontroller gegeben
     */

    public Frame(CommandController commandController){
        button = new Button();
        button.addActionListener(this);
        yPosOfPanel = 1;
        this.setSize(1080,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("TopGs get rich");
        this.getContentPane().setBackground(new Color(184,115,51));
        outputPanels = new OutputPanel[12];
        commandTextfield = new CommandTextfield();
        this.commandController = commandController;
        this.setVisible(true);
        this.add(commandTextfield);
        this.add(button);
    }

    //Quelle Button: https://www.youtube.com/watch?v=-IMys4PCkIA

    /**
     * bei sieg löscht sich das Frame und neues wird erstellt
     */
    public void win(){
        this.setVisible(false);
        winningFrame = new WinningFrame();
    }

    /**
     * falls der Bildschirm voll ist, wird er gecleart
     * Man erstellt ein Panel mit Label im Frame, direkt unter dem vorigen
     * @param output steht für den gegeben Output bei Aufruf der Methode
     */

    public void printOutput(String output) {
        if (yPosOfPanel == 9){
            System.out.println("j");
            yPosOfPanel = 1;
            for (int i = 1; i < 9; i++){
                outputPanels[i].setVisible(false);
            }
        }
        System.out.println(yPosOfPanel);
        outputPanels[yPosOfPanel] = new OutputPanel(new OutputLabel(output), 10, 10 + 50 * yPosOfPanel);
        this.add(outputPanels[yPosOfPanel]);
        yPosOfPanel++;
        this.setVisible(false);
        this.setVisible(true);
    }

    /**
     * Wenn man den Button drückt, wird im Command Controller die Methode controlCOmmand aufgerufen
     * @param e the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button && !Objects.equals(commandTextfield.getText(), "")) {
            try {
                commandController.controlCommand(commandTextfield.getCommand());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}