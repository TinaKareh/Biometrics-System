package futuristicbio.biometrics;






import com.morpho.mbop.gui.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.morpho.mbop.api.*;

/**
 * Class implementing the result frame of the acquisition. This frame shows the
 * best results of an acquisition when it is completed.
 */
public class ExampleResultFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -884948696373511851L;

	// Current acquisition
	private Acquisition			acquisition;

	// Images containing the result of the acquisition
	private ImageViewer[]	ResViews;

	// Option frame, which allows to save the obtained image
	private ImageBackupOptions	imageBackup;

	// Says if some pictures have to be reacquired.
	private boolean recapture;

	private int numberOfPanels = 29;
        private String applicatId;
        
        private ExampleMainFrame  mainframe;

    public void setMainframe(ExampleMainFrame mainframe) {
        this.mainframe = mainframe;
    }

    public ExampleMainFrame getMainframe() {
        return mainframe;
    }
    
    
        

    public String getApplicantId() {
        return applicatId;
    }

    public void setApplicantId(String applicatId) {
        this.applicatId = applicatId;
    }
        
        

	/**
	 * Constructor
	 */
	public ExampleResultFrame() {
		super("KAA IDMS Biometrics Capture");
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        final float ratioWidth = screenSize.width / 1280.f;
        final float ratioHeight = screenSize.height / 1024.f;
        setSize((int)(800 * ratioWidth), (int)(900 * ratioHeight));
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);

		recapture = false;

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				LaunchImageBackupOption();
			}
		});

		// Size of the result images
		int segmentedImageWidth = getSize().width / 5;
		int segmentedImageHeight = getSize().height / 7;
		int slapImageWidth = getSize().width / 3;
		int slapImageHeight = 2 * getSize().height / 7;
		int palmImageWidth = getSize().width / 3;
		int palmImageHeight = getSize().height / 7;

		ResViews = new ImageViewer[numberOfPanels];

		// Add panels including the future result images
		for (int i = 0; i < ResViews.length; i++)
		{
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			if (i < 5)
			{
				panel.setBounds(i * segmentedImageWidth, 0,
						segmentedImageWidth, segmentedImageHeight);
			}
			else if (i < 10)
			{
				panel.setBounds((i - 5) * segmentedImageWidth,
						segmentedImageHeight, segmentedImageWidth,
						segmentedImageHeight);
			}
			else if (i < 13)
			{
				panel.setBounds((i - 10) * slapImageWidth,
						2 * segmentedImageHeight, slapImageWidth,
						slapImageHeight);
			}
			else if (i < 17)
			{
				panel.setBounds((i - 13) * slapImageWidth / 4,
						2 * segmentedImageHeight + slapImageHeight, slapImageWidth / 4,
						segmentedImageHeight);
			}
			else if (i < 19)
			{
				panel.setBounds((i - 17) * slapImageWidth / 2 + slapImageWidth,
						2 * segmentedImageHeight + slapImageHeight, slapImageWidth / 2,
						segmentedImageHeight);
			}
			else if (i < 23)
			{
				panel.setBounds((i - 19) * slapImageWidth / 4 + slapImageWidth * 2,
						2 * segmentedImageHeight + slapImageHeight, slapImageWidth / 4,
						segmentedImageHeight);
			}
			else if (i < 26)
			{
				panel.setBounds((i - 23) * palmImageWidth,
						3 * segmentedImageHeight + slapImageHeight, palmImageWidth,
						palmImageHeight);
			}
			else
			{
				panel.setBounds((i - 26) * palmImageWidth,
						3 * segmentedImageHeight + slapImageHeight + palmImageHeight, palmImageWidth,
						palmImageHeight);
			}
			if (i < 10)
			{
				ResViews[i] = new ImageViewer(panel, segmentedImageWidth,
						segmentedImageHeight);
			}
			else if (i < 13)
			{
				ResViews[i] = new ImageViewer(panel, slapImageWidth,
						slapImageHeight);
			}
			else if (i < 17)
			{
				ResViews[i] = new ImageViewer(panel, slapImageWidth / 4,
						segmentedImageHeight);
			}
			else if (i < 19)
			{
				ResViews[i] = new ImageViewer(panel, segmentedImageWidth,
						segmentedImageHeight);
			}
			else if (i < 23)
			{
				ResViews[i] = new ImageViewer(panel, slapImageWidth / 4,
						segmentedImageHeight);
			}
			else
			{
				ResViews[i] = new ImageViewer(panel, palmImageWidth,
						palmImageHeight);
			}

			// Listeners for pictures to reacquire.
			final int j = i;
			panel.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e))
					{
						ZoomedImage contentPane = new ZoomedImage(ResViews[j].getImage());
						String title = "";
						switch (j)
						{
							case 0: title = "Rolled right thumb"; break;
							case 1: title = "Rolled right fore"; break;
							case 2: title = "Rolled right middle"; break;
							case 3: title = "Rolled right ring"; break;
							case 4: title = "Rolled right little"; break;
							case 5: title = "Rolled left thumb"; break;
							case 6: title = "Rolled left fore"; break;
							case 7: title = "Rolled left middle"; break;
							case 8: title = "Rolled left ring"; break;
							case 9: title = "Rolled left little"; break;
							case 10: title = "Left slap"; break;
							case 11: title = "Both thumbs"; break;
							case 12: title = "Right slap"; break;
							case 13: title = "Flat left little"; break;
							case 14: title = "Flat left ring"; break;
							case 15: title = "Flat left middle"; break;
							case 16: title = "Flat left fore"; break;
							case 17: title = "Flat left thumb"; break;
							case 18: title = "Flat right thumb"; break;
							case 19: title = "Flat right fore"; break;
							case 20: title = "Flat right middle"; break;
							case 21: title = "Flat right ring"; break;
							case 22: title = "Flat right little"; break;
							case 23: title = "Palm right writers"; break;
							case 24: title = "Palm right upper"; break;
							case 25: title = "Palm right lower"; break;
							case 26: title = "Palm left writers"; break;
							case 27: title = "Palm left upper"; break;
							case 28: title = "Palm left lower"; break;
							default: break;
						}
						JFrame f = new JFrame(title);
                        f.setSize((int)(800 * ratioWidth), (int)(800 * ratioWidth));
						f.setContentPane(contentPane);
                        f.setLocation((int)(100 * ratioWidth), (int)(100 * ratioWidth));
						f.setState(Frame.NORMAL);
						f.setAlwaysOnTop(true);
						f.setVisible(true);
					}
					else if (SwingUtilities.isRightMouseButton(e))
					{
						RecordCaptureToReacquire(j);
					}
				}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
			});
			panel.add(ResViews[i], BorderLayout.CENTER);
			add(panel);
		}
	}

	protected void close() {
//		for (int i = 0; i < ResViews.length; i++) {
//			ResViews[i].finalize();
//			/*ResViews[i] = null;*/
//		}
		dispose();
	}

	/**
	 * Interface function, used to connect the created acquisition to the result
	 * window (in order to get the result captures when the acquisition is
	 * complete
	 * 
	 * @param acquisition
	 *            is the current acquisition
	 */
	public void Connect(Acquisition newAcquisition) {
		acquisition = newAcquisition;
		imageBackup = new ImageBackupOptions(this, acquisition);
	}

	/**
	 * Disconnect the acquisition to the frame
	 */
	public void Disconnect(){
            System.out.println("Setting acquisition to null");
	     acquisition = null;
	}

	public void showImageResult() {
             System.out.println("image results ........");
//		JOptionPane.showMessageDialog(this,
//				"To zoom a picture, click with left mouse button. To recapture some pictures, click with right mouse button.",
//				"Information", JOptionPane.INFORMATION_MESSAGE);
		updateImgResults();
	}

	/**************************************************************************************/
	/****************************** DISPLAY RESULT IMAGES *********************************/
	/**************************************************************************************/

	/**
	 * Update the image result of a slap
	 */
	void updateSlapImage(BiometricData bioData, int index)
			throws com.morpho.mbop.api.Exception {
            System.out.println("working with slap index: "+ index); 
		if (bioData.HasImage())
			ResViews[index].UpdateImage(bioData.GetImage());
	}

	void updatePalmImage(BiometricData bioData, int index)
			throws com.morpho.mbop.api.Exception
	{
		if (bioData.HasImage())
			ResViews[index].UpdateImage(bioData.GetImage());
	}

	/**
	 * Update the image result of a segmented finger
	 */
	void updateSegmentedImage(BiometricData bioData,
			BiometricItemType itemType, int index)
			throws com.morpho.mbop.api.Exception {

		if (bioData.HasSegmentedImage(itemType))
			ResViews[index].UpdateImage(bioData.GetSegmentedImage(itemType));
	}

	/**
	 * Reset image results panel
	 */
	void resetImgResults()	{
            System.out.println("entered image results func......"); 
//		for (int index = 0; index < numberOfPanels; index++)
//		{
//			ResViews[index].finalize();
//		}
	}

	/**
	 * Update all the image results of a given acquisition type
	 */
	void updateImgResults() {
            
            System.out.println("started update image results.......");
		try {
                    System.out.println("attempting image update"); 
			AcquisitionDescriptor acqDesc = new AcquisitionDescriptor();
			for (BiometricItemType type : BiometricItemType.values())
			{
				acqDesc.SetItemActivation(type, true);
			}

//			resetImgResults();

			if (acquisition.HasCaptures(acqDesc)) {
                            
                            System.out.println("Acquisition had captures...");
				BiometricData[] bioData = acquisition
						.GetBestCaptures(acqDesc);
                                System.out.println("biodata length: "+ bioData.length);
				for (int i = 0; i < bioData.length; i++) {
					AcquisitionDescriptor descriptor = bioData[i]
							.GetDescriptor();
					if (descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE)&&
						descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE)&&
						descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE) &&
						descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING)) {
                                           
							updateSlapImage(bioData[i], 10);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE) &&
								descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE) &&
								descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE) &&
								descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING)) {
							updateSlapImage(bioData[i], 12);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_THUMB) &&
								descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_THUMB)) {
						updateSlapImage(bioData[i], 11);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE) &&
								descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE)) {
						updateSlapImage(bioData[i], 11);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_THUMB)) {
						updateSlapImage(bioData[i], 18);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE)) {
						updateSlapImage(bioData[i], 19);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE)) {
						updateSlapImage(bioData[i], 20);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING)) {
						updateSlapImage(bioData[i], 21);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE)) {
						updateSlapImage(bioData[i], 22);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_THUMB)) {
						updateSlapImage(bioData[i], 17);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE)) {
						updateSlapImage(bioData[i], 16);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE)) {
						updateSlapImage(bioData[i], 15);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING)) {
						updateSlapImage(bioData[i], 14);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE)) {
						updateSlapImage(bioData[i], 13);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_THUMB)) {
						updateSlapImage(bioData[i], 5);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_FORE)) {
						updateSlapImage(bioData[i], 6);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_MIDDLE)) {
						updateSlapImage(bioData[i], 7);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_RING)) {
						updateSlapImage(bioData[i], 8);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_LITTLE)) {
						updateSlapImage(bioData[i], 9);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_THUMB)) {
						updateSlapImage(bioData[i], 0);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_FORE)) {
						updateSlapImage(bioData[i], 1);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_MIDDLE)) {
						updateSlapImage(bioData[i], 2);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_RING)) {
						updateSlapImage(bioData[i], 3);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_LITTLE)) {
						updateSlapImage(bioData[i], 4);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_WRITERS)) {
						updatePalmImage(bioData[i], 23);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_LOWER)) {
						updatePalmImage(bioData[i], 25);
					} else if ( descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE_UP) &&
                                descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE_UP) &&
                                descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING_UP) &&
                                descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE_UP) &&
                                descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_UPPER)) {
                        updateSlapImage(bioData[i], 24);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_WRITERS)) {
						updatePalmImage(bioData[i], 26);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_LOWER)) {
						updatePalmImage(bioData[i], 28);
                    } else if ( descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE_UP) &&
                                descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE_UP) &&
                                descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING_UP) &&
                                descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE_UP) &&
                                descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_UPPER)) {
                        updateSlapImage(bioData[i], 27);
					} else if (	descriptor.IsActivated(BiometricItemType.BIOITEM_TYPE_OTHER)) {
						updateSlapImage(bioData[i], 11);
					} else {
						System.out.println("Unrecognized capture");
					}
				}
			}

		} catch (com.morpho.mbop.api.Exception e) {
                    e.printStackTrace();
			System.out
					.println("Couldn't load information");
		}
	}

	/**************************************************************************************/
	/********************************* SAVE RESULT IMAGES *********************************/
	/**************************************************************************************/

	/**
	 * Launch a dialog in order to know if the images need to be saved or not
	 * (if it is the case, a frame is created in order to select the backup
	 * path)
	 */
	public void LaunchImageBackupOption() {

		int res = JOptionPane.showConfirmDialog(this,
				"Do you want to save the obtained images ?", "Image Backup",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (res == JOptionPane.OK_OPTION)
		{
			imageBackup.show();
			setVisible(false);
		}
		else if (recapture)
		{
			recapture = false;
		}
		else
		{
                    
                    System.out.println("attempting print panel close");
			close();
		}
	}

	/**************************************************************************************/
	/***************************** RECORD IMAGES TO RECAPTURE *****************************/
	/**************************************************************************************/

	/**
	 * Enable acqDesc items corresponding to selected capture.
	 */
	public void RecordCaptureToReacquire(int index) {
		AcquisitionDescriptor acqDesc = new AcquisitionDescriptor();
		recapture = true;
		switch (index) {
		case 0:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_THUMB, true);
			JOptionPane.showMessageDialog(this,
				"Rolled right thumb added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 1:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_FORE, true);
			JOptionPane.showMessageDialog(this,
				"Rolled right fore added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 2:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_MIDDLE, true);
			JOptionPane.showMessageDialog(this,
				"Rolled right middle added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 3:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_RING, true);
			JOptionPane.showMessageDialog(this,
				"Rolled right ring added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 4:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_LITTLE, true);
			JOptionPane.showMessageDialog(this,
				"Rolled right little added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 5:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_THUMB, true);
			JOptionPane.showMessageDialog(this,
				"Rolled left thumb added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 6:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_FORE, true);
			JOptionPane.showMessageDialog(this,
				"Rolled left fore added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 7:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_MIDDLE, true);
			JOptionPane.showMessageDialog(this,
				"Rolled left middle added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 8:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_RING, true);
			JOptionPane.showMessageDialog(this,
				"Rolled left ring added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 9:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_LITTLE, true);
			JOptionPane.showMessageDialog(this,
				"Rolled left little added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 10:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE, true);
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE, true);
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING, true);
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE, true);
			JOptionPane.showMessageDialog(this,
				"Left slap added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 11:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_THUMB, true);
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_THUMB, true);
			JOptionPane.showMessageDialog(this,
				"Slap both thumbs added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 12:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE, true);
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE, true);
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING, true);
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE, true);
			JOptionPane.showMessageDialog(this,
				"Right slap added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 13:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE, true);
			JOptionPane.showMessageDialog(this,
				"Flat left little added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 14:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING, true);
			JOptionPane.showMessageDialog(this,
				"Flat left ring added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 15:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE, true);
			JOptionPane.showMessageDialog(this,
				"Flat left middle added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 16:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE, true);
			JOptionPane.showMessageDialog(this,
				"Flat left fore added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 17:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_THUMB, true);
			JOptionPane.showMessageDialog(this,
				"Flat left thumb added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 18:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_THUMB, true);
			JOptionPane.showMessageDialog(this,
				"Flat right thumb added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 19:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE, true);
			JOptionPane.showMessageDialog(this,
				"Flat right fore added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 20:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE, true);
			JOptionPane.showMessageDialog(this,
				"Flat right middle added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 21:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING, true);
			JOptionPane.showMessageDialog(this,
				"Flat right ring added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 22:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE, true);
			JOptionPane.showMessageDialog(this,
				"Flat right little added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 23:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_WRITERS, true);
			JOptionPane.showMessageDialog(this,
				"Left writers palm added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 24:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_UPPER, true);
            acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE_UP, true);
            acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE_UP, true);
            acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING_UP, true);
            acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE_UP, true);
			JOptionPane.showMessageDialog(this,
				"Left upper palm added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 25:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_LOWER, true);
			JOptionPane.showMessageDialog(this,
				"Left lower palm added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 26:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_WRITERS, true);
			JOptionPane.showMessageDialog(this,
				"Right writers palm added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 27:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_UPPER, true);
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE_UP, true);
            acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE_UP, true);
            acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING_UP, true);
            acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE_UP, true);
			JOptionPane.showMessageDialog(this,
				"Right upper palm added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 28:
			acqDesc.SetItemActivation(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_LOWER, true);
			JOptionPane.showMessageDialog(this,
				"Right lower palm added for recapture.",
				"Recapture list updated", JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			break;
		}
		try {
			acquisition.UpdateScenario(acqDesc);
		} catch (com.morpho.mbop.api.Exception e) {
			JOptionPane.showMessageDialog(null, "Exception caught" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE, null);
		}
	}
}
