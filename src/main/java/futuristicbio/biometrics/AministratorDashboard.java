/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import Fragments.FragmentDashboard;
import Fragments.FragmentDeviceManagement;
import Fragments.FragmentProfile;
import Fragments.FragmentReports;
import Fragments.FragmentUserManagement;
import event.EventMenuSelected;
import java.awt.AWTEvent;
import java.awt.Image;
//import event.EventMenuSelected;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Futuristic Ltd
 */
public class AministratorDashboard extends javax.swing.JFrame implements ActionListener {

    private String title;
    Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\javaproject\\biometrics\\biometrics\\src\\main\\java\\resources\\mini-logo.png");    
    private static final int SESSION_TIMEOUT = 300 * 1000; // 30 sec timeout for testing purposes
    private final Timer invalidationTimer = new Timer(SESSION_TIMEOUT, this);
    private Integer pageCounter = 0;
    private UserContext context;
    
    public AministratorDashboard(String title){
        this.title=title;
        initComponents();
         setUserContext();
        CurrentDate();
         this.setExtendedState(JFrame.MAXIMIZED_BOTH);
           final AWTEventListener l = new AWTEventListener() {

            @Override
            public void eventDispatched(AWTEvent event) {
                // if any input event invoked - restart the timer to prolong the session
                invalidationTimer.restart();
            }        
        };
        Toolkit.getDefaultToolkit().addAWTEventListener(l, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);Toolkit.getDefaultToolkit().addAWTEventListener(l, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
        setForm(new FragmentDashboard());
        this.setVisible(true);
        init();
        
    }
    public AministratorDashboard() {
        initComponents();
        setUserContext();
        CurrentDate();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
          final AWTEventListener l = new AWTEventListener() {

            @Override
            public void eventDispatched(AWTEvent event) {
                // if any input event invoked - restart the timer to prolong the session
                invalidationTimer.restart();
            }        
        };
        Toolkit.getDefaultToolkit().addAWTEventListener(l, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);Toolkit.getDefaultToolkit().addAWTEventListener(l, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
        setForm(new FragmentDashboard());
        this.setVisible(true);
        init();
    }
    
     private void setUserContext() {
        context = (UserContext) ThreadLocalStorage.getUserContext();
  
        //jLabelName.setText(context.getFirstName() +" "+ context.getLastName());
        //jMenu1.setText(context.getFirstName() +" "+ context.getLastName());
        
      
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fragmentMenu1 = new Fragments.FragmentMenu();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        MainPanelContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(icon);

        jPanel5.setBackground(new java.awt.Color(11, 46, 70));
        jPanel5.setPreferredSize(new java.awt.Dimension(905, 94));

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SOUTH SUDAN NATIONAL POLICE SERVICE (S.S.N.P.S)");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/flag_3_20.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(11, 46, 70));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Copyright © 2022 SocketWorks. All Rights Reserved");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanelContainer.setBackground(java.awt.Color.white);
        MainPanelContainer.setLayout(new javax.swing.BoxLayout(MainPanelContainer, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fragmentMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                            .addComponent(MainPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(MainPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
                    .addComponent(fragmentMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AministratorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AministratorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AministratorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AministratorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new AministratorDashboard("Title").setVisible(true);
            }
        });

    }

    public void showMessage() {
        JOptionPane.showConfirmDialog(null, "Please enter correct details!");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanelContainer;
    private Fragments.FragmentMenu fragmentMenu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

    public void setForm(JComponent comp) {
        MainPanelContainer.removeAll();
        MainPanelContainer.add(comp);
        MainPanelContainer.repaint();
        MainPanelContainer.revalidate();
        
    }
    
     public void CurrentDate() {

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //jMenuDate.setText("Current date : " + day + "/" + (month + 1) + "/" + year);

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            String updatedAt = sdf.format(date);
            //Lbl_time.setText("Current time is "+updatedAt);

    }

    private void init() {
        
        
        fragmentMenu1.addEventMenuSelected(new EventMenuSelected(){
            @Override
            public void selected(int index) {
                if(index == 1){
                   //Dashboard
                   setForm(new FragmentDashboard());
                }
                else if (index == 4){
                    //user tab
                    setForm(new FragmentUserManagement(AministratorDashboard.this));
                }else if(index == 5){
                    //Device tab
                   setForm(new FragmentDeviceManagement(AministratorDashboard.this));
                }else if(index == 2){
                    //Reports tab
                    setForm(new FragmentReports());
                }else if(index ==6){     
                    setForm(new FragmentProfile());
                }else if(index ==7){           
                          Login_Frame s = new Login_Frame();
                           s.setVisible(true);
                         
                             AministratorDashboard.this.dispose();
               }else {
                    setForm(new FragmentDashboard());
//                        if(pageCounter == 0){
//
//                }
               
           }
    
        }
        
   });

}
    
   @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        if(pageCounter == 0){
        Login_Frame login = new Login_Frame();
        login.setVisible(true);
        }
         pageCounter = 2;
    }
}