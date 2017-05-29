/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportImage;

import java.util.ArrayList;

/**
 *
 * @author Benten
 */
class Step3 {

    static MyLog log = Utils.log;

    static double[][] run(double[][] step2Result) {
        ArrayList<Integer[]> temp;
        temp = analysis(step2Result);
        temp = keepWithAreaUnderThreshold(temp, 100);
        Integer[] randNou = getDistinctRow(temp);
        log.println(" nr rand nou = " + randNou.length);
        double[][] toReturn = null;
        return toReturn;

    }

    private static ArrayList<Integer[]> analysis(double[][] step2Result) {
        double[][] copyPoza = step2Result.clone();
        ArrayList<Integer[]> c = new ArrayList<>();
        int width = copyPoza.length;
        int height = copyPoza[0].length;
        Integer colColtSt, rowColtSus, latimeCol, latimeRow;
        log.println("Matricea C dupa analysis");

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (copyPoza[col][row] == 0) {
                    if (copyPoza[col + 1][row] == 0 && copyPoza[col][row + 1] == 0) {//coltul  
                        colColtSt = col;
                        rowColtSus = row;
                        latimeCol = 0;
                        while (copyPoza[col + latimeCol][row] == 0) {
                            latimeCol = latimeCol + 1;
                        }
                        latimeRow = 0;
                        while (copyPoza[col][row + latimeRow] == 0) {
                            latimeRow = latimeRow + 1;
                        }
                        Integer[] var = new Integer[]{rowColtSus, colColtSt, latimeRow, latimeCol};
                        log.println(String.format("%d, %d, %d, %d", rowColtSus, colColtSt, latimeRow, latimeCol));
                        c.add(var);
                    }
                }
            }
        }
        return c;

    }

    private static ArrayList<Integer[]> keepWithAreaUnderThreshold(ArrayList<Integer[]> aux, int thresh) {
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

}
