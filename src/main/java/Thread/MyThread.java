package Thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("hy");
    }

    public static void main(String[] args) {
        MyThread m =new MyThread();
        m.run();
    }

}
