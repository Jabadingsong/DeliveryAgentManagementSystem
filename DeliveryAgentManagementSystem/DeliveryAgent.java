/**
 * DeliveryAgent Class
 * 
 * This class represents a delivery agent. It includes attributes such as the agent's ID,
 * name, vehicle type, and goods category. The class includes basic operations such as:
 * 
 * - Getters and setters for agent information
 * - Polymorphic behavior (specific to the vehicle type or goods)
 * 
 * This class forms the base for specialized agents that may inherit from this class.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */


public class DeliveryAgent {
    private int id; 
    private String name;
    private String contactNumber;
    private boolean availability;
    private String goods;

    public DeliveryAgent(String name, String contactNumber, boolean availability, String goods) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.availability = availability;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public boolean isAvailable() {
        return availability;
    }

    public String getGoods() {
        return goods;
    }

    public String toCSV() {
        return id + "," + name + "," + contactNumber + "," + getVehicleType() + "," + availability + "," + goods;
    }

    public static DeliveryAgent fromCSV(String csvLine) {
        String[] fields = csvLine.split(",");
        DeliveryAgent agent = new DeliveryAgent(fields[1], fields[2], Boolean.parseBoolean(fields[4]), fields[5]);
        agent.setId(Integer.parseInt(fields[0]));
        return agent;
    }

    // Abstract method for vehicle type, to be implemented in subclasses
    public String getVehicleType() {
        return "Generic Vehicle";
    }
}

