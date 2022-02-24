/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import futuristicbio.biometrics.Example;
import futuristicbio.biometrics.Signature;
import futuristicbio.biometrics.ThreadLocalStorage;
import futuristicbio.biometrics.UploadAndSave;
import futuristicbio.biometrics.CaptureImage;
import futuristicbio.biometrics.NetworkException;
import futuristicbio.biometrics.NewBiometricDevices;
import futuristicbio.biometrics.UserContext;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class FragmentCaptureSignature extends javax.swing.JPanel {
    static Example programExample = null;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
   
    
   String filename = null;
   byte[] person_image = null;
   private byte[] picture;
   private String applicantId;
   private String application_no;
   private String clientSignaturePath;
   private String serverSignPngPath;
   private UserContext context;
   private String user;
   private NewBiometricDevices devices;
    /**
     * Creates new form FragmentCaptureSignature
     */
    public FragmentCaptureSignature() {
        initComponents();
        setNewDataPaths();
        cleanTemporaryDirectories();
       //initiateImages();
       setUserContext();
       //CurrentDate();
    }
     public FragmentCaptureSignature(NewBiometricDevices devices,String application_no,String applicantId,String user) {
         this.devices =devices;
         this.application_no =application_no;
         this.applicantId =applicantId;
         this.user =user;
        initComponents();
        setNewDataPaths();
        cleanTemporaryDirectories();
       //initiateImages();
       setUserContext();
       //CurrentDate();
    }

    
     public void setApplicantId(String applicantId,String application_no) {
        this.applicantId = applicantId;
        this.application_no =application_no;
    }

    public String getApplicantId() {
        return applicantId;
    }
    
    public String getApplication() {
        return application_no;
    }
    
     private void setUserContext() {
        context = (UserContext) ThreadLocalStorage.getUserContext();
        
        //name.setText(context.getUserName() + "");
        //userid.setText(context.getUserId() + "");
        
    }
   
   private void initiateImages() {
        displaySignature();
    }
   
   private void setNewDataPaths() {

        String path = null;
        Properties prop = new Properties();
        InputStream input = null;
        try {

            //initiate local paths
            String mypath = Signature.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            File file = new java.io.File(decodedPath);
            path = file.getParent();
            
            clientSignaturePath = path.concat("\\signatures");
            
            input = Signature.class.getResourceAsStream("/resources/application.properties");
            prop.load(input);
          //serverSignPngPath = prop.getProperty("server.signPngPath");
           serverSignPngPath ="/var/www/html/biopng/";
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't load properties file");
            System.err.println(e.getMessage());
        }
   }
   private void cleanTemporaryDirectories() {

        try {
            File signature = new File(clientSignaturePath);
             if (signature.exists()) {    
            System.out.println(clientSignaturePath);
            FileUtils.cleanDirectory(signature);}
        }catch (IOException e) {
            System.err.println("Failed to delete temporary dirs: " + e.getMessage());
            e.printStackTrace();
        }
   }
   
   private FragmentCaptureSignature displaySignature() {
        System.out.println("Preparing signature......");
        File directory = new File(clientSignaturePath);
        if (directory.list().length > 0) {
            File file = directory.listFiles()[0];
            ImageIcon imageIconSc = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(jLabel23.getWidth(), jLabel23.getHeight(), Image.SCALE_SMOOTH));
            jLabel23.setIcon(imageIconSc);

        } else {
            jLabel23.setIcon(null);
        }

        return this;
    }
   
   
   private boolean verifyResourceBeforeServerPush() {
    File signatureDirectory = new File(clientSignaturePath);
    File[] signlistFiles = signatureDirectory.listFiles();
    System.out.println(signlistFiles.length);
    int size = signlistFiles.length;
    if (size == 0) {
           // JOptionPane.showMessageDialog(null, "Capture all requirements!", "Error", JOptionPane.ERROR_MESSAGE, null);
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
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);

        roundCorner1.setBackground(java.awt.Color.white);

        jButton2.setText("Upload Signature");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setText("Capture Signature");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setText("Signature");

        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(164, 164, 164))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout roundCorner1Layout = new javax.swing.GroupLayout(roundCorner1);
        roundCorner1.setLayout(roundCorner1Layout);
        roundCorner1Layout.setHorizontalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCorner1Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCorner1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundCorner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        UploadAndSave uploadAndSave = new UploadAndSave();
        //String userId = userid.getText();
        Integer userId = Integer.parseInt(user);

        if (this.verifyResourceBeforeServerPush()) {

            try {
                JOptionPane.showMessageDialog(this, "Uploading to server", "Information", JOptionPane.INFORMATION_MESSAGE);
                devices.setForm(new FragmentSignature(devices,applicantId,user,true));
                startThread();
                /*uploadAndSave.uploadSignatureFile(serverSignPngPath, clientSignaturePath, applicantId);
                uploadAndSave.updateForm25(applicantId,application_no);
                uploadAndSave.updatePermitBiometrics(userId,applicantId);
                JOptionPane.showMessageDialog(this, "Successfully transfered files to server", "Information", JOptionPane.INFORMATION_MESSAGE);
                //cleanTemporaryDirectories();
                devices.setForm(new FragmentSignature(devices,application_no,applicantId,user,true));*/
            }catch (Exception e) {
                System.err.println(e.getMessage());
                if (e instanceof NetworkException) {

                    JOptionPane.showMessageDialog(null, "Network is Down, try again later", "Error", JOptionPane.ERROR_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(null, "System failure, contact admin", "Error", JOptionPane.ERROR_MESSAGE, null);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //CaptureImage c = new CaptureImage();
        //c.main(args);
        CaptureImage captureImage = new CaptureImage(applicantId);
        captureImage.Run();
        displaySignature();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

     private  void startThread(){
         SwingWorker sw1 = new SwingWorker() {
        Integer userId = Integer.parseInt(user);

              @Override
            protected String doInBackground() throws Exception 
            {
            UploadAndSave uploadAndSave = new UploadAndSave();
               try{ // define what thread will do here
             uploadAndSave.uploadSignatureFile(serverSignPngPath, clientSignaturePath, applicantId);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel6;
    private SwingClass.RoundCorner roundCorner1;
    // End of variables declaration//GEN-END:variables
}
