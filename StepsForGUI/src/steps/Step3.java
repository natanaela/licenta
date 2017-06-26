/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steps;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Benten
 */
class Step3 {

    static MyLog log = Utils.log;

    static double[][] run(double[][] step2Result) {
        ArrayList<Integer[]> temp;
        temp = analysis(step2Result);
        temp = keepWithAreaOverThreshold(temp, 100);
        Integer[] newRow = getDistinctRow(temp);
        temp = sortRowAfterCornelColumn(temp, newRow);
        double[][] toReturn = new double[temp.size()][4];
        log.println("Matricea C dupa step 3");
        for (int i = 0; i < temp.size(); i++) {
            Integer[] rowArray = temp.get(i);
            toReturn[i][0] = rowArray[0].doubleValue();
            toReturn[i][1] = rowArray[1].doubleValue();
            toReturn[i][2] = rowArray[2].doubleValue();
            toReturn[i][3] = rowArray[3].doubleValue();
            log.println(String.format("%d, %d, %d, %d", 
                    rowArray[0],rowArray[1],
                    rowArray[2], rowArray[3]));
        }
        return toReturn;
    }

    private static ArrayList<Integer[]> analysis(double[][] step2Result) {
        double[][] copyImg = step2Result.clone();
        ArrayList<Integer[]> c = new ArrayList<>();
        int height = copyImg.length;
        int width = copyImg[0].length;
        Integer colColtSt, rowColtSus, latimeCol, latimeRow;       
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (copyImg[row][col] == 0) {
                    if (copyImg[row][col + 1] == 0 && copyImg[row + 1][col] == 0) {//coltul  
                        colColtSt = col;
                        rowColtSus = row;
                        latimeCol = 1;
                        while (copyImg[row][col + latimeCol] == 0) {
                            latimeCol = latimeCol + 1;
                        }
                        latimeRow = 1;
                        while (copyImg[row + latimeRow][col] == 0) {
                            latimeRow = latimeRow + 1;
                        }
                        Integer[] var = new Integer[]{rowColtSus, colColtSt, latimeRow, latimeCol};                        
                        c.add(var);
                    }
                }
            }
        }
        return c;
    }

    private static ArrayList<Integer[]> keepWithAreaOverThreshold(ArrayList<Integer[]> aux, int thresh) {
        ArrayList<Integer[]> toReturn = new ArrayList<>();
        for (Integer[] sir : aux) {
            if (sir[2] * sir[3] > thresh) {
                toReturn.add(sir);
            }
        }
        return toReturn;
    }

    private static Integer[] getDistinctRow(ArrayList<Integer[]> temp) {
        double prag;
        Integer[] D = new Integer[temp.size()];
        int maxim = 0;
        D[0] = -1;
        for (int i = 1; i < temp.size() - 1; i++) {
            D[i] = temp.get(i)[0] - temp.get(i - 1)[0];
            if (D[i] > maxim) {
                maxim = D[i];
            }
        }
        prag = maxim / 2.0;
        for (int i = 1; i < D.length - 1; i++) {
            D[i] = D[i] - prag < 0 ? -1 : D[i] - prag == 0 ? 0 : 1;
        }
        ArrayList<Integer> indexRandNouAux = new ArrayList<>();

        for (int i = 0; i < D.length - 1; i++) {
            if (D[i] > 0) {
                indexRandNouAux.add(i);
            }
        }
        ArrayList<Integer> randNou = new ArrayList<>();
        randNou.add(1);
        for (Integer index : indexRandNouAux) {
            randNou.add(temp.get(index)[0]);
        }
        return randNou.toArray(new Integer[]{0});
    }

    private static ArrayList<Integer[]> sortRowAfterCornelColumn(ArrayList<Integer[]> temp, Integer[] randNou) {
        ArrayList<Integer[]> oc = new ArrayList<Integer[]>();
        int nr_randuri = randNou.length;
        for (int j = 0; j < nr_randuri - 1; j++) {
            ArrayList<Integer[]> t = ordoneazaIntreRanduriDupaColoanaColt(temp, randNou[j], randNou[j + 1]);
            oc.addAll(t);
        }
        ArrayList<Integer[]> t = ordoneazaIntreRanduriDupaColoanaColt(temp, randNou[randNou.length - 1]);
        oc.addAll(t);
        return oc;
    }

    private static ArrayList<Integer[]> ordoneazaIntreRanduriDupaColoanaColt(ArrayList<Integer[]> c, Integer... par) {
        Integer st = par[0];
        Integer en = 0;
        boolean isLastRow = true;
        if (par.length > 1) {
            isLastRow = false;
            en = par[1];
        }
        ArrayList<Integer[]> bloc = new ArrayList<>();
        for (Integer[] randDinMatrice : c) {
            if ((isLastRow && randDinMatrice[0] >= st)
                    || (!isLastRow && randDinMatrice[0] < en && randDinMatrice[0] >= st)) {
                bloc.add(randDinMatrice);
            }
        }
        bloc.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        return bloc;
    }

}
