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
public class ConsoleLog implements MyLog{

    @Override
    public void println(String str) {
        System.out.println(str);
    }
    
}
