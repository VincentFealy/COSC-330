//Vincent Fealy
//COSC 330 Lab 5
public class Milk extends CondimentDecorator {
    final double MILK_COST = 0.50; // Cost of adding Milk
    Beverage beverage; // Reference to the beverage being decorated

    // Constructor to wrap a beverage with Milk
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    // Method to get description of the beverage with added Milk
    public String getDescription() {
        return "Milked " + beverage.getDescription(); // Prefix with "Milked" to the existing description
    }

    // Method to calculate the total cost including Milk
    public double cost() {
        return beverage.cost() + MILK_COST; // Add the cost of Milk to the beverage's cost
    }
}
