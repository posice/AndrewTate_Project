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

        // In den folgenden Zeilen werden alle verschiedenen Rooms erstellt
        mansion = new Room(
                "mansion",
                "You are now in the mansion, there is a chick waiting for you",
                new String[] {"chick", "Tristan"}
        );
        frenchBrothel = new Room(
                "french brothel",
                "Ooooo a very disgusting place: the french brothel, there are French "
                + "chicks and ninefive workers everywhere, you better run away from here",
                new String[] {"chick", "NineFive"}
        );
        gym = new Room(
                "gym",
                "G, you arrived at the gym! It's time to fight and train and by the way, you can talk to some true Gs"
                + " in here",
                new String[] {"G"}
        );
        garage = new Room(
                "garage",
                "",
                new String[] {}
        );
        bugattiStore = new Room(
                "Bugatti store",
                "YESSSS, BUGATTIS EVERYWHERE, PLEASE, YOU NEED TO BUY ONE OF THOSE BEAUTIES \n" +
                "There are also chicks and Gs in here who you can talk to",
                new String[] {"G", "chick"}
        );
        lamboStore = new Room(
                "Lambo store",
                "Lambos, nice, you might buy one just to let people know that you can actually afford it \n" +
                "no chicks here unfortunately, but a lot of Gs looking at their future cars",
                new String[] {"G"}
        );
        astonMartinStore = new Room(
                "Aston Martin store",
                "British cars hmmmm, those are cool but London is still a terrible city" +
                "but you know what British chicks are special and there are a few in here, also a lot of British Gs",
                new String[] {"G", "British chick"}
        );
        ferrariStore = new Room(
                "Ferrari store",
                "Ferraris, not as good as Bugattis but second best \n" + "Italian chicks and alpha males(Gs), marvelous",
                new String[] {"G","Italian chick"}
        );
        opelStore = new Room(
                "Opel store",
                "OH MY FUCKING GOD WHERE AM I?? I THINK THIS PLACE IS EVEN WORSE THAN THE FRENCH BROTHEL \n" +
                "Oh God too many NineFivers in here, I need to get out of here",
                new String[]{"NinveFive"}
        );

        currentRoomAndrew = mansion;
        currentRoomTristan = mansion;
    }

    public Room getCurrentRoomAndrew() { return currentRoomAndrew; }
    public Room getCurrentRoomTristan() { return currentRoomTristan; }
    public Room getMansion() { return mansion; }
    public Room getFrenchBrothel() { return frenchBrothel; }
    public Room getGym() { return gym; }
    public Room getGarage() { return garage; }
    public Room getBugattiStore() { return bugattiStore; }
    public Room getLamboStore() { return lamboStore; }
    public Room getAstonMartinStore() { return astonMartinStore; }
    public Room getFerrariStore() { return ferrariStore; }
    public Room getOpelStore() { return opelStore; }
    public AndrewTate getAndrewTate() { return andrewTate; }
    public TristanTate getTristanTate() { return tristanTate; }

    public void setCurrentRoomAndrew(Room newRoom) { currentRoomAndrew = newRoom; }

    public void setRandomRoom(Tate tate) { //Subtyping Methode, ein random Room wird für einen beliebigen Tate gesetzt
        int randomN = (int)(Math.random()*100); //random Zahl von 0 bis 99
        if (randomN < 40) { //wemm kleiner als 40
            if (tate == tristanTate) { // wenn Parameter tristanTate ist
                currentRoomTristan.setTristanOutRoom(); // Tristan wird aus seinem aktuellen Zimmer entfernt
                mansion.setTristanInRoom(); //wird in Mansion gesetzt
                currentRoomTristan = mansion;
            } else { // wenn Parameter AndrewTate ist
                currentRoomAndrew = mansion; // Andrew wird in die Mansion gesetzt
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
