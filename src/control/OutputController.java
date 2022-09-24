package control;

import model.persons.*;

public class OutputController {

    private RoomController roomController;
    private CommandController commandController;

    public OutputController(RoomController roomController) {
        this.roomController = roomController;
    }

     public String getInfos() {
        String infos = "Andrew Tate: follower: " + roomController.getAndrewTate().getFollower() + " money: " +
                roomController.getAndrewTate().getMoney() + "current location: " + roomController.getCurrentRoomAndrew().getName() +
                "\n" + "Tristan Tate: money: " + roomController.getTristanTate().getMoney() + "location: " +
                roomController.getCurrentRoomTristan().getName();
        return infos;
    } //typeCast

}
