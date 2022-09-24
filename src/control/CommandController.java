package control;

import model.tf.PredictCmd;
import view.CommandTextfield;

public class CommandController {
    String cmd;
    int cmdId;
    PredictCmd pcmd; //Hey

    public CommandController(){
        cmd = "";
        pcmd = new PredictCmd();
    }
    public void newCommand(String cmd){
        this.cmdId = pcmd.predictAns(cmd);


    }
}