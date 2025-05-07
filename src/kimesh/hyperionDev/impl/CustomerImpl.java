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
    System.out.println("Welcome to Order here, deliver there by Food Quick.");
    System.out.println("Please enter the necessary details in order for us to continue.");

    // Customer name
    String customerName;
    while (true) {
      System.out.print("Please enter your name: ");
      customerName = scanner.nextLine();
      if (!customerName.isBlank()) {
        break;
      }
      System.out.println("Customer name cannot be blank.");
    }

    // Street name
    String streetName;
    while (true) {
      System.out.print("Please enter your street name: ");
      streetName = scanner.nextLine();
      if (!streetName.isBlank()) {
        break;
      }
      System.out.println("Street name cannot be blank.");
    }

    // City name
    String cityName;
    while (true) {
      System.out.print("Please enter your city: ");
      cityName = scanner.nextLine();
      if (!cityName.isBlank()) {
        break;
      }
      System.out.println("City name cannot be blank.");
    }

    // Postalcode
    int postalCode;
    while (true) {
      System.out.print("Please enter your postal code (4 digits): ");
      try {
        postalCode = Integer.parseInt(scanner.nextLine());
        if (String.valueOf(postalCode).length() == 4) {
          break;
        } else {
          System.out.println("Postal code must be 4 digits.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Please enter numbers only.");
      }
    }

    // Contact number
    String contactNumber;
    while (true) {
      System.out.print("Please enter your contact number: ");
      contactNumber = scanner.nextLine();
      if (contactNumber.matches("\\d{10}")) {
        break;
      }
      System.out.println("Contact number must be exactly 10 digits.");
    }

    // Email address
    String emailAddress;
    while (true) {
      System.out.print("Please enter your email address: ");
      emailAddress = scanner.nextLine();
      if (!emailAddress.isBlank() &&
              emailAddress.contains("@") &&
              (emailAddress.endsWith(".com") || emailAddress.endsWith(".co.za"))) {
        break;
      }
      System.out.println("Please enter a valid email (e.g., example@domain.com or .co.za).");
    }

    return createCustomer(
            customerName,
            contactNumber,
            emailAddress,
            streetName,
            cityName,
            postalCode
    );
  }
}
