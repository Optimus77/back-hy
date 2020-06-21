import java.util.*;

public class Test23Iterator {




    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }

        Map<String,Integer> m = new TreeMap<>();
        for (Integer i = 100 ; i > 0 ; i-- ) {
            m.put(i.toString(),i);
        }


//        Traversal<String> iterator = list.iterator();
//        int i = 0 ;
//        while(iterator.hasNext()) {
//            if (i == 3) {
////                list.remove(3);
//                iterator.remove();
//            }
//            System.out.println(iterator.next());
//            i ++;
//        }
//        System.out.println(list);


//         for (String s:list) {
//             if (s.equals("3")) {
//                 list.remove(s);
////                 list.add(s);
//             }
//             System.out.println(s);
//         }

//        for (int i = 0 ; i < list.size() ; i++ ) {
//            if (i == 3) {
//                list.remove(i);
//            }
//            System.out.println(list.get(i));
//        }


//        Traversal it = m.entrySet().iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        for (Map.Entry<String,Integer> e :m.entrySet()) {
            System.out.println(e);
        }


//        System.out.println(m.keySet());





    }


}
