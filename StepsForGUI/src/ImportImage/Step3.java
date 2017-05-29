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
         ArrayList<Double[]>  temp;
        temp = analysis(step2Result);
        temp = keepWithAreaUnderThreshold(temp, 100);
        int distinctRow = countDistinctRow(temp);
        double[][] toReturn = null;
        return toReturn;

    }

    private static  ArrayList<Double[]> analysis(double[][] step2Result) {
        double[][] copyPoza = step2Result.clone();
        ArrayList<Double[]> c = new ArrayList<>();
        int width = copyPoza.length;
        int height = copyPoza[0].length;
        Integer colColtSt, rowColtSus, latimeCol, latimeRow;
            log.println("Matricea C dupa analysis");
       
            for (int row = 0; row < height; row++) {
                 for (int col = 0; col < width; col++) {
                if (copyPoza[col][row] == 0){
                    if(copyPoza[col+1][row]==0 &&copyPoza[col][row+1]==0){//coltul  
                        colColtSt=col;
                        rowColtSus=row;
                        latimeCol=0;
                        while(copyPoza[col+latimeCol][row]==0)
                            latimeCol=latimeCol+1;
                        latimeRow=0;
                        while(copyPoza[col][row+latimeRow]==0)
                            latimeRow=latimeRow+1;
                        Double[] var = new Double[]{rowColtSus.doubleValue(),colColtSt.doubleValue(),latimeRow.doubleValue(),latimeCol.doubleValue()};
                        log.println(String.format("%d, %d, %d, %d", rowColtSus,colColtSt,latimeRow,latimeCol));
                        c.add(var);
                    }
                }
            }
        }
        return c;

    }

    private static ArrayList<Double[]> keepWithAreaUnderThreshold( ArrayList<Double[]> aux, int i) {
return null;
    }

    private static int countDistinctRow(ArrayList<Double[]> temp) {
        return 0;
    }

}
