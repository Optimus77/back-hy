public class SeqCount2 {
    class MyThreadLocal extends ThreadLocal<Integer> {
        public Integer initialValue() {
            return 0;
        }
    }

    class MyThreadLocal2 extends ThreadLocal<String> {
        public String initialValue() {
            return "hy2";
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

    private static class SeqThread extends Thread{
        private SeqCount seqCount;

        SeqThread(SeqCount seqCount){
            this.seqCount = seqCount;
        }


        public void run() {
//            for(int i = 0 ; i < 3 ; i++){
//                System.out.println(Thread.currentThread().getName() + " seqCount :" + seqCount.nextSeq());
//            }
            seqCount.setValue(1);
            seqCount.getValue();
            seqCount.setValue(2);
            seqCount.getValue();
            seqCount.setValue(3);
            seqCount.getValue();
        }
    }
}