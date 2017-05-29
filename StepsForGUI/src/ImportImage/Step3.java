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

    static double[][] run(double[][] step2Result) {
         ArrayList<Double[]>  temp;
        temp = analysis(step2Result);
        temp = keepAreaUnderThreshold(temp, 100);
        
        double[][] toReturn = null;
        return toReturn;

    }

    private static  ArrayList<Double[]> analysis(double[][] step2Result) {
        double[][] copyPoza = step2Result.clone();
        ArrayList<Double[]> c = new ArrayList<>();
        int width = copyPoza.length;
        int height = copyPoza[0].length;
        Integer ci, cj, wi, wj;
        
       
            for (int row = 0; row < height; row++) {
                 for (int col = 0; col < width; col++) {
                if (copyPoza[col][row] == 0){
                    if(copyPoza[col+1][row]==0 &&copyPoza[col][row+1]==0){//coltul  
                        ci=col;
                        cj=row;
                        wi=0;
                        while(copyPoza[col+wi][row]==0)
                            wi=wi+1;
                        wj=0;
                        while(copyPoza[col][row+wj]==0)
                            wj=wj+1;
                        Double[] var = new Double[]{ci.doubleValue(),cj.doubleValue(),wi.doubleValue(),wj.doubleValue()};
                        System.out.println(String.format("%f, %f, %f, %f", var[0],var[1],var[2],var[3]));
                        c.add(var);
                    }
                }
            }
        }
        return c;

    }

    private static ArrayList<Double[]> keepAreaUnderThreshold( ArrayList<Double[]> aux, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
