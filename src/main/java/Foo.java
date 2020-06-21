public class Foo {

    public Foo (){
        System.out.println("Foo Constructor");
    }

    public void fooMethod () {
        System.out.println("foo");
    }

    public final void privateee (int i) {

    }

    public final void privateee (String s) {

    }

     static class Staticinner {
        static String hy;
        String hy2;
        static void hy3 () {}
        void hy4 () {}
        static {}
        class inner {}
    }

     class inner {
//        static String hy;
        String hy2;
//        static void hy3 () {}
        void hy4 () {}

    }



    public static void main(String[] args) {
        String hy = Foo.Staticinner.hy;
        String hy2 = new Foo.Staticinner().hy2;
        Staticinner.hy3();
        new Foo.Staticinner().hy4();

        String hy22 = new Foo().new inner().hy2;
        new Foo().new inner().hy4();

        System.out.println();
        System.out.println(System.identityHashCode(new Foo()));
        System.out.println(new Foo().hashCode());

        byte[] arr = new byte[2147483647];
}


}
