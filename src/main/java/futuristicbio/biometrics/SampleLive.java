/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import Fragments.FragmentEpson;
import edsdk.api.CanonCamera;
import edsdk.utils.CanonConstants;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author HP
 */
public class SampleLive extends javax.swing.JFrame {

    /**
     * Creates new form SampleLive
     */
    private String clientPhotosPath;
    private final String applicantId;
    private final BackgroundWorker bgWorker;
   // private final Applicant applicant;
    private boolean streamLiveView;
    private final FragmentEpson photo;


    public SampleLive(FragmentEpson photo){
        this.applicantId = photo.getApplicantId();
        this.photo = photo;
        streamLiveView = true;
        setPhotosPath();
        bgWorker = new BackgroundWorker();
        bgWorker.start();
    }

    public BackgroundWorker getBgWorker() {
        return bgWorker;
    }

    public void setPhotosPath() {

        String path = null;
        try {
            String mypath = Epson_Photo.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            java.io.File file = new java.io.File(decodedPath);
            path = file.getParent();
            clientPhotosPath = path.concat("\\photos");

        } catch (java.lang.Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public class BackgroundWorker extends SwingWorker<Void, BufferedImage> {

        final CanonCamera camera = new CanonCamera();

        @Override
        protected Void doInBackground() throws Exception {
            try {

                while (streamLiveView) {
                    if (!streamLiveView) {
                        break;
                    }
                    Thread.sleep(50);

                    final BufferedImage image = camera.downloadLiveView();

                    if (image != null) {
                        publish(image);
                    }
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("completed background process");
            return null;
        }

        @Override
        protected void process(List<BufferedImage> list) {

            BufferedImage image = list.get(list.size() - 1);
            jLabel1.setIcon(new ImageIcon(image));
            pack();
            image.flush();

        }

        @Override
        protected void done() {

            System.out.println("Running done method");
            camera.endLiveView();
            camera.closeSession();

            dispose();

        }

        public void start() {
            initComponents();

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {

                    terminateLiveView();

                }
            });

            if (camera.openSession()) {
                System.out.println(".....Opened camera session");
                if (camera.beginLiveView()) {
                    System.out.println("Stream live view set to: " + streamLiveView);
                    System.out.println(".....Initiated live view");
                    setVisible(true);
                    execute();
                } else {
                    System.err.println("Couldn't begin live view");
                }
            } else {
                System.err.println("camera session closed");
                JOptionPane.showMessageDialog(null, "Ensure camera is on", "Error", JOptionPane.ERROR_MESSAGE, null);

            }

        }

        public void zoomIn() {
            camera.setLiveViewZoomRatio(CanonConstants.EdsEvfZoom.kEdsEvfZoom_x5);
        }

        public void zoomOut() {
            camera.setLiveViewZoomRatio(CanonConstants.EdsEvfZoom.kEdsEvfZoom_Fit);
        }

        public void cropAndSave() {
            int x = 1727;
            int y = 550;
            int w = 1850;
            int h = 2130;
            final File[] photos = camera.shoot(CanonConstants.EdsSaveTo.kEdsSaveTo_Host);
            if (photos != null) {
                System.out.println("Camera took " + photos.length + " photos");
                File f = photos[0];
                try {
                    BufferedImage bufferedImage = ImageIO.read(photos[0]);
                    BufferedImage out = bufferedImage.getSubimage(x, y, w, h);
                    FileUtils.cleanDirectory(new File(clientPhotosPath));
                    File dest = new File(clientPhotosPath + "\\" + applicantId + "_" + f.getName());
                    ImageIO.write(out, "jpg", dest);
                    photo.displayPhotograph();

                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();

                } catch (RasterFormatException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Configure camera image quality!", "Error", JOptionPane.ERROR_MESSAGE, null);
                } finally {

                    terminateLiveView();

                }

            }

        }

        public void terminateLiveView() {
            streamLiveView = false;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/camera.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/zoom_out(1).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/zoom_best_fit.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        bgWorker.cropAndSave();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        bgWorker.zoomIn();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        bgWorker.zoomOut();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SampleLive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SampleLive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SampleLive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SampleLive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SampleLive(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
