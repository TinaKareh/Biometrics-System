/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import futuristicbio.biometrics.NetworkException;
import futuristicbio.biometrics.NewBiometricDevices;
import futuristicbio.biometrics.Realscan;
import futuristicbio.biometrics.RealscanG_Fingerprints;
import futuristicbio.biometrics.Realscan_Fingerprints;
import futuristicbio.biometrics.ThreadLocalStorage;
import futuristicbio.biometrics.UploadAndSave;
import futuristicbio.biometrics.UserContext;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Futuristic Ltd
 */
public class FragmentRealscanG extends javax.swing.JPanel {

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
    private String applicantId;
    private String application_no;
    private String user;
    private NewBiometricDevices devices;
    loadingFragment loading = new loadingFragment();
     private JDialog d ;

    /**
     * Creates new form FragmentRealscanG
     */
    public FragmentRealscanG() throws IOException {
        initComponents();
        setNewDataPaths();
        cleanTemporaryDirectories();
        //initiateImages();
    }
    
    public FragmentRealscanG(NewBiometricDevices devices,String application_no,String applicantId,String user) throws IOException {
        this.devices =devices;
         this.application_no =application_no;
        this.applicantId =applicantId;
        this.user = user;
        initComponents();
        setNewDataPaths();
        cleanTemporaryDirectories();
        //initiateImages();
    }
    
    
    public void setApplicantId(String applicantId,String application_no) {
      this.applicantId = applicantId;
      this.application_no =application_no;
    }
      
     public String getApplicantId() {
        return applicantId;
    }
     
