//Vincent Fealy
//COSC 330 Lab 5
class CircleAdapter implements Shape {
    private AnotherCircle aCircle;

    public CircleAdapter() {
        aCircle = new AnotherCircle();
    }

    @Override
    public void display() {
        aCircle.displayIt();
    }
}
