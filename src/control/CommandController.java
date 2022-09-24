package control;

import model.tf.PredictCmd;
import view.CommandTextfield;
import model.persons.*;

public class CommandController {
    String cmd;
    int cmdId;
    PredictCmd pcmd; //Hey
    private AndrewTate andrewTate;
    private TristanTate tristanTate;
    private RoomController roomController;

    public CommandController(AndrewTate andrewTate, TristanTate tristanTate, RoomController roomController){
        this.andrewTate = andrewTate;
        this.tristanTate = tristanTate;
        this.roomController = roomController;
        cmd = "";
        pcmd = new PredictCmd();
    }

    public void controlCommand(String cmd) {
        this.cmdId = pcmd.predictAns(cmd);
        switch (cmdId) {
            case 1: roomController.setCurrentRoomAndrew(roomController.getGym());
            case 2: roomController.setCurrentRoomAndrew(roomController.getMansion());
            case 3: roomController.setCurrentRoomAndrew(roomController.getFrenchBrothel());
            case 4: roomController.setCurrentRoomAndrew(roomController.getGarage());
            case 5: roomController.setCurrentRoomAndrew(roomController.getBugattiStore());
            case 6: roomController.setCurrentRoomAndrew(roomController.getLamboStore());
            case 7: roomController.setCurrentRoomAndrew(roomController.getAstonMartinStore());
            case 8: roomController.setCurrentRoomAndrew(roomController.getFerrariStore());
            case 9: roomController.setCurrentRoomAndrew(roomController.getOpelStore());
        }
    }
}