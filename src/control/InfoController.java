package control;

import model.persons.AndrewTate;
import model.persons.TristanTate;
import view.InfoLabel;

import java.util.Timer;
import java.util.TimerTask;

public class InfoController {
    private AndrewTate andrewTate;
    private TristanTate tristanTate;
    private InfoLabel label;
    private RoomController roomController;

    public InfoController(AndrewTate andrewTate, TristanTate tristanTate, RoomController roomController){
        this.andrewTate = andrewTate;
        this.tristanTate = tristanTate;
        this.roomController = roomController;
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

    public String getInfos() {
        String infos = "Andrew Tate: follower: " + andrewTate.getFollower() + " money: " +
                andrewTate.getMoney() + "current location: " + roomController.getCurrentRoom().getName() +
                "\n" + "Tristan Tate: money: " + tristanTate.getMoney();
        return infos;
    }
}