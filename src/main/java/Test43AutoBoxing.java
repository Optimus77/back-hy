import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Test43AutoBoxing {

    public static void main(String[] args) {

//        Integer a= 1;
//        Integer b= 2;
//        Integer c= 3;
//        Integer d= 3;
//        Integer e= 321;
//        Integer f= 321;
//        Long g = 3L;
//        System.out.println(c==d);
//        System.out.println(e==f);
//        System.out.println(c==(a+b));
//        System.out.println(c.equals(a+b));
//        System.out.println(g==a+b);
//        System.out.println(g.equals(a+b));


                 Integer a = 1;
                 Integer b = 2;
                 Integer c = 3;
                 Integer d = 3;
                 Integer e = 321;
                 Integer f = 321;
                 Long g = 3L;
                   Long g2 = 3L;
                Double D = 3d;
        int x1 = 1;
        int x2 = 2;
                 int x = 3;
                 long y = 3L;
        long y2 = 2L;
                double z =3;
        double z2 =2;
                String s= "";
                List l = new ArrayList();


//                 System.out.println(x == y);
//               //System.out.println(c == g); 提示出错，不可比较的类型。说明此时没有自动拆箱
//                 System.out.println(c == d);
//                 System.out.println(e == f);
//                 System.out.println(c == (a+b));
//                 System.out.println(c.equals(a+b));
//                 System.out.println(g == (a+b));
//                 System.out.println(g.equals(a+b));
//
//                  System.out.println(c.equals(z));
//
//
////                System.out.println(c == x);
////                 System.out.println(c == g);
////                  System.out.println(c+c == g);
//                 System.out.println(c==z);
//        System.out.println(c.equals(z));

//        System.out.println(     D   ==   s  );
//        System.out.println(     z   ==   c   );
//        System.out.println(     (g+g2)   ==  (x+y)   );

        System.out.println(     g.equals(x)  );
        System.out.println(     g.equals(c)  );
        System.out.println(     g.equals(a+b)  );
        System.out.println(     g.equals(x1+x2)  );

        System.out.println(    D.equals(x1+z2)  );



    }


}
