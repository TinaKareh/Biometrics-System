/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import futuristicbio.biometrics.BiostarAPI;
import futuristicbio.biometrics.Biostar_Photos;
import futuristicbio.biometrics.Example;
import futuristicbio.biometrics.NetworkException;
import futuristicbio.biometrics.NewBiometricDevices;
import futuristicbio.biometrics.SampleLive;
import futuristicbio.biometrics.UploadAndSave;
import futuristicbio.biometrics.UserContext;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Futuristic Ltd
 */
public class FragmentBiostar extends javax.swing.JPanel {

    private BiostarAPI biostar;
    static Example programExample = null;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private String serverPhotoPngPath;
    private String clientPhotosPath;
    private SampleLive sampleLive = null;
    private String applicantId;
    String filename = null;
    byte[] person_image = null;
    private byte[] picture;
    private UserContext context;
    private String application_no;
    private String user;
    private NewBiometricDevices devices;
    /**
     * Creates new form FragmentBiostar
     */
    public FragmentBiostar() throws IOException {
        initComponents();
        setNewDataPaths();
        cleanTemporaryDirectories();
        //initiateImages();
    }
    
     public FragmentBiostar(NewBiometricDevices devices,String application_no,String applicantId,String user) throws IOException {
         this.devices =devices;
         this.application_no =application_no;
        this.applicantId =applicantId;
        this.user = user;
        initComponents();
        setNewDataPaths();
        cleanTemporaryDirectories();
        //initiateImages();
    }

    
    private void setNewDataPaths() {

        String path = null;
        Properties prop = new Properties();
        InputStream input = null;
        try {

            //initiate local paths
            String mypath = Biostar_Photos.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            File file = new java.io.File(decodedPath);
            path = file.getParent();
            
            clientPhotosPath = path.concat("\\photos");
            System.out.println(clientPhotosPath);
            
            input = Biostar_Photos.class.getResourceAsStream("/resources/application.properties");
            prop.load(input);
            
             //serverPhotoPngPath = prop.getProperty("server.photoPngPath");
            //serverPhotoPngPath = "/home/administrator/biopng/photos/";
            serverPhotoPngPath = "/var/www/html/biopng/";

        }catch (IOException e) {
            
            JOptionPane.showMessageDialog(null, "Couldn't load properties file");
            System.err.println(e.getMessage());
        }
    }
     
     private void initiateImages() throws IOException {
        displayPhotograph();
    }

     private void cleanTemporaryDirectories() {
        try {
            FileUtils.cleanDirectory(new File(clientPhotosPath));
        } catch (IOException e) {
            System.err.println("Failed to delete temporary dirs: " + e.getMessage());
            e.printStackTrace();
        }
    }
     
     private FragmentBiostar displayPhotograph() throws IOException {
        System.out.println("Preparing photograph......");

        File directory = new File(clientPhotosPath);
        if (directory.list().length > 0) {
          System.out.println("Not Empty......");
            File file = directory.listFiles()[0];
            ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(jLabel22.getWidth(), jLabel22.getHeight(), Image.SCALE_SMOOTH));
            jLabel22.setIcon(imageIcon);
            
        } else {
           System.out.println("Empty......");
           // ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pic.png")).getImage().getScaledInstance(jLabel22.getWidth(), jLabel22.getHeight(), Image.SCALE_SMOOTH));
            //jLabel22.setIcon(imageIcon);
          
        }

        return this;
    }
     
  
     private boolean verifyResourceBeforeServerPush() {

       
        File photoDirectory = new File(clientPhotosPath);
        File[] photofiles = photoDirectory.listFiles();
      
        if ( photofiles.length < 1) {
            JOptionPane.showMessageDialog(null, "Capture all Photos!", "Error", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }else{
            return true;
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

        roundCorner1 = new SwingClass.RoundCorner();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(java.awt.Color.white);

        roundCorner1.setBackground(java.awt.Color.white);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Capture Photograph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Photograph");

        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );

        jButton2.setText("Upload Photograph");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundCorner1Layout = new javax.swing.GroupLayout(roundCorner1);
        roundCorner1.setLayout(roundCorner1Layout);
        roundCorner1Layout.setHorizontalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundCorner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        biostar = new BiostarAPI();

            biostar.setApplicantId(applicantId);
        try {
            biostar.validateUser();
            displayPhotograph();
        } catch (KeyManagementException ex) {
            Logger.getLogger(FragmentBiostar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FragmentBiostar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FragmentBiostar.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            /*loadingFragment loading = new loadingFragment();
               loading.setVisible(true);*/
       UploadAndSave uploadAndSave = new UploadAndSave();

        Integer userId = Integer.parseInt(user);
        
            if (this.verifyResourceBeforeServerPush()) {
            
            try {
            JOptionPane.showMessageDialog(this, "Uploading to server", "Information", JOptionPane.INFORMATION_MESSAGE);
            /*uploadAndSave.uploadPhotoFile(serverPhotoPngPath, clientPhotosPath, applicantId);
            uploadAndSave.updateForm25(applicantId,application_no);
            uploadAndSave.updatePermitBiometrics(userId,applicantId);
            JOptionPane.showMessageDialog(this, "Successfully transfered files to server", "Information", JOptionPane.INFORMATION_MESSAGE);
            */
            devices.setForm(new FragmentPhoto(devices,applicantId,user,true));
            startThread();
            } catch (Exception e) {
            System.err.println(e.getMessage());
            if (e instanceof NetworkException) {
            
            JOptionPane.showMessageDialog(null, "Network is Down, try again later", "Error", JOptionPane.ERROR_MESSAGE, null);
            } else {
            JOptionPane.showMessageDialog(null, "System failure, contact admin", "Error", JOptionPane.ERROR_MESSAGE, null);
            }
            }
            
            }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private SwingClass.RoundCorner roundCorner1;
    // End of variables declaration//GEN-END:variables

    private  void startThread(){
         SwingWorker sw1 = new SwingWorker() {
        Integer userId = Integer.parseInt(user);

              @Override
            protected String doInBackground() throws Exception 
            {
            UploadAndSave uploadAndSave = new UploadAndSave();
                // define what thread will do here
            try{uploadAndSave.uploadPhotoFile(serverPhotoPngPath, clientPhotosPath, applicantId);
            uploadAndSave.updateForm25(applicantId,application_no);
            uploadAndSave.updatePermitBiometrics(userId,applicantId);
             JOptionPane.showMessageDialog(null,"Successfully transfered files to server", "Information", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e) {
            System.err.println(e.getMessage());
            if (e instanceof NetworkException) {
            
            JOptionPane.showMessageDialog(null, "Network is Down, try again later", "Error", JOptionPane.ERROR_MESSAGE, null);
            } else {
            JOptionPane.showMessageDialog(null, "System failure, contact admin", "Error", JOptionPane.ERROR_MESSAGE, null);
            }
            }
                String res = "Finished Execution";
                return res;
            }
            
            protected void done() 
            {     
            }
        };
         sw1.execute(); 
    }

}
