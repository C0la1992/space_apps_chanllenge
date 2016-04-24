import java.util.Vector;

public class Console {
	private Vector<Wall> wall = new Vector<Wall>();
	private Vector<Energy> energy = new Vector<Energy>();
	private Vector<Oxygen> oxygen = new Vector<Oxygen>();
	private Vector<Water> water = new Vector<Water>();
	private Vector<Food> food = new Vector<Food>();
	

	Console() {
	}
	public void buildWall() {
		Wall e = new Wall();
		wall.add(e);
	}
	public void buildEnergy() {
		Energy e = new Energy();
		energy.add(e);
	}
	public void buildOxygen() {
		Oxygen e = new Oxygen();
		oxygen.add(e);
	}
	public void buildWater() {
		Water e = new Water();
		water.add(e);
	}
	public void buildFood() {
		Food e = new Food();
		food.add(e);
	}
	
	public void build(int id) {
		switch (id) {
		case 1:
			buildWall();
			break;
		case 2:
			buildEnergy();
			break;
		case 3:
			buildOxygen();
			break;
		case 4:
			buildWater();
			break;
		case 5:
			buildFood();
			break;
		}
	}
	
	public String[] getWallInformationOf(int objId) {
		String[] info = new String[3];
		info[0] = wall.get(objId).getPrice();
		info[1] = wall.get(objId).getMaintanceCost();
		info[2] = wall.get(objId).getDuration();
		return info;
	}
	
	public String[] getEnergyInformationOf(int objId) {
		String[] info = new String[5];
		info[0] = energy.get(objId).getPrice();
		info[1] = energy.get(objId).getMaintanceCost();
		info[2] = energy.get(objId).getCapacity();
		info[3] = energy.get(objId).getDuration();
		info[4] = energy.get(objId).getRange();
		return info;
	}
	
	public String[] getOxygenInformationOf(int objId) {
		String[] info = new String[5];
		info[0] = oxygen.get(objId).getPrice();
		info[1] = oxygen.get(objId).getMaintanceCost();
		info[2] = oxygen.get(objId).getCapacity();
		info[3] = oxygen.get(objId).getDuration();
		info[4] = oxygen.get(objId).getRange();
		return info;
	}
	
	public String[] getWaterInformationOf(int objId) {
		String[] info = new String[5];
		info[0] = water.get(objId).getPrice();
		info[1] = water.get(objId).getMaintanceCost();
		info[2] = water.get(objId).getCapacity();
		info[3] = water.get(objId).getDuration();
		info[4] = water.get(objId).getRange();
		return info;
	}
	
	public String[] getFoodInformationOf(int objId) {
		String[] info = new String[5];
		info[0] = food.get(objId).getPrice();
		info[1] = food.get(objId).getMaintanceCost();
		info[2] = food.get(objId).getCapacity();
		info[3] = food.get(objId).getDuration();
		info[4] = food.get(objId).getRange();
		return info;
	}
	
	

}
