//Vincent Fealy
//COSC 330 Lab 5
public class Mocha extends CondimentDecorator {
    final double COST = 0.75; // Cost of adding Mocha
    Beverage beverage; // Reference to the beverage being decorated

    // Constructor to wrap a beverage with Mocha
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    // Method to get description of the beverage with added Mocha
    public String getDescription() {
        return beverage.getDescription() + ", Mocha"; // Append Mocha to the existing description
    }

    // Method to calculate the total cost including Mocha
    public double cost() {
        return COST + beverage.cost(); // Add the cost of Mocha to the beverage's cost
    }
}
