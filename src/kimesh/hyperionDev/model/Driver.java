package kimesh.hyperionDev.model;

public class Driver {
	
	private String driverName;
	private String cityName;
	private int deliveries;
	
	public Driver(String driverName, String cityName, int deliveries) {
		this.driverName = driverName;
		this.cityName = cityName;
		this.deliveries = deliveries;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(int deliveries) {
		this.deliveries = deliveries;
	}

	@Override
	public String toString() {
		return "Driver - \nDriver Name: " + driverName + ", \nCity Name: " + cityName + ", \nDeliveries: " + deliveries + "\n";
	}
	
	
}
