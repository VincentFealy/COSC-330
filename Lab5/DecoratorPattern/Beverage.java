//Vincent Fealy
//COSC 330 Lab 5
public abstract class Beverage {
    String description = "Unknown Beverage";
    
    // Method to get the description of the beverage
    public String getDescription() {
        return description;
    }

    // Abstract method to calculate the cost of the beverage
    public abstract double cost();
}
