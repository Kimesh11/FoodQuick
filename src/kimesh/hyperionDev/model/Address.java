package kimesh.hyperionDev.model;

public class Address {

  // Address variables
  private String streetName;
  private String cityName;
  private int postalCode;

  // Constructor
  public Address(String streetName, String cityName, int postalCode) {
    this.streetName = streetName;
    this.cityName = cityName;
    this.postalCode = postalCode;
  }

  // Getters and setters
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

  // To String
  @Override
  public String toString() {
    return "\nStreet Name: " + streetName + ", \nCity Name: " + cityName + ", \nPostal Code: " + postalCode;
  }


}
