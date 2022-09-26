package control;

import model.tf.PredictCmd;
import view.CommandTextfield;
import model.persons.*;

import java.io.IOException;

public class CommandController {
    String cmd;
    private String outputCommand;
    private OutputController outputController;

    public CommandController(){
        cmd = "";
        outputCommand = "";
    }

    public void newOutPutController(OutputController outputController) { this.outputController = outputController; }

    public void controlCommand(String cmd) throws IOException {
        switch (cmd) {
            case "gym":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getGym());
                outputCommand = "goGym";
                break;
            case "mansion":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getMansion());
                outputCommand = "goMansion";
                break;
            case "french brothel":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getFrenchBrothel());
                outputCommand = "goFrenchBrothel";
                break;
            case "garage":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getGarage());
                outputCommand = "goGarage";
                break;
            case "bugatti store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getBugattiStore());
                outputCommand = "goBugattiStore";
                break;
            case "lambo store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getLamboStore());
                outputCommand = "goLamboStore";
                break;
            case "aston martin store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getAstonMartinStore());
                outputCommand = "goAstonMartinStore";
                break;
            case "ferrari store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getFerrariStore());
                outputCommand = "goFerrariStore";
                break;
            case "opel store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getOpelStore());
                outputCommand = "goOpelStore";
                break;
            case "infos":
                outputCommand = "getInfos";
                break;
            case "commands":
                outputCommand = "getCommands";
                break;
            case "have fun":
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "chick" ||
                        outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "Italian chick" ||
                        outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "British chick"
                    )
                    {
                        outputCommand = "haveFun";
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() + 100
                        );
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() - 1000
                        );
                        break;
                    } else { outputCommand = "noChick"; }
                }
                break;
            case "hit nine five":
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "NineFive") {
                        outputCommand = "hitNineFive";
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() + 1000
                        );
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() - 10000
                        );
                        break;
                    } else { outputCommand = "noNineFive"; }
                }
                break;
            case "hit chick":
                for (int i=0; i < outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom().length; i++) {
                    if (outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "chick" ||
                            outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "Italian chick" ||
                            outputController.getRoomController().getCurrentRoomAndrew().getPersonsInRoom()[i] == "British chick"
                    )
                    {
                        outputCommand = "hitChick";
                        outputController.getRoomController().getAndrewTate().setFollower(
                                outputController.getRoomController().getAndrewTate().getFollower() - 1000
                        );
                        outputController.getRoomController().getAndrewTate().setMoney(
                                outputController.getRoomController().getAndrewTate().getMoney() - 100000
                        );
                        break;
                    } else { outputCommand = "noChick"; }
                }
                break;
            case "hit g":
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
            case "buy bugatti":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getBugattiStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getBugattiStore());
                    outputCommand = "bugattiBought";
                }
                break;
            case "buy lambo":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getLamboStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getLamboStore());
                    outputCommand = "lamboBought";
                }
                break;
            case "buy aston martin":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getAstonMartinStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getAstonMartinStore());
                    outputCommand = "astonMartinBought";
                }
                break;
            case "buy ferrari":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getFerrariStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getFerrariStore());
                    outputCommand = "ferrariBought";
                }
                break;
            case "buy opel":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getOpelStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getOpelStore());
                    outputCommand = "opelBought";
                }
                break;
            case "talk to g":
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
            case "talk to chick":
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
            case "talk to nine five":
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
            case "talk to tristan":
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

            /* case "sell bugatti":
                if (
                    outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getBugattiStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().sellCar("newBugatti");
                    outputCommand = "bugattiSold";
                } else { outputCommand = "wrongStore"; }
                break;
            case "sell lambo":
                if (
                        outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getLamboStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().sellCar("newLambo");
                    outputCommand = "lamboSold";
                } else { outputCommand = "wrongStore"; }
                break;
            case "sell aston martin":
                if (
                        outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getAstonMartinStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().sellCar("newAstonMartin");
                    outputCommand = "astonMartinSold";
                } else { outputCommand = "wrongStore"; }
                break;
            case "sell ferrari":
                if (
                        outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getFerrariStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().sellCar("newFerrari");
                    outputCommand = "ferrariSold";
                } else { outputCommand = "wrongStore"; }
                break;
            case "sell opel":
                if (
                        outputController.getRoomController().getCurrentRoomAndrew() == outputController.getRoomController().getOpelStore()
                )
                {
                    outputController.getRoomController().getAndrewTate().sellCar("shit");
                    outputCommand = "opelSold";
                } else { outputCommand = "wrongStore"; }
                break; */
        }
        outputController.controlOutput(outputCommand);
        outputCommand = "";
    }
}