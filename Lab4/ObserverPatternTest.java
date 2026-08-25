import java.util.ArrayList;

// Observer interface
interface Observer {
    void update(String magazineName);
}

// Subject interface
interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(String magazineName);
}

// Concrete Subject class
class Magazine implements Subject {
    private String magazineName;
    private ArrayList<Observer> subscribers;

    public Magazine(String magazineName) {
        this.magazineName = magazineName;
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String magazineName) {
        for (Observer subscriber : subscribers) {
            subscriber.update(magazineName);
        }
    }

    public void newEdition(String magazineName) {
        System.out.println("New edition of " + magazineName + " is published.");
        notifyObservers(magazineName);
    }
}

// Concrete Observer class
class Subscriber implements Observer {
    private String subscriberName;

    public Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(String magazineName) {
        System.out.println(subscriberName + ", new edition of " + magazineName + " is available.");
    }
}

// Test class
public class ObserverPatternTest {
    public static void main(String[] args) {
        Magazine nationalGeographic = new Magazine("National Geographic");
        Magazine timeMagazine = new Magazine("Time Magazine");

        Subscriber vincent = new Subscriber("Vincent");
        Subscriber connor = new Subscriber("Connor");
        Subscriber charlie = new Subscriber("Charlie");

        nationalGeographic.subscribe(vincent);
        nationalGeographic.subscribe(connor);
        timeMagazine.subscribe(connor);
        timeMagazine.subscribe(charlie);

        nationalGeographic.newEdition("National Geographic");
        timeMagazine.newEdition("Time Magazine");

        nationalGeographic.unsubscribe(connor);
        timeMagazine.unsubscribe(charlie);

        nationalGeographic.newEdition("National Geographic");
        timeMagazine.newEdition("Time Magazine");
    }
}
