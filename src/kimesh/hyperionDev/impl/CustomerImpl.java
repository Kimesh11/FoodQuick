package kimesh.hyperionDev.impl;

import java.util.Scanner;

import kimesh.hyperionDev.model.Address;
import kimesh.hyperionDev.model.Contact;
import kimesh.hyperionDev.model.Customer;

public class CustomerImpl {

  // Creates the customer object.
  public static Customer createCustomer(String customerName, String contactNumber,
      String emailAddress, String street, String city, int postalCode) {
    Contact contact = new Contact(contactNumber, emailAddress);
    Address address = new Address(street, city, postalCode);
    return new Customer(customerName, contact, address);
  }

  // Captures the customer input and creates a customer object.
  public static Customer captureCustomerInput(Scanner scanner) {
    System.out.print("Welcome to Order here, deliver there"
        + "\nPlease enter the necessary details in order for us to continue\nPlease enter your name:");
    String customerName = scanner.nextLine();

    System.out.print("Please enter your street name: ");
    String streetName = scanner.nextLine();

    System.out.print("Please enter your city: ");
    String cityName = scanner.nextLine();

    System.out.print("Please enter your postal code: ");
    int postalCode = scanner.nextInt();
    scanner.nextLine(); // Consume the leftover newline

    System.out.print("Please enter your contact number: ");
    String contactNumber = scanner.nextLine();

    System.out.print("Please enter your email address: ");
    String emailAddress = scanner.nextLine();

    return createCustomer(customerName, contactNumber, emailAddress, streetName, cityName,
        postalCode);
  }
}
