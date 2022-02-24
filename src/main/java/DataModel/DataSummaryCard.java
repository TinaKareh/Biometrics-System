
package DataModel;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class DataSummaryCard {
    
    private String category, value;
    private Icon icon;

    public DataSummaryCard(String category, String value, Icon icon) {
        this.category = category;
        this.value = value;
        this.icon = icon;
    }

    public DataSummaryCard() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
