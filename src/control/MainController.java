package control;

import model.tf.PredictCmd;
import view.Frame;

public class MainController {
    public CommandController cc = new CommandController();

    public void control(){
        Frame frame = new Frame();
        PredictCmd cm = new PredictCmd();
        cm.doSth();
    }

    public void passCmd(String cmd){
        cc.newCommand(cmd);
    }
}
