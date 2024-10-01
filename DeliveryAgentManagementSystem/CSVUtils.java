/**
 * The CSVUtils class provides utility methods for reading and writing delivery agents 
 * to and from CSV files. This ensures persistence of agent data between program sessions.
 * 
 * Key Methods:
 * - writeToCSV: Writes the list of delivery agents to a specified CSV file, handling potential
 *   I/O exceptions and ensuring that data is saved properly.
 * - readFromCSV: Reads delivery agent data from a CSV file, creating DeliveryAgent objects 
 *   from each line and returning a list of agents.
 * 
 * Exception Handling:
 * - Both methods include error handling to ensure the program continues to run
 *   smoothly in case of file I/O errors. Errors are logged to the console, giving
 *   the user insights into any issues that occur during file operations.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils 
{

    // Write agents to a CSV file
    public static void writeToCSV(String filePath, List<DeliveryAgent> agents) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
        {
            for (DeliveryAgent agent : agents) 
            {
                writer.write(agent.toCSV());
                writer.newLine();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing to CSV: " + e.getMessage());
        }
    }

    // Read agents from a CSV file
    public static List<DeliveryAgent> readFromCSV(String filePath) 
    {
        List<DeliveryAgent> agents = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                agents.add(DeliveryAgent.fromCSV(line));
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error reading from CSV: " + e.getMessage());
        }
        return agents;
    }
}
