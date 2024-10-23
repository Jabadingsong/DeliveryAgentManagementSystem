/**
 * UserInterface Class
 * 
 * This class provides the console-based user interface for the Delivery Management System.
 * It handles user interactions, including registering, updating, deleting, and displaying
 * delivery agents, filtering by vehicle type, and searching by goods type.
 * 
 * Features:
 * - Displays a menu with various options for managing delivery agents.
 * - Captures and validates user inputs, such as agent details, vehicle type, and goods type.
 * - Performs operations like adding, updating, removing, and listing delivery agents.
 * - Saves delivery agent information to a CSV file.
 * - Ensures user inputs are valid with custom validation for vehicle type, goods type, and availability.
 * 
 * Author: OOP GROUP 7
 * Date: 10/22/2024
 */

import java.util.Scanner;
import java.util.List;

public class UserInterface 
{
    private Scanner scanner = new Scanner(System.in);
    private GoodsType goodsTypeObj = new GoodsType(); // Correct instance for goods type
    private VehicleType vehicle = new VehicleType();

    public void displayMenu() 
    {
        System.out.println("========== Delivery Management System ===========");
        System.out.println("1. Add Agent");
        System.out.println("2. Update Agent");
        System.out.println("3. Delete Agent");
        System.out.println("4. List All Agents");
        System.out.println("5. Filter Agents by Vehicle Type");
        System.out.println("6. Search Agents by Goods");
        System.out.println("7. Save Agents to CSV");
        System.out.println("8. Exit");
        System.out.print("Enter your choice (1-8): ");
    }

    public String getUserInput() 
    {
        return scanner.nextLine().trim(); 
    }

