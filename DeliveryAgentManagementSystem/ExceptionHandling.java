public class ExceptionHandling {

    // Handle InvalidInputException
    public void handleInvalidInputException() {
        System.out.println("Error: Invalid input. Please check your input and try again.");
    }

    // Handle AgentNotFoundException
    public void handleAgentNotFoundException() {
        System.out.println("Error: Agent not found. Please provide a valid agent ID.");
    }

    // Handle general exceptions with a custom message
    public void handleGeneralException(String message) {
        System.out.println("Error: " + message);
    }
}
