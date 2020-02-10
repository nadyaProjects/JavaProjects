package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Controller {

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    ExecutorService pool = Executors.newFixedThreadPool(10);

    Runnable p1 = new Program("task 1");
    Runnable p2 = new Program("task 2");
    Runnable p3 = new Program("task 3");
    Runnable p4 = new Program("task 4");
    Runnable p5 = new Program("task 5");
    Runnable p6 = new Program("task 7");
    Runnable p7 = new Program("task 8");
    Runnable p8 = new Program("task 8");
    Runnable p9 = new Program("task 9");
    Runnable p10 = new Program("task 10");
    Runnable name;

    {
        try {
            name = new Program(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void threadStart() {

        String line = null;
        while (true) {
            try {
                if (!!(line = br.readLine()).trim().equalsIgnoreCase("start" + " " + name)) ;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ("task 1".equals(name)) {
                pool.submit(p1);
                System.out.println("Task 1 is started");
            } else if ("task 2".equals(name)) {
                Thread.currentThread().run();
                System.out.println("Task 2 is started");
            } else if ("task 3".equals(name)) {
                pool.execute(p3);

                pool.execute(p4);
            } else if ("task 4".equals(name)) {
                pool.execute(p4);
            } else if ("task 5".equals(name)) {
                pool.execute(p5);
            } else if ("task 6".equals(name)) {
                pool.execute(p6);
            } else if ("task 7".equals(name)) {
                pool.execute(p7);
            } else if ("task 8".equals(name)) {
                pool.execute(p8);
            } else if ("task 9".equals(name)) {
                pool.execute(p9);
            } else if ("task 10".equals(name)) {
                pool.execute(p10);
            } else {
                throw new IllegalStateException("Unexpected value: " + name);
            }

            // Timer time = new Timer();

        }

    }

    public void threadStop() {

        String line = null;
        while (true) {
            try {
                if (!!(line = br.readLine()).trim().equalsIgnoreCase("stop" + " " + name)) ;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ("task 1".equals(name)) {
                Thread.currentThread().interrupt();
                System.out.println("Task 1 is stoped");
            } else if ("task 2".equals(name)) {
                Thread.currentThread().interrupt();
            } else if ("task 3".equals(name)) {
                Thread.currentThread().interrupt();

                Thread.currentThread().interrupt();
            } else if ("task 4".equals(name)) {
                Thread.currentThread().interrupt();
            } else if ("task 5".equals(name)) {
                Thread.currentThread().interrupt();
            } else if ("task 6".equals(name)) {
                Thread.currentThread().interrupt();
            } else if ("task 7".equals(name)) {
                Thread.currentThread().interrupt();
            } else if ("task 8".equals(name)) {
                Thread.currentThread().interrupt();
            } else if ("task 9".equals(name)) {
                Thread.currentThread().interrupt();
            } else if ("task 10".equals(name)) {
                Thread.currentThread().interrupt();
            } else {
                throw new IllegalStateException("Unexpected value: " + name);
            }


        }
    }
}