     public String getApplication() {
        return application_no;
    }
    
 

    
     private void setNewDataPaths() {

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
            clientPngPath = path.concat("\\fingerprints\\png");
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
    
     private void cleanTemporaryDirectories() {

        try {
            FileUtils.cleanDirectory(new File(clientPngPath));
            FileUtils.cleanDirectory(new File(clientWsqPath));
            FileUtils.cleanDirectory(new File(clientRawPath));

        } catch (IOException e) {
            System.err.println("Failed to delete temporary dirs: " + e.getMessage());
            e.printStackTrace();
        }
    }
     
     private FragmentRealscanG displayfingerprints() throws IOException{
        System.out.println("Preparing fingerprints......");
        File directory = new File(clientPngPath);//local directory location
        System.out.println(directory);
        
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
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_THUMB.png"));  
                    //Write the image to the destination as a JPG  
                      ImageIO.write(image, "png", output);
                       ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_THUMB.png")).getImage().getScaledInstance(jLabel25.getWidth(), jLabel25.getHeight(), Image.SCALE_SMOOTH));
                     jLabel25.setIcon(imageIcon1);
                   } else if (filedirectory.getName().contains("LEFT_FORE")) {
                        
                         //Create file for the source  
                   File input = new File(filedirectory.getAbsolutePath());
                       //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                     //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_FORE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                      
                        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_FORE.png")).getImage().getScaledInstance(jLabel26.getWidth(), jLabel26.getHeight(), Image.SCALE_SMOOTH));
                       jLabel26.setIcon(imageIcon2);
                   } else if (filedirectory.getName().contains("LEFT_MIDDLE")) {
                        
                          //Create file for the source  
                     File input = new File(filedirectory.getAbsolutePath());
                       //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                     //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_MIDDLE.png"));  
                    //Write the image to the destination as a JPG  
                     ImageIO.write(image, "png", output);
                      
                       ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_MIDDLE.png")).getImage().getScaledInstance(jLabel27.getWidth(), jLabel27.getHeight(), Image.SCALE_SMOOTH));
                       jLabel27.setIcon(imageIcon3);
                   } else if (filedirectory.getName().contains("LEFT_RING")) {
                       
                        //Create file for the source  
                      File input = new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                       //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_RING.png"));  
                     //Write the image to the destination as a JPG  
                      ImageIO.write(image, "png", output);
                     
                       ImageIcon imageIcon4 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_RING.png")).getImage().getScaledInstance(jLabel28.getWidth(), jLabel28.getHeight(), Image.SCALE_SMOOTH));
                      jLabel28.setIcon(imageIcon4);
                   } else if (filedirectory.getName().contains("LEFT_LITTLE")) {
                        //Create file for the source  
                     File input = new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_LITTLE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                      ImageIcon imageIcon5 = new ImageIcon(new ImageIcon("C:\\\\Users\\\\Futuristic Ltd\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\kaa-biometrics\\\\IDMSBiometrics\\\\IDMSBiometrics\\\\target\\\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_LITTLE.png")).getImage().getScaledInstance(jLabel29.getWidth(), jLabel29.getHeight(), Image.SCALE_SMOOTH));
                       jLabel29.setIcon(imageIcon5);
                    } else if (filedirectory.getName().contains("RIGHT_THUMB")) {
                       
                         //Create file for the source  
                    File input = new File(filedirectory.getAbsolutePath());
                       //Read the file to a BufferedImage  
                   BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_THUMB.png"));  
                    //Write the image to the destination as a JPG  
                      ImageIO.write(image, "png", output);
                      
                        ImageIcon imageIcon6 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_THUMB.png")).getImage().getScaledInstance(jLabel30.getWidth(), jLabel30.getHeight(), Image.SCALE_SMOOTH));
                       jLabel30.setIcon(imageIcon6);
                   } else if (filedirectory.getName().contains("RIGHT_FORE")) {
                       
                          //Create file for the source  
                      File input = new File(filedirectory.getAbsolutePath());
                      //Read the file to a BufferedImage  
                     BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_FORE.png"));  
                     //Write the image to the destination as a JPG  
                      ImageIO.write(image, "png", output);
                      
                       ImageIcon imageIcon7 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_FORE.png")).getImage().getScaledInstance(jLabel31.getWidth(), jLabel31.getHeight(), Image.SCALE_SMOOTH));
                       jLabel31.setIcon(imageIcon7);
                    } else if (filedirectory.getName().contains("RIGHT_MIDDLE")) {
                       
                         //Create file for the source  
                    File input = new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                   File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_MIDDLE.png"));  
                     //Write the image to the destination as a JPG  
                     ImageIO.write(image, "png", output);
                      
                       ImageIcon imageIcon8 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_MIDDLE.png")).getImage().getScaledInstance(jLabel32.getWidth(), jLabel32.getHeight(), Image.SCALE_SMOOTH));
                       jLabel32.setIcon(imageIcon8);
                   } else if (filedirectory.getName().contains("RIGHT_RING")) {
                      
                        //Create file for the source  
                    File input= new File(filedirectory.getAbsolutePath());
                        //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_RING.png"));  
                    //Write the image to the destination as a JPG  
                    ImageIO.write(image, "png", output);
                       
                        ImageIcon imageIcon9 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_RING.png")).getImage().getScaledInstance(jLabel33.getWidth(), jLabel33.getHeight(), Image.SCALE_SMOOTH));
                       jLabel33.setIcon(imageIcon9);
                   } else if (filedirectory.getName().contains("RIGHT_LITTLE")) {
                       
                         //Create file for the source  
                     File input= new File(filedirectory.getAbsolutePath());
                         //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_LITTLE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                       
                        ImageIcon imageIcon10 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_LITTLE.png")).getImage().getScaledInstance(jLabel34.getWidth(), jLabel34.getHeight(), Image.SCALE_SMOOTH));
                        jLabel34.setIcon(imageIcon10);

                    }else if(filedirectory.getName().contains("RIGHT_CAPTURE")){
                    
                         //Create file for the source  
                     File input= new File(filedirectory.getAbsolutePath());
                         //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_CAPTURE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                       
                        ImageIcon imageIcon11 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("RIGHT_CAPTURE.png")).getImage().getScaledInstance(jLabel36.getWidth(), jLabel36.getHeight(), Image.SCALE_SMOOTH));
                        jLabel36.setIcon(imageIcon11);
                    }else if(filedirectory.getName().contains("LEFT_CAPTURE")){
                    
                         //Create file for the source  
                     File input= new File(filedirectory.getAbsolutePath());
                         //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_CAPTURE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                       
                        ImageIcon imageIcon12 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("LEFT_CAPTURE.png")).getImage().getScaledInstance(jLabel38.getWidth(), jLabel38.getHeight(), Image.SCALE_SMOOTH));
                        jLabel38.setIcon(imageIcon12);
                    }else if(filedirectory.getName().contains("THUMB_CAPTURE")){
                    
                         //Create file for the source  
                     File input= new File(filedirectory.getAbsolutePath());
                         //Read the file to a BufferedImage  
                    BufferedImage image = ImageIO.read(input);
                      //Create a file for the output  
                    File output = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\fingerprints\\png\\"+ applicantId.toString().concat("THUMB_CAPTURE.png"));  
                    //Write the image to the destination as a JPG  
                       ImageIO.write(image, "png", output);
                       
                        /*ImageIcon imageIcon12 = new ImageIcon(new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\realscan_fingerprints\\png\\"+ applicantId.toString().concat("LEFT_CAPTURE.png")).getImage().getScaledInstance(jLabel38.getWidth(), jLabel38.getHeight(), Image.SCALE_SMOOTH));
                        jLabel38.setIcon(imageIcon12);*/
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
                jLabel36.setIcon(null);
                jLabel38.setIcon(null);
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
        } 

        {
            return true;
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
        button1 = new java.awt.Button();
        jPanel19 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);

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
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
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
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
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
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
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
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
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
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel17.setText("Right Thumb");

        jLabel18.setText("Right Index");

        jLabel19.setText("Right Middle");

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel20.setText("Right Ring");

        jLabel21.setText("Right Little");

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
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOTH_FORE_FINGERS", "BOTH_THUMBS", "BOTH_HANDS_NO_THUMBS", "LEFT_FOUR", "RIGHT_FOUR" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Fully Amputated");

        jCheckBox2.setText("Partially Amputated");

        jCheckBox3.setText("Juvenile(Under 16)");

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
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jCheckBox1)
                                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(9, 9, 9)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox2)
                                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
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
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox3))))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        jLabel1.setText("Left Capture");

        jLabel2.setText("Right Capture");

        javax.swing.GroupLayout roundCorner1Layout = new javax.swing.GroupLayout(roundCorner1);
        roundCorner1.setLayout(roundCorner1Layout);
        roundCorner1Layout.setHorizontalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        roundCorner1Layout.setVerticalGroup(
            roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundCorner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundCorner1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1164, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(roundCorner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        UploadAndSave uploadAndSave = new UploadAndSave();
        Integer userId = Integer.parseInt(user);

        if (this.verifyResourceBeforeServerPush()) {

            try {
                JOptionPane.showMessageDialog(this, "Uploading to server", "Information", JOptionPane.INFORMATION_MESSAGE);
                /*uploadAndSave.uploadRealscanfingerprints(serverPngPath, clientPngPath,
                    applicantId, isJuvenile, isAmputee, isPartialAmputee);
                uploadAndSave.updateForm25(applicantId,application_no);
                uploadAndSave.updatePermitBiometrics(userId,applicantId);
                JOptionPane.showMessageDialog(this, "Successfully transfered files to server", "Information", JOptionPane.INFORMATION_MESSAGE);
                */
                devices.setForm(new FragmentFingerprint(devices,applicantId,user,true));
                 startThread();
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

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        /*realScan = new Realscan();
        try {
            realScan.getFingerprints(this);
        } catch (IOException ex) {
            Logger.getLogger(RealscanG_Fingerprints.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start \"\"", "demo_run.bat");
            File dir = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics");
            pb.directory(dir);
            Process p = pb.start();

            // wait 10 seconds
            System.out.println("Waiting...");
            System.out.println(p.isAlive());
            
            if(jCheckBox1.isSelected()){
                isAmputee = 1;
            
            }else if(jCheckBox2.isSelected()){
            
                isPartialAmputee = 1;
            }else if(jCheckBox3.isSelected()){
              
                isJuvenile = 1;
            }else{
              System.out.println("exempt checkboxes not selected");
            }

            startDisplay();
            //Thread.sleep(220000);
            //displayfingerprints();

            /*Thread.sleep(48000);
            for(int i=0;i<=18;i++){
                Thread.sleep(9000);
                File directory = new File(clientPngPath);//local directory location
                System.out.println("Display Fingerprints");
                System.out.println(directory.list().length);
                if(directory.list().length > 0){
                    displayfingerprints();
                }

            }*/
            System.out.println("Fingerprints Done");
            //JOptionPane.showMessageDialog(this, "Fingerprints Captured", "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(Realscan_Fingerprints.class.getName()).log(Level.SEVERE, null, ex);
        }/* catch (InterruptedException ex) {
            Logger.getLogger(Realscan_Fingerprints.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_button1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private SwingClass.RoundCorner roundCorner1;
    // End of variables declaration//GEN-END:variables

    private  void startThread(){
         SwingWorker sw1 = new SwingWorker() {
        Integer userId = Integer.parseInt(user);

              @Override
            protected String doInBackground() throws Exception 
            {
            UploadAndSave uploadAndSave = new UploadAndSave();
            try{    // define what thread will do here
             uploadAndSave.uploadRealscanfingerprints(serverPngPath, clientPngPath,
                    applicantId, isJuvenile, isAmputee, isPartialAmputee);
                uploadAndSave.updateForm25(applicantId,application_no);
                uploadAndSave.updatePermitBiometrics(userId,applicantId);
                JOptionPane.showMessageDialog(null,"Successfully transfered files to server", "Information", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e) {
                System.err.println(e.getMessage());
                if (e instanceof NetworkException) {
                    JOptionPane.showMessageDialog(null, "Network is Down, try again later", "Error", JOptionPane.ERROR_MESSAGE, null);
                 } else {
                    JOptionPane.showMessageDialog(null, "System failure, contact admin", "Error", JOptionPane.ERROR_MESSAGE, null);
                  
                }
            }
                String res = "Finished Execution";
                return res;
            }
            
            protected void done() 
            {
             }
        };
         sw1.execute(); 
    }
    
     private  void startDisplay(){
       d= new JDialog(this.devices , "Dialog Example");
       d.setUndecorated(true);
       d.setBackground(new Color(0, 0, 0, 0));
       ImageIcon imageIcon = new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\UICons\\loader.gif");
       JLabel label = new JLabel();
       label.setIcon(imageIcon);
       d.add(label);
       d.setBackground(new Color(0, 0, 0, 0));
       d.setLocationRelativeTo(null);
       d.setLayout( new FlowLayout() );
       d.setSize(300,200);  
       d.setVisible(true); 
             //loading.setVisible(true);
             button1.setEnabled(false);
             jButton2.setEnabled(false);
         SwingWorker sw1 = new SwingWorker() {

              @Override
            protected String doInBackground() throws Exception 
            {
               
            Thread.sleep(220000);
            displayfingerprints(); 
               String res = "Finished Execution";
                return res;
            }
            
            protected void done() 
            {
            d.setVisible(false);
            button1.setEnabled(true);
            jButton2.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Fingerprints Captured", "Information", JOptionPane.INFORMATION_MESSAGE);


            }
        };
         sw1.execute(); 
    }

}
