package model.persons;

import java.util.Timer;
import java.util.TimerTask;

public class TristanTate extends Tate {

    /**
     * Tristan Tate, der Bruder von Andrew spielt auch eine große Rolle im Spiel
     * hier werden die benötigten Methoden und Variablen erstellt, um ihn zu verwalten
     */

    private int kids;

    public TristanTate() {
        kids = 2;
        manageVariables();
    }

    /**
     * timer für alle 20 Sekunden wird eingesetzt -> nimmt Änderungen an kids und money vor
     */
    @Override
    public void manageVariables() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                double randomN = Math.random();
                if (randomN < 0.05) {
                    kids++;
                } else if (randomN == 0.99) {
                    kids--;
                    money += 5000;
                }
                if (taxDay == 4){
                    taxDay = 1;
                    payTaxes();
                } else { taxDay ++; }
                payDay();
            }
        };// Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4

        timer.schedule(task, 5000 ,20000);
    }

    public int getKids(){
        return kids;
    }

    /**
     * Geld wird durch Steuern angepasst, abstrakte Methode wird umgesetzt
     */
    @Override
    public void payTaxes() {
        if (money > 0) { money *= 0.95; }
    }

    /**
     * Geld wird angepasst, abstrakte Methode wird umgesetzt
     */
    @Override
    public void payDay() {
        money += (int)(Math.random()*1000);
    }
}
