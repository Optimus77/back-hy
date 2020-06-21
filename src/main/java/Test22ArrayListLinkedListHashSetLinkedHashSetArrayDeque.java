import java.util.*;

public class Test22ArrayListLinkedListHashSetLinkedHashSetArrayDeque {


    public static void main(String[] args) {
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


//        Set<String> h = new HashSet<>();
//        h.add(null);
//        h.add(null);
//        System.out.println(h);
//
//        Set<String> h2 = new TreeSet<>();
//        h2.add(null);
//        h2.add(null);
//        System.out.println(h2);


//        Set<String> lh = new LinkedHashSet<>();
//        lh.add(null);
//        lh.add(null);
//        System.out.println(lh);
//
//
//        Deque<String> deque = new ArrayDeque<>();
//        deque.addFirst("a");
//        deque.addFirst("a");
        //deque.addFirst(null);
//
//        deque.getFirst();

        Deque<Integer> deque = new ArrayDeque<>(8);
//        System.out.println(deque.size());
        deque.addLast(0);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(7);
        deque.addFirst(8);
        System.out.println(deque);
    }


}