    public void handleUserChoice(DeliveryAgentManager agentManager) 
    {
        while (true) 
        {
            displayMenu();
            String choice = getUserInput();
            switch (choice) 
            {
                case "1":
                    handleRegistration(agentManager);
                    break;
                case "2":
                    System.out.print("Enter the agent ID to update: ");
                    int agentIDToUpdate = Integer.parseInt(getUserInput());
                    handleUpdate(agentManager, agentIDToUpdate);
                    break;
                case "3":
                    System.out.print("Enter the agent ID to delete: ");
                    int agentIDToDelete = Integer.parseInt(getUserInput());
                    agentManager.removeAgent(agentIDToDelete);
                    break;
                case "4":
                    List<DeliveryAgent> agents = agentManager.getAllAgents();
                    displayAgentsList(agents);
                    break;
                case "5":
                    filterByVehicleType(agentManager);
                    break;
                case "6":
                    searchByGoodsType(agentManager);
                    break;
                case "7":
                    agentManager.saveAgentsToCSV();
                    System.out.println("Agents saved to CSV successfully.");
                    break;
                case "8":
                    System.out.println("Exiting...");
                    scanner.close(); // Close scanner here before exiting
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }

    // Handle Registration Method
    public void handleRegistration(DeliveryAgentManager agentManager) 
    {
        try 
        {
            System.out.print("Enter agent ID: ");
            int agentID = Integer.parseInt(getUserInput());

            System.out.print("Enter agent name: ");
            String name = capitalizeString(getUserInput());

            System.out.print("Enter contact number: ");
            String contactNumber = getValidContactNumber(); 

            System.out.print("Enter vehicle type [Bike, Motorcycle, Car, Van, Truck]: ");
            String vehicleType = getUserInput();
            while (!vehicle.isValidVehicleType(vehicleType)) 
            {
                System.out.println("Invalid vehicle type. Please enter a valid vehicle type.");
                vehicleType = getUserInput();
            }

            System.out.print("Enter goods type [Food, Medicine, Furniture, Livestock, Clothing, Jewelry, Tech Products, Games, Customized Products, Toys]: ");
            String goodsType = getUserInput();
            while (!goodsTypeObj.isValidGoodsType(goodsType, true)) 
            {
                System.out.println("Invalid goods type. Please enter a valid goods type.");
                goodsType = getUserInput();
            }

            boolean availability = getAgentAvailability();

            DeliveryAgent agent = new DeliveryAgent(agentID, name, contactNumber, vehicleType, goodsType, availability);
            agentManager.addAgent(agent);
            System.out.println("Agent registered successfully.");
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Invalid input. Please enter numeric values where required.");
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to get and validate agent availability
    private boolean getAgentAvailability() 
    {
        while (true) {
            System.out.print("Is the agent available? (true/false): ");
            String input = getUserInput();
            if (input.equalsIgnoreCase("true")) 
            {
                return true;
            } 
            else if (input.equalsIgnoreCase("false")) 
            {
                return false;
            } 
            else 
            {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    }

    // Capitalize String Method
    public String capitalizeString(String str) 
    {
        if (str == null || str.isEmpty()) return str; // Handle empty input
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) 
            { // Check for empty words
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", words);
    }

    // Handle Update Method
    public void handleUpdate(DeliveryAgentManager agentManager, int agentID) 
    {
        try 
        {
            System.out.print("Enter new name: ");
            String name = capitalizeString(getUserInput());

            System.out.print("Enter new contact number (Minimum of 10 Number like 9876543210): ");
            String contactNumber = getUserInput();

            System.out.print("Enter new vehicle type [Bike, Motorcycle, Car, Van, Truck]: ");
            String vehicleType = getUserInput();
            while (!vehicle.isValidVehicleType(vehicleType)) 
            {
                System.out.println("Invalid vehicle type. Please enter a valid vehicle type.");
                vehicleType = getUserInput();
            }

            System.out.print("Enter new goods type [Food, Medicine, Furniture, Livestock, Clothing, Jewelry, Tech Products, Games, Customized Products, Toys]: ");
            String goodsType = getUserInput();
            while (!goodsTypeObj.isValidGoodsType(goodsType, true)) 
            {
                System.out.println("Invalid goods type. Please enter a valid goods type.");
                goodsType = getUserInput();
            }

            // Handle new availability status
            boolean availability = getAgentAvailability();

            // Update agent details
            agentManager.updateAgent(agentID, name, contactNumber, vehicleType, goodsType, availability);
            System.out.println("Agent details updated successfully.");
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display Agents List Method
    public void displayAgentsList(List<DeliveryAgent> agents) 
    {
        if (agents.isEmpty()) 
        {
            System.out.println("No agents found.");
            return;
        }
        System.out.printf("%-10s %-20s %-15s %-15s %-15s %-10s\n", "Agent ID", "Name", "Contact Number", "Vehicle Type", "Goods Type", "Availability");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        for (DeliveryAgent agent : agents) 
        {
            System.out.printf("%-10d %-20s %-15s %-15s %-15s %-10s\n", 
                agent.getAgentID(),
                agent.getName(),
                agent.getContactNumber(), 
                agent.getVehicleType(),
                agent.getGoodsType(),
                agent.isAvailability() ? "True" : "False"
            );
        System.out.println("----------------------------------------------------------------------------------------------------------------");    
        }
    }

    // Filter by Vehicle Type Method
    public void filterByVehicleType(DeliveryAgentManager agentManager) 
    {
        System.out.print("Enter vehicle type to filter: ");
        String vehicleType = getUserInput();
        List<DeliveryAgent> filteredAgents = agentManager.filterByVehicleType(vehicleType);
        displayAgentsList(filteredAgents);
    }

    // Search by Goods Type Method
    public void searchByGoodsType(DeliveryAgentManager agentManager) 
    {
        System.out.print("Enter goods type to search: ");
        String goodsType = getUserInput();
        List<DeliveryAgent> searchedAgents = agentManager.searchByGoodsType(goodsType);
        displayAgentsList(searchedAgents);
    }

    public void displayErrorMessage(String message) 
    {
        System.out.println("Error: " + message);
    }

    // Method to get valid contact number
    private String getValidContactNumber() 
    {
        while (true) 
        {
            String contactNumber = getUserInput();
            if (isValidContactNumber(contactNumber)) 
            {
                return contactNumber;
            } else {
                System.out.println("Invalid contact number. Please enter a valid number.");
            }
        }
    }

    private boolean isValidContactNumber(String contactNumber) 
    {
        return contactNumber.matches("\\d{10}"); // Example for a 10-digit number
    }
}
