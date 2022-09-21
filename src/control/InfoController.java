package control;

import model.AndrewTate;
import view.InfoLabel;

import java.util.Timer;
import java.util.TimerTask;

public class InfoController {
    private AndrewTate tate;
    private InfoLabel label;

    public InfoController(AndrewTate tate){
        this.tate = tate;
        doInfos();
    }

    public void doInfos(){
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                label.refresh(getInfos());
            }
        };

        timer.schedule(timerTask, 0, 5000);
    } // Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4
    public String getInfos(){
        String infos = "follower: " + tate.getFollower() + "money: " + tate.getMoney();
        return infos;
    }
}
