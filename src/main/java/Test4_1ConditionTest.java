import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test4_1ConditionTest {
    private LinkedList<String> buffer = new LinkedList<>();    //容器
    private int maxSize = 10;           //容器最大
    private Lock lock = new ReentrantLock();
    private Condition needGetCondition = lock.newCondition();
    private Condition needSetCondition = lock.newCondition();

//    Test4_1ConditionTest(int maxSize){
//        this.maxSize = maxSize;
//        buffer = new LinkedList<String>();
//        lock = new ReentrantLock();
//        needGetCondition= lock.newCondition();
//        needSetCondition= lock.newCondition();
//    }

    public void set(String string) throws InterruptedException {
        lock.lock();    //获取锁
        try {
            while (maxSize == buffer.size()){
                needSetCondition.await();       //满了，添加的线程进入等待状态
            }

            buffer.add(string);
            needGetCondition.signal();
        } finally {
            lock.unlock();      //记得释放锁
        }
    }

    public String get() throws InterruptedException {
        String string;
        lock.lock();
        try {
            while (buffer.size() == 0){
                needGetCondition.await();
            }
            string = buffer.poll();
            needSetCondition.signal();
        } finally {
            lock.unlock();
        }
        return string;
    }
}
