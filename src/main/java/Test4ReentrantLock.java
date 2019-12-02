import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test4ReentrantLock {

    private Lock lock = new ReentrantLock();

    private Map<String, String> map = new HashMap<>();

    //声明读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //获取读锁
    private Lock readLock = readWriteLock.readLock();

    //获取写锁
    private Lock writeLock = readWriteLock.writeLock();

    private boolean isUpdate = true;

    /**
     * 读操作
     * @param key
     * @return
     */
    public String read(String key) {
        readLock.lock();
        readLock.newCondition();
        readLock.newCondition();
        writeLock.newCondition();
        lock.newCondition();
        System.out.println(Thread.currentThread().getName() + " 读操作正在执行。。。");
        try {
            Thread.sleep(2000);
            return map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }

    /**
     * 写操作
     * @param key
     * @param value
     */
    public void write(String key, String value) {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + " 写操作正在执行。。。");
        try {
            Thread.sleep(2000);
            map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 读写操作  锁的降级
     */
    public void readWrite(){
        readLock.lock();    //保证isUpdate是最新的数据
        if (isUpdate) {
            readLock.unlock();
            writeLock.lock();
            map.put("name", "admin");
            readLock.lock(); //锁的降级，如果此处不加读锁，直接执行下一步释放写锁，多线程情况下有可能又被写锁抢占资源，通过此方法实现将写锁降级为读锁
            writeLock.unlock();
        }

        String value = map.get("name");
        System.out.println(value);
        readLock.unlock();
    }

    public static void main(String[] args) throws Exception{
        Test4ReentrantLock readWriteLockTest = new Test4ReentrantLock();

//        //写操作测试  可以知道写操作是互斥的
//        Runnable runnable1 = () -> {
//            for (int i = 0; i < 5; i++) {
//                readWriteLockTest.write("key" + i, "value"+i);
//            }
//
//        };
//        new Thread(runnable1).start();
//        new Thread(runnable1).start();
//        new Thread(runnable1).start();
//
//        //读操作测试  可以知道读操作是可以并发执行的
//        Runnable runnable2 = () -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(readWriteLockTest.read("key" + i));
//            }
//
//        };
//        new Thread(runnable2).start();
//        new Thread(runnable2).start();
//        new Thread(runnable2).start();

        //读写操作测试 锁的降级
        Runnable runnable3 = () -> {
            for (int i = 0; i < 5; i++) {
                readWriteLockTest.readWrite();
            }

        };
        new Thread(runnable3).start();
        new Thread(runnable3).start();
        new Thread(runnable3).start();
    }
}
