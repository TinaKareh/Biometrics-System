/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import com.github.sarxos.webcam.Webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Futuristic Ltd
 */
public class WebCamAPI {
    public static void main(String[] args) throws IOException{
     captureImage();
    }
    
    public static void captureImage() throws IOException{
    // get default webcam and open it
		Webcam webcam = Webcam.getDefault();
                
                if (webcam != null) {
			System.out.println("Webcam: " + webcam.getName());
		} else {
			System.out.println("No webcam detected");
		}
		webcam.open();

		// get image
		BufferedImage image = webcam.getImage();

		// save image to PNG file
		ImageIO.write(image, "PNG", new File("test.png"));
    }
}
