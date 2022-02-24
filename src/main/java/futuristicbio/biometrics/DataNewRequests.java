/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

/**
 *
 * @author kimel
 */
public class DataNewRequests {
    private String application_no, first_name,last_name, operator_name,speciality , applicant_id,county;

    public DataNewRequests(String application_no, String first_name, String last_name, String operator_name,String speciality, String applicant_id,String county) {
        this.application_no = application_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.operator_name = operator_name;
        this.speciality = speciality;
        this.applicant_id = applicant_id;
        this.county = county;
    }

    public String getpermitNo() {
        return application_no;
    }

    public void setpermitNo(String application_no) {
        this.application_no = application_no;
    }

    public String getfirstName() {
        return first_name;
    }

    public void setfirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getlastName() {
        return last_name;
    }

    public void setlastName(String lastName) {
        this.last_name = lastName;
    }

    public String getoperator() {
        return operator_name;
    }

    public void setoperator(String operator) {
        this.operator_name = operator;
    }

    public String getspeciality() {
        return speciality;
    }

    public void setspeciality(String job_position) {
        this.speciality = job_position;
    }
    public String getapplicant_id() {
        return applicant_id;
    }

    public void setapplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }
     public String getcounty() {
        return county;
    }

    public void setcounty(String county) {
        this.county = county;
    }
    
    
    

}
