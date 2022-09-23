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
        mansion = new Room("mansion", "", new String[]{"chick", "Tristan"});
        currentRoomAndrew = mansion;
        currentRoomTristan = mansion;
        frenchBrothel = new Room("french brothel", "", new String[]{"chick", "NineFive"});
        gym = new Room("gym", "", new String[]{"G"});
        garage = new Room("garage", "", new String[]{});
        bugattiStore = new Room("Bugatti store", "", new String[]{"G", "chick"});
        lamboStore = new Room("Lambo store", "", new String[]{"G"});
        astonMartinStore = new Room("Aston Martin store", "", new String[]{"G", "chick"});
        ferrariStore = new Room("Ferrari store", "", new String[]{"G"});
        opelStore = new Room("Opel store", "", new String[]{"NinveFive"});
    }

    public Room getCurrentRoomAndrew() { return currentRoomAndrew; }
    public Room getCurrentRoomTristan() { return currentRoomTristan; }

    //public void setCurrentRoomTristan (Room newRoom) { currentRoomTristan = newRoom; }
    public void setCurrentRoomAndrew(Room newRoom) { currentRoomAndrew = newRoom; }

    public void setRandomCurrentRoomTristan() {
        int randomN = (int)(Math.random()*100);
        if (randomN < 40) {
            currentRoomTristan.setTristanOutRoom();
            mansion.setTristanInRoom();
            currentRoomTristan = mansion;
        } else if (randomN < 44) {
            currentRoomTristan.setTristanOutRoom();
            frenchBrothel.setTristanInRoom();
            currentRoomTristan = frenchBrothel;
        } else if (randomN < 70) {
            currentRoomTristan.setTristanOutRoom();
            gym.setTristanInRoom();
            currentRoomTristan = gym;
        } else if (randomN < 80) {
            currentRoomTristan.setTristanOutRoom();
            garage.setTristanInRoom();
            currentRoomTristan = garage;
        } else if (randomN < 85) {
            currentRoomTristan.setTristanOutRoom();
            bugattiStore.setTristanInRoom();
            currentRoomTristan = bugattiStore;
        } else if (randomN < 89) {
            currentRoomTristan.setTristanOutRoom();
            lamboStore.setTristanInRoom();
            currentRoomTristan = lamboStore;
        } else if (randomN < 93) {
            currentRoomTristan.setTristanOutRoom();
            astonMartinStore.setTristanInRoom();
            currentRoomTristan = astonMartinStore;
        } else if (randomN < 97) {
            currentRoomTristan.setTristanOutRoom();
            ferrariStore.setTristanInRoom();
            currentRoomTristan = ferrariStore;
        } else if (randomN < 98) {
            currentRoomTristan.setTristanOutRoom();
            opelStore.setTristanInRoom();
            currentRoomTristan = opelStore;
        }
    }
}
