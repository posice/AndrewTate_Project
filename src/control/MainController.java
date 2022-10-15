package control;

import model.persons.AndrewTate;
import model.persons.TristanTate;
import view.Frame;

public class MainController {
    /**
     * alle Objekte werden hier erstellt
     */
    AndrewTate andrewTate = new AndrewTate();
    TristanTate tristanTate = new TristanTate();
    RoomController roomController = new RoomController(andrewTate, tristanTate);
    CommandController commandController = new CommandController();
    Frame frame = new Frame(commandController);
    OutputController outputController = new OutputController(roomController, frame);
    WinController winController = new WinController(andrewTate, frame);


    /**
     * commandController Assoziation 0..1 zu outputController wird hier umgesetzt
     */
    public void control(){
        commandController.newOutputController(outputController);
    }
}
