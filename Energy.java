
public class Energy {

	private String price;
	private String duration;
	private String capacity;
	private String maintanceCost;
	private String range;
	
	Energy() {
		price = "10 k";
		capacity = "21 MW";
		maintanceCost = "0.01 k";
		range = "10";
		duration = "100%";
	}
	
	public void setPrice(String p) {
		price = p;
	}
	public void setCapacity(String p) {
		capacity = p;
	}
	public void setMaintanceCost(String p) {
		maintanceCost = p;
	}
	public void setRange(String p) {
		range = p;
	}
	public void setDuration(String p) {
		duration = p;
	}
	public String getPrice() {
		return price;
	}
	public String getCapacity() {
		return capacity;
	}
	public String getMaintanceCost() {
		return maintanceCost;
	}
	public String getRange() {
		return range;
	}
	public String getDuration() {
		return duration;
	}
	
	
	
}
