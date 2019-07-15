package Algorithm.binarytree.traversal;

import java.util.LinkedList;
import java.util.List;

public class BinTreeTraverse {
    private static int[] dataArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9,10 }; //一个存放节点的值的数组容器
    private static List<Node> nodeList = new LinkedList<Node>(); //树的实现是LinkedList

    /*每一个Node由左孩子+右孩子+该节点的数据组成*/
    public  static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        /*构造节点时，只有数值，没有左右节点，左右节点是后来加的*/
        public Node (int data) {
            leftChild = null;
            rightChild = null;
            this.data = data ;
        }
    }

    public static void createBinTree (){
        //根据数组里的数值构造Node并放入nodeList中
        for (int arrayIndex = 0;arrayIndex<dataArray.length;arrayIndex++) {
            nodeList.add(new Node(dataArray[arrayIndex]));
        }
        /*
        * 当 dataArray（ 存放数值的数组）的长度为偶数时：1个根节点 + N对 左右兄弟 + 最后一个父节点只有左孩子；
        * 当 dataArray（ 存放数值的数组）的长度为奇数时：1个根节点 + N对 左右兄弟；
         *       父节点（包括根节点 ）个数：dataArray.length()/2；
         *       设nodeList的下标0号为根节点，最后一个 父节点的下标是dataArray.length()/2-1，最后一个 父节点要单独判断是否有右孩子；
         *       左孩子的下标 = 父节点 的下标*2+1；
         *       右孩子的下标 = 父节点 的下标*2+2；
        * */
        /*
         *   index = 0; 父节点0 = 根节点
         *   index = 1; 父节点0的左孩子  = 父节点1
         *   index = 2; 父节点0的右孩子
         *   index = 3; 父节点1的左孩子
         *   index = 4; 父节点1的右孩子
         * */

        /*                                1
        *                    2                            3
        *            4              5           6               7
        *      8       9     10
        * */

        /*先把 除去最后一个父节点的父节点分配上左孩子和右孩子*/
        for (int index=0;index < dataArray.length/2-1;index++) {
            nodeList.get(index).leftChild = nodeList.get(index*2+1);
            nodeList.get(index).rightChild = nodeList.get(index*2+2);
        }
        /*给最后一个父节点的父节点分配上左孩子*/
        nodeList.get(dataArray.length/2-1).leftChild = nodeList.get((dataArray.length/2-1)*2+1);
        /*如果节点数量为奇数，就再给最后一个父节点加一个右孩子*/
        if (dataArray.length %2 == 1) {
            nodeList.get(dataArray.length/2-1).rightChild = nodeList.get((dataArray.length/2-1)*2+1+1);
        }




    }

    public static void  beforeTraverse (Node node) {
        if (null==node) {return;}
        System.out.println(node.data);
        beforeTraverse(node.leftChild);
        beforeTraverse(node.rightChild);
    }

    public static void  middleTraverse (Node node) {
        if (null==node) {return;}
        middleTraverse(node.leftChild);
        System.out.println(node.data);
        middleTraverse(node.rightChild);
    }

    public static void  backTraverse (Node node) {
        if (null==node) {return;}
        backTraverse(node.leftChild);
        backTraverse(node.rightChild);
        System.out.println(node.data);
    }


    public static void main(String[] args) {
        createBinTree();
        System.out.println("前序遍历");
        beforeTraverse(nodeList.get(0));
        System.out.println("前序遍历");
        middleTraverse(nodeList.get(0));
        System.out.println("后序遍历");
        backTraverse(nodeList.get(0));

    }


}
