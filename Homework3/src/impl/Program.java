package impl;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;



public class Program implements Runnable{


    public Program(String s) {
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Running " + name);
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "is running");
            }
        };
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(repeatedTask, 1500L, 1500L);
        // System.out.println("TimerTask started");
        TimerTask countActiveThreads = new TimerTask() {
            public void run() {
                System.out.println("Treads running:" + Thread.activeCount());
            }
        };
        Timer timer1 = new Timer(true);
        timer.scheduleAtFixedRate(countActiveThreads, 2500L, 2500L);
        }
    }