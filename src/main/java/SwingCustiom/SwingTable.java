
package SwingCustiom;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;




public class SwingTable extends JTable{

    public SwingTable()  {
        setShowHorizontalLines(true);
        setRowHeight(40);
        setGridColor(new Color(230, 230, 230));
        getTableHeader().setReorderingAllowed(false);
        
        
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bin, boolean bin1, int i, int i1) {
                SwingTableHeader header = new SwingTableHeader(o +"");
               
                return header;
            }
            
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                
                Component comp =  super.getTableCellRendererComponent(table, o, isSelected, hasFocus, row, column);
                
                    comp.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if (isSelected) {
                        comp.setForeground(new Color(15, 89, 140));
                    }else {
                        comp.setForeground(new Color(102, 102, 102));
                    }
                    return comp;            
                 
            }
            
        });
        
    }
    public void addRow(Object[] row){
        DefaultTableModel model = (DefaultTableModel)getModel();
        model.addRow(row);
    }
}
