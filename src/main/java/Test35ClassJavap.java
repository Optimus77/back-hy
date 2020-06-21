public class Test35ClassJavap extends Son{

    private int a;
    private static int b=2;

    public void setA() {

//        this.a = a;
    }

    public static void setB() {
//        b = b;
    }

    private void setC () {}

    private static void setD () {}



    public static void main(String[] args) {
        Test35ClassJavap t= new Test35ClassJavap();
        t.setA ();
        t.setB ();
        t.setC ();
        t.setD ();
        t.fooMethod();
    }


}
