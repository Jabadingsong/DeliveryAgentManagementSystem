/**
 * Main Application for Delivery Agent Management System
 * 
 * This program serves as the entry point for the Delivery Agent Management System.
 * It presents a console-based interface that allows users to manage delivery agents,
 * perform CRUD operations, search/filter, and handle file operations.
 * 
 * Features:
 * - Menu-driven system with options for adding, viewing, editing, and deleting agents
 * - Search and filter functionality based on agent attributes
 * - Data persistence using CSV file handling
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

import java.util.List;
import java.util.Scanner;

// Main class to run the program
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        DeliveryAgentManager manager = new DeliveryAgentManager();

        // Update this to your specific path
        String filePath = "C:\\Users\\Ezkylle Opiniano\\Desktop\\SchoolStuff\\1st Semester\\oop\\finals\\Final OOP Group 7\\DeliveryAgentManagementSystem\\Data\\agents.csv";

        // Load agents from CSV
        try 
        {
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
            System.out.println("5. Filter Agents by Vehicle Type");
            System.out.println("6. Search Agents by Goods");
            System.out.println("7. Save Agents to CSV");
            System.out.println("8. Exit");

            int choice = getValidChoice(scanner, 8);
 
            switch (choice) 
            {
                case 1:
                    DeliveryAgent newAgent = inputAgent(scanner);
                    manager.addAgent(newAgent);
                    break;

                case 2:
                    System.out.print("Enter agent index to update: ");
                    int updateIndex = getValidIndex(scanner, manager.getAgents().size());
                    DeliveryAgent updatedAgent = inputAgent(scanner);
                    manager.updateAgent(updateIndex, updatedAgent);
                    break;
 
                case 3:
                    System.out.print("Enter agent index to delete: ");
                    int deleteIndex = getValidIndex(scanner, manager.getAgents().size());
                    manager.deleteAgent(deleteIndex);
                    break;

                case 4:
                    manager.displayAgents();
                    break;
 
                case 5:
                    System.out.print("Enter vehicle type to search: ");
                    String vehicleTypeInput = scanner.nextLine();
                    VehicleType vehicleType = VehicleType.valueOf(vehicleTypeInput.toUpperCase()); // Convert input to enum
                    List<DeliveryAgent> foundAgents = manager.searchByVehicleType(vehicleType);
                    if (foundAgents.isEmpty()) 
                    {
                         System.out.println("No agents found for vehicle type: " + vehicleType);
                    } 
                    else 
                    {
                         for (DeliveryAgent agent : foundAgents) 
                        {
                             System.out.println(agent.toCSV());
                        }
                    }
                    break;
                 
                case 6:
                    System.out.print("Enter goods to filter: ");
                    String goodsInput = scanner.nextLine();
                    GoodsType goods = GoodsType.valueOf(goodsInput.toUpperCase()); // Convert input to enum
                    List<DeliveryAgent> filteredAgents = manager.filterByGoods(goods);
                    if (filteredAgents.isEmpty()) 
                    {
                        System.out.println("No agents found for goods: " + goods);
                    } 
                    else 
                    {
                        for (DeliveryAgent agent : filteredAgents) 
                        {
                            System.out.println(agent.toCSV());
                        }
                    }
                    break;
                 
 
                case 7:
                    manager.saveToCSV(filePath);
                    break;
 
                case 8:
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
 
    private static int getValidChoice(Scanner scanner, int maxChoice) 
    {
        int choice = -1;
        while (choice < 1 || choice > maxChoice) 
        {
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            if (choice < 1 || choice > maxChoice) 
            {
                System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice + ".");
            }
        }
        return choice;
    }
 
    private static DeliveryAgent inputAgent(Scanner scanner) 
    {
        System.out.print("Enter agent name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter availability (true/false): ");
        boolean availability = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
    
        // Choose vehicle type using the VehicleType enum
        System.out.println("Choose vehicle type:");
        for (int i = 0; i < VehicleType.values().length; i++) 
        {
            System.out.println((i + 1) + ". " + VehicleType.values()[i]);
        }
        int vehicleChoice = getValidChoice(scanner, VehicleType.values().length);
        VehicleType vehicleType = VehicleType.values()[vehicleChoice - 1];
    
        // Choose goods type using the GoodsType enum
        System.out.println("Choose goods type:");
        for (int i = 0; i < GoodsType.values().length; i++) 
        {
            System.out.println((i + 1) + ". " + GoodsType.values()[i]);
        }
        int goodsChoice = getValidChoice(scanner, GoodsType.values().length);
        GoodsType goodsType = GoodsType.values()[goodsChoice - 1];
    
        return new DeliveryAgent(name, contactNumber, availability, goodsType, vehicleType); // Corrected constructor call
    }
 
    private static int getValidIndex(Scanner scanner, int maxIndex) 
    {
        int index = -1;
        while (index < 0 || index >= maxIndex) 
        {
            System.out.print("Enter index (0 to " + (maxIndex - 1) + "): ");
            index = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            if (index < 0 || index >= maxIndex) 
            {
                System.out.println("Invalid input. Please enter a number between 0 and " + (maxIndex - 1) + ".");
            }
        }
        return index;
    }
}
 