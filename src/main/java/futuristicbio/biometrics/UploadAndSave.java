package futuristicbio.biometrics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Futuristic
 */
public class UploadAndSave {

    private UserContext context;

    public UploadAndSave() {
        context = (UserContext) ThreadLocalStorage.getUserContext();
    }

    public void uploadSignatureFile(String pathToServer, String pathFromLocal,
            String applicantid) throws NetworkException, FileNotFoundException, SQLException {
            Connection conn = null;
            PreparedStatement pst = null;
            Statement stmt = null;
            ResultSet rs = null;
            Statement st = null;
           conn = DBConnect.ConnecrDb();

        //check if the applicant id is already in db
        try{
              /*String sql2 = "INSERT INTO permitbiometrics (applicantId) VALUES ('" + applicantid + "')";
              stmt = conn.createStatement();
              stmt.executeUpdate(sql2);*/

            String sql = "Select applicantId from permitbiometrics WHERE applicantId='" + applicantid + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            stmt = conn.createStatement();

            if (rs.next()) {
                //do nothing

            } else {
                //insert applicant id
                String sql2 = "INSERT INTO permitbiometrics (applicantId) VALUES ('" + applicantid + "')";
                stmt.executeUpdate(sql2);
            }
        }catch(SQLException e){
         System.err.println(e.getMessage());
          e.printStackTrace();
        }
        File directory = new File(pathFromLocal);
        File[] listFiles = directory.listFiles();
        if (listFiles.length > 0) {
            File signatureFile = listFiles[0];
            uploadtoserver(pathToServer, signatureFile);
            System.out.println("reaching");
                        try {
                String Query1 = "UPDATE permitbiometrics SET signature_status ='" + 1 + "',signatureURL= '" + signatureFile.getName()
                        + "' WHERE applicantId = '" + applicantid + "'";
                st = conn.createStatement();
                st.executeUpdate(Query1);
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
                throw new NetworkException("Failed to upload signature");
            } finally {
                try {
                    stmt.close();
                    st.close();
                    conn.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }

            }

        } else {
            System.out.println("Signature not found locally.....");
        }

    }

    public void uploadPhotoFile(String pathToServer, String pathFromLocal,
            String applicantid) throws NetworkException, FileNotFoundException, SQLException {
        
        Connection conn = null;
            Statement st = null;
            PreparedStatement pst = null;
            Statement stmt = null;
            ResultSet rs = null;
            conn = DBConnect.ConnecrDb();
         try{
            //check if the applicant id is already in db
            String sql = "Select  applicantId from permitbiometrics WHERE applicantId='" + applicantid + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            stmt = conn.createStatement();

            if (rs.next()) {
                //do nothing

            } else {
                //insert applicant id

                String sql2 = "INSERT INTO permitbiometrics (applicantId) VALUES ('" + applicantid + "')";
                stmt.executeUpdate(sql2);

            }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
                throw new NetworkException("Failed to update photograph field");
            }
        File directory = new File(pathFromLocal);
        File[] listFiles = directory.listFiles();
        if (listFiles.length > 0) {
            File signatureFile = listFiles[0];
            uploadtoserver(pathToServer, signatureFile);
            try {
                String Query1 = "UPDATE permitbiometrics SET image_status = '" + 1 + "',imageURL= '" + signatureFile.getName() + "' WHERE applicantId = '" + applicantid + "'";
                st = conn.createStatement();
                st.executeUpdate(Query1);

            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
                throw new NetworkException("Failed to update photograph field");
            } finally {
                DBConnect.closeStatement(st);
                DBConnect.closeConnection(conn);
            }

        } else {
            System.out.println("Passport photo not found locally....");
        }

    }

