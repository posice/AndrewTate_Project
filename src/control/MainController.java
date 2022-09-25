package control;

import model.persons.AndrewTate;
import model.persons.TristanTate;
import model.tf.PredictCmd;
import view.Frame;

import java.io.IOException;

public class MainController {
    AndrewTate andrewTate = new AndrewTate();
    TristanTate tristanTate = new TristanTate();
    RoomController roomController = new RoomController(andrewTate, tristanTate);
    CommandController commandController = new CommandController();
    Frame frame = new Frame(commandController);
    OutputController outputController = new OutputController(roomController, frame);
    WinController winController = new WinController(andrewTate, frame);

    public void control(){
        PredictCmd cm = new PredictCmd();
        commandController.newOutPutController(outputController);
        //cm.doSth();
        System.out.println(cm.getAnsFromInt(cm.predictAns("hey")));
    }

    public void passCmd(String cmd){
        try {
            commandController.controlCommand(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
