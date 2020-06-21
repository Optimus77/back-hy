
/*
* VM Args: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
*
* */


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test33MethodAreaOOM {

    static class OMMObject {}


    public static void main(String[] args) {

        while(true) {

            Enhancer en = new Enhancer();
            en.setSuperclass(OMMObject.class);
            en.setUseCache(false);
            en.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            en.create();
        }

    }



}
