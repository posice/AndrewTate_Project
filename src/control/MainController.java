package control;

import model.persons.AndrewTate;
import model.persons.TristanTate;
import model.tf.PredictCmd;
import view.Frame;

public class MainController {
    CommandController commandController = new CommandController();
    RoomController roomController = new RoomController();
    OutputController outputController = new OutputController(roomController);
    AndrewTate andrewTate = new AndrewTate();
    TristanTate tristanTate = new TristanTate();

    public void control(){
        Frame frame = new Frame();
        PredictCmd cm = new PredictCmd();
        cm.doSth();
    }

    public void passCmd(String cmd){
        commandController.newCommand(cmd);
    }
}
