package control;
import model.Room;

public class RoomController {

    private Room mansion;
    private Room frenchBrothel;
    private Room gym;
    private Room garage;

    public RoomController() {
        mansion = new Room("mansion", "In the mansion there is Tristan waiting for you");
        frenchBrothel = new Room("frenchBrothel", "Ooooo, a very weird place, a lot of chicks and strange French" +
                                    "men who are jerking off");
        gym = new Room("gym", "It's time to train, a lot of TopGs in here");
        garage = new Room("garage", "The cars" );
    }
}
