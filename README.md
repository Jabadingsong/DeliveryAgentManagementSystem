# DeliveryAgentManagementSystem
OOP FINAL PROJECT 2ND YEAR 

This code is a console-based Delivery Agent Management System, written in Java. It helps manage delivery agents by storing their details, allowing for operations such as adding, updating, deleting, listing, and searching agents. The system also supports persistence by saving agent data to and loading it from a CSV file. Here's an explanation of the main components:

## 1. DeliveryAgent Class
This class represents a delivery agent. It encapsulates key agent details such as:

- **name:** The full name of the agent.
- **contactNumber:** The agent’s phone number.
- **vehicleType:** Type of vehicle the agent uses (e.g., bike, car).
- **availability:** A boolean value indicating whether the agent is available for deliveries.

### Methods:
- **Getters and Setters:** Control access to the agent's private attributes, following the encapsulation principle of OOP (Object-Oriented Programming).
- **toCSV:** Converts the agent's details to a comma-separated string for easy CSV file storage.
- **fromCSV:** A static method that converts a CSV-formatted string back into a DeliveryAgent object.

## 2. DeliveryAgentManager Class
This class manages a list of delivery agents, providing CRUD operations (Create, Read, Update, Delete).

### Attributes:
- **agents:** A List of DeliveryAgent objects, representing all the agents currently managed.

### Methods:
- **addAgent(DeliveryAgent agent):** Adds a new agent to the list.
- **updateAgent(int index, DeliveryAgent updatedAgent):** Updates an agent's details based on the provided index.
- **deleteAgent(int index):** Removes an agent from the list based on the index.
- **saveToCSV(String filePath):** Saves the current list of agents to a CSV file using the CSVUtils.writeToCSV method.
- **loadFromCSV(String filePath):** Loads agents from a CSV file into the agents list using the CSVUtils.readFromCSV method.
- **searchByName(String name):** Searches agents by their name and returns a list of matching agents.
- **getAgents():** Returns the list of agents for viewing or further operations.

## 3. CSVUtils Class
This class handles reading and writing the agents' data to and from CSV files. It ensures the persistence of data between program sessions.

### Methods:
- **writeToCSV(String filePath, List<DeliveryAgent> agents):** Writes the list of agents to the specified CSV file. It uses a BufferedWriter for efficient file writing.
- **readFromCSV(String filePath):** Reads agents from a CSV file and returns them as a list. It uses a BufferedReader to read the file line by line and converts each line into a DeliveryAgent object using the DeliveryAgent.fromCSV method.

## 4. Main Class
The Main class is the entry point of the application. It contains a menu-driven user interface that allows users to perform various operations on the delivery agents. It uses a Scanner for input.

### Key Operations:
- **Add Agent:** Collects the agent's details from the user and adds the agent to the list using manager.addAgent.
- **Update Agent:** Allows the user to update an existing agent's details by specifying its index.
- **Delete Agent:** Removes an agent based on its index.
- **List All Agents:** Displays all agents, showing their details in CSV format.
- **Save Agents to CSV:** Saves the current agent list to the CSV file.
- **Exit:** Exits the application and automatically saves all changes to the CSV file.

### Key Functionalities:
- **Data Persistence:** Agent information is loaded from and saved to a CSV file using the CSVUtils class. This ensures that data persists even after the program is closed.
- **Encapsulation:** Attributes like name, contactNumber, vehicleType, and availability are private, and getters/setters are provided for controlled access.
- **Static Methods:** The DeliveryAgent class has a static method fromCSV to create DeliveryAgent objects from a CSV string, which helps load agents from the file easily.
- **Error Handling:** Both reading and writing CSV files are wrapped in try-catch blocks to handle any potential I/O errors and keep the program from crashing unexpectedly.

## How It Works:
When the program starts, it attempts to load existing agents from the `agents.csv` file. The user is presented with a menu to manage the agents: add new agents, update existing ones, delete them, or list them. The system saves the changes to the CSV file, either upon exiting or explicitly when the user chooses to do so. This structure promotes modularity and extensibility, allowing for further additions like filtering agents by vehicle type or expanding to include more attributes.
