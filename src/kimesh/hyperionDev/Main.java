package kimesh.hyperionDev;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import kimesh.hyperionDev.enums.Status;
import kimesh.hyperionDev.impl.CustomerImpl;
import kimesh.hyperionDev.impl.DriverImpl;
import kimesh.hyperionDev.impl.InvoiceImpl;
import kimesh.hyperionDev.impl.OrderImpl;
import kimesh.hyperionDev.impl.RestaurantImpl;
import kimesh.hyperionDev.model.Customer;
import kimesh.hyperionDev.model.Driver;
import kimesh.hyperionDev.model.Invoice;
import kimesh.hyperionDev.model.Meal;
import kimesh.hyperionDev.model.Order;
import kimesh.hyperionDev.model.Restaurant;

public class Main {

  public static void main(String[] args) {
    // Creating Scanner.
    Scanner scanner = new Scanner(System.in);

    // Capturing customer input.
    Customer customer = CustomerImpl.captureCustomerInput(scanner);

    // Capturing restaurant input.
    Restaurant restaurant = RestaurantImpl.captureRestaurantInput(scanner);

    // Initializing meals list.
    List<Meal> mealsBeingOrdered = new ArrayList<>();

    // Displaying meals that are available in the restaurant.
    System.out.println("Available meals at the restaurant");
    for (int i = 0; i < restaurant.getListOfMeals().size(); i++) {
      Meal meal = restaurant.getListOfMeals().get(i);
      System.out.println((i + 1) + ". " + meal.getMealName() + " - " + meal.getDescription() + "\nR"
              + meal.getPrice());
    }

    // Initializing variables.
    boolean orderingFood = true;
    double totalAmount = 0;

    // Allows customer to input the amount of meals they would like to order. Adds up the total
    // amount and displays the ordered meals.
    while (orderingFood) {
      System.out.println("Please enter the number of the meal you'd like to purchase " +
              "(or 0 to finish order).");
      int mealsToOrder = scanner.nextInt();
      scanner.nextLine();

      if (mealsToOrder == 0) {
        orderingFood = false;
      } else if (mealsToOrder > 0 && mealsToOrder <= restaurant.getListOfMeals().size()) {
        mealsBeingOrdered.add(restaurant.getListOfMeals().get(mealsToOrder - 1));
        totalAmount += restaurant.getListOfMeals().get(mealsToOrder - 1).getPrice();
        System.out.println("Added " + restaurant.getListOfMeals().get(mealsToOrder - 1).getMealName()
                + " to your order.");
      } else {
        // Lets the user know that they have made an invalid choice.
        System.out.println("Invalid choice. Please try again.");
      }

    }

    // Prompt for preparation instructions if any.
    System.out.println("Do you have any preparation instructions for your order?");
    String prepForMeals = scanner.nextLine();

    // Creates the order and sets the status to pending.
    Order order = OrderImpl.createOrder("Order - " + System.currentTimeMillis(),
            Status.PENDING, Instant.now(),
            customer, restaurant, mealsBeingOrdered, prepForMeals);

    // Prints out the order number.
    System.out.println("Your order has been created, order no. " + order.getOrderNumber());

    // Reads the drivers.txt to a list.
    List<Driver> driverList = DriverImpl.driverList("src/resources/drivers.txt");

    // Finds the closest driver with the least deliveries to the restaurant.
    Driver driverWithLeastDeliveries = DriverImpl.findClosestDriver(driverList, restaurant);

    // Checks if the driver object is not null.
    if (Objects.nonNull(driverWithLeastDeliveries)) {
      // Prints out the driver that will be delivering the meal and sets the order status to processing.
      System.out.println("Your meal will be delivered by: " + driverWithLeastDeliveries.getDriverName());
      order.setStatus(Status.PROCESSING);
      // Creates an invoice and sets the order status to completed.
      Invoice invoice = InvoiceImpl.createInvoice(customer, restaurant, driverWithLeastDeliveries, order, totalAmount);
      order.setStatus(Status.COMPLETED);
      // Prints the invoice.
      InvoiceImpl.printInvoiceReceipt(customer, restaurant, driverWithLeastDeliveries, order, totalAmount);
    } else {
      // Displays a message if there's no drivers available to  deliver to the customers location.
      System.out.println("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
    }
    scanner.close(); // Close the scanner to free resources
  }
}
