package futuristicbio.biometrics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User-PC
 */
import Fragments.FragmentMorpho;
import com.morpho.mbop.api.Acquisition;
import com.morpho.mbop.api.AcquisitionDescriptor;
import com.morpho.mbop.api.AcquisitionType;
import com.morpho.mbop.api.Core;
import com.morpho.mbop.api.LogLevel;
import com.morpho.mbop.api.SingleAcquisition;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.MessageFormat;
import javax.swing.*;
import java.util.*;
import javax.swing.border.TitledBorder;

public class OptionsFrame extends javax.swing.JFrame {

    private FragmentMorpho applicant;
    private Core core;
    private Acquisition acquisition;
    private SingleAcquisition singleAcquisition;
    private AcquisitionType currentAcquisitionType;

    // Listeners
    private ExampleAcquisitionStateListener acquisitionListener;
    private ExampleDeviceStateListener deviceListener;

    // Main frame
    private static ExampleMainFrame mainFrame;
    private SingleAcquisitionFrame singleAcquisitionFrame;
    private Options options;

    boolean m__isStopped;

    boolean m__launchNewAcquisition = true;
    private String applicantId;
    private String selectedDevice = "MorphoTop.SLAP-Sensor.293583634-16062510328";

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public AcquisitionType getCurrentAcquisitionType() {
        return currentAcquisitionType;
    }

    public void setCurrentAcquisitionType(AcquisitionType currentAcquisitionType) {
        this.currentAcquisitionType = currentAcquisitionType;
    }

    public OptionsFrame(FragmentMorpho newApplicant) {
        applicant = newApplicant;
        sortPath();
    }

    public FragmentMorpho getApplicant() {
        return applicant;
    }

    private void sortPath() {
        String path = null;
        try {
            String mypath = OptionsFrame.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            java.io.File jar = new java.io.File(decodedPath);
            path = jar.getParent();

        } catch (java.lang.Exception e) {
            System.out.println("Error during path sorting");
            e.printStackTrace();
        }

        System.out.println("Loading library...");
        try {
            com.morpho.mbop.api.Loader.load(path);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return;
        }

    }

    public class FingeScannerBackgroundWorker extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            while (!m__isStopped) {

