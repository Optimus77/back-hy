public class Test17Static {

    public static int hy;


    public static void main(String[] args) {

        Test17Static t1 = new Test17Static();
        t1.hy = 1;
        System.out.println(t1.hy);
        System.out.println(hy);
        hy = 2;
        System.out.println(t1.hy);
        System.out.println(hy);
        Test17Static t2 = new Test17Static();
        System.out.println(t2.hy);
        System.out.println(hy);
        t1.hy = 3;
        System.out.println(hy);
        System.out.println(t2.hy);
    }


}
