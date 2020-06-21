import java.util.Map;
import java.util.WeakHashMap;

public class Test14_1WeakHashMap {


    public static void main(String[] args) {

        Map<Integer, Integer> map = new WeakHashMap<>(3);

            WeakHashMap<Object, Object> map2 = new WeakHashMap<>();
//            Object key1= new Object();
//            Object value1= new Object();
//            Object key2= new Object();
//            Object value2= new Object();
//
//            map2.put(key1, value1);
//            map2.put(key2, value2);
//              System.out.println(map2);
//              System.out.println(map2.toString());
//            key1 = null;
//            System.gc();
//            System.out.println(map2.get(key1));
//            System.out.println(map2);
//            System.out.println(map2.toString());

            Object h= new Hy();
            Object hh= new Hy();
        map2.put(null,1);
        map2.put(h,hh);
        System.out.println(map2);
        h=null;
        map2.put(null,2);
        System.out.println(map2);
        System.gc();
        System.out.println(map2);



        // 放入3个new String()声明的字符串
        map.put(new Integer(1), 1);
        map.put(new Integer("2"), 2);
        map.put(new Integer("3"), 3);

        // 放入不用new String()声明的字符串
        map.put(6, 6);
        map.put(200, 200);

//        Integer hanyang;
//        for (Integer i1 : map.keySet()) {
//            if (i1==1) {
//                hanyang = i1;
//            }
//        }
//
//        Integer hanyang2;
//        for (Integer i2 : map.keySet()) {
//            if (i2==2) {
//                hanyang2 = i2;
//            }
//        }
//
//        Integer hanyang3;
//        for (Integer i3 : map.keySet()) {
//            if (i3==3) {
//                hanyang3 = i3;
//            }
//        }

        System.out.println(map);

        // gc一下
        System.gc();

        System.out.println(map);


//        // 放一个new String()声明的字符串
//        map.put(new String("4"), 4);
//
//        // 输出{4=4, 6=6, 3=3}，gc后放入的值和强引用的key可以打印出来
//        System.out.println(map);
//
//        // key与"3"的引用断裂
//        key = null;
//
//        // gc一下
//        System.gc();
//
//        // 输出{6=6}，gc后强引用的key可以打印出来
//        System.out.println(map);

    }

}
