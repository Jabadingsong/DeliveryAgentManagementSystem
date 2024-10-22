/**
 * VehicleType Class
 * 
 * This class defines a list of vehicle types that can be used by delivery agents 
 * in the Delivery Agent Management System. It provides functionality to validate 
 * vehicle types and retrieve all available types.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/19/2024
 */

 import java.util.Arrays;
 import java.util.List;
 
 public class VehicleType {
    private final List<String> vehicleTypes = Arrays.asList("Bike", "Motorcycle", "Car", "Van", "Truck");

    public boolean isValidVehicleType(String vehicleType) {
        return vehicleTypes.stream().anyMatch(v -> v.equalsIgnoreCase(vehicleType));
    }

    public List<String> getAllVehicleTypes() {
        return vehicleTypes;
    }
}

 