    public void uploadfingerprints(String Pathtoserver, String Pathtolocaldirectory,
            String applicantid, int isJuvenile, int isAmputee, int isPartialAmputee) throws NetworkException, FileNotFoundException {

        System.out.println("using id: " + applicantid);

        Connection conn = null;
        PreparedStatement pst = null;
        Statement stmt = null;
        Statement st = null;
        ResultSet rs = null;
        try {

            conn = DBConnect.ConnecrDb();
            //check if the applicant id is already in db
            String sql = "Select  applicantId from permitbiometrics WHERE applicantId='" + applicantid + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            stmt = conn.createStatement();

            if (rs.next()) {
                //do nothing

            } else {
                //insert applicant id

                String sql2 = "INSERT INTO permitbiometrics (applicantId) VALUES ('" + applicantid + "')";
                stmt.executeUpdate(sql2);

            }

            //get images from the path given
            File directory = new File(Pathtolocaldirectory);
            File[] listFiles = directory.listFiles();

            String rightFore = null;
            String rightCapture = null;
            String rightLittle = null;
            String rightMiddle = null;
            String rightRing = null;
            String rightThumb = null;
            String leftThumb = null;
            String leftRing = null;
            String leftMiddle = null;
            String leftLittle = null;
            String leftFore = null;
            String leftCapture = null;
            String thumbCapture = null;
            for (File sourceFile : listFiles) {

                if (sourceFile.getName().contains("RIGHT_FORE")) {

                    //save to db and upload  to server
                    rightFore = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_CAPTURE")) {

                    rightCapture = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_LITTLE")) {
                    rightLittle = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_MIDDLE")) {
                    rightMiddle = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_RING")) {
                    rightRing = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_THUMB")) {
                    rightThumb = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_THUMB")) {
                    leftThumb = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_RING")) {
                    leftRing = sourceFile.getName();

                    uploadtoserver(Pathtoserver, sourceFile);

                } else if (sourceFile.getAbsolutePath().contains("LEFT_MIDDLE")) {
                    leftMiddle = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_LITTLE")) {
                    leftLittle = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_FORE")) {
                    leftFore = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_CAPTURE")) {
                    leftCapture = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                }
                else if (sourceFile.getAbsolutePath().contains("THUMB_CAPTURE")) {
                    
                    thumbCapture = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                }
            }

            uploadMultipleFIles(Pathtoserver, Pathtolocaldirectory);
            
            String finalQuery = "UPDATE permitbiometrics SET fingerprint_status='" + 1 + "',"
                    +"right_fore='" + rightFore + "',"
                    + "right_originalcapture='" + rightCapture + "', "
                    + "right_little='" + rightLittle + "', "
                    + "right_middle='" + rightMiddle + "', "
                    + "left_little='" + leftLittle + "', "
                    + "right_ring='" + rightRing + "', "
                    + "right_thumb='" + rightThumb + "', "
                    + "left_thumb='" + leftThumb + "', "
                    + "left_ring='" + leftRing + "', "
                    + "left_middle='" + leftMiddle + "', "
                    + "left_fore='" + leftFore + "', "
                    + "left_originalcapture='" + leftCapture + "', "
                    +"thumb_capture='"+thumbCapture+"',"
                    + "is_amputee='" + isAmputee + "', "
                    + "is_juvenile='" + isJuvenile + "', "
                    + "is_partial_amputee='" + isPartialAmputee + "' "
                    + "WHERE applicantId='" + applicantid + "'";
            st = conn.createStatement();
            st.executeUpdate(finalQuery);

            System.out.println("Completed png upload...");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw new NetworkException("Failed to update biometric fields");
        } finally {

            try {
                rs.close();
                st.close();
                stmt.close();
                pst.close();
                conn.close();
            } catch (SQLException e) {

            }

        }

    }
    
    
    public void uploadRealscanfingerprints(String Pathtoserver, String Pathtolocaldirectory,
            String applicantid, int isJuvenile, int isAmputee, int isPartialAmputee) throws NetworkException, FileNotFoundException {

        System.out.println("using id: " + applicantid);

        Connection conn = null;
        PreparedStatement pst = null;
        Statement stmt = null;
        Statement st = null;
        ResultSet rs = null;
        try {

            conn = DBConnect.ConnecrDb();
            //check if the applicant id is already in db
            String sql = "Select  applicantId from permitbiometrics WHERE applicantId='" + applicantid + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            stmt = conn.createStatement();

            if (rs.next()) {
                //do nothing

            } else {
                //insert applicant id

                String sql2 = "INSERT INTO permitbiometrics (applicantId) VALUES ('" + applicantid + "')";
                stmt.executeUpdate(sql2);

            }

            //get images from the path given
            File directory = new File(Pathtolocaldirectory);
            
            FilenameFilter textFileFilter = new FilenameFilter() {

            @Override
            public boolean accept(File directory, String name) {
                return name.endsWith(".png");
            }
        };
            File[] listFiles = directory.listFiles(textFileFilter);

            String rightFore = null;
            String rightCapture = null;
            String rightLittle = null;
            String rightMiddle = null;
            String rightRing = null;
            String rightThumb = null;
            String leftThumb = null;
            String leftRing = null;
            String leftMiddle = null;
            String leftLittle = null;
            String leftFore = null;
            String leftCapture = null;
            String thumbCapture = null;
            String newName;
            String applicant = applicantid.toString();
            for (File sourceFile : listFiles) {

                if (sourceFile.getName().contains("RIGHT_FORE")) {
                    //save to db and upload  to server
                    rightFore = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_CAPTURE")) {

                    rightCapture = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_LITTLE")) {
                    rightLittle = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_MIDDLE")) {
                    rightMiddle = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_RING")) {
                    rightRing = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getName().contains("RIGHT_THUMB")) {
                    rightThumb = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_THUMB")) {
                    leftThumb = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_RING")) {
                    leftRing = sourceFile.getName();

                   // uploadtoserver(Pathtoserver, sourceFile);

                } else if (sourceFile.getAbsolutePath().contains("LEFT_MIDDLE")) {
                    leftMiddle = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_LITTLE")) {
                    leftLittle = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_FORE")) {
                    leftFore = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                } else if (sourceFile.getAbsolutePath().contains("LEFT_CAPTURE")) {
                    leftCapture = sourceFile.getName();

 //                 uploadtoserver(Pathtoserver, sourceFile);
                }else if (sourceFile.getAbsolutePath().contains("THUMB_CAPTURE")) {
                    
                    thumbCapture = sourceFile.getName();

//                    uploadtoserver(Pathtoserver, sourceFile);
                }
            }

            uploadMultipleFIles(Pathtoserver, Pathtolocaldirectory);
            System.out.println("reaching");
            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String updatedAt = sdf.format(date);
            Integer staffId = context.getUserId();*/
            String finalQuery = "UPDATE permitbiometrics SET fingerprint_status='" + 1 + "',"
                    + "right_fore='" + rightFore + "',"
                    + "right_originalcapture='" + rightCapture + "',"
                    + "right_little='" + rightLittle + "', "
                    + "right_middle='" + rightMiddle + "', "
                    + "left_little='" + leftLittle + "', "
                    + "right_ring='" + rightRing + "', "
                    + "right_thumb='" + rightThumb + "', "
                    + "left_thumb='" + leftThumb + "', "
                    + "left_ring='" + leftRing + "', "
                    + "left_middle='" + leftMiddle + "', "
                    + "left_fore='" + leftFore + "', "
                    + "left_originalcapture='" + leftCapture + "', "
                    +"thumb_capture='"+thumbCapture+"',"
                    + "is_amputee='" + isAmputee + "', "
                    + "is_juvenile='" + isJuvenile + "', "
                    + "is_partial_amputee='" + isPartialAmputee + "' "
                    + "WHERE applicantId='" + applicantid + "'";
            st = conn.createStatement();
            st.executeUpdate(finalQuery);

            System.out.println("Completed png upload...");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw new NetworkException("Failed to update biometric fields");
        } finally {

            try {
                rs.close();
                st.close();
                stmt.close();
                pst.close();
                conn.close();
            } catch (SQLException e) {

            }

        }

    }
    public void updatePermitBiometrics(Integer userid,String applicantid) throws SQLException{
     Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        Statement stmt = null;
       PreparedStatement prepared = null;
       ResultSet rs1 = null;
        try {

            conn = DBConnect.ConnecrDb();
            //check if the applicant id is already in db
            String sql = "SELECT  applicantId from permitbiometrics WHERE applicantId='" + applicantid + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            stmt = conn.createStatement();
            st = conn.createStatement();

            if (rs.next()) {
                //do nothing

            } else {
                //insert applicant id

                String sql2 = "INSERT INTO permitbiometrics (applicantId) VALUES ('" + applicantid + "')";
                stmt.executeUpdate(sql2);

            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String updatedAt = sdf.format(date);
            String sql3 = "SELECT firstname,lastname,employee_num FROM users WHERE id='"+userid+"'";
            String firstname = null;
            String lastname = null;
            String employee_num = null;
           prepared = conn.prepareStatement(sql3);
           rs1 = prepared.executeQuery();
        
        while(rs1.next()){
          firstname = rs1.getString("firstname");
          lastname = rs1.getString("lastname");
          employee_num = rs1.getString("employee_num");
        }
        String Query1 = "UPDATE permitbiometrics SET capture_firstname= '" + firstname + "',"
                    +"capture_lastname = '"+lastname+"',"
                    +"capture_timestamp = '"+updatedAt+"',"
                    +"capture_staffid= '"+employee_num+"'"
                    +"WHERE applicantId = '" + applicantid + "'";
            st.executeUpdate(Query1);
        
        
        }  catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {

            try {
                rs.close();
                st.close();
                stmt.close();
                pst.close();
                conn.close();
                prepared.close();
                rs1.close();
            } catch (SQLException e) {

            }

        }
    }

    public void updateForm25(String applicantId,String application_no) throws NetworkException, SQLException {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DBConnect.ConnecrDb();
        st = conn.createStatement();
        String query = "SELECT fingerprint_status,image_status,signature_status from permitbiometrics where applicantId='" + applicantId + "'";
        rs = st.executeQuery(query);
        int fingerprint_status = 0;
        int image_status = 0;
        int signature_status = 0;
        String files_uploaded = "files uploaded";
        String file_uploaded = "file uploaded";
         while(rs.next()) {
            fingerprint_status = rs.getInt("fingerprint_status");
            image_status = rs.getInt("image_status");
            signature_status = rs.getInt("signature_status");
            }
         if(application_no.startsWith("P")){
         if(fingerprint_status ==1 && image_status==1 && signature_status ==1){
        try {
            String Query1 = "UPDATE local_biocapture_manager SET bio_capture_status= '" + 1 + "',"
                    +"biocapture_file = '"+files_uploaded+"'"
                    +"WHERE applicant_id = '" + applicantId + "'";
            st.executeUpdate(Query1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw new NetworkException("Failed to update permitbiometric status");
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }

        }
         }
         }else{
                if(fingerprint_status ==1 || image_status==1 || signature_status ==1){
                    try {
                    String Query1 = "UPDATE local_biocapture_manager SET bio_capture_status= '" + 1 + "',"
                    +"biocapture_file = '"+file_uploaded+"'"
                    +"WHERE applicant_id = '" + applicantId + "'";
            st.executeUpdate(Query1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw new NetworkException("Failed to update permitbiometric status");
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }

        }
                }
         }

    }

    public void uploadMultipleFIles(String pathToServer, String pathFromLocal) throws NetworkException {
        File directory = new File(pathFromLocal);
        
        FilenameFilter textFileFilter = new FilenameFilter() {

            @Override
            public boolean accept(File directory, String name) {
                return name.endsWith(".png");
            }
        };
        File[] listFiles = directory.listFiles(textFileFilter);
        if (listFiles.length > 0) {
            JSch jsch = new JSch();
            Session session = null;
            Channel channel = null;
            ChannelSftp sftpChannel = null;
            String privateKey = "C:\\Users\\Futuristic Ltd\\.ssh\\grace-private-key.ppk";
            try {
                
            jsch.setKnownHosts("C:\\Users\\Futuristic Ltd\\.ssh\\known_hosts");
            session = jsch.getSession("gwanjiru35", "www.futuristickaadev.com", 22);  
            jsch.addIdentity(privateKey,"W4g2021*!");
            session.connect();
                /*session = jsch.getSession("administrator", "192.168.200.4", 22); 
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword("kaa@2021*");
                session.connect();*/
            } catch (JSchException e) {
            System.out.println("Issue getting session.");
            e.printStackTrace();
        }
            try{
                channel = session.openChannel("sftp");
                channel.connect();
                sftpChannel = (ChannelSftp) channel;

                for (int i = 0; i < listFiles.length; i++) {
                    System.out.println("uploading: " + listFiles[i].getName());
                    sftpChannel.put(listFiles[i].getAbsolutePath(), pathToServer + listFiles[i].getName());
                  System.out.println("done");
                }
            session.disconnect();

            } catch (JSchException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
                throw new NetworkException("Failed to upload resources");
            } catch (SftpException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
                throw new NetworkException("Failed to create sftp connection");
            } finally {
                sftpChannel.exit();
                channel.disconnect();
                session.disconnect();

            }

        } else {
            System.err.println("Files not found locally");
        }

    }

    public void uploadtoserver(String pathtoserver, File file) throws NetworkException, FileNotFoundException {

        JSch jsch = new JSch();
        Session session = null;
        Channel channel = null;
        ChannelSftp sftpChannel = null;
        String privateKey = "C:\\Users\\Futuristic Ltd\\.ssh\\grace-private-key.ppk";
        try{
            System.out.println("uploading: " + file.getName());
            
            jsch.setKnownHosts("C:\\Users\\Futuristic Ltd\\.ssh\\known_hosts");
            session = jsch.getSession("gwanjiru35", "www.futuristickaadev.com", 22);  
            jsch.addIdentity(privateKey,"W4g2021*!");
            
            session.connect();
            /*session = jsch.getSession("administrator", "192.168.200.4", 22);            
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("kaa@2021*");
            session.connect();*/
            
        } catch (JSchException e) {
            System.out.println("Issue getting session.");
            e.printStackTrace();
        }
        
        try {
            channel = session.openChannel("sftp");
            channel.connect();
            sftpChannel = (ChannelSftp) channel;
             File f = new File(file.getAbsolutePath());
             InputStream targetStream = new FileInputStream(f);

             String secondStream = pathtoserver+file.getName();
            sftpChannel.put(targetStream, secondStream);

            session.disconnect();
            
        } catch (JSchException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw new NetworkException("Failed to upload resource");
        } catch (SftpException e) {
            e.printStackTrace();
            throw new NetworkException("Failed to create sftp connection");
        } finally {
            sftpChannel.exit();
            channel.disconnect();
            session.disconnect();
        }

    }

}
