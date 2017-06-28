/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steps;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author tudor
 */
public class MyPanel  extends JPanel{
    public   ImageIcon img;


    public MyPanel(){};
    
    public void setImg(ImageIcon img){
        this.img = img;
    }
    
    public void paintComponent(Graphics g){
        if (img != null){
            g.clearRect(0, 0, getWidth(), getHeight());
            g.drawImage(img.getImage(), 0, 0, this);
        }
    }
    
}
