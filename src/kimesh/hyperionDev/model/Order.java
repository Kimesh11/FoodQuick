package kimesh.hyperionDev.model;

import java.time.Instant;
import java.util.List;

import kimesh.hyperionDev.enums.Status;

public class Order {

  // Order variables
  private String orderNumber;
  private Status status;
  private Instant orderDate;
  private Customer customerDetails;
  private Restaurant restaurantDetails;
  private List<Meal> listOfMealsBeingOrdered;
  private String preparationInstructions;

  // Constructor
  public Order(String orderNumber, Status status, Instant orderDate, Customer customerDetails,
               Restaurant restaurantDetails, List<Meal> listOfMealsBeingOrdered, String preparationInstructions) {
    this.orderNumber = orderNumber;
    this.status = status;
    this.orderDate = orderDate;
    this.customerDetails = customerDetails;
    this.restaurantDetails = restaurantDetails;
    this.listOfMealsBeingOrdered = listOfMealsBeingOrdered;
    this.preparationInstructions = preparationInstructions;
  }

  // Getters and setters
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Instant getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Instant orderDate) {
    this.orderDate = orderDate;
  }

  public Customer getCustomerDetails() {
    return customerDetails;
  }

  public void setCustomerDetails(Customer customerDetails) {
    this.customerDetails = customerDetails;
  }

  public Restaurant getRestaurantDetails() {
    return restaurantDetails;
  }

  public void setRestaurantDetails(Restaurant restaurantDetails) {
    this.restaurantDetails = restaurantDetails;
  }

  public List<Meal> getListOfMealsBeingOrdered() {
    return listOfMealsBeingOrdered;
  }

  public void setListOfMealsBeingOrdered(List<Meal> listOfMealsBeingOrdered) {
    this.listOfMealsBeingOrdered = listOfMealsBeingOrdered;
  }

  public String getPreparationInstructions() {
    return preparationInstructions;
  }

  public void setPreparationInstructions(String preparationInstructions) {
    this.preparationInstructions = preparationInstructions;
  }

}
