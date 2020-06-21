import java.util.Map;
import java.util.WeakHashMap;

public class Test14_2WeakHashMap {

    public static void main(String[] args) {

        Map<String, Integer> map = new WeakHashMap<>(3);

        map.put(null, null);

        // 放入3个new String()声明的字符串
        map.put(new String("1"), 1);
        map.put(new String("2"), 2);
        map.put(new String("3"), 3);

        // 放入不用new String()声明的字符串
        map.put("6", 6);

//        String s1=null;
//        for (String s : map.keySet()) {
//            if (s.equals("1")) {
//                s1 = s;
//            }
//        }
//
//        String s2;
//        for (String s : map.keySet()) {
//            if (s.equals("2")) {
//                s2 = s;
//            }
//        }
//
//        String s3;
//        for (String s : map.keySet()) {
//            if (s.equals("3")) {
//                s3 = s;
//            }
//        }
        System.out.println(map);
        System.gc();
        System.out.println(map);

        for (String s : map.keySet()) {
            if (s==null) {
                System.out.println(s);
                System.out.println(map.get(s));
            }
        }
    }
}
