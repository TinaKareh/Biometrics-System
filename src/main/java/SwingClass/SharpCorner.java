
package SwingClass;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class SharpCorner extends javax.swing.JPanel {

   
    public SharpCorner() {
        initComponents();
        setOpaque(false);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        //round none
        //g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, getHeight());
        //all round
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
