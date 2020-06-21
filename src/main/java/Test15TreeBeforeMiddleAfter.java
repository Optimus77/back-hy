//        1
//   2          3
//4     5     6     7
//     8       9

public class Test15TreeBeforeMiddleAfter {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    static {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n5.left = n8;

        n6.right = n9;

        // 1 2 4 5 8 3 6 9 7
        before(n1);

        // 4 2 8 5 1 6 9 3 7
        middle(n1);

        // 4 8 5 2 9 6 7 3 1
        after(n1);
    }


    static void before (Node n){
        if (n!=null) {
            System.out.println(n.value);
            before(n.left);
            before(n.right);
        }
    }

    static void middle (Node n){
        if (n!=null) {
            middle(n.left);
            System.out.println(n.value);
            middle(n.right);
        }
    }

    static void after (Node n){
        if (n!=null) {
            after(n.left);
            after(n.right);
            System.out.println(n.value);
        }
    }

    public static void main(String[] args) {



    }



}
