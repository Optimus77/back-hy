package Thread;

public class StopThread_3_Stop {
    public static void main(String args[]) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        t.stop();
    }

    static public class MyThread extends Thread {
        public void run() {
            currentThread().stop();

        }
    }


}
