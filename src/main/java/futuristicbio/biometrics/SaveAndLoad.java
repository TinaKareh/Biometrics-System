package futuristicbio.biometrics;



import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Generated with Java Beans
 * 
 */
public class SaveAndLoad
{

	/*******************************************************************************************************
	 * GUI objects
	 *******************************************************************************************************/
	private JFrame			saveAndLoadFrame;
	private JPanel			saveAndLoadContentPane;
	private JPanel			dataPathPanel;
	private JPanel			okCancelPanel;
	private JPanel			okPanel;
	private JButton			okButton;
	private Panel			cancelPanel;
	private JButton			cancelButton;
	private JButton			dataPathButton;
	private JScrollPane		dataPathScrollPane;
	private JTextArea		dataPathTextArea;
	private Options			options;
	private Boolean			shouldSave;
	private byte[]			data;

	/***********************************************************************************************************
	 * CONSTRUCTOR
	 *********************************************************************************************************/
	
	public SaveAndLoad(Options newOptions, byte[] array) 
	{
		options = newOptions;
		if (array != null) 
		{
			shouldSave = true;
			data = array;
		}
		getSaveAndLoadFrame().setVisible(true);
	}

	/***********************************************************************************************************
	 * ACTIONS
	 *********************************************************************************************************/

	public void loadAcquisition() 
	{
		options.loadAcquisition();
		this.getSaveAndLoadFrame().dispose();
	}

	public void saveAcquisition() 
	{
		try 
		{
			String fileName = dataPathTextArea.getText();
			RandomAccessFile f = new RandomAccessFile(fileName, "rw");
			f.write(data);
			f.close();
			this.getSaveAndLoadFrame().dispose();

		} 
		catch(java.lang.Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Exception caught : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
		}
	}

	public void cancelSaveAcquisition() 
	{
		this.getSaveAndLoadFrame().dispose();
	}

	public void reLaunchOptions() 
	{
		options.reLaunchOptions();
		this.getSaveAndLoadFrame().dispose();
	}

	public void selectNewDataPath() 
	{
		this.getSaveAndLoadFrame().setVisible(false);

		JFileChooser chooseDataPath = new JFileChooser();
		chooseDataPath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooseDataPath.setSelectedFile(new File(dataPathTextArea.getText()));
		int res = chooseDataPath.showOpenDialog(getSaveAndLoadContentPane());
		if (res == JFileChooser.APPROVE_OPTION)
		{
			dataPathTextArea.setText(chooseDataPath.getSelectedFile().getAbsolutePath());
		}
		
		this.getSaveAndLoadFrame().setVisible(true);
	}

	/***********************************************************************************************************
	 * PARAMETERS ACCESS
	 *********************************************************************************************************/

	public String getSaveFile() 
	{
		return dataPathTextArea.getText();
	}

	/***********************************************************************************************************
	 * LISTENERS
	 *********************************************************************************************************/

	class OkListener implements ActionListener 
	{
		private SaveAndLoad options;

		OkListener(SaveAndLoad newOptions) 
		{
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if (shouldSave)
			{
				options.saveAcquisition();
			}
			else
			{
				options.loadAcquisition();
			}
		}
	}

	class CancelListener implements ActionListener 
	{
		private SaveAndLoad options;

		CancelListener(SaveAndLoad newOptions) 
		{
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if (shouldSave)
			{
				options.cancelSaveAcquisition();
			}
			else
			{
				options.reLaunchOptions();
			}
		}
	}

	class DataPathSelectionListener implements ActionListener 
	{
		private SaveAndLoad options = null;

		DataPathSelectionListener(SaveAndLoad newOptions) 
		{
			options = newOptions;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			options.selectNewDataPath();
		}
	}


	/*******************************************************************************************************
	 * Generated GUI objects
	 *******************************************************************************************************/

	/**
	 * This method initializes saveAndLoadFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getSaveAndLoadFrame()
	{
		if (saveAndLoadFrame == null)
		{
			saveAndLoadFrame = new JFrame();
			saveAndLoadFrame.setSize(new Dimension(403, 209));
			saveAndLoadFrame.setTitle("Enter path and name of saved file");
			saveAndLoadFrame.setLocationRelativeTo(null);
			saveAndLoadFrame.setResizable(false);
			saveAndLoadFrame.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					options.reLaunchOptions();
				}
			});
			saveAndLoadFrame.setContentPane(getSaveAndLoadContentPane());
		}
		return saveAndLoadFrame;
	}

	/**
	 * This method initializes saveAndLoadContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getSaveAndLoadContentPane() 
	{
		if (saveAndLoadContentPane == null)
		{
			saveAndLoadContentPane = new JPanel();
			saveAndLoadContentPane.setLayout(new BoxLayout( getSaveAndLoadContentPane(), BoxLayout.Y_AXIS));
			saveAndLoadContentPane.add(getDataPathPanel(), null);
			saveAndLoadContentPane.add(getOkCancelPanel(), null);
		}
		return saveAndLoadContentPane;
	}

	/**
	 * This method initializes dataPathPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getDataPathPanel()
	{
		if (dataPathPanel == null)
		{
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.NONE;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			dataPathPanel = new JPanel();
			dataPathPanel.setLayout(new GridBagLayout());
			dataPathPanel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.black, 1),
					"Data Path", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), Color.black));
			dataPathPanel.add(getDataPathScrollPane(), gridBagConstraints2);
			dataPathPanel.add(getDataPathButton(), gridBagConstraints3);
		}
		return dataPathPanel;
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
			okCancelPanel.setLayout(new BoxLayout(getOkCancelPanel(), BoxLayout.X_AXIS));
			okCancelPanel.add(getOkPanel(), null);
			okCancelPanel.add(getCancelPanel(), null);
		}
	
		return okCancelPanel;
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
	 * This method initializes okButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getOkButton()
	{
		if (okButton == null)
		{
			okButton = new JButton();
			okButton.setSelected(true);
			okButton.setText("OK");
			okButton.addActionListener(new OkListener(this));
		}
		return okButton;
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
	 * This method initializes cancelButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getCancelButton()
	{
		if( cancelButton == null )
		{
			cancelButton = new JButton();
			cancelButton.setHorizontalAlignment(SwingConstants.RIGHT);
			cancelButton.setText("Cancel");
			cancelButton.addActionListener(new CancelListener(this));
		}
		return cancelButton;
	}

	/**
	 * This method initializes dataPathButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getDataPathButton()
	{
		if (dataPathButton == null)
		{
			dataPathButton = new JButton();
			dataPathButton.setText("...");
			dataPathButton.addActionListener(new DataPathSelectionListener(this));
		}
		return dataPathButton;
	}

	/**
	 * This method initializes dataPathScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getDataPathScrollPane()
	{
		if (dataPathScrollPane == null)
		{
			dataPathScrollPane = new JScrollPane();
			dataPathScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			dataPathScrollPane.setPreferredSize(new Dimension(330, 40));
			dataPathScrollPane.setViewportView(getDataPathTextArea());
		}
		return dataPathScrollPane;
	}

	/**
	 * This method initializes dataPathTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getDataPathTextArea()
	{
		if (dataPathTextArea == null)
		{
			dataPathTextArea = new JTextArea();
			dataPathTextArea.setPreferredSize(new Dimension(200, 70));
			dataPathTextArea.setBounds(new Rectangle(0, 0, 0, 0));
			dataPathTextArea.setWrapStyleWord(true);
			dataPathTextArea.setLineWrap(true);
			dataPathTextArea.setText(System.getProperty("user.dir"));
		}
		return dataPathTextArea;
	}
}
