package kimesh.hyperionDev.model;

public class Meal {
	
	private String mealName;
	private String description;
	private double price;
	
	public Meal(String mealName, String description, double price) {
		this.mealName = mealName;
		this.description = description;
		this.price = price;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
