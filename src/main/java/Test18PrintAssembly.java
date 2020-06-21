public class Test18PrintAssembly {

    static int b=2;
    static int c=2;
    static String m = "";

    public int hy(){
        return b=3;
    }


   void hy2 () {
        synchronized (m) {
            try {
                m.wait(1000);
//                m.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {

        new Test18PrintAssembly().hy();
        new Test18PrintAssembly().hy2();
    }

}
