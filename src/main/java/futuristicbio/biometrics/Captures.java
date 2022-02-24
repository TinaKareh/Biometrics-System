package futuristicbio.biometrics;





import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.morpho.mbop.api.Acquisition;
import com.morpho.mbop.api.AcquisitionDescriptor;
import com.morpho.mbop.api.BiometricItemType;

public class Captures 
{
	private JList						capturesDoneList;
	private JList						capturesToDoList;
	private AcquisitionDescriptor[]		capturesDone;
	private AcquisitionDescriptor[]		capturesToDo;
	private Acquisition					acquisition;
	private JFrame						capturesFrame;
	private JPanel						capturesContentPanel;
	private JPanel						capturesDoneListPanel;
	private JPanel						capturesToDoListPanel;
	private JPanel						okCancelPanel;
	private JPanel						okPanel;
	private Panel						cancelPanel;
	private JButton						okButton;
	private JButton						cancelButton;

	/**
	 * Constructor
	 * 
	 * @param newAcquisition is the Acquisition object which allows to call ChangeNextCapture
	 */
	public Captures( Acquisition newAcquisition ) 
	{
		acquisition = newAcquisition;
		capturesDone = acquisition.GetCapturesDone();
		capturesToDo = acquisition.GetCapturesToDo();
		capturesDoneList = new JList(UpdateItemList(capturesDone));
		capturesDoneList.setEnabled(false);
		capturesDoneList.setFixedCellWidth(180);
		capturesDoneList.setFixedCellHeight(25);
		capturesToDoList = new JList(UpdateItemList(capturesToDo));
		capturesToDoList.setFixedCellWidth(180);
		capturesToDoList.setFixedCellHeight(25);

		getCapturesFrame().setVisible(true);
	}

	/**
	 * This method initializes capturesFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getCapturesFrame() 
	{
		if( capturesFrame == null ) 
		{
			capturesFrame = new JFrame();
			capturesFrame.setSize( new Dimension( 220, 550 ) );
			capturesFrame.setTitle( "Select next capture" );
			capturesFrame.setLocationRelativeTo( null );
			capturesFrame.setResizable( false );
			capturesFrame.addWindowListener( new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e) 
				{
					close();
				}
			});
			
			capturesFrame.setContentPane(getCapturesContentPane());
		}
		
		return capturesFrame;
	}

	/**
	 * This method initializes capturesDoneListPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getCapturesDoneListPane() 
	{
		if (capturesDoneListPanel == null) 
		{
			capturesDoneListPanel = new JPanel();
			capturesDoneListPanel.setSize(new Dimension(200, 250));
			capturesDoneListPanel.add(capturesDoneList);
			JScrollPane scrollPane = new JScrollPane(capturesDoneList);
			capturesDoneListPanel.add(scrollPane, null);
		}
		
		return capturesDoneListPanel;
	}

	/**
	 * This method initializes capturesToDoListPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getCapturesToDoListPane() 
	{
		if (capturesToDoListPanel == null) 
		{
			capturesToDoListPanel = new JPanel();
			capturesToDoListPanel.setSize(new Dimension(200, 250));
			capturesToDoListPanel.add(capturesToDoList);
			JScrollPane scrollPane = new JScrollPane(capturesToDoList);
			capturesToDoListPanel.add(scrollPane, null);
		}
		
		return capturesToDoListPanel;
	}

	/**
	 * This method initializes capturesContentPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getCapturesContentPane() 
	{
		if (capturesContentPanel == null) 
		{
			capturesContentPanel = new JPanel();
			capturesContentPanel.setPreferredSize(new Dimension(220, 550));
			capturesContentPanel.setMinimumSize(new Dimension(220, 550));
			capturesContentPanel.add(new JLabel("Captures done"), BorderLayout.NORTH);
			capturesContentPanel.add(getCapturesDoneListPane(), BorderLayout.NORTH);
			capturesContentPanel.add(new JLabel("Captures to do"), BorderLayout.CENTER);
			capturesContentPanel.add(getCapturesToDoListPane(), BorderLayout.CENTER);
			capturesContentPanel.add(getOkCancelPanel(), BorderLayout.SOUTH);
		}
		return capturesContentPanel;
	}

	/**
	 * This method initializes okCancelPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getOkCancelPanel() 
	{
		if (okCancelPanel == null) 
		{
			okCancelPanel = new JPanel();
			okCancelPanel.setLayout( new BoxLayout( getOkCancelPanel(), BoxLayout.X_AXIS ) );
			okCancelPanel.add(getOkPanel(), null);
			okCancelPanel.add(getCancelPanel(), null);
		}
		return okCancelPanel;
	}

	/**
	 * This method initializes okButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getOkButton() 
	{
		if (okButton == null) 
		{
			okButton = new JButton();
			okButton.setText("OK");
			okButton.setSelected(true);
			okButton.addActionListener(new OkListener(this));
		}
		return okButton;
	}

	/**
	 * This method initializes cancelButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getCancelButton() 
	{
		if (cancelButton == null) 
		{
			cancelButton = new JButton();
			cancelButton.setHorizontalAlignment(SwingConstants.RIGHT);
			cancelButton.setText("Cancel");
			cancelButton.addActionListener(new CancelListener(this));
		}
		return cancelButton;
	}

	/**
	 * This method initializes okPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getOkPanel() 
	{
		if (okPanel == null) 
		{
			okPanel = new JPanel();
			okPanel.setLayout(new GridBagLayout());
			okPanel.add(getOkButton(), new GridBagConstraints());
		}
		return okPanel;
	}

	/**
	 * This method initializes cancelPanel
	 * 
	 * @return java.awt.Panel
	 */
	private Panel getCancelPanel() 
	{
		if (cancelPanel == null) 
		{
			cancelPanel = new Panel();
			cancelPanel.setLayout(new GridBagLayout());
			cancelPanel.add(getCancelButton(), new GridBagConstraints());
		}
		return cancelPanel;
	}

