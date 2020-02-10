package animalKingdom;

public class Cat extends Animal{

    @Override
    void eat() {
       System.out.println("Cat i eating");
    }

    @Override
    void run() {
        System.out.println("Cat is running");
    }

    void climb() {
        System.out.println("Cat is climbing");
    }
}
