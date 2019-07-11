package DesignPattern.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncLazy {
    private static SyncLazy instance;
    static volatile boolean  flag = true;
    private SyncLazy() {
    }

    public static synchronized SyncLazy getInstance() {
        if (instance == null) {
            instance = new SyncLazy();
        }
        return instance;
    }



}
