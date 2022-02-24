/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import Fragments.FragmentMicrosoftLifecam;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamViewer;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Futuristic Ltd
 */
public class TestWebcam extends javax.swing.JFrame implements WebcamListener, WindowListener, UncaughtExceptionHandler, ItemListener  {
    private String applicantId;
    Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\kaabackground.png");    
    private FragmentMicrosoftLifecam life;
    /**
     * Creates new form TestWebcam
     */
    public TestWebcam() {
         initComponents();
         addItems();
         captureImage();
    }
    
     public TestWebcam(FragmentMicrosoftLifecam life,String applicantId) {
         this.applicantId =applicantId;
         this.life =life;
         initComponents();
         addItems();
         captureImage();
    }
    
    private static final long serialVersionUID = 1L;

	//private static final Logger LOG = (Logger) LoggerFactory.getLogger(TestWebcam.class);

	private Webcam webcam = null;
	private WebcamPanel panel = null;
	private WebcamPicker picker = null;
        public JButton button = null;
	

	public void addItems() {

		this.setTitle("Webcam Capture Viewer");
		this.setLayout(new BorderLayout());
		this.addWindowListener((WindowListener) this);
                this.setResizable(false);
		picker = new WebcamPicker();
		picker.addItemListener(this);

		webcam = picker.getSelectedWebcam();

		if (webcam == null) {
                    System.out.println("No webcams found");
			System.exit(1);
		}

		webcam.setViewSize(WebcamResolution.VGA.getSize());
                //webcam./*addWebcamListener*/(WebcamViewer.this);

		panel = new WebcamPanel(webcam, false);
		panel.setFPSDisplayed(true);
                JPanel buttons = new JPanel();
                button = new JButton();
                button.setText("Capture");
                //String path = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\Icons\\camera.png";
                Icon icon = new ImageIcon("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\src\\main\\java\\resources\\Icons\\camera.png");
                button.setIcon(icon);
                buttons.add(button);

		this.add(picker, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
                this.add(buttons,BorderLayout.SOUTH);
		this.pack();
		//this.setVisible(true);
                        
		Thread t = new Thread() {

			@Override
			public void run() {
				panel.start();
			}
		};
		t.setName("webcam-viewer-starter");
		t.setDaemon(true);
		t.setUncaughtExceptionHandler(this);
		t.start();
	}

        public void captureImage(){
            
                 button.addActionListener(new ActionListener() { 
         
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            
                            BufferedImage image = webcam.getImage();
                            String filename = "_IMG_001.JPG";
                            String image2 = applicantId.toString().concat(filename);       
                            String path = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\photos\\"+ applicantId.toString().concat(filename);

       
                                try {
                                File imgFile = new File(path);
                                     // save image to PNG file
                                 ImageIO.write(image, "JPG", imgFile);
                                //display image
                                Window window = SwingUtilities.windowForComponent(button);
                                window.dispose();
                                webcam.close();
                                life.displayPhotograph();
                                } catch (IOException ex) {
                       Logger.getLogger(TestWebcam.class.getName()).log(Level.SEVERE, null, ex);
                            }
                             }                              
                         } );
                }
	
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(icon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TestWebcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestWebcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestWebcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestWebcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestWebcam().setVisible(true);
            }
        });
    }

    @Override
    public void webcamOpen(WebcamEvent we) {
      // LOG.info("Webcam opened");  
    }

    @Override
    public void webcamClosed(WebcamEvent we) {
      //LOG.info("Webcam closed");  
    }

    @Override
    public void webcamDisposed(WebcamEvent we) {
            //LOG.info("Webcam disposed");   
    }

    @Override
    public void webcamImageObtained(WebcamEvent we) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
		webcam.close();
    }

    @Override
    public void windowIconified(WindowEvent e) {
         //LOG.info("Webcam viewer paused");
		panel.pause();    }

    @Override
    public void windowDeiconified(WindowEvent e) {
       //LOG.info("Webcam viewer resumed");
		panel.resume();    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
    @Override
	public void uncaughtException(Thread t, Throwable e) {
		e.printStackTrace();
		//LOG.error(String.format("Exception in thread %s", t.getName()), e);
	}

    @Override
    public void itemStateChanged(ItemEvent e) {
                 
        if (e.getItem() == webcam) {
			return;
		}

		if (webcam == null) {
			return;
		}

		final WebcamPanel tmp = panel;

		remove(panel);

		webcam.removeWebcamListener(this);

		webcam = (Webcam) e.getItem();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.addWebcamListener(this);

		System.out.println("selected " + webcam.getName());

		panel = new WebcamPanel(webcam, false);

		add(panel, BorderLayout.CENTER);

		Thread t = new Thread() {

			@Override
			public void run() {
				tmp.stop();
				panel.start();
			}
		};
		t.setDaemon(true);
		t.setUncaughtExceptionHandler(this);
		t.start();    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