                if (m__launchNewAcquisition) {
                    m__launchNewAcquisition = false;
                    core.GetDevicesList();

                    selectedDevice = core.GetDevicesList()[0];
                    setCoreParameters();
                    System.out.println("publishing new acquisition");
                    publish();

                } else {

                    Thread.sleep(30);
                }

            }
            System.out.println("finishing loop......");
            return null;
        }

        @Override
        protected void done() {
            System.out.println("loop stopped .......");

        }

        @Override
        protected void process(List<Void> chunks) {
            try {
                startAquisition();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Exception caught (" + e.getClass().toString() + ") : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
                stopExample();

            }

        }

    }

    public void Run() {

        try {

            if (!applicant.m_sessionClosed) {

                System.out.println("testing run.......");
                System.out.println("ApplicationId set to : " + getApplicantId());
                // Get the configuration file
                byte[] configData = readLocalFile((new java.io.File(com.morpho.mbop.api.Loader.getPath(), "MorphoBOP_Config.dat")).getPath());

                // Initialize Core object
                ExampleLogListener logListener = new ExampleLogListener();
                core = new Core(logListener, LogLevel.INFORMATION, configData);
                String[] devices = core.GetDevicesList();
                options = new Options(devices);
                applicant.setM_sessionClosed(true);
                // Register a device listener in order to know when a device is connected or disconnected
                deviceListener = new ExampleDeviceStateListener(this);
                core.RegisterDeviceStateListener(deviceListener);

            } else {

                System.out.println("m__isStopped: " + m__isStopped);

            }

            FingeScannerBackgroundWorker fsWorker = new FingeScannerBackgroundWorker();
            fsWorker.execute();

            // While it is not asked to stop
        } catch (com.morpho.mbop.api.InvalidOrMissingLicenseException e) {
            JOptionPane.showMessageDialog(null, "Invalid license", "Error", JOptionPane.ERROR_MESSAGE, null);
            stopExample();
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Licence not found", "Error", JOptionPane.ERROR_MESSAGE, null);
            stopExample();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Exception caught (" + e.getClass().toString() + ") : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
            stopExample();
        }

    }

    public void setCoreParameters() throws Exception {

        // Set the parameters values obtained in the options frame
        core.SetParameter("sensor." + selectedDevice + ".ui.buzzer", "DISABLED");
        core.SetParameter("sensor." + selectedDevice + ".capture.mode", "AUTO");
        core.SetParameter("sensor." + selectedDevice + ".capture.resolution", "500");
        if (core.GetParameter("sensor." + selectedDevice + ".capture.has_live").equals("1")) {
            core.SetParameter("sensor." + selectedDevice + ".live.resolution", "125");
        } else {
            JOptionPane.showMessageDialog(null, "Live is not supported on that device", "Warning", JOptionPane.WARNING_MESSAGE, null);
        }
        core.SetParameter("output.thumbnail.resolution", "125");
        core.SetParameter("output.image.iso_compression_type", "ISO_COMPRESSION_LOSSY");
        core.SetParameter("system.threading.max_overall", options.getMaxThreadValue());
        core.SetParameter("system.threading.max_background", options.getBackgroundThreadValue());
        core.SetParameter("system.threading.image.capture.compression.enable", options.getCompressCaptureValue());
        core.SetParameter("system.threading.image.segmented.compression.enable", options.getCompressSegmentedValue());
        core.SetParameter("system.auto_continue", "1");
        core.SetParameter("system.auto_recapture", "0");
        core.SetParameter("system.auto_validation", "1");
        core.SetParameter("system.exception_auto_validation", "1");
        core.SetParameter("control.speed_vs_quality", options.getSelectedSpeedVsQualityValue());
        core.SetParameter("control.fte_vs_quality", options.getSelectedFTEVsQualityValue());
        core.SetParameter("control.fte_vs_quality.damaged_items", options.getSelectedFTEVsQualityDamagedValue());
        core.SetParameter("control.bypass.mode", "MANUAL");
        core.SetParameter("control.bypass.threshold.manual", "3");
        core.SetParameter("control.bypass.threshold.auto", "5");
        core.SetParameter("control.constraint.mode", options.getSelectedConstraintValue());
        core.SetParameter("system.toggle.mode", options.getSelectedToggleValue());

        if (options.getSelectedConsoEnabledValue() == "1") {
            if (selectedDevice.contains("MSO")) {
                core.SetParameter("system.consolidation.one_finger.enabled", "1");
            } else {
                core.SetParameter("system.consolidation.palm.enabled", "1");
            }

            core.SetParameter("system.consolidation.auto_continue", options.getSelectedConsoAutoContinueValue());
            core.SetParameter("system.consolidation.subimages.nb_min", options.getSelectedConsoMinValue());
            core.SetParameter("system.consolidation.subimages.nb_max", options.getSelectedConsoMaxValue());
        } else {
            core.SetParameter("system.consolidation.one_finger.enabled", "0");
            core.SetParameter("system.consolidation.palm.enabled", "0");
        }

    }

    public void startAquisition() throws Exception {
        // Creates the corresponding acquisition

//        AcquisitionDescriptor acqDesc = new AcquisitionDescriptor(options.getSelectedAcquisitionType());
        if (currentAcquisitionType == null) {
            currentAcquisitionType = AcquisitionType.SLAP_ALL;
        }
        AcquisitionDescriptor acqDesc = new AcquisitionDescriptor(currentAcquisitionType);
        acquisition = core.CreateAcquisition(acqDesc, selectedDevice);
        // Add a listener in order to know when the acquisition is complete (when it is the case, the result window is created)
        acquisitionListener = new ExampleAcquisitionStateListener(acquisition, getApplicantId());
        acquisitionListener.setApplicantId(getApplicantId());

        acquisition.RegisterAcquisitionStateListener(acquisitionListener);

        // Create the window which allows starting the acquisition
        mainFrame = new ExampleMainFrame(core, this);
        mainFrame.setApplicantId(getApplicantId());
        mainFrame.Connect(acquisition);
        acquisitionListener.setMainFrame(mainFrame);
        mainFrame.setVisible(true);

    }

    public void reLaunchOptions() {
        System.out.println("Relaunching options.........");
        if (core != null && acquisition != null) {
            try {
                acquisition.Close();
            } catch (com.morpho.mbop.api.Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            acquisition = null;
        }

        if (core != null && singleAcquisition != null) {
            try {
                singleAcquisition.close();
            } catch (java.lang.Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            singleAcquisition = null;
//            m__isStopped = true;
        }

    }

    private byte[] readLocalFile(String filename) throws IOException {
        File configFile = new File(filename);
        InputStream configStream = new FileInputStream(configFile);
        byte[] data = new byte[(int) configFile.length()];
        int offset = 0;
        int numRead = 0;
        while (offset < data.length && (numRead = configStream.read(data, offset, data.length - offset)) >= 0) {
            offset += numRead;
        }

        try {
            if (offset < data.length) {
                throw new IOException("Could not completely read file " + configFile.getName());
            }
        } finally {
            configStream.close();
        }

        return data;
    }

    public void stopExample() {

        // Delete the frames
        if (mainFrame != null) {
            mainFrame.dispose();
            mainFrame = null;
        }

        // Delete the frames
        if (singleAcquisitionFrame != null) {
            singleAcquisitionFrame.dispose();
            singleAcquisitionFrame = null;
        }

        if (options != null) {
            options = null;
        }

        try {
            // Close the Core object
            if (core != null) {
                core.Close();
                core = null;
            }
        } catch (com.morpho.mbop.api.Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        m__isStopped = true;
    }

    public void DisconnectCore() {
        System.out.println("Disconnecting core........");
        core.UnregisterDeviceStateListener(deviceListener);
        try {
            // Close the Core object
            if (core != null) {
                System.out.println("Closing core");
                core.Close();
                core = null;
            }
        } catch (com.morpho.mbop.api.Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//                core.Close();
//		core = null;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

            }
        });
    }

}
