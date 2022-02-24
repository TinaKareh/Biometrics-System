
package SwingCustiom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class SwingTableHeader extends JLabel{

    public SwingTableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(255,255,255));
        setFont(new Font("Sogue UI", 1, 14));
        setForeground(new Color(0,0,0));
        setBorder(new EmptyBorder(10,5,10,5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(230, 230, 230));
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
    
    
    
}
