//Vincent Fealy
//COSC 330 Lab 5
public class TestCafe {
    public static void main(String[] args) {
        // Test DarkRoast with Milk
        Beverage darkRoastWithMilk = new DarkRoast();
        darkRoastWithMilk = new Milk(darkRoastWithMilk); // Adding Milk
        System.out.println(darkRoastWithMilk.getDescription() 
                           + " $" + darkRoastWithMilk.cost());
        
        // Test HouseBlend with Mocha and Milk
        Beverage houseBlendWithMochaAndMilk = new HouseBlend();
        houseBlendWithMochaAndMilk = new Mocha(houseBlendWithMochaAndMilk); // Adding Mocha
        houseBlendWithMochaAndMilk = new Milk(houseBlendWithMochaAndMilk); // Adding Milk
        System.out.println(houseBlendWithMochaAndMilk.getDescription() 
                           + " $" + houseBlendWithMochaAndMilk.cost());
        
        // Test DarkRoast with double Mocha
        Beverage darkRoastWithDoubleMocha = new DarkRoast();
        darkRoastWithDoubleMocha = new Mocha(darkRoastWithDoubleMocha); // Adding first Mocha
        darkRoastWithDoubleMocha = new Mocha(darkRoastWithDoubleMocha); // Adding second Mocha
        System.out.println(darkRoastWithDoubleMocha.getDescription() 
                           + " $" + darkRoastWithDoubleMocha.cost());
    }
}
