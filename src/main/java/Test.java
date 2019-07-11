import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {


    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService cachedThreadPool2 = Executors.newScheduledThreadPool(1);
        ExecutorService cachedThreadPool3 = Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadPool4 = Executors.newFixedThreadPool(1);
        ExecutorService cachedThreadPool5 = Executors.newWorkStealingPool();
    }
}
