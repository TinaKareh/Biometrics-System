
package SwingCustiom;

import DataModel.StatusType;


public class CellStatus extends javax.swing.JPanel {

    
     public CellStatus(StatusType type) {
        initComponents();
        status.setType(type);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new SwingCustiom.TableStatus();

        setBackground(new java.awt.Color(255, 255, 255));

        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("Check");
        status.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingCustiom.TableStatus status;
    // End of variables declaration//GEN-END:variables
}
