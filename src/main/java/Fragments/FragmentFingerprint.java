/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import futuristicbio.biometrics.BiometricDevices;
import futuristicbio.biometrics.CrudOperations;
import futuristicbio.biometrics.DBConnect;
import futuristicbio.biometrics.Morpho_Fingerprints;
import futuristicbio.biometrics.NewBiometricDevices;
import futuristicbio.biometrics.RealscanG_Fingerprints;
import futuristicbio.biometrics.Realscan_Fingerprints;
import futuristicbio.biometrics.UserContext;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.SwingWorker;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Futuristic Ltd
 */
public class FragmentFingerprint extends javax.swing.JPanel {

        private String applicantId;
    private String application_no;
    private String first_name;
    private String last_name;
    private String operator_name;
    private String job_position;
    private String readdate;
    private String applicant;
    private UserContext context;
    ArrayList<String> fingerprint = new ArrayList<String>();
    private NewBiometricDevices devices;
    private String user;
    private boolean selected = false;
   private String clientPngPath;
   loadingFragment loading = new loadingFragment();
    private JDialog d ;
    /**
     * Creates new form FragmentFingerprint
     */
    public FragmentFingerprint() throws SQLException {
        initComponents();
        getDevices();
    }
    
     public FragmentFingerprint(NewBiometricDevices devices,String applicantId,String user) throws SQLException {
        this.devices =devices;
        //this.application_no =application_no;
        this.applicantId =applicantId;
        this.user = user;
         initComponents();
        getDevices();
    }
     
     public FragmentFingerprint(NewBiometricDevices devices,String applicantId,String user,boolean selected) throws SQLException, UnsupportedEncodingException {
        this.devices =devices;
        //this.application_no =application_no;
        this.applicantId =applicantId;
        this.user = user;
        this.selected =selected;
         initComponents();
        getDevices();
        if (selected) {
             System.out.println("initialize photo");
             jCheckBox1.setSelected(true);
             jCheckBox1.setEnabled(false);
         } 
         if (jCheckBox1.isSelected()){
            displayfingerprints();
         }
    }
     
     
     
     private FragmentFingerprint displayfingerprints() throws UnsupportedEncodingException {
        System.out.println("Preparing fingerprints......");
         String mypath = Realscan_Fingerprints.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            File file = new java.io.File(decodedPath);
            String path = file.getParent();

            clientPngPath = path.concat("\\fingerprints\\png");
        File directory = new File(clientPngPath);//local directory location
                applicant = applicantId.toString();  


        if (directory.isDirectory()) {

            if (directory.list().length > 0) {
                System.out.println("Directory is not empty!");
                File[] listFiles = directory.listFiles();
                
                for (File filedirectory : listFiles) {
                 if(filedirectory.getName().contains(applicant)){

                    if (filedirectory.getName().contains("LEFT_THUMB")) {
                        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel25.setIcon(imageIcon1);
                    } else if (filedirectory.getName().contains("LEFT_FORE")) {
                        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel26.setIcon(imageIcon2);
                    } else if (filedirectory.getName().contains("LEFT_MIDDLE")) {
                        ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel27.setIcon(imageIcon3);
                    } else if (filedirectory.getName().contains("LEFT_RING")) {
                        ImageIcon imageIcon4 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel28.setIcon(imageIcon4);
                    } else if (filedirectory.getName().contains("LEFT_LITTLE")) {
                        ImageIcon imageIcon5 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel29.setIcon(imageIcon5);
                    } else if (filedirectory.getName().contains("RIGHT_THUMB")) {
                        ImageIcon imageIcon6 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel30.setIcon(imageIcon6);
                    } else if (filedirectory.getName().contains("RIGHT_FORE")) {
                        ImageIcon imageIcon7 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel31.setIcon(imageIcon7);
                    } else if (filedirectory.getName().contains("RIGHT_MIDDLE")) {
                        ImageIcon imageIcon8 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel32.setIcon(imageIcon8);
                    } else if (filedirectory.getName().contains("RIGHT_RING")) {
                        ImageIcon imageIcon9 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel33.setIcon(imageIcon9);
                    } else if (filedirectory.getName().contains("RIGHT_LITTLE")) {
                        ImageIcon imageIcon10 = new ImageIcon(new ImageIcon(filedirectory.getAbsolutePath()).getImage().getScaledInstance(111, 146, Image.SCALE_SMOOTH));
                        jLabel34.setIcon(imageIcon10);

                    }
                 }
                }
            } else {
                jLabel25.setIcon(null);
                jLabel26.setIcon(null);
                jLabel27.setIcon(null);
                jLabel28.setIcon(null);
                jLabel29.setIcon(null);
                jLabel30.setIcon(null);
                jLabel31.setIcon(null);
                jLabel32.setIcon(null);
                jLabel33.setIcon(null);
                jLabel34.setIcon(null);

                System.out.println("Directory is empty!");

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
           jComboBoxFingerPrint.setEnabled(false);
           jButtonTakeFingerprints.setEnabled(false);
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
            Statement stmt = null;
            conn = (Connection) DBConnect.ConnecrDb();
            try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
             
          stmt = conn.createStatement();
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
                  
                  
                   if(device_type.equals("Fingerprint Scanner")){
                      
                     fingerprint.add(firstObject.getString("device_name"));
                     Set<String> set1 = new HashSet<>(fingerprint);
                     fingerprint.clear();
                     fingerprint.addAll(set1);
                  }
                  }
                  
                  
             String[] stringArray2 = fingerprint.toArray(new String[0]);
             jComboBoxFingerPrint.setModel( new DefaultComboBoxModel<>((String[])stringArray2));
                  
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
            finally {
                try {
                    if(rs != null)  rs.close();
                    if(stmt != null) stmt.close();
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
                jComboBoxFingerPrint.setEnabled(true);
                  jButtonTakeFingerprints.setEnabled(true);
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

        roundCornerFingerprint = new SwingClass.RoundCorner();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        roundCorner5 = new SwingClass.RoundCorner();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxFingerPrint = new javax.swing.JComboBox<>();
        jButtonTakeFingerprints = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);

        roundCornerFingerprint.setBackground(java.awt.Color.white);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("SELECT FINGERPRINT BIOCAPTURE DEVICE");

        roundCorner5.setBackground(java.awt.Color.white);

        jLabel14.setText("Choose Fingerprint Device");

        jComboBoxFingerPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFingerPrintActionPerformed(evt);
            }
        });

