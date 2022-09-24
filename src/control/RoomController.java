package control;
import model.Room;
import model.persons.*;

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
    private AndrewTate andrewTate; //lose Kopplung durch getter -> OuputController muss AndrewTate und TristanTate nicht kennen
    private TristanTate tristanTate;

    public RoomController(AndrewTate andrewTate, TristanTate tristanTate) {
        this.andrewTate = andrewTate;
        this.tristanTate = tristanTate;
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
    public AndrewTate getAndrewTate() { return andrewTate; }
    public TristanTate getTristanTate() { return tristanTate; }
    public Room getMansion() { return mansion; }
    public Room getFrenchBrothel() { return frenchBrothel; }
    public Room getGym() { return gym; }
    public Room getGarage() { return garage; }
    public Room getBugattiStore() { return bugattiStore; }
    public Room getLamboStore() { return lamboStore; }
    public Room getAstonMartinStore() { return astonMartinStore; }
    public Room getFerrariStore() { return ferrariStore; }
    public Room getOpelStore() { return opelStore; }

    //public void setCurrentRoomTristan (Room newRoom) { currentRoomTristan = newRoom; }
    public void setCurrentRoomAndrew(Room newRoom) { currentRoomAndrew = newRoom; }

    public void setRandomRoom(Tate tate) { //Subtyping Methode
        int randomN = (int)(Math.random()*100);
        if (randomN < 40) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                mansion.setTristanInRoom();
                currentRoomTristan = mansion;
            } else {
                currentRoomAndrew = mansion;
            }

        } else if (randomN < 44) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                frenchBrothel.setTristanInRoom();
                currentRoomTristan = frenchBrothel;
            } else { currentRoomAndrew = frenchBrothel; }

        } else if (randomN < 70) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                gym.setTristanInRoom();
                currentRoomTristan = gym;
            } else { currentRoomAndrew = gym; }

        } else if (randomN < 80) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                garage.setTristanInRoom();
                currentRoomTristan = garage;
            } else { currentRoomAndrew = garage; }

        } else if (randomN < 85) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                bugattiStore.setTristanInRoom();
                currentRoomTristan = bugattiStore;
            } else { currentRoomAndrew = bugattiStore; }

        } else if (randomN < 89) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                lamboStore.setTristanInRoom();
                currentRoomTristan = lamboStore;
            } else { currentRoomAndrew = lamboStore; }

        } else if (randomN < 93) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                astonMartinStore.setTristanInRoom();
                currentRoomTristan = astonMartinStore;
            } else { currentRoomAndrew = astonMartinStore; }

        } else if (randomN < 97) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                ferrariStore.setTristanInRoom();
                currentRoomTristan = ferrariStore;
            } else { currentRoomAndrew = ferrariStore; }

        } else if (randomN < 98) {
            if (tate == tristanTate) {
                currentRoomTristan.setTristanOutRoom();
                opelStore.setTristanInRoom();
                currentRoomTristan = opelStore;
            } else { currentRoomAndrew = opelStore; }
        }
    }
}
