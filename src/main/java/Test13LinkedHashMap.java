import java.util.LinkedHashMap;
import java.util.Map;

public class Test13LinkedHashMap {
    public static void main(String[] args) {
        Map m2 = new LinkedHashMap(2,0.75f,false);
        m2.put(null,null);
        m2.put(1,1);
        m2.put(2,2);
        m2.put(3,3);
        m2.put(4,4);
        System.out.println(m2);
        m2.put(2,22);
        System.out.println(m2);
    }
}
