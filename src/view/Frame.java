package view;

import control.CommandController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class Frame extends JFrame implements ActionListener {
    private CommandTextfield commandTextfield;
    private OutputPanel[] outputPanels;//Alle Panels
    private int yPosOfPanel;
    private WinningFrame winningFrame;
    private JButton button;

    public Frame(CommandController commandController){//erstellt das Frme und das Textfield des Panels
        button = new JButton();
        button.setText("enter");
        button.setForeground(Color.white);
        button.setFont(new Font("Uni Sans", Font.PLAIN, 15));
        button.addActionListener(this);
        button.setBounds(550, 450, 100, 100);
        button.setBackground(Color.black);
        yPosOfPanel = 1;
        this.setSize(1080,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Man kann es schließen
        this.setResizable(false);
        this.setTitle("TopGs get rich");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.black);
        this.getContentPane().setBackground(new Color(184,115,51));
        outputPanels = new OutputPanel[12];
        commandTextfield = new CommandTextfield(commandController);
        this.setVisible(true);
        this.add(commandTextfield);//Damit man das Textfield sieht
        this.add(button);
    }

    public void win(){//lässt das andere Frame auftauchen, wenn gewonnen wird
        this.setVisible(false);
        winningFrame = new WinningFrame();
    }

    public void printOutput(String output) {
        if (yPosOfPanel == 9){//Wenn das frame voll ist, werden die Labels "gelöscht und es fängt von Anfang an
            System.out.println("j");
            yPosOfPanel = 1;
            outputPanels[1].setVisible(false);
            outputPanels[2].setVisible(false);
            outputPanels[3].setVisible(false);
            outputPanels[4].setVisible(false);
            outputPanels[5].setVisible(false);
            outputPanels[6].setVisible(false);
            outputPanels[7].setVisible(false);
            outputPanels[8].setVisible(false);
        }
        System.out.println(yPosOfPanel);
        outputPanels[yPosOfPanel] = new OutputPanel(new OutputLabel("Folgende Infos: " + output), 10, 10 + 50 * yPosOfPanel);
        //Am richtigen Ort wird das Label erstellt
        this.add(outputPanels[yPosOfPanel]);//Man fügt das Panel mit dem hinzugefügten Label hinzu
        yPosOfPanel++;//nächstes Mal eins weiter oben
        this.setVisible(false);//aktualisiert das Frame
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button && !Objects.equals(commandTextfield.getText(), "")) {
            try {
                commandTextfield.getCommandController().controlCommand(commandTextfield.getCommand());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}