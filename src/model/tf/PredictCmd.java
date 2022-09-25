package model.tf;

import org.apache.commons.io.IOUtils;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class PredictCmd {
    JSONObject jsonObject;
    JSONArray intents;
    int numOfInputs;
    ComputationGraph model;

    public PredictCmd(){
        try{
            InputStream is = new FileInputStream(System.getProperty("user.dir") + "\\src\\model\\tf\\model\\intents.json");
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            jsonObject = new JSONObject(jsonTxt);
            intents = jsonObject.getJSONArray("intents");
        }catch (Exception e){
            System.out.println("Error: Could not load JSON File, so the AI couldn't do ANY predictions!");
            System.out.println("Exception:" + e);
        }

        try {
            for(int i = 0; i < intents.length(); i++)
                numOfInputs += intents.getJSONObject(i).getJSONArray("input").length();
        }catch (Exception e){
            System.out.println("Exception:" + e);
        }

        try{

            String executionPath = System.getProperty("user.dir");
            model = KerasModelImport.importKerasSequentialModelAndWeights(executionPath.replace("\\", "\\") + "\\src\\model\\tf\\model\\model.h5").toComputationGraph();
        }catch(Exception e){
            System.out.println("Error: Could not load model (h5)");
            System.out.println("Exception: " + e);
        }
    }

    public int predictAns(String cmd){
        INDArray input = Nd4j.create(stringToFloatArray(cmd));
        INDArray[] output = model.output(input);
        System.out.println("Test " + output[0]);

        float[] out = new float[Integer.parseInt("" + output[0].length())];
        for(int i = 0; i < output[0].length(); i++) out[i] = output[0].getFloat(i) < 0.1 ? 0 : output[0].getFloat(i);
        for(int i = 0; i < out.length; i++) System.out.print(" - " + out[i]);
        return 1;
    }

    private float[][] stringToFloatArray(String cmd){
        float[][] f = new float[1][numOfInputs];
        int ti = 0;
        for(int i = 0; i < intents.length(); i++){
            JSONArray ja = intents.getJSONObject(i).getJSONArray("input");
            for(int j = 0; j < ja.length(); j++){
                f[0][ti] = cmd.contains(ja.getString(j)) ? 1 : 0;
                System.out.println(f[0][ti]);
                ti++;
            }
        }
        return f;
    }
}
