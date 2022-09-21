package model;
import java.util.Timer;
import java.util.TimerTask;

public class TristanTate extends Tate {

    private int kids;

    public TristanTate() {
        kids = 2;
        manageMoney();
    }

    public void manageMoney() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                double randomN = Math.random();
                if (randomN < 0.05) { kids++; }
                money += (int)(randomN*100);
            }
        };

        timer.schedule(task, 0 ,20000);
    }
}
