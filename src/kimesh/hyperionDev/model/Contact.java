package kimesh.hyperionDev.model;

public class Contact {

	private String contactNumber;
	private String emailAddress;
	
	public Contact(String contactNumber, String emailAddress) {
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
	}

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

	@Override
	public String toString() {
		return "\nContact Number: " + contactNumber + ", \nEmail Address: " + emailAddress;
	}
	
	
}
