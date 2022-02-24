/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import DataModel.DataSummaryCard;
import DataModel.StatusType;
import futuristicbio.biometrics.CrudOperations;
import futuristicbio.biometrics.DataApplicants;
import futuristicbio.biometrics.ThreadLocalStorage;
import futuristicbio.biometrics.UserContext;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Futuristic Ltd
 */
public class FragmentApprovalDashboard extends javax.swing.JPanel {

    private CrudOperations co;
     private UserContext context;
     private ArrayList<DataApplicants> listingApplicants;
    /**
     * Creates new form FragmentApprovalDashboard
     */
    public FragmentApprovalDashboard() {
        initComponents();
        co = new CrudOperations();
        ArrayList<String> values = co.getSummary();
        
        
        card1.setData(new DataSummaryCard("Total Data Update Requests", values.get(3), new ImageIcon(getClass().getResource("/resources/UICons/sale-report.png"))));
        card2.setData(new DataSummaryCard("Total Approved Data Update Requests", values.get(5), new ImageIcon(getClass().getResource("/resources/UICons/15.png"))));
        card3.setData(new DataSummaryCard("Total Rejected Data Update Requests", values.get(6), new ImageIcon(getClass().getResource("/resources/UICons/16.png"))));
        card4.setData(new DataSummaryCard("Total Pending Data Update Requests", values.get(7), new ImageIcon(getClass().getResource("/resources/UICons/44.png"))));
    
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
       centerRenderer.setHorizontalAlignment( JLabel.CENTER );
       tableSwing91.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
       tableSwing91.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
       tableSwing91.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
       tableSwing91.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
       tableSwing91.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
       tableSwing91.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
       tableSwing91.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
       ((DefaultTableModel)tableSwing91.getModel()).setRowCount(0);
       init();
    }
    
    private void init(){
      context = (UserContext) ThreadLocalStorage.getUserContext();
      String role = context.getRole();
        listingApplicants = new ArrayList<>();
        if(role.equals("Approval Officer")){
        listingApplicants = new CrudOperations().getLimitedDataUpdates();
        }else{
        listingApplicants = new CrudOperations().getLimitedRegistrations();
        }
        if (listingApplicants.size() > 0) {
            for (int i = 0; i < listingApplicants.size(); i++) {
                DataApplicants get = listingApplicants.get(i);
                tableSwing91.addRow(new Object[]{get.getpermitNo(), get.getfirstName(), get.getlastName(), get.getoperator()
                , get.getspeciality(), get.getapplicant_id(), get.getreaddate()});
          
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

        roundCorner2 = new SwingClass.RoundCorner();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        card1 = new Fragments.FragmentCardSummary();
        card2 = new Fragments.FragmentCardSummary();
        card3 = new Fragments.FragmentCardSummary();
        card4 = new Fragments.FragmentCardSummary();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSwing91 = new SwingCustiom.TableSwing20();

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jLayeredPane1.add(card1);
        jLayeredPane1.add(card2);
        jLayeredPane1.add(card3);
        jLayeredPane1.add(card4);

        jScrollPane3.setViewportView(jLayeredPane1);

        tableSwing91.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
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
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSwing91.setSelectionBackground(new java.awt.Color(0, 112, 54));
        tableSwing91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSwing91MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSwing91);

        javax.swing.GroupLayout roundCorner2Layout = new javax.swing.GroupLayout(roundCorner2);
        roundCorner2.setLayout(roundCorner2Layout);
        roundCorner2Layout.setHorizontalGroup(
            roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        roundCorner2Layout.setVerticalGroup(
            roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundCorner2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundCorner2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableSwing91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSwing91MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableSwing91MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Fragments.FragmentCardSummary card1;
    private Fragments.FragmentCardSummary card2;
    private Fragments.FragmentCardSummary card3;
    private Fragments.FragmentCardSummary card4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private SwingClass.RoundCorner roundCorner2;
    private SwingCustiom.TableSwing20 tableSwing91;
    // End of variables declaration//GEN-END:variables
}
