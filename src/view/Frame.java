package view;

import control.CommandController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Frame extends JFrame{
    private CommandTextfield commandTextfield;
    private OutputPanel[] outputPanels;//Alle Panels
    private int yPosOfPanel;
    private WinningFrame winningFrame;

    public Frame(CommandController commandController){//erstellt das Frme und das Textfield des Panels
        yPosOfPanel = 1;
        this.setSize(1080,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Man kann es schließen
        this.setResizable(false);
        this.setTitle("TopGs get rich");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.black);
        this.getContentPane().setBackground(new Color(184,115,51));
        outputPanels = new OutputPanel[10];
        commandTextfield = new CommandTextfield(commandController);
        this.setVisible(true);
        this.add(commandTextfield);//Damit man das Textfield sieht
    }

    public void win(){//lässt das andere Frame auftauchen, wenn gewonnen wird
        this.setVisible(false);
        winningFrame = new WinningFrame();
    }

    public void printOutput(String output) {
        for (int i = yPosOfPanel; i < outputPanels.length; i++){
            if (yPosOfPanel > 9){//Wenn das frame voll ist, werden die Labels "gelöscht und es fängt von Anfang an
                yPosOfPanel = 1;
                outputPanels[1].setVisible(false);
                outputPanels[2].setVisible(false);
                outputPanels[3].setVisible(false);
                outputPanels[4].setVisible(false);
                outputPanels[5].setVisible(false);
                outputPanels[6].setVisible(false);
                outputPanels[7].setVisible(false);
                outputPanels[8].setVisible(false);
                outputPanels[9].setVisible(false);
            }
            outputPanels[i] = new OutputPanel(new OutputLabel("Folgende Infos: " + output), 10, 10 + 50 * yPosOfPanel);
            //Am richtigen Ort wird das Label erstellt
            this.add(outputPanels[i]);//Man fügt das Panel mit dem hinzugefügten Label hinzu
            yPosOfPanel++;//nächstes Mal eins weiter oben
            this.setVisible(false);//aktualisiert das Frame
            this.setVisible(true);
            break;
        }
    }
}