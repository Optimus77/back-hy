import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test42MethodHandle {

    static class A {
        void println (String s) {
            System.out.println(s);

        }

    }

    MethodHandle getMethodFromRecevier(Object receiver) throws Throwable {
        MethodType m = MethodType.methodType(void.class,String.class);
        return MethodHandles.lookup().findSpecial(receiver.getClass(),"println",m,getClass());

    }






    public static void main(String[] args) throws Throwable {
//        Object obj = System.out;
        Object obj2 = new A();

        Test42MethodHandle t = new Test42MethodHandle();


        t.getMethodFromRecevier(obj2).invokeExact("hhhhhhhhhhhhhhhhh");
//        getMethodFromRecevier(obj).invokeExact("hhhhhhhhhhhhhhhhh");


    }

}
