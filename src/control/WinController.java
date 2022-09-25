package control;

import model.persons.AndrewTate;
import view.Frame;

import java.util.Timer;
import java.util.TimerTask;

public class WinController {
    private AndrewTate andrewTate;
    private Frame frame;

    public WinController(AndrewTate andrewTate, Frame frame){
        this.andrewTate = andrewTate;
        this.frame = frame;
        checkWin();
    }

    public void checkWin(){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (andrewTate.getFollower() >= 1000 && andrewTate.getMoney()>= 1000000){
                    frame.win();
                }
            }
        };

        timer.schedule(task, 100, 5000);
    }
}
