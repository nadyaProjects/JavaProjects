package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;


public class Os {
    private ProgramManager pm = new ProgramManager();
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String name;


    public void start() {

        boolean running = true;
        String regex = "\\.*?";
        //programCount();
        while (running) {

            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line.trim().contains("start")) {
                name = line.replaceFirst("start", "").trim();
                pm.programStart(name);

            } else if (line.trim().contains("stop")) {
                name = line.replaceFirst("stop", "").trim();
                pm.programStop(name);
            } else if
            (line.trim().contains("shutdown")) {
                pm.closeAll();
                running = false;
            } else {
                System.out.println("Please proceed further.");
            }
        }
        System.out.println("Shutting down...");
    }

    private void programCount() {
        System.out.println("Programs with name " + pm.getRunningPrograms() + " are running");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Running programs are:" + pm.getProgramCount());
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}