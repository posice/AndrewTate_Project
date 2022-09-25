package control;

import model.tf.PredictCmd;
import view.CommandTextfield;
import model.persons.*;

public class CommandController {
    String cmd;
    int cmdId;
    PredictCmd pcmd; //Hey
    private String outputCommand;
    private OutputController outputController;

    public CommandController(){
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
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getGym());
                outputCommand = "goGym";
                break;
            case 2:
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getMansion());
                outputCommand = "goMansion";
                break;
            case 3:
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getFrenchBrothel());
                outputCommand = "goFrenchBrothel";
                break;
            case 4:
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getGarage());
                outputCommand = "goGarage";
                break;
            case 5:
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getBugattiStore());
                outputCommand = "goBugattiStore";
                break;
            case 6:
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getLamboStore());
                outputCommand = "goLamboStore";
                break;
            case 7:
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getAstonMartinStore());
                outputCommand = "goAstonMartinStore";
                break;
            case 8:
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getFerrariStore());
                outputCommand = "goFerrariStore";
                break;
            case 9:
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getOpelStore());
                outputCommand = "goOpelStore";
                break;
        }

    }
}