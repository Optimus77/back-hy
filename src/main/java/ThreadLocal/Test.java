package ThreadLocal;

public class Test {

    public static void main(String[] args) {
        MyThreadLocalPackage p = new MyThreadLocalPackage();
        new Thread1(p,"THREAD_1").start();
//        new Thread2(p,"THREAD_2").start();

    }

}


class Thread1 extends Thread {
    MyThreadLocalPackage p;

    public Thread1 (MyThreadLocalPackage p, String threadName) {
        this.p = p;
        setName(threadName);
    }

    @Override
    public void run() {
//        p.updateInteger(1);
//        p.updateString("String1");
//        p.updateString("String1.version2");
//        p.printMyThreadLocal();
        p.hy();
    }
}

class Thread2 extends Thread {
    MyThreadLocalPackage p;

    public Thread2 (MyThreadLocalPackage p, String threadName) {
        this.p = p;
        setName(threadName);
    }

    @Override
    public void run() {
        p.updateInteger(2);
        p.updateString("String2");
        p.updateString("String2.version2");
        p.printMyThreadLocal();
    }
}