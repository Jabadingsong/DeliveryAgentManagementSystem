/**
 * Person Class
 * 
 * This class represents a person with a name and contact number.
 * It provides methods to get and set the person's name and contact information.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/19/2024
 */

public class Person {
    private String name;            // The name of the person
    private long contactNumber;     // The contact number of the person

    /**
     * Constructor to create a Person instance
     * 
     * @param name The name of the person
     * @param contactNumber The contact number of the person
     */
    public Person(String name, long contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    /**
     * Gets the name of the person
     * 
     * @return The name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person
     * 
     * @param name The new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the contact number of the person
     * 
     * @return The contact number of the person
     */
    public long getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the contact number of the person
     * 
     * @param contactNumber The new contact number of the person
     */
    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
