/*
* VM Args: -Xss2m
* */

public class Test31NativeStackOutOfMemory {

    private void dontStop () {
        while(true){}

    }

    private void leak (){
        while (true) {
            new Thread(()->dontStop()).start();
        }
    }


    public static void main(String[] args) {
        Test31NativeStackOutOfMemory t = new Test31NativeStackOutOfMemory();
        t.leak();
    }


}
