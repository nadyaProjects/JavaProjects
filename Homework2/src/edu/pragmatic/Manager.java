package edu.pragmatic;

public interface Manager {

    void managePeople();

    default void drinkCoffeeAllDay() {
        System.out.println("Drink coffee all day!");
    }
}
