package control;

import model.persons.AndrewTate;
import model.persons.TristanTate;
import model.tf.PredictCmd;
import view.Frame;

public class MainController {
    AndrewTate andrewTate = new AndrewTate();
    TristanTate tristanTate = new TristanTate();
    RoomController roomController = new RoomController(andrewTate, tristanTate);
    CommandController commandController = new CommandController();
    Frame frame = new Frame(commandController);
    OutputController outputController = new OutputController(roomController, frame);

    public void control(){
        PredictCmd cm = new PredictCmd();
        commandController.newOutPutController(outputController);
        //cm.doSth();
    }

    public void passCmd(String cmd){
        commandController.controlCommand(cmd);
    }
}
