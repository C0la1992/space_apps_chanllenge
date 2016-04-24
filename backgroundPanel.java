import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class backgroundPanel extends JPanel {

	     public void paintComponent(Graphics g)
	     {
	        int x=0,y=0;
	        java.net.URL imgURL=getClass().getResource("background.jpg");
	        ImageIcon icon=new ImageIcon(imgURL);
	        g.drawImage(icon.getImage(),x,y,getSize().width,getSize().height,this);

	     }
	   
}
