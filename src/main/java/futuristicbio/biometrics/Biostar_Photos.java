/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
 import java.io.File;  
 import java.io.IOException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;


/**
 *
 * @author Futuristic Ltd
 */
public class Biostar_Photos extends javax.swing.JFrame {

    
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
        private Integer user;

    Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaabackground.png");    


   

   
     
    /**
     * Creates new form Biostar_Photos
     */
    public Biostar_Photos() throws IOException {
        initComponents();
        setNewDataPaths();
        cleanTemporaryDirectories();
        initiateImages();
        setUserContext();
        CurrentDate();
    }

     private void setUserContext() {
        context = (UserContext) ThreadLocalStorage.getUserContext();
        //name.setText(context.getUserName() + "");
        userid.setText(context.getUserId() + "");
        
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
     
      public void setNewDataPaths() {

        String path = null;
        Properties prop = new Properties();
        InputStream input = null;
        try {

            //initiate local paths
            String mypath = Biostar_Photos.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            File file = new java.io.File(decodedPath);
            path = file.getParent();
            
            clientPhotosPath = path.concat("\\suprema_photos");
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
     
     public void initiateImages() throws IOException {
        displayPhotograph();
    }

     public void cleanTemporaryDirectories() {
        try {
            FileUtils.cleanDirectory(new File(clientPhotosPath));
        } catch (IOException e) {
            System.err.println("Failed to delete temporary dirs: " + e.getMessage());
            e.printStackTrace();
        }
    }
     
     public Biostar_Photos displayPhotograph() throws IOException {
        System.out.println("Preparing photograph......");

        File directory = new File(clientPhotosPath);
        if (directory.list().length > 0) {
          System.out.println("Not Empty......");
            File file = directory.listFiles()[0];
         
            ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(jLabel22.getWidth(), jLabel22.getHeight(), Image.SCALE_SMOOTH));
            jLabel22.setIcon(imageIcon);
            
        } else {
           System.out.println("Empty......");
            ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pic.png")).getImage().getScaledInstance(jLabel22.getWidth(), jLabel22.getHeight(), Image.SCALE_SMOOTH));
            jLabel22.setIcon(imageIcon);
          
        }

        return this;
    }
     
     public void close3() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        userid = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        roundCorner1 = new SwingClass.RoundCorner();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        fragmentFooter2 = new Fragments.FragmentFooter();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        Lbl_time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(icon);

        jPanel3.setBackground(new java.awt.Color(255, 215, 125));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Details Captured By: ");

        name.setText("Name");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        userid.setText("User ID");
        userid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridActionPerformed(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(0, 82, 155));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 82, 155));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Airport Permit & Identity Management System Biometrics Capture");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userid)
                            .addComponent(name))
                        .addGap(3, 3, 3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(189, 189, 189)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jMenu3.setForeground(new java.awt.Color(204, 0, 153));
        jMenu3.setText("Date");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu3);

        Lbl_time.setForeground(new java.awt.Color(204, 0, 153));
        Lbl_time.setText("Time");
        Lbl_time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(Lbl_time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fragmentFooter2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundCorner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(fragmentFooter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void useridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useridActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        biostar = new BiostarAPI();
        
        try {
            biostar.setApplicantId(applicantId);
            biostar.validateUser();
        } catch (KeyManagementException | NoSuchAlgorithmException | IOException ex) {
            Logger.getLogger(Biostar_Photos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            displayPhotograph();
        } catch (IOException ex) {
            Logger.getLogger(Biostar_Photos.class.getName()).log(Level.SEVERE, null, ex);
        }

   
     
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        UploadAndSave uploadAndSave = new UploadAndSave();
        
        String userId = userid.getText();
       user = Integer.parseInt(userId);
        if (this.verifyResourceBeforeServerPush()) {

            try {
                 JOptionPane.showMessageDialog(this, "Uploading to server", "Information", JOptionPane.INFORMATION_MESSAGE);
                uploadAndSave.uploadPhotoFile(serverPhotoPngPath, clientPhotosPath, applicantId);
                uploadAndSave.updateForm25(applicantId,application_no);
                //uploadAndSave.updatePermitBiometrics(user,applicantId);
                JOptionPane.showMessageDialog(this, "Successfully transfered files to server", "Information", JOptionPane.INFORMATION_MESSAGE);
                dispose();
               BiometricDevices devices = new BiometricDevices();
                devices.displayPhotograph();

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

   
      public void CurrentDate() {

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        jMenu3.setText("Current date : " + day + "/" + (month + 1) + "/" + year);

        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        Lbl_time.setText("Current time is  " + hour + " : " + minute + " : " + second);

    }
    
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
            java.util.logging.Logger.getLogger(Biostar_Photos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biostar_Photos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biostar_Photos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biostar_Photos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Biostar_Photos().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Biostar_Photos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Lbl_time;
    private Fragments.FragmentFooter fragmentFooter2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField name;
    private SwingClass.RoundCorner roundCorner1;
    private javax.swing.JTextField userid;
    // End of variables declaration//GEN-END:variables
}
