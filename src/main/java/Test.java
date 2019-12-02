import javax.persistence.Table;
import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    String name;



    public static void main(String[] args) {


        ConcurrentMap<String, String> wordCounts = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<String> copyOnWriterArrayList  =new CopyOnWriteArrayList();

        Map<String,String> map = new HashMap<>();
        Map<String,String> table = new Hashtable<>();

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        table.put("1","1");
        table.put("2","2");
        table.put("3","3");
        copyOnWriterArrayList.add("1");
        copyOnWriterArrayList.add("2");
        copyOnWriterArrayList.add("3");

        wordCounts.entrySet();
        wordCounts.put("1","1");

        for (String str : copyOnWriterArrayList) {
            copyOnWriterArrayList.remove(str);
        }

        Iterator<Map.Entry<String,String>> it =map.entrySet().iterator();
        while(it.hasNext()) {
            it.next();
            it.remove();
            System.out.println("aaa");
        }


        Iterator<Map.Entry<String,String>> it2 =table.entrySet().iterator();
        while(it2.hasNext()) {
            String name = it2.next().getKey();
            map.remove(name);
            System.out.println("bbb");
        }



//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
//        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
//        ExecutorService workStealingPool = Executors.newWorkStealingPool();
//
//        fixedThreadPool.shutdown();
//
//        /*
//        *   scheduledThreadPool适用于执行周期任务，
//        *   scheduledThreadPool有两种玩法，scheduleAtFixedRate和scheduleWithFixedDelay。
//        *   scheduledThreadPool.scheduleAtFixedRate（
//        *                                   传入周期任务;
//        *                                   第一次任务需要演示多久开始;
//        *                                   两次任务开始时刻的间隔（如果任务执行时间大于间隔，则后一个任务需要前一个任务结束之后立即开始）；
//        *                                   时间单位
//        *                                   ）
//        *    scheduledThreadPool.scheduleWithFixedDelay（
//        *                                       传入周期任务;
//        *                                       第一次任务需要演示多久开始;
//        *                                       上次任务结束时刻与下次任务开始时刻的间隔；
//        *                                       时间单位
//        *                                       ）
//        *
//        * */
//        ((ScheduledExecutorService) scheduledThreadPool).scheduleAtFixedRate(new MyRunnable() {
//            @Override
//            public void run() {
//                System.out.println("first thread delay 10 seconds, and every 3 seconds Execute one thread");
//            }
//        }, 10, 3, TimeUnit.SECONDS);
//
//        ((ScheduledExecutorService) scheduledThreadPool).scheduleWithFixedDelay(new MyRunnable() {
//            @Override
//            public void run() {
//                System.out.println("first thread delay 10 seconds, and every 3 seconds between old thread done and new thread begin" );
//            }
//        }, 10, 3, TimeUnit.SECONDS);
//
//
//
//
    }
}
