package DesignPattern.Singleton;

public class SyncLazy {
    private static SyncLazy instance;

    private SyncLazy() {
    }

    public static synchronized SyncLazy getInstance() {
        if (instance == null) {
            instance = new SyncLazy();
        }
        return instance;
    }
}
