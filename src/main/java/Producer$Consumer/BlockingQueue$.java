//package Producer$Consumer;
//
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class BlockingQueue$ {
//
//    public static void main(String[] args) {
//        BufferArea ba = new BufferArea();
//
//        ProducerThread p1 = new ProducerThread(ba,"P_1");
//        ProducerThread p2 = new ProducerThread(ba,"P_3");
//        ProducerThread p3 = new ProducerThread(ba,"P_3");
//
//        ConsumerThread c1 = new ConsumerThread(ba,"C_1");
//        ConsumerThread c2 = new ConsumerThread(ba,"C_2");
//        ConsumerThread c3 = new ConsumerThread(ba,"C_3");
//
//        p1.start();
//        p2.start();
////        p3.start();
//        c1.start();
//        c2.start();
////        c3.start();
//    }
//}
//
//class BufferArea {
//
//    LinkedBlockingQueue<Integer> l = new LinkedBlockingQueue(10);
//
//    void put () {
//        try {
//            l.put(1);
//            System.out.println(Thread.currentThread().getName() + "  Put   " +l.size());
//        } catch (InterruptedException e) {
//            System.out.println(e.getStackTrace());
//        }
//    }
//
//    void remove () {
//        try {
//            l.take();
//            System.out.println(Thread.currentThread().getName() + "  Take   " +l.size());
//        } catch (InterruptedException e) {
//            System.out.println(e.getStackTrace());
//        }
//
//    }
//
//
//}
//
//
//class ProducerThread extends Thread {
//    BufferArea ba1;
//
//    public ProducerThread (BufferArea ba,String threadName) {
//        ba1 = ba;
//        setName(threadName);
//    }
//
//    @Override
//    public void run() {
//        for (;;) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(e.getStackTrace());
//            }
//            ba1.put();
//        }
//    }
//}
//
//class ConsumerThread extends Thread {
//    BufferArea ba2;
//
//    public ConsumerThread (BufferArea ba,String threadName) {
//        ba2 = ba;
//        setName(threadName);
//    }
//
//    @Override
//    public void run() {
//
//        for (;;) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(e.getStackTrace());
//            }
//            ba2.remove();
//        }
//
//    }
//}