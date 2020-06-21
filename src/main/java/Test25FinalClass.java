public final class Test25FinalClass {

    String hy ;

    public Test25FinalClass() {
        this.hy = "1";
    }

    public Test25FinalClass(String hy) {
        this.hy = hy;
    }


    public static void main(String[] args) {
        Test25FinalClass t = new Test25FinalClass();
        System.out.println(t.hashCode());
        int i = 1111;
        i = t.hashCode();
        System.out.println(t.hashCode());
        t = new Test25FinalClass("2");
        System.out.println(t.hashCode());

        String s = new String("1");
        System.out.println(s.hashCode());
        s = new String ("2");
        System.out.println(s.hashCode());
    }



}
