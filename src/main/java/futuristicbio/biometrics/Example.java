package futuristicbio.biometrics;

//
//
//
import java.io.*;
import javax.swing.*;

import com.morpho.mbop.api.*;
import com.morpho.mbop.api.Exception;

public class Example 
{
//	// MorphoBop objects
//	private Core			core;
//	private Acquisition		acquisition;
//	private SingleAcquisition	singleAcquisition;
//
//	// Listeners
//	private ExampleAcquisitionStateListener		acquisitionListener;
//	private ExampleDeviceStateListener		deviceListener;
//
//	// Main frame
//	private ExampleMainFrame mainFrame;
//	private SingleAcquisitionFrame				singleAcquisitionFrame;
//
//	// Options frame
//	private Options	options;
//
//	// Booleans used to know if a new acquisition has to be launched or if the program needs to be stopped
//	boolean m__isStopped;
//	boolean m__launchNewAcquisition = true;
//
//	// Function called when the Core object is being deleted
//	public void DisconnectCore() 
//	{
//		core.UnregisterDeviceStateListener( deviceListener );
//		core = null;
//	}
//
//	// Function called when the Acquisition object is being deleted
//	public void DisconnectAcquisition() 
//	{
//		acquisition.UnregisterAcquisitionStateListener( acquisitionListener );
//		acquisition = null;
//	}
//
//	// Main function
//	public void Run() 
//	{
//           
//          
//		try 
//		{
//			// Get the configuration file
//			byte[] configData = readLocalFile((new java.io.File(com.morpho.mbop.api.Loader.getPath(), "MorphoBOP_Config.dat")).getPath());
//
//			// Initialize Core object
//			ExampleLogListener logListener = new ExampleLogListener();
//			core = new Core( logListener, LogLevel.INFORMATION, configData );
//
//            // Register a device listener in order to know when a device is connected or disconnected
//            deviceListener = new ExampleDeviceStateListener(this);
//            core.RegisterDeviceStateListener(deviceListener);
//
//			// While it is not asked to stop
//			while (!m__isStopped) 
//			{
//
//				// If a new acquisition needs to be launched
//				if (m__launchNewAcquisition) 
//				{
//					m__launchNewAcquisition = false;
//
//					// Get the list of connected devices
//					String[] devices = core.GetDevicesList();
//                        
//					int res = JOptionPane.YES_OPTION;
//					
//					while((devices == null || devices.length == 0) && res == JOptionPane.YES_OPTION)
//					{
//						Object[] retryCancel = {"Retry", "Cancel"};
//						res = JOptionPane.showOptionDialog(null, "There is no connected device. Please plug a device and retry.", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, retryCancel, retryCancel[0]);
//						if(res != JOptionPane.YES_OPTION)
//	                    {
//	                        stopExample();
//	                        break;
//	                    }
//						devices = core.GetDevicesList();
//					} 
//					
//					if(devices != null && devices.length > 0)
//					{
//
//						// The options frame is launched
//                        if (options == null) 
//                        {
//                         
//                            options = new Options(this, devices);
//                            options.startAcquisition();
//                           
//                        } 
//                        else 
//                        {
//                            System.out.println("Displaying options");
//                            options.display();
//                        }
//					}
//				} 
//				else 
//				{
//					Thread.sleep(300);
//				}
//			}
//		} 
//		catch (com.morpho.mbop.api.InvalidOrMissingLicenseException e) 
//		{
//			JOptionPane.showMessageDialog( null, "Invalid license", "Error", JOptionPane.ERROR_MESSAGE, null );
//			stopExample();
//		} 
//		catch (java.lang.Exception e) 
//		{
//			JOptionPane.showMessageDialog( null, "Exception caught (" + e.getClass().toString() + ") : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null );
//			stopExample();
//		}
//	}
//
//	public void reLaunchOptions() 
//	{
//		if (core != null && acquisition != null) 
//		{
//			try 
//			{
//				acquisition.Close();
//			} 
//			catch (Exception e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			acquisition = null;
//		}
//		
//		if( core != null && singleAcquisition != null ) 
//		{
//			try 
//			{
//				singleAcquisition.close();
//			} 
//			catch (java.lang.Exception e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			singleAcquisition = null;
//		}
//		m__launchNewAcquisition = true;
//	}
//
//	/**
//	 * Start a new acquisition with the parameters values obtained in the
//	 * options frame
//	 * 
//	 * @throws Exception
//	 *             An error during the acquisition
//	 */
//	public void startAcquisition() 
//	{
//            
//            
//               System.out.println("retrying second acquisition");
//		try 
//		{
//
//			// Set the parameters values obtained in the options frame
//			String selectedDevice = options.getSelectedDevice();
//
//			core.SetParameter( "sensor." + selectedDevice + ".ui.buzzer", "DISABLED" );
//			core.SetParameter( "sensor." + selectedDevice + ".capture.mode", "AUTO" );
//			core.SetParameter( "sensor." + selectedDevice + ".capture.resolution", "500" );
//            if (core.GetParameter( "sensor." + selectedDevice + ".capture.has_live").equals("1"))
//            {
//                core.SetParameter( "sensor." + selectedDevice + ".live.resolution", "125");
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Live is not supported on that device", "Warning", JOptionPane.WARNING_MESSAGE, null);
//            }
//			core.SetParameter( "output.thumbnail.resolution",		"125"			);
//            core.SetParameter( "output.image.iso_compression_type",		"ISO_COMPRESSION_LOSSY"		);
//			core.SetParameter( "system.threading.max_overall",	options.getMaxThreadValue()							);
//			core.SetParameter( "system.threading.max_background",	options.getBackgroundThreadValue()					);
//			core.SetParameter( "system.threading.image.capture.compression.enable",	options.getCompressCaptureValue()					);
//			core.SetParameter( "system.threading.image.segmented.compression.enable",options.getCompressSegmentedValue()					);
//			core.SetParameter( "system.auto_continue",		"1"				);
//			core.SetParameter( "system.auto_recapture",		"0"			);
//            core.SetParameter( "system.auto_validation",			"1"			);
//            core.SetParameter( "system.exception_auto_validation",	"1"	);
//			core.SetParameter( "control.speed_vs_quality",	options.getSelectedSpeedVsQualityValue()			);
//			core.SetParameter( "control.fte_vs_quality",	options.getSelectedFTEVsQualityValue()				);
//            core.SetParameter( "control.fte_vs_quality.damaged_items",	options.getSelectedFTEVsQualityDamagedValue()		);
//			core.SetParameter( "control.bypass.mode",	"MANUAL"			);
//			core.SetParameter( "control.bypass.threshold.manual",	"3"		);
//			core.SetParameter( "control.bypass.threshold.auto",	"5"	);
//			core.SetParameter( "control.constraint.mode",		options.getSelectedConstraintValue()	);
//			core.SetParameter( "system.toggle.mode",		options.getSelectedToggleValue()					);
//
//            if( options.getSelectedConsoEnabledValue() == "1" ) 
//            {
//                if( selectedDevice.contains("MSO") ) 
//                {
//                    core.SetParameter( "system.consolidation.one_finger.enabled", "1" );
//                } 
//                else 
//                {
//                    core.SetParameter( "system.consolidation.palm.enabled", "1" );
//                }
//                
//                core.SetParameter( "system.consolidation.auto_continue",	options.getSelectedConsoAutoContinueValue()	);
//                core.SetParameter( "system.consolidation.subimages.nb_min",	options.getSelectedConsoMinValue()	);
//                core.SetParameter( "system.consolidation.subimages.nb_max",	options.getSelectedConsoMaxValue()	);
//            } 
//            else 
//            {
//                core.SetParameter( "system.consolidation.one_finger.enabled",	"0"	);
//                core.SetParameter( "system.consolidation.palm.enabled",		"0");
//            }
//
//            System.out.println("acquisition preparation");
//			// Creates a new descriptor corresponding to the items that have to be acquired
//			AcquisitionDescriptor acqDesc = new AcquisitionDescriptor( options.getSelectedAcquisitionType() );
//            
//			// Creates the corresponding acquisition
//			acquisition = core.CreateAcquisition( acqDesc, selectedDevice );
//
//			// Add a listener in order to know when the acquisition is complete (when it is the case, the result window is created)
//			acquisitionListener = new ExampleAcquisitionStateListener(acquisition);
//			acquisition.RegisterAcquisitionStateListener(acquisitionListener);
//
//			// Create the window which allows starting the acquisition
//			mainFrame = new ExampleMainFrame(this, core);
//			mainFrame.Connect(acquisition);
//			mainFrame.setVisible(true);
//                               
//		} 
//		catch (java.lang.Exception e) 
//		{
//			JOptionPane.showMessageDialog( null, "Exception caught (" + e.getClass().toString() + ") : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null );
//			m__launchNewAcquisition = true;
//		}
//	}
//
//  /**
//	 * Start a new single acquisition with the parameters values obtained in the
//	 * options frame
//	 * 
//	 * @throws Exception
//	 *             An error during the acquisition
//	 */
//	public void startSingleAcquisition()
//	{
//		try
//		{
//
//			// Set the parameters values obtained in the options frame
//			String selectedDevice = options.getSelectedDevice();
//
//			
//			core.SetParameter("sensor." + selectedDevice + ".ui.buzzer", options.getSelectedSoundActivationValue());
//			core.SetParameter("sensor." + selectedDevice + ".capture.mode", options.getSelectedCaptureType());
//			core.SetParameter("sensor." + selectedDevice + ".capture.resolution", 	options.getSelectedResolution());
//			if (core.GetParameter("sensor." + selectedDevice + ".capture.has_live").equals("1"))
//			{
//				core.SetParameter("sensor." + selectedDevice + ".live.resolution", options.getSelectedLiveResolution());
//			}
//			else
//			{
//				JOptionPane.showMessageDialog( null, "Live is not supported on that device", "Warning", JOptionPane.WARNING_MESSAGE, null );
//			}
//			core.SetParameter("output.thumbnail.resolution", options.getSelectedThumbnailResolution());
//			core.SetParameter("output.image.iso_compression_type", options.getSelectedISOCompressionType());
//			core.SetParameter("system.threading.max_overall", options.getMaxThreadValue());
//			core.SetParameter("system.threading.max_background", options.getBackgroundThreadValue());
//			core.SetParameter("system.threading.image.capture.compression.enable", options.getCompressCaptureValue());
//			core.SetParameter("system.threading.image.segmented.compression.enable", options.getCompressSegmentedValue());
//			
//			//core.SetParameter("control.speed_vs_quality", options
//			//		.getSelectedSpeedVsQualityValue());
//			core.SetParameter("control.speed_vs_quality", "INTERMEDIATE"); // FAVOR_QUALITY is forbidden
//			core.SetParameter("control.fte_vs_quality", options.getSelectedFTEVsQualityValue());			
//
//			// Create the corresponding acquisition
//			singleAcquisition = core.CreateSingleAcquisition(selectedDevice);
//
//			// Create the window which allows starting the acquisition
//			singleAcquisitionFrame = new SingleAcquisitionFrame(this, core);
//			singleAcquisitionFrame.Connect(singleAcquisition);
//			singleAcquisitionFrame.setVisible(true);
//
//		}
//		catch (java.lang.Exception e)
//		{
//			JOptionPane.showMessageDialog(null, "Exception caught : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
//			m__launchNewAcquisition = true;
//		}
//	}
//
//	/**
//	 * Load a saved acquisition
//	 * 
//	 * @throws Exception
//	 *             An error during the acquisition
//	 */
//	public void loadAcquisition()
//	{
//		try
//		{
//			// Keep some parameters
//			String selectedDevice = options.getSelectedDevice();
//
//			core.SetParameter( "sensor." + selectedDevice + ".ui.buzzer",		options.getSelectedSoundActivationValue() );
//			core.SetParameter( "sensor." + selectedDevice + ".capture.mode",	options.getSelectedCaptureType() );
//			
//            if( core.GetParameter( "sensor." + selectedDevice + ".capture.has_live").equals("1") )
//            {
//                core.SetParameter( "sensor." + selectedDevice + ".live.resolution", options.getSelectedLiveResolution() );
//            }
//            else
//            {
//                JOptionPane.showMessageDialog( null, "Live is not supported on that device", "Warning", JOptionPane.WARNING_MESSAGE, null );
//            }
//			core.SetParameter("output.thumbnail.resolution",							options.getSelectedThumbnailResolution()			);
//            core.SetParameter("output.image.iso_compression_type",						options.getSelectedISOCompressionType()				);
//			core.SetParameter("system.threading.max_overall",							options.getMaxThreadValue()							);
//			core.SetParameter("system.threading.max_background",						options.getBackgroundThreadValue()					);
//			core.SetParameter("system.threading.image.capture.compression.enable",		options.getCompressCaptureValue()					);
//			core.SetParameter("system.threading.image.segmented.compression.enable",	options.getCompressSegmentedValue()					);
//			core.SetParameter("control.bypass.mode",									options.getSelectedAutoBypassValue()				);
//			core.SetParameter("system.auto_continue",									options.getSelectedAutoContinueValue()				);
//			core.SetParameter("system.auto_recapture",									options.getSelectedAutoRecaptureValue()				);
//            core.SetParameter("system.auto_validation",									options.getSelectedAutoValidationValue()			);
//            core.SetParameter("system.exception_auto_validation",						options.getSelectedExceptionsAutoValidationValue()	);
//            core.SetParameter("system.consolidation.auto_continue",						options.getSelectedConsoAutoContinueValue()			);
//            core.SetParameter("system.consolidation.subimages.nb_min",					options.getSelectedConsoMinValue()					);
//            core.SetParameter("system.consolidation.subimages.nb_max",					options.getSelectedConsoMaxValue()					);
//
//			// Get save file
//			String fileName = options.getSaveFile();
//			RandomAccessFile f = new RandomAccessFile(fileName, "r");
//			byte[] array = new byte[(int)f.length()];
//			f.read(array);
//			f.close();
//
//			// Create the corresponding acquisition
//			acquisition = core.RestoreAcquisition(array, selectedDevice);
//
//			// Add a listener in order to know when the acquisition is
//			// complete (when it is the case, the result window is created)
//			acquisitionListener = new ExampleAcquisitionStateListener(acquisition);
//			acquisition.RegisterAcquisitionStateListener(acquisitionListener);
//
//			// Create the window which allows starting the acquisition
//			mainFrame = new ExampleMainFrame(this, core);
//			mainFrame.Connect(acquisition);
//			mainFrame.setVisible(true);
//
//		} 
//		catch (java.lang.Exception e) 
//		{
//			JOptionPane.showMessageDialog( null, "Exception caught : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null );
//			m__launchNewAcquisition = true;
//		}
//	}
//
//	/**
//	 * Stops the test program
//	 */
//	public void stopExample() 
//	{
//
//		// Delete the frames
//		if (mainFrame != null) 
//		{
//			mainFrame.dispose();
//			mainFrame = null;
//		}
//
//		// Delete the frames
//		if (singleAcquisitionFrame != null)
//		{
//			singleAcquisitionFrame.dispose();
//			singleAcquisitionFrame = null;
//		}
//
//		if (options != null) 
//		{
//			options = null;
//		}
//
//		try 
//		{
//			// Close the Core object
//			if (core != null) 
//			{
//				core.Close();
//				core = null;
//			}
//		} 
//		catch (Exception e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		m__isStopped = true;
//	}
//
//	/**
//	 * Read the given file and get a byte array containing all its data
//	 * 
//	 * @param filename
//	 * @return
//	 * @throws IOException
//	 */
//	private byte[] readLocalFile(String filename) throws IOException 
//	{
//		File configFile = new File(filename);
//		InputStream configStream = new FileInputStream(configFile);
//		byte[] data = new byte[(int) configFile.length()];
//		int offset = 0;
//		int numRead = 0;
//		while (offset < data.length && (numRead = configStream.read(data, offset, data.length- offset)) >= 0) 
//		{
//			offset += numRead;
//		}
//		
//		try
//		{
//			if (offset < data.length) 
//			{
//				throw new IOException("Could not completely read file " + configFile.getName());
//			}
//		}
//		finally
//		{
//			configStream.close();
//		}
//		
//		return data;
//	}
}
