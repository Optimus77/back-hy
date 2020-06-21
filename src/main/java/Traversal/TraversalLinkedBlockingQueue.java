package Traversal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class TraversalLinkedBlockingQueue {

    static Queue<String> q = new LinkedBlockingQueue();

    static {
        q.offer("15");
        q.offer("5");
        q.offer("4");
        q.offer("3");
        q.offer("2");
        q.offer("1");
    }

    static void iteratorQueue (Queue<String> q) {
        Iterator<String> it = q.iterator();

        while (it.hasNext()) {
            String s = it.next();
            System.out.println("element= " + s);
        }
    }

    static void enhancedForEach (Queue<String> q) {
        for (String s : q) {
            System.out.println("element= " + s);
        }
    }

    static void jdk8ForEach (Queue<String> q) {
        q.forEach((s)-> System.out.println("element= " + s));
    }


    static void ordinaryForEach (Queue<String> q) {
        // 因为Queue虽然有length，但是不能通过index下标来get元素，所以不能用普通for循环i++
    }

    public static void main(String[] args) {
        iteratorQueue(q);
        enhancedForEach(q);
        jdk8ForEach(q);
    }

}
