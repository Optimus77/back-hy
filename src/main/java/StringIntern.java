public class StringIntern {

    String hh = "hh";
    int yy = 100;
    Foo fff ;

    public static void main(String[] args) {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);
        // 在jdk1.6中返回false，jdk1.7是false


        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        // 在jdk1.6中返回false，jdk1.7是true


        String s5= "a"+ "a";
        s5.intern();
        String s6= "aa";
        System.out.println(s5 == s6);


        String s7 = new String("h") + new String("h");
        String s9 = "hh";
        String s8= s7.intern();
//        String s9 = "hh";
        System.out.println(s7 == s8);
        System.out.println(s9 == s8);
        // 有String9的话，就是false。没有String9的话，就是true。


        // 3.intern方法 （1.7版本，返回常量池中该字符串的引用）
        //（1） 当常量池中不存在"abc"这个字符串的引用，将这个对象的引用加入常量池，返回这个对象的引用。
        //（2） 当常量池中存在"abc"这个字符串的引用，返回这个对象的引用；
        // jdk1.6跟jdk1.7以上的区别是当常量池中不存在这个字符串的时候，jdk1.6是直接复制对象到常量池，而jdk1.7以上是把对象的引用加入常量池。
        // https://blog.csdn.net/guoxiaolongonly/article/details/80425548
        // https://www.cnblogs.com/feizhai/p/10196955.html
        // https://www.cnblogs.com/lzxin/p/10389304.html
        // https://ask.csdn.net/questions/331568
    }
}
