import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final ExecutorService executor = Executors.newCachedThreadPool();

        Point sharedPoint = new Point();

        for (int i = 0; i < 2000; i++) {
            executor.execute(/*new SingletonGetter()*/new PointMover(sharedPoint));
        }

        // tell the executor, that nothing will execute further
        executor.shutdown();

        // wait until all tasks complete
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {

        }

        // when complete, print final result
        System.out.println("Final point: " + sharedPoint.x); //expected 2000


    }
}
