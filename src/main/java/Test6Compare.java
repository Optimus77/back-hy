public class Test6Compare implements Comparable<Test6Compare>{

    String name;

    public static void main(String[] args) {
        Test6Compare t1 = new Test6Compare();
        Test6Compare t2 = new Test6Compare();
        t1.compareTo(t2);
    }

    @Override
    public int compareTo(Test6Compare o) {
        return 0;
    }
}
