import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test11Hashmap {

    public static void main(String[] args) {
        Map m = new HashMap();
//        m.put(1,null);
//        m.put(17,null);
//        System.out.println(m.get(null));
//        System.out.println(m.containsKey(null));
//
//        m.put(null,null);
//        System.out.println(m.get(null));
//        System.out.println(m.containsKey(null));
//        m.put(null,1);
//        System.out.println(m.get(null));
//        System.out.println(m.containsKey(null));


//        /*1
//        * true
//        * null
//        * false
//        * */
//        String k1 = "K1",e;
//        String k2 = "K2";
//        m.put(k1,1);
//        System.out.println(m.get(k1));
//        System.out.println(m.containsKey(k1));
//        k1 = null;
//        System.out.println(m.get(k1));
//        System.out.println(m.containsKey(k1));
//        System.out.println(m.get("K1"));
//        System.out.println(m.containsKey("K1"));


        Map m2 = new ConcurrentHashMap();
//        m2.put(null,1);
//        m2.put(1,null);
//        m2.put(null,null);
        m2.entrySet().iterator();
        Map m3 = new Hashtable();
        m3.put(2,2);
        m3.put(1,1);

        System.out.println(m3);
    }


}
