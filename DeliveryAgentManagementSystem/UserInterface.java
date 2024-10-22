import java.util.Scanner;
import java.util.List;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private GoodsType goodsTypeObj = new GoodsType(); // Correct instance for goods type
    private VehicleType vehicle = new VehicleType();

    public void displayMenu() {
        System.out.println("===== Delivery Management System =====");
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

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void handleUserChoice(DeliveryAgentManager agentManager) {
        while (true) {
            displayMenu();
            String choice = getUserInput();
            switch (choice) {
                case "1":
                    handleRegistration(agentManager);
                    break;
                case "2":
                    System.out.print("Enter the agent index to update: ");
                    int agentIDToUpdate = Integer.parseInt(getUserInput());
                    handleUpdate(agentManager, agentIDToUpdate);
                    break;
                case "3":
                    System.out.print("Enter the agent index to delete: ");
                    int agentIDToDelete = Integer.parseInt(getUserInput());
                    agentManager.removeAgent(agentIDToDelete);
                    displayDeletionSuccess();
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
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }

    // Handle Registration Method
    public void handleRegistration(DeliveryAgentManager agentManager) {
        try {
            System.out.print("Enter agent ID: ");
            int agentID = Integer.parseInt(getUserInput());

            System.out.print("Enter agent name: ");
            String name = getUserInput();
            name = capitalizeString(name);

            System.out.print("Enter contact number: ");
            long contactNumber;
            while (true) {
                try {
                    contactNumber = Long.parseLong(getUserInput());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid contact number.");
                }
            }

            System.out.print("Enter vehicle type [Bike, Motorcycle, Car, Van, Truck]: ");
            String vehicleType = getUserInput();
            
            while (!vehicle.isValidVehicleType(vehicleType)) {
                System.out.println("Invalid vehicle type. Please enter a valid vehicle type.");
                System.out.print("Enter vehicle type [Bike, Motorcycle, Car, Van, Truck]: ");
                vehicleType = getUserInput(); // Prompt again for input
            }
            
            System.out.print("Enter goods type [Food, Medicine, Furniture, Livestock, Clothing, Jewelry, Tech Products, Games, Customized Products, Toys]: ");
            String goodsType = getUserInput();
            
            // Using ignoreCase as true for case-insensitive validation
            while (!goodsTypeObj.isValidGoodsType(goodsType, true)) {
                System.out.println("Invalid goods type. Please enter a valid goods type.");
                System.out.print("Enter goods type [Food, Medicine, Furniture, Livestock, Clothing, Jewelry, Tech Products, Games, Customized Products, Toys]: ");
                goodsType = getUserInput(); // Prompt again for input
            }

            // Handle agent availability with validation
            boolean availability = getAgentAvailability();

            DeliveryAgent agent = new DeliveryAgent(agentID, name, contactNumber, vehicleType, goodsType, availability);
            agentManager.addAgent(agent);
            System.out.println("Agent registered successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to get and validate agent availability
    private boolean getAgentAvailability() {
        while (true) {
            System.out.print("Is the agent available? (true/false): ");
            String input = getUserInput().trim(); // Read input and remove leading/trailing whitespace
            
            if (input.equalsIgnoreCase("true")) {
                return true; // Return true for valid input
            } else if (input.equalsIgnoreCase("false")) {
                return false; // Return false for valid input
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    }

    // Capitalize String Method
    public String capitalizeString(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    // Handle Update Method
    public void handleUpdate(DeliveryAgentManager agentManager, int agentID) {
        try {
            System.out.print("Enter new name: ");
            String name = getUserInput();
            name = capitalizeString(name);

            System.out.print("Enter new contact number: ");
            long contactNumber = Long.parseLong(getUserInput());

            System.out.print("Enter new vehicle type: ");
            String vehicleType = capitalizeString(getUserInput());
            while (!vehicle.isValidVehicleType(vehicleType)) {
                System.out.println("Invalid vehicle type. Please enter a valid vehicle type.");
                System.out.print("Enter vehicle type [Bike, Motorcycle, Car, Van, Truck]: ");
                vehicleType = capitalizeString(getUserInput());
            }

            System.out.print("Enter new goods type: ");
            String goodsType = capitalizeString(getUserInput());
            while (!goodsTypeObj.isValidGoodsType(goodsType, true)) { // Use goodsTypeObj
                System.out.println("Invalid goods type. Please enter a valid goods type.");
                System.out.print("Enter goods type [Documents, Medical Services, Food, Hazardous Materials, Freight]: ");
                goodsType = capitalizeString(getUserInput());
            }

            agentManager.updateAgent(agentID, name, contactNumber, vehicleType, goodsType);
            System.out.println("Agent updated successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display Agents List Method
    public void displayAgentsList(List<DeliveryAgent> agents) {
        if (agents == null || agents.isEmpty()) {
            System.out.println("No agents available.");
        } else {
            System.out.println("===== Delivery Agents List =====");
            System.out.println("-----------------------------------");
            for (DeliveryAgent agent : agents) {
                System.out.printf("Agent ID: %d%n", agent.getAgentID());
                System.out.printf("Name: %s%n", agent.getName());
                System.out.printf("Contact Number: %d%n", agent.getContactNumber());
                System.out.printf("Vehicle Type: %s%n", agent.getVehicleType());
                System.out.printf("Goods Type: %s%n", agent.getGoodsType());
                System.out.printf("Availability: %b%n", agent.isAvailability());
                System.out.println("-----------------------------------");
            }
        }
    }

    // Display Deletion Success Method
    public void displayDeletionSuccess() {
        System.out.println("Agent deleted successfully.");
    }

    // Filter by Vehicle Type
    public void filterByVehicleType(DeliveryAgentManager agentManager) {
        System.out.print("Enter vehicle type to filter (Bike, Motorcycle, Car, Van, Truck): ");
        String vehicleType = capitalizeString(getUserInput());
        List<DeliveryAgent> filteredAgents = agentManager.filterByVehicleType(vehicleType);
        displayAgentsList(filteredAgents);
    }

    // Search by Goods Type
    public void searchByGoodsType(DeliveryAgentManager agentManager) {
        System.out.print("Enter goods type to search (Documents, Medical Services, Food, Hazardous Materials, Freight): ");
        String goodsType = capitalizeString(getUserInput());
        List<DeliveryAgent> searchedAgents = agentManager.searchByGoodsType(goodsType);
        displayAgentsList(searchedAgents);
    }

    // Display Error Message Method
    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
