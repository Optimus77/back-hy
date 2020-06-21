import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;


public class Test34DirectMemoryOOM {

    private static int _1MB = 1024*1024;
//    private static final sun.misc.Unsafe U;

//    static {
//        try {
//            U = sun.misc.Unsafe.getUnsafe();
//        } catch (Exception e) {
//            throw new Error(e);
//        }
//    }


    public static void main(String[] args) {
        try {
            Field UnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            UnsafeField.setAccessible(true);
            Unsafe u = (Unsafe)UnsafeField.get(null);

            while(true){
                u.allocateMemory(_1MB);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }




    }
}
