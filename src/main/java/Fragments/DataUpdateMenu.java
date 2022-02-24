/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import DataModel.DatalMenu;
import event.EventMenuSelected;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

/**
 *
 * @author Futuristic Ltd
 */
public class DataUpdateMenu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        leftSideMenu.addEventMenuSelected(event);
    }

    /**
     * Creates new form DataUpdateMenu
     */
    public DataUpdateMenu() {
        initComponents();
        setOpaque(false);
        leftSideMenu.setOpaque(false);
        init();
    }

    private void init() {
        leftSideMenu.addItem(new DatalMenu("17", "Home", DatalMenu.MenuType.MENU));
        leftSideMenu.addItem(new DatalMenu("17", "Dashboard", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("12", "Information Update", DatalMenu.MenuType.MENU));
        leftSideMenu.addItem(new DatalMenu("12", " New Information Update", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("15", "Approved Data Updates", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("16", "Rejected Data Updates", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("13", "Settings", DatalMenu.MenuType.MENU));
        leftSideMenu.addItem(new DatalMenu("13", "Profile", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("6", "Signout", DatalMenu.MenuType.TITLE));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sharpCorner1 = new SwingClass.SharpCorner();
        moveHeader = new SwingClass.SharpCorner();
        jLabel1 = new javax.swing.JLabel();
        leftSideMenu = new SwingCustiom.SwngListMenu<>();

        setPreferredSize(new java.awt.Dimension(243, 511));

        sharpCorner1.setBackground(new java.awt.Color(194, 208, 217));
        sharpCorner1.setToolTipText("");
        sharpCorner1.setPreferredSize(new java.awt.Dimension(243, 511));

        moveHeader.setBackground(new java.awt.Color(11, 46, 70));
        moveHeader.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mini-logo-removebg-preview (1).png"))); // NOI18N

        javax.swing.GroupLayout moveHeaderLayout = new javax.swing.GroupLayout(moveHeader);
        moveHeader.setLayout(moveHeaderLayout);
        moveHeaderLayout.setHorizontalGroup(
            moveHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moveHeaderLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(82, 82, 82))
        );
        moveHeaderLayout.setVerticalGroup(
            moveHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moveHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        leftSideMenu.setBackground(new java.awt.Color(194, 208, 217));
        leftSideMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftSideMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sharpCorner1Layout = new javax.swing.GroupLayout(sharpCorner1);
        sharpCorner1.setLayout(sharpCorner1Layout);
        sharpCorner1Layout.setHorizontalGroup(
            sharpCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(moveHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(leftSideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sharpCorner1Layout.setVerticalGroup(
            sharpCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sharpCorner1Layout.createSequentialGroup()
                .addComponent(moveHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(leftSideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sharpCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sharpCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void leftSideMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftSideMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_leftSideMenuMouseClicked

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#F8F8F8"), 0, getHeight(), Color.decode("#F8F8F8"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        //round only on the right side
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs); //To change body of generated methods, choose Tools | Templates.
    }

    private int x, y;

    public void initMoving(JFrame frame) {
        moveHeader.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

        });
        moveHeader.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private SwingCustiom.SwngListMenu<String> leftSideMenu;
    private SwingClass.SharpCorner moveHeader;
    private SwingClass.SharpCorner sharpCorner1;
    // End of variables declaration//GEN-END:variables
}
