package futuristicbio.biometrics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author futadmin
 */
public class UserContext {
    
    private Integer userId;
    private String firstName;
    private String lastName;
    private String regionId;
    private String airport_airstrip_id;
    private String email;
    private String phone;
    private String role;
    private String postal_address;
    private String physical_address;
    private String zip_code;
    private String employee_num;

    public UserContext(Integer userId, String firstName, String lastName,String email,String phone,String role,String postal_address,String physical_address,String zip_code,String employee_num,String regionId, String airport_airstrip_id) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email =email;
        this.phone=phone;
        this.role=role;
        this.postal_address =postal_address;
        this.physical_address =physical_address;
        this.zip_code =zip_code;
        this.employee_num =employee_num;
        this.regionId = regionId;
        this.airport_airstrip_id = airport_airstrip_id;
    }
    
     public void setEmail(String email) {
        this.email = email;
    }
    
      public String getEmail() {
        return email;
    }
      
       public void setPhone(String phone) {
        this.phone = phone;
    }
    
      public String getPhone() {
        return phone;
    }
      
         public void setEmployee(String employee_num) {
        this.employee_num = employee_num;
    }
    
      public String getEmployee() {
        return employee_num;
    }
      
       public void setRole(String role) {
        this.role = role;
    }
    
      public String getRole() {
        return role;
    }
      
      public String getPostalAddress() {
        return postal_address;
    }

    public void setPostalAddress(String postal_address) {
        this.postal_address = postal_address;
    }
    
    public String getPhysicalAddress() {
        return physical_address;
    }

    public void setPhysicalAddress(String physical_address) {
        this.physical_address = physical_address;
    }
    
    public String getZipCode() {
        return zip_code;
    }

    public void setZipCode(String zip_code) {
        this.zip_code = zip_code;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
      public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAirport_airstrip_id() {
        return airport_airstrip_id;
    }

    public void setAirport_airstrip_id(String airport_airstrip_id) {
        this.airport_airstrip_id = airport_airstrip_id;
    }

      
}
