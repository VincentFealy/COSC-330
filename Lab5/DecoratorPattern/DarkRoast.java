//Vincent Fealy
//COSC 330 Lab 5
public class DarkRoast extends Beverage {
    final double DARK_ROAST_COST = 2.50; // Cost of Dark Roast
    final String DESCRIPTION = "Dark Roast"; // Updated description

    public DarkRoast() {
        description = DESCRIPTION;
    }

    // Method to calculate the cost of Dark Roast
    public double cost() {
        return DARK_ROAST_COST;
    }
}
