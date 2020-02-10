package impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class Program implements Runnable {
    private Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private int interval;
    private String name;

    public String getName() {
        return name;
    }

    public Program(String name) {
        this.name = name;
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
        System.out.println("Program " + name + " was started");
    }

    public void stop() {
        running.set(false);
        System.out.println(name + " has been stopped");
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
          try {
            System.out.println("Thread with name " + name + " is running");
          Thread.sleep(15000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        System.out.println(
              "Thread was interrupted, Failed to complete operation");
            }
        // do something here
          }
        }
    }

