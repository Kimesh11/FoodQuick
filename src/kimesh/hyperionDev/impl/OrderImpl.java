package kimesh.hyperionDev.impl;

import java.time.Instant;
import java.util.List;

import kimesh.hyperionDev.enums.Status;
import kimesh.hyperionDev.model.Customer;
import kimesh.hyperionDev.model.Meal;
import kimesh.hyperionDev.model.Order;
import kimesh.hyperionDev.model.Restaurant;

public class OrderImpl {

  // Creates an Order.
  public static Order createOrder(String orderNumber, Status status, Instant orderDate, Customer customerDetails,
                                  Restaurant restaurantDetails, List<Meal> listOfMealsBeingOrdered, String preparationInstructions) {
    return new Order(
            orderNumber,
            status,
            orderDate,
            customerDetails,
            restaurantDetails,
            listOfMealsBeingOrdered,
            preparationInstructions
    );
  }

}
