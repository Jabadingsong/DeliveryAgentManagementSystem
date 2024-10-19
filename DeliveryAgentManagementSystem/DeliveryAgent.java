/**
 * DeliveryAgent Class
 * 
 * This class represents a delivery agent. It includes attributes such as the agent's ID,
 * name, contact number, availability, vehicle type, and goods category. 
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

 public class DeliveryAgent {
    private int id; 
    private String name;
    private String contactNumber;
    private boolean availability;
    private GoodsType goods;
    private VehicleType vehicleType;

    public DeliveryAgent(String name, String contactNumber, boolean availability, GoodsType goods, VehicleType vehicleType) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.availability = availability;
        this.goods = goods;
        this.vehicleType = vehicleType;
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

    public GoodsType getGoods() {
        return goods;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    // Method to convert the DeliveryAgent object to a CSV string
    public String toCSV() {
        return id + "," + name + "," + contactNumber + "," + vehicleType + "," + goods + "," + availability;
    }

    // Static method to create a DeliveryAgent from a CSV string
    public static DeliveryAgent fromCSV(String csvLine) {
        String[] tokens = csvLine.split(",");
        DeliveryAgent agent = new DeliveryAgent(
            tokens[1], // name
            tokens[2], // contact number
            Boolean.parseBoolean(tokens[4]), // availability
            GoodsType.valueOf(tokens[3].toUpperCase()), // goods
            VehicleType.valueOf(tokens[3].toUpperCase()) // vehicleType (if applicable)
        );
        agent.setId(Integer.parseInt(tokens[0])); // Set ID
        return agent;
    }
}
