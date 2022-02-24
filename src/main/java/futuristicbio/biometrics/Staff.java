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
public class Staff {
    
    public String firstname;

    private String lastname;
    private String employee_num;
    private String postal_address;
    private String mobile;
    private String email;
    private String zip_code;
    private String username;
    private String active_status;

    public Staff(String firstname, String lastname,
            String employee_num,String email, String mobile, String username,String postal_address,
             String zip_code, String active_status){
        this.firstname = firstname;

        this.lastname = lastname;
        this.employee_num = employee_num;
        this.email = email;
        this.mobile = mobile;
        this.username=username;
        this.postal_address = postal_address;
        this.zip_code = zip_code;
        this.active_status=active_status;
    }

    public String getfirstname() {
        return firstname;
    }
    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }
    public void setlastname(String lastname) {
        this.lastname = lastname;
    }
    
     public String getemployee_num() {
        return employee_num;
    }
      public String setemployee_num(String employee_num) {
        return employee_num;
    }

    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getmobile() {
      
        return mobile;
    }
    public void setmobile(String mobile) {
        this.mobile = mobile;
    }
    public String getusername() {
        return username;
    }
    public void setusername(String username) {
        this.username = username;
    }

    public String getpostal_address() {
        return postal_address;
    }
    public void setpostal_address(String postal_address) {
        this.postal_address = postal_address;
    }
    
   
    public String getzip_code() {
        return zip_code;
    }
    public void setzip_code(String zip_code) {
        this.zip_code = zip_code;
    }
    public String getactive_status() {
      
        return active_status;
    }
    public void setactive_status(String active_status) {
        this.active_status = active_status;
    }

   /* @Override
    public String toString() {
        return "Staff{" + "firstname=" + firstname + ", employee_num=" + employee_num + ", lastname=" + lastname + ", username=" + username + ", zip_code=" + zip_code + ", email=" + email + ", postal_address=" + postal_address + ", mobile=" + mobile + ", active_status=" + active_status +'}';
    }*/
    
    
}
