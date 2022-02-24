/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Futuristic Ltd
 */
public class SyncOutAPI{
    
        private static HttpURLConnection con;
       

        
   public static void main(String[] args) throws IOException, MalformedURLException, SQLException, URISyntaxException {
        mirrorText();
    }
   
            public static void mirrorText(){
                  
                  String word = "Ram Is A Good Boy";
                  String mirrored = reverseWord(word, word.length());
                  String str1 =mirrored.replaceFirst(word, "");
       
                  System.out.println(str1);

}
            
    public static String reverseWord(String word, int length) {
    if(length == 0)
        return word;
    else
        return reverseWord(word +word.charAt(length - 1), length - 1);
}
        
        public static void syncData() throws MalformedURLException, IOException, SQLException, URISyntaxException{
            
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement statement = null;

            
        URI myurl = new URI("https://futuristickaadev.com//mwclient//index.php?type=icomplete");
        
            
            conn = DBConnect.ConnecrDb();
            
            JSONObject jsonObject = new JSONObject();
            JSONArray array = new JSONArray();
            
            String query = "SELECT * FROM permitbiometrics PB INNER JOIN local_biocapture_manager LB on PB.applicantId =LB.applicant_id WHERE LB.bio_sync_receipt_status = 0 AND LB.bio_capture_status = 1 AND LB.region_id = 1 AND LB.airport_airstrip_id = 2";
            

         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         Statement stmt = conn.createStatement();
         rs = stmt.executeQuery(query);

            while(rs.next()) {
             JSONObject record = new JSONObject();
             //Inserting key-value pairs into the json object
             record.put("ID", rs.getInt("id"));
             record.put("applicant_id", rs.getInt("applicantId"));
             record.put("right_fore", rs.getString("right_fore"));
             record.put("right_originalcapture", rs.getString("right_originalcapture"));
             record.put("right_little", rs.getString("right_little"));
             record.put("right_middle", rs.getString("right_middle"));
             record.put("right_ring", rs.getString("right_ring"));
             record.put("right_thumb", rs.getString("right_thumb"));
             record.put("left_fore", rs.getString("left_fore"));
             record.put("left_little", rs.getString("left_little"));
             record.put("left_middle", rs.getString("left_middle"));
             record.put("left_ring", rs.getString("left_ring"));
             record.put("left_thumb", rs.getString("left_thumb"));
             record.put("left_originalcapture", rs.getString("left_originalcapture"));
             record.put("imageURL", rs.getString("imageURL"));
             record.put("signatureURL", rs.getString("signatureURL"));
             record.put("capture_staffid", rs.getInt("capture_staffid"));
             record.put("capture_firstname", rs.getString("capture_firstname"));
             record.put("capture_lastname", rs.getString("capture_lastname"));
             Timestamp capture_timestamp1 = rs.getTimestamp("capture_timestamp");
             String capture_timestamp = capture_timestamp1.toString();
             record.put("capture_timestamp", capture_timestamp);
             record.put("is_amputee", rs.getInt("is_amputee"));
             record.put("is_juvenile", rs.getInt("is_juvenile"));
             record.put("is_partial_amputee", rs.getInt("is_partial_amputee"));
             record.put("sync_staffid", rs.getInt("sync_staffid"));
             record.put("sync_firstname", rs.getString("sync_firstname"));
             record.put("sync_lastname", rs.getString("sync_lastname"));
             Timestamp sync_timestamp1 = rs.getTimestamp("sync_timestamp");
             String sync_timestamp = sync_timestamp1.toString();
             record.put("sync_timestamp", sync_timestamp);

             array.put(record);
               
}
            jsonObject.put("biometrics_data", array);
            String jsonInputString = null;
           JSONArray arr = jsonObject.getJSONArray("biometrics_data");
               int arrayLength = arr.length();

            
           
                  JSONObject firstObject = null;
                  int applicant_id = 0 ;
                  for (int i = 0; i < arr.length(); i++) {
                  firstObject = arr.getJSONObject(0);
                  }
                 Integer id1 = firstObject.getInt("ID");
                 String id = id1.toString();
                 Integer applicantId = firstObject.getInt("applicant_id");
                 String applicantid = applicantId.toString();
                 String right_fore = firstObject.getString("right_fore");
                 String right_originalcapture = firstObject.getString("right_originalcapture");
                 String right_little =firstObject.getString("right_little");
                 String right_middle = firstObject.getString("right_middle");
                 String right_ring = firstObject.getString("right_ring");
                 String right_thumb =firstObject.getString("right_thumb");
                 String left_fore =firstObject.getString("left_fore");
                 String left_little =firstObject.getString("left_little");
                 String left_middle = firstObject.getString("left_middle");
                 String left_ring =firstObject.getString("left_ring");
                 String left_thumb = firstObject.getString("left_thumb");
                 String left_originalcapture =firstObject.getString("left_originalcapture");
                 String imageURL = firstObject.getString("imageURL");
                 String signatureURL = firstObject.getString("signatureURL");
                 Integer staffid = firstObject.getInt("capture_staffid");
                 String capture_staffid = staffid.toString();
                 String capture_firstname = firstObject.getString("capture_firstname");
                 String capture_lastname = firstObject.getString("capture_lastname");
                 Integer is_amputee1 = firstObject.getInt("is_amputee");
                 String is_amputee= is_amputee1.toString();
                 Integer is_juvenile1 = firstObject.getInt("is_juvenile");
                 String is_juvenile = is_juvenile1.toString();
                 Integer is_partial_amputee1 = firstObject.getInt("is_partial_amputee");
                 String is_partial_amputee = is_partial_amputee1.toString();
                 Integer sync_staffid1 = firstObject.getInt("sync_staffid");
                 String sync_staffid =sync_staffid1.toString();
                 String sync_firstname = firstObject.getString("sync_firstname");
                 String sync_lastname = firstObject.getString("sync_lastname");
                 String sync_timestamp = firstObject.getString("sync_timestamp");
                 String capture_timestamp = firstObject.getString("capture_timestamp");
                  
                 if(arrayLength == 0){
                        JOptionPane.showMessageDialog(null, "Transmit Done ....");
                 } else{
                   JOptionPane.showMessageDialog(null, "Transmit in progress ....");

                 }
             
             Map<String,String> arguments = new HashMap<>();
             
             arguments.put("rid", "1");
             arguments.put("aid", "2");
             arguments.put("lid", "0");
             arguments.put("ID", id);
             arguments.put("applicant_id", applicantid);
             arguments.put("right_fore", right_fore);
             arguments.put("right_originalcapture", right_originalcapture);
             arguments.put("right_little", right_little);
             arguments.put("right_middle", right_middle);
             arguments.put("right_ring", right_ring);
             arguments.put("right_thumb", right_thumb);
             arguments.put("left_fore", left_fore);
             arguments.put("left_little", left_little);
             arguments.put("left_middle", left_middle);
             arguments.put("left_ring", left_ring);
             arguments.put("left_thumb", left_thumb);
             arguments.put("left_originalcapture", left_originalcapture);
             arguments.put("imageURL", imageURL);
             arguments.put("signatureURL", signatureURL);
             arguments.put("capture_staffid", capture_staffid);
             arguments.put("capture_firstname", capture_firstname);
             arguments.put("capture_lastname", capture_lastname);
             arguments.put("capture_timestamp", capture_timestamp);
             arguments.put("is_amputee", is_amputee);
             arguments.put("is_juvenile", is_juvenile);
             arguments.put("is_partial_amputee", is_partial_amputee);
             arguments.put("sync_staffid", sync_staffid);
             arguments.put("sync_firstname", sync_firstname);
             arguments.put("sync_lastname", sync_lastname);
             arguments.put("sync_timestamp", sync_timestamp);  
             
                StringJoiner sj = new StringJoiner("&");
                for(Map.Entry<String,String> entry : arguments.entrySet())
                sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
                  + URLEncoder.encode(entry.getValue(), "UTF-8"));
                
