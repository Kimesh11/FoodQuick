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
        if (parts.length != 3) {
          System.out.println("Invalid line format: " + line);
          continue;
        }
        String name = parts[0];
        String cityName = parts[1];
        int deliveries = Integer.parseInt(parts[2]);

        driverList.add(new Driver(name, cityName, deliveries));

      }
    } catch (FileNotFoundException e) {
      System.out.println("The file at '" + filePath + "' was not found. Please make sure it exists.");
    } catch (IOException e) {
      System.out.println("An error occurred while reading the file: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Failed to parse delivery count. Make sure the file contains valid numbers.");
    }
    return driverList;

  }

  // Finds the closets driver by looping through the list of drivers and taking in the restaurants location.
  public static Driver findClosestDriver(List<Driver> drivers, Restaurant restaurant) {
    Driver closestDriver = null;
    int lowestDeliveries = Integer.MAX_VALUE;

    for (Driver driver : drivers) {
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
