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
public class Step2 {

    public static double[][] run(double[][] pozaBW, int segm, int steps) {
        double[][] w, copyPoza, aux;
        w = new double[pozaBW.length][pozaBW[0].length];
        aux = new double[pozaBW.length][pozaBW[0].length];
        copyPoza = pozaBW.clone();
        int width = copyPoza.length;
        int height = copyPoza[0].length;
        int sus, jos, dreapta, stanga;
        double  sign;
        double a, b, si;
        if (segm == 1) {
            a = 2;
            b = -4.5;
            si = 1;
        } else {
            a = -4;
            b = -0.5;
            si = -1;
        }
        for (int step = 0; step < steps; step++) {
            for (int col = 0; col < width; col ++ ){
                for (int row = 0; row < height ; row++){
                    sus = row - 1;
                    jos = row +1;
                    stanga = col -1;
                    dreapta = col + 1;
                    if (sus < 0) sus = height-1; 
                    if (jos > height-1) jos = 0;
                    if (stanga < 0) stanga = width-1;
                    if ( dreapta > width -1) dreapta = 0;
                    w[col][row] = a * copyPoza[col][row] + b + copyPoza[col][sus] +copyPoza[col][jos] +copyPoza[stanga][row] +copyPoza[dreapta][row];
                    sign = (w[col][row] * si)<0.0 ? -1.0 : (w[col][row] * si)>0? 1.0 : 0.0; 
                    aux[col][row] = (sign + 1 ) / 2;
                }
            }
            copyPoza = aux;

        }

        return copyPoza;
    }

}
