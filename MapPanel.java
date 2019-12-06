package WindowBuilder.views;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	
	
	public BufferedImage image;
	public int scale;
	
	public MapPanel(BufferedImage image, int scale) {
		super();
		this.image = image;
		this.scale = scale;
	}
	@Override	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, image.getWidth()*scale, image.getHeight()*scale, this);	
	}	
}
