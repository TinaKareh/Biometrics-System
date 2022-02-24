/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Futuristic Ltd
 */
public class Realscan_Fingerprints extends javax.swing.JFrame {
    
    private Realscan realScan;
    String filename = null;
    byte[] person_image = null;
    private byte[] picture;
    private String serverPngPath;
    private String serverWsqPath;
    private String serverRawPath;
    private String clientPngPath;
    private String clientWsqPath;
    private String clientRawPath;
     private String defaultRoot;
    private int isJuvenile;
    private int isAmputee;
    private int isPartialAmputee;
    private UserContext context;
    boolean m_sessionClosed;
    private Integer applicantId;
    private String application_no;
    private Integer user;
    Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaabackground.png");    


    /**
     * Creates new form Realscan_Fingerprints
     */
    public Realscan_Fingerprints() throws IOException {
        initComponents();
        setNewDataPaths();
        cleanTemporaryDirectories();
        initiateImages();
        setUserContext();
        CurrentDate();
      
    }
    
      public void setApplicantId(Integer applicantId,String application_no) {
      this.applicantId = applicantId;
      this.application_no =application_no;
    }
      
     public Integer getApplicantId() {
        return applicantId;
    }
     
     public String getApplication() {
        return application_no;
    }
    
     private void setUserContext() {
        context = (UserContext) ThreadLocalStorage.getUserContext();
       
        //name.setText(context.getUserName() + "");
        userid.setText(context.getUserId() + "");

    }

    
     public void setNewDataPaths() {

        String path = null;
        Properties prop = new Properties();
        InputStream input = null;
        try {

            //initiate local paths
            String mypath = Realscan_Fingerprints.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            File file = new java.io.File(decodedPath);
            path = file.getParent();

            clientWsqPath = path.concat("\\fingerprints\\wsq");
            clientPngPath = path.concat("\\realscan_fingerprints\\png");
            clientRawPath = path.concat("\\fingerprints\\raw");
            
            //initiate remote paths
            input = Realscan_Fingerprints.class.getResourceAsStream("/resources/application.properties");
            prop.load(input);

            //serverPngPath = prop.getProperty("server.fingerPngPath");
            serverPngPath = "/var/www/html/biopng/";
            serverWsqPath = prop.getProperty("server.wsqPath");
            serverRawPath = prop.getProperty("server.rawPath");
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't load properties file");
            System.err.println(e.getMessage());
        }
    }
     
     public void initiateImages() throws IOException {
        displayfingerprints();
    }
    
     public void cleanTemporaryDirectories() {

        try {
            FileUtils.cleanDirectory(new File(clientPngPath));
            FileUtils.cleanDirectory(new File(clientWsqPath));
            FileUtils.cleanDirectory(new File(clientRawPath));


            checkbox1.setState(false);
            checkbox2.setState(false);
            checkbox3.setState(false);

        } catch (IOException e) {
            System.err.println("Failed to delete temporary dirs: " + e.getMessage());
            e.printStackTrace();
        }
    }
     
