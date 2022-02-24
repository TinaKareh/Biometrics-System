/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futuristicbio.biometrics;

import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.awt.Toolkit;
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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author kimel
 */
public final class BiometricDevices extends javax.swing.JFrame {

    private Integer applicantId;
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
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaabackground.png");    

    /**
     * Creates new form BiometricDevices
     * @throws java.sql.SQLException
     */
    public BiometricDevices() throws SQLException, IOException {
        initComponents();
        setUserContext();
        getDevices();
        //displayPhotograph();
    }
    
    private void setUserContext() {
        context = (UserContext) ThreadLocalStorage.getUserContext();
        
        //name.setText(context.getUserName() + "");
        lblRegionId.setText(context.getRegionId()+"");
        lblAirportId.setText(context.getAirport_airstrip_id() + "" );
       
    }

    
    
    public void getPermitDetails(String application_no,Integer applicantId,String first_name,String last_name,String operator_name,String readdate){
        this.application_no = application_no;
        this.applicantId = applicantId;
        this.first_name = first_name;
        this.last_name=last_name;
        this.operator_name =operator_name;
        this.readdate =readdate;
         
        applicant = applicantId.toString();
        
        jTextFieldAppNo.setText(application_no);
        jTextFieldAppId.setText(applicant);
        jTextFieldFirstName.setText(first_name);
        jTextFieldLastName.setText(last_name);
        jTextFieldOperator.setText(operator_name);
        jTextFieldDate.setText(readdate);
        
    }
    
         public BiometricDevices displayPhotograph() throws IOException {
             
        System.out.println("Preparing photograph......");
        String clientPhotosPath ="C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\signatures";
        File directory = new File(clientPhotosPath);
        if (directory.list().length > 0) {
          System.out.println("Not Empty......");
            File file = directory.listFiles()[0];
         if(file.getName().contains(applicant)){
             System.out.println("Empty......");
             ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pic.png")).getImage().getScaledInstance(jLabel23.getWidth(), jLabel23.getHeight(), Image.SCALE_SMOOTH));
             jLabel23.setIcon(imageIcon);
             
         }
         else {
             ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(jLabel23.getWidth(), jLabel23.getHeight(), Image.SCALE_SMOOTH));
             jLabel23.setIcon(imageIcon);
         }
        } else {
           System.out.println("Empty......");
            ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pic.png")).getImage().getScaledInstance(jLabel23.getWidth(), jLabel23.getHeight(), Image.SCALE_SMOOTH));
            jLabel23.setIcon(imageIcon);
          
        }

