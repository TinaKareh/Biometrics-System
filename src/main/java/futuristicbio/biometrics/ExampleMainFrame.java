package futuristicbio.biometrics;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.morpho.mbop.api.*;
import com.morpho.mbop.gui.*;

/**
 * Class implementing the main frame of the example. It includes the
 * AcquisitionPanel object of the MorphoBop library.
 *
 */
public class ExampleMainFrame extends JFrame implements ValidationListener, AcquisitionStateListener {

    /**
     *
     */
    private static final long serialVersionUID = -6650880386200117774L;

    // The AcquisitionPanel object
    private AcquisitionPanel acqPanel;
    private Acquisition acquisition;
    private Core core;
    private OptionsFrame oframe;
    private JCheckBoxMenuItem mnuValidation;
    private String applicantId;

    /**
     * Constructor
     *
     * @throws MbopResourceException This exception is thrown if the XML file is
     * not found. This XML file contains all the textual data of the application
     * (it allows managing the multilingual functionality)
     * @throws MbopException This exception is thrown if a problem occurred in
     * the MorphoBop library
     */
    public ExampleMainFrame(Core newCore, OptionsFrame optionsFrame)
            throws ResourceException, com.morpho.mbop.api.Exception {
        super("KAA IDMS Biometrics Capture System");
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        final float ratioWidth = screenSize.width / 1280.f;
        final float ratioHeight = screenSize.height / 1024.f;
        setSize((int) (1000 * ratioWidth), (int) (900 * ratioHeight));
        setLocationRelativeTo(null);
        setResizable(false);

        core = newCore;
        oframe = optionsFrame;

        // Construct and includes the new AcquisitionPanel object
        acqPanel = new AcquisitionPanel((int) (992 * ratioWidth), (int) (846 * ratioHeight));
        Container content = getContentPane();
        content.add(acqPanel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                oframe.getApplicant().
                        displayfingerprints();
                ExampleMainFrame.this.dispose();
//                oframe.DisconnectCore();
                oframe.reLaunchOptions();

            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu menuActions = new JMenu("Actions");
        JMenuItem forceCalibration = new JMenuItem("Force Calibration");
        JMenuItem stopAndSave = new JMenuItem("Stop and Save");
        JMenuItem changeNextCapture = new JMenuItem("Change Next Capture");
        JMenuItem abortAcquisition = new JMenuItem("Abort Acquisition");

        JMenu menuOptions = new JMenu("Options");
        mnuValidation = new JCheckBoxMenuItem("Validation listener simulator");

        menuActions.add(forceCalibration);
        menuActions.add(stopAndSave);
        menuActions.add(changeNextCapture);
        menuActions.add(abortAcquisition);
        menuOptions.add(mnuValidation);
        menuBar.add(menuActions);
        menuBar.add(menuOptions);
        setJMenuBar(menuBar);

        forceCalibration.addActionListener(new ForceCalibrationListener(this));
        stopAndSave.addActionListener(new StopAndSaveListener(this));
        changeNextCapture.addActionListener(new ChangeNextCaptureListener(this));
        abortAcquisition.addActionListener(new AbortAcquisitionListener(this));
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    protected void close() {
        
        System.out.println("Attempting mainframe dispose.....");
        dispose();
    }
    
     public void close1() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    /**
     * Connect the Acquisition object to the AcquisitionPanel. It allows the
     * AcquisitionPanel interacting with the MorphoBop library.
     *
     * @param acquisition It is the new Acquisition object.
     * @throws MbopException This exception is thrown if a problem occurred in
     * the MorphoBop library
     */
    public void Connect(Acquisition newAcquisition) throws com.morpho.mbop.api.Exception {
        acquisition = newAcquisition;
        acqPanel.Connect(acquisition);
        acquisition.RegisterValidationListener(this);
        acquisition.RegisterAcquisitionStateListener(this);
    }

    /**
     * Disconnect the Acquisition object to the AcquisitionPanel.
     */
    public void disconnect() {
        acquisition.UnregisterValidationListener(this);
        acquisition.UnregisterAcquisitionStateListener(this);
        acqPanel.Disconnect();
    }

    void forceCalibration() {
        try {
            core.ForceDeviceCalibration(acquisition.GetDeviceID());
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    class ForceCalibrationListener implements ActionListener {

        private ExampleMainFrame frame = null;

        ForceCalibrationListener(ExampleMainFrame newFrame) {
            frame = newFrame;
        }

        public void actionPerformed(ActionEvent e) {
            frame.forceCalibration();
        }

    }

    void stopAndSave() {
        try {
            byte[] array = acquisition.StopAndSave();
            new SaveAndLoad(null, array);
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    class StopAndSaveListener implements ActionListener {

        private ExampleMainFrame frame = null;

        StopAndSaveListener(ExampleMainFrame newFrame) {
            frame = newFrame;
        }

        public void actionPerformed(ActionEvent e) {
            frame.stopAndSave();
        }

    }

    void changeNextCapture() {
        new Captures(acquisition);
    }

    class ChangeNextCaptureListener implements ActionListener {

        private ExampleMainFrame frame = null;

        ChangeNextCaptureListener(ExampleMainFrame newFrame) {
            frame = newFrame;
        }

        public void actionPerformed(ActionEvent e) {
            frame.changeNextCapture();
        }

    }

    void abortAcquisition() {
        try {
            acquisition.Abort();
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    class AbortAcquisitionListener implements ActionListener {

        private ExampleMainFrame frame = null;

        AbortAcquisitionListener(ExampleMainFrame newFrame) {
            frame = newFrame;
        }

        public void actionPerformed(ActionEvent e) {
            frame.abortAcquisition();
        }
    }

    // Validation Listener Simulator
    public boolean Validation(BiometricData i__Data) {
        if (mnuValidation.isSelected()) {
            if (JOptionPane.showConfirmDialog(this, "Is this capture valid ?", "Validation Listener Simulator", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public void Closing() {
    }

    // AcquisitionStateListener members
    public void StateChanged(AcquisitionState i__State) {
        switch (i__State) {
            case WAITING_FOR_ACTION:
                BiometricItemType[] l__askedAndFound = new BiometricItemType[2];
                l__askedAndFound[0] = BiometricItemType.BIOITEM_TYPE_OTHER;
                l__askedAndFound[1] = BiometricItemType.BIOITEM_TYPE_OTHER;
                try {
                    if (acquisition.IsLastCaptureMisplaced(l__askedAndFound)) {
                        int JOptionPaneReturn = JOptionPane.showConfirmDialog(this, "Misplaced item : " + l__askedAndFound[0].toString() + ". Found item : " + l__askedAndFound[1].toString() + ".\nDo you want to correct it ?", "MorphoBOP", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (JOptionPaneReturn == JOptionPane.YES_OPTION) {
                            acquisition.CorrectMisplacedCapture();
                        } else if (JOptionPaneReturn == JOptionPane.CANCEL_OPTION) {
                            acquisition.Rollback();
                        }
                    }
                } catch (java.lang.Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
                }
                break;
            default:
                break;
        }
    }
}
