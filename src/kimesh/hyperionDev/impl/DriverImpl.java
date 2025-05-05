package kimesh.hyperionDev.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import kimesh.hyperionDev.model.Driver;
import kimesh.hyperionDev.model.Restaurant;

public class DriverImpl {
	
  // returns a list of drivers from reading the drivers.txt file.
	public static List<Driver> driverList(String filePath) {
		List<Driver> driverList = new ArrayList<Driver>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while (Objects.nonNull(br.readLine())) {
				line = br.readLine();
				// Splits the lines by driver name, city name and deliveries.
				String[] parts = line.split(",\\s*");
				String name = parts[0];
				String cityName = parts[1];
				int deliveries = Integer.parseInt(parts[2]);
				
				driverList.add(new Driver(name, cityName, deliveries));
				
			}
		} catch (FileNotFoundException e) {
			System.err.print("Error reading file: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.print("Error reading file: " + e);
			e.printStackTrace();
		}
		return driverList;
		
	}
	
	// Finds the closets driver by looping through the list of drivers and taking in the restaurants location.
	public static Driver findClosestDriver(List<Driver> drivers, Restaurant restaurant) {
		Driver closestDriver = null;
		int lowestDeliveries = Integer.MAX_VALUE;
		
		for(Driver driver: drivers) {
			if (driver.getCityName().equalsIgnoreCase(restaurant.getAddress().getCityName())) {
				if (closestDriver == null || driver.getDeliveries() < closestDriver.getDeliveries()) {
					lowestDeliveries = driver.getDeliveries();
					closestDriver = driver;
				}
			}
		}
		return closestDriver;
	}
}
