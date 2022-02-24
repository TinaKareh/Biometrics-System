/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import DataModel.StatusType;
import futuristicbio.biometrics.CrudBean;
import futuristicbio.biometrics.EnrollmentDetails;
import futuristicbio.biometrics.NewBiometricDevices;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Futuristic Ltd
 */
public class FragmentPendingCompletion extends javax.swing.JPanel {

    private ArrayList<EnrollmentDetails> pendingCompletion;

    /**
     * Creates new form FragmentPendingCompletion
     */
    public FragmentPendingCompletion() {
        initComponents();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableSwing91.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableSwing91.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableSwing91.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tableSwing91.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tableSwing91.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tableSwing91.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tableSwing91.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        ((DefaultTableModel) tableSwing91.getModel()).setRowCount(0);
        init();
    }

    private void init() {

        pendingCompletion = new ArrayList<>();
        pendingCompletion = new CrudBean().getPendingApplications();
        if (pendingCompletion.size() > 0) {
            for (int i = 0; i < pendingCompletion.size(); i++) {
                EnrollmentDetails details = pendingCompletion.get(i);
                tableSwing91.addRow(new Object[]{details.getPoliceId(), details.getFirstName(), details.getSurname(), details.getPosition(),
                    details.getRank(), details.getCounty(), details.getState(), (details.getStatus().equals("0") ? StatusType.Continue : StatusType.Edit)});

                int rowCount = ((DefaultTableModel) tableSwing91.getModel()).getRowCount();
                String rowss = Integer.toString(rowCount);
                jTextField1.setText(rowss);
            }
        } else {
            //should add empty table row
            System.out.println("No Applicant found");
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
        swingSearch1 = new SwingCustiom.SwingSearch();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSwing91 = new SwingCustiom.TableSwing20();

        jPanel2.setBackground(java.awt.Color.white);

        swingSearch1.setBackground(new java.awt.Color(240, 240, 240));
        swingSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swingSearch1ActionPerformed(evt);
            }
        });
        swingSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                swingSearch1KeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(11, 46, 70));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icons/print.png"))); // NOI18N
        jButton1.setText("Print");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Total Records:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(swingSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(swingSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jScrollPane1.setBackground(java.awt.Color.white);

        tableSwing91.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Police ID", "First Name", "Last Name", "Position Held", "Rank", "County", "State", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSwing91.setSelectionBackground(new java.awt.Color(11, 46, 70));
        tableSwing91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSwing91MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSwing91);

        javax.swing.GroupLayout roundCorner1Layout = new javax.swing.GroupLayout(roundCorner1);
        roundCorner1.setLayout(roundCorner1Layout);
        roundCorner1Layout.setHorizontalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCorner1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void swingSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swingSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_swingSearch1ActionPerformed

    private void swingSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_swingSearch1KeyReleased

    }//GEN-LAST:event_swingSearch1KeyReleased

    private void tableSwing91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSwing91MouseClicked
        // TODO add your handling code here:
        int index = tableSwing91.getSelectedRow();
        int index2 = tableSwing91.getSelectedColumn();
        System.out.println("selected row is:" + index);
        System.out.println("selected Column is:" + index2);
        TableModel model = tableSwing91.getModel();
        String value1 = model.getValueAt(index, index2).toString();
        System.out.println(model.getValueAt(index, index2));
        System.out.println("String button is for " + value1);

        int value = (value1.equals("Continue") ? 1 : 0);

        if (value1.equals("Continue")) {
            System.out.println("Button clicked");

            String application_no = model.getValueAt(index, 0).toString();
            String first_name = model.getValueAt(index, 1).toString();
            String position = model.getValueAt(index, 3).toString();
            String last_name = model.getValueAt(index, 2).toString();
            String rank = model.getValueAt(index, 4).toString();
            String state = model.getValueAt(index, 5).toString();
            String county = model.getValueAt(index, 6).toString();

            NewBiometricDevices biometric = new NewBiometricDevices();
            biometric.setVisible(true);
            biometric.getPermitDetails(application_no, first_name, position, last_name, rank, state, county);
            this.setVisible(false);

        } else if (value1.equals("Edit")) {

            // provideResetOptions();
        }

    }//GEN-LAST:event_tableSwing91MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private SwingClass.RoundCorner roundCorner1;
    private SwingCustiom.SwingSearch swingSearch1;
    private SwingCustiom.TableSwing20 tableSwing91;
    // End of variables declaration//GEN-END:variables
}
