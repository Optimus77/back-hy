//package Producer$Consumer;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.Semaphore;
//
//public class Semaphore$ {
//
//    public static void main(String[] args) {
//        BufferArea bufferArea = new BufferArea();
//        //生产者线程
//        ProducerThread p1 = new ProducerThread(bufferArea, "producer_1");
//        ProducerThread p2 = new ProducerThread(bufferArea, "producer_2");
//        ProducerThread p3 = new ProducerThread(bufferArea, "producer_3");
//        ProducerThread p4 = new ProducerThread(bufferArea, "producer_4");
//        //消费者线程
//        ConsumerThread c1 = new ConsumerThread(bufferArea, "consumer_1");
//        ConsumerThread c2 = new ConsumerThread(bufferArea, "consumer_2");
//        ConsumerThread c3 = new ConsumerThread(bufferArea, "consumer_3");
//        ConsumerThread c4 = new ConsumerThread(bufferArea, "consumer_4");
//        p1.start();
//        p2.start();
//        p3.start();
//        p4.start();
//        c1.start();
////        c2.start();
////        c3.start();
////        c4.start();
//    }
//}
//    /**
//     * 缓冲区
//     */
//    class BufferArea {
//        //缓冲区的最大容积
//        Semaphore emptyCount = new Semaphore(4);
//        //固定写法，写死0
//        Semaphore fullCount = new Semaphore(0);
//        //互斥量，用于多生产者/消费者场景，使put/take操作在某一个时刻只能被一个生产者/消费者执行。
//        Semaphore isUse = new Semaphore(1);
//        //表示生产者消费者的操作结果，最大值是缓冲区的最大容积，最小值是0。并不是通过它来阻塞/唤醒线程（其实和Semaphore的permit作用是一样的）
//        private int num = 0;
//
////        List list = new LinkedList<Integer>();
//
//        public void put(){
//            try {
////                isUse.acquire();
//                emptyCount.acquire();
//                isUse.acquire();
//                num++;
////                System.out.println("producer--"+ Thread.currentThread().getName()+"--num:" + num);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
////                isUse.release();
//                fullCount.release();
//                isUse.release();
//                System.out.println("producer--"+ Thread.currentThread().getName()+"--num:" + num);
//
//
//            }
//        }
//        public void get(){
//            try {
////                isUse.acquire();
//                fullCount.acquire();
//                isUse.acquire();
//                num--;
////                System.out.println("consumer--"+ Thread.currentThread().getName()+"--num:" + num);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
////                isUse.release();
//                emptyCount.release();
//                System.out.println("consumer--"+ Thread.currentThread().getName()+"--num:" + num);
//                isUse.release();
//
//            }
//        }
//    }
//
//    class ProducerThread extends Thread{
//        private BufferArea bufferArea;
//        public ProducerThread(BufferArea bufferArea,String threadName) {
//            this.bufferArea = bufferArea;
//            setName(threadName);
//        }
//
//
//
//        @Override
//        public void run() {
//            for(;;){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                bufferArea.put();
//            }
//        }
//    }
//    class ConsumerThread extends Thread{
//        private BufferArea bufferArea;
//
//        public ConsumerThread(BufferArea bufferArea,String threadName) {
//            this.bufferArea = bufferArea;
//            setName(threadName);
//        }
//
//        @Override
//        public void run() {
//            for(;;){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                bufferArea.get();
//            }
//        }
//    }
