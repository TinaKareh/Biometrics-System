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
public class Device {
    
    //public String id;

    /*private final String device_type;
    private final String device_name;
    private final String serial_number;
    private final String driver_location;
    private final String sdk_location;
    private final String device_status;
    private final String date_created;*/
    private String device_type;
    private String device_name;
    private String serial_number;
    private String driver_location;
    private String sdk_location;
    private String date_created;
    private String device_status;
    
    
   
    public Device(
            String device_type, String device_name,String serial_number, String driver_location,
            String sdk_location,String date_created, String device_status){
        

        //this.id = id;
        this.device_type = device_type;
        this.device_name = device_name;
        this.serial_number=serial_number;
        this.driver_location = driver_location;
        this.sdk_location = sdk_location;
        this.date_created=date_created;
        this.device_status = device_status;
        
    }

    /*public String getid() {
        return id;
    }
    public void setid(String id) {
        this.id = id;
    }*/

    public String getdevice_type() {
        return device_type;
    }
    public void setdevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getdevice_name() {
        return device_name;
    }
    public void setdevice_name(String device_name) {
        this.device_name = device_name;
    }
    public String getserial_number() {
        return serial_number;
    }
    public void setserial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getdriver_location() {
        return driver_location;
    }
    public void setdriver_location(String driver_location) {
        this.driver_location = driver_location;
    }

    public String getsdk_location() {
        return sdk_location;
    }
    public void setsdk_location(String sdk_location) {
        this.sdk_location = sdk_location;
    }
    public String getdate_created() {
        return date_created;
    }
    public void setdate_created(String date_created) {
        this.date_created = date_created;
    }
    
    public String getdevice_status() {
      
        return device_status;
    }
    public void setdevice_status(String device_status) {
        this.device_status = device_status;
    }

    
   

   /* @Override
    public String toString() {
        return "Device{" +"device_type=" + device_type + ", device_name=" + device_name + ", serial_number=" + serial_number + ", driver_location=" + driver_location + ", sdk_location=" + sdk_location + ", device_status=" + device_status + ", date_created=" + date_created + '}';
    }*/
    
    
    
}
