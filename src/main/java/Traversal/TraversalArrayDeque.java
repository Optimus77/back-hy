package Traversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TraversalArrayDeque {

    static Deque<String> q = new ArrayDeque();

    static {
        q.offer("15");
        q.offer("5");
        q.offer("4");
        q.offer("3");
        q.offer("2");
        q.offer("1");
    }

    static void iteratorDeque(Deque<String> q) {
        Iterator<String> it = q.iterator();

        while (it.hasNext()) {
            String s = it.next();
            System.out.println("element= " + s);
        }
    }

    static void enhancedForEach (Deque<String> q) {
        for (String s : q) {
            System.out.println("element= " + s);
        }
    }

    static void jdk8ForEach (Deque<String> q) {
        q.forEach((s)-> System.out.println("element= " + s));
    }


    static void ordinaryForEach (Deque<String> q) {
        // 因为Deque虽然有length，但是不能通过index下标来get元素，所以不能用普通for循环i++
    }

    public static void main(String[] args) {
        iteratorDeque(q);
        enhancedForEach(q);
        jdk8ForEach(q);
    }
}
