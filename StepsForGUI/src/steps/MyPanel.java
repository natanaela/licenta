/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steps;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author tudor
 */
public class MyPanel extends JPanel {

    public ImageIcon img;
    double scalareX, scalareY;

    public MyPanel() {
    }

    ;
    
    public void setImg(BufferedImage img) {
        scalareX = getWidth() / (double)img.getWidth();
        scalareY = getHeight() / (double) img.getHeight();
        ImageIcon icon = new ImageIcon(ScaledImage(img, getWidth(), getHeight()));
        this.img = icon;
    }

    public void paintComponent(Graphics g) {
        if (img != null) {
            g.clearRect(0, 0, getWidth(), getHeight());
            g.drawImage(img.getImage(), 0, 0, this);
        }
    }

    private Image ScaledImage(Image img, int w, int h) {
        BufferedImage resizeImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
        Graphics2D g2 = resizeImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizeImage;
    }

}
