package Thread;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        cachedThreadPool.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("hyRunnable");
                    }
        });

        Future<String> f = cachedThreadPool.submit(
//                new Callable<String>() {
////                    public String call() {
////                        return "hy";
////                    }
////                }

                () -> {
                    return "hyCallable";
                }
        );


        ExecutorService cachedThreadPool2 = Executors.newCachedThreadPool();
        ScheduledExecutorService  scheduledThreadPool = Executors.newScheduledThreadPool(5);
        Future<Integer> result = scheduledThreadPool.schedule(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int num = new Random().nextInt(100);//生成随机数
                System.out.println(Thread.currentThread().getName() + " : " + num);
                return num;
            }
        }, 3, TimeUnit.SECONDS);

        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();
    }





}

