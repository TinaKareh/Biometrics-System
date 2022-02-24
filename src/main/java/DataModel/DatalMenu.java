
package DataModel;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DatalMenu {

    public DatalMenu() {
    }
    
    
    
    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public MenuType getType() {
        return type;
    }

    
    public void setType(MenuType type) {
        this.type = type;
    }

    
    
    public DatalMenu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    
    
    private String icon;
    private String name;
    private MenuType type; 
    
    
    public Icon toIcon(){
         return new ImageIcon(getClass().getResource("/resources/UICons/" + icon + ".png"));
    }
    
    public static enum MenuType {
    TITLE, MENU, EMPTY
    }
}
