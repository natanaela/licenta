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
import javax.swing.JTextArea;
import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import libsvm.svm_parameter;
import libsvm.svm_problem;

/**
 *
 * @author Benten
 */
public class RbfOptimizer {

    static double[] cValues = new double[]{-5, -3, -1, 1, 3, 5, 7, 9, 11, 13, 15};
    static double[] gammaValues = new double[]{-15, -13, -11, -9, -7, -5, -3, -1, 1, 3};

    public static svm_parameter getOptimsForTestFile(svm_problem problem, String testFileData, JTextArea outputString) throws IOException {
        double acuratete = 0; //counter
        double maxAcuratete = 0;
        double cOptim = 0;
        double gammaOptim = 0;
        LoadingLIBSVM.ResultAcurateteAndConfuzie rezultatOptim = new LoadingLIBSVM.ResultAcurateteAndConfuzie();
        svm_model modelOptim = new svm_model();
        for (int i = 0; i < cValues.length; i++) {
            for (int j = 0; j < gammaValues.length; j++) {
                double C = Math.pow(2, cValues[i]);
                double gamma = Math.pow(2, gammaValues[j]);
                acuratete = 0;//resetez counter-ul
                svm_parameter params = getSvmParameters(C, gamma); //crearea parametrilor
                svm_model model = svm.svm_train(problem, params); // scoatem un model din problema=trainData si parametri=parametriModel
                LoadingLIBSVM.ResultAcurateteAndConfuzie rezultat = LoadingLIBSVM.testModelForTestFile(model, testFileData); // returnaza cate labeluri au fost corect gasite
                acuratete = rezultat.acuratete;
                modelOptim = model;
                if (acuratete > maxAcuratete) {
                    maxAcuratete = acuratete;
                    cOptim = C;
                    gammaOptim = gamma;
                    rezultatOptim = rezultat;
                }
            }
        }
        outputString.append("cOptim=" + cOptim + "\ngammaOptim=" + gammaOptim + "\nAcuratete=" + maxAcuratete * 100 + "%"  + "\nnSV= " + suma(modelOptim.nSV)+"%\n");
        outputString.append("Matricea confuzie:\n" + parseMatrixToString(rezultatOptim.confuzie));
        return getSvmParameters(cOptim, gammaOptim);
    }

    public static svm_parameter getParamsForTestFile(svm_problem problem, String testFileData, double C, double gamma, JTextArea outputString) throws IOException {
        svm_parameter params = getSvmParameters(C, gamma); //crearea parametrilor
        svm_model model = svm.svm_train(problem, params); // scoatem un model din problema=trainData si parametri=parametriModel
        LoadingLIBSVM.ResultAcurateteAndConfuzie rezultat = LoadingLIBSVM.testModelForTestFile(model, testFileData); // returnaza cate labeluri au fost corect gasite
        outputString.append("C=" + C + "\ngamma=" + gamma + "\nAcuratete=" + rezultat.acuratete * 100 + "%" + "%\nnSV=" + suma(model.nSV) + "%\n");
        outputString.append("Matricea confuzie:\n" + parseMatrixToString(rezultat.confuzie) + "\n");
        return getSvmParameters(C, gamma);
    }

    private static svm_parameter getSvmParameters(double c, double g) {
        svm_parameter toReturn = new svm_parameter();
        toReturn.kernel_type = 2;//t
        toReturn.svm_type = 0;//s
        toReturn.gamma = g;//g
        toReturn.C = c;//c
        toReturn.eps = 0.001;
        return toReturn;
    }
    
    private static String parseMatrixToString(int[][] confuzie) {
        StringBuilder toReturn = new StringBuilder();
        for (int row = 0; row < confuzie.length; row++) {
            for (int col = 0; col < confuzie[0].length; col++) {
                toReturn.append(confuzie[row][col] + "  ");
            }
            toReturn.append("\n");
        }
        return toReturn.toString();
    }
    
    private static int suma(int[] nSV) {
        int toReturn = 0;
        for (int i : nSV) {
            toReturn += i;
        }
        return toReturn;
    }
}
