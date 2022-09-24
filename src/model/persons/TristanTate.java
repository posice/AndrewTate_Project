package model.persons;

import java.util.Timer;
import java.util.TimerTask;
import model.Room;

public class TristanTate extends Tate {

    private int kids;

    public TristanTate() {
        kids = 2;
        manageMoney();
    }

    @Override
    public void manageMoney() {
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
                payDay();
            }
        };// Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4

        timer.schedule(task, 0 ,20000);
    }

    @Override
    public void payTaxes() { money *= 0.95; }

    @Override
    public void payDay() {
        money += (int)(Math.random()*1000); //Geld was durch Arbeit verdient wird
        money += addUpCarMoney();
    }
}
