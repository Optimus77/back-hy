package DesignPattern.Singleton;

public class Hungry {

    //准备一个类属性，指向一个实例化对象。 因为是类属性，所以只有一个
    private static Hungry instance = new Hungry();

    //私有化构造方法使得该类无法在外部通过new 进行实例化
    private Hungry() {
    }

    //public static 方法，提供给调用者获取静态属性（容器）中存放的单例对象
    public static Hungry getInstance() {
        return instance;
    }

}
