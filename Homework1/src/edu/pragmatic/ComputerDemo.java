package edu.pragmatic;

import java.lang.reflect.Field;

public class ComputerDemo {
    public static void main(String[] args) {
        Computer lenovo = new Computer();
        Computer dell = new Computer();

        lenovo.year = 2019;
        lenovo.hardDiskMemory = 500;
        lenovo.freeMemory = lenovo.hardDiskMemory;
        lenovo.isNotebook = true;
        lenovo.operationSystem = "Windows";

        dell.year = 2017;
        dell.hardDiskMemory = 300;
        dell.freeMemory = dell.hardDiskMemory;
        dell.isNotebook = true;
        dell.operationSystem = "Linux";

        lenovo.useMemory(100);
        dell.changeOperationSystem("Windows");

        System.out.println("Lenovo parameters:" + " " + lenovo.toString());
        System.out.println("Dell parameters:" + " " + dell.toString());

    }
}
