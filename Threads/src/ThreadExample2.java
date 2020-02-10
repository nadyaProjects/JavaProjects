import java.util.concurrent.TimeUnit;

public class ThreadExample2 {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            try{
                String name = Thread.currentThread().getName();
                System.out.println("Foo" + name);
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Bar" + name);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
