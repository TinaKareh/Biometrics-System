/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Futuristic Ltd
 */
public class Background {
    
       private File inputFile = null;
	BufferedImage img = null; 
	
	public Background() throws IOException
	{
	    
		this.inputFile = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\suprema_photos\\270385photo.png");
		if(this.inputFile.exists() == false)
		{
			throw new IOException(" File does not exist");
		}
		
		// Check if we can understand the image
		if(this.containsUseableImage() == false)
		{
			return;
		}
		
		// Read the image
		this.img = ImageIO.read(this.inputFile);
	}
	
		
	/**
    * Make provided image transparent wherever color matches the provided color.
    *
    * @param im BufferedImage whose color will be made transparent.
    * @param color Color in provided image which will be made transparent.
    * @return Image with transparency applied.
    */
   public BufferedImage getColorTransparentImage()
   {
	   Color leftTopColor = new Color(this.img.getRGB(0, 0));
	   ImageFilter filter = new SimilarColorFilter(leftTopColor, 0.5, 0.2, 0.06);
	   //														  ^    ^    ^
	   //														  |    |    |
	   // 										 	 Hue  --------+    |    |
	   // 											 Saturation -------+    |
	   // 			 								 Value -----------------+
	   
	   // Apply the filter
	   final ImageProducer ip = new FilteredImageSource(this.img.getSource(), filter);
	   Image transparentImage = Toolkit.getDefaultToolkit().createImage(ip);
	  
	   // Convert to Buffered Image
	   final BufferedImage bufferedImage =  new BufferedImage(transparentImage.getWidth(null), transparentImage.getHeight(null),BufferedImage.TYPE_INT_ARGB);
	   final Graphics2D g2d = bufferedImage.createGraphics();
           //g2d.setComposite(AlphaComposite.Clear);
	   g2d.drawImage(transparentImage, 0, 0, null);
           //g2d.setComposite(AlphaComposite.Clear);
	   g2d.dispose();
	   return bufferedImage;
   }
	
   /**
    * Makes the background of the qaf transparent and saves it under the given name
    * @param outputFileName
    * @return 
    * @throws IOException 
    */
   	public void saveAsTransparentPng() throws IOException
   	{
   		if(this.img == null)
   		{
   			throw new IllegalStateException("File can not be converted.");
   		}
   		
	    BufferedImage bi = getColorTransparentImage();
	    File out = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\suprema_photos\\photo.png");
	    ImageIO.write(bi, "PNG", out);
   	}
   
	/**
	 * Checks if the given image can be precessed
	 * @return
	 */
	public boolean containsUseableImage()
	{
		return (this.getImageFormat().equalsIgnoreCase("unknown") == false);
	}
	
	/**
	 * Determines the image type of the qaf. 
	 * If the image type could not be understood then it returns "unknown"
	 * @param inputFileName
	 * @return
	 * @throws IOException 
	 */
	public String getImageFormat()
	{
		try(ImageInputStream iis = ImageIO.createImageInputStream(this.inputFile))
		{
			Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);
			while (imageReaders.hasNext()) 
			{
			    ImageReader reader = (ImageReader) imageReaders.next();
			    return reader.getFormatName();
			}
			return "unknown";
		}
		catch (IOException e) 
		{
			return "unknown";
		}
	}
	
	/**
	 * Info about the qaf file
	 */
	public String toString()
	{
		String size = "";
		if(this.img != null)
		{
			size = " - " + this.img.getWidth() + "x" + this.img.getWidth();
		}
		return inputFile.toString() + " [" + this.getImageFormat() + size + "]";
	}
	
	/**
	 * Filter for making ??ixels with the same color transparent
	 * @author gue
	 */
	private class SimilarColorFilter extends RGBImageFilter
	{
		Double delta_hue;
		Double delta_saturation;
		Double delta_brightness;
		
		float thue;
		float tsaturation;
		float tbrightness;
		
		public SimilarColorFilter(Color color, Double delta_hue, Double delta_saturation, Double delta_brightness)
		{
			this.delta_hue = delta_hue;
			this.delta_saturation = delta_saturation;
			this.delta_brightness = delta_brightness;
			
			// Convert to HSV
		    int r,g,b;
		    r = color.getRed();
		    g = color.getGreen();
		    b = color.getBlue();
		    
		    float[] hsv = new float[3];
		    Color.RGBtoHSB(r,g,b,hsv);
		    
		    // Remember the current parameters
		    this.thue = hsv[0];
		    this.tsaturation = hsv[1];
		    this.tbrightness = hsv[2];
		}
		
		@Override
		public int filterRGB(int x, int y, int rgb)
		{
			Color cpix = new Color(rgb);
			float[] hsv = new float[3];
		    Color.RGBtoHSB(cpix.getRed(),cpix.getGreen(),cpix.getBlue(), hsv);
		    
			float phue = hsv[0];
			float psaturation = hsv[1];
			float pbrightness = hsv[2];
			
			if (isInTolerance(phue, this.thue, this.delta_hue) && 
				isInTolerance(psaturation, this.tsaturation, this.delta_saturation) && 
				isInTolerance(pbrightness, this.tbrightness, this.delta_brightness))
			{
				// Mark the alpha bits as zero - transparent
				return 0x00FFFFFF & rgb;
			}
			else
			{
				// nothing to do
				return rgb;
			}
		}
		
		/**
		 * Liefert true wenn der aktuelle Wert und der Zielwert nciht 
		 * weiter als max_delta voneinander entfernt sind.
		 * 
		 * Wenn max_delta == null dann liefert der Check immer true zur??ck.
		 * 
		 * @param actual_value  
		 * @param target_value 
		 * @param max_delta max allowed delta, or null (which means: ignore)
		 * @return
		 */
		public boolean isInTolerance(double actual_value, double target_value, Double max_delta)
		{
			// Wenn null dann wird dieser Wert nicht ber??cksichtigt und der Check ist autom. erfolgreich
			if(max_delta == null)
			{
				return true;
			}
			
			double low = Math.min(actual_value, target_value);
			double high = Math.max(actual_value, target_value);
			
			return (high-low) <= max_delta;
			
		}
	}
}
