package Traversal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TraversalHashSet {
    static Set<String> h = new HashSet();

    static {
        h.add("15");
        h.add("5");
        h.add("4");
        h.add("3");
        h.add("2");
        h.add("1");
    }

    static void iteratorHashSet (Set<String> h) {
        Iterator<String> it = h.iterator();

        while (it.hasNext()) {
            String s = it.next();
            System.out.println("element= " + s);
        }
    }

    static void enhancedForEach (Set<String> h) {
        for (String s : h) {
            System.out.println("element= " + s);
        }
    }

    static void jdk8ForEach (Set<String> h) {
        h.forEach((s)-> System.out.println("element= " + s));
    }


    static void ordinaryForEach (HashSet<String> h) {
        // 因为SET虽然有length，但是不能通过index下标来get元素，所以不能用普通for循环i++
    }

    public static void main(String[] args) {
        iteratorHashSet(h);
        enhancedForEach(h);
        jdk8ForEach(h);
    }

}
