package futuristicbio.biometrics;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Font;

import java.util.ResourceBundle;

import com.morpho.mbop.api.*;
import com.morpho.mbop.gui.*;

/**
 * Class implementing the main frame of the example. It includes the
 * AcquisitionPanel object of the MorphoBop library.
 *
 */
public class SingleAcquisitionFrame extends JFrame implements LiveListener, SingleAcquisition.CaptureListener {

    private static final long serialVersionUID = -3372905469781234558L;

    private AcquisitionPanel acqPanel;
    private SingleAcquisition acquisition;
    private Core core;
    private Example example;
    //private JCheckBoxMenuItem	mnuValidation;
    private ResourceBundle m__rb;

    private class AcquisitionPanel extends JPanel {

        private static final long serialVersionUID = 5831345602850421830L;

        private LiveView m__imageLive;
        private JButton mButtonStart;
        private JButton mButtonCancel;
        private JButton mButtonForce;
        private JLabel mLabelMessage;

        public AcquisitionPanel(int width, int height) throws ResourceException {
            CreateAcquisitionPanel(width, height);
        }

        public void finalize() {
            if (m__imageLive != null) {
//				m__imageLive.finalize();
            }

            m__imageLive = null;
            this.removeAll();
        }

        private void CreateAcquisitionPanel(int width, int height) throws ResourceException {

            //final int controlStatusWidth = (int)(565 * width / 1000.f);
            final int gap = 6;

            m__rb = Resources.GetResourceBundle();

            this.setLayout(null);

            setSize(new Dimension(width, height));

            // Fenetre de Live
            int imageLiveWidth = (width - 2 * gap);
            int imageLiveHeight = 9 * height / 10 - (3 * gap / 2);
            m__imageLive = new LiveView(imageLiveWidth, imageLiveHeight);
            m__imageLive.setBounds(gap, gap, imageLiveWidth, imageLiveHeight);
            this.add(m__imageLive);

            int controlHeight = height - imageLiveHeight - 3 * gap;
            int controlWidth = 125;
            mButtonStart = new JButton();
            mButtonStart.setText(m__rb.getString("START"));
            mButtonStart.setSelected(true);
            mButtonStart.setBounds(width - 3 * gap - 3 * controlWidth, gap + imageLiveHeight + gap, controlWidth, controlHeight);
            this.add(mButtonStart);

            mButtonForce = new JButton();
            mButtonForce.setText(m__rb.getString("CAPTURE"));
            mButtonForce.setSelected(true);
            mButtonForce.setEnabled(false);
            mButtonForce.setBounds(width - 2 * gap - 2 * controlWidth, gap + imageLiveHeight + gap, controlWidth, controlHeight);
            this.add(mButtonForce);

            mButtonCancel = new JButton();
            mButtonCancel.setText(m__rb.getString("CANCEL"));
            mButtonCancel.setSelected(true);
            mButtonCancel.setEnabled(false);
            mButtonCancel.setBounds(width - 1 * gap - 1 * controlWidth, gap + imageLiveHeight + gap, controlWidth, controlHeight);
            this.add(mButtonCancel);

            mLabelMessage = new JLabel();
            mLabelMessage.setFont(new Font("Dialog", Font.PLAIN, 25));
            mLabelMessage.setHorizontalAlignment(JLabel.CENTER);
            mLabelMessage.setVerticalAlignment(JLabel.CENTER);
            mLabelMessage.setBounds(gap, gap + imageLiveHeight + gap, width - 5 * gap - 3 * controlWidth, controlHeight);
            this.add(mLabelMessage);

            setVisible(true);
        }

        public void repaint() {
        }

        public LiveView getLiveView() {
            return m__imageLive;
        }

        public JButton getButtonStart() {
            return mButtonStart;
        }

        public JButton getButtonForce() {
            return mButtonForce;
        }

        public JButton getButtonCancel() {
            return mButtonCancel;
        }

        public JLabel getLabelMessage() {
            return mLabelMessage;
        }
    }

    /**
     * Constructor
     *
     * @throws MbopResourceException This exception is thrown if the XML file is
     * not found. This XML file contains all the textual data of the application
     * (it allows managing the multilingual functionality)
     * @throws MbopException This exception is thrown if a problem occurred in
     * the MorphoBop library
     */
    public SingleAcquisitionFrame(Example newExample, Core newCore) throws ResourceException, com.morpho.mbop.api.Exception {
        super("MorphoBOP 2");
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        final float ratioWidth = screenSize.width / 1280.f;
        final float ratioHeight = screenSize.height / 1024.f;
        setSize((int) (1000 * ratioWidth), (int) (900 * ratioHeight));
        setLocationRelativeTo(null);
        setResizable(false);

        core = newCore;
        example = newExample;

        // Construct and includes the new AcquisitionPanel object
        acqPanel = new AcquisitionPanel((int) (992 * ratioWidth), (int) (846 * ratioHeight));
        Container content = getContentPane();
        content.add(acqPanel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                SingleAcquisitionFrame.this.dispose();
//				example.reLaunchOptions();
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu menuActions = new JMenu("Actions");
        JMenuItem forceCalibration = new JMenuItem("Force Calibration");

        menuActions.add(forceCalibration);
        menuBar.add(menuActions);
        setJMenuBar(menuBar);

        forceCalibration.addActionListener(new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                SingleAcquisitionFrame.this.forceCalibration();
            }
        });

