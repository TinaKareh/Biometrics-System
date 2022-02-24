package futuristicbio.biometrics;






import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import com.morpho.mbop.api.AcquisitionType;
import com.morpho.mbop.api.Exception;

/*
 * Contain a frame allowing to modify different parameters of an acquisition
 * -> The selected device
 * -> The capture mode of the selected device
 * -> The sound activation
 * -> The speed vs quality mode
 * -> The FTE vs quality mode
 * -> The auto recapture activation
 * -> The auto continue activation
 * 
 * The GUI is generated with Java Beans
 * 
 */
public class Options {

	/*******************************************************************************************************
	 * GUI objects
	 *******************************************************************************************************/
	private JFrame optionFrame = null; // @jve:decl-index=0:visual-constraint="241,4"
	private JPanel optionContentPane = null;
	private JPanel acquisitionTypePanel = null;
	private JPanel deviceSelectionPanel = null;
	private JPanel autoContinuePanel = null;
	private JPanel autoRecapturePanel = null;
	private JPanel autoValidationPanel = null;
	private JPanel exceptionsAutoValidationPanel = null;
	private JPanel autoBypassPanel = null;
	private JPanel threadingThreadCountPanel = null;
	private JPanel threadingCompressionPanel = null;
	private JPanel speedVsQualityPanel = null;
	private JPanel soundActivationPanel = null;
	private JPanel resolutionPanel = null;
	private JPanel liveResolutionPanel = null;
	private JPanel thumbnailResolutionPanel = null;
	private JPanel ISOCompressionTypePanel = null;
	private JPanel captureTypePanel = null;
	private JPanel loadOkCancelPanel = null;
    private JPanel consoEnabledPanel = null;
    private JPanel consoAutoContinuePanel = null;
    private JPanel consoMinMaxPanel = null;
    //private JPanel consoNbMaxPanel = null;
	private JButton verifButton = null;
	private JButton okButton = null;
	private JButton loadButton = null;
	private JButton cancelButton = null;
	private Choice acquisitionTypeChoice = null;
	private Choice deviceChoice = null;
	private JRadioButton autoContinueYesRadioButton = null;
	private JRadioButton autoContinueNoRadioButton = null;
	private JRadioButton autoRecaptureYesRadioButton = null;
	private JRadioButton autoRecaptureNoRadioButton = null;
	private JRadioButton autoValidationYesRadioButton = null;
	private JRadioButton autoValidationNoRadioButton = null;
	private JRadioButton exceptionsAutoValidationYesRadioButton = null;
	private JRadioButton exceptionsAutoValidationNoRadioButton = null;
	private JRadioButton autoBypassYesRadioButton = null;
	private JRadioButton autoBypassNoRadioButton = null;
	private JTextField autoBypassThresholdTextField = null;
	private JTextField manualBypassThresholdTextField = null;
	private JSpinner threadingMaxJSpinner = null;
	private JSpinner threadingBackgroundJSpinner = null;
	private Choice speedVsQualityChoice = null;
	private JRadioButton soundActivationYesRadioButton = null;
	private JRadioButton soundActivationNoRadioButton = null;
	private JRadioButton resolutionStandardRadioButton = null;
	private JRadioButton resolutionHighRadioButton = null;
	private JRadioButton liveResolutionStandardRadioButton = null;
	private JRadioButton liveResolutionLowRadioButton = null;
	private JRadioButton thumbnailResolutionFirstRadioButton = null;
	private JRadioButton thumbnailResolutionSecondRadioButton = null;
	private JRadioButton thumbnailResolutionThirdRadioButton = null;
    private JRadioButton rawCompressionTypeRadioButton = null;
    private JRadioButton lossyCompressionTypeRadioButton = null;
    private JRadioButton losslessCompressionTypeRadioButton = null;
	private JRadioButton captureAutoRadioButton = null;
	private JRadioButton captureManualRadioButton = null;
	private Checkbox captureImageCheckBox = null;
	private Checkbox segmentedImageCheckBox = null;
    private JRadioButton consoEnabledYesRadioButton = null;
	private JRadioButton consoEnabledNoRadioButton = null;
    private JRadioButton consoAutoContinueYesRadioButton = null;
	private JRadioButton consoAutoContinueNoRadioButton = null;
    private JSpinner consoMinJSpinner = null;
	private JSpinner consoMaxJSpinner = null;
	private JPanel verifPanel = null;
	private JPanel okPanel = null;
	private Panel cancelPanel = null;
	private Panel loadPanel = null;
	private JPanel fteVsQualityPanel = null;
	private Choice fteVsQualityChoice = null;
    private JPanel fteVsQualityDamagedPanel = null;
	private Choice fteVsQualityDamagedChoice = null;
	private JPanel constraintPanel = null;
	private Choice constraintChoice = null;
	private JPanel togglePanel = null;
	private Choice toggleChoice = null;

	private Example example = null;
	private String[] deviceList = null;

	private SaveAndLoad saveAndLoad = null;

	/**
	 * Constructor
	 * 
	 * @param newExample
	 *            is the example program (allows to launch a new acquisition or to
	 *            stop the program)
	 * @param newDeviceList
	 *            contains the list of the connected devices
	 */
	public Options(Example newExample, String[] newDeviceList) {
		example = newExample;
		deviceList = newDeviceList;
                
//		getOptionFrame().setVisible(true);
	}
        
        public Options(String[] newDeviceList){
            deviceList = newDeviceList;
            example = new Example();
        }

    public void display() {
        getOptionFrame().setVisible(true);
    }

	public void launchSaveAndLoad() {
		saveAndLoad = new SaveAndLoad(this, null);
	}

	/**
	 * Launch the acquisition with the updated parameters
	 */
	public void startAcquisition() {
//		example.startAcquisition();
	}
  public void startSingleAcquisition() {
//		example.startSingleAcquisition();
	}
	/**
	 * Load an acquisition
	 */
	public void loadAcquisition() {
//		example.loadAcquisition();
	}

	/**
	 * Re-launch the options frame
	 */
	public void reLaunchOptions() {
//		example.reLaunchOptions();
	}

	/**
	 * Stop the example program
	 */
	public void stopExample() {
//		example.stopExample();
	}

	/**
	 * Update the auto recapture value, if necessary : if the auto continue mode
	 * is disabled, so does the auto recapture mode
	 */
	public void updateAutoRecaptureValue() {
		if (autoContinueNoRadioButton.isSelected()) {
			autoRecaptureNoRadioButton.setSelected(true);
			autoRecapturePanel.setEnabled(false);
			autoRecaptureNoRadioButton.setEnabled(false);
			autoRecaptureYesRadioButton.setEnabled(false);
		} else {
			autoRecaptureNoRadioButton.setEnabled(true);
			autoRecaptureYesRadioButton.setEnabled(true);
			autoRecapturePanel.setEnabled(true);
		}
	}

	/**
	 * Disable threshold text area if auto bypass is set to No.
	 */
	public void updateAutoBypassThresholdValue() {
		if (autoBypassNoRadioButton.isSelected()) {
			autoBypassThresholdTextField.setEnabled(false);
		} else {
			autoBypassThresholdTextField.setEnabled(true);
		}
	}

    /**
	 * Disable consolidation fields if consolidation is disabled
	 */
	public void updateConsoFields() {
		if (consoEnabledNoRadioButton.isSelected()) {
			consoMinJSpinner.setEnabled(false);
			consoMaxJSpinner.setEnabled(false);
            consoAutoContinueYesRadioButton.setEnabled(false);
            consoAutoContinueNoRadioButton.setEnabled(false);
		} else {
			consoMinJSpinner.setEnabled(true);
			consoMaxJSpinner.setEnabled(true);
            consoAutoContinueYesRadioButton.setEnabled(true);
            consoAutoContinueNoRadioButton.setEnabled(true);
		}
	}

	/***********************************************************************************************************
	 * LISTENERS
	 ***********************************************************************************************************/

