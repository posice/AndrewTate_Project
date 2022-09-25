package control;

import view.Frame;

import java.io.IOException;

public class OutputController {

    private RoomController roomController;
    private Frame frame;

    public OutputController(RoomController roomController, Frame frame) {
        this.roomController = roomController;
        this.frame = frame;
    }

    public RoomController getRoomController() { return roomController; }

    public void controlOutput(String outputCommand) throws IOException {
        switch (outputCommand) {
            case "goGym":
                frame.printOutput(roomController.getGym().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getGym());
                if (roomController.getCurrentRoomTristan() == roomController.getGym()) {
                    frame.printOutput("\n Your brother Tristan is in here as well");
                }
                break;
            case "goMansion":
                frame.printOutput(roomController.getMansion().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getMansion());
                if (roomController.getCurrentRoomTristan() == roomController.getMansion()) {
                    frame.printOutput("\n Your brother Tristan is in here as well");
                }
                break;
            case "goFrenchBrothel":
                frame.printOutput(roomController.getFrenchBrothel().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getFrenchBrothel());
                if (roomController.getCurrentRoomTristan() == roomController.getFrenchBrothel()) {
                    frame.printOutput("\n Your brother Tristan is in here as well");
                }
                break;
            case "goGarage":
                frame.printOutput(roomController.getGarage().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getGarage());
                if (roomController.getCurrentRoomTristan() == roomController.getGarage()) {
                    frame.printOutput("\n Your brother Tristan is in here as well");
                }
                break;
            case "goBugattiStore":
                frame.printOutput(roomController.getBugattiStore().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getBugattiStore());
                if (roomController.getCurrentRoomTristan() == roomController.getBugattiStore()) {
                    frame.printOutput("\n Your brother Tristan is in here as well");
                }
                break;
            case "goLamboStore":
                frame.printOutput(roomController.getLamboStore().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getLamboStore());
                if (roomController.getCurrentRoomTristan() == roomController.getLamboStore()) {
                    frame.printOutput("\n Your brother Tristan is in here as well");
                }
                break;
            case "goAstonMartinStore":
                frame.printOutput(roomController.getAstonMartinStore().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getAstonMartinStore());
                if (roomController.getCurrentRoomTristan() == roomController.getAstonMartinStore()) {
                    frame.printOutput("Your brother Tristan is in here as well");
                }
                break;
            case "goFerrariStore":
                frame.printOutput(roomController.getFerrariStore().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getFerrariStore());
                if (roomController.getCurrentRoomTristan() == roomController.getFerrariStore()) {
                    frame.printOutput("Your brother Tristan is in here as well");
                }
                break;
            case "goOpelStore":
                frame.printOutput(roomController.getOpelStore().getInfo());
                roomController.setCurrentRoomAndrew(roomController.getOpelStore());
                if (roomController.getCurrentRoomTristan() == roomController.getOpelStore()) {
                    frame.printOutput("Your brother Tristan is in here as well");
                }
                break;
        }
    }

    public String getInfos() { // Ausgabe von allen wichtigen Informationen durch typecast
        // alle wichtigen Informationen werden konkatiniert
        String infos = "Andrew Tate: follower: " + roomController.getAndrewTate().getFollower() + " money: " +
                roomController.getAndrewTate().getMoney() + "current location: " + roomController.getCurrentRoomAndrew().getName() +
                "\n" + "Tristan Tate: money: " + roomController.getTristanTate().getMoney() + "location: " +
                roomController.getCurrentRoomTristan().getName();
        return infos; // der neu zusammengesetzte String wird zurückgegeben
    }
}
