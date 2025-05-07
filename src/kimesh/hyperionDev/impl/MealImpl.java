package kimesh.hyperionDev.impl;

import kimesh.hyperionDev.model.Meal;

public class MealImpl {

  // Creates a Meal.
  public static Meal createMeal(String mealName, String description, double price) {
    return new Meal(
            mealName,
            description,
            price
    );
  }
}
