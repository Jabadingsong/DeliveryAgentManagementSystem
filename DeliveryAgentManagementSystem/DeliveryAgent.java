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
    private String name;
    private String contactNumber;
    private String vehicleType;
    private boolean availability;

    // Constructor
    public DeliveryAgent(String name, String contactNumber, String vehicleType, boolean availability) 
    {
        this.name = name;
        this.contactNumber = contactNumber;
        this.vehicleType = vehicleType;
        this.availability = availability;
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

    // Method to convert to CSV format
    public String toCSV() 
    {
        return name + "," + contactNumber + "," + vehicleType + "," + availability;
    }

    // Static method to create an agent from CSV
    public static DeliveryAgent fromCSV(String csvLine) 
    {
        String[] fields = csvLine.split(",");
        return new DeliveryAgent(fields[0], fields[1], fields[2], Boolean.parseBoolean(fields[3]));
    }
}
