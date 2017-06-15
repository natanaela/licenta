/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportImage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Benten
 */
public class importImage extends javax.swing.JFrame implements MyLog {

    private BufferedImage img = null;
    private BufferedImage imgPrelucrata = null;
    private double[][] pozaBW = new double[1][1];
    private double[][] step2Result = new double[1][1]; // prima dimensiune este indicele coloana
    private double[][] step3Result = new double[1][1]; // prima dimensiune este indicele rand
    
    /**
     * Creates new form importImage
     */
    public importImage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSP = new javax.swing.JScrollPane();
        loadImgButton = new javax.swing.JButton();
        deleteImgButton = new javax.swing.JButton();
        step1Run = new javax.swing.JButton();
        imgProcSP = new javax.swing.JScrollPane();
        saveImgStep1 = new javax.swing.JButton();
        parametru = new javax.swing.JTextField();
        step2Run = new javax.swing.JButton();
        NrIteratii = new javax.swing.JLabel();
        PragStep1 = new javax.swing.JLabel();
        iteratii = new javax.swing.JTextField();
        meniuLabel = new javax.swing.JLabel();
        initialImgLabel = new javax.swing.JLabel();
        imgProcLabel = new javax.swing.JLabel();
        step3Run = new javax.swing.JButton();
        step4Run = new javax.swing.JButton();
        SVMLabel = new javax.swing.JLabel();
        linearClass = new javax.swing.JRadioButton();
        rbfClass = new javax.swing.JRadioButton();
        coefLabel = new javax.swing.JLabel();
        gammaLabel = new javax.swing.JLabel();
        coefField = new javax.swing.JTextField();
        gammaField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        consola = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loadImgButton.setText("Incarca poza");
        loadImgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImgButtonActionPerformed(evt);
            }
        });

        deleteImgButton.setText("Sterge poza");
        deleteImgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImgButtonActionPerformed(evt);
            }
        });

        step1Run.setText("Generare pas 1");
        step1Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                step1RunActionPerformed(evt);
            }
        });

        saveImgStep1.setText("Save img");
        saveImgStep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImgStep1ActionPerformed(evt);
            }
        });

        parametru.setText("50");
        parametru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parametruActionPerformed(evt);
            }
        });

        step2Run.setText("Generare pas 2");
        step2Run.setActionCommand("Step2");
        step2Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                step2RunActionPerformed(evt);
            }
        });

        NrIteratii.setText("  Nr. Iteratii :");

        PragStep1.setText("Prag :");

        iteratii.setText("50");
        iteratii.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iteratiiActionPerformed(evt);
            }
        });

        meniuLabel.setForeground(new java.awt.Color(0, 51, 255));
        meniuLabel.setText("Meniu");

        initialImgLabel.setForeground(new java.awt.Color(0, 51, 255));
        initialImgLabel.setText("Poza initiala");

        imgProcLabel.setForeground(new java.awt.Color(0, 51, 255));
        imgProcLabel.setText("Poza prelucrata");

        step3Run.setText("Generare pas 3");
        step3Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                step3RunActionPerformed(evt);
            }
        });

        step4Run.setText("Generare pas 4");
        step4Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                step4RunActionPerformed(evt);
            }
        });

        SVMLabel.setForeground(new java.awt.Color(0, 51, 255));
        SVMLabel.setText("Clasificator SVM");

        linearClass.setText("Linear");
        linearClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linearClassActionPerformed(evt);
            }
        });

        rbfClass.setText("RBF");

        coefLabel.setText("coef0=");

        gammaLabel.setText("gamma=");

        coefField.setText("10000");
        coefField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coefFieldActionPerformed(evt);
            }
        });

        consola.setEditable(false);
        consola.setColumns(20);
        consola.setRows(5);
        jScrollPane1.setViewportView(consola);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbfClass)
                            .addComponent(linearClass))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gammaLabel)
                            .addComponent(coefLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(gammaField)
                            .addComponent(coefField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteImgButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(step1Run, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(loadImgButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(step2Run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(PragStep1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(parametru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(saveImgStep1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(NrIteratii, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(iteratii, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(step3Run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(step4Run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(SVMLabel)))
                                .addGap(124, 124, 124)
                                .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(meniuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(320, 320, 320)
                                .addComponent(initialImgLabel)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgProcLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imgProcSP, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meniuLabel)
                    .addComponent(initialImgLabel)
                    .addComponent(imgProcLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loadImgButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteImgButton)
                                .addGap(35, 35, 35)
                                .addComponent(step1Run)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(parametru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saveImgStep1)
                                    .addComponent(PragStep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addComponent(step2Run)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NrIteratii, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iteratii, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(step3Run)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(step4Run))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(SVMLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgProcSP, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linearClass)
                    .addComponent(coefLabel)
                    .addComponent(coefField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbfClass)
                    .addComponent(gammaLabel)
                    .addComponent(gammaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //creez un camp
    JLabel jlab = new JLabel();

    //functie care ma ajuta sa iau o parte din imagine
    private Image ScaledImage(Image img, int w, int h) {
        BufferedImage resizeImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
        Graphics2D g2 = resizeImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizeImage;
    }

    private void loadImgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImgButtonActionPerformed
        //create file chooser
        JFileChooser jfc = new JFileChooser();
        jfc.setSelectedFile(new File("PICT0001_croped.JPG"));
        if (jfc.showOpenDialog(loadImgButton) == JFileChooser.APPROVE_OPTION) {
            img = null;
            try {
                java.io.File f = jfc.getSelectedFile();
                img = ImageIO.read(f);
            } catch (IOException e) {
                System.out.println(e);
            }
            ImageIcon icon = new ImageIcon(ScaledImage(img, jSP.getWidth(), jSP.getHeight()));
            jlab.setIcon(icon);
            //add jLabel to scroll pane
            jSP.getViewport().add(jlab);
        }
    }//GEN-LAST:event_loadImgButtonActionPerformed

    private void deleteImgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImgButtonActionPerformed
        //remove image from jlabel jlab
        jlab.setIcon(null);
    }//GEN-LAST:event_deleteImgButtonActionPerformed

    private void step1RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_step1RunActionPerformed
        int width = img.getWidth();
        int height = img.getHeight();
        imgPrelucrata = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        imgPrelucrata.setData(img.getData());
        int thresh = Integer.parseInt(parametru.getText());
        pozaBW = new double[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color c = new Color(imgPrelucrata.getRGB(x, y));
                int red = c.getRed();
                int pixle = red < thresh ? 0 : 255;
                pozaBW[y][x] = red < thresh ? 0 : red == thresh ? 0.5 : 1; // poza cu prima dimensiune = randuri
                Color cnew = new Color(pixle, pixle, pixle);
                imgPrelucrata.setRGB(x, y, cnew.getRGB());
            }
        }
        ImageIcon icon = new ImageIcon(ScaledImage(imgPrelucrata, jSP.getWidth(), jSP.getHeight()));
        jlab.setIcon(icon);
        //add jLabel to scroll pane
        imgProcSP.getViewport().add(jlab);
    }//GEN-LAST:event_step1RunActionPerformed

    private void saveImgStep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImgStep1ActionPerformed
        JFileChooser jfc = new JFileChooser();
        if (imgPrelucrata != null && jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File f = jfc.getSelectedFile();
                ImageIO.write(imgPrelucrata, "jpg", f);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_saveImgStep1ActionPerformed

    private void parametruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parametruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parametruActionPerformed

    private void step2RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_step2RunActionPerformed
        int iteratie = Integer.parseInt(iteratii.getText());
        step2Result = Step2.run(pozaBW, 1, iteratie);
        step2Result = Step2.run(step2Result, 0, 1);
            
        int height = step2Result.length;
        int  width = step2Result[0].length;
        BufferedImage imgToSHow = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int pixel = (int) step2Result[row][col] * 255;
                Color cnew = new Color(pixel, pixel, pixel);
                imgToSHow.setRGB(col, row, cnew.getRGB());
            }
        }

        ImageIcon icon = new ImageIcon(ScaledImage(imgToSHow, jSP.getWidth(), jSP.getHeight()));
        jlab.setIcon(icon);
        //add jLabel to scroll pane
        imgProcSP.getViewport().add(jlab);
    }//GEN-LAST:event_step2RunActionPerformed

    private void iteratiiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iteratiiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iteratiiActionPerformed

    private void coefFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coefFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coefFieldActionPerformed

    private void step4RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_step4RunActionPerformed
         Step4.Result step4Result = Step4.run(step3Result,pozaBW,4,4,15);
       
    }//GEN-LAST:event_step4RunActionPerformed

    private void step3RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_step3RunActionPerformed
        step3Result = Step3.run(step2Result);
        
    }//GEN-LAST:event_step3RunActionPerformed

    private void linearClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linearClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linearClassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(importImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(importImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(importImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(importImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        importImage myFrame = new importImage();
        myFrame.setTitle("SVM");
        Utils.log = myFrame;
//        Utils.log = new ConsoleLog();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                myFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NrIteratii;
    private javax.swing.JLabel PragStep1;
    private javax.swing.JLabel SVMLabel;
    private javax.swing.JTextField coefField;
    private javax.swing.JLabel coefLabel;
    private javax.swing.JTextArea consola;
    private javax.swing.JButton deleteImgButton;
    private javax.swing.JTextField gammaField;
    private javax.swing.JLabel gammaLabel;
    private javax.swing.JLabel imgProcLabel;
    private javax.swing.JScrollPane imgProcSP;
    private javax.swing.JLabel initialImgLabel;
    private javax.swing.JTextField iteratii;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton linearClass;
    private javax.swing.JButton loadImgButton;
    private javax.swing.JLabel meniuLabel;
    private javax.swing.JTextField parametru;
    private javax.swing.JRadioButton rbfClass;
    private javax.swing.JButton saveImgStep1;
    private javax.swing.JButton step1Run;
    private javax.swing.JButton step2Run;
    private javax.swing.JButton step3Run;
    private javax.swing.JButton step4Run;
    // End of variables declaration//GEN-END:variables

    @Override
    public void println(String str) {
        consola.append(str + "\n");
    }

}
