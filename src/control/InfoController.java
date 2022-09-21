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
    }
    public String getInfos(){
        String infos = "" + tate.getBodyCount() + tate.getAge() + tate.getMoney();
        return infos;
    }
}
