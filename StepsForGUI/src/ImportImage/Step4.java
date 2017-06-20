/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportImage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractList;
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

    public static Result run(double[][] C, double[][] x0, int h, int l) {
        Result toReturn = new Result();
        double[][] x = x0.clone();
        int nalt, lat;
        List<Double[]> F = new ArrayList<Double[]>(); // tine linii

        Integer[] etichete = readLabelsFromFile(etichetePath);
        for (int i = 0; i < C.length; i++) { // pt fiecare rand din c
            List<Double> ftemp = new ArrayList<>();
            int ci, cj, wi, wj;
            ci = (int) C[i][0];
            cj = (int) C[i][1];
            wi = (int) C[i][2];
            wj = (int) C[i][3];
            double[][] cha = extractCha(x0, ci, cj, wi, wj);
            scadex0DinX(x, x0, ci, cj, wi, wj);
            nalt = wi / h;
            lat = wj / l;

            for (int k1 = 1; k1 <= h; k1++) {
                for (int k2 = 1; k2 <= l; k2++) {
                    int c = countZeros(cha,
                            (k1 - 1) * nalt,
                            k1 * nalt - 1,
                            (k2 - 1) * lat,
                            k2 * lat - 1);
                    ftemp.add(c / (double) (lat * nalt));
                }
            }
            F.add(ftemp.toArray(new Double[ftemp.size()]));
        }
        double[] k = getK(C);
//        double[][] F1;  // tine F transpus
//        F1 = transpuneFsiAddLiniaK(F, k);
        double[][] F2 = addColK(F, k);
//        FileUtils.writeInFile("f1.txt", F1);
//        FileUtils.writeInFile("f2.txt", F2);
//        log.println(F1);
        toReturn.F = F2;
        toReturn.etichete = etichete;
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

    private static Integer countZeros(double[][] cha, int i1, int i2, int j1, int j2) {
        int count = 0;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (cha[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;

    }

    private static double[] getK(double[][] C) {
        double[] toReturn = new double[C.length];
        for (int i = 0; i < C.length; i++) { // fiecare rand din C
            toReturn[i] = C[i][3] / (C[i][2] + C[i][3]);
        }
        return toReturn;

    }

    private static double[][] transpuneFsiAddLiniaK(List<Double[]> F, double[] k) {

        double[][] toReturn = new double[F.get(0).length + 1][k.length];
        for (int F_row_index = 0; F_row_index < F.size(); F_row_index++) { //F_row_index = rand
            Double[] F_row = F.get(F_row_index);
            for (int i = 0; i < F_row.length; i++) { // luam element din F_row, i = coloana
                toReturn[i][F_row_index] = F_row[i];
            }
            toReturn[F_row.length][F_row_index] = k[F_row_index];
        }

        return toReturn;
    }

    private static double[][] addColK(List<Double[]> F, double[] k) {
        double[][] toReturn = new double[F.size()][F.get(0).length  + 1];

        for (int F_row_index = 0; F_row_index < F.size(); F_row_index++) { //F_row_index = rand
            Double[] F_row = F.get(F_row_index);
            for (int i = 0; i < F_row.length; i++) { // luam element din F_row, i = coloana
                toReturn[F_row_index][i] = F_row[i];
            }
            toReturn[F_row_index][F_row.length] = k[F_row_index];
        }

        return toReturn;

    }

    public static class Result {

        public Integer[] etichete;
        public double[][] F;

        public Result() {
        }
    }

}
