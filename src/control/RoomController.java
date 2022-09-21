package control;
import model.Room;

public class RoomController {

    private Room mansion;
    private Room frenchBrothel;
    private Room gym;
    private Room garage;
    private Room currentRoom;

    public RoomController() {
        mansion = new Room("mansion", "");
        currentRoom = mansion;
        frenchBrothel = new Room("frenchBrothel", "");
        gym = new Room("gym", "");
        garage = new Room("garage", "" );
    }

    public Room getCurrentRoom() { return currentRoom; }
}
