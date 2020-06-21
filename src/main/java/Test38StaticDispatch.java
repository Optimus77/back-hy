public class Test38StaticDispatch {

    class Human {
        void say () {
            System.out.println("human");
        }
        void say2 (int i) {
            System.out.println("human2");
        }
    }

    class Man extends Human {
        void say () {
            System.out.println("man");
        }

    }

    class Woman extends Human {
        void say () {
            System.out.println("woman");
        }
    }

    private void sayHello (char... arg) {



    }

    private void sayHello () {



    }


    void test (){
        Human m = new Man();
        m.say2(1);

    }


    public static void main(String[] args) {

        Test38StaticDispatch t = new Test38StaticDispatch();
        t.test();


    }


}
