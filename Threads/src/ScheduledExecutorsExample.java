import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsExample {
    public static void main(String[] args) {

        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling: " +
                System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3,
                TimeUnit.SECONDS);
        try {
            TimeUnit.MILLISECONDS.sleep(1337);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms"
                , remainingDelay);
    }
}
