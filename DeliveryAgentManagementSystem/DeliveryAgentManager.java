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
        agent.setId(agents.size() + 1); // Assign ID starting from 1
        agents.add(agent);
    }

    // Update an existing delivery agent
    public void updateAgent(int index, DeliveryAgent updatedAgent) 
    {
        updatedAgent.setId(index + 1); // Update ID to match the agent's index
        agents.set(index, updatedAgent);
    }

    // Delete an existing delivery agent
    public void deleteAgent(int index) 
    {
        if (index >= 0 && index < agents.size()) 
        {
            agents.remove(index);
            // Reassign IDs after deletion to keep them sequential
            for (int i = index; i < agents.size(); i++) 
            {
                agents.get(i).setId(i + 1);
            }
        }
    }

    // Get the list of agents
    public List<DeliveryAgent> getAgents() 
    {
        return agents;
    }

    // Save agents to CSV
    public void saveToCSV(String filePath) 
    {
        CSVUtils.writeToCSV(filePath, agents);
    }

    // Load agents from CSV
    public void loadFromCSV(String filePath) 
    {
        agents = CSVUtils.readFromCSV(filePath);
    }
}
