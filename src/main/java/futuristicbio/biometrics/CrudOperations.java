/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudOperations {

    private ArrayList<String> al;
    public ArrayList<DataNewRequests> alm;

    public CrudOperations() {
    }

    public ArrayList<DataApplicants> getAllApplicants() {
        ArrayList<DataApplicants> viewUser = new ArrayList<>();

        String sql5 = "SELECT registration_number,first_name,middle_name,surname,rank,state,county, biocapture_status FROM police_details WHERE biocapture_status ='" + 0 + "'ORDER BY registration_date DESC";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new DataApplicants(
                        rse.getString("registration_number"), rse.getString("first_name"), rse.getString("middle_name"), rse.getString("surname"),
                        rse.getString("rank"), rse.getString("state"), rse.getString("county"), rse.getString("biocapture_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<EnrollmentDetails> getAllEnrollments() {
        ArrayList<EnrollmentDetails> viewUser = new ArrayList<>();

        String sql5 = "SELECT police_idno,first_name,surname,position_held,rank,state,county,enrollment_status FROM police_details WHERE enrollment_status ='" + 1 + "'ORDER BY registration_date DESC";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new EnrollmentDetails(
                        rse.getString("police_idno"), rse.getString("first_name"), rse.getString("surname"), rse.getString("position_held"),
                        rse.getString("rank"), rse.getString("county"), rse.getString("state"), rse.getString("enrollment_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<EnrollmentDetails> getAllRegistrations() {
        ArrayList<EnrollmentDetails> viewUser = new ArrayList<>();

        String sql5 = "SELECT police_idno,first_name,surname,position_held,rank,state,county, verification_status FROM police_details WHERE verification_status ='" + 1 + "'ORDER BY registration_date DESC";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new EnrollmentDetails(
                        rse.getString("police_idno"), rse.getString("first_name"), rse.getString("surname"), rse.getString("position_held"),
                        rse.getString("rank"), rse.getString("state"), rse.getString("county"), rse.getString("verification_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<DataApplicants> getLimitedRegistrations() {
        ArrayList<DataApplicants> viewUser = new ArrayList<>();

        String sql5 = "SELECT registration_number,first_name,middle_name,surname,rank,state,county, biocapture_status FROM police_details WHERE biocapture_status ='" + 1 + "'ORDER BY registration_date DESC LIMIT 10";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new DataApplicants(
                        rse.getString("registration_number"), rse.getString("first_name"), rse.getString("middle_name"), rse.getString("surname"),
                        rse.getString("rank"), rse.getString("county"), rse.getString("state"), rse.getString("biocapture_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<EnrollmentDetails> getAllDataUpdates() {
        ArrayList<EnrollmentDetails> viewUser = new ArrayList<>();

        String sql5 = "SELECT police_idno,first_name,surname,position_held,rank,state,county,update_status FROM police_details WHERE update_status >='" + 1 + "'ORDER BY registration_date DESC";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new EnrollmentDetails(
                        rse.getString("police_idno"), rse.getString("first_name"), rse.getString("surname"), rse.getString("position_held"),
                        rse.getString("rank"), rse.getString("county"), rse.getString("state"), rse.getString("update_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<DataApplicants> getLimitedDataUpdates() {
        ArrayList<DataApplicants> viewUser = new ArrayList<>();

        String sql5 = "SELECT registration_number,first_name,middle_name,surname,rank,state,county, approve_status FROM police_details WHERE update_status ='" + 1 + "'ORDER BY registration_date DESC LIMIT 10";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new DataApplicants(
                        rse.getString("registration_number"), rse.getString("first_name"), rse.getString("middle_name"), rse.getString("surname"),
                        rse.getString("rank"), rse.getString("county"), rse.getString("state"), rse.getString("approve_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<EnrollmentDetails> getAllApprovedUpdates() {
        ArrayList<EnrollmentDetails> viewUser = new ArrayList<>();

        String sql5 = "SELECT police_idno,first_name,surname,position_held,rank,state,county, update_status FROM police_details WHERE update_status ='" + 2 + "'ORDER BY registration_date DESC";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new EnrollmentDetails(
                        rse.getString("police_idno"), rse.getString("first_name"), rse.getString("surname"), rse.getString("position_held"),
                        rse.getString("rank"), rse.getString("county"), rse.getString("state"), rse.getString("update_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<DataApplicants> getAllRejectedUpdates() {
        ArrayList<DataApplicants> viewUser = new ArrayList<>();

        String sql5 = "SELECT registration_number,first_name,middle_name,surname,rank,state,county, update_status FROM police_details WHERE update_status ='" + 3 + "'ORDER BY registration_date DESC";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new DataApplicants(
                        rse.getString("registration_number"), rse.getString("first_name"), rse.getString("middle_name"), rse.getString("surname"),
                        rse.getString("rank"), rse.getString("county"), rse.getString("state"), rse.getString("update_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<DataNewRequests> searchPendingDateFrom(String searchText, String startDate, String endDate) throws SQLException {
        alm = new ArrayList<>();
        String sql, sql1, dateStart = null, dateEnd = null, textSearch;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //initialize parameters and set default

        textSearch = ("".equals(searchText)) ? "" : searchText;
        dateStart = ("".equals(startDate)) ? "1991-01-01" : startDate;
        dateEnd = ("".equals(endDate)) ? dtf.format(now) : endDate;
        System.out.println(dateStart);
        System.out.println(dateEnd);

        Connection conn = null;
        ResultSet rs = null;
        conn = (Connection) DBConnect.ConnecrDb();
        Statement stmt = conn.createStatement();

        if (textSearch.equals("") || dateStart.equals("1991-01-01") || dateEnd.equals(dtf.format(now))) {

            sql1 = "SELECT registration_number,first_name,middle_name,surname,rank,state,county,biocapture_status "
                    + "FROM police_details WHERE biocapture_status = 1 ORDER BY registration_date DESC";
            rs = stmt.executeQuery(sql1);
        } else {

            sql = "SELECT registration_number,first_name,middle_name,surname,rank,state,county,biocapture_status "
                    + "FROM police_details WHERE biocapture_status = 1 AND DATE(registration_date) BETWEEN '" + dateStart + "' AND '" + dateEnd + "' ORDER BY registration_date DESC";
            rs = stmt.executeQuery(sql);
        }

        try {
            while (rs.next()) {
                alm.add(new DataNewRequests(rs.getString("registration_number"), rs.getString("first_name"), rs.getString("surname"), rs.getString("middle_name"), rs.getString("rank"), rs.getString("state"), rs.getString("county")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return alm;
    }

    public ArrayList<DataNewRequests> searchCompletedDateFrom(String searchText, String startDate, String endDate) throws SQLException {
        alm = new ArrayList<>();
        String sql, sql1, dateStart, dateEnd, textSearch;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //initialize parameters and set default
        textSearch = ("".equals(searchText)) ? "" : searchText;
        dateStart = ("".equals(startDate)) ? "1991-01-01" : startDate;
        dateEnd = ("".equals(endDate)) ? dtf.format(now) : endDate;

        Connection conn = null;
        ResultSet rs = null;
        conn = (Connection) DBConnect.ConnecrDb();
        Statement stmt = conn.createStatement();

        if (textSearch.equals("") || dateStart.equals("1991-01-01") || dateEnd.equals(dtf.format(now))) {

            sql1 = "SELECT registration_number,first_name,middle_name,surname,rank,state,county,biocapture_status "
                    + "FROM police_details WHERE update_status >= 1";
            rs = stmt.executeQuery(sql1);
        } else {

            sql = "SELECT registration_number,first_name,middle_name,surname,rank,state,county,biocapture_status FROM police_details WHERE update_status >= 1 AND DATE(registration_date) BETWEEN '" + dateStart + "' AND '" + dateEnd + "'";
            rs = stmt.executeQuery(sql);
        }
        try {
            while (rs.next()) {
                alm.add(new DataNewRequests(rs.getString("registration_number"), rs.getString("first_name"), rs.getString("middle_name"), rs.getString("surname"), rs.getString("rank"), rs.getString("state"), rs.getString("county")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return alm;
    }

    public ArrayList<String> getSummary() {
        al = new ArrayList<String>();

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        ResultSet rse = null;
        ResultSet rsd = null;
        ResultSet rsc = null;
        ResultSet rsa = null;
        ResultSet rsb = null;
        ResultSet rsf = null;
        ResultSet rsg = null;
        ResultSet rsh = null;

        PreparedStatement psta = null;
        PreparedStatement pstb = null;
        PreparedStatement pstc = null;
        PreparedStatement pstd = null;
        PreparedStatement pste = null;
        PreparedStatement pstf = null;
        PreparedStatement pstg = null;
        PreparedStatement psth = null;

        String sql1 = "SELECT count(id) AS 'ME'  from police_details where gender = 'Male'";
        String sql2 = "SELECT count(id) AS 'FE' from police_details where gender = 'Female'";

        String sql3 = "SELECT count(id) AS 'TE' from police_details";
        String sql4 = "SELECT count(id) AS 'DU' from police_details where update_status >=1";
        String sql5 = "SELECT count(id) AS SU from users where active_status= 1";
        String sql6 = "SELECT count(id) AS 'AP' from police_details where update_status=2";
        String sql7 = "SELECT count(id) AS 'RE' from police_details where update_status=3";
        String sql8 = "SELECT count(id) AS 'PE' from police_details where update_status=1";

        try {
            sqlConn.setAutoCommit(false);

            psta = (PreparedStatement) sqlConn.prepareStatement(sql1);
            pstb = (PreparedStatement) sqlConn.prepareStatement(sql2);
            pstc = (PreparedStatement) sqlConn.prepareStatement(sql3);
            pstd = (PreparedStatement) sqlConn.prepareStatement(sql4);
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            pstf = (PreparedStatement) sqlConn.prepareStatement(sql6);
            pstg = (PreparedStatement) sqlConn.prepareStatement(sql7);
            psth = (PreparedStatement) sqlConn.prepareStatement(sql8);

            rsa = psta.executeQuery();
            if (rsa.next()) {
                al.add(rsa.getString("ME"));
            } else {
                al.add("0");
            }
            rsb = pstb.executeQuery();
            if (rsb.next()) {
                al.add(rsb.getString("FE"));
            } else {
                al.add("0");
            }
            rsc = pstc.executeQuery();
            if (rsc.next()) {
                al.add(rsc.getString("TE"));
            } else {
                al.add("0");
            }
            rsd = pstd.executeQuery();
            if (rsd.next()) {
                al.add(rsd.getString("DU"));

            } else {
                al.add("0");
            }
            rse = pste.executeQuery();
            if (rse.next()) {
                al.add(rse.getString("SU"));
            } else {
                al.add("0");
            }
            rsf = pstf.executeQuery();
            if (rsf.next()) {
                al.add(rsf.getString("AP"));
            } else {
                al.add("0");
            }
            rsg = pstg.executeQuery();
            if (rsg.next()) {
                al.add(rsg.getString("RE"));
            } else {
                al.add("0");
            }
            rsh = psth.executeQuery();
            if (rsh.next()) {
                al.add(rsh.getString("PE"));
            } else {
                al.add("0");
            }
            sqlConn.commit();
        } catch (SQLException ex) {
            try {
                sqlConn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rsa != null) {
                    rsa.close();
                }
                if (rsb != null) {
                    rsb.close();
                }
                if (rsc != null) {
                    rsc.close();
                }
                if (rsd != null) {
                    rsd.close();
                }
                if (rse != null) {
                    rse.close();
                }
                if (rsf != null) {
                    rsf.close();
                }
                if (rsg != null) {
                    rsg.close();
                }
                if (rsh != null) {
                    rsh.close();
                }

                if (psta != null) {
                    psta.close();
                }
                if (pstb != null) {
                    pstb.close();
                }
                if (pstc != null) {
                    pstc.close();
                }
                if (pstd != null) {
                    pstd.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (pstf != null) {
                    pstf.close();
                }
                if (pstg != null) {
                    pstg.close();
                }
                if (psth != null) {
                    psth.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return al;
    }

    public ArrayList<String> getRankSummary() {
        al = new ArrayList<String>();

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        ResultSet rsp = null;
        ResultSet rso = null;
        ResultSet rsn = null;
        ResultSet rsm = null;
        ResultSet rsl = null;
        ResultSet rsk = null;
        ResultSet rsj = null;
        ResultSet rsi = null;
        ResultSet rsh = null;
        ResultSet rsg = null;
        ResultSet rsf = null;
        ResultSet rse = null;
        ResultSet rsd = null;
        ResultSet rsc = null;
        ResultSet rsa = null;
        ResultSet rsb = null;

        PreparedStatement psta = null;
        PreparedStatement pstb = null;
        PreparedStatement pstc = null;
        PreparedStatement pstd = null;
        PreparedStatement pste = null;
        PreparedStatement pstf = null;
        PreparedStatement pstg = null;
        PreparedStatement psth = null;
        PreparedStatement psti = null;
        PreparedStatement pstj = null;
        PreparedStatement pstk = null;
        PreparedStatement pstl = null;
        PreparedStatement pstm = null;
        PreparedStatement pstn = null;
        PreparedStatement psto = null;
        PreparedStatement pstp = null;
        String sql1 = "SELECT count(id) AS 'MG'  from police_details where rank = 'Major General'";
        String sql2 = "SELECT count(id) AS 'SE'  from police_details where rank = 'Sergeant'";

        String sql3 = "SELECT count(id) AS 'GE'  from police_details where rank = 'General'";
        String sql4 = "SELECT count(id) AS 'LG'  from police_details where rank = 'Lt. General'";
        String sql5 = "SELECT count(id) AS 'BG'  from police_details where rank = 'Brigadier General'";
        String sql6 = "SELECT count(id) AS 'CO'  from police_details where rank = 'Colonel'";
        String sql7 = "SELECT count(id) AS 'LC'  from police_details where rank = 'Lt. Colonel'";
        String sql8 = "SELECT count(id) AS 'MA'  from police_details where rank = 'Major'";
        String sql9 = "SELECT count(id) AS 'CA'  from police_details where rank = 'Captain'";
        String sql10 = "SELECT count(id) AS 'LE'  from police_details where rank = 'Lieutenant'";
        String sql11 = "SELECT count(id) AS 'LT'  from police_details where rank = '2nd Lieutenant'";
        String sql12 = "SELECT count(id) AS 'WO'  from police_details where rank = 'Warrant Officer'";
        String sql13 = "SELECT count(id) AS 'SM'  from police_details where rank = 'Sergeant Major'";
        String sql14 = "SELECT count(id) AS 'CP'  from police_details where rank = 'Corporal'";
        String sql15 = "SELECT count(id) AS 'LP'  from police_details where rank = 'Lance Corporal'";
        String sql16 = "SELECT count(id) AS 'CT'  from police_details where rank = 'Constable'";

        try {
            sqlConn.setAutoCommit(false);

            psta = (PreparedStatement) sqlConn.prepareStatement(sql1);
            pstb = (PreparedStatement) sqlConn.prepareStatement(sql2);
            pstc = (PreparedStatement) sqlConn.prepareStatement(sql3);
            pstd = (PreparedStatement) sqlConn.prepareStatement(sql4);
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            pstf = (PreparedStatement) sqlConn.prepareStatement(sql6);
            pstg = (PreparedStatement) sqlConn.prepareStatement(sql7);
            psth = (PreparedStatement) sqlConn.prepareStatement(sql8);
            psti = (PreparedStatement) sqlConn.prepareStatement(sql9);
            pstj = (PreparedStatement) sqlConn.prepareStatement(sql10);
            pstk = (PreparedStatement) sqlConn.prepareStatement(sql11);
            pstl = (PreparedStatement) sqlConn.prepareStatement(sql12);
            pstm = (PreparedStatement) sqlConn.prepareStatement(sql13);
            pstn = (PreparedStatement) sqlConn.prepareStatement(sql14);
            psto = (PreparedStatement) sqlConn.prepareStatement(sql15);
            pstp = (PreparedStatement) sqlConn.prepareStatement(sql16);

            rsa = psta.executeQuery();
            if (rsa.next()) {
                al.add(rsa.getString("MG"));
            } else {
                al.add("0");
            }
            rsb = pstb.executeQuery();
            if (rsb.next()) {
                al.add(rsb.getString("SE"));
            } else {
                al.add("0");
            }
            rsc = pstc.executeQuery();
            if (rsc.next()) {
                al.add(rsc.getString("GE"));
            } else {
                al.add("0");
            }
            rsd = pstd.executeQuery();
            if (rsd.next()) {
                al.add(rsd.getString("LG"));

            } else {
                al.add("0");
            }
            rse = pste.executeQuery();
            if (rse.next()) {
                al.add(rse.getString("BG"));
            } else {
                al.add("0");
            }
            rsf = pstf.executeQuery();
            if (rsf.next()) {
                al.add(rsf.getString("CO"));
            } else {
                al.add("0");
            }
            rsg = pstg.executeQuery();
            if (rsg.next()) {
                al.add(rsg.getString("LC"));
            } else {
                al.add("0");
            }
            rsh = psth.executeQuery();
            if (rsh.next()) {
                al.add(rsh.getString("MA"));
            } else {
                al.add("0");
            }
            rsi = psti.executeQuery();
            if (rsi.next()) {
                al.add(rsi.getString("CA"));
            } else {
                al.add("0");
            }
            rsj = pstj.executeQuery();
            if (rsj.next()) {
                al.add(rsj.getString("LE"));
            } else {
                al.add("0");
            }
            rsk = pstk.executeQuery();
            if (rsk.next()) {
                al.add(rsk.getString("LT"));
            } else {
                al.add("0");
            }
            rsl = pstl.executeQuery();
            if (rsl.next()) {
                al.add(rsl.getString("WO"));
            } else {
                al.add("0");
            }
            rsm = pstm.executeQuery();
            if (rsm.next()) {
                al.add(rsm.getString("SM"));
            } else {
                al.add("0");
            }
            rsn = pstn.executeQuery();
            if (rsn.next()) {
                al.add(rsn.getString("CP"));
            } else {
                al.add("0");
            }
            rso = psto.executeQuery();
            if (rso.next()) {
                al.add(rso.getString("LP"));
            } else {
                al.add("0");
            }
            rsp = pstp.executeQuery();
            if (rsp.next()) {
                al.add(rsp.getString("CT"));
            } else {
                al.add("0");
            }
            sqlConn.commit();
        } catch (SQLException ex) {
            try {
                sqlConn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rsa != null) {
                    rsa.close();
                }
                if (rsb != null) {
                    rsb.close();
                }
                if (rsc != null) {
                    rsc.close();
                }
                if (rsd != null) {
                    rsd.close();
                }
                if (rse != null) {
                    rse.close();
                }
                if (rsf != null) {
                    rsf.close();
                }
                if (rsg != null) {
                    rsg.close();
                }
                if (rsh != null) {
                    rsh.close();
                }
                if (rsi != null) {
                    rsi.close();
                }
                if (rsj != null) {
                    rsj.close();
                }
                if (rsk != null) {
                    rsk.close();
                }
                if (rsl != null) {
                    rsl.close();
                }
                if (rsm != null) {
                    rsm.close();
                }
                if (rsn != null) {
                    rsn.close();
                }
                if (rso != null) {
                    rso.close();
                }
                if (rsp != null) {
                    rsp.close();
                }

                if (psta != null) {
                    psta.close();
                }
                if (pstb != null) {
                    pstb.close();
                }
                if (pstc != null) {
                    pstc.close();
                }
                if (pstd != null) {
                    pstd.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (pstf != null) {
                    pstf.close();
                }
                if (pstg != null) {
                    pstg.close();
                }
                if (psth != null) {
                    psth.close();
                }
                if (psti != null) {
                    psti.close();
                }
                if (pstj != null) {
                    pstj.close();
                }
                if (pstk != null) {
                    pstk.close();
                }
                if (pstl != null) {
                    pstl.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (pstn != null) {
                    pstn.close();
                }
                if (psto != null) {
                    psto.close();
                }
                if (pstp != null) {
                    pstp.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return al;
    }

    public ArrayList<String> getStateSummary() {
        al = new ArrayList<String>();

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();

        ResultSet rsn = null;
        ResultSet rsm = null;
        ResultSet rsl = null;
        ResultSet rsk = null;
        ResultSet rsj = null;
        ResultSet rsi = null;
        ResultSet rsh = null;
        ResultSet rsg = null;
        ResultSet rsf = null;
        ResultSet rse = null;
        ResultSet rsd = null;
        ResultSet rsc = null;
        ResultSet rsa = null;
        ResultSet rsb = null;

        PreparedStatement psta = null;
        PreparedStatement pstb = null;
        PreparedStatement pstc = null;
        PreparedStatement pstd = null;
        PreparedStatement pste = null;
        PreparedStatement pstf = null;
        PreparedStatement pstg = null;
        PreparedStatement psth = null;
        PreparedStatement psti = null;
        PreparedStatement pstj = null;
        PreparedStatement pstk = null;
        PreparedStatement pstl = null;
        PreparedStatement pstm = null;
        PreparedStatement pstn = null;

        String sql1 = "SELECT count(id) AS 'MG'  from police_details where state = 'Eastern Equatorial'";
        String sql2 = "SELECT count(id) AS 'SE'  from police_details where state = 'Western Equatorial'";

        String sql3 = "SELECT count(id) AS 'GE'  from police_details where state = 'Central Equatorial/Bahr el Jabal'";
        String sql4 = "SELECT count(id) AS 'LG'  from police_details where state = 'Lake State'";
        String sql5 = "SELECT count(id) AS 'BG'  from police_details where state = 'Blue Nile State'";
        String sql6 = "SELECT count(id) AS 'CO'  from police_details where state = 'Abyei Administrative State'";
        String sql7 = "SELECT count(id) AS 'LC'  from police_details where state = 'South Kordofan'";
        String sql8 = "SELECT count(id) AS 'MA'  from police_details where state = 'Upper Nile'";
        String sql9 = "SELECT count(id) AS 'CA'  from police_details where state = 'Western Bahr el-Gahazal'";
        String sql10 = "SELECT count(id) AS 'LE'  from police_details where state = 'Jonglei'";
        String sql11 = "SELECT count(id) AS 'LT'  from police_details where state = 'Warab'";
        String sql12 = "SELECT count(id) AS 'WO'  from police_details where state = 'North Bahr el-Ghazal'";
        String sql13 = "SELECT count(id) AS 'SM'  from police_details where state = 'Unity'";
        String sql14 = "SELECT count(id) AS 'CP'  from police_details where state = 'General Headquarter'";

        try {
            sqlConn.setAutoCommit(false);

            psta = (PreparedStatement) sqlConn.prepareStatement(sql1);
            pstb = (PreparedStatement) sqlConn.prepareStatement(sql2);
            pstc = (PreparedStatement) sqlConn.prepareStatement(sql3);
            pstd = (PreparedStatement) sqlConn.prepareStatement(sql4);
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            pstf = (PreparedStatement) sqlConn.prepareStatement(sql6);
            pstg = (PreparedStatement) sqlConn.prepareStatement(sql7);
            psth = (PreparedStatement) sqlConn.prepareStatement(sql8);
            psti = (PreparedStatement) sqlConn.prepareStatement(sql9);
            pstj = (PreparedStatement) sqlConn.prepareStatement(sql10);
            pstk = (PreparedStatement) sqlConn.prepareStatement(sql11);
            pstl = (PreparedStatement) sqlConn.prepareStatement(sql12);
            pstm = (PreparedStatement) sqlConn.prepareStatement(sql13);
            pstn = (PreparedStatement) sqlConn.prepareStatement(sql14);

            rsa = psta.executeQuery();
            if (rsa.next()) {
                al.add(rsa.getString("MG"));
            } else {
                al.add("0");
            }
            rsb = pstb.executeQuery();
            if (rsb.next()) {
                al.add(rsb.getString("SE"));
            } else {
                al.add("0");
            }
            rsc = pstc.executeQuery();
            if (rsc.next()) {
                al.add(rsc.getString("GE"));
            } else {
                al.add("0");
            }
            rsd = pstd.executeQuery();
            if (rsd.next()) {
                al.add(rsd.getString("LG"));

            } else {
                al.add("0");
            }
            rse = pste.executeQuery();
            if (rse.next()) {
                al.add(rse.getString("BG"));
            } else {
                al.add("0");
            }
            rsf = pstf.executeQuery();
            if (rsf.next()) {
                al.add(rsf.getString("CO"));
            } else {
                al.add("0");
            }
            rsg = pstg.executeQuery();
            if (rsg.next()) {
                al.add(rsg.getString("LC"));
            } else {
                al.add("0");
            }
            rsh = psth.executeQuery();
            if (rsh.next()) {
                al.add(rsh.getString("MA"));
            } else {
                al.add("0");
            }
            rsi = psti.executeQuery();
            if (rsi.next()) {
                al.add(rsi.getString("CA"));
            } else {
                al.add("0");
            }
            rsj = pstj.executeQuery();
            if (rsj.next()) {
                al.add(rsj.getString("LE"));
            } else {
                al.add("0");
            }
            rsk = pstk.executeQuery();
            if (rsk.next()) {
                al.add(rsk.getString("LT"));
            } else {
                al.add("0");
            }
            rsl = pstl.executeQuery();
            if (rsl.next()) {
                al.add(rsl.getString("WO"));
            } else {
                al.add("0");
            }
            rsm = pstm.executeQuery();
            if (rsm.next()) {
                al.add(rsm.getString("SM"));
            } else {
                al.add("0");
            }
            rsn = pstn.executeQuery();
            if (rsn.next()) {
                al.add(rsn.getString("CP"));
            } else {
                al.add("0");
            }
            sqlConn.commit();
        } catch (SQLException ex) {
            try {
                sqlConn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rsa != null) {
                    rsa.close();
                }
                if (rsb != null) {
                    rsb.close();
                }
                if (rsc != null) {
                    rsc.close();
                }
                if (rsd != null) {
                    rsd.close();
                }
                if (rse != null) {
                    rse.close();
                }
                if (rsf != null) {
                    rsf.close();
                }
                if (rsg != null) {
                    rsg.close();
                }
                if (rsh != null) {
                    rsh.close();
                }
                if (rsi != null) {
                    rsi.close();
                }
                if (rsj != null) {
                    rsj.close();
                }
                if (rsk != null) {
                    rsk.close();
                }
                if (rsl != null) {
                    rsl.close();
                }
                if (rsm != null) {
                    rsm.close();
                }
                if (rsn != null) {
                    rsn.close();
                }

                if (psta != null) {
                    psta.close();
                }
                if (pstb != null) {
                    pstb.close();
                }
                if (pstc != null) {
                    pstc.close();
                }
                if (pstd != null) {
                    pstd.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (pstf != null) {
                    pstf.close();
                }
                if (pstg != null) {
                    pstg.close();
                }
                if (psth != null) {
                    psth.close();
                }
                if (psti != null) {
                    psti.close();
                }
                if (pstj != null) {
                    pstj.close();
                }
                if (pstk != null) {
                    pstk.close();
                }
                if (pstl != null) {
                    pstl.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (pstn != null) {
                    pstn.close();
                }

                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return al;
    }

    public ArrayList<DataNewRequests> getNewRequests() {
        alm = new ArrayList<>();

        String sql = "SELECT \n"
                + "    application_no AS 'APPNO',\n"
                + "    first_name AS 'FIRSTNAME',\n"
                + "    last_name AS 'LASTNAME',\n"
                + "    operator_name AS 'OPNAME',\n"
                + "    job_position AS 'DESIGNATION',\n"
                + "    applicant_id AS 'APPID',\n"
                + "FROM\n"
                + "local_biocapture_manager\n"
                + "WHERE\n"
                + "bio_capture_status = 0;";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = (PreparedStatement) sqlConn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                // alm.add(new DataNewRequests(rs.getString("APPNO"), rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),rs.getString("OPNAME"),rs.getString("DESIGNATION"),rs.getString("APPID")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return alm;
    }

    public ArrayList<DataNewRequests> searchBioCaptureNow(String searchText) throws SQLException {
        alm = new ArrayList<>();
        String sql, sql1, textSearch;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Connection conn = null;
        ResultSet rs = null;
        conn = (Connection) DBConnect.ConnecrDb();

        Statement stmt = conn.createStatement();

        textSearch = (searchText.equals("")) ? "" : searchText;
        if (textSearch.equals("")) {
            sql1 = "SELECT application_no,first_name,last_name,operator_name,speciality,applicant_id FROM local_biocapture_manager WHERE bio_capture_status = 0";
            rs = stmt.executeQuery(sql1);
        } else {
            sql = "SELECT application_no,first_name,last_name,operator_name,speciality,applicant_id FROM local_biocapture_manager WHERE bio_capture_status = 0 AND first_name LIKE '" + textSearch + "' OR last_name  LIKE '" + textSearch + "' OR application_no  LIKE '" + textSearch + "' OR operator_name  LIKE '" + textSearch + "' OR applicant_id   LIKE '" + textSearch + "' OR speciality  LIKE '" + textSearch + "'";
            rs = stmt.executeQuery(sql);

        }
        try {

            while (rs.next()) {
                //alm.add(new DataNewRequests(rs.getString("application_no"), rs.getString("first_name"),rs.getString("last_name"),rs.getString("operator_name"),rs.getString("speciality"),rs.getString("applicant_id")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return alm;
    }

    public ArrayList<DataNewRequests> searchBioCaptureCompleted(String searchText) throws SQLException {
        alm = new ArrayList<>();
        String sql1, sql, textSearch;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //initialize parameters and set default
        textSearch = (searchText.equals("")) ? "" : searchText;
        Connection conn = null;
        ResultSet rs = null;
        conn = (Connection) DBConnect.ConnecrDb();

        Statement stmt = conn.createStatement();
        if (textSearch.equals("")) {
            sql1 = "SELECT application_no,first_name,last_name,operator_name,speciality,applicant_id FROM local_biocapture_manager WHERE bio_capture_status = 1";
            rs = stmt.executeQuery(sql1);
        } else {
            sql = "SELECT application_no,first_name,last_name,operator_name,speciality,applicant_id FROM local_biocapture_manager WHERE bio_capture_status = 1 AND first_name LIKE '" + textSearch + "' OR last_name  LIKE '" + textSearch + "' OR application_no  LIKE '" + textSearch + "' OR operator_name  LIKE '" + textSearch + "' OR applicant_id   LIKE '" + textSearch + "' OR speciality  LIKE '" + textSearch + "'";
            rs = stmt.executeQuery(sql);
        }

        try {

            while (rs.next()) {
                //alm.add(new DataNewRequests(rs.getString("application_no"), rs.getString("first_name"),rs.getString("last_name"),rs.getString("operator_name"),rs.getString("speciality"),rs.getString("applicant_id")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return alm;
    }

    public ArrayList<Staff> getAllStaffsUsers() {
        ArrayList<Staff> viewUser = new ArrayList<>();

        String sql5 = "SELECT firstname,lastname,employee_num,email,mobile,role,postal_address,zip_code,active_status FROM users";
        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;
        try {
            prepStatement = (PreparedStatement) sqlConn.prepareStatement(sql5);
            resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                viewUser.add(new Staff(
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("employee_num"),
                        resultSet.getString("email"),
                        resultSet.getString("mobile"),
                        resultSet.getString("role"),
                        resultSet.getString("postal_address"),
                        resultSet.getString("zip_code"),
                        resultSet.getString("active_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (prepStatement != null) {
                    prepStatement.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

    public ArrayList<Device> getAllDevices() {
        ArrayList<Device> viewUser = new ArrayList<>();

        String sql5 = "SELECT id,device_type,device_name,serial_number,driver_location,sdk_location,device_status,date_created FROM biometric_devices";

        DBConnect conn = new DBConnect();
        Connection sqlConn = (Connection) DBConnect.ConnecrDb();
        PreparedStatement pste = null;
        ResultSet rse = null;
        try {
            pste = (PreparedStatement) sqlConn.prepareStatement(sql5);
            rse = pste.executeQuery();
            while (rse.next()) {
                viewUser.add(new Device(
                        rse.getString("device_type"), rse.getString("device_name"), rse.getString("serial_number"),
                        rse.getString("driver_location"), rse.getString("sdk_location"), rse.getString("date_created"), rse.getString("device_status")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rse != null) {
                    rse.close();
                }
                if (pste != null) {
                    pste.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return viewUser;
    }

}
