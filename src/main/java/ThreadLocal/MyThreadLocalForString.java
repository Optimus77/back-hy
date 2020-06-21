package ThreadLocal;

public class MyThreadLocalForString extends ThreadLocal<String>{

    @Override
    protected String initialValue() {
        return "";
    }

}
