
package Fragments;

import futuristicbio.biometrics.Login_Frame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;


public class FragmentOverlay extends javax.swing.JPanel {

  
    public FragmentOverlay() {
        initComponents();
        sharpCorner1.setBackground(new Color(0, 0, 0, 255));
        sharpCorner2.setBackground(new Color(88, 88, 89, 255));
        sharpCorner3.setBackground(new Color(0, 0, 0, 255));
      //  OverlayLayer.setBac.setBackground(new Color(0, 0, 0, 123));kground(new Color(0, 0, 0, 123));
    }
    
//    public void initClcking(JFrame fram){
//        btnSplashToLogin.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                 
//                Login_Frame login = new Login_Frame();
//                login.setVisible(true);
//               
//                fram.dispose();
//                 
//            }
//            
//        
//        });
//    }
      
     

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bluebackground = new SwingClass.SharpCorner();
        sharpCorner1 = new SwingClass.SharpCorner();
        sharpCorner2 = new SwingClass.SharpCorner();
        sharpCorner3 = new SwingClass.SharpCorner();
        jLabel2 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(760, 731));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/justice_2_10.png"))); // NOI18N

        bluebackground.setBackground(new java.awt.Color(24, 103, 241));
        bluebackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sharpCorner1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sharpCorner2.setBackground(new java.awt.Color(204, 204, 255));
        sharpCorner2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sharpCorner3.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout sharpCorner3Layout = new javax.swing.GroupLayout(sharpCorner3);
        sharpCorner3.setLayout(sharpCorner3Layout);
        sharpCorner3Layout.setHorizontalGroup(
            sharpCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sharpCorner3Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        sharpCorner3Layout.setVerticalGroup(
            sharpCorner3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sharpCorner3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        sharpCorner2.add(sharpCorner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 13, 750, 420));

        sharpCorner1.add(sharpCorner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 19, 780, 450));

        bluebackground.add(sharpCorner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 34, 810, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bluebackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(259, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(369, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bluebackground, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(156, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(155, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingClass.SharpCorner bluebackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private SwingClass.SharpCorner sharpCorner1;
    private SwingClass.SharpCorner sharpCorner2;
    private SwingClass.SharpCorner sharpCorner3;
    // End of variables declaration//GEN-END:variables
}
