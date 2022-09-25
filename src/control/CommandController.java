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
    private String outputCommand;
    private OutputController outputController;

    public CommandController(AndrewTate andrewTate, TristanTate tristanTate, RoomController roomController){
        this.andrewTate = andrewTate;
        this.tristanTate = tristanTate;
        this.roomController = roomController;
        cmd = "";
        outputCommand = "";
        pcmd = new PredictCmd();
    }

    public void newOutPutController(OutputController outputController) { this.outputController = outputController; }

    public String getOutputCommand() { return outputCommand; }

    public void controlCommand(String cmd) {
        this.cmdId = pcmd.predictAns(cmd);
        switch (cmdId) {
            case 1:
                roomController.setCurrentRoomAndrew(roomController.getGym());
                outputCommand = "goGym";
                break;
            case 2:
                roomController.setCurrentRoomAndrew(roomController.getMansion());
                outputCommand = "goMansion";
                break;
            case 3:
                roomController.setCurrentRoomAndrew(roomController.getFrenchBrothel());
                outputCommand = "goFrenchBrothel";
                break;
            case 4:
                roomController.setCurrentRoomAndrew(roomController.getGarage());
                outputCommand = "goGarage";
                break;
            case 5:
                roomController.setCurrentRoomAndrew(roomController.getBugattiStore());
                outputCommand = "goBugattiStore";
                break;
            case 6:
                roomController.setCurrentRoomAndrew(roomController.getLamboStore());
                outputCommand = "goLamboStore";
                break;
            case 7:
                roomController.setCurrentRoomAndrew(roomController.getAstonMartinStore());
                outputCommand = "goAstonMartinStore";
                break;
            case 8:
                roomController.setCurrentRoomAndrew(roomController.getFerrariStore());
                outputCommand = "goFerrariStore";
                break;
            case 9:
                roomController.setCurrentRoomAndrew(roomController.getOpelStore());
                outputCommand = "goOpelStore";
                break;
        }

    }
}