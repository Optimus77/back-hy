
/*
* VM Args: -Xss128k
* */


public class Test30StackOverFlow {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        Test30StackOverFlow t =new Test30StackOverFlow();

        try {
            t.stackLeak();
        } catch (Throwable e ){
            System.out.println("Stack Length is "+t.stackLength);
            throw e;
        }





    }


}
