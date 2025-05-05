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
		System.out.println("\nPlease enter the details of your restaurant"
				+ "\nPlease enter the necessary details in order for us to continue\nPlease enter the restaurant name:");
		String restaurantName = scanner.nextLine();
		
		System.out.print("Please enter your street name: ");
		String restaurantStreetName = scanner.nextLine();
		
		System.out.print("Please enter your city: ");
		String restaurantCityName = scanner.nextLine();
		
		System.out.print("Please enter your postal code: ");
		int restaurantPostalCode = scanner.nextInt();
		scanner.nextLine(); // Consume the leftover newline
		
		System.out.print("Please enter your contact number: ");
		String restaurantContactNumber = scanner.nextLine();
		
		System.out.print("Please enter your email address: ");
		String restaurantEmailAddress = scanner.nextLine();
		
		List<Meal> mealList = new ArrayList<>();
		boolean addingMeal = true;
		
		while(addingMeal) {
			 System.out.println("\nEnter details for a new meal:");

            System.out.print("Meal Name: ");
            String mealName = scanner.nextLine();

            System.out.print("Meal Description: ");
            String mealDescription = scanner.nextLine();

            double mealPrice = 0.0;
            System.out.print("Meal Price: ");
            mealPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the leftover newline
            
            mealList.add(MealImpl.createMeal(mealName, mealDescription, mealPrice));
            
            System.out.println("Do you want to add another meal? (Y/N)");
            String response = scanner.nextLine();
            
            if (!response.equalsIgnoreCase("Y")) {
            	addingMeal = false;
            }
            
		}
		return createRestaurant(restaurantName, restaurantContactNumber, restaurantEmailAddress, restaurantStreetName, restaurantCityName, restaurantPostalCode, mealList);
	}
}
