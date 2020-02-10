package impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProgramManager {
    private List<Program> programs = new ArrayList<Program>();

    public void programStart(String name) {
        Program p = new Program(name);
        p.start();
        programs.add(p);
    }

    public String getRunningPrograms(){
        String result = "";
        for (Program p : programs){
            result += p.getName() + " ";
        }
        return  result;
    }

    public void programStop(String name) {
        for (int i = 0; i < programs.size(); i++) {
            Program p = programs.get(i);
            if (p.getName().equals(name)) {
                p.stop();
                programs.remove(i);
            }
        }
    }

    public int getProgramCount() {
        return programs.size();
    }

    public void closeAll() {
        for (Program p: programs) {
            p.stop();
        }
    }
}

