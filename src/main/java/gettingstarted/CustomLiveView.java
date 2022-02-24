/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gettingstarted;

import edsdk.api.CanonCamera;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class CustomLiveView extends javax.swing.JFrame {
    
    public CustomLiveView(){
    initiateLiveView();
    }

    private void initiateLiveView() {
        final CanonCamera camera = new CanonCamera();
        if (camera.openSession()) {
            if (camera.beginLiveView()) {
//                final JFrame frame = new JFrame("Live view");
                final JLabel label = new JLabel();
                getContentPane().add(label, BorderLayout.CENTER);
                setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosing(final WindowEvent e) {
                        camera.endLiveView();
                        camera.closeSession();
                        CanonCamera.close();
                        
                    }
                });
                setVisible(true);

                try{
                   while (true) {
                    Thread.sleep(50);
                    final BufferedImage image = camera.downloadLiveView();
                    if (image != null) {
                        label.setIcon(new ImageIcon(image));
                        pack();
                        image.flush();
                    }

                }
                }catch(InterruptedException e){
                e.printStackTrace();
                }
             
            }
        
        }

    }

  
}
