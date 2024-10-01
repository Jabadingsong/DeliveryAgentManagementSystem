/**
 * The Main class serves as the entry point for the Delivery Agent Management System. 
 * It provides a user interface to manage delivery agents through various operations 
 * such as adding, updating, deleting, listing, and searching agents. 
 * The application loads agent data from a CSV file on startup and saves it before exiting.
 */

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        DeliveryAgentManager manager = new DeliveryAgentManager();

        // Use the correct path to the data folder
        String filePath = "C:\\Users\\Ezkylle Opiniano\\Desktop\\SchoolStuff\\1st Semester\\oop\\finals\\Final OOP Group 7\\DeliveryAgentManagementSystem\\Data\\agents.csv";
        
        // Load agents from CSV (if the file exists)
        try {
            manager.loadFromCSV(filePath);
        } 
        catch (Exception e) 
        {
            System.out.println("Failed to load data from CSV. Please check the file path.");
        }
        
        boolean exit = false;

        while (!exit) 
        {
            System.out.println("\nDelivery Agent Management System:");
            System.out.println("1. Add Agent");
            System.out.println("2. Update Agent");
            System.out.println("3. Delete Agent");
            System.out.println("4. List All Agents");
            System.out.println("5. Save Agents to CSV");
            System.out.println("6. Exit");
            
            int choice = -1;
            // Loop to ensure valid integer input for menu selection
            while (choice == -1) 
            {
                System.out.print("Choose an option: ");
                try 
                {
                    choice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline after nextInt
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    scanner.nextLine();  // Consume the invalid input
                }
            }

            switch (choice) 
            {
                case 1:
                    // Add a new agent
                    DeliveryAgent newAgent = inputAgent(scanner);
                    manager.addAgent(newAgent);
                    break;

                case 2:
                    // Update an agent
                    System.out.print("Enter agent index to update: ");
                    int updateIndex = getValidIndex(scanner, manager.getAgents().size());
                    DeliveryAgent updatedAgent = inputAgent(scanner);
                    manager.updateAgent(updateIndex, updatedAgent);
                    break;

                case 3:
                    // Delete an agent
                    System.out.print("Enter agent index to delete: ");
                    int deleteIndex = getValidIndex(scanner, manager.getAgents().size());
                    manager.deleteAgent(deleteIndex);
                    break;

                case 4:
                    // List all agents
                    List<DeliveryAgent> agents = manager.getAgents();
                    if (agents.isEmpty()) 
                    {
                        System.out.println("No agents available.");
                    } 
                    else 
                    {
                        System.out.println("ID,Name,Contact Number,Vehicle Type,Availability"); // Header for display
                        for (int i = 0; i < agents.size(); i++) 
                        {
                            System.out.println((i + 1) + ": " + agents.get(i).toCSV());  // Start displaying agents from 1
                        }
                    }
                    break;
                

                case 5:
                    // Save agents to CSV
                    manager.saveToCSV(filePath);
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting program.");
                    manager.saveToCSV(filePath);
                    scanner.close();
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to input agent details from the user
    private static DeliveryAgent inputAgent(Scanner scanner) 
    {
        System.out.print("Enter agent name: ");
        String name = scanner.nextLine();

        System.out.print("Enter agent contact number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        boolean availability;
        while (true) 
        {
            System.out.print("Is the agent available? (true/false): ");
            String availabilityInput = scanner.nextLine();
            if (availabilityInput.equalsIgnoreCase("true") || availabilityInput.equalsIgnoreCase("false")) 
            {
                availability = Boolean.parseBoolean(availabilityInput);
                break;
            } 
            else 
            {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }

        return new DeliveryAgent(name, contactNumber, vehicleType, availability);
    }

    // Method to validate and get a valid index for update/delete operations
    private static int getValidIndex(Scanner scanner, int size) 
    {
        int index = -1;
        while (index < 0 || index >= size) 
        {
            System.out.print("Enter a valid index: ");
            try 
            {
                index = scanner.nextInt();
                scanner.nextLine();  // Consume newline after nextInt
                if (index < 0 || index >= size) 
                {
                    System.out.println("Index out of range. Please try again.");
                }
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();  // Consume the invalid input
            }
        }
        return index;
    }
}
