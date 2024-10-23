/**
 * Delivery Agent Management System
 * 
 * This program manages delivery agents and categorizes them by the type of goods they deliver
 * and the vehicle they use (e.g., bike, motorcycle, car, van, truck). 
 * It supports adding, updating, removing, and searching for agents. 
 * Additionally, the system can filter agents based on their vehicle type or goods type.
 * 
 * The manager loads agent data from a CSV file during initialization and can save updated data back to the file.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentManager 
{
    private List<DeliveryAgent> agentsList = new ArrayList<>();
    private String csvFilePath;

    // Constructor to initialize the CSV file path and load agents from CSV
    public DeliveryAgentManager(String csvFilePath) 
    {
        this.csvFilePath = csvFilePath;
        loadAgentsFromCSV(); // Load agents from the CSV file during initialization
    }

    // Load agents from the CSV file
    private void loadAgentsFromCSV() 
    {
        agentsList = CSVUtils.readFromCSV(csvFilePath);
    }

    // Save agents to the CSV file
    public void saveAgentsToCSV() 
    {
        if (CSVUtils.writeToCSV(csvFilePath, agentsList)) 
        {
            System.out.println("Agents saved successfully to CSV.");
        } else {
            System.out.println("Error saving agents to CSV.");
        }
    }

    public void addAgent(DeliveryAgent agent) 
    {
        agentsList.add(agent);
    }

    public void removeAgent(int agentID) 
    {
        DeliveryAgent agent = getAgentById(agentID);
        if (agent != null) 
        {
            agentsList.remove(agent);
            System.out.println("Agent removed successfully.");
        } 
        else 
        {
            System.out.println("Error: Agent ID not found.");
        }
    }

    public DeliveryAgent getAgentById(int agentID) 
    {
        for (DeliveryAgent agent : agentsList)
        {
            if (agent.getAgentID() == agentID) 
            {
                return agent;
            }
        }
        return null;
    }

    public void updateAgent(int agentID, String name, String contactNumber, String vehicleType, String goodsType, boolean availability) {
    DeliveryAgent agent = getAgentById(agentID);
    if (agent != null) 
    {
        agent.updateAgentDetails(name, contactNumber, vehicleType, goodsType, availability);
        System.out.println("Agent updated successfully.");
    } 
    else 
    {
        System.out.println("Error: Agent ID not found.");
    }
}

    public List<DeliveryAgent> getAllAgents() 
    {
        return agentsList;
    }
    
    public List<DeliveryAgent> filterByVehicleType(String vehicleType) 
    {
        List<DeliveryAgent> filteredAgents = new ArrayList<>();
        for (DeliveryAgent agent : agentsList) 
        {
            if (agent.getVehicleType().equalsIgnoreCase(vehicleType)) 
            {
                filteredAgents.add(agent);
            }
        }
        return filteredAgents;
    }

    public List<DeliveryAgent> searchByGoodsType(String goodsType) 
    {
        List<DeliveryAgent> searchedAgents = new ArrayList<>();
        for (DeliveryAgent agent : agentsList) {
            if (agent.getGoodsType().equalsIgnoreCase(goodsType)) 
            {
                searchedAgents.add(agent);
            }
        }
        return searchedAgents;
    }
}
