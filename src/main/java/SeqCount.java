public class SeqCount {
    class MyThreadLocal extends ThreadLocal<Integer> {
        public Integer initialValue() {
            return 0;
        }
    }

    class MyThreadLocal2 extends ThreadLocal<String> {
        public String initialValue() {
            return "hy";
        }
    }

    private ThreadLocal<Integer> seqCount = new MyThreadLocal();
    private ThreadLocal<String> seqCount2 = new MyThreadLocal2();

    public int nextSeq(){
        seqCount.set(seqCount.get() + 1);
        return seqCount.get();
    }
    public void setValue(int a){
        seqCount.set(a);
    }
    public void getValue(){
        System.out.println(seqCount.get() + seqCount2.get());
    }

    public static void main(String[] args){
        SeqCount seqCount = new SeqCount();
        SeqCount2 seqCount2 = new SeqCount2();
        SeqThread thread1 = new SeqThread(seqCount,seqCount2);
        SeqThread thread2 = new SeqThread(seqCount,seqCount2);
        SeqThread thread3 = new SeqThread(seqCount,seqCount2);
        SeqThread thread4 = new SeqThread(seqCount,seqCount2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private static class SeqThread extends Thread{
        private SeqCount seqCount;
        private SeqCount2 seqCount2;

        SeqThread(SeqCount seqCount){
            this.seqCount = seqCount;
        }

        SeqThread(SeqCount seqCount,SeqCount2 seqCount2){
            this.seqCount = seqCount;
            this.seqCount2 = seqCount2;
        }

        public void run() {
//            for(int i = 0 ; i < 3 ; i++){
//                System.out.println(Thread.currentThread().getName() + " seqCount :" + seqCount.nextSeq());
//            }
            seqCount.setValue(1);
            seqCount2.setValue(11);
            seqCount.getValue();
            seqCount2.getValue();
            seqCount.setValue(2);
            seqCount2.setValue(22);
            seqCount.getValue();
            seqCount2.getValue();
        }
    }
}