package Traversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TraversalArrayList {

    static List<String> l = new ArrayList();

    static {
        l.add("15");
        l.add("5");
        l.add("4");
        l.add("3");
        l.add("2");
        l.add("1");
    }

    static void iteratorArrayList (List<String> l) {
        Iterator<String> it = l.iterator();
//        int i=0;
//        while (it.hasNext() && i==0) {
//            i=1;
////            it.next();
//            it.remove();
//        }

        while (it.hasNext()) {
            String s = it.next();
            System.out.println("element= " + s);
        }
    }

    static void enhancedForEach (List<String> l) {
        for (String s : l) {
            System.out.println("element= " + s);
        }
    }

    static void jdk8ForEach (List<String> l) {
        l.forEach((s)-> System.out.println("element= " + s));
    }


    static void ordinaryForEach (List<String> l) {
        for (int i =0 ; i< l.size() ; i++) {
            System.out.println("element= " + l.get(i));
        }
    }

    public static void main(String[] args) {
        iteratorArrayList(l);
        enhancedForEach(l);
        jdk8ForEach(l);
        ordinaryForEach(l);
    }

}


