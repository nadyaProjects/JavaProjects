package impl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ConsoleController {

    private Scanner sc = new Scanner(System.in);
    private String name = sc.next();

    public String getName() {
        return name;
    }

    //Thread thread = new Thread(new Program(name));
    //Runnable p1 = new Program("task 1");
    //Runnable p2 = new Program("task 2");
    //Runnable p3 = new Program("task 3");
    //Runnable p4 = new Program("task 4");
    //Runnable p5 = new Program("task 5");
    //Runnable p6 = new Program("task 7");
    //Runnable p7 = new Program("task 8");
    //Runnable p8 = new Program("task 8");
    //Runnable p9 = new Program("task 9");
    //Runnable p10 = new Program("task 10");
    //Set<Thread> threads = Thread.getAllStackTraces().keySet();

//for (Thread t : threads) static {
    // do something with each thread
    //  }

    ExecutorService executor = Executors.newFixedThreadPool(10);

    List<Callable<String>> callables = Arrays.asList(
            () -> "task1",
            () -> "task2",
            () -> "task3",
            () -> "task4",
            () -> "task5",
            () -> "task6",
            () -> "task7",
            () -> "task8",
            () -> "task9",
            () -> "task10");


    public void start() {

        //  try{
        //    executor.invokeAll(callables)
        //          .stream()
        //        .map(future -> {
        //          try {
        //            return future.get();
        //      } catch (Exception e) {
        //        throw new IllegalStateException(e);
        //  }
        //})

        // .forEach(System.out::println);
        //} catch (InterruptedException e) {
        //  e.printStackTrace();
        //}

        if (name.contains("start" + " " + callables.stream().toString().contains(name))) {

            executor.submit(() -> name);
        }
        System.out.println(callables + "is running");

        // private void run (String name){
    }

    public void stop() {


        //  try {
        //    executor.invokeAll(callables)
        //          .stream()
        //        .map(future -> {
        //          try {
        //            return future.get();
        //      } catch (Exception e) {
        //        throw new IllegalStateException(e);
        //  }
        //})

        //.forEach(System.out::println);
        //} catch (InterruptedException e) {
        //  e.printStackTrace();
        //}

        if (name.contains("start" + " " + callables.stream().toString().contains(name))) {
            executor.shutdown();
            System.out.println(callables + "is stopped");
        }

    }
}