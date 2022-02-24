/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Futuristic Ltd
 */
public class DataRankSummary {
     private String category;
    private Icon icon;
    private ArrayList<String> value = new ArrayList<String>();

    public DataRankSummary(String category, ArrayList<String> value, Icon icon) {
        this.category = category;
        this.value = value;
        this.icon = icon;
    }

    public DataRankSummary() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getValue() {
        return value;
    }

    public void setValue(ArrayList<String> value) {
        this.value = value;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
    
    public Icon toIcon(){
         return new ImageIcon(getClass().getResource("/UICons/" + icon + ".png"));
    } 
}
