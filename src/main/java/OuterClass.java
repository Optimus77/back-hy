public class OuterClass
{

    static{
        System.out.println("外部类静态块");
    }

    static void hy () {
        System.out.println("外部类静态方法");
    }

    public OuterClass()
    {
        System.out.println("外部类无参构造方法");
    }

    public OuterClass(String flag)
    {
        System.out.println("外部类有参构造方法"+flag);
    }

    class InnerClass
    {
        // 非静态内部类不能拥有：静态变量、静态语句、静态方法
//        private OuterClass out = new OuterClass("普通内部类属性");
    }

    static class InnerStaticClass
    {
        static long hy = System.currentTimeMillis();

        static{
            System.out.println("静态内部类静态块");
            System.out.println(" "+hy);
        }
        public static void load()
        {
            System.out.println(System.currentTimeMillis());
            System.out.println("静态内部类静态方法");
        }

        public static void load2()
        {
            System.out.println(System.currentTimeMillis());
            System.out.println("静态内部类静态方法2");
        }
    }




}
