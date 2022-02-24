/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import com.mysql.jdbc.Connection;
import futuristicbio.biometrics.BiometricDevices;
import futuristicbio.biometrics.Biostar_Photos;
import futuristicbio.biometrics.CrudOperations;
import futuristicbio.biometrics.DBConnect;
import futuristicbio.biometrics.Epson_Photo;
import futuristicbio.biometrics.NewBiometricDevices;
import futuristicbio.biometrics.TestWebcam;
import futuristicbio.biometrics.UserContext;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Futuristic Ltd
 */
public class FragmentPhoto extends javax.swing.JPanel {
    private String applicantId;
    private String application_no;
    private String first_name;
    private String last_name;
    private String operator_name;
    private String job_position;
    private String readdate;
    private String applicant;
    private UserContext context;
    ArrayList<String> photo = new ArrayList<String>();
    ArrayList<String> fingerprint = new ArrayList<String>();
    ArrayList<String> signature = new ArrayList<String>();
    private NewBiometricDevices devices;
    private String user;
    private boolean selected = false;
   loadingFragment loading = new loadingFragment();
    private JDialog d ;

    /**
     * Creates new form FragmentPhoto
     */
    public FragmentPhoto() throws SQLException, IOException {
        initComponents();
        getDevices();
        
    }
    
