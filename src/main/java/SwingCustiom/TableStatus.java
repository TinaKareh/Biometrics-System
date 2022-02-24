
package SwingCustiom;



import DataModel.StatusType;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class TableStatus extends JLabel {

    
    public StatusType getType() {
            return type;
    }
    
    public TableStatus() {
        setForeground(Color.WHITE);
    }
    

    private StatusType type;


    
    
    public void setType(StatusType type) {
        this.type = type;
        
        //use if stmts if you want to display text with space or contains special chars, / capt
        if(type == StatusType.Capture){
            setText("Capture");
        }else if(type == StatusType.Reset){
            setText("Reset");
        }else if(type == StatusType.Edit){
              setText("Edit");
        }else if(type == StatusType.Activate){
                setText("Approve");
        }else if(type == StatusType.Deactivate){
                setText("Reject");
        }else if(type == StatusType.Reactivate){
            setText("Activate");
        }else if(type == StatusType.Continue){
            setText("Resume");
        }else if(type == StatusType.Renew){
            setText("Renew");
        }else if(type == StatusType.Reissue){
            setText("Reissue");
        }else{
        
        }
        repaint();
    }
    
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        if (type != null) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g;
            if (type == StatusType.PENDING) {
                g = new GradientPaint(0, 0, new Color(186, 123, 247), 0, getHeight(), new Color(167, 94, 236));
            } else if (type == StatusType.Reset) {
                g = new GradientPaint(0, 0, new Color(0,112,54), 0, getHeight(), new Color(0,112,54));
            } else if (type == StatusType.Activate) {
                
                g = new GradientPaint(0, 0, new Color(11,46,70), 0, getHeight(), new Color(11,46,70));
            }else if(type == StatusType.Deactivate){
                g = new GradientPaint(0, 0, new Color(0,112,54), 0, getHeight(), new Color(0,112,54));
            }else if(type == StatusType.Edit){
                g = new GradientPaint(0, 0, new Color(11,46,70), 0, getHeight(), new Color(11,46,70));
            }
            else if(type == StatusType.Reactivate){
                g = new GradientPaint(0, 0, new Color(11,46,70), 0, getHeight(), new Color(11,46,70));
            }
            
            else if (type == StatusType.NODATA) {
                g = new GradientPaint(0, 0, new Color(255, 255, 255), 0, getHeight(), new Color(255, 255, 255));
            } else {
                g = new GradientPaint(0, 0, new Color(11,46,70), 0, getHeight(), new Color(11,46,70));
            }
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 1, 1);
        }
        super.paintComponent(grphcs);
    }

//    @Override
//    protected void paintComponent(Graphics grphcs) {
//        if (type != null) {
//            Graphics2D g2 = (Graphics2D) grphcs;
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            GradientPaint g;
//            if (type == StatusType.PENDING) {
//                g = new GradientPaint(0, 0, new Color(186, 123, 247), 0, getHeight(), new Color(167, 94, 236));
//            } else if (type == StatusType.APPROVED) {
//                g = new GradientPaint(0, 0, new Color(142, 142, 250), 0, getHeight(), new Color(123, 123, 245));
//            } else if (type == StatusType.ViewProcess || type == StatusType.Activate) {
//                //this is green n color
//                g = new GradientPaint(0, 0, new Color(63,148,65), 0, getHeight(), new Color(63,148,65));
//                //g = new GradientPaint(0, 0, new Color(142, 142, 250), 0, getHeight(), new Color(123, 123, 245));
//            }else if (type == StatusType.Capture) {
//                //this is green n color
//                //g = new GradientPaint(0, 0, new Color(63,148,65), 0, getHeight(), new Color(63,148,65));
//                g = new GradientPaint(0, 0, new Color(142, 142, 250), 0, getHeight(), new Color(123, 123, 245));
//            }
//            else if(type == StatusType.Reset){
//                g = new GradientPaint(0, 0, new Color(235,52,52), 0, getHeight(), new Color(235,52,52));
//            }
//            else if (type == StatusType.Edit) {
//                //this is green n color //it picks this color but button text is not picking ok now i get you
//                g = new GradientPaint(0, 0, new Color(63,148,65), 0, getHeight(), new Color(63,148,65));
//                //g = new GradientPaint(0, 0, new Color(142, 142, 250), 0, getHeight(), new Color(123, 123, 245));
//            }
//            if (type == StatusType.Reactivate) {
//                g = new GradientPaint(0, 0, new Color(186, 123, 247), 0, getHeight(), new Color(167, 94, 236));
//            }
//            else if(type == StatusType.Deactivate){
//                //is this greeen
//                g = new GradientPaint(0, 0, new Color(235,52,52), 0, getHeight(), new Color(235,52,52));
//            }else if (type == StatusType.NODATA) {
//                g = new GradientPaint(0, 0, new Color(255, 255, 255), 0, getHeight(), new Color(255, 255, 255));
//            } else {
//                g = new GradientPaint(0, 0, new Color(63,148,65), 0, getHeight(), new Color(63,148,65));
//            }
//            g2.setPaint(g);
//            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 1, 1);
//        }
//        super.paintComponent(grphcs);
//    }
}