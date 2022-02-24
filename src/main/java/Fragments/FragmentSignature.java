/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import futuristicbio.biometrics.CrudOperations;
import futuristicbio.biometrics.DBConnect;
import futuristicbio.biometrics.NewBiometricDevices;
import futuristicbio.biometrics.Signature;
import futuristicbio.biometrics.UserContext;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
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
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Futuristic Ltd
 */
public class FragmentSignature extends javax.swing.JPanel {

    private String applicantId;
    private String application_no;
    private String first_name;
    private String last_name;
    private String operator_name;
    private String job_position;
    private String readdate;
    private String applicant;
    private UserContext context;
    private String user;
    private ArrayList<String> photo = new ArrayList<String>();
    private ArrayList<String> fingerprint = new ArrayList<String>();
    private ArrayList<String> signature = new ArrayList<String>();
    private NewBiometricDevices devices;
    private boolean selected = false;
    private String clientSignaturePath;
    loadingFragment loading = new loadingFragment();
     private JDialog d ;
     

    /**
     * Creates new form FragmentSignature
     */
    public FragmentSignature() throws SQLException {
        initComponents();
        getDevices();
    }
    
    public FragmentSignature(NewBiometricDevices devices,String applicantId,String user) throws SQLException {
        this.devices =devices;
        //this.application_no =application_no;
        this.applicantId =applicantId;
        this.user = user;
        initComponents();
        getDevices();
    }
    
    public FragmentSignature(NewBiometricDevices devices,String applicantId,String user, boolean selected) throws SQLException, IOException, UnsupportedEncodingException {
         this.devices =devices;
        // this.application_no =application_no;
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
            displaySignature();
         }
     
        
    }

    
     private FragmentSignature displaySignature() throws UnsupportedEncodingException {
         applicant = applicantId.toString();  
         String mypath = Signature.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            File file = new java.io.File(decodedPath);
        String path = file.getParent();
            
            clientSignaturePath = path.concat("\\signatures");
        System.out.println("Preparing signature......");
        File directory = new File(clientSignaturePath);
        if (directory.isDirectory()) {
        if (directory.list().length > 0) {
            File [] file2 = directory.listFiles();
            for (File filedirectory : file2) {
         if(filedirectory.getName().contains(applicant)){
            ImageIcon imageIconSc = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(277,218, Image.SCALE_SMOOTH));
            jLabel23.setIcon(imageIconSc);
         }
            }
        }
        }else {
            jLabel23.setIcon(null);
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
                  jComboBoxSignature.setEnabled(false);
                  jButtonTakeSignature.setEnabled(false);
                  //devices.setFocusable(false);
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
                  
                  
                 if(device_type.equals("Signature Pad")){
                      
                     signature.add(firstObject.getString("device_name"));
                     Set<String> set = new HashSet<>(signature);
                     signature.clear();
                     signature.addAll(set);

                      }
                  }
                  
                 
                  String[] stringArray1 = signature.toArray(new String[0]);
                  

                  
                  jComboBoxSignature.setModel( new DefaultComboBoxModel<>((String[])stringArray1));
                  
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
              jComboBoxSignature.setEnabled(true);
              jButtonTakeSignature.setEnabled(true);
             //JOptionPane.showMessageDialog(null,"Successfully transfered files to server", "Information", JOptionPane.INFORMATION_MESSAGE);
                   //devices.setFocusable(true);
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

        roundCornerSignature = new SwingClass.RoundCorner();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        roundCorner4 = new SwingClass.RoundCorner();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxSignature = new javax.swing.JComboBox<>();
        jButtonTakeSignature = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);

        roundCornerSignature.setBackground(java.awt.Color.white);

        jLabel23.setBackground(new java.awt.Color(128, 125, 123));
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jCheckBox1.setBackground(java.awt.Color.white);
        jCheckBox1.setText("Captured");

        roundCorner4.setBackground(java.awt.Color.white);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Choose Signature Pad:");

        jComboBoxSignature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSignatureActionPerformed(evt);
            }
        });

        jButtonTakeSignature.setText("Take Signature");
        jButtonTakeSignature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTakeSignatureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundCorner4Layout = new javax.swing.GroupLayout(roundCorner4);
        roundCorner4.setLayout(roundCorner4Layout);
        roundCorner4Layout.setHorizontalGroup(
            roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jComboBoxSignature, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCorner4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTakeSignature, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        roundCorner4Layout.setVerticalGroup(
            roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSignature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTakeSignature, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("SELECT SIGNATURE BIOCAPTURE DEVICE");

        javax.swing.GroupLayout roundCornerSignatureLayout = new javax.swing.GroupLayout(roundCornerSignature);
        roundCornerSignature.setLayout(roundCornerSignatureLayout);
        roundCornerSignatureLayout.setHorizontalGroup(
            roundCornerSignatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(roundCornerSignatureLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(roundCornerSignatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(roundCorner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerSignatureLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346))
        );
        roundCornerSignatureLayout.setVerticalGroup(
            roundCornerSignatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCornerSignatureLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(roundCornerSignatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundCornerSignatureLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jCheckBox1))
                    .addComponent(roundCorner4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundCornerSignature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(roundCornerSignature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSignatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSignatureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSignatureActionPerformed

    private void jButtonTakeSignatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTakeSignatureActionPerformed
        // TODO add your handling code here:

        String cameraDevice=jComboBoxSignature.getSelectedItem().toString();

        if(cameraDevice.equals("Wacom 530 STU")){
            Signature signature = new Signature();
            devices.setForm(new FragmentCaptureSignature(devices,application_no,applicantId,user));
            //signature.setApplicantId(applicantId,application_no);
            //signature.setVisible(true);

        }else if(cameraDevice.equals("Wacom 500 STU")){
            Signature signature = new Signature();
            //signature.setApplicantId(applicantId,application_no);
            devices.setForm(new FragmentCaptureSignature(devices,application_no,applicantId,user));
            //signature.setVisible(true);
        }
        else{
            System.out.println("No device selected");
        }
    }//GEN-LAST:event_jButtonTakeSignatureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTakeSignature;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBoxSignature;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator4;
    private SwingClass.RoundCorner roundCorner4;
    private SwingClass.RoundCorner roundCornerSignature;
    // End of variables declaration//GEN-END:variables
}
