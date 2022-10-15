package control;

import model.persons.AndrewTate;
import view.Frame;

import java.util.Timer;
import java.util.TimerTask;

public class WinController {
    /**
     * man kontrolliert hier, ob gewonnen wurde
     */
    private AndrewTate andrewTate;
    private Frame frame;
    private boolean won;

    public WinController(AndrewTate andrewTate, Frame frame){
        this.andrewTate = andrewTate;
        this.frame = frame;
        checkWin();
        won  = false;
    }

    public void checkWin(){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (andrewTate.getFollower() >= 10000 && andrewTate.getMoney()>= 1000000 && !won){
                    frame.win();
                    won = true;
                }
            }
        };

        timer.schedule(task, 100, 5000);
    }
}
