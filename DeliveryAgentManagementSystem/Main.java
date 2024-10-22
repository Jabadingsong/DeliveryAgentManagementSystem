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

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ezkylle Opiniano\\Desktop\\SchoolStuff\\1st Semester\\oop\\finals\\Final OOP Group 7\\DeliveryAgentManagementSystem\\Data\\agents.csv"; // Update with your CSV file path
        DeliveryAgentManager agentManager = new DeliveryAgentManager(filePath);
        UserInterface userInterface = new UserInterface();

        boolean running = true;
        while (running) {
            userInterface.displayMenu();
            String choice = userInterface.getUserInput();

            switch (choice) {
                case "1": // Adding
                    userInterface.handleRegistration(agentManager);
                    agentManager.saveAgentsToCSV(); // Save after adding
                    break;
                case "2": // Updating
                    try {
                        System.out.print("Enter Agent's ID to update: ");
                        int updateID = Integer.parseInt(userInterface.getUserInput());
                        if (agentManager.getAgentById(updateID) == null) {
                            System.out.println("Agent ID not found.");
                            break;
                        }
                        userInterface.handleUpdate(agentManager, updateID);
                        agentManager.saveAgentsToCSV(); // Save after updating
                    } catch (NumberFormatException e) {
                        userInterface.displayErrorMessage("Invalid input. Please enter a valid number.");
                    }
                    break;
                case "3": // Deleting
                    try {
                        System.out.print("Enter Agent's ID to delete: ");
                        int deleteID = Integer.parseInt(userInterface.getUserInput());
                        agentManager.removeAgent(deleteID);
                        agentManager.saveAgentsToCSV(); // Save after deleting
                    } catch (NumberFormatException e) {
                        userInterface.displayErrorMessage("Invalid input. Please enter a valid number.");
                    }
                    break;
                case "4": // Listing
                    List<DeliveryAgent> agents = agentManager.getAllAgents();
                    userInterface.displayAgentsList(agents);
                    break;
                case "5": // Filter Agents by Vehicle Type
                    System.out.print("Enter Vehicle Type to filter: ");
                    String vehicleType = userInterface.getUserInput();
                    List<DeliveryAgent> filteredAgentsByVehicle = agentManager.filterByVehicleType(vehicleType);
                    userInterface.displayAgentsList(filteredAgentsByVehicle);
                    break;
                case "6": // Search Agents by Goods
                    System.out.print("Enter Goods Type to search: ");
                    String goodsType = userInterface.getUserInput();
                    List<DeliveryAgent> searchedAgentsByGoods = agentManager.searchByGoodsType(goodsType);
                    userInterface.displayAgentsList(searchedAgentsByGoods);
                    break;
                case "7": // Save Agents to CSV
                    agentManager.saveAgentsToCSV();
                    System.out.println("Agents saved to CSV successfully.");
                    break;
                case "8": // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
