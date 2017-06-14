/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportImage;

/**
 *
 * @author Benten
 */
public class Step4 {
    public static String etichetePath = "C:\\Octave\\OCTA\\kit_ici_octave modificat de prof\\handwr\\etichete.txt";
    public static String s = "sdfg";
    public static Result run(double[][] C, double[][] x0, int h, int l, int n) {
        Result toReturn = null;
        double[][] x = x0.clone();
        Integer[] O = readLabelsFromFile(etichetePath);
        for (int i = 0 ; i < C.length;i++){ // pt fiecare rand din c
            double ci, cj, wi, wj;
            ci = C[i][0];
            cj = C[i][1];
            wi = C[i][2];
            wj = C[i][3];
            scadex0DinX(x,x0, ci, cj, wi, wj);
        }  
        
        return toReturn;
    }

    private static Integer[] readLabelsFromFile(String etichetePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void scadex0DinX(double[][] x, double[][] x0, double ci, double cj, double wi, double wj) {
    }

    public static class Result {

        public int[] F, C;

        public Result() {
        }
    }

}
