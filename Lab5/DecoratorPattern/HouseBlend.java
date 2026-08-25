//Vincent Fealy
//COSC 330 Lab 5
public class HouseBlend extends Beverage {
    final double HOUSE_BLEND_COST = 3.00; // Cost of HouseBlend
    final String DESCRIPTION = "House Blend"; // Updated description

    public HouseBlend() {
        description = DESCRIPTION;
    }

    // Method to calculate the cost of HouseBlend
    public double cost() {
        return HOUSE_BLEND_COST;
    }
}
