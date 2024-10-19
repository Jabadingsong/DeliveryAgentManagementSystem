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
    private List<DeliveryAgent> agents;

    public DeliveryAgentManager() 
    {
        this.agents = new ArrayList<>();
    }

    public void addAgent(DeliveryAgent agent) 
    {
        agent.setId(agents.size() + 1); 
        agents.add(agent);
    }

    public void updateAgent(int index, DeliveryAgent updatedAgent) 
    {
        updatedAgent.setId(index + 1); 
        agents.set(index, updatedAgent);
    }

    public void deleteAgent(int index) 
    {
        if (index >= 0 && index < agents.size()) 
        {
            agents.remove(index);
            for (int i = index; i < agents.size(); i++) 
            {
                agents.get(i).setId(i + 1);
            }
        }
    }

    public List<DeliveryAgent> getAgents() 
    {
        return agents;
    }

    public void displayAgents() 
    {
        System.out.println("Current Agents:");
        for (int i = 0; i < agents.size(); i++) {
            DeliveryAgent agent = agents.get(i);
            System.out.println((i) + ": " + agent.toCSV());
        }
    }

    // Search agents by vehicle type
    public List<DeliveryAgent> searchByVehicleType(VehicleType vehicleType) 
    {
        List<DeliveryAgent> result = new ArrayList<>();
        for (DeliveryAgent agent : agents) 
        {
            if (agent.getVehicleType() == vehicleType) 
            {
                result.add(agent);
            }
        }
        return result;
    }

    // Filter agents by goods type
    public List<DeliveryAgent> filterByGoods(GoodsType goods) 
    {
        List<DeliveryAgent> result = new ArrayList<>();
        for (DeliveryAgent agent : agents) 
        {
            if (agent.getGoods() == goods) 
            {
                result.add(agent);
            }
        }
        return result;
    }

    public void saveToCSV(String filePath) 
    {
        if (CSVUtils.writeToCSV(filePath, agents)) 
        { // Assuming writeToCSV returns a boolean indicating success
            System.out.println("Agents saved successfully to " + filePath); // Success message
        } 
        else 
        {
            System.err.println("Error saving agents to file."); // Error message
        }
    }

    public void loadFromCSV(String filePath) 
    {
        agents = CSVUtils.readFromCSV(filePath);
    }
}