	class OkListener implements ActionListener {
		private Options options = null;

		OkListener(Options newOptions) {
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Launch the acquisition
			options.startAcquisition();
			options.close();
		}
	}

	class VerifListener implements ActionListener {
		private Options options = null;

		VerifListener(Options newOptions) {
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Launch the acquisition
			options.startSingleAcquisition();
			options.close();
		}
	}

	class CancelListener implements ActionListener {
		private Options options = null;

		CancelListener(Options newOptions) {
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Stop the example program
			options.stopExample();
			options.close();
		}
	}

	class LoadListener implements ActionListener {
		private Options options = null;

		LoadListener(Options newOptions) {
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			options.launchSaveAndLoad();
			options.close();
		}
	}

	class AutoContinueNoListener implements ActionListener {
		private Options options = null;

		AutoContinueNoListener(Options newOptions) {
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			options.updateAutoRecaptureValue();
		}
	}

	class AutoBypassListener implements ActionListener {
		private Options options = null;

		AutoBypassListener(Options newOptions) {
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			options.updateAutoBypassThresholdValue();
		}
	}

    class ConsoEnabledNoListener implements ActionListener {
		private Options options = null;

		ConsoEnabledNoListener(Options newOptions) {
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			options.updateConsoFields();
		}
	}

	class DeviceSelectionListener implements ItemListener {
		private Options options = null;

		DeviceSelectionListener(Options newOptions) {
			options = newOptions;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			String device = options.getDeviceChoice().getSelectedItem();
			if ((device != null) && device.startsWith("FingerOTF."))
            {
                options.getSpeedVsQualityChoice().select(options.getSpeedVsQualityChoice().getItemCount() - 1);
                options.getAcquisitionTypeChoice().select("SLAP_BOTH_NO_THUMBS");
                options.getSpeedVsQualityChoice().setEnabled(false);

                options.getResolutionStandardRadioButton().setSelected(true);
                options.getResolutionHighRadioButton().setEnabled(false);
                options.getCaptureAutoRadioButton().setSelected(true);
                options.getCaptureManualRadioButton().setEnabled(false);

                options.getConsoEnabledNoRadioButton().setSelected(true);
                options.getConsoEnabledYesRadioButton().setEnabled(false);
            }
            else
            {
                options.getSpeedVsQualityChoice().setEnabled(true);
                options.getResolutionHighRadioButton().setEnabled(true);
                options.getCaptureManualRadioButton().setEnabled(true);
                options.getConsoEnabledYesRadioButton().setEnabled(true);
            }
		}
	}
	

	/***********************************************************************************************************
	 * GETTERS
	 * 
	 * @throws Exception
	 *********************************************************************************************************/

