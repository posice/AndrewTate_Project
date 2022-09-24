package model.tf;

import org.tensorflow.*;
import org.tensorflow.Tensor;

import java.util.List;

public class PredictCmd {

    public int predictAns(String cmd) {

        try (SavedModelBundle model = SavedModelBundle.load(System.getProperty("user.dir")+"\\src\\Model\\tf\\model", "serve")) {

            /*try (Session session = savedModelBundle.session()) {

                Session.Runner runner = session.runner();
                runner.feed("x", Tensor.create(10));
                runner.feed("y", Tensor.create(20));

                List<Tensor> tensors = runner.fetch("ans").run();
                System.out.println("Answer is: " + tensors.get(0).intValue());
            }*/
            return 1;

        } catch (TensorFlowException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

}
