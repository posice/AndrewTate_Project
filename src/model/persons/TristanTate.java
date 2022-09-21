package model.persons;

import java.util.Timer;
import java.util.TimerTask;

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
        };

        timer.schedule(task, 0 ,20000);
    }

    @Override
    public void payTaxes() { money *= 0.95; }

    @Override
    public void payDay() { money += (int)(Math.random()*1000); }
}