            String appendQuery = sj.toString();
            String newQuery = myurl.getQuery();
             if (newQuery == null) {
            newQuery = appendQuery;
                 } else {
            newQuery += "&" + appendQuery;  
              }
            URI newURI = new URI(myurl.getScheme(),myurl.getAuthority(),
                myurl.getPath(),newQuery);
            String uri = newURI.toString();
            uri = uri.replaceFirst("\\#", "?");
             URI finalURI = new URI(uri);
           
            //URL url = finalURI.toURL();
            URL url = new URL("https://futuristickaadev.com//mwclient//index.php?type=iprintcards&srid=2&lid=0");
            System.out.println(url);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setDoOutput(true);
            con.connect();
            
                /*byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
                //System.out.println(out);
                int length = out.length;*/
                  
            /* try(OutputStream os= con.getOutputStream()){
            //byte[] postData = jsonInputString.getBytes("utf-8");
             //os.write(postData, 0, postData.length);
                  }*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder results = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            results.append(line);
        }
             System.out.println(results.toString());
     
                String returnedData = results.toString();
                String str5 = returnedData.replaceAll("[()]", "");
                String str3 =str5.substring(str5.indexOf(' '),str5.length());
                String str2 = str3.replaceFirst("\"", "");


                JSONArray arr2 = new JSONArray(str2);
                //System.out.println(arr);
                String message = null;
               for (int i = 0; i < arr2.length(); i++) {
                  message = arr2.getJSONObject(i).getString("message");
                  }
               System.out.println(message);
               if(message.equals("Success")){
                String sql = "UPDATE local_biocapture_manager SET bio_sync_receipt_status = 1 WHERE applicant_id ='"+ applicantid+"'";
               int result = stmt.executeUpdate(sql);

               }
                
        }
    
}
