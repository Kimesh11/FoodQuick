package kimesh.hyperionDev.model;

public class Address {
	
	private String streetName;
	private String cityName;
	private int postalCode;
	
	public Address(String streetName, String cityName, int postalCode) {
		this.streetName = streetName;
		this.cityName = cityName;
		this.postalCode = postalCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "\nStreet Name: " + streetName + ", \nCity Name: " + cityName + ", \nPostal Code: " + postalCode;
	}
	
	
}
