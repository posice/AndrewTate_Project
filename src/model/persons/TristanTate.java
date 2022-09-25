package model.persons;

import java.util.Timer;
import java.util.TimerTask;

public class TristanTate extends Tate {

    private int kids;

    public TristanTate() {
        kids = 2;
        manageVariables();
    }

    @Override
    public void manageVariables() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() { // Timer für alle 20 Sekunden
                double randomN = Math.random(); // random Zahl
                if (randomN < 0.05) {
                    kids++; //neues Kind
                } else if (randomN == 0.99) {
                    kids--; //Kind stirbt
                    money += 5000; //Lebensversicherung
                }
                if (taxDay == 4){ //jeden viertan Tag werden Steuern gezahlt
                    taxDay = 1;  //zurücksetzen auf ersten Tag
                    payTaxes();  // Steuern werden bezahlt
                } else { taxDay ++; } // wenn nicht taxday, dann kommt nächster Tag
                payDay(); //bekommt Geld
            }
        };// Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4

        timer.schedule(task, 5000 ,20000);
    }

    @Override
    public void payTaxes() { money *= 0.95; } // Geld wird von dem Staat abgezogen

    @Override
    public void payDay() {
        money += (int)(Math.random()*1000); //Geld was durch Arbeit verdient wird
    }
}
