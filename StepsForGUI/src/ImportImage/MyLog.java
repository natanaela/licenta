/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportImage;

import java.util.List;

/**
 *
 * @author Benten
 */
public interface MyLog {
    
    <T> void println(T t);
    
    <T> void  println(List<T> list);
    
     void println(double[][] d);
}
