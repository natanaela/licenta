/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

/**
 *
 * @author tudor
 */
public class MyMouseListener implements MouseListener{
    boolean startCroping = false;
    int leftUpX, leftUpY, downRightX, downRightY;
    boolean firtstCornerSelected = false;
    public Interface referintaInterfata;

    int x, y;
    @Override
    public void mouseClicked(MouseEvent e) {
        if (startCroping){

            if (firtstCornerSelected == false){
                leftUpX = e.getX();
                leftUpY = e.getY();
                firtstCornerSelected = true;
            }
            else{
                downRightX = e.getX();
                downRightY = e.getY();
                firtstCornerSelected = false;
                startCroping = false;
                referintaInterfata.setJSPMouseCursor(Cursor.DEFAULT_CURSOR);
                referintaInterfata.scaleImageInput(leftUpX, leftUpY, downRightX, downRightY);
                
            }
            
        }
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    
}
