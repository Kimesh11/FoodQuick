package kimesh.hyperionDev.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import kimesh.hyperionDev.model.Address;
import kimesh.hyperionDev.model.Contact;
import kimesh.hyperionDev.model.Meal;
import kimesh.hyperionDev.model.Restaurant;

public class RestaurantImpl {

  // Creates a restaurant object.
  public static Restaurant createRestaurant(String restaurantName, String contactNumber, String emailAddress,
                                            String street, String city, int postalCode, List<Meal> meals) {
    Address address = new Address(street, city, postalCode);
    Contact contact = new Contact(contactNumber, emailAddress);
    return new Restaurant(restaurantName, contact, address, meals);
  }

  // Captures the restaurant input and returns a restaurant object.
  public static Restaurant captureRestaurantInput(Scanner scanner) {
    scanner.useLocale(Locale.US);

    System.out.println("\nWelcome to Restaurant Registration!");
    System.out.println("Please enter the following details:\n");

    // Restaurant name
    String restaurantName;
    while (true) {
      System.out.print("Restaurant name: ");
      restaurantName = scanner.nextLine();
      if (!restaurantName.isBlank()) {
        break;
      }
      System.out.println("Restaurant name cannot be blank.");
    }

    // Street name
    String restaurantStreetName;
    while (true) {
      System.out.print("Street name: ");
      restaurantStreetName = scanner.nextLine();
      if (!restaurantStreetName.isBlank()) {
        break;
      }
      System.out.println("Street name cannot be blank.");
    }

    // City name
    String restaurantCityName;
    while (true) {
      System.out.print("City name: ");
      restaurantCityName = scanner.nextLine();
      if (!restaurantCityName.isBlank()) {
        break;
      }
      System.out.println("City name cannot be blank.");
    }

    // Postal code
    int restaurantPostalCode;
    while (true) {
      System.out.print("Please enter your postal code (4 digits): ");
      try {
        restaurantPostalCode = Integer.parseInt(scanner.nextLine());
        if (String.valueOf(restaurantPostalCode).length() == 4) {
          break;
        } else {
          System.out.println("Postal code must be 4 digits.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Please enter numbers only.");
      }
    }

    // Contact number
    String restaurantContactNumber;
    while (true) {
      System.out.print("Please enter your contact number: ");
      restaurantContactNumber = scanner.nextLine();
      if (restaurantContactNumber.matches("\\d{10}")) {
        break;
      }
      System.out.println("Contact number must be exactly 10 digits.");
    }

    // Email
    String restaurantEmailAddress;
    while (true) {
      System.out.print("Email address: ");
      restaurantEmailAddress = scanner.nextLine();
      if (!restaurantEmailAddress.isBlank() &&
              restaurantEmailAddress.contains("@") &&
              (restaurantEmailAddress.endsWith(".com") || restaurantEmailAddress.endsWith(".co.za"))) {
        break;
      }
      System.out.println("Please enter a valid email (e.g., example@domain.com or .co.za).");
    }

    // Meals
    List<Meal> mealList = new ArrayList<>();
    boolean addingMeal = true;
    while (addingMeal) {
      System.out.println("\nEnter details for a new meal:");

      // Meal name
      String mealName;
      while (true) {
        System.out.print("Meal Name: ");
        mealName = scanner.nextLine();
        if (!mealName.isBlank()) {
          break;
        }
        System.out.println("Meal name cannot be blank.");
      }

      // Meal description
      String mealDescription;
      while (true) {
        System.out.print("Meal Description: ");
        mealDescription = scanner.nextLine();
        if (!mealDescription.isBlank()) {
          break;
        }
        System.out.println("Meal description cannot be blank.");
      }

      // Meal price
      double mealPrice;
      while (true) {
        System.out.print("Meal Price: ");
        if (scanner.hasNextDouble()) {
          mealPrice = scanner.nextDouble();
          scanner.nextLine(); // consume newline
          if (mealPrice > 0) {
            break;
          } else {
            System.out.println("Price must be a positive number.");
          }
        } else {
          System.out.println("Invalid input. Please enter a numeric value.");
          scanner.nextLine(); // consume invalid input
        }
      }

      mealList.add(MealImpl.createMeal(mealName, mealDescription, mealPrice));

      System.out.print("Do you want to add another meal? (Y/N): ");
      String response = scanner.nextLine();
      addingMeal = response.equalsIgnoreCase("Y");
    }

    return createRestaurant(
            restaurantName,
            restaurantContactNumber,
            restaurantEmailAddress,
            restaurantStreetName,
            restaurantCityName,
            restaurantPostalCode,
            mealList
    );
  }
}
