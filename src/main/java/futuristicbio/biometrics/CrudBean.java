/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Futuristic Ltd
 */
public class CrudBean {

//    public CrudBean {}
    public ArrayList<EnrollmentDetails> getPendingApplications() {

        ArrayList<EnrollmentDetails> pending = new ArrayList<>();

        String query = "SELECT police_idno,first_name,surname,position_held,rank,county,state,data_completion_status FROM police_details WHERE data_completion_status = 0";
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement prepared = null;

        try {
            conn = DBConnect.ConnecrDb();
            prepared = conn.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                pending.add(new EnrollmentDetails(result.getString("police_idno"), result.getString("first_name"), result.getString("surname"), result.getString("position_held"), result.getString("rank"), result.getString("county"), result.getString("state"), result.getString("data_completion_status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepared != null) {
                    prepared.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return pending;
    }

    public ArrayList<EnrollmentDetails> getBiometricApplications() {

        ArrayList<EnrollmentDetails> biometric = new ArrayList<>();

        String query = "SELECT police_idno,first_name,surname,position_held,rank,county,state,biocapture_status FROM police_details WHERE biocapture_status = 0 AND data_completion_status = 1";
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement prepared = null;

        try {
            conn = DBConnect.ConnecrDb();
            prepared = conn.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                biometric.add(new EnrollmentDetails(result.getString("police_idno"), result.getString("first_name"), result.getString("surname"), result.getString("position_held"), result.getString("rank"), result.getString("county"), result.getString("state"), result.getString("biocapture_status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepared != null) {
                    prepared.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return biometric;
    }

    public ArrayList<EnrollmentDetails> getCompleteEnrollment() {

        ArrayList<EnrollmentDetails> complete = new ArrayList<>();

        String query = "SELECT police_idno,first_name,surname,position_held,rank,county,state,enrollment_status FROM police_details WHERE enrollment_status = 1";
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement prepared = null;

        try {
            conn = DBConnect.ConnecrDb();
            prepared = conn.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                complete.add(new EnrollmentDetails(result.getString("police_idno"), result.getString("first_name"), result.getString("surname"), result.getString("position_held"), result.getString("rank"), result.getString("county"), result.getString("state"), result.getString("enrollment_status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepared != null) {
                    prepared.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return complete;
    }

    public ArrayList<EnrollmentDetails> getRenewalApplications() {

        ArrayList<EnrollmentDetails> renewal = new ArrayList<>();

        String query = "SELECT police_idno,first_name,surname,position_held,rank,county,state,enrollment_status FROM police_details WHERE enrollment_status = 1";
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement prepared = null;

        try {
            conn = DBConnect.ConnecrDb();
            prepared = conn.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                renewal.add(new EnrollmentDetails(result.getString("police_idno"), result.getString("first_name"), result.getString("surname"), result.getString("position_held"), result.getString("rank"), result.getString("county"), result.getString("state"), result.getString("enrollment_status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepared != null) {
                    prepared.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return renewal;
    }

    public ArrayList<EnrollmentDetails> getReissueApplications() {

        ArrayList<EnrollmentDetails> reissue = new ArrayList<>();

        String query = "SELECT police_idno,first_name,surname,position_held,rank,county,state,enrollment_status FROM police_details WHERE enrollment_status = 1";
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement prepared = null;

        try {
            conn = DBConnect.ConnecrDb();
            prepared = conn.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                reissue.add(new EnrollmentDetails(result.getString("police_idno"), result.getString("first_name"), result.getString("surname"), result.getString("position_held"), result.getString("rank"), result.getString("county"), result.getString("state"), result.getString("enrollment_status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepared != null) {
                    prepared.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return reissue;
    }

    public ArrayList<EnrollmentDetails> getSyncedBiometricApplications() {
          ArrayList<EnrollmentDetails> synced = new ArrayList<>();

        String query = "SELECT police_idno,first_name,surname,position_held,rank,county,state,biocapture_status FROM police_details WHERE biocapture_status = 0 AND data_completion_status = 1 ORDER BY registration_date DESC";
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement prepared = null;

        try {
            conn = DBConnect.ConnecrDb();
            prepared = conn.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                synced.add(new EnrollmentDetails(result.getString("police_idno"), result.getString("first_name"), result.getString("surname"), result.getString("position_held"), result.getString("rank"), result.getString("county"), result.getString("state"), result.getString("biocapture_status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepared != null) {
                    prepared.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return synced;
    
    }

}
