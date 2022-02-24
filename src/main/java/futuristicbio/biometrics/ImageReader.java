package futuristicbio.biometrics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.jnbis.api.Jnbis;



public class ImageReader {

       public static void main(String[] args) throws ClassNotFoundException, SQLException {
           //find files with wsq extesnsion
        String imageExtension[] = new String[]{ "wsq" };
        File direcory = new File("C:\\Users\\User-PC\\Desktop\\NetbeansProject\\Source code PROMA\\build\\tempfingerprints");
        File[] listFiles = direcory.listFiles();
        ArrayList<File> imageFileList = new ArrayList();
        for(File aFile : listFiles ) {
            // use FilenameUtils.getExtension from Apache Commons IO
            String extension = FilenameUtils.getExtension(aFile.getAbsolutePath());
            for(String ext: imageExtension) {
                if(extension.equals(ext)) {
                    imageFileList.add(aFile);
                    break;
                }
            }
        }
         //loop through the array to copy and store the image path to the db  
  for(File sourceFile : imageFileList){
        String photo="";
        String path="C:\\Users\\User-PC\\Desktop\\NetbeansProject\\Source code PROMA\\build\\tempfingerprints1";
        String fileName="";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn =DriverManager.getConnection("jdbc:mysql://192.168.0.47:3306/permit","root","Root2017*");
        
     if (sourceFile.getAbsolutePath().contains("RIGHT_FORE")){
     
    //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:\\Users\\User-PC\\Desktop\\NetbeansProject\\Source code PROMA\\build\\tempfingerprints1\\right_fore.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
   
   
   //save to db
    String Query1 = "UPDATE efnsbiometrics SET right_fore= '"+photo+"' WHERE applicantId = '1'";
    
  
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
        }
        
     else if(sourceFile.getAbsolutePath().contains("0_ORIGINAL_CAPTURE")){
          //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/right_originalcapture.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
       //save to db  
    String Query1 = "UPDATE efnsbiometrics SET right_originalcapture= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
                
         
     }
      else if(sourceFile.getAbsolutePath().contains("RIGHT_LITTLE")){
          
      //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/right_little.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //save to db
           String Query1 = "UPDATE efnsbiometrics SET right_little= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
           else if(sourceFile.getAbsolutePath().contains("RIGHT_MIDDLE")){
                //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/right_middle.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //save to db
           String Query1 = "UPDATE efnsbiometrics SET right_middle= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
           
     }
          else if(sourceFile.getAbsolutePath().contains("RIGHT_RING")){
               //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/right_ring.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //insert to db
           String Query1 = "UPDATE efnsbiometrics SET right_ring= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
     
      else if(sourceFile.getAbsolutePath().contains("RIGHT_THUMB")){
               //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/right_thumb.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //insert to db
     String Query1 = "UPDATE efnsbiometrics SET right_thumb= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
         else if(sourceFile.getAbsolutePath().contains("LEFT_THUMB")){
               //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/left_thumb.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //insert to db
     String Query1 = "UPDATE efnsbiometrics SET left_thumb= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
     
     
         else if(sourceFile.getAbsolutePath().contains("LEFT_RING")){
               //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/left_ring.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //insert to db
     String Query1 = "UPDATE efnsbiometrics SET left_ring= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
     
         else if(sourceFile.getAbsolutePath().contains("LEFT_MIDDLE")){
               //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/left_middle.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //insert to db
     String Query1 = "UPDATE efnsbiometrics SET left_middle= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
     
     
         else if(sourceFile.getAbsolutePath().contains("LEFT_LITTLE")){
               //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/left_little.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //insert to db
     String Query1 = "UPDATE efnsbiometrics SET left_little= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
     
     
         else if(sourceFile.getAbsolutePath().contains("LEFT_FORE")){
               //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/left_fore.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //insert to db
     String Query1 = "UPDATE efnsbiometrics SET left_fore= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
     
     
         else if(sourceFile.getAbsolutePath().contains("1_ORIGINAL_CAPTURE")){
               //convert to png and insert to folder
   File png = Jnbis.wsq().decode(sourceFile.getPath()).toPng().asFile("C:/Users/Futuristic/Desktop/fingerprints1/left_originalcapture.png");
   fileName=png.getName();
   photo=path+"/"+fileName; 
         //insert to db
     String Query1 ="UPDATE efnsbiometrics SET left_originalcapture= '"+photo+"' WHERE applicantId = '1'";
    Statement st = conn.createStatement();
    st.executeUpdate(Query1);
         
     }
     
       }
       }
       
  
}
