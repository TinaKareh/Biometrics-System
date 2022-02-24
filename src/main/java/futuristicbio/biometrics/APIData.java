/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Futuristic Ltd
 */
public class APIData {
    //22cd34feb0f419648ad5e83cf9c67716317645bc access token 1

    private static HttpURLConnection connection;

    public static void main(String[] args) {
        getData();
        postData();
    }

    public static String parse(String responseBody) {
        JSONArray users = new JSONArray(responseBody);
        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            int id = user.getInt("id");
            String name = user.getString("name");
            String phone = user.getString("phone");

            System.out.println("ID is: " + id + " " + "Name is: " + name + " " + "Phone is: " + phone);
        }
        return null;
    }

    //method that gets data from api
    public static void getData() {
        Properties prop = new Properties();
        InputStream input = null;

        BufferedReader reader;
        String line;
        StringBuffer readContent = new StringBuffer();

        try {
            //loads the application.property file and gets the url required url
            input = DBConnect.class.getResourceAsStream("/resources/application.properties");
            prop.load(input);

            System.out.println(input);

            Class.forName(prop.getProperty("get.url"));
            
            URL url3 = new URL(prop.getProperty("url"));
            connection = (HttpURLConnection) url3.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3600);
            connection.setReadTimeout(3600);

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    readContent.append(line);
                }
                reader.close();

            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    readContent.append(line);
                }
                reader.close();
            }
            parse(readContent.toString());
//            System.out.println(readContent.toString());
        } catch (IOException ex) {
            Logger.getLogger(APIData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(APIData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.disconnect();
        }
    }

    //method to send data to the api
    public static void postData() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            //loads the application.property file and gets the url required url
            input = DBConnect.class.getResourceAsStream("/resources/application.properties");
            prop.load(input);

            System.out.println(input);

            Class.forName(prop.getProperty("get.url"));
            
            URL url = new URL(prop.getProperty("demo.post.url"));
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Authorization", "Bearer 22cd34feb0f419648ad5e83cf9c67716317645bc");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String data = "key1=value1&key2=value2";

            byte[] out = data.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = http.getOutputStream();
            stream.write(out);

            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            http.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(APIData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(APIData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(APIData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
