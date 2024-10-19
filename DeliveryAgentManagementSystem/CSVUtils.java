/**
 * CSVUtils Class
 * 
 * This utility class manages CSV file operations for handling delivery agent data.
 * It includes methods for:
 * 
 * - Reading delivery agent data from a CSV file to populate a list of agents
 * - Writing updated delivery agent information to a CSV file
 * - Ensuring that the data is correctly formatted for Excel viewing, including header labels
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    /**
     * Writes a list of DeliveryAgent objects to a specified CSV file.
    * 
    * @param filePath The path to the CSV file where data will be saved.
    * @param agents   The list of DeliveryAgent objects to be written to the file.
    * @return boolean indicating success (true) or failure (false) of the operation.
    */
    public static boolean writeToCSV(String filePath, List<DeliveryAgent> agents) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
        {
            // Write the header line for the CSV
            writer.write("ID,Name,Contact Number,Goods Type,Vehicle Type,Availability");
            writer.newLine();
    
            // Write each DeliveryAgent's data to the CSV file
            for (DeliveryAgent agent : agents) 
            {
                writer.write(agent.toCSV());
                writer.newLine();
            }
            return true; // Indicate successful write operation
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing to CSV: " + e.getMessage());
            return false; // Indicate failure in writing
        }
    }

    /**
     * Reads DeliveryAgent data from a specified CSV file.
    * 
    * @param filePath The path to the CSV file from which data will be read.
    * @return A list of DeliveryAgent objects populated with data from the CSV file.
    */
    public static List<DeliveryAgent> readFromCSV(String filePath) 
    {
        List<DeliveryAgent> agents = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            // Skip the header line to focus on the data rows
            reader.readLine();
    
            // Read each line and convert it into a DeliveryAgent object
            while ((line = reader.readLine()) != null) 
            {
                DeliveryAgent agent = DeliveryAgent.fromCSV(line);
                agents.add(agent); // Add the agent to the list
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error reading from CSV: " + e.getMessage());
        }
        return agents; // Return the populated list of agents
    }    
}
