import java.util.ArrayList;
import java.util.List;

/*
*   VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
* */

public class Test29OutOfMemory {

    Object instance;

    static class OOMObject {

    }

    static class GcObject {
        public Object instance = null;
    }


    public static void main(String[] args) {
//        testGC();
        List<OOMObject> list = new ArrayList<>();
        while(true) list.add(new OOMObject());
    }


    public static void testGC () {
        GcObject obj1 = new GcObject();
        GcObject obj2 = new GcObject();
        obj1.instance = obj2;
        obj2.instance = obj1;

        obj1=null;
        obj2=null;

        System.gc();


    }
}
