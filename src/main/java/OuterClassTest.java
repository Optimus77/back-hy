public class OuterClassTest {
    public static void main(String[] args)
    {
        OuterClass o = new OuterClass();
        System.out.println(System.currentTimeMillis());
//        long hy = OuterClass.InnerStaticClass.hy;
        OuterClass.InnerStaticClass.load2();

        //        OuterClass.InnerStaticClass.load();
//        // 静态内部类无需外部类实例即可调用
//        OuterClass out = OuterClass.InnerStaticClass.out;
//        OuterClass.InnerClass innerClass = out.new InnerClass();
//        // 非静态内部类需要外部类实例调用
    }

}
