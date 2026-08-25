//Vincent Fealy
//COSC 330 Lab 5
public class TestAdapterPattern {
    public static void main(String[] args) {
        Shape circle1 = new Circle(5); // Assuming radius = 5
        Shape circle2 = new Circle(7); // Assuming radius = 7

        ShapeInterface circle1Adapter = new ShapeAdapter(circle1);
        ShapeInterface circle2Adapter = new ShapeAdapter(circle2);

        // Use the adapters to calculate area and perimeter
        System.out.println("Area of Circle 1: " + circle1Adapter.calculateArea());
        System.out.println("Perimeter of Circle 1: " + circle1Adapter.calculatePerimeter());

        System.out.println("Area of Circle 2: " + circle2Adapter.calculateArea());
        System.out.println("Perimeter of Circle 2: " + circle2Adapter.calculatePerimeter());
    }
}
