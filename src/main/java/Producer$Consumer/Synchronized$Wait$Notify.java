//package Producer$Consumer;
//
//public class Synchronized$Wait$Notify {
//    public static void main(String[] args) {
//        BufferArea bufferArea = new BufferArea();
//        //生产者线程
//        ProducerThread p1 = new ProducerThread(bufferArea,"producer_1");
//        ProducerThread p2 = new ProducerThread(bufferArea,"producer_2");
//        ProducerThread p3 = new ProducerThread(bufferArea,"producer_3");
//        //消费者线程
//        ConsumerThread c1 = new ConsumerThread(bufferArea,"consumer_1");
//        ConsumerThread c2 = new ConsumerThread(bufferArea,"consumer_2");
//        ConsumerThread c3 = new ConsumerThread(bufferArea,"consumer_3");
//
//        p1.start();
//        p2.start();
//        p3.start();
//        c1.start();
//        c2.start();
//        c3.start();
//    }
//}
///**
// * 缓冲区
// */
//class BufferArea {
//    //维护某一时刻缓冲区内资源数量，用于阻塞/唤醒线程
//    private int num = 0;
//    //缓冲区最大容量，用于阻塞/唤醒线程
//    private int size = 10;
//
//    /**
//     * 消费者从缓冲区取走资源
//     */
//    public synchronized void remove(){
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        if(num > 0){
//            num--;
//            System.out.println("消费者" + Thread.currentThread().getName() +
//                    "消耗一件资源，" + "当前缓冲区有" + num + "个资源");
//            //唤醒正在等待的其他所有线程（包括生产者和消费者）
//            notifyAll();
//        }else{
//            try {
//                //如果缓冲区为空，则消费者进入等待状态，并释放锁
//                System.out.println("消费者" + Thread.currentThread().getName() + "线程进入等待状态");
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    /**
//     * 生产者向缓冲区中添加资源
//     */
//    public synchronized void add(){
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        if(num < size){
//            num++;
//            System.out.println("生产者" +Thread.currentThread().getName() + "生产一件资源，当前缓冲区有" + num + "个资源");
//            //唤醒正在等待的其他所有线程（包括生产者和消费者）
//            notifyAll();
//        }else{
//            try{
//                //如果缓冲区已满，则生产者进入等待状态，并释放锁
//                System.out.println("生产者" +Thread.currentThread().getName()+"线程进入等待");
//                wait();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
///**
// * 消费者线程
// */
//class ConsumerThread extends Thread{
//    private BufferArea bufferArea;
//    public ConsumerThread(BufferArea bufferArea,String threadName){
//        this.bufferArea = bufferArea;
//        setName(threadName);
//    }
//    @Override
//    public void run() {
//        while(true){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            bufferArea.remove();
//        }
//    }
//}
///**
// * 生产者线程
// */
//class ProducerThread extends Thread{
//    private BufferArea bufferArea;
//    public ProducerThread(BufferArea bufferArea,String threadName){
//        this.bufferArea = bufferArea;
//        setName(threadName);
//    }
//    @Override
//    public void run() {
//        //不断地生产资源
//        while(true){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            bufferArea.add();
//        }
//    }
//}
