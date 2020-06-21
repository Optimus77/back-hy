import java.util.concurrent.CountDownLatch;

public class Test10CountDownLatch {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    /**
     * Boss线程，等待员工到达开会
     */
    static class BossThread extends Thread{
        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共有" + countDownLatch.getCount() + "个人开会...");
            try {

                //Boss等待
                countDownLatch.await();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("所有人都已经到齐了，开会吧...");
        }
    }

    static class BossThread2 extends Thread{
        @Override
        public void run() {
            System.out.println("2Boss在会议室等待，总共有" + countDownLatch.getCount() + "个人开会...");
            try {
                //Boss等待
                countDownLatch.await();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("2所有人都已经到齐了，开会吧...");
        }
    }

    //员工到达会议室
    static class EmpleoyeeThread  extends Thread{
        @Override
        public void run() {
//            System.out.println(Thread.currentThread().getName());
            //员工到达会议室 count - 1
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "，到达会议室....");
        }
    }

    public static void main(String[] args){
        //Boss线程启动
        new BossThread().start();
        new BossThread2().start();
        for(long i = 0,j = countDownLatch.getCount() ; i < j ; i++){
            new EmpleoyeeThread().start();
        }


        int flag = 31;

        System.out.println(flag&~(1<<2));
    }


}
