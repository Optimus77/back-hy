import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test20Copy {

    String[] hy = {"a"};
    String hy2 = "a";
    int hy3 = 1;

    String[] getSnapshot1() {
        return hy;
    }

    String getSnapshot2() {
        return hy2;
    }

    int getSnapshot3() {
        return hy3;
    }


//    void test (String[] snapshot) {
//        System.out.println(Arrays.toString(snapshot));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Arrays.toString(snapshot));
//        System.out.println(snapshot==getSnapshot1());
//    }


    public static void main(String[] args) {
        Test20Copy t = new Test20Copy();
//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println("hahaha");
//                t.hy[0]="cc";
//            }
//        }.start();
//
//        String[] snapshot = t.getSnapshot1();
//        t.test(snapshot);

        String[] s1 = t.getSnapshot1();
        String s2 = t.getSnapshot2();
        int s3 = t.getSnapshot3();

        System.out.println(Arrays.toString(s1));
        System.out.println(s2);
        System.out.println(s3);

        t.hy[0] = "bb";
        t.hy2 = "bb";
        t.hy3 = 2;

        System.out.println(Arrays.toString(s1));
        System.out.println(s2);
        System.out.println(s3);


    }

}
