package Fragments;

import DataModel.Data2Menu;
import DataModel.DatalMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class FragmentMenuItem extends javax.swing.JPanel {

    private boolean selected;

    public FragmentMenuItem(DatalMenu data) {
        initComponents();
        setOpaque(false);
        if (data.getType() == DatalMenu.MenuType.MENU) {
            menuIconHolder.setIcon(data.toIcon());
            menuIconHolder.setVisible(false);
            menNameHolder.setText(data.getName());
        } else if (data.getType() == DatalMenu.MenuType.TITLE) {
            menNameHolder.setText(data.getName());
            menNameHolder.setFont(new Font("Segoe UI", 1, 12));
            //menNameHolder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            menuIconHolder.setIcon(data.toIcon());
            //menuIconHolder.setVisible(false);
        } else {
            menNameHolder.setText(" ");
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuIconHolder = new javax.swing.JLabel();
        menNameHolder = new javax.swing.JLabel();

        menuIconHolder.setForeground(new java.awt.Color(255, 255, 255));

        menNameHolder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menNameHolder.setText("Menu Name");
        menNameHolder.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(menuIconHolder)
                .addGap(16, 16, 16)
                .addComponent(menNameHolder, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuIconHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menNameHolder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (selected) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(239, 239, 239));
            //all round
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);

        } else {
        }
        super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel menNameHolder;
    private javax.swing.JLabel menuIconHolder;
    // End of variables declaration//GEN-END:variables
}
