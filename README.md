# WaterTank
Abstract Class: WaterTank class is an abstract base class that defines the common properties and methods of water tanks like filling the tank, using water, and retrieving the status of the tank.
<img width="1026" height="491" alt="Image" src="https://github.com/user-attachments/assets/1195ab38-915c-4b72-9182-f0fff97866eb" />

Subclasses: HomeTank and BuildingTank are the two subclasses of class WaterTank. Both subclasses implement the capacity (200 liters for HomeTank and 1000 liters for BuildingTank) and override the abstract methods to manage water levels.

User Interaction: The application uses JOptionPane for graphical user interface interaction, whereby users can choose the type of tank they desire to use. Users can enter the number of units of water to fill or use and the application alters the existing water level for them.

Status Checking: The program verifies the status of the tank after each operation, i.e., whether it is in use, empty, or full. The program continues to prompt for operations from the user until the tank is either empty or full and the program terminates with an appropriate message.
