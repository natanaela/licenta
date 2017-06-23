/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JTextArea;
import libsvm.*;

/**
 *
 * @author Benten
 */
public class LoadingLIBSVM {
    //incarcarea fisierului care contine pe prima coloana labels si pe celelalte 7 coloane samples
    //Pas1 separi fisierul in doua : train + test  cu ajutorul functiei matlab "parseBDToTxt"
    public static String trainFileData;
    public static String testFileData;
    //public static Double[] inputDataForPrediction = new Double[]{0.5625, 0.17708, 0.70833, 0.40625, 0.55208, 0.78125, 0.28632};

    /**
     * @param args the command line arguments
     */
    public static void test(String[] args) throws Exception {
        svm_problem problem = getProblemFromTrainingDataFile(trainFileData);
        //svm_parameter params = RbfOptimizer.getOptimsForTestFile(problem, testFileData ,new JTextArea()); // luam parametrii cu acuratetea maxima
        //svm_parameter params = LinearOptimizer.getOptimsForTestFile(problem, testFileData,new JTextArea());
        //svm_model model = svm.svm_train(problem, params); // scoatem un model din problema=trainData si parametri=parametriModel
        //double label = testPredict(model, inputDataForPrediction);
        //System.out.println("Rezutatul predictiei de test este:" + label);
    }
    
    //metoda creaza problema cu ajutorul baze de date Train
    public static svm_problem getProblemFromTrainingDataFile(String filePath) throws FileNotFoundException, IOException {
        ArrayList<Double> labels = new ArrayList<>();
        ArrayList<Double[]> values = new ArrayList<>();// lista de siruri de valori, un sir de valori este pt un rand din fisier=un set de valori pt un label
        //citim label si values de pe fiecare linie din fisier 
        FileInputStream fis = new FileInputStream(filePath);//tinem evidenta streamului, ca si capul de citire de pe un harddisk
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        while ((line = br.readLine()) != null) { //citim o linie din stream
            String[] params = line.trim().split(",\\s+");
            labels.add(Double.parseDouble(params[0])); // prima valoare din split pe linie este valoarea labelului
            Double[] v = new Double[params.length - 1];
            for (int i = 1; i < params.length; i++) { // citim restul de valori din split si le punem in values
                v[i - 1] = (Double.parseDouble(params[i]));
            }
            values.add(v);
        }
        br.close();
        svm_problem problem = getProblemFromLabelsAndValues(labels, values);
        return problem;
    }

    //metoda ia fiecare valoare din problema
    private static svm_problem getProblemFromLabelsAndValues(ArrayList<Double> labels, ArrayList<Double[]> values) {
        svm_problem problem = new svm_problem();// obiectul are trei campuri l, y, x
        problem.l = labels.size();
        problem.y = new double[labels.size()];
        for (int i = 0; i < labels.size(); i++) {
            problem.y[i] = labels.get(i);
        }
        problem.x = new svm_node[labels.size()][]; // x este o matrice de valori, un rand va contine un set de values pt un label, nr de randuri=nr de labeluri
        for (int i = 0; i < labels.size(); i++) { // pt fiecare rand
            Double[] v = values.get(i); // v = sir de valori pt un label din iteratie
            problem.x[i] = getNodesArrayFromDoubleArray(v);
        }
        return problem;
    }
    
    private static svm_node[] getNodesArrayFromDoubleArray(Double[] inputData) {
        svm_node[] toReturn = new svm_node[inputData.length];
        for (int i = 0; i < inputData.length; i++) { // pt fiecare double din sir, creem un nod cu index si value intr-un sir de nodes
            toReturn[i] = new svm_node();
            toReturn[i].index = i + 1;
            toReturn[i].value = inputData[i];
        }
        return toReturn;
    }
    
    //metoda folosita pentru testarea predict
    public static double testPredict(svm_model model, Double[] inputDataForPrediction) {
        svm_node[] svm_nds = getNodesArrayFromDoubleArray(inputDataForPrediction);//generez vectorul cu date de test pt predictie
        double raspuns = svm.svm_predict(model, svm_nds);
        return raspuns;
    }
    
    //metoda folosita pentru a citi labels si sampels din baza de date de test
    public static double testModelForTestFile(svm_model model, String testFileData) throws FileNotFoundException, IOException {
        int counterMatched = 0;
        int counterTotal = 0;
        double label;
        Double[] restuParametriiPeLinie;
        FileInputStream fis = new FileInputStream(testFileData);//tinem evidenta streamului, ca si capul de citire de pe un harddisk
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        while ((line = br.readLine()) != null) { //citim o linie din stream
            counterTotal++;
            String[] params = line.trim().split(",\\s+");
            label = (Double.parseDouble(params[0])); // prima valoare din split pe linie este valoarea labelului
            restuParametriiPeLinie = new Double[params.length - 1];
            for (int i = 1; i < params.length; i++) { // citim restul de valori din split si le punem in values
                restuParametriiPeLinie[i - 1] = (Double.parseDouble(params[i]));
            }
            if (matchLabel(label, restuParametriiPeLinie, model)) {
                counterMatched++;
            }
        }
        br.close();
        return counterMatched / (double) counterTotal;
    }
    
    private static boolean matchLabel(double label, Double[] restuParametriiPeLinie, svm_model model) {
        double rezultatPredict = LoadingLIBSVM.testPredict(model, restuParametriiPeLinie);
        return Double.compare(label, rezultatPredict) == 0;
    }
    
}