     public FragmentPhoto(NewBiometricDevices devices,String applicantId,String user) throws SQLException, IOException {
         this.devices =devices;
         this.application_no =application_no;
        this.applicantId =applicantId;
        this.user = user;
        initComponents();
        getDevices();
        
    }
     public FragmentPhoto(NewBiometricDevices devices,String applicantId,String user, boolean selected) throws SQLException, IOException {
        this.devices =devices;
        this.application_no =application_no;
        this.selected =selected;
        this.applicantId =applicantId;
        this.user = user;
        initComponents();
        getDevices();       
         if (selected) {
             System.out.println("initialize photo");
             jCheckBox1.setSelected(true);
             jCheckBox1.setEnabled(false);
         } 
         if (jCheckBox1.isSelected()){
            displayPhotograph();
         }
     
        
    }
     
     
      private FragmentPhoto displayPhotograph() throws IOException {
        applicant = applicantId.toString();  
        System.out.println("Preparing photograph......");
        String clientPhotosPath ="C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\photos";
        File directory = new File(clientPhotosPath);
        if (directory.isDirectory()) {
        if (directory.list().length > 0) {
          System.out.println("Not Empty......");
            File [] file = directory.listFiles();
            for (File filedirectory : file) {
         if(filedirectory.getName().contains(applicant)){
             ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(209, 192, Image.SCALE_SMOOTH));
             jLabel23.setIcon(imageIcon);
             
         }
         
            }
        } 
      }
        return this;
    }
     
       private void getDevices() throws SQLException{
       d= new JDialog(this.devices , "Dialog Example");
       d.setUndecorated(true);
       d.setBackground(new Color(0, 0, 0, 0));
       ImageIcon imageIcon = new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\UICons\\loader.gif");
       JLabel label = new JLabel();
       label.setIcon(imageIcon);
       d.add(label);
       d.setBackground(new Color(0, 0, 0, 0));
       d.setLocationRelativeTo(null);
       d.setLayout( new FlowLayout() );
       d.setSize(300,200);  
       d.setVisible(true); 
                  //loading.setVisible(true);
                  jComboBoxCameraDevices.setEnabled(false);
                  ButtonTakePhotoNow.setEnabled(false);
                 // devices.setFocusable(false);
                 SwingWorker sw1 = new SwingWorker() {
            @Override
            protected String doInBackground() throws Exception 
            {
                
       String sql;
         JSONObject jsonObject = new JSONObject();
         JSONArray array = new JSONArray();
         
          sql= "SELECT device_type,device_name FROM biometric_devices WHERE device_status = 1";
            Connection conn = null;
            ResultSet rs = null;
            conn = (Connection) DBConnect.ConnecrDb();
            try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
             
         Statement stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
            while(rs.next()){
              JSONObject record = new JSONObject();
             //Inserting key-value pairs into the json object
             record.put("device_type", rs.getString("device_type"));
             record.put("device_name",rs.getString("device_name"));
             
                    array.put(record);
            }
            jsonObject.put("devices_data", array);
            JSONArray arr = jsonObject.getJSONArray("devices_data");
            
                 JSONObject firstObject = null;
                 

                 for (int i = 0; i < arr.length(); i++) {
                  firstObject = arr.getJSONObject(i);
                  String device_type = firstObject.getString("device_type");
                  
                  
                  if(device_type.equals("Photos")){
                      photo.add(firstObject.getString("device_name"));
                      Set<String> set2 = new HashSet<>(photo);
                      photo.clear();
                      photo.addAll(set2);

                  }
                  }
                  
                  String[] stringArray = photo.toArray(new String[0]);
               
                  jComboBoxCameraDevices.setModel( new DefaultComboBoxModel<>((String[])stringArray));
                         
                 
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
            finally {
                try {
                    if(rs != null)  rs.close();
                    
                    if(conn != null) conn.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
                String res = "Finished Execution";
                return res;
            }
            
            protected void done() 
            {
                          d.setVisible(false);
                          jComboBoxCameraDevices.setEnabled(true);
                          ButtonTakePhotoNow.setEnabled(true);
            }
                 
                 };
 sw1.execute(); 
    }

   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundCornerPhoto = new SwingClass.RoundCorner();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        roundCorner1 = new SwingClass.RoundCorner();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxCameraDevices = new javax.swing.JComboBox<>();
        ButtonTakePhotoNow = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(java.awt.Color.white);

        roundCornerPhoto.setBackground(java.awt.Color.white);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("SELECT PHOTO BIOCAPTURE DEVICE");

        roundCorner1.setBackground(java.awt.Color.white);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Choose Camera Device:");

        jComboBoxCameraDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCameraDevicesActionPerformed(evt);
            }
        });

        ButtonTakePhotoNow.setText("Take Photo");
        ButtonTakePhotoNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTakePhotoNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundCorner1Layout = new javax.swing.GroupLayout(roundCorner1);
        roundCorner1.setLayout(roundCorner1Layout);
        roundCorner1Layout.setHorizontalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCorner1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jComboBoxCameraDevices, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCorner1Layout.createSequentialGroup()
                        .addComponent(ButtonTakePhotoNow, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxCameraDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(ButtonTakePhotoNow, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jCheckBox1.setText("Captured");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundCornerPhotoLayout = new javax.swing.GroupLayout(roundCornerPhoto);
        roundCornerPhoto.setLayout(roundCornerPhotoLayout);
        roundCornerPhotoLayout.setHorizontalGroup(
            roundCornerPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerPhotoLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(roundCornerPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerPhotoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerPhotoLayout.createSequentialGroup()
                        .addGroup(roundCornerPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addGap(95, 95, 95)
                        .addComponent(roundCorner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        roundCornerPhotoLayout.setVerticalGroup(
            roundCornerPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCornerPhotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(roundCornerPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCornerPhotoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox1))
                    .addComponent(roundCorner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundCornerPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundCornerPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCameraDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCameraDevicesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCameraDevicesActionPerformed

    private void ButtonTakePhotoNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTakePhotoNowActionPerformed
        // TODO add your handling code here:
        String cameraDevice=jComboBoxCameraDevices.getSelectedItem().toString();

        if(cameraDevice.equals("Epson EOS")){
            Epson_Photo photo;
            try {
                photo = new Epson_Photo();
               devices.setForm(new FragmentEpson(devices,application_no,applicantId,user));
            } catch (IOException ex) {
                Logger.getLogger(BiometricDevices.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if(cameraDevice.equals("Suprema Facestation")){
            Biostar_Photos biostar = null;
            try {
                 devices.setForm(new FragmentBiostar(devices,application_no,applicantId,user));

            } catch (IOException ex) {
                Logger.getLogger(BiometricDevices.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
        else if(cameraDevice.equals("Microsoft Lifecam")){
            devices.setForm(new FragmentMicrosoftLifecam(devices,application_no,applicantId,user));
            
        }
        else{
            System.out.println("No device selected");
        }
    }//GEN-LAST:event_ButtonTakePhotoNowActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonTakePhotoNow;
    public javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBoxCameraDevices;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private SwingClass.RoundCorner roundCorner1;
    private SwingClass.RoundCorner roundCornerPhoto;
    // End of variables declaration//GEN-END:variables
}
