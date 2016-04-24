import java.awt.Color;

import javax.swing.JPanel;

public class menuPanel extends JPanel {
	private Color bgColor = Color.cyan;
	private int width = 400;
	private int height = 1000;
	private spaceButton btn1 = new spaceButton(" 1 * 1 ");
	private spaceButton btn2 = new spaceButton(" 1 * 2 ");
	private spaceButton btn3 = new spaceButton(" 2 * 2 ");
	private spaceButton btn4 = new spaceButton(" 3 * 3 ");
	private spaceButton btn5 = new spaceButton(" 2 * 4 ");
	
	menuPanel() {
		this.setSize(width, height);
		this.setLayout(null);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		btn1.setLocation(10, 10);
		btn2.setLocation(10, 70);
		btn3.setLocation(10, 130);
		btn4.setLocation(10, 190);
		btn5.setLocation(10, 250);
	}
}
