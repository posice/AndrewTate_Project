import control.MainController;
import model.tf.PredictCmd;
import view.Frame;
import view.WinningFrame;

public class Main {
    public static void main(String[] args) {
        MainController mc = new MainController();
        mc.control();
    }
}