import control.MainController;
import model.tf.PredictCmd;
import view.Frame;

public class Main {
    static MainController mc = new MainController();
    public static void main(String[] args) {
        mc.control();
    }
}