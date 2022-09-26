package control;

import model.persons.AndrewTate;
import model.persons.TristanTate;
import model.tf.PredictCmd;
import view.Frame;

import java.io.IOException;

public class MainController {
    //alle Objekte werden hier erstellt
    AndrewTate andrewTate = new AndrewTate();
    TristanTate tristanTate = new TristanTate();
    RoomController roomController = new RoomController(andrewTate, tristanTate);
    CommandController commandController = new CommandController();
    Frame frame = new Frame(commandController);
    OutputController outputController = new OutputController(roomController, frame);
    WinController winController = new WinController(andrewTate, frame);

    public void control(){
        PredictCmd cm = new PredictCmd();
        commandController.newOutPutController(outputController); //commandController Assoziation 0..1 zu outputController
        //cm.doSth();
    }

    public void passCmd(String cmd){
        try {
            commandController.controlCommand(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
