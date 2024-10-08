/**
 * The DeliveryAgent class represents a delivery agent, 
 * encapsulating key details such as name, contact number, 
 * vehicle type, and availability.
 * 
 * Attributes:
 * - name: The full name of the delivery agent.
 * - contactNumber: A string representing the agent's contact number. 
 *   This could be expanded to include validation for format in future improvements.
 * - vehicleType: Describes the type of vehicle the agent uses 
 *   (e.g., bike, motorcycle, car, van, truck).
 * - availability: A boolean indicating whether the agent is currently available for deliveries.
 * - id: The unique identifier for the delivery agent, starting from 1.
 * - goods: A string representing the type of goods the agent delivers.
 * 
 * Methods:
 * - Getters and setters are used to ensure encapsulation, allowing for controlled 
 *   access and modification of agent details.
 * - toCSV: Converts the delivery agent's information to CSV format for easy storage.
 * - fromCSV: A static method that allows for the creation of a DeliveryAgent object 
 *   from a CSV line, facilitating CSV imports.
 */

public class DeliveryAgent 
{
    private int id; // ID will be assigned during the CSV write process
    private String name;
    private String contactNumber;
    private String vehicleType;
    private boolean availability;
    private String goods; // New attribute for the type of goods delivered

    // Constructor
    public DeliveryAgent(String name, String contactNumber, String vehicleType, boolean availability, String goods) 
    {
        this.name = name;
        this.contactNumber = contactNumber;
        this.vehicleType = vehicleType;
        this.availability = availability;
        this.goods = goods; // Initialize goods
    }

    // Getters and setters for encapsulation
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public String getVehicleType() 
    {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) 
    {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() 
    {
        return availability;
    }

    public void setAvailability(boolean availability) 
    {
        this.availability = availability;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getGoods() // New getter for goods
    {
        return goods;
    }

    public void setGoods(String goods) // New setter for goods
    {
        this.goods = goods;
    }

    // Method to convert to CSV format
    public String toCSV() 
    {
        return id + "," + name + "," + contactNumber + "," + vehicleType + "," + availability + "," + goods;
    }

    // Static method to create an agent from CSV
    public static DeliveryAgent fromCSV(String csvLine) 
    {
        String[] fields = csvLine.split(",");
        DeliveryAgent agent = new DeliveryAgent(fields[1], fields[2], fields[3], Boolean.parseBoolean(fields[4]), fields[5]); // Include goods
        agent.setId(Integer.parseInt(fields[0])); // Set the ID from the CSV
        return agent;
    }
}
