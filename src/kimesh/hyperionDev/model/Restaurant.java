package kimesh.hyperionDev.model;

import java.util.List;

public class Restaurant {

	private String restautantName;
	private Contact contact;
	private Address address;
	private List<Meal> listOfMeals;
	
	public Restaurant(String restautantName, Contact contact, Address address, List<Meal> listOfMeals) {
		this.restautantName = restautantName;
		this.contact = contact;
		this.address = address;
		this.listOfMeals = listOfMeals;
	}

	public String getRestautantName() {
		return restautantName;
	}

	public void setRestautantName(String restautantName) {
		this.restautantName = restautantName;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Meal> getListOfMeals() {
		return listOfMeals;
	}

	public void setListOfMeals(List<Meal> listOfMeals) {
		this.listOfMeals = listOfMeals;
	}
}
