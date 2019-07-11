import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        ExecutorService workStealingPool = Executors.newWorkStealingPool();



        /*
        *   scheduledThreadPool适用于执行周期任务，
        *   scheduledThreadPool有两种玩法，scheduleAtFixedRate和scheduleWithFixedDelay。
        *   scheduledThreadPool.scheduleAtFixedRate（
        *                                   传入周期任务;
        *                                   第一次任务需要演示多久开始;
        *                                   两次任务开始时刻的间隔（如果任务执行时间大于间隔，则后一个任务需要前一个任务结束之后立即开始）；
        *                                   时间单位
        *                                   ）
        *    scheduledThreadPool.scheduleWithFixedDelay（
        *                                       传入周期任务;
        *                                       第一次任务需要演示多久开始;
        *                                       上次任务结束时刻与下次任务开始时刻的间隔；
        *                                       时间单位
        *                                       ）
        *
        * */
        ((ScheduledExecutorService) scheduledThreadPool).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("first thread delay 10 seconds, and every 3 seconds Execute one thread");
            }
        }, 10, 3, TimeUnit.SECONDS);

        ((ScheduledExecutorService) scheduledThreadPool).scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("first thread delay 10 seconds, and every 3 seconds between old thread done and new thread begin" );
            }
        }, 10, 3, TimeUnit.SECONDS);

    }
}
