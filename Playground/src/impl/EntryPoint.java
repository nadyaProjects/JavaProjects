package impl;

import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {

        Os os = new Os();
        os.start();

    }

    private static void Wait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
