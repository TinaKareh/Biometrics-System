
package SwingCustiom;

import DataModel.DatalMenu;
import Fragments.FragmentMenuItem;
import event.EventMenuSelected;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;


public class SwngListMenu<E extends Object> extends JList<E>{
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
    }
    

    public SwngListMenu() {

        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof DatalMenu) {
                        DatalMenu menu = (DatalMenu)o;
                        if (menu.getType() == DatalMenu.MenuType.TITLE) {
                            selectedIndex = index;
                            
                            if(event != null){
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
            
        });
        
        
    }


    
    
@Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean selected, boolean focus) {
                DatalMenu data;
                if (o instanceof DatalMenu) {
                    data = (DatalMenu)o;
                    
                } else {
                    data = new DatalMenu("", o +"", DatalMenu.MenuType.EMPTY);
                }
                FragmentMenuItem item = new FragmentMenuItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }
            
        };
    }
   public void addItem(DatalMenu data){
   model.addElement(data);}
    
}