/**
 * The CSVUtils class provides utility methods for reading and writing 
 * delivery agent data to and from a CSV file.
 * 
 * Key functionality:
 * - writeToCSV: Writes a list of DeliveryAgent objects to a CSV file,
 *   including a header line for better organization when viewed in Excel.
 * - readFromCSV: Reads a CSV file and converts each line back into 
 *   DeliveryAgent objects for use in the application.
 * 
 * This separation of concerns allows for cleaner code and easier maintenance.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils 
{
    // Method to write a list of agents to a CSV file
    public static void writeToCSV(String filePath, List<DeliveryAgent> agents) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
        {
            writer.write("ID,Name,Contact Number,Vehicle Type,Availability");
            writer.newLine();

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

    // Method to read agents from a CSV file
    public static List<DeliveryAgent> readFromCSV(String filePath) 
    {
        List<DeliveryAgent> agents = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            // Skip the header line
            reader.readLine(); 
            
            while ((line = reader.readLine()) != null) 
            {
                DeliveryAgent agent = DeliveryAgent.fromCSV(line);
                agents.add(agent);
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error reading from CSV: " + e.getMessage());
        }

        return agents;
    }
}