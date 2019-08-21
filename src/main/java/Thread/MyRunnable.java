package Thread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("hy");
    }


    public static void main(String[] args) {
        Thread t =new Thread(new MyRunnable());
        t.run();
    }
}