	public AcquisitionType getSelectedAcquisitionType() throws Exception {
		if (getAcquisitionTypeChoice().getSelectedItem().equals("SLAP_ALL"))
			return AcquisitionType.SLAP_ALL;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals(
				"SLAP_BOTH_FOREFINGERS"))
			return AcquisitionType.SLAP_BOTH_FOREFINGERS;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals(
				"SLAP_BOTH_NO_THUMBS"))
			return AcquisitionType.SLAP_BOTH_NO_THUMBS;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals(
				"SLAP_BOTH_THUMBS"))
			return AcquisitionType.SLAP_BOTH_THUMBS;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals(
				"SLAP_LEFT_FOUR"))
			return AcquisitionType.SLAP_LEFT_FOUR;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals(
				"SLAP_RIGHT_FOUR"))
			return AcquisitionType.SLAP_RIGHT_FOUR;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals(
				"SLAP_ROLLED_ALL"))
			return AcquisitionType.SLAP_ROLLED_ALL;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals(
				"ROLLED_ALL"))
			return AcquisitionType.ROLLED_ALL;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals(
				"SLAP_ROLLED_PALM_ALL"))
			return AcquisitionType.SLAP_ROLLED_PALM_ALL;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals("SLAP_ROLLED_PALM_LOWER"))
			return AcquisitionType.SLAP_ROLLED_PALM_LOWER;
		else if (getAcquisitionTypeChoice().getSelectedItem().equals("SLAP_ROLLED_PALM_BUT_UPPER"))
			return AcquisitionType.SLAP_ROLLED_PALM_BUT_UPPER;
		else
			throw new Exception("Invalid Acquisition Type");
	}

	public String getSelectedDevice() {
		return getDeviceChoice().getSelectedItem();
	}

	public String getSelectedAutoContinueValue() {
		if (getAutoContinueYesRadioButton().isSelected())
			return "1";
		else
			return "0";
	}

	public String getSelectedAutoRecaptureValue() {
		if (getAutoRecaptureYesRadioButton().isSelected())
			return "1";
		else
			return "0";
	}

	public String getSelectedAutoValidationValue() {
		if (getAutoValidationYesRadioButton().isSelected())
			return "1";
		else
			return "0";
	}

	public String getSelectedExceptionsAutoValidationValue() {
		if (getExceptionsAutoValidationYesRadioButton().isSelected())
			return "1";
		else
			return "0";
	}

	public String getSelectedAutoBypassValue() {
		if (getAutoBypassYesRadioButton().isSelected())
			return "AUTO";
		else
			return "MANUAL";
	}

	public String getSelectedAutoBypassThresholdValue() {
		return getAutoBypassThresholdTextField().getText();
	}

	public String getSelectedManualBypassThresholdValue() {
		return getManualBypassThresholdTextField().getText();
	}

	public String getMaxThreadValue() {
		return getThreadingMaxJSpinner().getValue().toString();
	}

	public String getBackgroundThreadValue() {
		return getThreadingBackgroundJSpinner().getValue().toString();
	}

	public String getCompressCaptureValue() {
		return getCaptureImageCheckBox().getState() ? "1" : "0";
	}

	public String getCompressSegmentedValue() {
		return getSegmentedImageCheckBox().getState() ? "1" : "0";
	}

	public String getSelectedSpeedVsQualityValue() {
		return getSpeedVsQualityChoice().getSelectedItem();
	}

	public String getSelectedFTEVsQualityValue() {
		return getFteVsQualityChoice().getSelectedItem();
	}

    public String getSelectedFTEVsQualityDamagedValue() {
		return getFteVsQualityDamagedChoice().getSelectedItem();
	}

	public String getSelectedConstraintValue() {
            //temporary
//		return getConstraintChoice().getSelectedItem();
              return "UNCONSTRAINED";
	}

	public String getSelectedToggleValue() {
            return "PRESENT_BANDAGED_AMPUTEE";
//		return getToggleChoice().getSelectedItem();
	}

	public String getSelectedSoundActivationValue() {
		if (getSoundActivationYesRadioButton().isSelected())
			return "AUTO";
		else
			return "DISABLED";
	}

	public String getSelectedCaptureType() {
		if (getCaptureAutoRadioButton().isSelected())
			return "AUTO";
		else
			return "MANUAL";
	}

	public String getSelectedResolution() {
		if (getResolutionStandardRadioButton().isSelected())
			return "500";
		else
			return "1000";
	}

	public String getSelectedLiveResolution() {
		if (getLiveResolutionStandardRadioButton().isSelected())
			return "250";
		else
			return "125";
	}

	public String getSelectedThumbnailResolution() {
		if (getThumbnailResolutionFirstRadioButton().isSelected())
			return "62.5";
		else if (getThumbnailResolutionSecondRadioButton().isSelected())
			return "125";
		else
			return "250";
	}

    public String getSelectedISOCompressionType() {
		if (getRawCompressionTypeRadioButton().isSelected())
			return "ISO_COMPRESSION_RAW";
		else if (getLossyCompressionTypeRadioButton().isSelected())
			return "ISO_COMPRESSION_LOSSY";
		else
			return "ISO_COMPRESSION_LOSSLESS";
	}

    public String getSelectedConsoEnabledValue() {
        //temporary
        return "0";
//		if (getConsoEnabledYesRadioButton().isSelected())
//			return "1";
//		else
//			return "0";
	}
    
    public String getSelectedConsoAutoContinueValue() {
		if (getConsoAutoContinueYesRadioButton().isSelected())
			return "1";
		else
			return "0";
	}

    public String getSelectedConsoMinValue() {
		return getConsoMinJSpinner().getValue().toString();
	}

    public String getSelectedConsoMaxValue() {
		return getConsoMaxJSpinner().getValue().toString();
	}

	public String getSaveFile() {
		if (saveAndLoad == null)
			return "";
		else
			return saveAndLoad.getSaveFile();
	}

	/*******************************************************************************************************
	 * Generated GUI objects
	 *******************************************************************************************************/
	/**
	 * This method initializes optionFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getOptionFrame() {
		if (optionFrame == null) {
			optionFrame = new JFrame();
			optionFrame.setSize(new Dimension(800, 724));
			optionFrame.setTitle("Options");
			optionFrame.setLocationRelativeTo(null);
			optionFrame.setResizable(false);
			optionFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					stopExample();
					close();
				}
			});
			optionFrame.setContentPane(getOptionContentPane());
		}
		return optionFrame;
	}

	/**
	 * This method initializes optionContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getOptionContentPane() {
		if (optionContentPane == null) {
			optionContentPane = new JPanel();

			GridBagLayout layout = new GridBagLayout();
			GridBagConstraints c = new GridBagConstraints();
			optionContentPane.setLayout(layout);

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.0;
			layout.setConstraints(getConstraintPanel(), c);
			optionContentPane.add(getConstraintPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getAcquisitionTypePanel(), c);
			optionContentPane.add(getAcquisitionTypePanel());
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getTogglePanel(), c);
			optionContentPane.add(getTogglePanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			JPanel newPanel = new JPanel();
			layout.setConstraints(newPanel, c);
			optionContentPane.add(newPanel);
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getDeviceSelectionPanel(), c);
			optionContentPane.add(getDeviceSelectionPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getCaptureTypePanel(), c);
			optionContentPane.add(getCaptureTypePanel());
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getResolutionPanel(), c);
			optionContentPane.add(getResolutionPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getLiveResolutionPanel(), c);
			optionContentPane.add(getLiveResolutionPanel());
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getSoundActivationPanel(), c);
			optionContentPane.add(getSoundActivationPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getThumbnailResolutionPanel(), c);
			optionContentPane.add(getThumbnailResolutionPanel());
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getSpeedVsQualityPanel(), c);
			optionContentPane.add(getSpeedVsQualityPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getFteVsQualityPanel(), c);
			optionContentPane.add(getFteVsQualityPanel());
            c.gridwidth = GridBagConstraints.RELATIVE;
            layout.setConstraints(getFteVsQualityDamagedPanel(), c);
			optionContentPane.add(getFteVsQualityDamagedPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			newPanel = new JPanel();
			layout.setConstraints(newPanel, c);
			optionContentPane.add(newPanel);
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getAutoContinuePanel(), c);
			optionContentPane.add(getAutoContinuePanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getAutoRecapturePanel(), c);
			optionContentPane.add(getAutoRecapturePanel());
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getAutoValidationPanel(), c);
			optionContentPane.add(getAutoValidationPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getExceptionsAutoValidationPanel(), c);
			optionContentPane.add(getExceptionsAutoValidationPanel());
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getAutoBypassPanel(), c);
			optionContentPane.add(getAutoBypassPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
            layout.setConstraints(getISOCompressionTypePanel(), c);
            optionContentPane.add(getISOCompressionTypePanel());
			c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getThreadingThreadCountPanel(), c);
			optionContentPane.add(getThreadingThreadCountPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getThreadingCompressionPanel(), c);
			optionContentPane.add(getThreadingCompressionPanel());
            c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getConsoEnabledPanel(), c);
			optionContentPane.add(getConsoEnabledPanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			layout.setConstraints(getConsoMinMaxPanel(), c);
			optionContentPane.add(getConsoMinMaxPanel());
            c.gridwidth = GridBagConstraints.RELATIVE;
			layout.setConstraints(getConsoAutoContinuePanel(), c);
			optionContentPane.add(getConsoAutoContinuePanel());
			c.gridwidth = GridBagConstraints.REMAINDER;
			newPanel = new JPanel();
			layout.setConstraints(newPanel, c);
			optionContentPane.add(newPanel);
            layout.setConstraints(getLoadOkCancelPanel(), c);
			optionContentPane.add(getLoadOkCancelPanel());

			optionContentPane.setSize(811, 690);
		}
		return optionContentPane;
	}

	/**
	 * This method initializes acquisitionTypePanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAcquisitionTypePanel() {
		if (acquisitionTypePanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.gridx = 0;
			acquisitionTypePanel = new JPanel();
			acquisitionTypePanel.setLayout(new GridBagLayout());
			acquisitionTypePanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Acquisition Type", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			acquisitionTypePanel.setMinimumSize(new Dimension(38, 50));
			acquisitionTypePanel.setPreferredSize(new Dimension(38, 50));
			acquisitionTypePanel.add(getAcquisitionTypeChoice(),
					gridBagConstraints);
		}
		return acquisitionTypePanel;
	}

	/**
	 * This method initializes constraintPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getConstraintPanel() {
		if (constraintPanel == null) {
			constraintPanel = new JPanel();
			constraintPanel.setLayout(new GridBagLayout());
			constraintPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Constraint Mode", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			constraintPanel.setMinimumSize(new Dimension(38, 50));
			constraintPanel.setPreferredSize(new Dimension(38, 50));
			constraintPanel.add(getConstraintChoice(),
					new GridBagConstraints());
		}
		return constraintPanel;
	}

	/**
	 * This method initializes togglePanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getTogglePanel() {
		if (togglePanel == null) {
			togglePanel = new JPanel();
			togglePanel.setLayout(new GridBagLayout());
			togglePanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Toggle Mode", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			togglePanel.setMinimumSize(new Dimension(38, 50));
			togglePanel.setPreferredSize(new Dimension(38, 50));
			togglePanel.add(getToggleChoice(),
					new GridBagConstraints());
		}
		return togglePanel;
	}

	/**
	 * This method initializes deviceSelectionPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getDeviceSelectionPanel() {
		if (deviceSelectionPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			deviceSelectionPanel = new JPanel();
			deviceSelectionPanel.setPreferredSize(new Dimension(38, 50));
			deviceSelectionPanel.setMinimumSize(new Dimension(38, 50));
			deviceSelectionPanel.setLayout(gridLayout);
			deviceSelectionPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Device Selection", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			deviceSelectionPanel.setMinimumSize(new Dimension(38, 50));
			deviceSelectionPanel.setPreferredSize(new Dimension(38, 50));
			deviceSelectionPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			deviceSelectionPanel.add(getDeviceChoice(), null);
		}
		return deviceSelectionPanel;
	}

	/**
	 * This method initializes autoContinuePanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAutoContinuePanel() {
		if (autoContinuePanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			autoContinuePanel = new JPanel();
			autoContinuePanel.setLayout(new GridBagLayout());
			autoContinuePanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Auto Continue", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			autoContinuePanel.setMinimumSize(new Dimension(38, 50));
			autoContinuePanel.setPreferredSize(new Dimension(38, 50));
			autoContinuePanel.add(getAutoContinueYesRadioButton(),
					gridBagConstraints);
			autoContinuePanel.add(getAutoContinueNoRadioButton(),
					gridBagConstraints1);

			ButtonGroup autoContinueGroup = new ButtonGroup();
			autoContinueGroup.add(getAutoContinueYesRadioButton());
			autoContinueGroup.add(getAutoContinueNoRadioButton());
		}
		return autoContinuePanel;
	}

	/**
	 * This method initializes autoRecapturePanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAutoRecapturePanel() {
		if (autoRecapturePanel == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			autoRecapturePanel = new JPanel();
			autoRecapturePanel.setLayout(new GridBagLayout());
			autoRecapturePanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Auto Recapture", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			autoRecapturePanel.setMinimumSize(new Dimension(38, 50));
			autoRecapturePanel.setPreferredSize(new Dimension(38, 50));
			autoRecapturePanel.add(getAutoRecaptureYesRadioButton(),
					gridBagConstraints2);
			autoRecapturePanel.add(getAutoRecaptureNoRadioButton(),
					gridBagConstraints3);

			ButtonGroup autoRecaptureGroup = new ButtonGroup();
			autoRecaptureGroup.add(getAutoRecaptureYesRadioButton());
			autoRecaptureGroup.add(getAutoRecaptureNoRadioButton());
		}
		return autoRecapturePanel;
	}

	/**
	 * This method initializes autoValidationPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAutoValidationPanel() {
		if (autoValidationPanel == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			autoValidationPanel = new JPanel();
			autoValidationPanel.setLayout(new GridBagLayout());
			autoValidationPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Auto Validation", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			autoValidationPanel.setMinimumSize(new Dimension(38, 50));
			autoValidationPanel.setPreferredSize(new Dimension(38, 50));
			autoValidationPanel.add(getAutoValidationYesRadioButton(),
					gridBagConstraints2);
			autoValidationPanel.add(getAutoValidationNoRadioButton(),
					gridBagConstraints3);

			ButtonGroup autoValidationGroup = new ButtonGroup();
			autoValidationGroup.add(getAutoValidationYesRadioButton());
			autoValidationGroup.add(getAutoValidationNoRadioButton());
		}
		return autoValidationPanel;
	}

	/**
	 * This method initializes exceptionsAutoValidationPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getExceptionsAutoValidationPanel() {
		if (exceptionsAutoValidationPanel == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			exceptionsAutoValidationPanel = new JPanel();
			exceptionsAutoValidationPanel.setLayout(new GridBagLayout());
			exceptionsAutoValidationPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Exceptions Auto Validation", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			exceptionsAutoValidationPanel.setMinimumSize(new Dimension(38, 50));
			exceptionsAutoValidationPanel.setPreferredSize(new Dimension(38, 50));
			exceptionsAutoValidationPanel.add(getExceptionsAutoValidationYesRadioButton(),
					gridBagConstraints2);
			exceptionsAutoValidationPanel.add(getExceptionsAutoValidationNoRadioButton(),
					gridBagConstraints3);

			ButtonGroup exceptionsAutoValidationGroup = new ButtonGroup();
			exceptionsAutoValidationGroup.add(getExceptionsAutoValidationYesRadioButton());
			exceptionsAutoValidationGroup.add(getExceptionsAutoValidationNoRadioButton());
		}
		return exceptionsAutoValidationPanel;
	}

	/**
	 * This method initializes autoBypassPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAutoBypassPanel() {
		if (autoBypassPanel == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.gridy = 0;
			gridBagConstraints5.insets = new Insets (0, 5, 0, 10);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.insets = new Insets (0, 5, 0, 10);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			autoBypassPanel = new JPanel();
			autoBypassPanel.setLayout(new GridBagLayout());
			autoBypassPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Auto Bypass (set Thresholds)", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			autoBypassPanel.setMinimumSize(new Dimension(38, 50));
			autoBypassPanel.setPreferredSize(new Dimension(38, 50));
			autoBypassPanel.add(getAutoBypassYesRadioButton(),
					gridBagConstraints2);
			autoBypassPanel.add(getAutoBypassNoRadioButton(),
					gridBagConstraints3);
			autoBypassPanel.add(getAutoBypassThresholdTextField(),
					gridBagConstraints4);
			autoBypassPanel.add(getManualBypassThresholdTextField(),
					gridBagConstraints5);

			ButtonGroup autoBypassGroup = new ButtonGroup();
			autoBypassGroup.add(getAutoBypassYesRadioButton());
			autoBypassGroup.add(getAutoBypassNoRadioButton());
		}
		return autoBypassPanel;
	}

	/**
	 * This method initializes threadingThreadCountPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getThreadingThreadCountPanel() {
		if (threadingThreadCountPanel == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.gridy = 0;
			gridBagConstraints5.insets = new Insets (0, 5, 0, 10);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.insets = new Insets (0, 5, 0, 10);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			threadingThreadCountPanel = new JPanel();
			threadingThreadCountPanel.setLayout(new GridBagLayout());
			threadingThreadCountPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Threading - Thread count", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			threadingThreadCountPanel.setMinimumSize(new Dimension(38, 50));
			threadingThreadCountPanel.setPreferredSize(new Dimension(38, 50));
			threadingThreadCountPanel.add(new JLabel("Max"),
					gridBagConstraints2);
			threadingThreadCountPanel.add(new JLabel("Background"),
					gridBagConstraints3);
			threadingThreadCountPanel.add(getThreadingMaxJSpinner(),
					gridBagConstraints4);
			threadingThreadCountPanel.add(getThreadingBackgroundJSpinner(),
					gridBagConstraints5);
		}
		return threadingThreadCountPanel;
	}

	/**
	 * This method initializes threadingCompressionPanel
	 * 
	 * @return javax.swing.JPanel
	 */

	private JPanel getThreadingCompressionPanel() {
		if (threadingCompressionPanel == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 3;
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.insets = new Insets(0, 30, 0, 5);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints0 = new GridBagConstraints();
			gridBagConstraints0.gridx = 0;
			gridBagConstraints0.gridy = 0;
			gridBagConstraints0.insets = new Insets(0, 30, 0, 5);
			threadingCompressionPanel = new JPanel();
			threadingCompressionPanel.setLayout(new GridBagLayout());
			threadingCompressionPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Threading - Compression", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			threadingCompressionPanel.setMinimumSize(new Dimension(38, 50));
			threadingCompressionPanel.setPreferredSize(new Dimension(38, 50));
			threadingCompressionPanel.add(getCaptureImageCheckBox(),
					gridBagConstraints0);
			threadingCompressionPanel.add(new JLabel("Capture Image"),
					gridBagConstraints1);
			threadingCompressionPanel.add(getSegmentedImageCheckBox(),
					gridBagConstraints2);
			threadingCompressionPanel.add(new JLabel("Segmented Image"),
					gridBagConstraints3);
		}
		return threadingCompressionPanel;
	}

	/**
	 * This method initializes speedVsQualityPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getSpeedVsQualityPanel() {
		if (speedVsQualityPanel == null) {
			speedVsQualityPanel = new JPanel();
			speedVsQualityPanel.setLayout(new GridBagLayout());
			speedVsQualityPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Speed vs Quality", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			speedVsQualityPanel.setMinimumSize(new Dimension(38, 50));
			speedVsQualityPanel.setPreferredSize(new Dimension(38, 50));
			speedVsQualityPanel.add(getSpeedVsQualityChoice(),
					new GridBagConstraints());
		}
		return speedVsQualityPanel;
	}

	/**
	 * This method initializes soundActivationPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getSoundActivationPanel() {
		if (soundActivationPanel == null) {
			soundActivationPanel = new JPanel();
			soundActivationPanel.setLayout(new GridBagLayout());
			soundActivationPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1), "Sound",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			soundActivationPanel.setMinimumSize(new Dimension(38, 50));
			soundActivationPanel.setPreferredSize(new Dimension(38, 50));
			soundActivationPanel.add(getSoundActivationYesRadioButton(),
					new GridBagConstraints());
			soundActivationPanel.add(getSoundActivationNoRadioButton(),
					new GridBagConstraints());

			ButtonGroup SoundActivationGroup = new ButtonGroup();
			SoundActivationGroup.add(getSoundActivationYesRadioButton());
			SoundActivationGroup.add(getSoundActivationNoRadioButton());
		}
		return soundActivationPanel;
	}

	/**
	 * This method initializes captureTypePanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getCaptureTypePanel() {
		if (captureTypePanel == null) {
			captureTypePanel = new JPanel();
			captureTypePanel.setLayout(new GridBagLayout());
			captureTypePanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Capture Type", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			captureTypePanel.setMinimumSize(new Dimension(38, 50));
			captureTypePanel.setPreferredSize(new Dimension(38, 50));
			captureTypePanel.add(getCaptureAutoRadioButton(),
					new GridBagConstraints());
			captureTypePanel.add(getCaptureManualRadioButton(),
					new GridBagConstraints());

			ButtonGroup captureTypeGroup = new ButtonGroup();
			captureTypeGroup.add(getCaptureAutoRadioButton());
			captureTypeGroup.add(getCaptureManualRadioButton());
		}
		return captureTypePanel;
	}

	/**
	 * This method initializes resolutionPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getResolutionPanel() {
		if (resolutionPanel == null) {
			resolutionPanel = new JPanel();
			resolutionPanel.setLayout(new GridBagLayout());
			resolutionPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Resolution (in dpi)", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			resolutionPanel.setMinimumSize(new Dimension(38, 50));
			resolutionPanel.setPreferredSize(new Dimension(38, 50));
			resolutionPanel.add(getResolutionStandardRadioButton(),
					new GridBagConstraints());
			resolutionPanel.add(getResolutionHighRadioButton(),
					new GridBagConstraints());

			ButtonGroup resolutionGroup = new ButtonGroup();
			resolutionGroup.add(getResolutionStandardRadioButton());
			resolutionGroup.add(getResolutionHighRadioButton());
		}
		return resolutionPanel;
	}

	/**
	 * This method initializes liveResolutionPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getLiveResolutionPanel() {
		if (liveResolutionPanel == null) {
			liveResolutionPanel = new JPanel();
			liveResolutionPanel.setLayout(new GridBagLayout());
			liveResolutionPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Live resolution (in dpi)", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			liveResolutionPanel.setMinimumSize(new Dimension(38, 50));
			liveResolutionPanel.setPreferredSize(new Dimension(38, 50));
			liveResolutionPanel.add(getLiveResolutionLowRadioButton(),
					new GridBagConstraints());
			liveResolutionPanel.add(getLiveResolutionStandardRadioButton(),
					new GridBagConstraints());
			ButtonGroup liveResolutionGroup = new ButtonGroup();
			liveResolutionGroup.add(getLiveResolutionStandardRadioButton());
			liveResolutionGroup.add(getLiveResolutionLowRadioButton());
		}
		return liveResolutionPanel;
	}

	/**
	 * This method initializes thumbnailResolutionPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getThumbnailResolutionPanel() {
		if (thumbnailResolutionPanel == null) {
			thumbnailResolutionPanel = new JPanel();
			thumbnailResolutionPanel.setLayout(new GridBagLayout());
			thumbnailResolutionPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Thumbnail resolution (in dpi)", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			thumbnailResolutionPanel.setMinimumSize(new Dimension(38, 50));
			thumbnailResolutionPanel.setPreferredSize(new Dimension(38, 50));
			thumbnailResolutionPanel.add(getThumbnailResolutionFirstRadioButton(),
					new GridBagConstraints());
			thumbnailResolutionPanel.add(getThumbnailResolutionSecondRadioButton(),
					new GridBagConstraints());
			thumbnailResolutionPanel.add(getThumbnailResolutionThirdRadioButton(),
					new GridBagConstraints());
			ButtonGroup thumbnailResolutionGroup = new ButtonGroup();
			thumbnailResolutionGroup.add(getThumbnailResolutionFirstRadioButton());
			thumbnailResolutionGroup.add(getThumbnailResolutionSecondRadioButton());
			thumbnailResolutionGroup.add(getThumbnailResolutionThirdRadioButton());
		}
		return thumbnailResolutionPanel;
	}

    /**
	 * This method initializes ISOCompressionTypePanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getISOCompressionTypePanel() {
		if (ISOCompressionTypePanel == null) {
			ISOCompressionTypePanel = new JPanel();
			ISOCompressionTypePanel.setLayout(new GridBagLayout());
			ISOCompressionTypePanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"ISO Compression Type", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			ISOCompressionTypePanel.setMinimumSize(new Dimension(38, 50));
			ISOCompressionTypePanel.setPreferredSize(new Dimension(38, 50));
			ISOCompressionTypePanel.add(getRawCompressionTypeRadioButton(),
					new GridBagConstraints());
			ISOCompressionTypePanel.add(getLossyCompressionTypeRadioButton(),
					new GridBagConstraints());
			ISOCompressionTypePanel.add(getLosslessCompressionTypeRadioButton(),
					new GridBagConstraints());
			ButtonGroup ISOCompressionTypeGroup = new ButtonGroup();
			ISOCompressionTypeGroup.add(getRawCompressionTypeRadioButton());
			ISOCompressionTypeGroup.add(getLossyCompressionTypeRadioButton());
			ISOCompressionTypeGroup.add(getLosslessCompressionTypeRadioButton());
		}
		return ISOCompressionTypePanel;
	}

    /**
	 * This method initializes consoEnabledPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getConsoEnabledPanel() {
		if (consoEnabledPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			consoEnabledPanel = new JPanel();
			consoEnabledPanel.setLayout(new GridBagLayout());
			consoEnabledPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Consolidation Enabled", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			consoEnabledPanel.setMinimumSize(new Dimension(38, 50));
			consoEnabledPanel.setPreferredSize(new Dimension(38, 50));
			consoEnabledPanel.add(getConsoEnabledYesRadioButton(),
					gridBagConstraints);
			consoEnabledPanel.add(getConsoEnabledNoRadioButton(),
					gridBagConstraints1);

			ButtonGroup consoEnabledPanelGroup = new ButtonGroup();
			consoEnabledPanelGroup.add(getConsoEnabledYesRadioButton());
			consoEnabledPanelGroup.add(getConsoEnabledNoRadioButton());
		}
		return consoEnabledPanel;
	}

    /**
	 * This method initializes consoAutoContinuePanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getConsoAutoContinuePanel() {
		if (consoAutoContinuePanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			consoAutoContinuePanel = new JPanel();
			consoAutoContinuePanel.setLayout(new GridBagLayout());
			consoAutoContinuePanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Consolidation - Auto Continue", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			consoAutoContinuePanel.setMinimumSize(new Dimension(38, 50));
			consoAutoContinuePanel.setPreferredSize(new Dimension(38, 50));
			consoAutoContinuePanel.add(getConsoAutoContinueYesRadioButton(),
					gridBagConstraints);
			consoAutoContinuePanel.add(getConsoAutoContinueNoRadioButton(),
					gridBagConstraints1);

			ButtonGroup consoAutoContinueGroup = new ButtonGroup();
			consoAutoContinueGroup.add(getConsoAutoContinueYesRadioButton());
			consoAutoContinueGroup.add(getConsoAutoContinueNoRadioButton());
		}
		return consoAutoContinuePanel;
	}

    /**
	 * This method initializes consoMinMaxPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getConsoMinMaxPanel() {
		if (consoMinMaxPanel == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.gridy = 0;
			gridBagConstraints5.insets = new Insets (0, 5, 0, 10);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.insets = new Insets (0, 5, 0, 10);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			consoMinMaxPanel = new JPanel();
			consoMinMaxPanel.setLayout(new GridBagLayout());
			consoMinMaxPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Consolidation - Subimages Min/Max Number", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			consoMinMaxPanel.setMinimumSize(new Dimension(38, 50));
			consoMinMaxPanel.setPreferredSize(new Dimension(38, 50));
			consoMinMaxPanel.add(new JLabel("Min"),
					gridBagConstraints2);
			consoMinMaxPanel.add(new JLabel("Max"),
					gridBagConstraints3);
			consoMinMaxPanel.add(getConsoMinJSpinner(),
					gridBagConstraints4);
			consoMinMaxPanel.add(getConsoMaxJSpinner(),
					gridBagConstraints5);
		}
		return consoMinMaxPanel;
	}

	/**
	 * This method initializes okCancelPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getLoadOkCancelPanel() {
		if (loadOkCancelPanel == null) {
			loadOkCancelPanel = new JPanel();
			loadOkCancelPanel.setLayout(new GridBagLayout());
			GridBagConstraints cLoad = new GridBagConstraints();
			cLoad.gridx = 0;
			cLoad.gridy = 0;
			cLoad.insets = new Insets(0, 0, 0, 240);
			GridBagConstraints cVerif = new GridBagConstraints();
			cVerif.gridx = 1;
			cVerif.gridy = 0;
			cVerif.insets = new Insets(0, 240, 0, 0);
			GridBagConstraints cOk = new GridBagConstraints();
			cOk.gridx = 2;
			cOk.gridy = 0;
			cOk.insets = new Insets(0, 10, 0, 0);
			GridBagConstraints cCancel = new GridBagConstraints();
			cCancel.gridx = 3;
			cCancel.gridy = 0;
			cCancel.insets = new Insets(0, 5, 0, 0);
			loadOkCancelPanel.setMinimumSize(new Dimension(38, 50));
			loadOkCancelPanel.setPreferredSize(new Dimension(38, 50));
			loadOkCancelPanel.add(getLoadPanel(), cLoad);
			loadOkCancelPanel.add(getVerifPanel(), cVerif);
			loadOkCancelPanel.add(getOkPanel(), cOk);
			loadOkCancelPanel.add(getCancelPanel(), cCancel);
		}
		return loadOkCancelPanel;
	}

	/**
	 * This method initializes okButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText("Enroll");
			okButton.setSelected(true);
			okButton.addActionListener(new OkListener(this));
		}
		return okButton;
	}

	/**
	 * This method initializes verifButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getVerifButton() {
		if (verifButton == null) {
			verifButton = new JButton();
			verifButton.setText("Ident/Verif");
			verifButton.setSelected(false);
			verifButton.addActionListener(new VerifListener(this));
		}
		return verifButton;
	}

	/**
	 * This method initializes cancelButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getCancelButton() {
		if (cancelButton == null) {
			cancelButton = new JButton();
			cancelButton.setHorizontalAlignment(SwingConstants.RIGHT);
			cancelButton.setText("Cancel");
			cancelButton.addActionListener(new CancelListener(this));
		}
		return cancelButton;
	}

	/**
	 * This method initializes loadButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getLoadButton() {
		if (loadButton == null) {
			loadButton = new JButton();
			loadButton.setHorizontalAlignment(SwingConstants.RIGHT);
			loadButton.setText("Load");
			loadButton.addActionListener(new LoadListener(this));
		}
		return loadButton;
	}

	/**
	 * This method initializes acquisitionTypeChoice
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getAcquisitionTypeChoice() {
		if (acquisitionTypeChoice == null) {
			acquisitionTypeChoice = new Choice();
			acquisitionTypeChoice.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			acquisitionTypeChoice.setMaximumSize(new Dimension(28, 21));
			acquisitionTypeChoice.setMinimumSize(new Dimension(28, 21));
			for (AcquisitionType type : AcquisitionType.values()) 
			{
				acquisitionTypeChoice.add(type.toString());
			}
			acquisitionTypeChoice.select("SLAP_ALL");
		}
		return acquisitionTypeChoice;
	}

	/**
	 * This method initializes deviceChoice
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getDeviceChoice() {
		if (deviceChoice == null) {
			deviceChoice = new Choice();

			if (deviceList != null) {
				for (String device : deviceList) {
					deviceChoice.add(device);
				}
			}
			ItemListener listener = new DeviceSelectionListener(this);
			deviceChoice.addItemListener(listener);
			deviceChoice.select(0);
			listener.itemStateChanged(new ItemEvent(deviceChoice, ItemEvent.ITEM_STATE_CHANGED, deviceChoice.getSelectedItem(), ItemEvent.SELECTED));
		}
		return deviceChoice;
	}

	/**
	 * This method initializes autoContinueYesRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getAutoContinueYesRadioButton() {
		if (autoContinueYesRadioButton == null) {
			autoContinueYesRadioButton = new JRadioButton();
			autoContinueYesRadioButton.setText("Yes");
			autoContinueYesRadioButton.setSelected(true);
			autoContinueYesRadioButton
					.addActionListener(new AutoContinueNoListener(this));
		}
		return autoContinueYesRadioButton;
	}

	/**
	 * This method initializes autoContinueNoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getAutoContinueNoRadioButton() {
		if (autoContinueNoRadioButton == null) {
			autoContinueNoRadioButton = new JRadioButton();
			autoContinueNoRadioButton.setText("No");
			autoContinueNoRadioButton
					.addActionListener(new AutoContinueNoListener(this));
		}
		return autoContinueNoRadioButton;
	}

	/**
	 * This method initializes autoRecaptureYesRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getAutoRecaptureYesRadioButton() {
		if (autoRecaptureYesRadioButton == null) {
			autoRecaptureYesRadioButton = new JRadioButton();
			autoRecaptureYesRadioButton.setText("Yes");
		}
		return autoRecaptureYesRadioButton;
	}

	/**
	 * This method initializes autoRecaptureNoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getAutoRecaptureNoRadioButton() {
		if (autoRecaptureNoRadioButton == null) {
			autoRecaptureNoRadioButton = new JRadioButton();
			autoRecaptureNoRadioButton.setText("No");
			autoRecaptureNoRadioButton.setSelected(true);
		}
		return autoRecaptureNoRadioButton;
	}

	/**
	 * This method initializes autoValidationYesRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getAutoValidationYesRadioButton() {
		if (autoValidationYesRadioButton == null) {
			autoValidationYesRadioButton = new JRadioButton();
			autoValidationYesRadioButton.setText("Yes");
			autoValidationYesRadioButton.setSelected(true);
		}
		return autoValidationYesRadioButton;
	}

	/**
	 * This method initializes autoValidationNoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getAutoValidationNoRadioButton() {
		if (autoValidationNoRadioButton == null) {
			autoValidationNoRadioButton = new JRadioButton();
			autoValidationNoRadioButton.setText("No");
		}
		return autoValidationNoRadioButton;
	}

	/**
	 * This method initializes exceptionsAutoValidationYesRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getExceptionsAutoValidationYesRadioButton() {
		if (exceptionsAutoValidationYesRadioButton == null) {
			exceptionsAutoValidationYesRadioButton = new JRadioButton();
			exceptionsAutoValidationYesRadioButton.setText("Yes");
		}
		return exceptionsAutoValidationYesRadioButton;
	}

	/**
	 * This method initializes exceptionsAutoValidationNoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getExceptionsAutoValidationNoRadioButton() {
		if (exceptionsAutoValidationNoRadioButton == null) {
			exceptionsAutoValidationNoRadioButton = new JRadioButton();
			exceptionsAutoValidationNoRadioButton.setText("No");
			exceptionsAutoValidationNoRadioButton.setSelected(true);
		}
		return exceptionsAutoValidationNoRadioButton;
	}

	/**
	 * This method initializes autoBypassYesRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getAutoBypassYesRadioButton() {
		if (autoBypassYesRadioButton == null) {
			autoBypassYesRadioButton = new JRadioButton();
			autoBypassYesRadioButton.setText("Yes");
			autoBypassYesRadioButton
					.addActionListener(new AutoBypassListener(this));
		}
		return autoBypassYesRadioButton;
	}

	/**
	 * This method initializes autoBypassNoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getAutoBypassNoRadioButton() {
		if (autoBypassNoRadioButton == null) {
			autoBypassNoRadioButton = new JRadioButton();
			autoBypassNoRadioButton.setText("No");
			autoBypassNoRadioButton.setSelected(true);
			autoBypassNoRadioButton
					.addActionListener(new AutoBypassListener(this));
		}
		return autoBypassNoRadioButton;
	}

	/**
	 * This method initializes autoBypassThresholdTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getAutoBypassThresholdTextField() {
		if (autoBypassThresholdTextField == null) {
			autoBypassThresholdTextField= new JTextField();
			autoBypassThresholdTextField.setText("5");
			autoBypassThresholdTextField.setEnabled(false);
			autoBypassThresholdTextField.setPreferredSize(new Dimension(20,20));
		}
		return autoBypassThresholdTextField;
	}

	/**
	 * This method initializes manualBypassThresholdTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getManualBypassThresholdTextField() {
		if (manualBypassThresholdTextField == null) {
			manualBypassThresholdTextField= new JTextField();
			manualBypassThresholdTextField.setText("3");
			manualBypassThresholdTextField.setEnabled(true);
			manualBypassThresholdTextField.setPreferredSize(new Dimension(20,20));
		}
		return manualBypassThresholdTextField;
	}

	/**
	 * This method initializes threadingMaxJSpinner
	 * 
	 * @return javax.swing.JSpinner
	 */
	private JSpinner getThreadingMaxJSpinner() {
		if (threadingMaxJSpinner == null) {
			threadingMaxJSpinner= new JSpinner();
			threadingMaxJSpinner.setPreferredSize(new Dimension(80,80));
		}
		return threadingMaxJSpinner;
	}

	/**
	 * This method initializes threadingBackgroundJSpinner
	 * 
	 * @return javax.swing.JSpinner
	 */
	private JSpinner getThreadingBackgroundJSpinner() {
		if (threadingBackgroundJSpinner == null) {
			threadingBackgroundJSpinner= new JSpinner();
			threadingBackgroundJSpinner.setPreferredSize(new Dimension(80,80));
		}
		return threadingBackgroundJSpinner;
	}

    /**
	 * This method initializes consoMinJSpinner
	 * 
	 * @return javax.swing.JSpinner
	 */
	private JSpinner getConsoMinJSpinner() {
		if (consoMinJSpinner == null) {
            SpinnerNumberModel sm = new SpinnerNumberModel(2, 2, 100, 1); // displayed, min, max, step 
			consoMinJSpinner= new JSpinner(sm);
			consoMinJSpinner.setPreferredSize(new Dimension(80,80));
            consoMinJSpinner.setEnabled(false);
		}
		return consoMinJSpinner;
	}

    /**
	 * This method initializes consoMaxJSpinner
	 * 
	 * @return javax.swing.JSpinner
	 */
	private JSpinner getConsoMaxJSpinner() {
		if (consoMaxJSpinner == null) {
            SpinnerNumberModel sm = new SpinnerNumberModel(2, 2, 100, 1); // displayed, min, max, step 
			consoMaxJSpinner= new JSpinner(sm);
			consoMaxJSpinner.setPreferredSize(new Dimension(80,80));
            consoMaxJSpinner.setEnabled(false);
		}
		return consoMaxJSpinner;
	}

	/**
	 * This method initializes captureImageCheckBox
	 * 
	 * @return java.awt.Checkbox
	 */
	private Checkbox getCaptureImageCheckBox() {
		if (captureImageCheckBox == null) {
			captureImageCheckBox = new Checkbox();
		}
		return captureImageCheckBox;
	}

	/**
	 * This method initializes segmentedImageCheckBox
	 * 
	 * @return java.awt.Checkbox
	 */
	private Checkbox getSegmentedImageCheckBox() {
		if (segmentedImageCheckBox == null) {
			segmentedImageCheckBox = new Checkbox();
		}
		return segmentedImageCheckBox;
	}

	/**
	 * This method initializes speedVsQualityChoice
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getSpeedVsQualityChoice() {
		if (speedVsQualityChoice == null) {
			speedVsQualityChoice = new Choice();
			speedVsQualityChoice.add("DISABLE_ALGORITHM");
			speedVsQualityChoice.add("FAVOR_SPEED");
			speedVsQualityChoice.add("INTERMEDIATE_FAST");
			speedVsQualityChoice.add("INTERMEDIATE");
			speedVsQualityChoice.add("FAVOR_QUALITY");
			speedVsQualityChoice.select("INTERMEDIATE");
		}
		return speedVsQualityChoice;
	}

	/**
	 * This method initializes constraintChoice
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getConstraintChoice() {
		if (constraintChoice == null) {
			constraintChoice = new Choice();
			constraintChoice.add("UNCONSTRAINED");
			constraintChoice.add("CONSTRAINED_RIGHT_THEN_LEFT");
			constraintChoice.add("CONSTRAINED_LEFT_THEN_RIGHT");
		}
		return constraintChoice;
	}

	/**
	 * This method initializes toggleChoice
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getToggleChoice() {
		if (toggleChoice == null) {
			toggleChoice = new Choice();
			toggleChoice.add("PRESENT_DEACTIVATED");
			toggleChoice.add("PRESENT_DEACTIVATED_DAMAGED");
			toggleChoice.add("PRESENT_BANDAGED_AMPUTEE");
			toggleChoice.add("PRESENT_BANDAGED_AMPUTEE_DAMAGED");
		}
		return toggleChoice;
	}

	/**
	 * This method initializes soundActivationYesRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getSoundActivationYesRadioButton() {
		if (soundActivationYesRadioButton == null) {
			soundActivationYesRadioButton = new JRadioButton();
			soundActivationYesRadioButton.setText("Enabled");
		}
		return soundActivationYesRadioButton;
	}

	/**
	 * This method initializes soundActivationNoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getSoundActivationNoRadioButton() {
		if (soundActivationNoRadioButton == null) {
			soundActivationNoRadioButton = new JRadioButton();
			soundActivationNoRadioButton.setText("Disabled");
			soundActivationNoRadioButton.setSelected(true);
		}
		return soundActivationNoRadioButton;
	}

	/**
	 * This method initializes captureAutoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getCaptureAutoRadioButton() {
		if (captureAutoRadioButton == null) {
			captureAutoRadioButton = new JRadioButton();
			captureAutoRadioButton.setText("Automatic");
			captureAutoRadioButton.setSelected(true);
		}
		return captureAutoRadioButton;
	}

	/**
	 * This method initializes captureManualRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getCaptureManualRadioButton() {
		if (captureManualRadioButton == null) {
			captureManualRadioButton = new JRadioButton();
			captureManualRadioButton.setText("Manual");
		}
		return captureManualRadioButton;
	}

	/**
	 * This method initializes resolutionStandardRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getResolutionStandardRadioButton() {
		if (resolutionStandardRadioButton == null) {
			resolutionStandardRadioButton = new JRadioButton();
			resolutionStandardRadioButton.setText("500");
			resolutionStandardRadioButton.setSelected(true);
		}
		return resolutionStandardRadioButton;
	}

	/**
	 * This method initializes resolutionHighRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getResolutionHighRadioButton() {
		if (resolutionHighRadioButton == null) {
			resolutionHighRadioButton = new JRadioButton();
			resolutionHighRadioButton.setText("1000");
		}
		return resolutionHighRadioButton;
	}

	/**
	 * This method initializes resolutionStandardRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getLiveResolutionStandardRadioButton() {
		if (liveResolutionStandardRadioButton == null) {
			liveResolutionStandardRadioButton = new JRadioButton();
			liveResolutionStandardRadioButton.setText("250");
		}
		return liveResolutionStandardRadioButton;
	}

	/**
	 * This method initializes resolutionHighRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getLiveResolutionLowRadioButton() {
		if (liveResolutionLowRadioButton == null) {
			liveResolutionLowRadioButton = new JRadioButton();
			liveResolutionLowRadioButton.setText("125");
			liveResolutionLowRadioButton.setSelected(true);
		}
		return liveResolutionLowRadioButton;
	}

	/**
	 * This method initializes thumbnailResolutionFirstRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getThumbnailResolutionFirstRadioButton() {
		if (thumbnailResolutionFirstRadioButton == null) {
			thumbnailResolutionFirstRadioButton = new JRadioButton();
			thumbnailResolutionFirstRadioButton.setText("62.5");
		}
		return thumbnailResolutionFirstRadioButton;
	}

	/**
	 * This method initializes thumbnailResolutionSecondRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getThumbnailResolutionSecondRadioButton() {
		if (thumbnailResolutionSecondRadioButton == null) {
			thumbnailResolutionSecondRadioButton = new JRadioButton();
			thumbnailResolutionSecondRadioButton.setText("125");
			thumbnailResolutionSecondRadioButton.setSelected(true);
		}
		return thumbnailResolutionSecondRadioButton;
	}

	/**
	 * This method initializes thumbnailResolutionThirdRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getThumbnailResolutionThirdRadioButton() {
		if (thumbnailResolutionThirdRadioButton == null) {
			thumbnailResolutionThirdRadioButton = new JRadioButton();
			thumbnailResolutionThirdRadioButton.setText("250");
		}
		return thumbnailResolutionThirdRadioButton;
	}

    /**
	 * This method initializes rawCompressionTypeRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getRawCompressionTypeRadioButton() {
		if (rawCompressionTypeRadioButton == null) {
			rawCompressionTypeRadioButton = new JRadioButton();
			rawCompressionTypeRadioButton.setText("Raw");
            rawCompressionTypeRadioButton.setSelected(true);
		}
		return rawCompressionTypeRadioButton;
	}

    /**
	 * This method initializes lossyCompressionTypeRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getLossyCompressionTypeRadioButton() {
		if (lossyCompressionTypeRadioButton == null) {
			lossyCompressionTypeRadioButton = new JRadioButton();
			lossyCompressionTypeRadioButton.setText("Lossy");
		}
		return lossyCompressionTypeRadioButton;
	}

    /**
	 * This method initializes losslessCompressionTypeRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getLosslessCompressionTypeRadioButton() {
		if (losslessCompressionTypeRadioButton == null) {
			losslessCompressionTypeRadioButton = new JRadioButton();
			losslessCompressionTypeRadioButton.setText("Lossless");
		}
		return losslessCompressionTypeRadioButton;
	}

    /**
	 * This method initializes consoEnabledYesRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getConsoEnabledYesRadioButton() {
		if (consoEnabledYesRadioButton == null) {
			consoEnabledYesRadioButton = new JRadioButton();
			consoEnabledYesRadioButton.setText("Yes");
            consoEnabledYesRadioButton
					.addActionListener(new ConsoEnabledNoListener(this));
		}
		return consoEnabledYesRadioButton;
	}

	/**
	 * This method initializes consoEnabledNoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getConsoEnabledNoRadioButton() {
		if (consoEnabledNoRadioButton == null) {
			consoEnabledNoRadioButton = new JRadioButton();
			consoEnabledNoRadioButton.setText("No");
            consoEnabledNoRadioButton.setSelected(true);
            consoEnabledNoRadioButton
					.addActionListener(new ConsoEnabledNoListener(this));
		}
		return consoEnabledNoRadioButton;
	}

    /**
	 * This method initializes consoAutoContinueYesRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getConsoAutoContinueYesRadioButton() {
		if (consoAutoContinueYesRadioButton == null) {
			consoAutoContinueYesRadioButton = new JRadioButton();
			consoAutoContinueYesRadioButton.setText("Yes");
            consoAutoContinueYesRadioButton.setEnabled(false);
		}
		return consoAutoContinueYesRadioButton;
	}

	/**
	 * This method initializes consoAutoContinueNoRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getConsoAutoContinueNoRadioButton() {
		if (consoAutoContinueNoRadioButton == null) {
			consoAutoContinueNoRadioButton = new JRadioButton();
			consoAutoContinueNoRadioButton.setText("No");
            consoAutoContinueNoRadioButton.setSelected(true);
            consoAutoContinueNoRadioButton.setEnabled(false);
		}
		return consoAutoContinueNoRadioButton;
	}

	/**
	 * This method initializes okPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getOkPanel() {
		if (okPanel == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			okPanel = new JPanel();
			okPanel.setLayout(new GridBagLayout());
			okPanel.add(getOkButton(), gridBagConstraints5);
		}
		return okPanel;
	}

	/**
	 * This method initializes verifPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getVerifPanel() {
		if (verifPanel == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			verifPanel = new JPanel();
			verifPanel.setLayout(new GridBagLayout());
			verifPanel.add(getVerifButton(), gridBagConstraints5);
		}
		return verifPanel;
	}

	protected void close() {
		this.getOptionFrame().dispose();
	}

	/**
	 * This method initializes cancelPanel
	 * 
	 * @return java.awt.Panel
	 */
	private Panel getCancelPanel() {
		if (cancelPanel == null) {
			cancelPanel = new Panel();
			cancelPanel.setLayout(new GridBagLayout());
			cancelPanel.add(getCancelButton(), new GridBagConstraints());
		}
		return cancelPanel;
	}

	/**
	 * This method initializes cancelPanel
	 * 
	 * @return java.awt.Panel
	 */
	private Panel getLoadPanel() {
		if (loadPanel == null) {
			loadPanel = new Panel();
			loadPanel.setLayout(new GridBagLayout());
			loadPanel.add(getLoadButton(), new GridBagConstraints());
		}
		return loadPanel;
	}

	/**
	 * This method initializes fteVsQualityPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getFteVsQualityPanel() {
		if (fteVsQualityPanel == null) {
			fteVsQualityPanel = new JPanel();
			fteVsQualityPanel.setLayout(new GridBagLayout());
			fteVsQualityPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"FTE vs Quality", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			fteVsQualityPanel.setMinimumSize(new Dimension(38, 50));
			fteVsQualityPanel.setPreferredSize(new Dimension(38, 50));
			fteVsQualityPanel.add(getFteVsQualityChoice(),
					new GridBagConstraints());
		}
		return fteVsQualityPanel;
	}

  /**
	 * This method initializes fteVsQualityChoice
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getFteVsQualityChoice() {
		if (fteVsQualityChoice == null) {
			fteVsQualityChoice = new Choice();
			fteVsQualityChoice.add("NO_CONTROL");
			fteVsQualityChoice.add("LOW");
			fteVsQualityChoice.add("STANDARD");
			fteVsQualityChoice.add("SECURE");
			fteVsQualityChoice.add("VERY_SECURE");
			fteVsQualityChoice.select(2);
		}
		return fteVsQualityChoice;
	}

    /**
	 * This method initializes fteVsQualityDamagedPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getFteVsQualityDamagedPanel() {
		if (fteVsQualityDamagedPanel == null) {
			fteVsQualityDamagedPanel = new JPanel();
			fteVsQualityDamagedPanel.setLayout(new GridBagLayout());
			fteVsQualityDamagedPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"FTE vs Quality for DAMAGED items", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			fteVsQualityDamagedPanel.setMinimumSize(new Dimension(38, 50));
			fteVsQualityDamagedPanel.setPreferredSize(new Dimension(38, 50));
			fteVsQualityDamagedPanel.add(getFteVsQualityDamagedChoice(),
					new GridBagConstraints());
		}
		return fteVsQualityDamagedPanel;
	}

    /**
	 * This method initializes fteVsQualityDamagedChoice
	 * 
	 * @return java.awt.Choice
	 */
	private Choice getFteVsQualityDamagedChoice() {
		if (fteVsQualityDamagedChoice == null) {
			fteVsQualityDamagedChoice = new Choice();
			fteVsQualityDamagedChoice.add("NO_CONTROL");
			fteVsQualityDamagedChoice.add("LOW");
			fteVsQualityDamagedChoice.add("STANDARD");
			fteVsQualityDamagedChoice.add("SECURE");
			fteVsQualityDamagedChoice.add("VERY_SECURE");
			fteVsQualityDamagedChoice.select(1);
		}
		return fteVsQualityDamagedChoice;
	}
        
      
}
