package kimesh.hyperionDev.model;

public class Contact {

	// Contact variables
  private String contactNumber;
  private String emailAddress;

	// Constructor
  public Contact(String contactNumber, String emailAddress) {
    this.contactNumber = contactNumber;
    this.emailAddress = emailAddress;
  }

	// Getters and setters
  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

	// To String
  @Override
  public String toString() {
    return "\nContact Number: " + contactNumber + ", \nEmail Address: " + emailAddress;
  }


}
