public class Food {

	private String price;

	private String duration;

	private String capacity;

	private String maintanceCost;

	private String range;

	private String quality;

	Food() {

		price = "100 k";

		capacity = "5 ton";

		maintanceCost = "0.1 k";

		range = "20";

		duration = "100%";

		quality = "100%";

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

	public void setQuality(String p) {

		quality = p;

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

	public String getQuality() {

		return quality;

	}

}