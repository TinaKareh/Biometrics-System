package futuristicbio.biometrics;





import com.morpho.mbop.api.*;

/**
 * Listener called whenever the acquisition state changes.
 */
public class ExampleAcquisitionStateListener implements AcquisitionStateListener 
{
	private ExampleResultFrame resFrame;
        private String applicantId;
        private ExampleMainFrame mainFrame;

    public void setMainFrame(ExampleMainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    

        
	/**
	 * Constructor
	 */
	public ExampleAcquisitionStateListener( Acquisition newAcquisition, String applicantId ) 
	{
            
            this.applicantId = applicantId;
		resFrame = new ExampleResultFrame();
                resFrame.setApplicantId(applicantId);
		resFrame.Connect(newAcquisition);
	}

        public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantId() {
        return applicantId;
    }
	public void StateChanged( AcquisitionState i__State ) 
	{
            
            
		// When the acquisition is complete, the result window is created
		if( i__State == AcquisitionState.COMPLETED ) 
		{
                    System.out.println("Acquisition complete!"); 
			// Show the window which contains the image results
			resFrame.showImageResult();
			resFrame.setAlwaysOnTop(true);
                        resFrame.setMainframe(mainFrame);
			resFrame.setVisible(true);
		}
	}

	// This function is called when the acquisition object is being deleted
	public void Closing() 
	{
		resFrame.Disconnect();
	}
}
