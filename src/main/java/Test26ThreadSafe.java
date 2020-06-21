import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test26ThreadSafe {

//    private static Map<Integer,Integer> vector=new ConcurrentHashMap<>();
    private Vector<Integer> vector=new Vector<>();


    public static void main(String[] args){
        Test26ThreadSafe t = new Test26ThreadSafe();
//        t.hy();


//        while(true){
            for (int i=0;i<10;i++){
                t.vector.add(i);
            }
//            Thread removedThread=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    synchronized (vector) {
//                        for (int i = 0; i < vector.size(); i++) {
//                            vector.remove(i);
//                        }
//                    }
//                }
//            });
//
            Thread printThread=new Thread(new Runnable() {
                @Override
                public void run() {
//                    synchronized (vector) {
                        for (int i = 0; i < t.vector.size(); i++) {
                            System.out.println("i" + i);
                            Thread.currentThread().interrupt();
                            System.out.println(Thread.currentThread().isInterrupted());
                            System.out.println("size" + t.vector.size());
                            System.out.println((t.vector.get(i)));
                        }
//                    }
                }
            });
//            removedThread.start();
            printThread.start();
            printThread.interrupt();
            System.out.println(printThread.isInterrupted());



//            while(Thread.activeCount()>20) {
//                // 就永远陷在这里出不去
//            };
//            System.out.println("Thread.activeCount"+Thread.activeCount());
//        }
    }




}
