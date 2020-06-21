package Traversal;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class TraversalHashMap {

    static HashMap<String,String> map = new HashMap<>();

    static {
        map.put("15","10");
        map.put("4","10");
        map.put("3","10");
        map.put("2","10");
        map.put("1","10");
    }

    static void iteratorHashMap(HashMap<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("iterator entrySet "+"key= " + entry.getKey() + " and value= " + entry.getValue());
//            it.next();
//            it.remove();
        }

        Iterator<String> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            String key = it2.next();
            System.out.println("iterator keySet "+"value= " + map.get(key));
        }

        Iterator<String> it3 = map.values().iterator();
        while (it3.hasNext()) {
            String value = it3.next();
            System.out.println("iterator values "+"value= " + value);
        }
    }

    static void enhancedForEach (HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("enhancedForEach entrySet "+"key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        for (String s : map.keySet()) {
            String value = map.get(s);//得到每个key多对用value的值
            System.out.println("enhancedForEach keySet "+"value= " + value);
        }

        for (String v : map.values()) {
            System.out.println("enhancedForEach keySet "+"value= " + v);
        }

    }

    static void ordinaryForEach (HashMap<String, String> map) {
        //因为map没有length，也不能通过index下标来get元素，所以不能用普通for循环i++
    }

    static void jdk8ForEach (HashMap<String, String> map) {
        map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
        map.entrySet().forEach((entry) -> System.out.println("key: " + entry.getKey() +  " value:" +entry.getValue() ));
        map.keySet().forEach((key) -> System.out.println("key: " + key +  " value:" +map.get(key)));
        map.values().forEach((value) -> System.out.println(" value:" + value));
    }


    public static void main(String[] args) {
        iteratorHashMap(map);
//        enhancedForEach(map);
//        jdk8ForEach(map);

        TreeMap<String,String> map2 = new TreeMap<>();
        map2.put("15","10");
        map2.put("4","10");
        map2.put("3","10");
        map2.put("2","10");
        map2.put("1","10");
//        map2.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
        map2.entrySet().forEach((entry) -> System.out.println("key: " + entry.getKey() +  " value:" +entry.getValue() ));
//
//        PriorityBlockingQueue<String> p = new PriorityBlockingQueue();
//        p.forEach((e) -> System.out.println(e));


    }

}