        acqPanel.getButtonStart().addActionListener(new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                SingleAcquisitionFrame.this.captureAsync();
            }
        });

        acqPanel.getButtonForce().addActionListener(new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                SingleAcquisitionFrame.this.forceCapture();
            }
        });
        acqPanel.getButtonCancel().addActionListener(new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                SingleAcquisitionFrame.this.captureAsyncCancel();
            }
        });
    }

    protected void close() {
        dispose();
    }

    private void captureAsync() {
        try {
            acquisition.captureAsync();
            acqPanel.getButtonStart().setEnabled(false);
            acqPanel.getButtonForce().setEnabled(true);
            acqPanel.getButtonCancel().setEnabled(true);
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    private void forceCapture() {
        try {
            acquisition.forceCapture();
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    private void captureAsyncCancel() {
        try {
            acquisition.captureAsyncCancel();
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    /**
     * Connect the Acquisition object to the AcquisitionPanel. It allows the
     * AcquisitionPanel interacting with the MorphoBop library.
     *
     * @param acquisition It is the new Acquisition object.
     * @throws MbopException This exception is thrown if a problem occurred in
     * the MorphoBop library
     */
    public void Connect(SingleAcquisition newAcquisition) throws com.morpho.mbop.api.Exception {
        acquisition = newAcquisition;
        acquisition.addLiveListener(this);
        acquisition.addCaptureListener(this);
    }

    /**
     * Disconnect the Acquisition object to the AcquisitionPanel.
     */
    public void disconnect() {
        acquisition.removeLiveListener(this);
        acquisition.removeCaptureListener(this);
    }

    void forceCalibration() {
        try {
            core.ForceDeviceCalibration(acquisition.getDeviceID());
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    private String getErrorString(int errorFlags) {
        String result = "";
        if (errorFlags == BiometricData.ERROR_FLAG_NONE) {
            return m__rb.getString("OK");
        }

        if ((errorFlags & BiometricData.ERROR_FLAG_ACQ_TOO_FAST) == BiometricData.ERROR_FLAG_ACQ_TOO_FAST) {
            result += ", " + m__rb.getString("ACQ_TOO_FAST");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_ACQ_TOO_INCLINED) == BiometricData.ERROR_FLAG_ACQ_TOO_INCLINED) {
            result += ", " + m__rb.getString("ACQ_TOO_INCLINED");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_FAKE_FINGER_DETECTED_GLOBAL) == BiometricData.ERROR_FLAG_FAKE_FINGER_DETECTED_GLOBAL) {
            result += ", " + m__rb.getString("FAKE_FINGER_DETECTED_GLOBAL");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_FAKE_FINGER_DETECTED_LOCAL) == BiometricData.ERROR_FLAG_FAKE_FINGER_DETECTED_LOCAL) {
            result += ", " + m__rb.getString("FAKE_FINGER_DETECTED_LOCAL");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_QC_BAD_CONTRAST) == BiometricData.ERROR_FLAG_QC_BAD_CONTRAST) {
            result += ", " + m__rb.getString("QC_BAD_CONTRAST");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_QC_FEW_MINUTIAE) == BiometricData.ERROR_FLAG_QC_FEW_MINUTIAE) {
            result += ", " + m__rb.getString("QC_FEW_MINUTIAE");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_QC_LOW_SURFACE) == BiometricData.ERROR_FLAG_QC_LOW_SURFACE) {
            result += ", " + m__rb.getString("QC_LOW_SURFACE");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_QC_POOR_QUALITY) == BiometricData.ERROR_FLAG_QC_POOR_QUALITY) {
            result += ", " + m__rb.getString("QC_POOR_QUALITY");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_QC_TOO_BRIGHT) == BiometricData.ERROR_FLAG_QC_TOO_BRIGHT) {
            result += ", " + m__rb.getString("QC_TOO_BRIGHT");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_QC_TOO_DARK) == BiometricData.ERROR_FLAG_QC_TOO_DARK) {
            result += ", " + m__rb.getString("QC_TOO_DARK");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_QC_BAD_NFIQ) == BiometricData.ERROR_FLAG_QC_BAD_NFIQ) {
            result += ", " + m__rb.getString("QC_BAD_NFIQ");
        }
        if ((errorFlags & BiometricData.ERROR_FLAG_SC_DUPLICATE) == BiometricData.ERROR_FLAG_SC_DUPLICATE) {
            result += ", " + m__rb.getString("SC_DUPLICATE");
        }

        if (result.length() > 1) {
            result = result.substring(2);
        }

        return result;
    }

    public void onCaptureCompleted(java.lang.Exception error, boolean cancelled, BiometricData biometricData) {
        acqPanel.getButtonStart().setEnabled(false);
        acqPanel.getButtonCancel().setEnabled(false);
        acqPanel.getButtonForce().setEnabled(false);
        if (error != null) {
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        } else if (cancelled) {
            JOptionPane.showMessageDialog(null, m__rb.getString("CAPTURE_CANCELLED"), "Info", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            String capturedFingers = "";
            int count = 0;
            try {
                if (biometricData.HasSegmentedImage(BiometricItemType.BIOITEM_TYPE_FLAT_FINGER_A)) {
                    capturedFingers += "\nA : " + getErrorString(biometricData.GetErrorFlags(BiometricItemType.BIOITEM_TYPE_FLAT_FINGER_A));
                    count++;
                }
                if (biometricData.HasSegmentedImage(BiometricItemType.BIOITEM_TYPE_FLAT_FINGER_B)) {
                    capturedFingers += "\nB : " + getErrorString(biometricData.GetErrorFlags(BiometricItemType.BIOITEM_TYPE_FLAT_FINGER_B));
                    count++;
                }
                if (biometricData.HasSegmentedImage(BiometricItemType.BIOITEM_TYPE_FLAT_FINGER_C)) {
                    capturedFingers += "\nC : " + getErrorString(biometricData.GetErrorFlags(BiometricItemType.BIOITEM_TYPE_FLAT_FINGER_C));
                    count++;
                }
                if (biometricData.HasSegmentedImage(BiometricItemType.BIOITEM_TYPE_FLAT_FINGER_D)) {
                    capturedFingers += "\nD : " + getErrorString(biometricData.GetErrorFlags(BiometricItemType.BIOITEM_TYPE_FLAT_FINGER_D));
                    count++;
                }
            } catch (java.lang.Exception e) {
            }
            if (capturedFingers.isEmpty()) {
                String message = String.format(m__rb.getString("N_FINGERS_FOUND"), 0) + ".";
                JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE, null);
            } else {
                String message = String.format(m__rb.getString("N_FINGERS_FOUND"), count) + " :";
                JOptionPane.showMessageDialog(null, message + capturedFingers, "Info", JOptionPane.INFORMATION_MESSAGE, null);
            }
        }
    }

    public void onCaptureProgressChanged(AcquisitionState state) {
        switch (state) {
            case WAITING_FOR_START:
                acqPanel.getLabelMessage().setText("<html><center>" + m__rb.getString("ACQUISITION_PROCESSING") + "</center></html>");
                // "<html><center>Waiting for device to start streaming.</center><center>Do not put your hand on the device.</center></html>"
                break;
            case CAPTURING_DATA:
                acqPanel.getLabelMessage().setText("<html><center>" + m__rb.getString("WAITING_HAND") + "</center></html>");
                //acqPanel.getLabelMessage().setText("<html><center>Device streaming.</center><center>Please put your hand on the device.</center></html>");
                break;
            case PROCESSING:
                acqPanel.getLabelMessage().setText("<html><center>" + m__rb.getString("ACQUISITION_PROCESSING") + "</center></html>");
                //acqPanel.getLabelMessage().setText("<html><center>Processing capture.</center><center>You can remove your hand from the device.</center></html>");
                break;
            case ABORTED:
                //
                acqPanel.getLabelMessage().setText("<html><center>" + m__rb.getString("CAPTURE_CANCELLED") + "</center></html>");
                //acqPanel.getLabelMessage().setText("Acquisition aborted.");
                break;
            case COMPLETED:
                acqPanel.getLabelMessage().setText("<html><center>" + m__rb.getString("ACQUISITION_COMPLETED") + "</center></html>");
                //acqPanel.getLabelMessage().setText("Acquisition completed.");
                break;
            default:
                acqPanel.getLabelMessage().setText("");
                break;
        }
    }

    public void Live(AcquisitionDescriptor i__CorrespondingItem, Image i__Image, LiveData i__LiveData) {
        acqPanel.getLiveView().updateImage(i__Image, i__LiveData);
    }

    public void Closing() {
    }

    // AcquisitionStateListener members
    public void StateChanged(AcquisitionState i__State) {
        switch (i__State) {
            case WAITING_FOR_ACTION:
                break;
            default:
                break;
        }
    }
}