        return this;
    }
    
    public void getDevices() throws SQLException{
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

                  }else if(device_type.equals("Fingerprint Scanner")){
                      
                     fingerprint.add(firstObject.getString("device_name"));
                     Set<String> set1 = new HashSet<>(fingerprint);
                     fingerprint.clear();
                     fingerprint.addAll(set1);
                  }else{
                      
                     signature.add(firstObject.getString("device_name"));
                     Set<String> set = new HashSet<>(signature);
                     signature.clear();
                     signature.addAll(set);

                      }
                  }
                  
                  String[] stringArray = photo.toArray(new String[0]);
                  String[] stringArray1 = signature.toArray(new String[0]);
                  String[] stringArray2 = fingerprint.toArray(new String[0]);

                  
                  jComboBoxCameraDevices.setModel( new DefaultComboBoxModel<>((String[])stringArray));
                  jComboBoxSignature.setModel( new DefaultComboBoxModel<>((String[])stringArray1));
                  jComboBoxFingerPrint.setModel( new DefaultComboBoxModel<>((String[])stringArray2));
                  
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        lblRegionId = new javax.swing.JTextField();
        lblAirportId = new javax.swing.JTextField();
        roundCorner2 = new SwingClass.RoundCorner();
        roundCorner3 = new SwingClass.RoundCorner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldAppId = new javax.swing.JTextField();
        jTextFieldAppNo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldOperator = new javax.swing.JTextField();
        jTextFieldDate = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanelCaptureType = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanelDevicesType = new javax.swing.JPanel();
        roundCornerDefault = new SwingClass.RoundCorner();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        roundCornerPhoto = new SwingClass.RoundCorner();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        roundCorner1 = new SwingClass.RoundCorner();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxCameraDevices = new javax.swing.JComboBox<>();
        ButtonTakePhotoNow = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        roundCornerSignature = new SwingClass.RoundCorner();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        roundCorner4 = new SwingClass.RoundCorner();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxSignature = new javax.swing.JComboBox<>();
        jButtonTakeSignature = new javax.swing.JButton();
        roundCornerFingerprint = new SwingClass.RoundCorner();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        roundCorner5 = new SwingClass.RoundCorner();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxFingerPrint = new javax.swing.JComboBox<>();
        jButtonTakeFingerprints = new javax.swing.JButton();
        roundCornerCaptured = new SwingClass.RoundCorner();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(icon);

        jPanel5.setBackground(new java.awt.Color(255, 215, 125));

        jLabel6.setBackground(new java.awt.Color(4, 132, 247));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 82, 155));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Airport Permit & Identity Management System");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 215, 125));

        name.setEditable(false);
        name.setText("Name");

        lblRegionId.setEditable(false);
        lblRegionId.setText("Region");

        lblAirportId.setEditable(false);
        lblAirportId.setText("Airport");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 126, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAirportId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAirportId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel16.setText("First Name");

        jLabel17.setText("Last Name");

        jLabel18.setText("Applicant ID");

        jLabel19.setText("Application No");

        jTextFieldFirstName.setEditable(false);

        jTextFieldLastName.setEditable(false);

        jTextFieldAppId.setEditable(false);

        jTextFieldAppNo.setEditable(false);

        jLabel20.setText("Biocapture Type");

        jTextFieldOperator.setEditable(false);

        jLabel21.setText("Date");

        javax.swing.GroupLayout roundCorner3Layout = new javax.swing.GroupLayout(roundCorner3);
        roundCorner3.setLayout(roundCorner3Layout);
        roundCorner3Layout.setHorizontalGroup(
            roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAppId, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAppNo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundCorner3Layout.setVerticalGroup(
            roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel21)
                        .addComponent(jTextFieldOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel18)
                        .addComponent(jLabel19)
                        .addComponent(jLabel17)
                        .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAppId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAppNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCaptureType.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BIOCAPTURE");

        jLabel7.setText("Photo");

        jLabel8.setText("Signature");

        jLabel9.setText("Fingerprint");

        jButton2.setText("Capture Photo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Capture Fingerprint");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Capture Signature");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCaptureTypeLayout = new javax.swing.GroupLayout(jPanelCaptureType);
        jPanelCaptureType.setLayout(jPanelCaptureTypeLayout);
        jPanelCaptureTypeLayout.setHorizontalGroup(
            jPanelCaptureTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanelCaptureTypeLayout.createSequentialGroup()
                .addGroup(jPanelCaptureTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCaptureTypeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelCaptureTypeLayout.createSequentialGroup()
                        .addGroup(jPanelCaptureTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCaptureTypeLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCaptureTypeLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCaptureTypeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        jPanelCaptureTypeLayout.setVerticalGroup(
            jPanelCaptureTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCaptureTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanelCaptureTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanelCaptureTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(jPanelCaptureTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jPanelDevicesType.setLayout(new java.awt.CardLayout());

        roundCornerDefault.setBackground(java.awt.Color.white);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELECT BIOCAPTURE DEVICE");

        javax.swing.GroupLayout roundCornerDefaultLayout = new javax.swing.GroupLayout(roundCornerDefault);
        roundCornerDefault.setLayout(roundCornerDefaultLayout);
        roundCornerDefaultLayout.setHorizontalGroup(
            roundCornerDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerDefaultLayout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );
        roundCornerDefaultLayout.setVerticalGroup(
            roundCornerDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCornerDefaultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
        );

        jPanelDevicesType.add(roundCornerDefault, "card3");

        roundCornerPhoto.setBackground(java.awt.Color.white);

        jLabel2.setText("SELECT PHOTO BIOCAPTURE DEVICE");

        roundCorner1.setBackground(java.awt.Color.white);

        jLabel11.setText("Choose Camera Device");

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
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel11)
                        .addGap(67, 67, 67)
                        .addComponent(jComboBoxCameraDevices, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(ButtonTakePhotoNow, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxCameraDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonTakePhotoNow, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        jPanel2.setBackground(java.awt.Color.white);

        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout roundCornerPhotoLayout = new javax.swing.GroupLayout(roundCornerPhoto);
        roundCornerPhoto.setLayout(roundCornerPhotoLayout);
        roundCornerPhotoLayout.setHorizontalGroup(
            roundCornerPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerPhotoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerPhotoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundCornerPhotoLayout.setVerticalGroup(
            roundCornerPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCornerPhotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(roundCornerPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(200, 200, 200))
        );

        jPanelDevicesType.add(roundCornerPhoto, "card5");

        roundCornerSignature.setBackground(java.awt.Color.white);

        jLabel3.setText("SELECT SIGNATURE BIOCAPTURE DEVICE");

        roundCorner4.setBackground(java.awt.Color.white);

        jLabel12.setText("Choose Signature Pad");

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
                .addGroup(roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner4Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel12)
                        .addGap(79, 79, 79)
                        .addComponent(jComboBoxSignature, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner4Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jButtonTakeSignature, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        roundCorner4Layout.setVerticalGroup(
            roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSignature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButtonTakeSignature, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout roundCornerSignatureLayout = new javax.swing.GroupLayout(roundCornerSignature);
        roundCornerSignature.setLayout(roundCornerSignatureLayout);
        roundCornerSignatureLayout.setHorizontalGroup(
            roundCornerSignatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerSignatureLayout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
            .addGroup(roundCornerSignatureLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(roundCorner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundCornerSignatureLayout.setVerticalGroup(
            roundCornerSignatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCornerSignatureLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundCorner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jPanelDevicesType.add(roundCornerSignature, "card6");

        roundCornerFingerprint.setBackground(java.awt.Color.white);

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
                        .addGap(135, 135, 135)
                        .addComponent(jLabel14)
                        .addGap(79, 79, 79)
                        .addComponent(jComboBoxFingerPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner5Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jButtonTakeFingerprints, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        roundCorner5Layout.setVerticalGroup(
            roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxFingerPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jButtonTakeFingerprints, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout roundCornerFingerprintLayout = new javax.swing.GroupLayout(roundCornerFingerprint);
        roundCornerFingerprint.setLayout(roundCornerFingerprintLayout);
        roundCornerFingerprintLayout.setHorizontalGroup(
            roundCornerFingerprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerFingerprintLayout.createSequentialGroup()
                .addContainerGap(307, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
            .addGroup(roundCornerFingerprintLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(roundCorner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundCornerFingerprintLayout.setVerticalGroup(
            roundCornerFingerprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCornerFingerprintLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundCorner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jPanelDevicesType.add(roundCornerFingerprint, "card4");

        roundCornerCaptured.setBackground(java.awt.Color.white);

        jLabel10.setText("ALL BIOMETRICS CAPTURED");

        javax.swing.GroupLayout roundCornerCapturedLayout = new javax.swing.GroupLayout(roundCornerCaptured);
        roundCornerCaptured.setLayout(roundCornerCapturedLayout);
        roundCornerCapturedLayout.setHorizontalGroup(
            roundCornerCapturedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCornerCapturedLayout.createSequentialGroup()
                .addContainerGap(315, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        roundCornerCapturedLayout.setVerticalGroup(
            roundCornerCapturedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCornerCapturedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
        );

        jPanelDevicesType.add(roundCornerCaptured, "card2");

        jPanel4.setBackground(new java.awt.Color(0, 81, 155));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Developed for KAA by Futuristic © 2021");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundCorner2Layout = new javax.swing.GroupLayout(roundCorner2);
        roundCorner2.setLayout(roundCorner2Layout);
        roundCorner2Layout.setHorizontalGroup(
            roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundCorner3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundCorner2Layout.createSequentialGroup()
                        .addComponent(jPanelCaptureType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanelDevicesType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundCorner2Layout.setVerticalGroup(
            roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundCorner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelCaptureType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDevicesType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundCorner2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundCorner2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jPanelDevicesType.removeAll();
        jPanelDevicesType.repaint();
        jPanelDevicesType.revalidate();
        jPanelDevicesType.add(roundCornerPhoto);
        jPanelDevicesType.repaint();
        jPanelDevicesType.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jPanelDevicesType.removeAll();
        jPanelDevicesType.repaint();
        jPanelDevicesType.revalidate();
        jPanelDevicesType.add(roundCornerFingerprint);
        jPanelDevicesType.repaint();
        jPanelDevicesType.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jPanelDevicesType.removeAll();
        jPanelDevicesType.repaint();
        jPanelDevicesType.revalidate();
        jPanelDevicesType.add(roundCornerSignature);
        jPanelDevicesType.repaint();
        jPanelDevicesType.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ButtonTakePhotoNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTakePhotoNowActionPerformed
        // TODO add your handling code here:
        String cameraDevice=jComboBoxCameraDevices.getSelectedItem().toString();
        
        if(cameraDevice.equals("Epson EOS")){
            Epson_Photo photo;
            try {
                photo = new Epson_Photo();
                photo.setApplicantId(applicantId,application_no);
                photo.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(BiometricDevices.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        else if(cameraDevice.equals("Suprema Facestation")){
            Biostar_Photos biostar = null;
            try {
                biostar = new Biostar_Photos();
            } catch (IOException ex) {
                Logger.getLogger(BiometricDevices.class.getName()).log(Level.SEVERE, null, ex);
            }
           // biostar.setApplicantId(applicantId,application_no);
            biostar.setVisible(true);
            
        }
        else if(cameraDevice.equals("Microsoft Lifecam")){
        }
        else{
            System.out.println("No device selected");
        }
    }//GEN-LAST:event_ButtonTakePhotoNowActionPerformed

    private void jComboBoxCameraDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCameraDevicesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCameraDevicesActionPerformed

    private void jComboBoxSignatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSignatureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSignatureActionPerformed

    private void jButtonTakeSignatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTakeSignatureActionPerformed
        // TODO add your handling code here:
        
         String cameraDevice=jComboBoxSignature.getSelectedItem().toString();
         
         if(cameraDevice.equals("Wacom 530 STU")){
             Signature signature = new Signature();
             signature.setApplicantId(applicantId,application_no);
             signature.setVisible(true);
        
        }else if(cameraDevice.equals("Wacom 500 STU")){
             Signature signature = new Signature();
             signature.setApplicantId(applicantId,application_no);
             signature.setVisible(true);
        }
        else{
            System.out.println("No device selected");
        }
    }//GEN-LAST:event_jButtonTakeSignatureActionPerformed

    private void jComboBoxFingerPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFingerPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFingerPrintActionPerformed

    private void jButtonTakeFingerprintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTakeFingerprintsActionPerformed
        // TODO add your handling code here:
        String fingerprintDevice=jComboBoxFingerPrint.getSelectedItem().toString();
        
       
        if(fingerprintDevice.equals("Morpho Top 100")){
            Morpho_Fingerprints morpho = new Morpho_Fingerprints();
            morpho.setApplicantId(applicantId,application_no);
            morpho.setVisible(true);
       
        }
        else if(fingerprintDevice.equals("Realscan D")){
            Realscan_Fingerprints Realscan = null;
            try {
                Realscan = new Realscan_Fingerprints();
                Realscan.setApplicantId(applicantId,application_no);
                Realscan.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(BiometricDevices.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
        else if(fingerprintDevice.equals("Realscan G-10")){
         RealscanG_Fingerprints Realscan = null;
            try {
                Realscan = new RealscanG_Fingerprints();
            } catch (IOException ex) {
                Logger.getLogger(BiometricDevices.class.getName()).log(Level.SEVERE, null, ex);
            }
         Realscan.setApplicantId(applicantId,application_no);
         Realscan.setVisible(true);
        }
        else{
            System.out.println("No device selected");
        }
    }//GEN-LAST:event_jButtonTakeFingerprintsActionPerformed

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
            java.util.logging.Logger.getLogger(BiometricDevices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BiometricDevices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BiometricDevices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BiometricDevices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BiometricDevices().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BiometricDevices.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(BiometricDevices.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonTakePhotoNow;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonTakeFingerprints;
    private javax.swing.JButton jButtonTakeSignature;
    private javax.swing.JComboBox<String> jComboBoxCameraDevices;
    private javax.swing.JComboBox<String> jComboBoxFingerPrint;
    private javax.swing.JComboBox<String> jComboBoxSignature;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelCaptureType;
    private javax.swing.JPanel jPanelDevicesType;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextFieldAppId;
    private javax.swing.JTextField jTextFieldAppNo;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldOperator;
    private javax.swing.JTextField lblAirportId;
    private javax.swing.JTextField lblRegionId;
    private javax.swing.JTextField name;
    private SwingClass.RoundCorner roundCorner1;
    private SwingClass.RoundCorner roundCorner2;
    private SwingClass.RoundCorner roundCorner3;
    private SwingClass.RoundCorner roundCorner4;
    private SwingClass.RoundCorner roundCorner5;
    private SwingClass.RoundCorner roundCornerCaptured;
    private SwingClass.RoundCorner roundCornerDefault;
    private SwingClass.RoundCorner roundCornerFingerprint;
    private SwingClass.RoundCorner roundCornerPhoto;
    private SwingClass.RoundCorner roundCornerSignature;
    // End of variables declaration//GEN-END:variables
}
