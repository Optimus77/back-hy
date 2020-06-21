import java.util.Map;
import java.util.TreeMap;

public class Test16Treemap {

    public static void main(String[] args) {
        new Test16Treemap().testTreeMap();
    }


    public class HHH implements Comparable<HHH> {
        @Override
        public int compareTo(HHH o) {
            return 0;
        }
    }

    public class HHH2 {
    }

    void testTreeMap () {
        Map<HHH,String> m = new TreeMap();
        Map<HHH2,String> m2 = new TreeMap();
//        m.put(new HHH(),"1");
//        m.put(new HHH(),"11");
//        m2.put(new HHH2(),"2");
//        m2.put(new HHH2(),"22");
//        System.out.println(m);
//        System.out.println(m2);

        Map<String,String> m3 = new TreeMap();
        m3.put("2","2");
        m3.put("22","22");
        System.out.println(m3);
        m3.toString();
        m3.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });
    }


}
