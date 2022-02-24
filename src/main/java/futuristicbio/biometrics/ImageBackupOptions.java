package futuristicbio.biometrics;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

import com.morpho.mbop.api.*;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;
import org.jnbis.api.Jnbis;

public class ImageBackupOptions {

    /**
     * *****************************************************************************************************
     * GUI objects
     * *****************************************************************************************************
     */
    private JFrame imageBackupOptionsFrame;
    private JPanel imageBackupOptionsContentPane;
    private JPanel dataPathPanel;
    private JPanel okCancelPanel;
    private JPanel okPanel;
    private JButton okButton;
    private Panel cancelPanel;
    private JButton cancelButton;
    private JButton dataPathButton;
    private JScrollPane dataPathScrollPane;
    private JTextArea dataPathTextArea;
    private Acquisition acquisition;
    private ExampleResultFrame exampleFrame;
//        private String printSavelocation;
    private String wsqSaveLocation;
    private String pngSaveLocation;
    private String rawSaveLocation;

    /**
     * Constructor
     *
     * @param newTestResult
     */
    public ImageBackupOptions(ExampleResultFrame newExampleFrame, Acquisition newAcquisition) {
        exampleFrame = newExampleFrame;
        acquisition = newAcquisition;
        getImageBackupOptionsFrame().setVisible(false);

        setNewDataPaths();
    }

    public String getWsqSaveLocation() {
        if (!wsqSaveLocation.endsWith("\\")) {
            return wsqSaveLocation + "\\";
        } else {
            return wsqSaveLocation;
        }
    }

    public String getWsqFolderPath() {

        return wsqSaveLocation;
    }

    public String getPngSaveLocation() {
        if (!pngSaveLocation.endsWith("\\")) {
            pngSaveLocation += "\\";
        }
        return pngSaveLocation;
    }

    public String getRawSaveLocation() {
        if (!rawSaveLocation.endsWith("\\")) {
            rawSaveLocation += "\\";
        }
        return rawSaveLocation;
    }

    /**
     * Close the window
     */
    protected void close() {
        getImageBackupOptionsFrame().dispose();
        exampleFrame.close();
    }

    public void show() {

        saveImages();
        exampleFrame.getMainframe().close1();
//		getImageBackupOptionsFrame().setVisible(true);

    }

