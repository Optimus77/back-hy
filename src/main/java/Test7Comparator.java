
import java.util.ArrayList;
import java.util.Comparator;

public class Test7Comparator implements Comparator<Hy> {


    @Override
    public int compare(Hy o1,Hy o2) {
        o1.hy.equals(o2.hy);
        return 0;
    }

    public static void main(String[] args) {
        Hy h1 = new Hy();
        Hy h2 = new Hy();
        Test7Comparator c = new Test7Comparator();
        System.out.println();
        c.compare(h1, h2);
    }




}
