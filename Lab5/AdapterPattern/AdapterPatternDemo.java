//Vincent Fealy
//COSC 330 Lab 5
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Shape aShape = new CircleAdapter();
        aShape.display();
    }
}
