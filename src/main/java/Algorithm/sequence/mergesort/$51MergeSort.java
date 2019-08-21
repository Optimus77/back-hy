package Algorithm.sequence.mergesort;

import java.util.Arrays;

public class $51MergeSort {

    void mergeSort(int[] array) {
        split(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    void split (int[] array,int begin ,int end) {
        // 如果切到最后时，子数组只有一个元素，return即可。
        if (end-begin <=0) {
            return;
        }
        int mid = (end+begin) /2;
         // 继续切子数组1
        split(array,begin,mid);
        // 继续切子数组2
        split(array,mid+1,end);
        // 子数组1的子数组和子数组2的子数组都切完并且merge排序完，来merge子数组1和子数组2
        merge(array,begin,mid,end);
    }

    void merge (int[] array ,int begin,int mid,int end) {
        // 一定要在这里复制array，在aux上比较，通过比较之后的优胜者（较小值）赋值给array 的顺序位置
        int[] aux =array.clone();

        // 用来在aux内部作比较用的两个指针，p1ForAux的范围是[begin,mid]，p2ForAux的范围是[mid+1,end]，每次向前移动一格
        int p1ForAux = begin;
        int p2ForAux = mid+1;

        //
        for (int whereToBeAssginToArray =begin; whereToBeAssginToArray<=end ;whereToBeAssginToArray++) {
            // 如果p1ForAux已经递增出界，说明p1ForAux范围内的数字都已经胜出，现在的事情是把p2ForAux按序排列即可。然后p2ForAux向前一格
            if (p1ForAux > mid  ) {
                array[whereToBeAssginToArray] = aux[p2ForAux];
                p2ForAux++;
            // 如果p2ForAux已经递增出界，说明p2ForAux范围内的数字都已经胜出，现在的事情是把p1ForAux按序排列即可。然后p1ForAux向前一格
            } else if (p2ForAux>end) {
                array[whereToBeAssginToArray] = aux[p1ForAux];
                p1ForAux++;
             // 如果p1ForAux胜出，把p1ForAux赋值给array的whereToBeAssginToArray位置。然后p1ForAux向前一格
            } else if (aux[p1ForAux] < aux[p2ForAux]) {
                array[whereToBeAssginToArray] = aux[p1ForAux];
                p1ForAux++;
            // 如果p2ForAux胜出或平手，把p2ForAux赋值给array的whereToBeAssginToArray位置。然后p2ForAux向前一格
            } else {
                array[whereToBeAssginToArray] = aux[p2ForAux];
                p2ForAux++;
            }
        }
    }


    public static void main(String[] args) {
        int [] array ={9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        $51MergeSort m =new $51MergeSort();
        m.mergeSort(array);
    }



}
