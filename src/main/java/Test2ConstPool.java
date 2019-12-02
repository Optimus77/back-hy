import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2ConstPool {

    static int a = 1;
    static String name = "name";
    static Integer i = 200;

//    public void test(int a,String name,Hy h){
//        a++;
//        name+="hh";
//        h.hy = "yyy";
//        System.out.println(a);
//        System.out.println(name);
//        System.out.println(h.hy);
//    }
//
//    public void test2(int a,String name,Hy h){
//        a=3;
//        name = "hh";
//        h = new Hy();
//        h.hy = "yyy";
//        System.out.println(a);
//        System.out.println(name);
//        System.out.println(h.hy);
//    }
//
//    public void test3(Integer i){
//        i++;
//        System.out.println(i);
//    }

    public static void main(String[] args) {
//        Test2ConstPool t = new Test2ConstPool();
//        Hy h =new Hy();
//        t.test3(i);
//        System.out.println(a);
//        System.out.println(name);
//        System.out.println(h.hy);
//        System.out.println(i);
//
//        List<String> l = new ArrayList();
//
//        Foo f = new Son();
//        f.fooMethod();

        char c = '韩';
        char c2 = 41;
        System.out.println(Integer.valueOf(c));
        System.out.println(c2);
        System.out.println(c2);

        System.out.println("name" == ("name"));
        String name1 = "name";
        String name2 = "name";
        System.out.println(name1 == name2);

        Integer i1 = 128;
        Integer i2 = 128;
        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);


        Lock lock = new ReentrantLock(true);
        lock.tryLock();


    }


}
