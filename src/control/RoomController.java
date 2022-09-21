package control;
import model.Room;

public class RoomController {

    private Room mansion;
    private Room frenchBrothel;
    private Room gym;
    private Room garage;
    private Room bugattiStore;
    private Room lamboStore;
    private Room astonMartinStore;
    private Room ferrariStore;
    private Room opelStore;
    private Room currentRoomAndrew;
    private Room currentRoomTristan;

    public RoomController() {
        mansion = new Room("mansion", "");
        currentRoomAndrew = mansion;
        currentRoomTristan = mansion;
        frenchBrothel = new Room("french brothel", "");
        gym = new Room("gym", "");
        garage = new Room("garage", "" );
        bugattiStore = new Room("Bugatti store", "");
        lamboStore = new Room("Lambo store", "");
        astonMartinStore = new Room("Aston Martin store", "");
        ferrariStore = new Room("Ferrari store", "");
        opelStore = new Room("Opel store", "");
    }

    public Room getCurrentRoomAndrew() { return currentRoomAndrew; }
    public Room getCurrentRoomTristan() { return currentRoomTristan; }

    public void setCurrentRoomTristan (Room newRoom) { currentRoomTristan = newRoom; }
    public void setCurrentRoomAndrew(Room newRoom) { currentRoomAndrew = newRoom; }

    public void setRandomCurrentRoom() {
        int randomN = (int)(Math.random()*100);
        if (randomN < 40) {
            currentRoomTristan = mansion;
        } else if (randomN < 44) {
            currentRoomTristan = frenchBrothel;
        } else if (randomN < 70) {
            currentRoomTristan = gym;
        } else if (randomN < 80) {
            currentRoomTristan = garage;
        } else if (randomN < 85) {
            currentRoomTristan = bugattiStore;
        }
    }
}
