package control;

import model.persons.AndrewTate;
import model.persons.TristanTate;
import model.tf.PredictCmd;
import view.Frame;

public class MainController {
    CommandController commandController = new CommandController();
    AndrewTate andrewTate = new AndrewTate();
    TristanTate tristanTate = new TristanTate();
    RoomController roomController = new RoomController(andrewTate, tristanTate);
    OutputController outputController = new OutputController(roomController);

    public void control(){
        Frame frame = new Frame();
        PredictCmd cm = new PredictCmd();
        //cm.doSth();
    }

    public void passCmd(String cmd){
        commandController.newCommand(cmd);
    }
}
