package control;

public class CommandController {
    boolean newCmd = false;
    String cmd = "";

    public void newCommand(String cmd){
        this.cmd = cmd;
        newCmd = true;
    }

}
