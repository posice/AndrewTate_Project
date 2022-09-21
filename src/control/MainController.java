package control;

import model.AndrewTate;
import model.tf.PredictCmd;
import view.Frame;

public class MainController {
    CommandController commandController = new CommandController();
    RoomController roomController = new RoomController();
    AndrewTate andrewTate = new AndrewTate();
    InfoController infoController = new InfoController(andrewTate);

    public void control(){
        Frame frame = new Frame();
        PredictCmd cm = new PredictCmd();
        cm.doSth();
    }

    public void passCmd(String cmd){
        commandController.newCommand(cmd);
    }
}
