package kimesh.hyperionDev.model;

public class Invoice {
	
	private Customer customerDetails;
	private Restaurant restaurantDetails;
	private Driver driverDetails;
	private Order orderDetails;
	private double totalAmountToBePaid;
	
	public Invoice(Customer customerDetails, Restaurant restaurantDetails, Driver driverDetails,
			Order orderDetails, double totalAmountToBePaid) {
		super();
		this.customerDetails = customerDetails;
		this.restaurantDetails = restaurantDetails;
		this.driverDetails = driverDetails;
		this.orderDetails = orderDetails;
		this.totalAmountToBePaid = totalAmountToBePaid;
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

	public Driver getDriverDetails() {
		return driverDetails;
	}

	public void setDriverDetails(Driver driverDetails) {
		this.driverDetails = driverDetails;
	}

	public double getTotalAmountToBePaid() {
		return totalAmountToBePaid;
	}

	public void setTotalAmountToBePaid(double totalAmountToBePaid) {
		this.totalAmountToBePaid = totalAmountToBePaid;
	}
	
}
