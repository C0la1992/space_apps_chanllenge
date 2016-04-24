public class Oxygen {

	private String price;

	private String duration;

	private String capacity;

	private String maintanceCost;

	private String range;

	private String purity;

	Oxygen() {

		price = "50 k";

		capacity = "50 L";

		maintanceCost = "0.05 k";

		range = "40";

		duration = "100%";

		purity = "100%";

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

	public void setPurity(String p) {

		purity = p;

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

	public String getPurity() {

		return purity;

	}

}