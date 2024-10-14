/**
 * Delivery Agent Management System
 * 
 * This program manages delivery agents and categorizes them by the type of goods they deliver
 * and the vehicle they use (e.g., bike, motorcycle, car, van, truck). It implements
 * object-oriented principles including inheritance and polymorphism. The system supports:
 * 
 * - CRUD operations (Create, Read, Update, Delete)
 * - Search and filter functionality by agent's vehicle type and goods category
 * - Data validation for input fields
 * - File handling through CSV (data persistence)
 * - Enhanced exception handling
 * 
 * Data is saved and loaded from a CSV file with category labels for easy viewing in Excel.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

 import java.util.ArrayList;
 import java.util.List;
 
 public class DeliveryAgentManager {
     private List<DeliveryAgent> agents;
 
     public DeliveryAgentManager() {
         this.agents = new ArrayList<>();
     }
 
     public void addAgent(DeliveryAgent agent) {
         agent.setId(agents.size() + 1); 
         agents.add(agent);
     }
 
     public void updateAgent(int index, DeliveryAgent updatedAgent) {
         updatedAgent.setId(index + 1); 
         agents.set(index, updatedAgent);
     }
 
     public void deleteAgent(int index) {
         if (index >= 0 && index < agents.size()) {
             agents.remove(index);
             for (int i = index; i < agents.size(); i++) {
                 agents.get(i).setId(i + 1);
             }
         }
     }
 
     public List<DeliveryAgent> getAgents() {
         return agents;
     }
 
     public void displayAgents() {
         System.out.println("Current Agents:");
         for (int i = 0; i < agents.size(); i++) {
             DeliveryAgent agent = agents.get(i);
             System.out.println((i + 1) + ": " + agent.toCSV());
         }
     }
 
     public List<DeliveryAgent> searchByVehicleType(String vehicleType) {
         List<DeliveryAgent> result = new ArrayList<>();
         for (DeliveryAgent agent : agents) {
             if (agent.getVehicleType().equalsIgnoreCase(vehicleType)) {
                 result.add(agent);
             }
         }
         return result;
     }
 
     public List<DeliveryAgent> filterByGoods(String goods) {
         List<DeliveryAgent> result = new ArrayList<>();
         for (DeliveryAgent agent : agents) {
             if (agent.getGoods().equalsIgnoreCase(goods)) {
                 result.add(agent);
             }
         }
         return result;
     }
 
     public void saveToCSV(String filePath) {
         if (CSVUtils.writeToCSV(filePath, agents)) { // Assuming writeToCSV returns a boolean indicating success
             System.out.println("Agents saved successfully to " + filePath); // Success message
         } else {
             System.err.println("Error saving agents to file."); // Error message
         }
     }
 
     public void loadFromCSV(String filePath) {
         agents = CSVUtils.readFromCSV(filePath);
     }
 }
 