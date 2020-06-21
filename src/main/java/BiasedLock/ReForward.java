package BiasedLock;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ReForward {

    public static void main(String[] args) throws Exception {
        //延迟5s，目的是启动偏向锁机制
        Thread.sleep(5000);

        //创造100个，偏向t1的，偏向锁
        List<A> listA = new ArrayList<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <100 ; i++) {
                A a = new A();
                synchronized (a){
                    listA.add(a);
                }
            }
            try {
                //为了防止JVM线程复用，在创建完对象后，保持线程t1状态为存活
                Thread.sleep(100000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();

        //睡眠3s钟保证线程t1创建对象完成
        Thread.sleep(10000);
        out.println(t1.isAlive());
        out.println("list中第20个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(19)).toPrintable()));

        //创建线程t2竞争线程t1中已经退出同步块的锁
        Thread t2 = new Thread(() -> {
            //这里面只循环了30次！！！
            for (int i = 0; i < 30; i++) {
                A a =listA.get(i);
                synchronized (a){
                    //分别打印第19次和第20次偏向锁重偏向结果
                    if(i==18||i==19){
                        out.println("第"+ ( i + 1) + "次偏向结果");
                        out.println((ClassLayout.parseInstance(a).toPrintable()));
                    }
                }
            }
//            try {
//                Thread.sleep(10000000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });
        t2.start();

        Thread.sleep(10000);
        out.println("打印list中第19个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(18)).toPrintable()));
        out.println("打印list中第20个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(19)).toPrintable()));
        out.println("打印list中第21个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(20)).toPrintable()));
        out.println("打印list中第30个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(29)).toPrintable()));
        out.println("打印list中第31个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(30)).toPrintable()));
        out.println("打印list中第41个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(40)).toPrintable()));
        out.println("打印list中第51个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(50)).toPrintable()));
        out.println("打印list中第100个对象的对象头：");
        out.println((ClassLayout.parseInstance(listA.get(99)).toPrintable()));
    }

}