     public Realscan_Fingerprints displayfingerprints() throws IOException {
        System.out.println("Preparing fingerprints......");
        File directory = new File(clientPngPath);//local directory location
        
        
        if (directory.isDirectory()) {
           if (directory.list().length > 0) {
             System.out.println("Directory is not empty!");
              File[] listFiles = directory.listFiles();
             System.out.println(listFiles);
             for (File filedirectory : listFiles) {
                 if (filedirectory.getName().contains("LEFT_THUMB")) {
                      //Create file for the source  
                   File input = new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                     //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_THUMB.png"));  
                    //Write the image to the destination as a JPG  
                      ImageIO.write(image, "png", output);
                       ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_THUMB.png")).getImage().getScaledInstance(jLabel25.getWidth(), jLabel25.getHeight(), Image.SCALE_SMOOTH));
                     jLabel25.setIcon(imageIcon1);
                   } else if (filedirectory.getName().contains("LEFT_FORE")) {
                        
                         //Create file for the source  
                   File input = new File(filedirectory.getAbsolutePath());
                       //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                     //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_FORE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                      
                        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_FORE.png")).getImage().getScaledInstance(jLabel26.getWidth(), jLabel26.getHeight(), Image.SCALE_SMOOTH));
                       jLabel26.setIcon(imageIcon2);
                   } else if (filedirectory.getName().contains("LEFT_MIDDLE")) {
                        
                          //Create file for the source  
                     File input = new File(filedirectory.getAbsolutePath());
                       //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                     //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_MIDDLE.png"));  
                    //Write the image to the destination as a JPG  
                     ImageIO.write(image, "png", output);
                      
                       ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_MIDDLE.png")).getImage().getScaledInstance(jLabel27.getWidth(), jLabel27.getHeight(), Image.SCALE_SMOOTH));
                       jLabel27.setIcon(imageIcon3);
                   } else if (filedirectory.getName().contains("LEFT_RING")) {
                       
                        //Create file for the source  
                      File input = new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                       //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_RING.png"));  
                     //Write the image to the destination as a JPG  
                      ImageIO.write(image, "png", output);
                     
                       ImageIcon imageIcon4 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_RING.png")).getImage().getScaledInstance(jLabel28.getWidth(), jLabel28.getHeight(), Image.SCALE_SMOOTH));
                      jLabel28.setIcon(imageIcon4);
                   } else if (filedirectory.getName().contains("LEFT_LITTLE")) {
                        //Create file for the source  
                     File input = new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_LITTLE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                      ImageIcon imageIcon5 = new ImageIcon(new ImageIcon("C:\\\\Users\\\\Futuristic Ltd\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\kaa-biometrics\\\\IDMSBiometrics\\\\IDMSBiometrics\\\\target\\\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_LITTLE.png")).getImage().getScaledInstance(jLabel29.getWidth(), jLabel29.getHeight(), Image.SCALE_SMOOTH));
                       jLabel29.setIcon(imageIcon5);
                    } else if (filedirectory.getName().contains("RIGHT_THUMB")) {
                       
                         //Create file for the source  
                    File input = new File(filedirectory.getAbsolutePath());
                       //Read the file to a BufferedImage  
                   BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_THUMB.png"));  
                    //Write the image to the destination as a JPG  
                      ImageIO.write(image, "png", output);
                      
                        ImageIcon imageIcon6 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_THUMB.png")).getImage().getScaledInstance(jLabel30.getWidth(), jLabel30.getHeight(), Image.SCALE_SMOOTH));
                       jLabel30.setIcon(imageIcon6);
                   } else if (filedirectory.getName().contains("RIGHT_FORE")) {
                       
                          //Create file for the source  
                      File input = new File(filedirectory.getAbsolutePath());
                      //Read the file to a BufferedImage  
                     BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_FORE.png"));  
                     //Write the image to the destination as a JPG  
                      ImageIO.write(image, "png", output);
                      
                       ImageIcon imageIcon7 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_FORE.png")).getImage().getScaledInstance(jLabel31.getWidth(), jLabel31.getHeight(), Image.SCALE_SMOOTH));
                       jLabel31.setIcon(imageIcon7);
                    } else if (filedirectory.getName().contains("RIGHT_MIDDLE")) {
                       
                         //Create file for the source  
                    File input = new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_MIDDLE.png"));  
                     //Write the image to the destination as a JPG  
                     ImageIO.write(image, "png", output);
                      
                       ImageIcon imageIcon8 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_MIDDLE.png")).getImage().getScaledInstance(jLabel32.getWidth(), jLabel32.getHeight(), Image.SCALE_SMOOTH));
                       jLabel32.setIcon(imageIcon8);
                   } else if (filedirectory.getName().contains("RIGHT_RING")) {
                      
                        //Create file for the source  
                    File input= new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_RING.png"));  
                    //Write the image to the destination as a JPG  
                    ImageIO.write(image, "png", output);
                       
                        ImageIcon imageIcon9 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_RING.png")).getImage().getScaledInstance(jLabel33.getWidth(), jLabel33.getHeight(), Image.SCALE_SMOOTH));
                       jLabel33.setIcon(imageIcon9);
                   } else if (filedirectory.getName().contains("RIGHT_LITTLE")) {
                       
                         //Create file for the source  
                     File input= new File(filedirectory.getAbsolutePath());
                         //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_LITTLE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                       
                        ImageIcon imageIcon10 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_LITTLE.png")).getImage().getScaledInstance(jLabel34.getWidth(), jLabel34.getHeight(), Image.SCALE_SMOOTH));
                        jLabel34.setIcon(imageIcon10);

                    }else if(filedirectory.getName().contains("THUMB_CAPTURE")){
                    
                         //Create file for the source  
                     File input= new File(filedirectory.getAbsolutePath());
                         //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("THUMB_CAPTURE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                       
                        ImageIcon imageIcon11 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("THUMB_CAPTURE.png")).getImage().getScaledInstance(jLabel36.getWidth(), jLabel36.getHeight(), Image.SCALE_SMOOTH));
                        jLabel36.setIcon(imageIcon11);
                    }
               }
           } else {
                jLabel25.setIcon(null);
               jLabel26.setIcon(null);
              jLabel27.setIcon(null);
                jLabel28.setIcon(null);
                jLabel29.setIcon(null);
               jLabel30.setIcon(null);
                jLabel31.setIcon(null);
               jLabel32.setIcon(null);
               jLabel33.setIcon(null);
               jLabel34.setIcon(null);

                System.out.println("Directory is empty!");

            }

       }

        return this;
    }
     
     private boolean verifyResourceBeforeServerPush() {

        
        File fingerDirectory = new File(clientPngPath);

       
        File[] fingerFiles = fingerDirectory.listFiles();

        if ( fingerFiles.length < 1) {
            JOptionPane.showMessageDialog(null, "Capture all requirements!", "Error", JOptionPane.ERROR_MESSAGE, null);
            return false;
        } else if (fingerFiles.length < 1 && !excemptFromFingerCapture()) {
            JOptionPane.showMessageDialog(null, "Capture Finger prints first!", "Error", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }

        {
            return true;
        }

   }
     
      private boolean excemptFromFingerCapture() {

        if (checkbox1.isEnabled() && checkbox2.isEnabled()) {
            System.out.println("exempt checkboxes are enabled.....");

            if (checkbox1.getState()) {
                isAmputee = 1;
                System.out.println("full amputee, finger scanner exempt");
                return true;
            } else {
                isAmputee = 0;
            }
            if (checkbox2.getState()) {
                System.out.println("juvenile, finger scanner exempt");
                isJuvenile = 1;
                return true;

            } else {
                isJuvenile = 0;
            }
        } else {
            System.out.println("Check boxes not enabled");
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        userid = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        roundCorner1 = new SwingClass.RoundCorner();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        checkbox1 = new java.awt.Checkbox();
        checkbox2 = new java.awt.Checkbox();
        button1 = new java.awt.Button();
        jPanel19 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        checkbox3 = new java.awt.Checkbox();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fragmentFooter1 = new Fragments.FragmentFooter();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        Lbl_time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(icon);

        jPanel3.setBackground(new java.awt.Color(255, 215, 125));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Details Captured By: ");

        name.setText("Name");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        userid.setText("User ID");
        userid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridActionPerformed(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(0, 82, 155));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 82, 155));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Airport Permit & Identity Management System Biometrics Capture");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userid)
                            .addComponent(name))
                        .addGap(3, 3, 3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundCorner1.setBackground(java.awt.Color.white);

        jButton2.setText("Upload Fingerprints");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("FingerPrints");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jLabel12.setText("Left Thumb");

        jLabel13.setText("Left Index");

        jLabel14.setText("Left Middle");

        jLabel15.setText("Left Ring");

        jLabel16.setText("Left Little");

        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );

        jLabel17.setText("Right Thumb");

        jLabel18.setText("Right Index");

        jLabel19.setText("Right Middle");

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel20.setText("Right Ring");

        jLabel21.setText("Right Little");

        checkbox1.setLabel("Fully Amputated");
        checkbox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkbox1MouseClicked(evt);
            }
        });

        checkbox2.setLabel("Juvenile (Under 16)");
        checkbox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkbox2MouseClicked(evt);
            }
        });

        button1.setActionCommand("Capture Fingerprints");
        button1.setLabel("Capture Fingerprints");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOTH_FORE_FINGERS", "BOTH_THUMBS", "BOTH_HANDS_NO_THUMBS", "LEFT_FOUR", "RIGHT_FOUR" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        checkbox3.setLabel("Partially amputated");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(checkbox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(9, 9, 9)))
                                            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel15)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel16))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel21))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        );

        jLabel2.setText("Thumb Capture");

        javax.swing.GroupLayout roundCorner1Layout = new javax.swing.GroupLayout(roundCorner1);
        roundCorner1.setLayout(roundCorner1Layout);
        roundCorner1Layout.setHorizontalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundCorner1Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundCorner1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundCorner1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(69, 69, 69)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jMenu3.setForeground(new java.awt.Color(204, 0, 153));
        jMenu3.setText("Date");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu3);

        Lbl_time.setForeground(new java.awt.Color(204, 0, 153));
        Lbl_time.setText("Time");
        Lbl_time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(Lbl_time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fragmentFooter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundCorner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(fragmentFooter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void useridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useridActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

       UploadAndSave uploadAndSave = new UploadAndSave();
       String userId = userid.getText();
       user = Integer.parseInt(userId);
        if (this.verifyResourceBeforeServerPush()) {

            try {
                JOptionPane.showMessageDialog(this, "Uploading to server", "Information", JOptionPane.INFORMATION_MESSAGE);

               /* uploadAndSave.uploadRealscanfingerprints(serverPngPath, clientPngPath,
                        applicantId, isJuvenile, isAmputee, isPartialAmputee);
                uploadAndSave.updateForm25(applicantId,application_no);
               // uploadAndSave.updatePermitBiometrics(user,applicantId);
                JOptionPane.showMessageDialog(this, "Successfully transfered files to server", "Information", JOptionPane.INFORMATION_MESSAGE);
                dispose();*/

            } catch (Exception e) {
                System.err.println(e.getMessage());
                if (e instanceof NetworkException) {

                    JOptionPane.showMessageDialog(null, "Network is Down, try again later", "Error", JOptionPane.ERROR_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(null, "System failure, contact admin", "Error", JOptionPane.ERROR_MESSAGE, null);
                }
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkbox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkbox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox1MouseClicked

    private void checkbox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkbox2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox2MouseClicked

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
          
        realScan = new Realscan();
        try {
         ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start \"\"", "demo_run.bat");
         File dir = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics");
         pb.directory(dir);
         Process p = pb.start();
  
          // wait 10 seconds
         System.out.println("Waiting...");
         System.out.println(p.isAlive());
         
         
          Thread.sleep(180000);
          displayfingerprints();
         
        /* Thread.sleep(45000);
         for(int i=0;i<=20;i++){
         Thread.sleep(7000);
         File directory = new File(clientPngPath);//local directory location
         System.out.println("Display Fingerprints");
         System.out.println(directory.list().length);
         if(directory.list().length > 0){
          displayfingerprints();
          } 
         
         }*/
         System.out.println("Fingerprints Done");
         JOptionPane.showMessageDialog(this, "Fingerprints Captured", "Information", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException ex) {
            Logger.getLogger(Realscan_Fingerprints.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Realscan_Fingerprints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

      public void CurrentDate() {

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        jMenu3.setText("Current date : " + day + "/" + (month + 1) + "/" + year);

        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        Lbl_time.setText("Current time is  " + hour + " : " + minute + " : " + second);

    }
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
            java.util.logging.Logger.getLogger(Realscan_Fingerprints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Realscan_Fingerprints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Realscan_Fingerprints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Realscan_Fingerprints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Realscan_Fingerprints().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Realscan_Fingerprints.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Lbl_time;
    private java.awt.Button button1;
    private java.awt.Checkbox checkbox1;
    private java.awt.Checkbox checkbox2;
    private java.awt.Checkbox checkbox3;
    private Fragments.FragmentFooter fragmentFooter1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField name;
    private SwingClass.RoundCorner roundCorner1;
    private javax.swing.JTextField userid;
    // End of variables declaration//GEN-END:variables
}
