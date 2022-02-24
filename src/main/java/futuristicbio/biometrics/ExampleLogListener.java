package futuristicbio.biometrics;






import com.morpho.mbop.api.LogLevel;
import com.morpho.mbop.api.LogListener;

/**
 * Class implementing the LogListener interface proposed by the MorphoBop
 * library
 */
public class ExampleLogListener implements LogListener {

	/**
	 * Constructor
	 */
	public ExampleLogListener() {
	}

	/**
	 * Redefined LogListener interface function. In this example, the messages
	 * are displayed in the console.
	 * 
	 * @param i__MessageLevel
	 *            Describe the importance of the message.
	 * @param i__Message
	 *            The message itself.
	 */
	public void ShowMessage(LogLevel i__MessageLevel, String i__Message) {
		System.out.println(i__Message);
	}
}
