# DeliveryAgentManagementSystem
OOP Final Project - 2nd Year
This console-based Delivery Agent Management System is developed in Java to manage delivery agents efficiently. The system allows for operations such as adding, updating, deleting, listing, and searching for agents, with data persistence through saving and loading agent information from a CSV file.

## Table of Contents
- DeliveryAgent Class
- DeliveryAgentManager Class
- CSVUtils Class
- Main Class
- GoodsType Class
- VehicleType Class
- How It Works


## 1. DeliveryAgent Class
The DeliveryAgent class represents a delivery agent and encapsulates essential details:

Attributes:
- **name:** The full name of the agent.
- **contactNumber:** The agent’s phone number.
- **vehicleType:** The type of vehicle the agent uses (e.g., bike, car).
- **availability:** A boolean indicating whether the agent is available for deliveries.
### Methods:
- **Getters and Setters:** Control access to the agent's private attributes, following the encapsulation principle of OOP.
- **toCSV():** Converts the agent's details to a comma-separated string for easy CSV storage.
- **fromCSV(String csvLine):** A static method that converts a CSV-formatted string back into a DeliveryAgent object.

## 2. DeliveryAgentManager Class
The DeliveryAgentManager class manages a list of delivery agents and provides CRUD operations (Create, Read, Update, Delete).

### Attributes:
- **agents:** A List<DeliveryAgent> representing all currently managed agents.

### Methods:
- **addAgent(DeliveryAgent agent):** Adds a new agent to the list.
- **updateAgent(int index, DeliveryAgent updatedAgent):** Updates an agent's details based on the provided index.
- **deleteAgent(int index):** Removes an agent from the list based on the index.
- **saveToCSV(String filePath):** Saves the current list of agents to a CSV file.
- **loadFromCSV(String filePath):** Loads agents from a CSV file into the agents list.
- **searchByName(String name):** Searches agents by their name and returns a list of matching agents.
- **getAgents():** Returns the list of agents for viewing or further operations.

## 3. CSVUtils Class
The CSVUtils class handles the reading and writing of agents' data to and from CSV files, ensuring data persistence between program sessions.

### Methods:
- **writeToCSV(String filePath, List<DeliveryAgent> agents):** Writes the list of agents to the specified CSV file using a BufferedWriter.
- **readFromCSV(String filePath):** Reads agents from a CSV file and returns them as a list. It uses a BufferedReader to read the file line by line, converting each line into a DeliveryAgent object.

## 4. Main Class
The Main class serves as the entry point for the application, providing a menu-driven user interface that allows users to perform various operations on the delivery agents.

### Key Operations:
- **Add Agent:** Collects agent details from the user and adds the agent to the list.
- **Update Agent:** Allows the user to update an existing agent's details by specifying its index.
- **Delete Agent:** Removes an agent based on its index.
- **List All Agents:** Displays all agents, showing their details in CSV format.
- **Save Agents to CSV:** Saves the current agent list to a CSV file.
- **Exit:** Exits the application and saves all changes to the CSV file.

## 5. GoodsType Class
The GoodsType class enumerates the different types of goods that can be delivered by agents, providing a structured way to categorize delivery items.

### Methods:
- **getGoodsTypes():** Returns a list of available goods types for reference or selection.
- **toString():** Provides a string representation of the goods type.

## 6. VehicleType Class
The VehicleType class enumerates the various types of vehicles used by delivery agents, ensuring consistency in the vehicle categorization process.

### Methods:
- **getVehicleTypes():** Returns a list of available vehicle types for reference or selection.
- **toString():** Provides a string representation of the vehicle type.

## 7. How It Works
When the program starts, it attempts to load existing agents from the agents.csv file. If the file is found, the agents are loaded into the system; otherwise, the application begins with an empty list.

### User Interface:
The application presents a menu-driven interface that allows users to choose from various operations. Users can:

- **Add New Agents:** The system prompts for necessary details, which are then validated before being added to the list.
- **Update Existing Agents:** Users can select an agent by index and modify their details as needed.
- **Delete Agents:** Agents can be removed from the list based on their index.
- **List All Agents:** Displays all agents currently managed, formatted in CSV style for easy readability.
- **Save Changes:** Users can manually save the current state of agents to the CSV file at any time, ensuring data persistence.
- **Exit:** When exiting, the system automatically saves all changes to the CSV file, preserving the current state for future sessions.

### Key Functionalities:

- **Data Persistence:** The agent information is loaded from and saved to a CSV file, ensuring data persists across sessions.
- **Encapsulation:** Private attributes like name, contactNumber, vehicleType, and availability are accessed via getters/setters.
- **Static Methods:** The fromCSV method helps load agents from a CSV string, simplifying data retrieval.
- **Error Handling:** Both reading and writing operations are wrapped in try-catch blocks to handle potential I/O errors gracefully, preventing program crashes.

This structure promotes modularity and extensibility, allowing for future enhancements like filtering agents by vehicle type or adding more attributes.
