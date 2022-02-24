
package Fragments;


import DataModel.DatalMenu;
import event.EventMenuSelected;
//import event.EventMenuSelected;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class FragmentMenu extends javax.swing.JPanel {

    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
        leftSideMenu.addEventMenuSelected(event);
    }
    
    public FragmentMenu() {
        initComponents();
        setOpaque(false);
        leftSideMenu.setOpaque(false);
        init();
    }

    private void init() {
        leftSideMenu.addItem(new DatalMenu("17", "Home", DatalMenu.MenuType.MENU));
        leftSideMenu.addItem(new DatalMenu("17", "Dashboard", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("4", "Reports", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("17", "Settings", DatalMenu.MenuType.MENU));
        leftSideMenu.addItem(new DatalMenu("2", "Users", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("3", "Devices", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("13", "Profile", DatalMenu.MenuType.TITLE));
        leftSideMenu.addItem(new DatalMenu("6", "Signout", DatalMenu.MenuType.TITLE));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sharpCorner1 = new SwingClass.SharpCorner();
        moveHeader = new SwingClass.SharpCorner();
        jLabel1 = new javax.swing.JLabel();
        leftSideMenu = new SwingCustiom.SwngListMenu<>();

        moveHeader.setBackground(new java.awt.Color(11, 46, 70));
        moveHeader.setPreferredSize(new java.awt.Dimension(243, 95));

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mini-logo-removebg-preview (1).png"))); // NOI18N

        javax.swing.GroupLayout moveHeaderLayout = new javax.swing.GroupLayout(moveHeader);
        moveHeader.setLayout(moveHeaderLayout);
        moveHeaderLayout.setHorizontalGroup(
            moveHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moveHeaderLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        moveHeaderLayout.setVerticalGroup(
            moveHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moveHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38))
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
                .addGap(0, 0, 0)
                .addComponent(leftSideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sharpCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#F8F8F8"), 0, getHeight(), Color.decode("#F8F8F8"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        //round only on the right side
        g2.fillRect(getWidth() -20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int x, y;
    public void initMoving(JFrame frame){
        moveHeader.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
            
        });
        moveHeader.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen()-x, e.getYOnScreen()-y);
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
