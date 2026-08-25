public class Starbuzz {
    public static void main(String[] args) {
      
        // Creating a DarkRoast object and then wrapping it with a Milk decorator
        Beverage beverage = new DarkRoast();
        beverage = new Milk(beverage); // Adding milk to the dark roast

        // Outputting the description and cost of the first beverage
        System.out.println("Beverage 1: " + beverage.getDescription() + " $" + beverage.cost());

        // Constructing a HouseBlend beverage and enhancing it with Milk and Mocha decorators
        Beverage beverage2 = new HouseBlend(); // Start with a basic house blend
        beverage2 = new Milk(beverage2); // Add milk
        beverage2 = new Mocha(beverage2); // Add mocha

        // Displaying the details of the second, more complex beverage
        System.out.println("Beverage 2: " + beverage2.getDescription() + " $" + beverage2.cost());

    }
}
