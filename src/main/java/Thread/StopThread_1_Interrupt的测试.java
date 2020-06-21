package Thread;

public class StopThread_1_Interrupt的测试 {
    public static void main(String args[]){
        Thread t = new MyThread();
        t.start();
        t.interrupt();
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.interrupted());
//        System.out.println(t.interrupted());
        System.out.println(t.isInterrupted());
        System.out.println(t.isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.currentThread().isInterrupted());

    }

    static public class MyThread extends Thread {
        public void run(){
//            for (;;) {
//
//                System.out.println(1);
//            }
            System.out.println(1);
            try {
                System.out.println(1);
                throw new InterruptedException();
                }catch (InterruptedException i) {


            }
            System.out.println(1);



        }
    }





}
