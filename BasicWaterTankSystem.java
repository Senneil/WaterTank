import javax.swing.JOptionPane;

abstract class WaterTank {
     int capacity;
     int currentLevel;

    public WaterTank(int capacity) {
        this.capacity = capacity;
        this.currentLevel = 0;
    }

    // Abstract methods
    public abstract void fillTank(int liters);
    public abstract void useWater(int liters);
    public abstract String checkStatus();

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCapacity() {
        return capacity;
    }
}

class HomeTank extends WaterTank {
    public HomeTank() {
        super(200);
    }


    public void fillTank(int liters) {
        if (currentLevel + liters > capacity) {
            currentLevel = capacity;
        } else {
            currentLevel += liters;
        }
    }

    public void useWater(int liters) {
        if (currentLevel - liters < 0) {
            currentLevel = 0;
        } else {
            currentLevel -= liters;
        }
    }

    public String checkStatus() {
        if (currentLevel == capacity) {
            return "Tank is Full.";
        } else if (currentLevel == 0) {
            return "Tank is Empty.";
        } else {
            return "Tank is In Use.";
        }
    }
}

class BuildingTank extends WaterTank {
    public BuildingTank() {
        super(500);
    }


    public void fillTank(int liters) {
        if (currentLevel + liters > capacity) {
            currentLevel = capacity;
        } else {
            currentLevel += liters;
        }
    }


    public void useWater(int liters) {
        if (currentLevel - liters < 0) {
            currentLevel = 0;
        } else {
            currentLevel -= liters;
        }
    }


    public String checkStatus() {
        if (currentLevel == capacity) {
            return "Tank is Full.";
        } else if (currentLevel == 0) {
            return "Tank is Empty.";
        } else {
            return "Tank is In Use.";
        }
    }
}

public class BasicWaterTankSystem {
    public static void main(String[] args) {
        WaterTank tank = null;


        String[] options = {"HomeTank", "BuildingTank"};
        int choice = JOptionPane.showOptionDialog(null, "Choose type of tank:", "Water Tank",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

        if (choice == 0) {
            tank = new HomeTank();
        } else if (choice == 1) {
            tank = new BuildingTank();
        }


        while (tank != null) {
            String action = JOptionPane.showInputDialog("Enter liters to fill or use");
            if (action != null && !action.isEmpty()) {
                int liters = Integer.parseInt(action);
                if (liters > 0) {
                    tank.fillTank(liters);
                    JOptionPane.showMessageDialog(null, liters + " liters added. Current level: " + tank.getCurrentLevel() + "/" + tank.getCapacity());
                } else {
                    tank.useWater(-liters);
                    JOptionPane.showMessageDialog(null, (-liters) + " liters used. Current level: " + tank.getCurrentLevel() + "/" + tank.getCapacity());
                }


                String status = tank.checkStatus();
                JOptionPane.showMessageDialog(null, status);


                if (tank.getCurrentLevel() == 0) {
                    JOptionPane.showMessageDialog(null, "Tank is Empty! Program ended.");
                    break;
                } else if (tank.getCurrentLevel() == tank.getCapacity()) {
                    JOptionPane.showMessageDialog(null, "Tank is Full! Program ended.");
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
    }
}