        jButtonTakeFingerprints.setText("Take Fingerprint");
        jButtonTakeFingerprints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTakeFingerprintsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundCorner5Layout = new javax.swing.GroupLayout(roundCorner5);
        roundCorner5.setLayout(roundCorner5Layout);
        roundCorner5Layout.setHorizontalGroup(
            roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner5Layout.createSequentialGroup()
                .addGroup(roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxFingerPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner5Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButtonTakeFingerprints, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        roundCorner5Layout.setVerticalGroup(
            roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxFingerPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButtonTakeFingerprints, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanel5.setBackground(java.awt.Color.white);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jLabel12.setText("Left Thumb");

        jLabel13.setText("Left Index");

        jLabel15.setText("Left Middle");

        jLabel16.setText("Left Ring");

        jLabel17.setText("Left Little");

        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel18.setText("Right Thumb");

        jLabel19.setText("Right Index");

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel21.setText("Right Ring");

        jLabel22.setText("Right Little");

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jCheckBox1.setText("Captured");

        jLabel1.setText("Right Little");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(9, 9, 9)))
                                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel16)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel17))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel1)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel22))))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jCheckBox1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundCornerFingerprintLayout = new javax.swing.GroupLayout(roundCornerFingerprint);
        roundCornerFingerprint.setLayout(roundCornerFingerprintLayout);
        roundCornerFingerprintLayout.setHorizontalGroup(
            roundCornerFingerprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerFingerprintLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundCorner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(roundCornerFingerprintLayout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundCornerFingerprintLayout.setVerticalGroup(
            roundCornerFingerprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCornerFingerprintLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundCornerFingerprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCornerFingerprintLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(roundCornerFingerprintLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(roundCorner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1216, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(29, Short.MAX_VALUE)
                    .addComponent(roundCornerFingerprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(roundCornerFingerprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFingerPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFingerPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFingerPrintActionPerformed

    private void jButtonTakeFingerprintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTakeFingerprintsActionPerformed
        // TODO add your handling code here:
        String fingerprintDevice=jComboBoxFingerPrint.getSelectedItem().toString();

        if(fingerprintDevice.equals("Morpho Top 100")){
            Morpho_Fingerprints morpho = new Morpho_Fingerprints();
            try {
                 devices.setForm(new FragmentMorpho(devices,application_no,applicantId,user));
            } catch (IOException ex) {
                Logger.getLogger(FragmentFingerprint.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        else if(fingerprintDevice.equals("Realscan D")){
            Realscan_Fingerprints Realscan = null;
            try {
               devices.setForm(new FragmentRealscanD(devices,application_no,applicantId,user));
            } catch (IOException ex) {
                Logger.getLogger(FragmentFingerprint.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if(fingerprintDevice.equals("Realscan G-10")){
            RealscanG_Fingerprints Realscan = null;
            try {
                devices.setForm(new FragmentRealscanG(devices,application_no,applicantId,user));
            } catch (IOException ex) {
                Logger.getLogger(FragmentFingerprint.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else{
            System.out.println("No device selected");
        }
    }//GEN-LAST:event_jButtonTakeFingerprintsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTakeFingerprints;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBoxFingerPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator5;
    private SwingClass.RoundCorner roundCorner5;
    private SwingClass.RoundCorner roundCornerFingerprint;
    // End of variables declaration//GEN-END:variables
}
