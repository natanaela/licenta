/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steps;

/**
 *
 * @author Benten
 */
public class Step2 {

    public static double[][] run(double[][] imgBW, int segm, int steps) {
        double[][] w, copyImg, aux;
        w = new double[imgBW.length][imgBW[0].length];
        aux = new double[imgBW.length][imgBW[0].length];
        copyImg = imgBW.clone();
        int height = copyImg.length;
        int width = copyImg[0].length;
        int up, down, right, left;
        double sign;
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
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    up = row - 1;
                    down = row + 1;
                    left = col - 1;
                    right = col + 1;
                    if (up < 0) {
                        up = height - 1;
                    }
                    if (down > height - 1) {
                        down = 0;
                    }
                    if (left < 0) {
                        left = width - 1;
                    }
                    if (right > width - 1) {
                        right = 0;
                    }
                    w[row][col] = a * copyImg[row][col] + b
                            + copyImg[up][col] + copyImg[down][col]
                            + copyImg[row][left] + copyImg[row][right];
                    sign = (w[row][col] * si) < 0.0 ? -1.0 : (w[row][col] * si) > 0 ? 1.0 : 0.0;
                    aux[row][col] = (sign + 1) / 2;
                }
            }
            copyImg = aux;           
        }
        return copyImg;
    }

}
