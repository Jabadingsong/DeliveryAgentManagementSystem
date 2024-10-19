/**
 * Delivery Agent Management System
 * 
 * This program manages delivery agents and categorizes them by the type of goods they deliver
 * and the vehicle they use (e.g., bike, motorcycle, car, van, truck). 
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentManager 
{
    // List to hold DeliveryAgent objects
    private List<DeliveryAgent> agents;

    // Constructor to initialize the agents list
    public DeliveryAgentManager() 
    {
        this.agents = new ArrayList<>();
    }

    /**
     * Adds a new delivery agent to the list.
    * The ID is automatically set based on the current size of the list.
    * 
    * @param agent The DeliveryAgent object to be added.
    */
    public void addAgent(DeliveryAgent agent) 
    {
        agent.setId(agents.size() + 1); // Set the ID based on the current list size
        agents.add(agent); // Add the agent to the list
    }

    /**
     * Updates an existing delivery agent in the list.
    * The ID of the updated agent is set based on its position in the list.
    * 
    * @param index The index of the agent to be updated.
    * @param updatedAgent The new DeliveryAgent object with updated information.
    */
    public void updateAgent(int index, DeliveryAgent updatedAgent) 
    {
        updatedAgent.setId(index + 1); // Set the ID based on the index
        agents.set(index, updatedAgent); // Replace the existing agent with the updated agent
    }

    /**
     * Deletes a delivery agent from the list by index.
    * After removal, the IDs of subsequent agents are updated to maintain consistency.
    * 
    * @param index The index of the agent to be deleted.
    */
    public void deleteAgent(int index) 
    {
        if (index >= 0 && index < agents.size()) 
        { // Check if index is valid
            agents.remove(index); // Remove the agent at the specified index
            // Update IDs of subsequent agents
            for (int i = index; i < agents.size(); i++) 
            {
                agents.get(i).setId(i + 1); // Reset IDs to maintain order
            }
        }
    }

    /**
     * Returns the list of all delivery agents.
    * 
    * @return List of DeliveryAgent objects.
    */
    public List<DeliveryAgent> getAgents() 
    {
        return agents; // Return the list of agents
    }

    /**
     * Displays the current list of agents in the console.
    * Each agent's details are printed in CSV format.
    */
    public void displayAgents() 
    {
        System.out.println("Current Agents:");
        for (int i = 0; i < agents.size(); i++) 
        {
            DeliveryAgent agent = agents.get(i);
            System.out.println((i) + ": " + agent.toCSV()); // Display each agent
        }
    }

    /**
     * Searches for agents by their vehicle type.
    * 
    * @param vehicleType The VehicleType to filter agents by.
    * @return A list of DeliveryAgent objects that match the specified vehicle type.
    */
    public List<DeliveryAgent> searchByVehicleType(VehicleType vehicleType) 
    {
        List<DeliveryAgent> result = new ArrayList<>();
        for (DeliveryAgent agent : agents) 
        {
            if (agent.getVehicleType() == vehicleType) 
            { // Check if the vehicle type matches
                result.add(agent); // Add matching agents to the result list
            }
        }
        return result; // Return the filtered list
    }

    /**
     * Filters agents by the type of goods they deliver.
    * 
    * @param goods The GoodsType to filter agents by.
    * @return A list of DeliveryAgent objects that match the specified goods type.
    */
    public List<DeliveryAgent> filterByGoods(GoodsType goods) 
    {
        List<DeliveryAgent> result = new ArrayList<>();
        for (DeliveryAgent agent : agents) 
        {
            if (agent.getGoods() == goods) 
            { // Check if the goods type matches
                result.add(agent); // Add matching agents to the result list
            }
        }
        return result; // Return the filtered list
    }

    /**
     * Saves the current list of agents to a specified CSV file.
    * 
    * @param filePath The path to the CSV file where the agents will be saved.
    */
    public void saveToCSV(String filePath) 
    {
        if (CSVUtils.writeToCSV(filePath, agents)) 
        { // Attempt to write to the CSV file
            System.out.println("Agents saved successfully to " + filePath); // Success message
        } 
        else 
        {
            System.err.println("Error saving agents to file."); // Error message
        }
    }

    /**
     * Loads delivery agents from a specified CSV file into the manager.
    * 
    * @param filePath The path to the CSV file from which agents will be loaded.
    */
    public void loadFromCSV(String filePath) 
    {
        agents = CSVUtils.readFromCSV(filePath); // Read agents from the CSV file
    }
}
