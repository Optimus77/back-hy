public class Son extends Foo{
    public Son() {
    }

    public void sonMethod () {}

    public void fooMethod () {
        System.out.println("son");
    }

    public void privateee2 () {

    }

    public void privateee () {

    }

    public static void main(String[] args) {

        Son s = new Son();
        s.privateee(1);
    }



}
