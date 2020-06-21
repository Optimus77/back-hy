import java.util.Queue;
import java.util.concurrent.*;

public class Test21CurrentLinkQueueSynchronousQueueLinkedTransferQueue {


    public static void main(String[] args) {

        Queue<String> l = new LinkedBlockingQueue<>();
        l.offer("a");
        l.offer("a");
        System.out.println(l);

        Queue<String> q = new ConcurrentLinkedQueue<>();

        BlockingQueue<String> q2 = new SynchronousQueue<>();
//        try {
//            q2.put("a");
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        q2.offer("a");
//        q2.offer("a");
//        q2.poll();

//        System.out.println(q2.offer(null));

        q2.offer("a");
//        q2.offer(null);
//
        System.out.println(q2.offer("a"));
        System.out.println(q2);
        System.out.println(q2.poll());


        Queue<String> q3 = new LinkedTransferQueue();
        q3.offer("a");
        q3.offer("a");
//        q3.offer(null);
        System.out.println(q3);





    }

}
