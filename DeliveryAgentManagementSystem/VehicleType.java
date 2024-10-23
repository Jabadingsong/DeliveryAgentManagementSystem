/**
 * VehicleType Class
 * 
 * This class defines and manages the list of vehicle types that can be used 
 * by delivery agents in the Delivery Agent Management System. It provides 
 * methods to:
 * - Validate whether a given vehicle type is valid, using case-insensitive matching.
 * - Retrieve the list of all available vehicle types.
 * 
 * The vehicle types included are: Bike, Motorcycle, Car, Van, and Truck.
 * 
 * Author: OOP GROUP 7
 * Date: 10/19/2024
 */

 import java.util.Arrays;
 import java.util.List;
 
 public class VehicleType 
 {
    private final List<String> vehicleTypes = Arrays.asList("Bike", "Motorcycle", "Car", "Van", "Truck");

    public boolean isValidVehicleType(String vehicleType) 
    {
        return vehicleTypes.stream().anyMatch(v -> v.equalsIgnoreCase(vehicleType));
    }

    public List<String> getAllVehicleTypes() 
    {
        return vehicleTypes;
    }
}

 