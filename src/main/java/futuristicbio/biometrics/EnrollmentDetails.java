/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuristicbio.biometrics;

/**
 *
 * @author Futuristic Ltd
 */
public class EnrollmentDetails {

    private String police_id;
    private String first_name;
    private String surname;
    private String position_held;
    private String rank;
    private String county;
    private String state;
    private String status;

    public EnrollmentDetails(String police,String first_name,String surname,String position,String rank,String county, String state,String status) {
        this.police_id = police;
        this.first_name = first_name;
        this.surname = surname;
        this.position_held = position;
        this.rank = rank;
        this.county = county;
        this.state = state;
        this.status = status;
    }

    public String getPoliceId() {
        return police_id;
    }

    public void setPoliceId(String police) {
        this.police_id = police;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position_held;
    }

    public void setPosition(String position) {
        this.position_held = position;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
    
    public String getState(){
     return state;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
}
