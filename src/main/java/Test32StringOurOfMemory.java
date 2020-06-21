
/*
* -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * */

import java.util.ArrayList;
import java.util.List;

public class Test32StringOurOfMemory {
    public static void main(String[] args) {
        List<String> l = new ArrayList();
        int i=1;
        while(true){
            l.add(String.valueOf(++i).intern());

            if (i==5000000) {
                System.out.println(i);

            }
            if (i==6000000) {
                System.out.println(i);

            }
        }

    }


}
