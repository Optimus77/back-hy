package Thread;

public class MyThreadLocal {

    static ThreadLocal local =new ThreadLocal();

    static class ThreadA implements Runnable  {
        @Override
        public void run() {
            Thread.currentThread().setName("ThreadA");
            local.set("AAAAAAA");
            local.set("AAAAAAA2");
            System.out.println(Thread.currentThread().getName() +"     "+ local.get());
        }
    }

    static class ThreadB implements Runnable  {
        @Override
        public void run() {
            Thread.currentThread().setName("ThreadB");
            local.set("BBBBBBB");
            System.out.println(Thread.currentThread().getName() +"     "+ local.get());
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }

}