	/**
	 * This method closes Captures window
	 */
	protected void close() 
	{
		getCapturesFrame().dispose();
	}

	/**
	 * Listener on OK Button
	 * 
	 * This method calls ChangeNextCapture and closes Captures window
	 */
	class OkListener implements ActionListener 
	{
		private Captures captures = null;

		OkListener(Captures newCaptures) 
		{
			captures = newCaptures;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{           
			try 
			{
				acquisition.ChangeNextCapture( capturesToDo[capturesToDoList.getSelectedIndex()] );
				captures.close();
			}
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog( null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null );
			}
		}
	}

	/**
	 * Listener on Cancel Button
	 * 
	 * This method closes Captures window
	 */
	class CancelListener implements ActionListener 
	{
		private Captures captures = null;

		CancelListener( Captures newCaptures ) 
		{
			captures = newCaptures;
			captures.close();
		}

		@Override
		public void actionPerformed( ActionEvent arg0 ) 
		{
			captures.close();
		}
	}

	public String[] UpdateItemList(AcquisitionDescriptor[] i__AcqDesc)
    {
        String[] o__Items = new String[i__AcqDesc.length];
        for (int i = 0; i < i__AcqDesc.length; i++)
        {
            if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE))
                    o__Items[i] = "SLAP RIGHT ITEMS";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE))
                    o__Items[i] = "SLAP LEFT ITEMS";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_THUMB) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_THUMB))
                o__Items[i] = "SLAP BOTH THUMBS";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE))
                o__Items[i] = "SLAP BOTH FOREFINGERS";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_THUMB))
                o__Items[i] = "SLAP RIGHT THUMB";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_THUMB))
                o__Items[i] = "SLAP LEFT THUMB";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE))
                o__Items[i] = "SLAP RIGHT FOREFINGER";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE))
                o__Items[i] = "SLAP LEFT FOREFINGER";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_THUMB))
                o__Items[i] = "ROLLED RIGHT THUMB";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_FORE))
                o__Items[i] = "ROLLED RIGHT FORE";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_MIDDLE))
                o__Items[i] = "ROLLED RIGHT MIDDLE";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_RING))
                o__Items[i] = "ROLLED RIGHT RING";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_RIGHT_LITTLE))
                o__Items[i] = "ROLLED RIGHT LITTLE";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_THUMB))
                o__Items[i] = "ROLLED LEFT THUMB";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_FORE))
                o__Items[i] = "ROLLED LEFT FORE";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_MIDDLE))
                o__Items[i] = "ROLLED LEFT MIDDLE";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_RING))
                o__Items[i] = "ROLLED LEFT RING";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_ROLLED_LEFT_LITTLE))
                o__Items[i] = "ROLLED LEFT LITTLE";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_WRITERS))
                o__Items[i] = "PALM RIGHT WRITERS";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE_UP) && 
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_LOWER) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_UPPER))
                    o__Items[i] = "RIGHT FULL HAND";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_FORE_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_MIDDLE_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_RING_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_RIGHT_LITTLE_UP) && 
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_UPPER))
                    o__Items[i] = "PALM RIGHT UPPER";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_RIGHT_LOWER))
                o__Items[i] = "PALM RIGHT LOWER";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_WRITERS))
                o__Items[i] = "PALM LEFT WRITERS";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_LOWER) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_UPPER))
                    o__Items[i] = "LEFT FULL HAND";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_FORE_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE_UP) && 
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_MIDDLE_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_RING_UP) &&
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_FLAT_LEFT_LITTLE_UP) && 
                i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_UPPER))
                    o__Items[i] = "PALM LEFT UPPER";
            else if (i__AcqDesc[i].IsActivated(BiometricItemType.BIOITEM_TYPE_PALM_LEFT_LOWER))
                o__Items[i] = "PALM LEFT LOWER";
        }
        return o__Items;
    }
}