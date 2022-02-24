/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
 import org.apache.commons.codec.binary.Base64;  

/**
 *
 * @author Futuristic Ltd
 */
public class BiostarAPI {
    
    private static HttpURLConnection con;
    private String applicantId;
    
    
     public void setApplicantId(String applicantId) {
      this.applicantId = applicantId;
      System.out.println(applicantId);
    }
     
     public String getApplicantId() {
        return applicantId;
    }
     
     
     public  void validateUser() throws KeyManagementException, NoSuchAlgorithmException, MalformedURLException, IOException{
         /* Start of Fix */
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }

        } };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        
        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) { return true; }
        };
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        /* End of the fix*/
   
            URL myurl = new URL("https://192.168.200.2:456/api/login");
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setDoOutput(true);
            con.connect();
             String jsonInputString="{\"User\":{\"login_id\":\"admin\",\"password\":\"Root@2021*#\"}}";
        
             try(OutputStream os= con.getOutputStream()){
            byte[] postData = jsonInputString.getBytes("utf-8");
             os.write(postData, 0, postData.length);
                  }
             
             Map<String, List<String>> map = con.getHeaderFields();

	System.out.println("Printing Response Header...\n");

	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		System.out.println("Key : " + entry.getKey() 
                           + " ,Value : " + entry.getValue());
	}

	System.out.println("\nGet Response Header By Key ...\n");
	String session_id = con.getHeaderField("bs-session-id");
            
        if (session_id == null) {
		System.out.println("Key 'bs-session-id' is not found!");
	} else {
	}
	
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder results = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            results.append(line);
        }
            
            //GET Request
            String url = "https://192.168.200.2:456/api/devices/543716115/credentials/face?pose_sensitivity=4";

        try {

            URL murl = new URL(url);
            con = (HttpURLConnection) murl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("bs-session-id", session_id);
             

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String responseLine;
                StringBuilder content = new StringBuilder();

                while ((responseLine = in.readLine()) != null) {

                    content.append(responseLine);
                    
                }
                String rawPhoto = content.toString();
         JSONObject obj = new JSONObject(rawPhoto);
         JSONObject credentials = obj.getJSONObject("credentials");
        JSONArray arr = credentials.getJSONArray("faces");

        String post_id = null;
        for (int i = 0; i < arr.length(); i++) {
           post_id = arr.getJSONObject(i).getString("template_ex_normalized_image");
        }
                    System.out.println(post_id);



       String filename = "_IMG_001.JPG";
       String image = applicantId.toString().concat(filename);
        //convert base64 string to binary data
        byte[] data = convertToImg(post_id);
        String path = "C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\photos\\"+ applicantId.toString().concat(filename);
        writeByteToImageFile(data, path); 
        //File directory = new File("C:\\Users\\Futuristic Ltd\\OneDrive\\Documents\\NetBeansProjects\\kaa-biometrics\\IDMSBiometrics\\IDMSBiometrics\\target\\suprema_photos");
        
            } catch (IOException ex) {
            
            Logger.getLogger(BiostarAPI.class.getName()).log(Level.SEVERE, null, ex);
        }finally {

            con.disconnect();
        }
        
     }
      public static byte[] convertToImg(String base64) throws IOException  
      {  
           return Base64.decodeBase64(base64);  
      } 
      
          public static void writeByteToImageFile(byte[] imgBytes, String imgFileName) throws IOException  
      {  

           File imgFile = new File(imgFileName);  
           BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));  
           ImageIO.write(img, "JPG", imgFile);
           
          
                  }  
     
    
}
