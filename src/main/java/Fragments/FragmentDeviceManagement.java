/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import DataModel.StatusType;
import futuristicbio.biometrics.AministratorDashboard;
import futuristicbio.biometrics.CheckBiometricDevice;
import futuristicbio.biometrics.CrudOperations;
import futuristicbio.biometrics.DBConnect;
import futuristicbio.biometrics.Device;
import futuristicbio.biometrics.Login_Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.table.TableModel;

/**
 *
 * @author kimel
 */
public class FragmentDeviceManagement extends javax.swing.JPanel {

    /**
     * Creates new form FragmentUserManagement
     */
    private ArrayList<Device> listingDevices;
        private AministratorDashboard board;
loadingFragment loading = new loadingFragment();

    public FragmentDeviceManagement() {
        initComponents();
        ((DefaultTableModel)tableSwing91.getModel()).setRowCount(0);
        init();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                tableSwing91.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
    }
    
    public FragmentDeviceManagement( AministratorDashboard board) {
        this.board =board;
        initComponents();
       ((DefaultTableModel)tableSwing91.getModel()).setRowCount(0);
        init();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                tableSwing91.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                tableSwing91.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
    }

    private void updateDevices(){
        int index = tableSwing91.getSelectedRow();
        int index2 = tableSwing91.getSelectedColumn();
        
        TableModel model = tableSwing91.getModel();
        String value1 = model.getValueAt(index,index2).toString();
        
   
        if (value1.equals("Edit")) {
            String serial_number = model.getValueAt(index, 2).toString();
            String device_type = model.getValueAt(index, 0).toString();
            String device_name = model.getValueAt(index, 1).toString();
            String driver_location = model.getValueAt(index, 3).toString();

            String sdk_location = model.getValueAt(index, 4).toString();
            String device_status = model.getValueAt(index, 5).toString();
            String date_created = model.getValueAt(index, 6).toString();

            
           
            board.setForm(new FragmentEditDevice(device_type, device_name, serial_number,driver_location, sdk_location,device_status,date_created,board));

        }else if(value1.equals("Reactivate")){
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement statement = null;
             Statement stmt = null;
         String serial_number = model.getValueAt(index, 2).toString();

        try {
            conn = DBConnect.ConnecrDb();
            String query = "UPDATE biometric_devices SET device_status = 1 WHERE serial_number ='"+serial_number+"'";
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
         
           stmt = conn.createStatement();
          int result =stmt.executeUpdate(query);

           JOptionPane.showMessageDialog(null, "Device Activated!");
           ((DefaultTableModel)tableSwing91.getModel()).setRowCount(0);
             init();

        }catch (SQLException e) {
            System.err.println();
            e.printStackTrace();
        }
        finally {
                
                if (conn != null) {
                    try {
                        conn.close();
                        rs.close();
                        statement.close();
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(CheckBiometricDevice.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            
        }
        }else {
               System.out.println("Click Appropriate place");
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSwing91 = new SwingCustiom.TableSwing20();

        setBackground(java.awt.Color.white);

        jPanel1.setBackground(java.awt.Color.white);

        jButton1.setBackground(new java.awt.Color(11, 46, 70));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/plus.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonPrint.setBackground(new java.awt.Color(11, 46, 70));
        jButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/print.png"))); // NOI18N
        jButtonPrint.setText("Print ");
        jButtonPrint.setToolTipText("");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonPrint))
                .addContainerGap())
        );

        tableSwing91.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Device Type", "Device Name", "Serial Number", "Driver Location", "SDK Location", "Device Status", "Date Created", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSwing91.setSelectionBackground(new java.awt.Color(0, 112, 54));
        tableSwing91.setShowVerticalLines(false);
        tableSwing91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSwing91MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSwing91);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         board.setForm(new FragmentAddDevice(board));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableSwing91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSwing91MouseClicked
        // TODO add your handling code here:
        updateDevices();
    }//GEN-LAST:event_tableSwing91MouseClicked

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        // TODO add your handling code here:
        //generateReports();
        displayReport();

    }//GEN-LAST:event_jButtonPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public SwingCustiom.TableSwing20 tableSwing91;
    // End of variables declaration//GEN-END:variables

    
    private void displayReport(){
    JasperPrint jasperPrint = generateReport();
    JasperViewer jasperViewer = new JasperViewer(jasperPrint);
    jasperViewer.viewReport(jasperPrint, false);
    }
    
    private JasperPrint generateReport(){
    JasperPrint jasperPrint = null;
    String name = "device_management";
     Map param = new HashMap();
     
     String url = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaalogo.png";
     String path = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaabackground.png";
     param.put("logo", url);
     param.put("background", path);
     
     
     param.put("Device Type", "Device Type");
     param.put("Device Name", "Device Name");
     param.put("Serial Number", "Serial Number");
     param.put("Driver Location", "Driver Location");
     param.put("SDK Location", "SDK Location");
     param.put("Device Status", "Device Status");
     param.put("Date Created", "Date Added");

     JRTableModelDataSource datasource = new JRTableModelDataSource(tableSwing91.getModel());
    try{
   String source1 = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\futuristicbio\\biometrics\\" + name + ".jrxml";
    JasperReport jasperReport = JasperCompileManager.compileReport(source1);
    jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JRTableModelDataSource(tableSwing91.getModel()));
         System.out.println(jasperPrint);
    }catch(JRException e){
        e.printStackTrace();
                System.out.println("reports Error  " + e.toString());
    }
    return jasperPrint;
    }
    
    private void displayReport2(){
    JasperPrint jasperPrint = generateReport2();
    JasperViewer jasperViewer = new JasperViewer(jasperPrint);
    jasperViewer.viewReport(jasperPrint, false);
    }
    
    private JasperPrint generateReport2(){
    JasperPrint jasperPrint = null;
    String name = "installation";
     Map<String,Object> param = new HashMap<String, Object>();
     
     String url = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaalogo.png";
     String path = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaabackground.png";
     param.put("logo", url);
     param.put("background", path);
     param.put("data","dummy");
     
   
    try{
   String source1 = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\futuristicbio\\biometrics\\" + name + ".jrxml";
 String subReportFileName = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\futuristicbio\\biometrics\\wacom.jrxml";
   JasperReport jasperReport = JasperCompileManager.compileReport(source1);
   JasperReport jasperSubReport = JasperCompileManager.compileReport(subReportFileName);
    param.put("SUBREPORT_DIR", jasperSubReport);
    jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JRTableModelDataSource(tableSwing91.getModel()));
    }catch(JRException e){
        e.printStackTrace();
                System.out.println("reports Error  " + e.toString());
    }
    return jasperPrint;
    }
     

    private void init() {
            loading.setVisible(true);
            jButton1.setEnabled(false);
            jButtonPrint.setEnabled(false);
        SwingWorker sw1 = new SwingWorker() {
            @Override
            protected String doInBackground() throws Exception 
            {
              listingDevices = new ArrayList<>();
        listingDevices = new CrudOperations().getAllDevices();
        if (listingDevices.size() > 0) {
            for (int i = 0; i < listingDevices.size(); i++) {
                Device get = listingDevices.get(i);
                tableSwing91.addRow(new Object[]{get.getdevice_type(), get.getdevice_name(), get.getserial_number(), get.getdriver_location()
                , get.getsdk_location(), (get.getdevice_status().equals("1")? "Active": "Not Active"), get.getdate_created(),(get.getdevice_status().equals("1")? StatusType.Edit: StatusType.Reactivate)});
                                
            }
        } else {
            //should add empty table row
            System.out.println("No Device found");
        }
            
            String res = "Finished Execution";
                return res;
            }
                 
               protected void done() 
            {
                   loading.setVisible(false);
                   jButton1.setEnabled(true);
                   jButtonPrint.setEnabled(true);
            }  
                 };
        sw1.execute();
    }

    

   
}
