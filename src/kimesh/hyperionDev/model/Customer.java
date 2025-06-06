package kimesh.hyperionDev.model;

public class Customer {

	// Customer variables
  private String customerName;
  private Contact contact;
  private Address address;

	// Constructor
  public Customer(String customerName, Contact contact, Address address) {
    super();
    this.customerName = customerName;
    this.contact = contact;
    this.address = address;
  }

	// Getters and setters
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

	// To String
  @Override
  public String toString() {
    return "Customer - \nCustomer Name: " + customerName + ", \nContact - " + contact + ", \nAddress - " + address;
  }
}
