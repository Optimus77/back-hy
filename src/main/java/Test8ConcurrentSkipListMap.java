import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Test8ConcurrentSkipListMap {

    public static void main(String[] args) {
        Map<String,String> c=  new ConcurrentSkipListMap();
//        c.put(null,null);
//        c.put("1","1");
//        c.put("1","1");
//
//        c.put("1","2");
//        c.put("2","2");
//        System.out.println(c);


        Map<Hy,Hy> c2=  new ConcurrentSkipListMap(new HyComparator());
        Hy h1 = new Hy();
        Hy h2 = new Hy();
        c2.put(null,null);
        c2.put(h1,h1);
        c2.put(h2,h2);

        TreeMap<Hy,Hy> t2=  new TreeMap(new HyComparator());
        t2.put(null,null);

    }



}

class HyComparator implements Comparator<Hy> {

    @Override
    public int compare(Hy o1, Hy o2) {
        System.out.println(o1);
        return 0;
    }
}