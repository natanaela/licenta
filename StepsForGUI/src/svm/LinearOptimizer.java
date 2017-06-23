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
public class LinearOptimizer {
    
    static double[] cValues = new double[]{-5, -3, -1, 1, 3, 5, 7, 9, 11, 13, 15};

    public static svm_parameter getOptimsForTestFile(svm_problem problem, String testFileData, JTextArea outputString) throws IOException {
        double acuratete; //counter
        double maxAcuratete = 0;
        double cOptim = 0;
        for (int i = 0; i < cValues.length; i++) {
            double C = Math.pow(2, cValues[i]);
            acuratete = 0;//resetez acuratetea
            svm_parameter params = getSvmParameters(C); //crearea parametrilor
            svm_model model = svm.svm_train(problem, params); // scoatem un model din problema=trainData si parametri=parametriModel
            acuratete = LoadingLIBSVM.testModelForTestFile(model, testFileData);
            //System.out.println("***************************** c=" + C + " acuratete=" + acuratete + "***************************");
            if (acuratete > maxAcuratete) {
                maxAcuratete = acuratete;
                cOptim = C;
            }
        }
        //System.out.println("=========================== cOptim=" + cOptim +"==========================================================");
        outputString.append("cOptim=" + cOptim + "\nAcuratete=" + maxAcuratete * 100 + "%\n");
        return getSvmParameters(cOptim);
    }

    public static svm_parameter getParamsForTestFile(svm_problem problem, String testFileData, double C, JTextArea outputString) throws IOException {
        double acuratete = 0; //counter
        svm_parameter params = getSvmParameters(C); //crearea parametrilor
        svm_model model = svm.svm_train(problem, params); // scoatem un model din problema=trainData si parametri=parametriModel
        acuratete = LoadingLIBSVM.testModelForTestFile(model, testFileData); // returnaza cate labeluri au fost corect gasite
        outputString.append("C=" + C + "\nAcuratete=" + acuratete * 100 + "%\n");
        return getSvmParameters(C);
    }
    
    private static svm_parameter getSvmParameters(double c) {
        svm_parameter toReturn = new svm_parameter();
        toReturn.kernel_type = 0;//t
        toReturn.svm_type = 0;//s
        toReturn.C = c;//c
        toReturn.eps = 0.001;
        return toReturn;
    }
    
}
