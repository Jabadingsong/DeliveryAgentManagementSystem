/**
 * ExceptionHandling Class
 * 
 * This class provides custom exception handling methods for the Delivery Agent Management System.
 * It handles specific exceptions such as invalid input and agent not found, and includes a method for 
 * handling general exceptions with custom error messages.
 * 
 * Methods:
 * - handleInvalidInputException(): Displays a message for invalid user input.
 * - handleAgentNotFoundException(): Displays a message when an agent is not found.
 * - handleGeneralException(String message): Displays a custom error message for general exceptions.
 * 
 * Author: OOP GROUP 7
 * Date: 10/22/2024
 */

public class ExceptionHandling 
{

    // Handle InvalidInputException
    public void handleInvalidInputException() 
    {
        System.out.println("Error: Invalid input. Please check your input and try again.");
    }

    // Handle AgentNotFoundException
    public void handleAgentNotFoundException() 
    {
        System.out.println("Error: Agent not found. Please provide a valid agent ID.");
    }

    // Handle general exceptions with a custom message
    public void handleGeneralException(String message) 
    {
        System.out.println("Error: " + message);
    }
}
