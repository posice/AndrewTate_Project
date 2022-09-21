package control;

import model.AndrewTate;
import view.InfoLabel;

import java.util.Timer;
import java.util.TimerTask;

public class InfoController {
    private AndrewTate andrewTate;
    private InfoLabel label;

    private int taxday = 1;

    public InfoController(AndrewTate tate){
        this.andrewTate = tate;
        doInfos();
    }

    public void doInfos(){

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (taxday == 4){
                    taxday = 1;
                    andrewTate.taxes();
                }
                andrewTate.payDay();
                label.refresh(getInfos());
                taxday ++;
            }
        };

        timer.schedule(timerTask, 0, 5000);
    } // Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4

    public String getInfos(){
        String infos = "follower: " + andrewTate.getFollower() + "money: " + andrewTate.getMoney();
        return infos;
    }
}
