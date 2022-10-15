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
import java.util.Random;

public class PredictCmd {
    /**
     * Attribute: JSON-Object -> Datei (intents.json)
     * JSON-Array -> (intents, wrds, classes <-- aus intents.json)
     * numOfInputs -> int (Länge der wrds-Liste)
     * ComputationGraph -> model (model.h5 geladen als (tf-)Graph)
     */
    private JSONObject jsonObject;
    private JSONArray intents;
    private JSONArray wrds;
    private JSONArray classes;
    private int numOfInputs;
    private ComputationGraph model;

    /**
     * Konstruktor (construct):
     * Lädt: die JSON & model.h5 (KI)
     * Bei Error: Ausgabe in der Konsole, KEIN ABSTURZ, funktioniert dann trotzdem nicht
     */
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

        try{
            wrds = jsonObject.getJSONArray("words");
            classes = jsonObject.getJSONArray("classes");
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }

        try {
            for(int i = 0; i < intents.length(); i++)
                numOfInputs += intents.getJSONObject(i).getJSONArray("input").length();
            numOfInputs = wrds.length();
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

    /**
     * Die Methode gibt die wahrscheinlichste Ausgabe anhand des User-Inputs als Index in der JSON aus.
     * @param cmd: Eingabe vom User
     * @return : Index der wahrscheinlichsten Ausgabe, sonst -1 (sofern alle wahrscheinlichkeiten <0.4)
     */

    public int predictAns(String cmd){
        INDArray input = Nd4j.create(stringToFloatArray(cmd));
        INDArray[] output = model.output(input);

        float[] out = new float[Integer.parseInt("" + output[0].length())];

        int maxIndex = -1;
        for(int i = 0; i < output[0].length(); i++){
            out[i] = output[0].getFloat(i) < 0.1 ? 0 : output[0].getFloat(i);
            maxIndex = out[i] > maxIndex ? i : maxIndex;
        }
        return out[maxIndex] < 0.4 ? -1 : maxIndex;
    }

    /**
     * Bekommt einen Index i, wonach in der JSON die richtige Klasse (index -> Class (String))
     * @param i : Index der Klasse
     * @return : String der Klasse, bei -1 = "none"
     */
    public String getClassFromInt(int i){
        return i == -1 ? "none" : jsonObject.getJSONArray("classes").getString(i);
    }

    /**
     * Bekommt den User-Input von predictAns und gibt mithilfe einer for-Schleife ein float-Array
     * zurück. Ferner: (siehe @return)
     * @param cmd : Eingabe des Users (aufgerufen von predictAns)
     * @return float-Array : 1, wenn das Wort vorkommt, sonst 0 (wenn Wort vom User == das Wort in words (JSON)
     */
    private float[][] stringToFloatArray(String cmd){
        float[][] f = new float[1][numOfInputs];
        int ti = 0;
        for(int i = 0; i < wrds.length(); i++){
            f[0][ti] = cmd.contains(wrds.getString(i)) ? 1 : 0;
            ti++;
        }
        return f;
    }
}
