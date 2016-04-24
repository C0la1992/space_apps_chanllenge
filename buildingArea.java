import java.awt.Color;

import javax.swing.JPanel;

public class buildingArea extends JPanel{

	private int width = 1000;
	private int height = 1000;
	private Color bgColor = Color.GRAY;
	
	buildingArea() {
		this.setSize(width, height);
		this.setLocation(0, 0);
		this.setBackground(bgColor);
	}
}
