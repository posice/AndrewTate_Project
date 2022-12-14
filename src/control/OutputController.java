package control;

import view.Frame;

import java.io.IOException;

public class OutputController {

    /**
     * Controler Klasse, welche kontrolliert, welche Antworten auf welche Comments des Users folgen
     * kennt roomController um auf einzelne Daten der Orte zuzugreifen
     * kennt frame, um Verbindung zur GUI aufzustellen
     */

    private RoomController roomController;
    private Frame frame;
    private String[] allCommands =
    {
            "gym", "mansion", "french brothel", "garage", "bugatti store", "lambo store",
            "aston martin store", "ferrari store", "opel store", "infos", "commands", "have fun", "hit nine five",
            "hit chick", "hit g", "buy bugatti", "buy lambo", "buy aston martin", "buy ferrari", "buy opel", "talk to chick",
            "talk to g", "talk to nine five", "talk to tristan"
    };

    public OutputController(RoomController roomController, Frame frame) {
        this.roomController = roomController;
        this.frame = frame;
    }


    public RoomController getRoomController() { return roomController; } // für die lose Kopplung

    /**
     * Methode zur Kontrolle von Output
     * Bei leerem String: User wird benachrichtigt, dass Programm nicht versteht, was er meint
     * Bei Orten: User wird informiert, dass er in einem neuen Ort ist und was dieser Ort bietet,
     * im Hintergrund wird das Model angepasst
     * Bei Personen: User wird benachrichtigt, welche Interaktionen mit Personen gerade stattfinden
     * Dabei wird beachtet, ob die Person im Zimmer ist, falls nicht, wird der User benachrichtigt
     * Bei Autos: User wird benachrichtigt, dass er ein Auto gekauft hat
     * Bei getInfos: siehe Methode getInfos()
     * Bei getCommands: es werden dem User mögliche Commands gezeigt
     *
     * @param outputCommand bekommt String, welcher aus dem commandController kommt,
     * damit dann entscheiden kann was weitergemacht wird
     * @throws IOException
     */
    public void controlOutput(String outputCommand) throws IOException {
        switch (outputCommand) {
            case "":
                frame.printOutput("Excuse me what the hell did you just say?");
                break;
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
                frame.printOutput(roomController.getAndrewTate().getAllCars());
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
            case "getInfos":
                frame.printOutput(getInfos());
                break;
            case "getCommands":
                String output = "";
                /*for (int i=0; i < allCommands.length; i++) {
                    if (i == allCommands.length - 1) { output += allCommands[i]; }
                    else { output += allCommands[i] + ", "; }
                }*/
                output = "You can go to different car stores and buy the cars. You can also go to different places regarding Andrew Tate. There are also some other things to do like talking or smashing";
                frame.printOutput(output);
                break;
            case "noNineFive":
                frame.printOutput("no Nine Fives in here :(");
                break;
            case "noChick":
                frame.printOutput("no chicks in here");
                break;
            case "noG":
                frame.printOutput("no Gs in here");
                break;
            case "haveFun":
                frame.printOutput("insert moaning noises");
                break;
            case "hitNineFive":
                frame.printOutput("soooo, if you hit him,you get more followers but you have to pay for his surgery");
                break;
            case "hitChick":
                frame.printOutput("Oh G, you better never do this again, you just lost a lot of money and followers");
                break;
            case "hitG":
                frame.printOutput("Listen, he is not gonna tell anybody and does not want money, however you have just lost one follower");
                break;
            case "bugattiBought":
                frame.printOutput("You just bought a brand new bugatti, congrats!!");
                break;
            case "lamboBought":
                frame.printOutput("You just bought a brand new lambo, congrats!!");
                break;
            case "astonMartinBought":
                frame.printOutput("You just bought a brand new Aston Martin, congrats!!");
                break;
            case "ferrariBought":
                frame.printOutput("You just bought a brand new ferrari, congrats!!");
                break;
            case "opelBought":
                frame.printOutput("Eww an ugly opel");
                break;
            case "talkG":
                frame.printOutput("hey yo topG, wassup? i have earned a lot of money because of you, so here, just take some of it");
                break;
            case "talkChick":
                frame.printOutput("Ohhhh Andrew I'm int THE MOOD");
                break;
            case "talkItalianChick":
                frame.printOutput("uuu andrew, you wanna put your cheese on my pizza");
                break;
            case "talkBritishChick":
                frame.printOutput("andrew mai, could u please give me a cup of wa'er");
                break;
            case "talkNineFive":
                frame.printOutput("I swear TopG, I am gonna stop vaping and join the hustlers university");
                break;
            case "tristan1":
                frame.printOutput("Hey Brother, how's life?");
                break;
            case "tristan2":
                frame.printOutput("Hey Brother, here is some money I just wanted to give you because I have too much");
                break;
            case "tristan3":
                frame.printOutput("Hey Brother, give me some money, I wanna buy a new car");
                break;
            case "noTristan":
                frame.printOutput("Tristan is not in this room");
                break;
        }
    }

    /**
     * erstellt String, in welchem alle benötigten Informationen für den User zusammengefasst werden
     *
     * @return der zusammengesetzte String
     */
    public String getInfos() {
        String infos = "Andrew Tate: follower: " + roomController.getAndrewTate().getFollower() + " money: " +
                (int)(roomController.getAndrewTate().getMoney()) + " current location: " + roomController.getCurrentRoomAndrew().getName() +
                "\n" + " Tristan Tate: money: " + (int)(roomController.getTristanTate().getMoney()) + " location: " +
                roomController.getCurrentRoomTristan().getName() + " kids: " + roomController.getTristanTate().getKids();
        return infos;
    }
}