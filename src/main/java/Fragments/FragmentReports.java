/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import DataModel.StatusType;
import futuristicbio.biometrics.CrudOperations;
import futuristicbio.biometrics.DBConnect;
import futuristicbio.biometrics.DataApplicants;
import futuristicbio.biometrics.DataNewRequests;
import futuristicbio.biometrics.EnrollmentDetails;
import futuristicbio.biometrics.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class FragmentReports extends javax.swing.JPanel {

    private CrudOperations co;
    private ArrayList<DataNewRequests> requestses;
    loadingFragment loading = new loadingFragment();
    private ArrayList<EnrollmentDetails> listingApplicants;

    public FragmentReports() {
        initComponents();
        ((DefaultTableModel)swingTable1.getModel()).setRowCount(0);
        ((DefaultTableModel)swingTable2.getModel()).setRowCount(0);
        getPendingReports();
        getCompletedReports();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                swingTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                swingTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                swingTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                swingTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                swingTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                swingTable1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                swingTable1.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
                
                swingTable2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                swingTable2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                swingTable2.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                swingTable2.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                swingTable2.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                swingTable2.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                swingTable2.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundCorner1 = new SwingClass.RoundCorner();
        jPanel1 = new javax.swing.JPanel();
        jButtonPending = new javax.swing.JButton();
        jButtonCompleted = new javax.swing.JButton();
        jPanelReportsBody = new javax.swing.JPanel();
        jScrollPanePending = new javax.swing.JScrollPane();
        roundCorner3 = new SwingClass.RoundCorner();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom = new com.toedter.calendar.JDateChooser();
        jButtonPrintPendingReports = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        roundCorner4 = new SwingClass.RoundCorner();
        DashboardSearch = new SwingCustiom.SwingSearch();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTotalPending = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        swingTable1 = new SwingCustiom.SwingTable();
        jScrollPaneCompleted = new javax.swing.JScrollPane();
        roundCorner2 = new SwingClass.RoundCorner();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        roundCorner5 = new SwingClass.RoundCorner();
        swingSearch2 = new SwingCustiom.SwingSearch();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        swingTable2 = new SwingCustiom.SwingTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jButtonPrintCompletedReports = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(java.awt.Color.white);

        roundCorner1.setBackground(java.awt.Color.white);

        jPanel1.setBackground(java.awt.Color.white);

        jButtonPending.setBackground(new java.awt.Color(11, 46, 70));
        jButtonPending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/document.png"))); // NOI18N
        jButtonPending.setText("Enrollments");
        jButtonPending.setToolTipText("");
        jButtonPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPendingActionPerformed(evt);
            }
        });

        jButtonCompleted.setBackground(new java.awt.Color(11, 46, 70));
        jButtonCompleted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/task.png"))); // NOI18N
        jButtonCompleted.setText("Data Updates");
        jButtonCompleted.setToolTipText("");
        jButtonCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompletedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButtonPending, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(jButtonCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPending, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanelReportsBody.setLayout(new java.awt.CardLayout());

        jScrollPanePending.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPanePending.setAutoscrolls(true);
        jScrollPanePending.setOpaque(false);

        roundCorner3.setBackground(java.awt.Color.white);

        jPanel3.setBackground(java.awt.Color.white);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Date From");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Date To");

        jDateChooserTo.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserTo.setDateFormatString("yyy-MM-dd");
        jDateChooserTo.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        jDateSearchFrom.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jDateSearchFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFromPropertyChange(evt);
            }
        });

        jButtonPrintPendingReports.setBackground(new java.awt.Color(11, 46, 70));
        jButtonPrintPendingReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/print.png"))); // NOI18N
        jButtonPrintPendingReports.setText("PRINT");
        jButtonPrintPendingReports.setToolTipText("");
        jButtonPrintPendingReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintPendingReportsActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(128, 125, 123));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/loupe.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateSearchFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(405, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jDateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPrintPendingReports, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButtonPrintPendingReports))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateSearchFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundCorner4.setBackground(java.awt.Color.white);

        DashboardSearch.setBackground(new java.awt.Color(240, 240, 240));
        DashboardSearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        DashboardSearch.setMinimumSize(new java.awt.Dimension(11, 42));
        DashboardSearch.setPreferredSize(new java.awt.Dimension(11, 42));
        DashboardSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DashboardSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout roundCorner4Layout = new javax.swing.GroupLayout(roundCorner4);
        roundCorner4.setLayout(roundCorner4Layout);
        roundCorner4Layout.setHorizontalGroup(
            roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashboardSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundCorner4Layout.setVerticalGroup(
            roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCorner4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(DashboardSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(java.awt.Color.white);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOTAL :");

        jTextFieldTotalPending.setEditable(false);
        jTextFieldTotalPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalPendingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTotalPending, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldTotalPending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        swingTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Police ID", "First Name", "Last Name", "Position Held", " Rank", "County", "State"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        swingTable1.setSelectionBackground(new java.awt.Color(0, 112, 54));
        jScrollPane3.setViewportView(swingTable1);

        javax.swing.GroupLayout roundCorner3Layout = new javax.swing.GroupLayout(roundCorner3);
        roundCorner3.setLayout(roundCorner3Layout);
        roundCorner3Layout.setHorizontalGroup(
            roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundCorner3Layout.createSequentialGroup()
                .addGroup(roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner3Layout.createSequentialGroup()
                        .addComponent(roundCorner4, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundCorner3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        roundCorner3Layout.setVerticalGroup(
            roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner3Layout.createSequentialGroup()
                .addGroup(roundCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundCorner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPanePending.setViewportView(roundCorner3);

        jPanelReportsBody.add(jScrollPanePending, "card3");

        jScrollPaneCompleted.setBackground(new java.awt.Color(255, 255, 255));

        roundCorner2.setBackground(java.awt.Color.white);

        jPanel6.setBackground(java.awt.Color.white);

        roundCorner5.setBackground(java.awt.Color.white);

        swingSearch2.setBackground(new java.awt.Color(240, 240, 240));
        swingSearch2.setBorder(null);
        swingSearch2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        swingSearch2.setMinimumSize(new java.awt.Dimension(11, 42));
        swingSearch2.setPreferredSize(new java.awt.Dimension(11, 42));
        swingSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swingSearch2ActionPerformed(evt);
            }
        });
        swingSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                swingSearch2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout roundCorner5Layout = new javax.swing.GroupLayout(roundCorner5);
        roundCorner5.setLayout(roundCorner5Layout);
        roundCorner5Layout.setHorizontalGroup(
            roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(swingSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundCorner5Layout.setVerticalGroup(
            roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundCorner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner5Layout.createSequentialGroup()
                        .addComponent(swingSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Search From");

        jDateChooser3.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser3.setDateFormatString("yyy-MM-dd");
        jDateChooser3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Search From");

        jDateChooser4.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser4.setDateFormatString("yyy-MM-dd");
        jDateChooser4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundCorner5, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(80, 80, 80))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(roundCorner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
        );

        swingTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Police ID", "First Name", "Last Name", "Position Held", "Rank", "County", "State "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        swingTable2.setSelectionBackground(new java.awt.Color(0, 112, 54));
        jScrollPane4.setViewportView(swingTable2);

        jPanel4.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL :");

        jTextFieldTotal.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonPrintCompletedReports.setBackground(new java.awt.Color(128, 125, 123));
        jButtonPrintCompletedReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/print.png"))); // NOI18N
        jButtonPrintCompletedReports.setText("PRINT");
        jButtonPrintCompletedReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintCompletedReportsActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(128, 125, 123));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/loupe.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundCorner2Layout = new javax.swing.GroupLayout(roundCorner2);
        roundCorner2.setLayout(roundCorner2Layout);
        roundCorner2Layout.setHorizontalGroup(
            roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(576, Short.MAX_VALUE))
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPrintCompletedReports, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundCorner2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        roundCorner2Layout.setVerticalGroup(
            roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundCorner2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonPrintCompletedReports)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundCorner2Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        jScrollPaneCompleted.setViewportView(roundCorner2);

        jPanelReportsBody.add(jScrollPaneCompleted, "card2");

        javax.swing.GroupLayout roundCorner1Layout = new javax.swing.GroupLayout(roundCorner1);
        roundCorner1.setLayout(roundCorner1Layout);
        roundCorner1Layout.setHorizontalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelReportsBody, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelReportsBody, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundCorner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPendingActionPerformed
        // TODO add your handling code here:
        jPanelReportsBody.removeAll();
        jPanelReportsBody.repaint();
        jPanelReportsBody.revalidate();
        jPanelReportsBody.add(jScrollPanePending);
        jPanelReportsBody.repaint();
        jPanelReportsBody.revalidate();
    }//GEN-LAST:event_jButtonPendingActionPerformed

    private void jButtonCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompletedActionPerformed
        // TODO add your handling code here:
        jPanelReportsBody.removeAll();
        jPanelReportsBody.repaint();
        jPanelReportsBody.revalidate();
        jPanelReportsBody.add(jScrollPaneCompleted);
        jPanelReportsBody.repaint();
        jPanelReportsBody.revalidate();
    }//GEN-LAST:event_jButtonCompletedActionPerformed

    private void DashboardSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DashboardSearchKeyReleased
       
        ((DefaultTableModel)swingTable1.getModel()).setRowCount(0);
     
        try {
            searchPermits();
        } catch (SQLException ex) {
            Logger.getLogger(FragmentReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DashboardSearchKeyReleased

    private void swingSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_swingSearch2KeyReleased
        // TODO add your handling code here:
        ((DefaultTableModel)swingTable2.getModel()).setRowCount(0);
      
        try {
            searchPermits2();
        } catch (SQLException ex) {
            Logger.getLogger(FragmentReports.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_swingSearch2KeyReleased

    private void jDateSearchFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFromPropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jDateSearchFromPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        getPendingReportsByDate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonPrintPendingReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintPendingReportsActionPerformed
        // TODO add your handling code here:
        displayReport();
    }//GEN-LAST:event_jButtonPrintPendingReportsActionPerformed

    private void jButtonPrintCompletedReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintCompletedReportsActionPerformed
        // TODO add your handling code here:
        displayReport2();
    }//GEN-LAST:event_jButtonPrintCompletedReportsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        getCompletedReportsByDate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldTotalPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalPendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalPendingActionPerformed

    private void swingSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swingSearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_swingSearch2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingCustiom.SwingSearch DashboardSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCompleted;
    private javax.swing.JButton jButtonPending;
    private javax.swing.JButton jButtonPrintCompletedReports;
    private javax.swing.JButton jButtonPrintPendingReports;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private com.toedter.calendar.JDateChooser jDateSearchFrom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelReportsBody;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPaneCompleted;
    private javax.swing.JScrollPane jScrollPanePending;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldTotalPending;
    private SwingClass.RoundCorner roundCorner1;
    private SwingClass.RoundCorner roundCorner2;
    private SwingClass.RoundCorner roundCorner3;
    private SwingClass.RoundCorner roundCorner4;
    private SwingClass.RoundCorner roundCorner5;
    private SwingCustiom.SwingSearch swingSearch2;
    private SwingCustiom.SwingTable swingTable1;
    private SwingCustiom.SwingTable swingTable2;
    // End of variables declaration//GEN-END:variables

    
    private void searchPermits() throws SQLException{
    Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ResultSet rs = null;
         connection = DBConnect.ConnecrDb();
        Statement stmt = connection.createStatement();

        try {
           
            if(DashboardSearch.getText().equals("")){
                String sql1 = "SELECT registration_number,first_name,middle_name,surname,rank,state,county,biocapture_status "
                    + "FROM police_details WHERE biocapture_status = 1";
                resultSet =stmt.executeQuery(sql1);
            }else{
           
            String sql = "SELECT registration_number,first_name,middle_name,surname,rank,state,county,biocapture_status "
                    + "FROM police_details"
                    + " WHERE biocapture_status ='"+ 1 +"' AND registration_number LIKE '%" + DashboardSearch.getText() + "%' OR date_birth LIKE '%" + DashboardSearch.getText()  + "%' OR first_name LIKE'%" + DashboardSearch.getText()  + "%' OR middle_name LIKE '%" + DashboardSearch.getText()  + "%' OR surname LIKE '%" + DashboardSearch.getText()  + "%'OR rank LIKE '%" + DashboardSearch.getText()  + "%'OR state LIKE '%" + DashboardSearch.getText()  + "%'" ;

            statement = connection.prepareStatement(sql);
           

            resultSet = statement.executeQuery();
            }
            if (resultSet == null) {
                System.err.println("null result set");
            }

            DefaultTableModel model = (DefaultTableModel) swingTable1.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {

                
                User reports = new User(resultSet.getString("registration_number"),resultSet.getString("first_name"),
                        resultSet.getString("middle_name"), resultSet.getString("surname"),
                        resultSet.getString("rank"), resultSet.getString("state"),
                        resultSet.getString("county"),resultSet.getString("biocapture_status")
                        );
                Object[] row = new Object[8];

                row[0] = reports.getpermitNo();
                row[1] = reports.getfirstName();
                row[2] = reports.getlastName();
                row[3] = reports.getoperator();
                row[4] = reports.getspeciality();
                row[5] = reports.getapplicant_id();
                row[6] = reports.getreaddate();
                //row[7] = reports.getbiocapture_status().equals("0")? StatusType.Capture: StatusType.Reset;

                model.addRow(row);
            }
            
                Integer rows = model.getRowCount();
                 String total = rows.toString();
                jTextFieldTotalPending.setText(total);

            if (model.getRowCount() < 1) {
                JOptionPane.showMessageDialog(null, "No Application found", "Error", JOptionPane.ERROR_MESSAGE, null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();

        } finally {
            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void searchPermits2() throws SQLException{
    Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
          connection = DBConnect.ConnecrDb();
          Statement stmt = connection.createStatement();
        try {
            
             if(swingSearch2.getText().equals("")){
                String sql1 = "SELECT registration_number,first_name,middle_name,surname,rank,state,county,update_status "
                    + "FROM police_details WHERE update_status >= 1";
                resultSet =stmt.executeQuery(sql1);
            }else{
           
            String sql = "SELECT registration_number,first_name,middle_name,surname,rank,state,county,update_status "
                    + "FROM police_details"
                    + " WHERE update_status >= '"+ 1 +"' AND registration_number LIKE '%" + swingSearch2.getText() + "%' OR date_birth LIKE '%" + swingSearch2.getText()  + "%' OR first_name LIKE'%" + swingSearch2.getText()  + "%' OR middle_name LIKE '%" + swingSearch2.getText()  + "%' OR surname LIKE '%" + swingSearch2.getText()  + "%'OR rank LIKE '%" + swingSearch2.getText()  + "%'OR state LIKE '%" + swingSearch2.getText()  + "%'" ;

            statement = connection.prepareStatement(sql);
           

            resultSet = statement.executeQuery();
             }
            if (resultSet == null) {
                System.err.println("null result set");
            }

            DefaultTableModel model = (DefaultTableModel) swingTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {

                
                User reports = new User(resultSet.getString("registration_number"),resultSet.getString("first_name"),
                        resultSet.getString("middle_name"), resultSet.getString("surname"),
                        resultSet.getString("rank"), resultSet.getString("state"),
                        resultSet.getString("county"),resultSet.getString("update_status")
                        );
                Object[] row = new Object[8];

                row[0] = reports.getpermitNo();
                row[1] = reports.getfirstName();
                row[2] = reports.getlastName();
                row[3] = reports.getoperator();
                row[4] = reports.getspeciality();
                row[5] = reports.getapplicant_id();
                row[6] = reports.getreaddate();
                //row[7] = reports.getbiocapture_status().equals("0")? StatusType.Capture: StatusType.Reset;

                model.addRow(row);
            }
            
                Integer rows = model.getRowCount();
                 String total = rows.toString();
                jTextFieldTotal.setText(total);

            if (model.getRowCount() < 1) {
                JOptionPane.showMessageDialog(null, "No Application found", "Error", JOptionPane.ERROR_MESSAGE, null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();

        } finally {
            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     
    private void displayReport(){
    JasperPrint jasperPrint = generateReport();
    JasperViewer jasperViewer = new JasperViewer(jasperPrint);
    jasperViewer.viewReport(jasperPrint, false);
    }
    
    private JasperPrint generateReport(){
    JasperPrint jasperPrint = null;
    String name = "pending_permits";
     Map param = new HashMap();
     
     String url = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaalogo.png";
     String path = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaabackground.png";
     param.put("logo", url);
     param.put("background", path);
     
     
     param.put("Device Type", "Application Number");
     param.put("Device Name", "First Name");
     param.put("Serial Number", "Last Name");
     param.put("Driver Location", "Operator");
     param.put("SDK Location", "Speciality");
     param.put("Device Status", "Applicant ID");
    

     JRTableModelDataSource datasource = new JRTableModelDataSource(swingTable1.getModel());
    try{
   String source1 = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\futuristicbio\\biometrics\\" + name + ".jrxml";
    JasperReport jasperReport = JasperCompileManager.compileReport(source1);
    jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JRTableModelDataSource(swingTable1.getModel()));
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
    String name = "completed_permits";
     Map param = new HashMap();
     
     String url = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaalogo.png";
     String path = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaabackground.png";
     param.put("logo", url);
     param.put("background", path);
     
     
     param.put("Device Type", "Application Number");
     param.put("Device Name", "First Name");
     param.put("Serial Number", "Last Name");
     param.put("Driver Location", "Operator");
     param.put("SDK Location", "Speciality");
     param.put("Device Status", "Applicant ID");
    

     JRTableModelDataSource datasource = new JRTableModelDataSource(swingTable2.getModel());
    try{
   String source1 = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\futuristicbio\\biometrics\\" + name + ".jrxml";
    JasperReport jasperReport = JasperCompileManager.compileReport(source1);
    jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JRTableModelDataSource(swingTable2.getModel()));
    }catch(JRException e){
        e.printStackTrace();
                System.out.println("reports Error  " + e.toString());
    }
    return jasperPrint;
    }
    
    private void getPendingReportsByDate(){
        Date date = jDateSearchFrom.getDate();
        Date date1 = jDateChooserTo.getDate();
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        
        
        if(date1 != null && date.after(date1) && date != null){
               //Show error
               System.out.println("Date1 is after Date2");
              
           }else {
        String date2 = (date != null)? dcn.format(jDateSearchFrom.getDate() ): "";
        String date3 = (date1 != null)? dcn.format(jDateChooserTo.getDate() ): "";
        System.out.println(date2);
        System.out.println(date3);
        
          if(!"".equals(date3)){
            ((DefaultTableModel)swingTable1.getModel()).setRowCount(0);
            try {
                
             ArrayList<DataNewRequests> request = new ArrayList<>();
            CrudOperations crud = new CrudOperations();
            request = crud.searchPendingDateFrom(DashboardSearch.getText(),date2,date3);
               if (request.size() < 1) {
                            swingTable1.addRow(new Object[]{" ", " ", " ", " ", " ", " "});
                        } else {
                           for (int i = 0; i < request.size(); i++) {
                             DataNewRequests dnr = (DataNewRequests) request.get(i);
                
                           swingTable1.addRow(new Object[]{dnr.getpermitNo(), dnr.getfirstName(), dnr.getlastName(), dnr.getoperator(), dnr.getspeciality(), dnr.getapplicant_id(),dnr.getcounty()});
              
               DefaultTableModel model =((DefaultTableModel)swingTable1.getModel());
                 Integer rows = model.getRowCount();
                 String total = rows.toString();
                jTextFieldTotalPending.setText(total);
                           
                           }
         }
        } catch (SQLException ex) {
            Logger.getLogger(FragmentReports.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No data found");
        }
        }
        }
     
    }
    
    private void getCompletedReportsByDate(){
        
         Date date = jDateChooser3.getDate();
        Date date1 = jDateChooser4.getDate();
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        
        
        if(date1 != null && date.after(date1) && date != null){
               //Show error
               System.out.println("Date1 is after Date2");
              
           }else {
        String date2 = (date != null)? dcn.format(jDateChooser3.getDate() ): "";
        String date3 = (date1 != null)? dcn.format(jDateChooser4.getDate() ): "";
        
          if(!"".equals(date3)){
            ((DefaultTableModel)swingTable2.getModel()).setRowCount(0);
            try {
                
             ArrayList<DataNewRequests> request = new ArrayList<>();
            CrudOperations crud = new CrudOperations();
            request = crud.searchCompletedDateFrom(swingSearch2.getText(),date2,date3);
               if (request.size() < 1) {
                            swingTable2.addRow(new Object[]{" ", " ", " ", " ", " ", " "});
                        } else {
                           for (int i = 0; i < request.size(); i++) {
                             DataNewRequests dnr = (DataNewRequests) request.get(i);
                
                           swingTable2.addRow(new Object[]{dnr.getpermitNo(), dnr.getfirstName(), dnr.getlastName(), dnr.getoperator(), dnr.getspeciality(), dnr.getapplicant_id(),dnr.getcounty()});
            
                  DefaultTableModel model =((DefaultTableModel)swingTable2.getModel());
                 Integer rows = model.getRowCount();
                 String total = rows.toString();
                jTextFieldTotal.setText(total);
                           
                           }
         }
        } catch (SQLException ex) {
            Logger.getLogger(FragmentReports.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No data found");
        }
        }
        }
    
    }

    private void getPendingReports() {
      
             listingApplicants = new ArrayList<>();
        listingApplicants = new CrudOperations().getAllEnrollments();
        if (listingApplicants.size() > 0) {
            for (int i = 0; i < listingApplicants.size(); i++) {
                EnrollmentDetails details = listingApplicants.get(i);
                swingTable1.addRow(new Object[]{details.getPoliceId(), details.getFirstName(), details.getSurname(), details.getPosition(),
                    details.getRank(), details.getCounty(), details.getState()});
              
                

            int rowCount = ((DefaultTableModel)swingTable1.getModel()).getRowCount();
            String rowss = Integer.toString(rowCount);
            jTextFieldTotalPending.setText(rowss);
            }
        } else {
            //should add empty table row
            System.out.println("No Applicant found");
        }
  
    }

    private void getCompletedReports() {
       listingApplicants = new ArrayList<>();
        listingApplicants = new CrudOperations().getAllDataUpdates();
        if (listingApplicants.size() > 0) {
            for (int i = 0; i < listingApplicants.size(); i++) {
                EnrollmentDetails details = listingApplicants.get(i);
                swingTable2.addRow(new Object[]{details.getPoliceId(), details.getFirstName(), details.getSurname(), details.getPosition(),
                    details.getRank(), details.getCounty(), details.getState()});

                

            int rowCount = ((DefaultTableModel)swingTable2.getModel()).getRowCount();
            String rowss = Integer.toString(rowCount);
            jTextFieldTotal.setText(rowss);
            }
        } else {
            //should add empty table row
            System.out.println("No Applicant found");
        }
    }
}
