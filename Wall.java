public class Wall {

	private String price;

	private String duration;

	private String maintanceCost;

	Wall() {

		price = "1 k";

		maintanceCost = "0.0001 k";

		duration = "100%";

	}

	public void setPrice(String p) {

		price = p;

	}

	public void setMaintanceCost(String p) {

		maintanceCost = p;

	}

	public void setDuration(String p) {

		duration = p;

	}

	public String getPrice() {

		return price;

	}

	public String getMaintanceCost() {

		return maintanceCost;

	}

	public String getDuration() {

		return duration;

	}

}