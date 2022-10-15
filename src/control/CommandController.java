package control;

import model.tf.PredictCmd;
import view.CommandTextfield;
import model.persons.*;

import java.io.IOException;

public class CommandController {

    /**
     * Klasse zum Empfangen der Commands der User
     */

    String cmd;
    PredictCmd cm = new PredictCmd();
    private String outputCommand;
    private OutputController outputController;

    public CommandController(){
        cmd = "";
        outputCommand = "";
    }

    public void newOutputController(OutputController outputController) { this.outputController = outputController; }

    /**
     * Methode zum Verwalten der Commands
     * für jedes case wird outputCommnand für den outputController vorbereitet
     * bei Interaktionen mit Personen und Kaufen von Autos wird das Model angepasst
     * outputController.controlOutput wird danach aufgerufen
     * @param inp wird von predictCmd analysiert
     * @throws IOException
     */
    public void controlCommand(String inp) throws IOException {
        String cmd = cm.getClassFromInt(cm.predictAns(inp));
        switch (cmd) { //cmd aus Textfield
            case "none":
                outputCommand = "";
                break;
            case "gtgym":
                outputCommand = "goGym";
                break;
            case "gtmansion":
                outputCommand = "goMansion";
                break;
            case "gtfrenchbrothel":
                outputCommand = "goFrenchBrothel";
                break;
            case "gtgarage":
                outputCommand = "goGarage";
                break;
            case "gtbugattistore":
                outputCommand = "goBugattiStore";
                break;
            case "gtlambostore":
                outputCommand = "goLamboStore";
                break;
            case "gtastonmartinstore":
                outputCommand = "goAstonMartinStore";
                break;
            case "gtferraristore":
                outputCommand = "goFerrariStore";
                break;
            case "gtopelstore":
                outputCommand = "goOpelStore";
                break;
            case "get_infos":
                outputCommand = "getInfos";
                break;
            case "commands":
                outputCommand = "getCommands";
                break;
            case "have_fun": //SEX
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "chick" ||
                        outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "Italian chick" ||
                        outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "British chick"
                    )  //jede Art Chick
                    {
                        outputCommand = "haveFun";
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() + 100
                        ); //mehr Follower
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() - 1000
                        ); //Chick will Geld (keine Prostitution)
                        break;
                    } else { outputCommand = "noChick"; } // wenn chick nicht im room ändert sich cmd
                }
                break;
            case "hit_nine_five": // nine five schlagen
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "NineFive") { //wenn nine five im zimmer ist
                        outputCommand = "hitNineFive";
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() + 1000
                        ); //neue follower
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() - 15000
                        ); //weniger geld
                        break;
                    } else { outputCommand = "noNineFive"; }
                }
                break;
            case "hit_chick":
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "chick" ||
                        outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "Italian chick" ||
                        outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "British chick"
                    ) //wenn chick im zimmer ist
                    {
                        outputCommand = "hitChick";
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() - 1000
                        ); //weniger follower
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() - 100000
                        ); //weniger Geld
                        break;
                    } else { outputCommand = "noChick"; }
                }
                break;
            case "hit_g":
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "G") {
                        outputCommand = "hitG";
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() - 1
                        );
                        break;
                    } else { outputCommand = "noG"; }
                }
                break;
            case "buy_bugatti":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getBugattiStore()
                ) //nur wenn in bugatti store
                {
                    outputController.getRoomController().getAndrewTate().newCar(
                            outputController.getRoomController().getBugattiStore()
                    ); // neues auto
                    outputCommand = "bugattiBought";
                }
                break;
            case "buy_lambo":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getLamboStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getLamboStore());
                    outputCommand = "lamboBought";
                }
                break;
            case "buy_aston_martin":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getAstonMartinStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getAstonMartinStore());
                    outputCommand = "astonMartinBought";
                }
                break;
            case "buy_ferrari":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getFerrariStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getFerrariStore());
                    outputCommand = "ferrariBought";
                }
                break;
            case "buy_opel":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getOpelStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getOpelStore());
                    outputCommand = "opelBought";
                }
                break;
            case "talk_to_g":
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "G") {
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() + 100
                        );
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() + 5000
                        );
                        outputCommand = "talkG";
                        break;
                    } else { outputCommand = "noG"; }
                }
                break;
            case "talk_to_chick":
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "chick" ||
                        outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "Italian chick" ||
                        outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "British chick"
                    )
                    {
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() + 100
                        );
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() - 500
                        );
                        if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "British chick") {
                            outputCommand = "talkBritishChick";
                        } else if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "Italian chick") {
                            outputCommand = "talkItalianChick";
                        } else if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "chick") {
                            outputCommand = "talkChick";
                        }
                        break;
                    } else { outputCommand = "noChick"; }
                }
                break;
            case "talk_to_ninefive":
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "NineFive") {
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() + 1000
                        );
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() + 1000
                        );
                        outputCommand = "talkNineFive";
                        break;
                    } else { outputCommand = "noNineFive"; }
                }
                break;
            case "talk_to_tristan":
                int randomN = (int)(Math.random()*10);
                if (outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getCurrentRoomTristan()) {
                    if (randomN < 4) {
                        outputCommand = "tristan1";
                    } else if (randomN < 7) {
                        outputCommand = "tristan2";
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() + (int) (Math.random() * 1000)
                        );
                    } else if (randomN < 9) {
                        outputCommand = "tristan3";
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() - (int)(Math.random()*1000)
                        );
                    }

                    outputController.getRoomController().getAndrewTate().setFollower(
                            outputController.getRoomController().getAndrewTate().getFollower() + 100
                    );
                    outputController.getRoomController().setRandomRoom(
                            outputController.getRoomController().getTristanTate()
                    );

                } else { outputCommand = "noTristan"; }
        }
        outputController.controlOutput(outputCommand);
        outputCommand = ""; //outputCommand ist null, sodass man nicht einfach irgendwas eingeben kann
    }
}