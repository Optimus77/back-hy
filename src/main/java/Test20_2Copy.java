import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test20_2Copy {

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(3434,"chenjiazhan",835745);
        students[1] = new Student(8347543,"guerge",5435);
        students[2] = new Student(4835,"urgirt",34543);
        Student[] copy = Arrays.copyOf(students,students.length);
        System.out.println("拷贝的数组：");
        for(Student s : copy){
            System.out.println(s.toString());
        }
//        students[1].setId(5832573);
        Student[] students2 = students;
        students2[1].setId(5832573);
        students = null;
        System.gc();
        System.out.println("改变后的数组");
        for(Student s : copy){
            System.out.println(s.toString());
        }
        System.out.println("复制后的数组改变后是否是会影响到原来的数组，也就是这两个数组里面所存储的内容指针是不是指向同一个地方");
        for(Student s : students2){
            System.out.println(s.toString());
        }
//        System.out.println("很遗憾，确实是这样的");


        int[] arr = {1,2,3};
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(arr2));
        arr[0]--;
        System.out.println(Arrays.toString(arr2));


        String[] s = {"1","2","3"};
        String[] s2 = Arrays.copyOf(s,s.length);
        System.out.println(Arrays.toString(s2));
        s[0].replace('1','a');
        System.out.println(Arrays.toString(s2));

        Integer[] i = {1,2,3};
        Integer[] i2 = Arrays.copyOf(i,i.length);
        System.out.println(Arrays.toString(i2));
        i[0]++;
        System.out.println(Arrays.toString(i2));


    }

}

class Student {
    private int id;
    private String name;
    private int Salary;

    public Student(int id,String name,int salary){
        this.id = id;
        this.name = name;
        this.Salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return "[name:"+name+"][id:"+id+"][salary:"+Salary+"]";
    }

}
