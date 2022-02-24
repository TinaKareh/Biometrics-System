package futuristicbio.biometrics;



 public class User {

  
    private String application_no, first_name,last_name, biocapture_type,speciality , applicant_id,readdate,biocapture_status;

   
    public User(String application_no, String first_name, String last_name, String biocapture_type,String job_position, String applicant_id,String readdate,String biocapture_status) {
        this.application_no = application_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.biocapture_type = biocapture_type;
        this.speciality = job_position;
        this.applicant_id = applicant_id;
        this.readdate = readdate;
        this.biocapture_status =biocapture_status;
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
        return biocapture_type;
    }

    public void setoperator(String biocapture_type) {
        this.biocapture_type = biocapture_type;
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
    public String getreaddate() {
        return readdate;
    }

    public void setreaddate(String readdate) {
        this.readdate = readdate;
    }
    
     public String getbiocapture_status() {
        return biocapture_status;
    }

    public void setbiocapture_status(String biocapture_status) {
        this.biocapture_status = biocapture_status;
    }
}
