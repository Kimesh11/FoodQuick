package kimesh.hyperionDev.impl;

import java.io.FileWriter;
import java.io.IOException;

import kimesh.hyperionDev.model.Customer;
import kimesh.hyperionDev.model.Driver;
import kimesh.hyperionDev.model.Invoice;
import kimesh.hyperionDev.model.Order;
import kimesh.hyperionDev.model.Restaurant;

public class InvoiceImpl {

  // Creates an Invoice.
  public static Invoice createInvoice(Customer customerDetails, Restaurant restaurantDetails, Driver driverDetails,
                                      Order orderDetails, double totalAmountToBePaid) {
    return new Invoice(customerDetails, restaurantDetails, driverDetails, orderDetails, totalAmountToBePaid);
  }

  // Prints the invoice.
  public static void printInvoiceReceipt(Customer customerDetails, Restaurant restaurantDetails, Driver driverDetails,
                                         Order orderDetails, double totalAmountToBePaid) {
    //creates an invoice.txt file.
    try (FileWriter fw = new FileWriter("src/resources/invoice.txt")) {
      String orderSummary = String.format(
              "Order No. %s%n" +
                      "Customer Name: %s%n" +
                      "Customer Email: %s%n" +
                      "Customer Contact: %s%n" +
                      "Customer Location: %s%n" +
                      "Your order from %s in %s:%n%s%n" +
                      "Preparation Instructions: %s%n" +
                      "Total Due: R%.2f%n" +
                      "%s is the nearest to the restaurant you ordered from. He/She will be delivering your order to:%n" +
                      "%s%n%s%n%s%n" +
                      "If you need to contact the restaurant, their contact is %s.",
              orderDetails.getOrderNumber(),
              customerDetails.getCustomerName(),
              customerDetails.getContact().getEmailAddress(),
              customerDetails.getContact().getContactNumber(),
              customerDetails.getAddress().getCityName(),
              restaurantDetails.getRestautantName(),
              restaurantDetails.getAddress().getCityName(),
              restaurantDetails.getListOfMeals().toString(),
              orderDetails.getPreparationInstructions(),
              totalAmountToBePaid,
              driverDetails.getDriverName(),
              customerDetails.getAddress().getStreetName(),
              customerDetails.getAddress().getCityName(),
              customerDetails.getAddress().getPostalCode(),
              restaurantDetails.getContact().getContactNumber()
      );
      // Writes the order summary to the file with all the invoice information.
      fw.write(orderSummary);
      System.out.println("Your invoice has been saved to 'src/resources/invoice.txt' and sent to "
              + customerDetails.getContact().getEmailAddress());
    } catch (IOException e) {
      System.out.println("Failed to write the invoice. Please check if the 'src/resources/' " +
              "folder exists and is writable.");
    }
  }
}
