package Thread;

import lombok.Synchronized;

public class Synchronize {

    String name = "hy";

    public synchronized void A(){}

    public synchronized void B(){}

    public void C(){
        synchronized (this) {}
        synchronized (name) {}
        synchronized (new MyThread()) {}
        synchronized (Synchronize.class) {}

    }

}
