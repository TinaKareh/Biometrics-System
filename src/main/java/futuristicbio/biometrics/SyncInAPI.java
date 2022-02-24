/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.json.JSONObject;

/**
 *
 * @author Futuristic Ltd
 */
public class SyncInAPI {
    
        private static HttpURLConnection con;
        
   public static void main(String[] args) throws IOException {
        syncData();
        //Background back = new Background();
        //back.saveAsTransparentPng();
    }

    
    public static void syncData() throws IOException{
    
        //String filename = "photo.png";
       //String image = applicantId.toString().concat(filename);
             File input = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\suprema_photos\\270385photo.png");
              BufferedImage image2 = ImageIO.read(input);
              //final int color = image2.getRGB(0, 0);
        Color leftTopColor = new Color(image2.getRGB(0, 0));
        
      final Image imageWithTransparency = makeColorTransparent(image2, leftTopColor,10);
            String path = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\suprema_photos\\photo.png";

      final BufferedImage transparentImage = imageToBufferedImage(imageWithTransparency);
             
      ImageIO.write(transparentImage, "png", new File(path)) ;
               
           
    }
    private static BufferedImage imageToBufferedImage(final Image image){
    
        BufferedImage background = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
   
                Graphics2D g = background.createGraphics();
                  //g.setBackground(Color.WHITE);
                  //g.fillRect(0, 0, background.getWidth(), background.getHeight());
                  g.drawImage(image, 0, 0, null);
                  g.dispose();
                         
            
            return background;
    }
    
    public static Image makeColorTransparent(final BufferedImage im, final Color color,int tolerance)
   {
        int temp = 0;

    if (tolerance < 0 || tolerance > 100) {

        System.err.println("The tolerance is a percentage, so the value has to be between 0 and 100.");

        temp = 0;

    } else {

        temp = tolerance * (0xFF000000 | 0xFF000000) / 100;

    }

    final int toleranceRGB = Math.abs(temp);
      final ImageFilter filter = new RGBImageFilter()
      {
         
        public int markerRGBFrom = (color.getRGB() | 0xFF000000) - toleranceRGB;

        public int markerRGBTo = (color.getRGB() | 0xFF000000) + toleranceRGB;

          @Override
         public final int filterRGB(final int x, final int y, final int rgb)
         {
            if ((rgb | 0xFF000000) >= markerRGBFrom && (rgb | 0xFF000000) <= markerRGBTo) {

                // Mark the alpha bits as zero - transparent

                return 0x00FFFFFF & rgb;

            } else {

                // Nothing to do

                return rgb;

            }

         }
         
      };
final ImageProducer ip;
       ip = new FilteredImageSource(im.getSource(), filter);
      return Toolkit.getDefaultToolkit().createImage(ip);
   }

    
    
   
}
