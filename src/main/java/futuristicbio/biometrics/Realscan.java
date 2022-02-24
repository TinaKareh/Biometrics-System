/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

//import static futuristicbio.biometrics.BiostarAPI.validateUser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Futuristic Ltd
 */
public class Realscan {
    
    public RealscanG_Fingerprints realscan;
    public  void getFingerprints(RealscanG_Fingerprints realscan) throws IOException{
        this.realscan = realscan;
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start \"\"", "demo_run.bat");
            File dir = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics");
            pb.directory(dir);
            Process p = pb.start();

            // wait 10 seconds
            System.out.println("Waiting...");
            System.out.println(p.isAlive());

            
     
            Thread.sleep(220000);
            realscan.displayfingerprints();
            /*Thread.sleep(48000);
            for(int i=0;i<=18;i++){
                Thread.sleep(9000);
                File directory = new File(clientPngPath);//local directory location
                System.out.println("Display Fingerprints");
                System.out.println(directory.list().length);
                if(directory.list().length > 0){
                    displayfingerprints();
                }

            }*/
          
        } catch (IOException ex) {
            Logger.getLogger(Realscan_Fingerprints.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Realscan_Fingerprints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
