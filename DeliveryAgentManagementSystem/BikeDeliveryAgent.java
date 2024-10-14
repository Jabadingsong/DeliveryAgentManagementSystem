public class BikeDeliveryAgent extends DeliveryAgent 
{
    public BikeDeliveryAgent(String name, String contactNumber, boolean availability, String goods) 
    {
        super(name, contactNumber, availability, goods);
    }

    @Override
    public String getVehicleType() 
    {
        return "Bike";
    }
}
