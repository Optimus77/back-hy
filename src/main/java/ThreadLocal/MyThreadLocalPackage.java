package ThreadLocal;

public class MyThreadLocalPackage {

    static MyThreadLocalForInteger i = new MyThreadLocalForInteger();
    static MyThreadLocalForString s = new MyThreadLocalForString();

    void updateInteger (int update) {
        System.out.println("setInteger： " + Thread.currentThread().getName() + "  " + update);
        i.set(update);
    }

    void updateString(String update) {
        System.out.println("setString： " + Thread.currentThread().getName() + "  " + update);
        s.set(update);
    }

    void printMyThreadLocal () {
        System.out.println(Thread.currentThread().getName() + "__Integer:" + i.get() + "__String:" + s.get());
    }

    void hy() {
        MyThreadLocalForString s0 = s;
        s0.set("1");
        System.out.println(Thread.currentThread().getName() + "__String:" + s.get());
        s0 = null;
        System.out.println(Thread.currentThread().getName() + "__String:" + s.get());
        System.gc();
        System.out.println(Thread.currentThread().getName() + "__String:" + s.get());

    }

}

