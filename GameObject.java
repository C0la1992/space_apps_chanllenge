import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameObject extends JPanel {
	private int objId;
	private int ID;
	private int ID_x;
	private int ID_y;
	private int spaceSizeX;
	private int spaceSizeY;
	private String image = "";
	
	GameObject() { }
	GameObject(String img){ 
		image = img;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void paintComponent(Graphics g)
    {
       int x=0,y=0;
       java.net.URL imgURL=getClass().getResource(image);
       ImageIcon icon=new ImageIcon(imgURL);
       g.drawImage(icon.getImage(),x,y,getSize().width,getSize().height,this);
    }
	
	public void copyFromGameObject(GameObject obj) {
		ID = obj.getID();
		ID_x = obj.getIDX();
		ID_y = obj.getIDY();
		spaceSizeX = obj.getSpaceSize().x;
		spaceSizeY = obj.getSpaceSize().y;
		this.setSize(obj.getSize());
		this.setLocation(obj.getLocation());
		this.setBackground(obj.getBackground());
		this.setImage(obj.getImage());
	}
	
	public void setIDXY(int x, int y) {
		ID_x = x;
		ID_y = y;
	}
	
	public int getIDX() {
		return ID_x;
	}
	
	public int getIDY() {
		return ID_y;
	}
	
	
	public void setID(int id) {
		ID = id;
	}
	public int getID() {
		return ID;
	}
	public void setSpaceSize(int x, int y) {
		spaceSizeX = x;
		spaceSizeY = y;
	}
	public Point getSpaceSize() {
		Point p = new Point(spaceSizeX, spaceSizeY);
		return p;
	}
	public void setObjId(int id) {
		this.objId = id;
	}
}
