package BiasedLock;

import org.openjdk.jol.info.ClassLayout;

public class PrintObject {

    public static void main(String[] args) throws InterruptedException{
        Thread.sleep(5000);
        A a = new A();
//        synchronized (a) {
//            System.out.println(ClassLayout.parseInstance(a).toPrintable());
//        }
//        System.out.println("main ===========================");
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        Thread t1 = new Thread(() -> {
            synchronized (a){
                System.out.println("thread1 locking===========================");
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }

        });
        t1.start();
//        t1.join();
//        Thread.sleep(10000);

        synchronized (a){
            System.out.println("main locking===========================");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}
