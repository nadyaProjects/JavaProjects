package animalKingdom;

public class Bird extends Animal {

    String pen;
    String beak;

    @Override
    void eat() {
        System.out.println("Bird is eating");
    }

    @Override
    void run() {
        System.out.println("Burd is running");
    }

    void fly() {
        System.out.println("Bird is flying");

    }

    @Override
    public String toString() {
        return "Bird{" +
                "pen='" + pen + '\'' +
                ", beak='" + beak + '\'' +
                '}';
    }
}