    /**
     * Allow to select a new path for saving the images
     */
    public void setNewDataPaths() {

        String path = null;
        try {
            String mypath = ImageBackupOptions.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            java.io.File jar = new java.io.File(decodedPath);
            path = jar.getParent();

            wsqSaveLocation = path.concat("\\fingerprints\\wsq");
            pngSaveLocation = path.concat("\\fingerprints\\png");
            rawSaveLocation = path.concat("\\fingerprints\\raw");

        } catch (java.lang.Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Save all the obtained image in the given data path
     *
     * @param path
     */
    public void saveImages() {
        try {
            getImageBackupOptionsFrame().setVisible(false);

            saveImgResults();
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(getImageBackupOptionsFrame(), "ERROR", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveImgResults() {
        try {
            AcquisitionDescriptor acqDesc = new AcquisitionDescriptor();
            for (BiometricItemType type : BiometricItemType.values()) {
                acqDesc.SetItemActivation(type, true);
            }

            if (acquisition.HasCaptures(acqDesc)) {
                BiometricData[] bioData = acquisition.GetAllCaptures(acqDesc);
                String applicationId = exampleFrame.getApplicantId();

                if (bioData != null) {
                    System.out.println("Saving using applicationId: "+ applicationId);
                    //bioData length is currently set at 3
                    //[0] being right hand
                    //[1] being left hand
                    //[2] being thumb
                    for (int i = 0; i < bioData.length; i++) {
                        if (bioData[i].HasImage()) {
                            com.morpho.mbop.api.Image img = bioData[i].GetImage();
                            String originalCapture;
                                if (i == 0) {
                                    originalCapture = "_RIGHT_CAPTURE";
                                } else if (i == 1) {
                                    originalCapture = "_LEFT_CAPTURE";
                                } else  {
                                    originalCapture = "_THUMB_CAPTURE";
                                }
                            if (img.HasAs(ImageFormat.RAW)) {
                                byte[] data = img.GetPixels();
                                save(getRawSaveLocation() + applicationId + originalCapture+"_"+ img.GetWidth() + "_" + img.GetHeight() + ".raw", data);
                            }
                            if (img.HasAs(ImageFormat.WSQ)) {
                                
                                byte[] data = img.GetAs(ImageFormat.WSQ);
                                String wsqPath = getWsqSaveLocation() + applicationId +originalCapture+ ".wsq";
                                save(wsqPath, data);
//                                convertWsqToPng(wsqPath);

                            }
                        }

                        for (BiometricItemType type : BiometricItemType.values()) {
                            if (bioData[i].HasSegmentedImage(type)) {

                                com.morpho.mbop.api.Image img = bioData[i].GetSegmentedImage(type);
                                if (img.HasAs(ImageFormat.RAW)) {
                                    byte[] data = img.GetPixels();
                                    save(getRawSaveLocation() + applicationId + "_" + type + "_" + img.GetWidth() + "_" + img.GetHeight() + ".raw", data);
                                }
                                if (img.HasAs(ImageFormat.WSQ)) {
                                    byte[] data = img.GetAs(ImageFormat.WSQ);
//										save(getWsqSaveLocation() + i + "_" + type + ".wsq", data);
                                    String wsqPath = getWsqSaveLocation() + applicationId + "_" + type + ".wsq";
                                    save(wsqPath, data);

                                }
//                           
                            }
                        }
                    }
                }
            }
            convertWsqToPng(getWsqFolderPath());
            
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(getImageBackupOptionsFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void convertWsqToPng(String sourceWsqPath) {
        System.out.println("Attempting png conversion using path: " + sourceWsqPath);
        File direcory = new File(sourceWsqPath);
        File[] listFiles = direcory.listFiles();
        ArrayList<File> imageFileList = new ArrayList();
        for (File aFile : listFiles) {
            // use FilenameUtils.getExtension from Apache Commons IO
            String fName = FilenameUtils.getBaseName(aFile.getName()).concat(".png");
            System.out.println("converting " + aFile.getName());
            System.out.println("New File name: " + fName);
            String ouputPath = getPngSaveLocation() + (fName);
            File png = Jnbis.wsq().decode(aFile.getPath()).toPng().asFile(ouputPath);
        }
    }

    /**
     * Save a given image (in .raw format) on the disk
     *
     * @param filename is the name of the image
     * @param data contains the image data
     * @throws IOException
     */
    private void save(String filename, byte[] data) {
        try {
            System.out.println("Writing file " + filename);
            File imageFile = new File(filename);
            OutputStream configStream = new FileOutputStream(imageFile);
            configStream.write(data);
            configStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Couldn't create file " + filename);
        }
    }

    /**
     * *********************************************************************************************************
     * LISTENERS
     * *******************************************************************************************************
     */
    class OkListener implements ActionListener {

        private ImageBackupOptions options;

        OkListener(ImageBackupOptions newOptions) {
            options = newOptions;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            options.close();
            
        }
    }

    class CancelListener implements ActionListener {

        private ImageBackupOptions options = null;

        CancelListener(ImageBackupOptions newOptions) {
            options = newOptions;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            options.close();
        }
    }

    class DataPathSelectionListener implements ActionListener {

        private ImageBackupOptions options = null;

        ;

        DataPathSelectionListener(ImageBackupOptions newOptions) {
            options = newOptions;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
//			options.selectNewDataPath();
        }
    }

    /**
     * *********************************************************************************************************
     * PARAMETERS ACCESS
     * *******************************************************************************************************
     */
//	public String getSelectedDataPath() 
//	{
//            return printSavelocation;
////		return dataPathTextArea.getText();
//	}
    /**
     * *****************************************************************************************************
     * Generated GUI objects
     * *****************************************************************************************************
     */
    /**
     * This method initializes imageBackupOptionsFrame
     *
     * @return javax.swing.JFrame
     */
    private JFrame getImageBackupOptionsFrame() {
        
        
        if (imageBackupOptionsFrame == null) {
            imageBackupOptionsFrame = new JFrame();
            imageBackupOptionsFrame.setSize(new Dimension(403, 145));
            imageBackupOptionsFrame.setTitle("Path For Image Backup");
            imageBackupOptionsFrame.setLocationRelativeTo(null);
            imageBackupOptionsFrame.setResizable(false);
            imageBackupOptionsFrame.setContentPane(getImageBackupOptionsContentPane());
        }

        return imageBackupOptionsFrame;
    }

    /**
     * This method initializes imageBackupOptionsContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getImageBackupOptionsContentPane() {
        if (imageBackupOptionsContentPane == null) {
            imageBackupOptionsContentPane = new JPanel();
            imageBackupOptionsContentPane.setLayout(new BoxLayout(getImageBackupOptionsContentPane(), BoxLayout.Y_AXIS));
            imageBackupOptionsContentPane.add(getDataPathPanel(), null);
            imageBackupOptionsContentPane.add(getOkCancelPanel(), null);
        }
        return imageBackupOptionsContentPane;
    }

    /**
     * This method initializes dataPathPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getDataPathPanel() {
        if (dataPathPanel == null) {
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
    private JPanel getOkCancelPanel() {
        if (okCancelPanel == null) {
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
    private JPanel getOkPanel() {
        if (okPanel == null) {
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
    private JButton getOkButton() {
        if (okButton == null) {
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
    private Panel getCancelPanel() {
        if (cancelPanel == null) {
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
     * This method initializes dataPathButton
     *
     * @return javax.swing.JButton
     */
    private JButton getDataPathButton() {
        if (dataPathButton == null) {
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
    private JScrollPane getDataPathScrollPane() {
        if (dataPathScrollPane == null) {
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
    private JTextArea getDataPathTextArea() {
        if (dataPathTextArea == null) {
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
