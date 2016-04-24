import javax.swing.JButton;

public class spaceButton extends JButton {
	private int width = 100;
	private int height = 50;
	private int ID;
	
	spaceButton() {
		this.setSize(width, height);
		
	}
	
	spaceButton(String s) {
		this.setSize(width, height);
		this.setText(s);
	}
	
	public void setID(int id) {
		ID = id;
	}
	
	public int getID() {
		return ID;
	}
}
