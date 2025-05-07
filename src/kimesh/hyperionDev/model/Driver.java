package kimesh.hyperionDev.model;

public class Driver {

	// Driver variables
  private String driverName;
  private String cityName;
  private int deliveries;

	// Constructor
  public Driver(String driverName, String cityName, int deliveries) {
    this.driverName = driverName;
    this.cityName = cityName;
    this.deliveries = deliveries;
  }

	// Getters and setters
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

	// To String
  @Override
  public String toString() {
    return "Driver - \nDriver Name: " + driverName + ", \nCity Name: " + cityName + ", \nDeliveries: " + deliveries + "\n";
  }


}
