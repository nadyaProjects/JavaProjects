package edu.pragmatic;

public class Computer {

    int year;
    double price;
    boolean isNotebook;
    int hardDiskMemory;
    double freeMemory;
    String operationSystem;

    void changeOperationSystem(String newOperationSystem) {
        newOperationSystem = newOperationSystem;
        System.out.println("The new operation system is:" + newOperationSystem);
    }

    void useMemory(double memory) {
        if (memory > freeMemory) {
            System.out.println("Not enough free memory");
        } else {
            freeMemory = freeMemory - memory;
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "year=" + year +
                ", price=" + price +
                ", isNotebook=" + isNotebook +
                ", hardDiskMemory=" + hardDiskMemory +
                ", freeMemory=" + freeMemory +
                ", operationSystem='" + operationSystem + '\'' +
                '}';
    }
}
