import java.util.concurrent.atomic.AtomicInteger;

public class Test5GetAndIncrement {
    private final AtomicInteger count = new AtomicInteger();

    private void test () {
        final AtomicInteger count = this.count;
        this.count.getAndIncrement();
        System.out.println(this.count);
        this.count.getAndIncrement();
        System.out.println(count);
    }

    public static void main(String[] args) {
        Test5GetAndIncrement t = new Test5GetAndIncrement();
        t.test();

    }
}
