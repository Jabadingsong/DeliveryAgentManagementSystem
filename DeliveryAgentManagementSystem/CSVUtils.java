/**
 * CSVUtils Class
 * 
 * This utility class handles CSV file operations for managing delivery agent data 
 * in the Delivery Agent Management System. It includes methods for:
 * 
 * - Reading delivery agent data from a specified CSV file to populate a list of DeliveryAgent objects.
 * - Writing updated delivery agent information back to a CSV file, ensuring correct formatting 
 *   for Excel viewing, including header labels.
 * - Handling I/O exceptions during read and write operations, providing feedback on errors.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils 
{

	public static boolean writeToCSV(String filePath, List<DeliveryAgent> agents) 
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
		{
			// Write the header line for the CSV
			writer.write("ID,Name,Contact Number,Goods Type,Vehicle Type,Availability");
			writer.newLine();

			// Write each agent's details to the CSV
			for (DeliveryAgent agent : agents) 
			{
				writer.write(String.format("%d,%s,%s,%s,%s,%b",
						agent.getAgentID(),
						agent.getName(),
						agent.getContactNumber(), // Now as String
						agent.getGoodsType(),
						agent.getVehicleType(),
						agent.isAvailability()));
				writer.newLine();
			}
			return true; // Successful write
		} 
		catch (IOException e) 
		{
			System.out.println("Error writing to CSV: " + e.getMessage());
			return false; // Failed write
		}
	}

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
