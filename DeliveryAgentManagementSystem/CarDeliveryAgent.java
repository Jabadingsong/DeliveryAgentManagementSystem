public class CarDeliveryAgent extends DeliveryAgent 
{
    public CarDeliveryAgent(String name, String contactNumber, boolean availability, String goods) 
    {
        super(name, contactNumber, availability, goods);
    }

    @Override
    public String getVehicleType() 
    {
        return "Car";
    }
}
