/**
 * DeliveryAgent Class
 * 
 * This class represents a delivery agent within the Delivery Agent Management System. 
 * It encapsulates key attributes such as the agent's ID, name, contact number, availability status, 
 * the type of goods they handle, and the type of vehicle they use.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

public class DeliveryAgent 
{
    private int id;  // Unique identifier for the delivery agent
    private String name;  // Name of the delivery agent
    private String contactNumber;  // Contact number for the delivery agent
    private boolean availability;  // Availability status of the delivery agent (true if available, false otherwise)
    private GoodsType goods;  // Type of goods the agent is responsible for delivering
    private VehicleType vehicleType;  // Type of vehicle the agent uses for deliveries

    /**
     * Constructor to initialize a new DeliveryAgent object.
     * 
     * @param name The name of the delivery agent
     * @param contactNumber The contact number of the delivery agent
     * @param availability The availability status of the delivery agent
     * @param goods The type of goods the delivery agent handles
     * @param vehicleType The type of vehicle the delivery agent uses
     */
    public DeliveryAgent(String name, String contactNumber, boolean availability, GoodsType goods, VehicleType vehicleType) 
    {
        this.name = name;
        this.contactNumber = contactNumber;
        this.availability = availability;
        this.goods = goods;
        this.vehicleType = vehicleType;
    }

    // Getter for the agent ID
    public int getId() 
    {
        return id;
    }

    // Setter for the agent ID
    public void setId(int id) 
    {
        this.id = id;
    }

    // Getter for the agent's name
    public String getName() 
    {
        return name;
    }

    // Getter for the agent's contact number
    public String getContactNumber() 
    {
        return contactNumber;
    }

    // Method to check if the agent is available
    public boolean isAvailable() 
    {
        return availability;
    }

    // Getter for the type of goods the agent handles
    public GoodsType getGoods() 
    {
        return goods;
    }

    // Getter for the type of vehicle the agent uses
    public VehicleType getVehicleType() 
    {
        return vehicleType;
    }

    /**
     * Converts the DeliveryAgent object to a CSV string format for easy storage and retrieval.
     * 
     * @return A CSV string representation of the DeliveryAgent object
     */
    public String toCSV() 
    {
        return id + "," + name + "," + contactNumber + "," + vehicleType + "," + goods + "," + availability;
    }

    /**
     * Static method to create a DeliveryAgent object from a CSV string.
     * 
     * @param csvLine A CSV string representing a delivery agent
     * @return A DeliveryAgent object constructed from the CSV string
     */
    public static DeliveryAgent fromCSV(String csvLine) 
    {
        String[] tokens = csvLine.split(","); // Split the CSV line into individual tokens
        DeliveryAgent agent = new DeliveryAgent(
            tokens[1], // name
            tokens[2], // contact number
            Boolean.parseBoolean(tokens[4]), // availability
            GoodsType.valueOf(tokens[3].toUpperCase()), // goods
            VehicleType.valueOf(tokens[3].toUpperCase()) // vehicleType (if applicable)
        );
        agent.setId(Integer.parseInt(tokens[0])); // Set the ID from the first token
        return agent; // Return the constructed DeliveryAgent object
    }
}
