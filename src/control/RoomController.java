package control;
import model.Room;

public class RoomController {

    private Room mansion;
    private Room frenchBrothel;
    private Room gym;
    private Room garage;
    private Room currentRoomAndrew;
    private Room currentRoomTristan;

    public RoomController() {
        mansion = new Room("mansion", "");
        currentRoomAndrew = mansion;
        currentRoomTristan = mansion;
        frenchBrothel = new Room("frenchBrothel", "");
        gym = new Room("gym", "");
        garage = new Room("garage", "" );
    }

    public Room getCurrentRoomAndrew() { return currentRoomAndrew; }
    public Room getCurrentRoomTristan() { return currentRoomTristan; }

    public void setCurrentRoomTristan (Room newRoom) { currentRoomTristan = newRoom; }
    public void setCurrentRoomAndrew(Room newRoom) { currentRoomAndrew = newRoom; }
}
