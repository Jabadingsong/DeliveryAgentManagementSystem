/**
 * Person Class
 * 
 * This class represents a person with basic attributes: name and contact number.
 * It provides getter and setter methods for managing the person's name and contact details.
 * 
 * This class serves as the base class for more specialized classes, such as DeliveryAgent, 
 * in the Delivery Agent Management System.
 * 
 * Author: OOP GROUP 7
 * Date: 10/19/2024
 */

 public class Person 
 {
    private String name;            // The name of the person
    private String contactNumber;   // The contact number of the person

    public Person(String name, String contactNumber) 
    {
        this.name = name;
        this.contactNumber = contactNumber; 
    }

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
}
