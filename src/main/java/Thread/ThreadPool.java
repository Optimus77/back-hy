package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(
                new Runnable() {
            @Override
            public void run() {
            }
        });
        cachedThreadPool.submit(
                new Callable<String>() {
                    public String call() {
                        System.out.println("hy");
                        return "hy";
                    }
                }
        );
        cachedThreadPool.submit(

        )
    }



}
