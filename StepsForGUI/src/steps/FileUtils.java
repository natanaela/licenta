/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steps;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Benten
 */
public class FileUtils {

    public static void writeInFile(String filePath, double[][] mtx) {
         NumberFormat formatter = new DecimalFormat("##.##");
        try {
            PrintWriter writer = new PrintWriter(filePath, "UTF-8");
            for (int row = 0 ; row < mtx.length; row++){
                StringBuilder line = new StringBuilder();
                for( int col = 0 ; col < mtx[row].length; col++){
                    line.append(formatter.format(mtx[row][col]) + "," );
                }
                writer.println(line.toString().substring(0, line.length()-1));     
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void writeFullInFile(String filePath, double[][] mtx) {
        try {
            PrintWriter writer = new PrintWriter(filePath, "UTF-8");
            for (int row = 0 ; row < mtx.length; row++){
                StringBuilder line = new StringBuilder();
                for( int col = 0 ; col < mtx[row].length; col++){
                    line.append(mtx[row][col] + ", " );
                }
                writer.println(line.toString().substring(0, line.length()-2));                    
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
