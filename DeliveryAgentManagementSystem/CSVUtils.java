/**
 * CSVHandler Class
 * 
 * This utility class manages CSV file handling for loading and saving delivery agent data.
 * It includes methods for:
 * 
 * - Reading from a CSV file to populate the list of delivery agents
 * - Writing to a CSV file to save updated delivery agent information
 * - Ensuring data is correctly formatted for Excel viewing, with category labels
 * 
 * Author: OOP GROUP 7 
 * Date: 10/14/2024
 */

 import java.io.*;
 import java.util.ArrayList;
 import java.util.List;
 
 public class CSVUtils 
 {
     // Method to write a list of agents to a CSV file
     public static boolean writeToCSV(String filePath, List<DeliveryAgent> agents) 
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
             return true; // Indicate success
         } 
         catch (IOException e) 
         {
             System.out.println("Error writing to CSV: " + e.getMessage());
             return false; // Indicate failure
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
 