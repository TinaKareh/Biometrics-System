/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Futuristic Ltd
 */
public class DBConnect {
    private static final String username = "root";
    private static final String password = "";
    private static final String dataCOnn = "jdbc:mysql://127.0.0.1/demotest";
    private static com.mysql.jdbc.Connection sqlConn = null;
        public static Connection ConnecrDb() {

        Properties prop = new Properties();
        InputStream input = null;
   
        try {
            sqlConn = (com.mysql.jdbc.Connection)DriverManager.getConnection(dataCOnn, username, password);
        } catch (SQLException e) {
            return sqlConn;
        }
        return sqlConn;

        /*try {

            input = DBConnect.class.getResourceAsStream("/resources/application.properties");
            prop.load(input);
            
            System.out.println(input);

              
            Class.forName(prop.getProperty("mysql.driver"));
            Connection conn = DriverManager.getConnection(prop.getProperty("mysql.url"),
                    prop.getProperty("mysql.username"), prop.getProperty("mysql.password"));
            
            //JOptionPane.showMessageDialog(null, "Connection Established");C:\Users\9589693153\Documents\NetBeansProjects\PROMA
            return conn;

        } 
                catch (IOException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Couldn't load properties file");
                    return null;
                } 
        
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Couldn't connect to database, Check network status");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Couldn't load database driver");
            return null;
        }*/
        
        

    }
        
        
    public static Session createSession() throws JSchException {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = DBConnect.class.getResourceAsStream("/resources/application.properties");
            prop.load(input);
            
            System.out.println(input);
            
            JSch jsch = new JSch();
            Session session = jsch.getSession(prop.getProperty("app.ssh.username"),
                    prop.getProperty("app.ssh.ip"), 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(prop.getProperty("app.ssh.password"));
            return session;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Couldn't load properties file");
            return null;
        }
    }

    public static void closeConnection(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void closePreparedStatement(PreparedStatement pst) {

        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rst) {

        try {
            if (rst != null) {
                rst.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement smt) {

        try {

            if (smt != null) {
                smt.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    
}
