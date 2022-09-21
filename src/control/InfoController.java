package control;

import model.AndrewTate;
import model.TristanTate;
import view.InfoLabel;

import java.util.Timer;
import java.util.TimerTask;

public class InfoController {
    private AndrewTate andrewTate;
    private TristanTate tristanTate;
    private InfoLabel label;

    public InfoController(AndrewTate andrewTate, TristanTate tristanTate){
        this.andrewTate = andrewTate;
        this.tristanTate = tristanTate;
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
        timer.schedule(timerTask, 100, 5000);
    } // Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4

    public String getInfos(){
        String infos = "Andrew Tate: follower: " + andrewTate.getFollower() + " money: " +
                        andrewTate.getMoney() + "\n" + "Tristan Tate: follower: " ;
        return infos;
    }
}
