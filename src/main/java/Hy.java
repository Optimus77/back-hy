import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Hy {
    String hy = "hy";

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    static class thread1 implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try
            {
                try{condition.awaitNanos(1111L);}catch(InterruptedException e){}
                System.out.println(1);
            }
            finally
            {
                lock.unlock();
            }
        }
    }
    static class thread2 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try
            {
                try{condition.awaitNanos(1111L);}catch(InterruptedException e){}
                System.out.println(2);
            }
            finally
            {
                lock.unlock();
            }
        }
    }
    static class thread3 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try
            {
                try{condition.awaitNanos(1111L);}catch(InterruptedException e){}
                System.out.println(3);
            }
            finally
            {
                lock.unlock();
            }
        }
    }
    static class thread4 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try
            {
                try{
                    condition.awaitNanos(1111L);}catch(InterruptedException e){}
                System.out.println(4);
            }
            finally
            {
                lock.unlock();
            }
        }
    }
     public static void main(String[] args) throws InterruptedException {

//         for (;;){
//
//             try {
//                 throw new InterruptedException   ();
//
//             } catch (InterruptedException retry) {
//
//             }
//             System.out.println(CurrentTimeFunction.NAME);
//
//         }
        new Thread(new thread1()).start();
         new Thread(new thread2()).start();
         new Thread(new thread3()).start();
         new Thread(new thread4()).start();
     }


}
