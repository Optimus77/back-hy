import java.util.*;

public class Test19Final {

    final String hy;
    String hy2;

    public Test19Final(String hy) {
        this.hy = hy;

    }

    public static void main(String[] args) {
        Test19Final t = new Test19Final("1");
        Test19Final t2 = new Test19Final("2");
        System.out.println(t.hy);
        System.out.println(t2.hy);


//        List<String> l = new ArrayList<>();
//        List<String> l2 = new LinkedList<>();
//        l.add(null);
//        l.add(null);
//        l2.add(null);
//        l2.add(null);
//        Set<String> s = new HashSet<>();
//        s.add(null);
//        s.add(null);
//        System.out.println(l);
//        System.out.println(l2);
//        System.out.println(s);
//
//
//        Set<String> h = new HashSet<>();
//        h.add(null);
//        h.add(null);
//        System.out.println(h);
//
//        Set<String> lh = new LinkedHashSet<>();
//        lh.add(null);
//        lh.add(null);
//        System.out.println(lh);
    }

}
