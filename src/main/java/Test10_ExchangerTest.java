import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Test10_ExchangerTest {

    //交易大厅
    static Exchanger<List<String>> exchanger = new Exchanger<List<String>>();

    static class Producer implements Runnable{

        //生产者的箱子
        private List<String> buffer = new ArrayList<String>();

        @Override
        public void run() {
            for(int i = 1 ; i < 5 ; i++){
                System.out.println("生产者第" + i + "次提供");
                for(int j = 1 ; j <= 3 ; j++){
                    System.out.println("生产者装入" + i  + "--" + j);
                    buffer.add("buffer：" + i + "--" + j);
                }

                System.out.println("生产者装满，等待与消费者交换...");
                try {
                    exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        //消费者的箱子
        private List<String> buffer = new ArrayList<String>();

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                //调用exchange()与消费者进行数据交换
                try {
                    buffer = exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("消费者第" + i + "次提取");
                for (int j = 1; j <= 3 ; j++) {
                    System.out.println("消费者 : " + buffer.get(0));
                    buffer.remove(0);
                }
            }
        }
    }

    public static void main(String[] args){
//        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}