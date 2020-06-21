//package Producer$Consumer;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Lock$Condition {
//    public static void main(String[] args) {
//        BufferArea bufferArea = new BufferArea();
//
//        //生产者线程
//        ProducerThread producer1 = new ProducerThread(bufferArea,"producer_1");
//
//        //消费者线程
//        ConsumerThread consumer1 = new ConsumerThread(bufferArea,"consumer_1");
//        ConsumerThread consumer2 = new ConsumerThread(bufferArea,"consumer_2");
//        ConsumerThread consumer3 = new ConsumerThread(bufferArea,"consumer_3");
//
//        producer1.start();
//        consumer1.start();
//        consumer2.start();
//        consumer3.start();
//    }
//}
//
//class BufferArea {
//    //维护一个此时缓冲区资源数量的int属性，根据某一时刻的数量来决定是我Condition的wait还是别人signalAll。
//    private int num = 0;
//
//    private Lock lock = new ReentrantLock();
//    Condition producerCondition = lock.newCondition();
//    Condition consumerCondition = lock.newCondition();
//    /**
//     * 向资源池中添加资源
//     */
//    public void add(){
//        lock.lock();
//        try{
//            if(num < 10){
//                num++;
//                System.out.println(Thread.currentThread().getName() +
//                        "生产一件资源,当前资源池有" + num + "个");
//                //唤醒等待的消费者
//                consumerCondition.signal();
////                consumerCondition.signalAll();
//
//            }else{
//                //让生产者线程等待
//                try {
//                    producerCondition.await();
//                    System.out.println(Thread.currentThread().getName() + "线程进入等待");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }finally{
//            lock.unlock();
//        }
//    }
//    /**
//     * 从资源池中取走资源
//     */
//    public void remove(){
//        lock.lock();
//        try{
//            if(num > 0){
//                num--;
//                System.out.println("消费者" + Thread.currentThread().getName()
//                        + "消耗一件资源," + "当前资源池有" + num + "个");
////                producerCondition.signalAll();
//                producerCondition.signal();
//            }else{
//                try {
//                    consumerCondition.await();
//                    System.out.println(Thread.currentThread().getName() + "线程进入等待");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }//让消费者等待
//            }
//        }finally{
//            lock.unlock();
//        }
//    }
//}
//
///**
// * 消费者线程
// */
//class ConsumerThread extends Thread{
//    private BufferArea resource;
//    public ConsumerThread(BufferArea resource,String threadName){
//        this.resource = resource;
//        setName(threadName);
//    }
//    public void run(){
//        while(true){
//            try {
//                Thread.sleep((long) (1000 * Math.random()));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            resource.remove();
//        }
//    }
//}
///**
// * 生产者线程
// * @author tangzhijing
// *
// */
//class ProducerThread extends Thread{
//    private BufferArea resource;
//    public ProducerThread(BufferArea resource,String threadName){
//        this.resource = resource;
//        setName(threadName);
//    }
//    public void run(){
//        while(true){
//            try {
//                Thread.sleep((long) (1000 * Math.random()));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            resource.add();
//        }
//    }
//}
//
