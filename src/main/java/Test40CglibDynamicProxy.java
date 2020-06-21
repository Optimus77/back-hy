
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test40CglibDynamicProxy {

    static class Hello1 {

        public void sayHello1_1(int i) {
            System.out.println("Hello1 sayHello1_1"+" "+i);
        }

//        public void sayHello1_2() {
//            System.out.println("Hello1 sayHello1_2");
//        }
    }


    static class HyInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("Before: "  + method.getName());
            Object object = methodProxy.invokeSuper(o, objects);
            System.out.println("After: " + method.getName());
            return object;
        }


    }

    static Object getProxy () {
        Enhancer enhancer = new Enhancer();
        //继承被代理类
        enhancer.setSuperclass(Hello1.class);
        //设置回调
        enhancer.setCallback(new HyInterceptor());
        return enhancer.create();

    }




    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\Angular\\back-hy\\CGlibDebuggingClassWriter");

        Hello1 proxy = (Hello1)getProxy();
        proxy.sayHello1_1(7);

        System.out.println(proxy.getClass().getName());
        System.out.println(Hello1.class.getName());
    }

}
