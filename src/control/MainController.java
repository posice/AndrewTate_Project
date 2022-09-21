package control;

import model.AndrewTate;
import model.Room;

public class MainController {
    private AndrewTate tate;
    private InfoController infoController;

    public MainController(){
        tate = new AndrewTate("Andrew Tate", 6000000, new Room(), 300, 30);
        infoController = new InfoController(tate);
    }
}
