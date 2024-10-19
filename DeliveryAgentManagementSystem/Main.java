/**
 * Main Application for Delivery Agent Management System
 * 
 * This program serves as the entry point for the Delivery Agent Management System.
 * It provides a console-based interface that allows users to manage delivery agents,
 * perform CRUD operations, search/filter agents, and handle file operations for data persistence.
 * 
 * Features:
 * - Menu-driven system with options for adding, viewing, editing, and deleting agents
 * - Search functionality by vehicle type and filter by goods type
 * - Data persistence through CSV file handling
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

import java.util.List;
import java.util.Scanner;

// Main class to run the Delivery Agent Management System
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        DeliveryAgentManager manager = new DeliveryAgentManager(); // Instance of DeliveryAgentManager

        // Specify the path for the CSV file to load/save agents
        String filePath = "C:\\Users\\Ezkylle Opiniano\\Desktop\\SchoolStuff\\1st Semester\\oop\\finals\\Final OOP Group 7\\DeliveryAgentManagementSystem\\Data\\agents.csv";

        // Load agents from the CSV file
        try 
        {
            manager.loadFromCSV(filePath); // Load existing agents
        } 
        catch (Exception e) 
        {
            System.out.println("Failed to load data from CSV. Please check the file path."); // Error message
        }

        boolean exit = false; // Control variable for the main loop

        // Main menu loop
        while (!exit) 
        {
            System.out.println("\nDelivery Agent Management System:");
            System.out.println("1. Add Agent");
            System.out.println("2. Update Agent");
            System.out.println("3. Delete Agent");
            System.out.println("4. List All Agents");
            System.out.println("5. Filter Agents by Vehicle Type");
            System.out.println("6. Search Agents by Goods");
            System.out.println("7. Save Agents to CSV");
            System.out.println("8. Exit");

            int choice = getValidChoice(scanner, 8); // Get a valid menu choice

            switch (choice) 
            {
                case 1: // Add a new agent
                    DeliveryAgent newAgent = inputAgent(scanner); // Input agent details
                    manager.addAgent(newAgent); // Add agent to the manager
                    break;

                case 2: // Update an existing agent
                    System.out.print("Enter agent index to update: "); // Prompt for agent index
                    int updateIndex = getValidIndex(scanner, manager.getAgents().size()); // Validate index
                    DeliveryAgent updatedAgent = inputAgent(scanner); // Input updated agent details
                    manager.updateAgent(updateIndex, updatedAgent); // Update the agent
                    break;

                case 3: // Delete an agent
                    System.out.print("Enter agent index to delete: "); // Prompt for agent index
                    int deleteIndex = getValidIndex(scanner, manager.getAgents().size()); // Validate index
                    manager.deleteAgent(deleteIndex); // Delete the agent
                    break;

                case 4: // List all agents
                    manager.displayAgents(); // Display current agents
                    break;

                case 5: // Filter agents by vehicle type
                    System.out.print("Enter vehicle type to search: "); // Prompt for vehicle type
                    String vehicleTypeInput = scanner.nextLine(); // Read input
                    VehicleType vehicleType = VehicleType.valueOf(vehicleTypeInput.toUpperCase()); // Convert input to enum
                    List<DeliveryAgent> foundAgents = manager.searchByVehicleType(vehicleType); // Search agents
                    // Display search results
                    if (foundAgents.isEmpty()) 
                    {
                        System.out.println("No agents found for vehicle type: " + vehicleType);
                    } 
                    else 
                    {
                        for (DeliveryAgent agent : foundAgents) 
                        {
                            System.out.println(agent.toCSV()); // Print agent details in CSV format
                        }
                    }
                    break;
                
                case 6: // Search agents by goods type
                    System.out.print("Enter goods to filter: "); // Prompt for goods type
                    String goodsInput = scanner.nextLine(); // Read input
                    GoodsType goods = GoodsType.valueOf(goodsInput.toUpperCase()); // Convert input to enum
                    List<DeliveryAgent> filteredAgents = manager.filterByGoods(goods); // Filter agents
                    // Display filter results
                    if (filteredAgents.isEmpty()) 
                    {
                        System.out.println("No agents found for goods: " + goods);
                    } 
                    else 
                    {
                        for (DeliveryAgent agent : filteredAgents) 
                        {
                            System.out.println(agent.toCSV()); // Print agent details in CSV format
                        }
                    }
                    break;
                
                case 7: // Save agents to CSV
                    manager.saveToCSV(filePath); // Save agents to the specified file
                    break;

                case 8: // Exit the program
                    System.out.println("Exiting program."); // Inform the user
                    manager.saveToCSV(filePath); // Save agents before exiting
                    scanner.close(); // Close the scanner
                    exit = true; // Set exit flag to true
                    break;

                default: // Handle invalid input
                    System.out.println("Invalid choice. Please try again."); // Inform the user
            }
        }
    }

    // Method to get a valid menu choice from the user
    private static int getValidChoice(Scanner scanner, int maxChoice) 
    {
        int choice = -1; // Initialize choice
        while (choice < 1 || choice > maxChoice) // Validate choice
        {
            System.out.print("Choose an option: "); // Prompt for input
            choice = scanner.nextInt(); // Read input
            scanner.nextLine();  // Consume newline
            if (choice < 1 || choice > maxChoice) 
            {
                System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice + "."); // Error message
            }
        }
        return choice; // Return valid choice
    }

    // Method to input agent details from the user
    private static DeliveryAgent inputAgent(Scanner scanner) 
    {
        System.out.print("Enter agent name: "); // Prompt for agent name
        String name = scanner.nextLine(); // Read agent name
        System.out.print("Enter contact number: "); // Prompt for contact number
        String contactNumber = scanner.nextLine(); // Read contact number
        System.out.print("Enter availability (true/false): "); // Prompt for availability
        boolean availability = scanner.nextBoolean(); // Read availability
        scanner.nextLine(); // Consume newline
    
        // Choose vehicle type using the VehicleType enum
        System.out.println("Choose vehicle type:");
        for (int i = 0; i < VehicleType.values().length; i++) 
        {
            System.out.println((i + 1) + ". " + VehicleType.values()[i]); // List vehicle types
        }
        int vehicleChoice = getValidChoice(scanner, VehicleType.values().length); // Validate choice
        VehicleType vehicleType = VehicleType.values()[vehicleChoice - 1]; // Get selected vehicle type
    
        // Choose goods type using the GoodsType enum
        System.out.println("Choose goods type:");
        for (int i = 0; i < GoodsType.values().length; i++) 
        {
            System.out.println((i + 1) + ". " + GoodsType.values()[i]); // List goods types
        }
        int goodsChoice = getValidChoice(scanner, GoodsType.values().length); // Validate choice
        GoodsType goodsType = GoodsType.values()[goodsChoice - 1]; // Get selected goods type
    
        return new DeliveryAgent(name, contactNumber, availability, goodsType, vehicleType); // Return new DeliveryAgent instance
    }

    // Method to get a valid index from the user
    private static int getValidIndex(Scanner scanner, int maxIndex) 
    {
        int index = -1; // Initialize index
        while (index < 0 || index >= maxIndex) // Validate index
        {
            System.out.print("Enter index (0 to " + (maxIndex - 1) + "): "); // Prompt for input
            index = scanner.nextInt(); // Read input
            scanner.nextLine();  // Consume newline
            if (index < 0 || index >= maxIndex) 
            {
                System.out.println("Invalid input. Please enter a number between 0 and " + (maxIndex - 1) + "."); // Error message
            }
        }
        return index; // Return valid index
    }
}
