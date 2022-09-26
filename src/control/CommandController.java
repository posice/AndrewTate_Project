package control;

import model.tf.PredictCmd;
import view.CommandTextfield;
import model.persons.*;

import java.io.IOException;

public class CommandController {
    PredictCmd cm = new PredictCmd();
    String cmd;
    private String outputCommand;
    private OutputController outputController;

    public CommandController(){
        cmd = "";
        outputCommand = "";
    }

    public void newOutPutController(OutputController outputController) { this.outputController = outputController; }

    public void controlCommand(String inp) throws IOException {
        String cmd = cm.getClassFromInt(cm.predictAns(inp));
        System.out.println("cmd: " + cmd + " - " + inp);
        switch (cmd) {
            case "gtgym":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getGym());
                outputCommand = "goGym";
                break;
            case "gtmansion":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getMansion());
                outputCommand = "goMansion";
                break;
            case "gtfrenchbrothel":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getFrenchBrothel());
                outputCommand = "goFrenchBrothel";
                break;
            case "garage":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getGarage());
                outputCommand = "goGarage";
                break;
            case "bugatti_store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getBugattiStore());
                outputCommand = "goBugattiStore";
                break;
            case "lambo_store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getLamboStore());
                outputCommand = "goLamboStore";
                break;
            case "aston_martin_store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getAstonMartinStore());
                outputCommand = "goAstonMartinStore";
                break;
            case "ferrari_store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getFerrariStore());
                outputCommand = "goFerrariStore";
                break;
            case "opel_store":
                outputController.getRoomController().setCurrentRoomAndrew(outputController.getRoomController().getOpelStore());
                outputCommand = "goOpelStore";
                break;
            case "get_infos":
                outputCommand = "getInfos";
                break;
            case "commands":
                outputCommand = "getCommands";
                break;
            case "have_fun":
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
                break; //Hier weitermachen
            case "hit_nine_five":
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
                )
                {
                    outputController.getRoomController().getAndrewTate().newCar(outputController.getRoomController().getBugattiStore());
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
        }
        outputController.controlOutput(outputCommand);
        outputCommand = "";
    }
}