package animalKingdom;

public abstract class Animal {

    double weight;
    double height;
    String name;

    public Animal() {
    }

    public Animal(double weight, double height, String name) {
        this.weight = weight;
        this.height = height;
        this.name = name;
    }

    void eat() {
        System.out.println("Animal is eating");
    }

    void walk() {
        System.out.println("Animal is walking");
    }

    void fight() {
        System.out.println("Animal is figting");
    }

    abstract void run();

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}
