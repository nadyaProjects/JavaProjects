package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OperatingSystem {


    public void start() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Controller cl = new Controller();
        ConsoleController cc = new ConsoleController();
        OperatingSystem os = new OperatingSystem();

        System.out.println("Start your program:");
        boolean line;
        try {
            if ((line = br.readLine().contains("start"))) {

                cl.threadStart();
            } else if
            ((line = br.readLine().contains("stop"))) {
                cl.threadStop();
            } else if (line = br.readLine().trim().equalsIgnoreCase("shutdown")) {
                os.shutdown();
            } else {
                System.out.println("There is no such program.");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
os.runningProgramCount();
    }

    public void shutdown() {
        ExecutorService pool = Executors.newFixedThreadPool(Thread.activeCount());
        System.out.println("Shutting down...");

        pool.shutdown();

        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!pool.isTerminated()) {
                System.err.println("Cancel non-finished tasks");

                pool.shutdownNow();
                System.out.println("Shutdown finished");

            }
        }
    }

    public void runningProgramCount() {
        System.out.println("Running programs are:" + Thread.activeCount());
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "is running");
            }
        };
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(repeatedTask, 15L, 15L);
        // System.out.println("TimerTask started");
        TimerTask countActiveThreads = new TimerTask() {
            public void run() {
                System.out.println("Treads running:" + Thread.activeCount());

            }
        };
    }
}