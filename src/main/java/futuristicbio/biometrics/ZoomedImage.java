package futuristicbio.biometrics;





import java.awt.*;
import java.awt.image.*;

import javax.swing.*;

public class ZoomedImage extends JPanel
{
	private static final long	serialVersionUID	= 1288351449724732696L;
	
	private BufferedImage m_o_Image;

	public ZoomedImage(BufferedImage img)
	{
		m_o_Image = img;
	}

	protected void paintComponent(Graphics g)
	{
		if( m_o_Image != null )
		{
            final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            final float ratioWidth = screenSize.width / 1280.f;
            final float ratioHeight = screenSize.height / 1024.f;
			int width = m_o_Image.getWidth();
			int height = m_o_Image.getHeight();
            final float finalRatioWidth  = ((float)width / (800.f * ratioWidth));
            final float finalRatioHeight = ((float)height / (800.f * ratioHeight));
			if (finalRatioWidth > 1)
			{
				width /= finalRatioWidth;
				height /= finalRatioWidth;
			}
			else if (finalRatioHeight > 1)
			{
				width /= finalRatioHeight;
				height /= finalRatioHeight;
			}
			
			g.drawImage( m_o_Image, (getWidth() - width) / 2, (getHeight() - height) / 2, width, height, null );
			g.dispose();
		}
	}
}
