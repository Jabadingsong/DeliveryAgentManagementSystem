/**
 * The DeliveryAgentManager class manages a collection of delivery agents, 
 * providing CRUD (Create, Read, Update, Delete) operations.
 * 
 * It is responsible for:
 * - Registering new agents
 * - Updating existing agents based on their index in the list
 * - Deleting agents by index
 * - Saving agent data to a CSV file for persistence
 * - Loading agent data from a CSV file on application startup
 * 
 * The class is designed with extensibility in mind, allowing additional
 * operations to be added in the future (e.g., searching agents by name or vehicle type).
 */

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentManager 
{
    private List<DeliveryAgent> agents;

    public DeliveryAgentManager() 
    {
        this.agents = new ArrayList<>();
    }

    // Register a new delivery agent
    public void addAgent(DeliveryAgent agent) 
    {
        agents.add(agent);
        System.out.println("Agent added successfully.");
    }

    // Update an existing agent
    public void updateAgent(int index, DeliveryAgent updatedAgent) 
    {
        if (index >= 0 && index < agents.size()) 
        {
            agents.set(index, updatedAgent);
            System.out.println("Agent updated successfully.");
        } 
        else 
        {
            System.out.println("Invalid agent index.");
        }
    }

    // Delete an agent
    public void deleteAgent(int index) 
    {
        if (index >= 0 && index < agents.size()) 
        {
            agents.remove(index);
            System.out.println("Agent deleted successfully.");
        } 
        else 
        {
            System.out.println("Invalid agent index.");
        }
    }

    // Save agents to CSV
    public void saveToCSV(String filePath) 
    {
        CSVUtils.writeToCSV(filePath, agents);
        System.out.println("Agents saved to CSV.");
    }

    // Load agents from CSV
    public void loadFromCSV(String filePath) 
    {
        agents = CSVUtils.readFromCSV(filePath);
        System.out.println("Agents loaded from CSV.");
    }

    // Search agents by name
    public List<DeliveryAgent> searchByName(String name) 
    {
        List<DeliveryAgent> result = new ArrayList<>();
        for (DeliveryAgent agent : agents) 
        {
            if (agent.getName().equalsIgnoreCase(name)) 
            {
                result.add(agent);
            }
        }
        return result;
    }

    // Get the list of agents (for displaying or further operations)
    public List<DeliveryAgent> getAgents() 
    {
        return agents;
    }
}
