package futuristicbio.biometrics;






import com.morpho.mbop.api.DeviceState;
import com.morpho.mbop.api.DeviceStateListener;

import javax.swing.JOptionPane;

/**
 * Listener called whenever a device is connected or disconnected
 * 
 */
public class ExampleDeviceStateListener implements DeviceStateListener {

        private OptionsFrame oframe = null;

//	/**
//	 * Constructor
//	 */

        public ExampleDeviceStateListener(OptionsFrame frame){
        oframe = frame;
        }

	/**
	 * Redefined DeviceStateListener interface function. In this example, the
	 * status of the device is displayed in the console.
	 * 
	 * @param i__DeviceID
	 *            Is the ID of the concerned device
	 * @param i__DeviceState
	 *            Is its new state.
	 */
	public void StateChanged(String i__DeviceID, DeviceState i__DeviceState) {
        switch (i__DeviceState)
        {
            case DIRTY:
                JOptionPane.showMessageDialog(null, "Device has been detected as dirty. We recommand you to clean it.", "Device dirty", JOptionPane.WARNING_MESSAGE, null);
                break;
			case GLASS_SCRATCHED:
				JOptionPane.showMessageDialog(null, "Device glass/prism/pad is scratched.", "Device glass scratched", JOptionPane.WARNING_MESSAGE, null);
				break;
			case TEMPERATURE_HIGH:
				JOptionPane.showMessageDialog(null, "Device temperature is high.", "Device temperature high", JOptionPane.WARNING_MESSAGE, null);
				break;
			case TEMPERATURE_TOO_HIGH:
				JOptionPane.showMessageDialog(null, "Device temperature is too high.", "Device temperature too high", JOptionPane.WARNING_MESSAGE, null);
				break;
            default:
                break;
        }
		System.out.println("Device " + i__DeviceID + " state changed -> "
				+ i__DeviceState);
	}

	/**
	 * This function is called when the core object is being deleted
	 */
	public void Closing() {
		oframe.DisconnectCore();
	}
}
