package futuristicbio.biometrics;

//uploads the images to the server 



import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
/**
 * 
 * @author javagists.com
 *
 */
public class UploadToServer {
 
 public static void main(String[] args) throws Exception {
 
  JSch jsch = new JSch();
        Session session = null;
        
        try {
             session = jsch.getSession("administrator", "192.168.200.4", 22);
        } catch (JSchException e) {
            System.out.println("Issue getting session.");
            e.printStackTrace();
        }
        
         try {
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("kaa@2021*");
            session.connect(); // do you need to set properties first?
        } catch (JSchException e) {
            System.out.println("Issue connecting to session.");
            e.printStackTrace();
        }
         
         try {
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
             sftpChannel.exit();
        } catch (JSchException e) {
            System.out.println("Issue connecting to session.");
            e.printStackTrace();
        }
         
         session.disconnect(); /*try {
     session = jsch.getSession("administrator", "192.168.200.4", 22);
     session.setConfig("StrictHostKeyChecking", "no");
     session.setPassword("kaa@2021*");
     session.connect();
     Channel channel = session.openChannel("sftp");
     channel.connect();
     ChannelSftp sftpChannel = (ChannelSftp) channel;
     /*File directory = new File("C:/Users/Futuristic/Desktop/fingerprints1");
     File[] fList = directory.listFiles();
     for (File file : fList){
     if (file.isFile()){
     //String filename=file.getAbsolutePath();
     sftpChannel.put(file.getAbsolutePath(),  "/home/administrator/"+file.getName());
     // System.out.println(filename + " transferred to " + sftpDirectory );
     }
     //sftpChannel.put("C:/Users/Futuristic/Desktop/fingerprints1/right_fore.png", "/home/administrator/uploadnow.png");
     }
     sftpChannel.exit();
     session.disconnect();
     }
     catch (JSchException e) {
     e.printStackTrace();
     }*/
 
 }
 
} 
    


