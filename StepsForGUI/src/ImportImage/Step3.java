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
        double[][] toReturn;
        toReturn = analysis(step2Result);

        return toReturn;

    }

    private static double[][] analysis(double[][] step2Result) {
        double[][] copyPoza = step2Result.clone();
        ArrayList<Double[]> c = new ArrayList<>();
        int width = copyPoza.length;
        int height = copyPoza[0].length;
        double ci, cj, wi, wj;
        
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                if (copyPoza[col][row] == 0){
                    if(copyPoza[col+1][row]==0 &&copyPoza[col][row+1]==0){//coltul
                        ci=col;
                        cj=row;
                        wi=0;
                        while(copyPoza[col+(int)wi][row]==0)
                            wi=wi+1;
                        wj=0;
                        while(copyPoza[col][row+(int)wj]==0)
                            wj=wj+1;
                        Double[] var = new Double[]{ci,cj,wi,wj};
                        c.add(var);
                    }
                }
            }
        }
        return null;

    }

}
