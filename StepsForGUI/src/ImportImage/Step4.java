/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportImage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benten
 */
public class Step4 {

    static MyLog log = Utils.log;
    // public static String etichetePath = "C:\\Octave\\OCTA\\kit_ici_octave modificat de prof\\handwr\\etichete.txt";
    public static String etichetePath = "/home/tudor/Downloads/kit_ici_octave/kit_ici_octave/handwr/etichete.txt";

    public static Result run(double[][] C, double[][] x0, int h, int l, int n) {
        Result toReturn = null;
        double[][] x = x0.clone();
        Integer[] etichete = readLabelsFromFile(etichetePath);
        for (int i = 0; i < C.length; i++) { // pt fiecare rand din c
            int ci, cj, wi, wj;
            ci = (int) C[i][0];
            cj = (int) C[i][1];
            wi = (int) C[i][2];
            wj = (int) C[i][3];
            double[][] cha = extractCha(x0, ci, cj, wi, wj);
            scadex0DinX(x, x0, ci, cj, wi, wj);
            if (i == 0) {
                FileUtils.writeInFile("/home/tudor/Downloads/kit_ici_octave/kit_ici_octave/handwr/outputJavaStep4x.txt", x);
            }
        }

        return toReturn;
    }

    private static Integer[] readLabelsFromFile(String etichetePath) {
        List<Integer> etichete = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(etichetePath));

            String line = br.readLine(); // citeste o linie din fisier

            while (line != null) { // cat timp linia nu e goala
                adaugaEtichete(etichete, line); //sparge linia in numere si adauga fiecare numar
                line = br.readLine();
            }

        } catch (Exception e) {
            log.println("Eroare la citire din fisier!");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    log.println("eroare la inchidere buffer de citire din fisier");
                }
            }
        }
        return etichete.toArray(new Integer[1]);
    }

    private static void scadex0DinX(double[][] x, double[][] x0, int ci, int cj, int wi, int wj) {
        for (int i = 0; i < wi; i++) {
            for (int j = 0; j < wj; j++) {
                x[ci + i][cj + j] = 1 - x0[ci + i][cj + j];
            }
        }
    }

    private static void adaugaEtichete(List<Integer> etichete, String line) {
        String[] numereStr = line.split(" ");
        for (String s : numereStr) {
            try {
                etichete.add(Integer.parseInt(s));
            } catch (NumberFormatException ex) {
                log.println("Format eticheta nu este integer!");
            }
        }

    }

    private static double[][] extractCha(double[][] x0, int ci, int cj, int wi, int wj) {
        double[][] toReturn = new double[wi][wj];
        for (int i = 0; i < wi; i++) {
            for (int j = 0; j < wj; j++) {
                toReturn[i][j] = x0[ci + i][cj + j];
            }
        }
        return toReturn;
    }

    public static class Result {

        public int[] F, C;

        public Result() {
        }
    }

}
