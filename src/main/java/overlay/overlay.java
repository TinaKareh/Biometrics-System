
package overlay;

import futuristicbio.biometrics.*;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;


public class overlay extends javax.swing.JPanel {


    public overlay() {
        initComponents();
        LBtopIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/UICons/kaabackground.png")).getImage().getScaledInstance(98, 98, Image.SCALE_SMOOTH)));
        shaowLogo.setBackground(new Color( 255, 236, 0 , 200));
        sharpCorner1.setBackground(new Color( 255, 236, 0 , 123));
    }
    
    public void setData(String[] params){
        LBStation.setText(params[0]);
        accessArea.setText(params[0]);
        LBSerialNo.setText(params[0]);
        LBExp.setText(params[0]);
        LBperator.setText(params[0]);
        LBReg.setText(params[0]);
        LBAVCode.setText(params[0]);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DynamicColor = new SwingClass.SharpCorner();
        sharpCorner2 = new SwingClass.SharpCorner();
        LBackground = new javax.swing.JLabel();
        shaowLogo = new SwingClass.SharpCorner();
        sharpCorner1 = new SwingClass.SharpCorner();
        LBtopIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LBStation = new javax.swing.JLabel();
        accessArea = new javax.swing.JLabel();
        LBSerialNo = new javax.swing.JLabel();
        LBExp = new javax.swing.JLabel();
        LBperator = new javax.swing.JLabel();
        LBReg = new javax.swing.JLabel();
        LBAVCode = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        QRCodeHolder = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DynamicColor.setBackground(new java.awt.Color(0, 82, 155));

        javax.swing.GroupLayout sharpCorner2Layout = new javax.swing.GroupLayout(sharpCorner2);
        sharpCorner2.setLayout(sharpCorner2Layout);
        sharpCorner2Layout.setHorizontalGroup(
            sharpCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        sharpCorner2Layout.setVerticalGroup(
            sharpCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        LBackground.setBackground(new java.awt.Color(255, 236, 0));
        LBackground.setForeground(new java.awt.Color(255, 236, 0));
        LBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UICons/kaabackground.png"))); // NOI18N

        LBtopIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBtopIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UICons/favicon.jpeg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 82, 155));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Kenya Airports Authority");

        LBStation.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        LBStation.setForeground(new java.awt.Color(0, 0, 0));
        LBStation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBStation.setText("JKIA");

        accessArea.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        accessArea.setForeground(new java.awt.Color(0, 0, 0));
        accessArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accessArea.setText("AIRSIDE VEHICLE / EQUIPMENT CERTIFICATE");

        LBSerialNo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        LBSerialNo.setForeground(new java.awt.Color(0, 0, 0));
        LBSerialNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBSerialNo.setText("Serial No: 21603");

        LBExp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LBExp.setForeground(new java.awt.Color(0, 0, 0));
        LBExp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBExp.setText("cc");

        LBperator.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LBperator.setForeground(new java.awt.Color(0, 0, 0));
        LBperator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBperator.setText("Operator:  KENYA AUEROTECH LTD");

        LBReg.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        LBReg.setForeground(new java.awt.Color(0, 0, 0));
        LBReg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBReg.setText("Reg No :  PT 03");

        LBAVCode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LBAVCode.setForeground(new java.awt.Color(0, 0, 0));
        LBAVCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBAVCode.setText("Av Code :  AVJK 29001");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Issued under Authority of Airport Manager");

        QRCodeHolder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout sharpCorner1Layout = new javax.swing.GroupLayout(sharpCorner1);
        sharpCorner1.setLayout(sharpCorner1Layout);
        sharpCorner1Layout.setHorizontalGroup(
            sharpCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sharpCorner1Layout.createSequentialGroup()
                .addGroup(sharpCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBperator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBAVCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sharpCorner1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(sharpCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sharpCorner1Layout.createSequentialGroup()
                                .addComponent(LBtopIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                                .addComponent(QRCodeHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LBStation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accessArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LBSerialNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LBReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(sharpCorner1Layout.createSequentialGroup()
                                .addComponent(LBExp, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 44, Short.MAX_VALUE)))))
                .addGap(8, 8, 8))
        );
        sharpCorner1Layout.setVerticalGroup(
            sharpCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sharpCorner1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(sharpCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(QRCodeHolder, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(LBtopIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LBStation)
                .addGap(8, 8, 8)
                .addComponent(accessArea)
                .addGap(8, 8, 8)
                .addComponent(LBSerialNo)
                .addGap(8, 8, 8)
                .addComponent(LBExp)
                .addGap(8, 8, 8)
                .addComponent(LBperator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LBReg)
                .addGap(18, 18, 18)
                .addComponent(LBAVCode)
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout shaowLogoLayout = new javax.swing.GroupLayout(shaowLogo);
        shaowLogo.setLayout(shaowLogoLayout);
        shaowLogoLayout.setHorizontalGroup(
            shaowLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(shaowLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sharpCorner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shaowLogoLayout.setVerticalGroup(
            shaowLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(shaowLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sharpCorner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DynamicColorLayout = new javax.swing.GroupLayout(DynamicColor);
        DynamicColor.setLayout(DynamicColorLayout);
        DynamicColorLayout.setHorizontalGroup(
            DynamicColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DynamicColorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(shaowLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(DynamicColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DynamicColorLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(LBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addGap(24, 24, 24)))
            .addGroup(DynamicColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DynamicColorLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(sharpCorner2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
        );
        DynamicColorLayout.setVerticalGroup(
            DynamicColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DynamicColorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(shaowLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(DynamicColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DynamicColorLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(LBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)))
            .addGroup(DynamicColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DynamicColorLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(sharpCorner2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
        );

        add(DynamicColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 21, 460, 440));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingClass.SharpCorner DynamicColor;
    public javax.swing.JLabel LBAVCode;
    public javax.swing.JLabel LBExp;
    public javax.swing.JLabel LBReg;
    public javax.swing.JLabel LBSerialNo;
    public javax.swing.JLabel LBStation;
    private javax.swing.JLabel LBackground;
    public javax.swing.JLabel LBperator;
    private javax.swing.JLabel LBtopIcon;
    public javax.swing.JLabel QRCodeHolder;
    private javax.swing.JLabel accessArea;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private SwingClass.SharpCorner shaowLogo;
    private SwingClass.SharpCorner sharpCorner1;
    private SwingClass.SharpCorner sharpCorner2;
    // End of variables declaration//GEN-END:variables
}
