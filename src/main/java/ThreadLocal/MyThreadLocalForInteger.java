package ThreadLocal;

public class MyThreadLocalForInteger extends ThreadLocal<Integer>{
    @Override
    protected Integer initialValue() {
        return 0;
    }
}
