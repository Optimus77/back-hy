import sun.net.spi.nameservice.dns.DNSNameService;

import java.util.ArrayList;
import java.util.List;

public class Test41ClassLoader$ClassForName {


    void test () {

        try {

            Class c2 = Test41ClassLoader$ClassForName.class.getClassLoader().loadClass("Son");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {
        Test41ClassLoader$ClassForName t = new Test41ClassLoader$ClassForName();
        t.test();


        try {
            String s = "3";
            Class c = Class.forName("Son");
//            Class c2 = s.
//                    getClass().
//                    getClassLoader().
//
//                    loadClass("j");
//
//            Class c3 = new Son().getClass();
//            Class c4 = Son.class;

//            System.out.println(c==c2);
//            System.out.println(c3==c4);
//            System.out.println(c==c3);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}
