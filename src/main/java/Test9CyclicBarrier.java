import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Test9CyclicBarrier {

    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread{
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            //等待
            try {
                System.out.println(cyclicBarrier.isBroken());
                cyclicBarrier.await();

                //Thread.sleep(1000);
                System.out.println(cyclicBarrier.isBroken());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("人到齐了，开会吧...."));

        for(int i = 0 ; i < 5; i++){
            new CyclicBarrierThread().start();
        }

//        try {
//            new CyclicBarrierThread().start();
//            Thread.sleep(1000);
//            new CyclicBarrierThread().start();
//            Thread.sleep(1000);
//            new CyclicBarrierThread().start();
//            Thread.sleep(1000);
//            new CyclicBarrierThread().start();
//            Thread.sleep(1000);
//            new CyclicBarrierThread().start();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




    }
}
