package futuristicbio.biometrics;



public class Reports {

    public String othernames;

    private final String passportNo;
    private final String fileR;
    private final String id;
    private final String presentNationality;
    private final String permitClassId;
    private final String dateOfIssue;

    public Reports(String othernames, String passportNo,
            String fileR, String id, String presentNationality,
            String permitclassId, String dateOfIssue){
        this.othernames = othernames;

        this.passportNo = passportNo;
        this.fileR = fileR;
        this.id = id;
        this.presentNationality = presentNationality;
        this.dateOfIssue = dateOfIssue;
        this.permitClassId = permitclassId;
    }

    public String getothernames() {
        return othernames;
    }

    public String getpassportNo() {
        return passportNo;
    }

    public String getpresentNationality() {
        return presentNationality;
    }

    public String getPermitClassId() {
        return permitClassId;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }
   
    public String getfileR() {
      
        return fileR;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Reports{" + "othernames=" + othernames + ", passportNo=" + passportNo + ", fileR=" + fileR + ", id=" + id + ", presentNationality=" + presentNationality + ", permitClassId=" + permitClassId + ", dateOfIssue=" + dateOfIssue + '}';
    }
    
    

}
