package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        cachedThreadPool.submit(
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
    }


}

