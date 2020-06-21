package Thread;

import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimestampFunction;
import org.springframework.data.auditing.CurrentDateTimeProvider;

public class StopThread_2_Interrupt搭配Sleep或检查点 {
    public static void main(String args[]) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        long stamp1 = System.currentTimeMillis();
        for (;;) {
            if (System.currentTimeMillis() == stamp1+2000)
            {break;}
        }

        t.interrupt();
        System.out.println(System.currentTimeMillis());
//        System.out.println(t.isInterrupted());
//        System.out.println(t);
//        Thread.sleep(2000);
//        System.out.println(System.currentTimeMillis());
//        System.out.println(t.isInterrupted());
    }

    static public class MyThread extends Thread {
        public void run() {
//            System.out.println(currentThread());
//            System.out.println(Thread.interrupted());
            for (;;) {
                if (!Thread.interrupted()) {System.out.println(1);} else { System.out.println(System.currentTimeMillis()); break; }

            }
//            Thread.currentThread().interrupt();
//            System.out.println(System.currentTimeMillis());
//            try {
//                Thread.sleep(111);
//                System.out.println(2);
//            } catch (InterruptedException e) {
//                System.out.println(System.currentTimeMillis());
//
//            }
//            System.out.println(1);
        }
    }


}
