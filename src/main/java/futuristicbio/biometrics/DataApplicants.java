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
public class DataApplicants {

    private String registration_number, first_name, middle_name, surname, rank, state, county, biocapture_status;

    public DataApplicants(String registration_number, String first_name, String middle_name, String surname, String rank, String state, String county, String biocapture_status) {
        this.registration_number = registration_number;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.surname = surname;
        this.rank = rank;
        this.state = state;
        this.county = county;
        this.biocapture_status = biocapture_status;
    }

    public String getpermitNo() {
        return registration_number;
    }

    public void setpermitNo(String application_no) {
        this.registration_number = application_no;
    }

    public String getfirstName() {
        return first_name;
    }

    public void setfirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getlastName() {
        return middle_name;
    }

    public void setlastName(String lastName) {
        this.middle_name = lastName;
    }

    public String getoperator() {
        return surname;
    }

    public void setoperator(String biocapture_type) {
        this.surname = biocapture_type;
    }

    public String getspeciality() {
        return rank;
    }

    public void setspeciality(String job_position) {
        this.rank = job_position;
    }

    public String getapplicant_id() {
        return state;
    }

    public void setapplicant_id(String applicant_id) {
        this.state = applicant_id;
    }

    public String getreaddate() {
        return county;
    }

    public void setreaddate(String readdate) {
        this.county = readdate;
    }

    public String getbio_capture_status() {
        return biocapture_status;
    }

    public void setbio_capture_status(String bio_capture_status) {
        this.biocapture_status = bio_capture_status;
    }
}
