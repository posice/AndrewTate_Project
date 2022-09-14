package Model.tf;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlowException;

import java.nio.file.Paths;
import java.util.List;

public class PredictCmd {

    public void doSth() {
        try (SavedModelBundle savedModelBundle = SavedModelBundle.load(System.getProperty("user.dir")+"\\src\\Model\\tf\\model", "serve")) {

            try (Session session = savedModelBundle.session()) {
                Session.Runner runner = session.runner();
                runner.feed("x", Tensor.create(10));
                runner.feed("y", Tensor.create(20));

                List<Tensor> tensors = runner.fetch("ans").run();
                System.out.println("Answer is: " + tensors.get(0).intValue());
            }

        } catch (TensorFlowException ex) {
            ex.printStackTrace();
        }
    }

}
