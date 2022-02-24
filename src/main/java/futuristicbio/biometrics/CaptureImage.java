package futuristicbio.biometrics;



/*
  CaptureImage
  Captures a signature and creates encoded image file sig.png
  (an alternative signature image filename can be supplied as an argument)
  
  Copyright (c) 2015 Wacom GmbH. All rights reserved.
	
 */

import com.florentis.signature.SigCtl;
import com.florentis.signature.SigObj;
import com.florentis.signature.DynamicCapture;

public class CaptureImage {

    private String filename = "sig.png";
    private String applicantId;
    private String finalpath;

    public CaptureImage(String customerId) {

        this.applicantId = customerId;
        setNewDataPaths();
    }

    public void setNewDataPaths() {

        String path = null;
        try {
            String mypath = CaptureImage.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = java.net.URLDecoder.decode(mypath, "UTF-8");
            java.io.File jar = new java.io.File(decodedPath);
            path = jar.getParent();

            finalpath = path.concat("\\signatures");

        } catch (java.lang.Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void Run() {

        try {

            SigCtl sigCtl = new SigCtl();
            DynamicCapture dc = new DynamicCapture();
            int rc = dc.capture(sigCtl, "Display Name", "IDMS Biometric Capture-Sign here", null, null);
            if (rc == 0) {
                SigObj sig = sigCtl.signature();
                sig.extraData("AdditionalData", "CaptureImage.java Additional Data");
                int flags = SigObj.outputFilename | SigObj.color32BPP | SigObj.encodeData;
                sig.renderBitmap(finalpath + "\\" + applicantId.toString().concat(filename), 300, 150, "image/png", 0.5f, 0xff0000, 0xffffff, 0.0f, 0.0f, flags);
                System.out.println("Created Signature image file: " + applicantId.toString().concat(filename));
            } else {
                System.out.println("Capture returned: " + rc);
                switch (rc) {
                    case 1:
                        System.out.println("Cancelled");
                        break;
                    case 100:
                        System.out.println("Signature tablet not found");
                        break;
                    case 103:
                        System.out.println("Capture not licensed");
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
