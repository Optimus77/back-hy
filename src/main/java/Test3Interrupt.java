import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3Interrupt {

    private Lock lock = new ReentrantLock();

    public void doBussiness() {
        String name = Thread.currentThread().getName();

        try {
            System.out.println(name + " 开始获取锁");
            lock.lock();
            System.out.println(name + " 得到锁");
            System.out.println(name + " 开工干活");
            for (int i=0; i<5; i++) {
                System.out.println(name + " : " + i);
            }
        } finally {
            try {
                lock.unlock();
                System.out.println(name + " 释放锁");
            } catch (Exception e) {
                System.out.println(name + " : 没有得到锁的线程运行结束");
            }
        }
    }

    public static void main(String[] args) {

        Test3Interrupt test3 = new Test3Interrupt();

        Thread t0 = new Thread(
                new Runnable() {
                    public void run() {
                        test3.doBussiness();
                    }
                }
        );

        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        test3.doBussiness();
                    }
                }
        );

//        // 启动线程t1
        t0.start();
//        // 启动线程t2
        t1.start();
        // 线程t1没有得到锁，中断t1的等待
        t0.interrupt();
        t1.interrupt();
    }


}
