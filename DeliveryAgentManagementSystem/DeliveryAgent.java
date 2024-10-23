/**
 * DeliveryAgent Class
 * 
 * This class represents a delivery agent within the Delivery Agent Management System.
 * It encapsulates key attributes such as the agent's ID, name, contact number, availability status,
 * the type of goods they handle, and the type of vehicle they use.
 * 
 * It provides methods to update the agent's details and convert a CSV line into a DeliveryAgent object.
 * The CSV data is expected to follow the format: agentID, name, contactNumber, goodsType, vehicleType, availability.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

public class DeliveryAgent extends Person 
{
    private int agentID;
    private String vehicleType;
    private String goodsType;
    private boolean availability;

    public DeliveryAgent(int agentID, String name, String contactNumber, String vehicleType, String goodsType, boolean availability) 
    {
        super(name, contactNumber);
        this.agentID = agentID;
        this.vehicleType = vehicleType;
        this.goodsType = goodsType;
        this.availability = availability;
    }

    public int getAgentID() 
    {
        return agentID;
    }

    public String getVehicleType() 
    {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) 
    {
        this.vehicleType = vehicleType;
    }

    public String getGoodsType() 
    {
        return goodsType;
    }

    public void setGoodsType(String goodsType) 
    {
        this.goodsType = goodsType;
    }

    public boolean isAvailability() 
    {
        return availability;
    }

    public void setAvailability(boolean availability) 
    {
        this.availability = availability;
    }

    public void updateAgentDetails(String name, String contactNumber, String vehicleType, String goodsType, boolean availability) {
        setName(name);
        setContactNumber(contactNumber); 
        setVehicleType(vehicleType);
        setGoodsType(goodsType);
        setAvailability(availability);
    }

    @Override
    public String toString() 
    {
        return "Agent ID: " + agentID + "\n" +
               "Name: " + getName() + "\n" +
               "Contact Number: " + getContactNumber() + "\n" +
               "Vehicle Type: " + getVehicleType() + "\n" +
               "Goods Type: " + getGoodsType() + "\n" +
               "Availability: " + isAvailability();
    }
    
    public static DeliveryAgent fromCSV(String csvLine) 
    {
        String[] fields = csvLine.split(","); // Split the line by commas

        int id = Integer.parseInt(fields[0].trim());
        String name = fields[1].trim();
        String contact = fields[2].trim(); 
        String goods = fields[3].trim();
        String vehicle = fields[4].trim();
        boolean availability = Boolean.parseBoolean(fields[5].trim());

        return new DeliveryAgent(id, name, contact, vehicle, goods, availability);
    }
}
