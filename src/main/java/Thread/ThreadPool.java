package Thread;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPool {

     static class hy implements Runnable {

         @Override
         public void run() {
             String ass = null;
             ass.length();
             throw new NullPointerException();
         }
     }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService cachedThreadPoolPersonal = Executors.newCachedThreadPool(r -> {
            Thread t = new Thread(r);
            t.setUncaughtExceptionHandler(
                    (t1, e) -> {
                        System.out.println(t1.getName() + "线程抛出的异常"+e);
                    });
            return t;
        });
        cachedThreadPoolPersonal.submit(() -> {
            String a = null;
            a.length();
        });

        Future f = cachedThreadPool.submit(
//                new Callable<String>() {
////                    public String call() {
////                        return "hy";
////                    }
////                }

                () -> {
                        String a = null;
                        a.length();
//                        throw new NullPointerException();
                        return "hyCallable";
                }
        );

        try {  System.out.println(f.get());
        } catch (Exception e) {
            System.out.println(e);
        }

        Future f2 =cachedThreadPool.submit(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("hyRunnable");
//                    }
//                 }
                ()-> { System.out.println("hyRunnable"); }
        );
        System.out.println(f2.get());


        cachedThreadPool.execute(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("hyRunnable");
//                    }
//                 }

                   ()-> { System.out.println("hyRunnable"); }

        );




        ExecutorService cachedThreadPool2 = Executors.newCachedThreadPool();
        ScheduledExecutorService  scheduledThreadPool = Executors.newScheduledThreadPool(0);
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
        ExecutorService forkJoinPool = Executors.newWorkStealingPool();
//        forkJoinPool.submit();

        long start = System.currentTimeMillis();
//        ForkJoinPool forkJoinPool2 = ForkJoinPool.commonPool();
        ForkJoinPool forkJoinPool2 = new ForkJoinPool(4);
        ForkJoinTask<Long> forkJoinTask = forkJoinPool2.submit(new SumTask());
        System.out.println(Runtime.getRuntime().availableProcessors()-1);
        System.out.println("getParallelism: " + forkJoinPool2.getParallelism());
        System.out.println("getPoolSize: " + forkJoinPool2.getPoolSize());
        Long sum = forkJoinTask.get();
        System.out.println("getPoolSize: " + forkJoinPool2.getPoolSize());
        forkJoinPool2.shutdown();


        System.out.println("sum: " + sum);
        System.out.println("fork join elapse: " + (System.currentTimeMillis() - start));

    }


    private static class SumTask extends RecursiveTask<Long> {
        private long[] arr = new long[1000000];
        private int from = 0;
        private int to = arr.length;


        public SumTask(long[] arr, int from, int to) {
            this.arr = arr;
            this.from = from;
            this.to = to;
        }


        public SumTask() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            }
        }


        @Override
        protected Long compute() {
            // 小于1000的时候直接相加，可灵活调整，否则就拆分任务
            if (to - from <= 1000) {
                long sum = 0;
                for (int i = from; i < to; i++) {
                    // 模拟耗时
                    sum += (arr[i]/3*3/3*3/3*3/3*3/3*3);
                }
                return sum;
            }

            // 将此SumTask分成两个子任务，left和right
            int middle = (from + to) / 2;
            SumTask left = new SumTask(arr, from, middle);
            SumTask right = new SumTask(arr, middle, to);

            // 提交left任务
            left.fork();
            // 提交right任务
            right.fork();
            // 等待left计算完毕，取回结果
            Long leftResult = left.join();
            // 等待right计算完毕，取回结果
            Long rightResult = right.join();

            // 左结果+右结果
            return leftResult + rightResult;
        }
    }




}

