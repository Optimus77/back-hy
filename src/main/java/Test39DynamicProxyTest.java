import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test39DynamicProxyTest {


    interface I1 {
        void sayHello1_1(int i);
//        void sayHello1_2();
    }

    interface I2 {
        void sayHello2_1(int i);
        void sayHello2_2();
    }

    static class Impl implements I1 {

        @Override
        public void sayHello1_1(int i) {
            System.out.println("Hello1 sayHello1_1"+" "+i);
        }

//        @Override
//        public void sayHello1_2() {
//            System.out.println("Hello1 sayHello1_2");
//        }
    }

    static class Hello2 implements I2 {

        @Override
        public void sayHello2_1(int i) {
            System.out.println("Hello1 sayHello2_1"+" "+i);
        }

        @Override
        public void sayHello2_2() {
            System.out.println("Hello1 sayHello2_2");
        }
    }


    static class HyInvocationHandler implements InvocationHandler {

        Object target;

        public HyInvocationHandler(Object target) {
            this.target = target;
        }

            Object getProxy () {
            return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome "+method.getName());
            Object result = method.invoke(target,args);
            System.out.println("End "+method.getName());
            return result;
        }
    }


    public static void main(String[] args) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
//        I2 h2 = (I2) new HyInvocationHandler().bind(new Hello2());
//        h2.sayHello2_1(7);

        I1 i = new Impl();
        HyInvocationHandler p = new HyInvocationHandler(i);
        I1 proxy = (I1)p.getProxy();
        proxy.sayHello1_1(7);

        System.out.println(proxy.getClass().getName());
        System.out.println(i.getClass().getName());

        I2 i2 = new Hello2();
        HyInvocationHandler p2 = new HyInvocationHandler(i2);
        I2 proxy2 = (I2)p2.getProxy();
        proxy2.sayHello2_1(7);

        System.out.println(proxy2.getClass().getName());
        System.out.println(i2.getClass().getName());



    }

}
