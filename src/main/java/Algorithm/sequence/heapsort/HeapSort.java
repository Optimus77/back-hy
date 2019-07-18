package Algorithm.sequence.heapsort;

import java.util.Arrays;

/*
*   最小堆举例
*   排序后是降序
* */
public class HeapSort {
    static int [] arr ={1, 3, 2, 6, 5, 7, 8, 9, 10, 0};

    // i = 要调整的节点
    // j =  要调整的数组的范围的末下标
    static void  downAdjust (int i,int j)  {
        int child1 = 2*i+1;
        int child2 = 2*i+2;

        if (child2 < j) {
            if (arr [child1] < arr[child2]) {
                if (arr[i] < arr [child1]) return;
                arr[i] = arr[i] ^ arr [child1] ^(arr [child1] =arr[i]);
                downAdjust(child1,j);
            } else {
                if (arr[i] < arr [child2]) return;
                arr[i] = arr[i] ^ arr [child2] ^(arr [child2] =arr[i]);
                downAdjust(child2,j);
            }
        } else if (child1 < j) {
            if (arr[i] < arr [child1]) return;
            arr[i] = arr[i] ^ arr [child1] ^(arr [child1] =arr[i]);
            downAdjust(child1,j);
        }
        return;
    }

    static void becomeHeap () {
        for (int i=arr.length/2-1;i>=0;i--) {
            downAdjust(i,arr.length);
        }
        System.out.println("becomeHeap: "+Arrays.toString(arr));
    }

    static void sort () {
        for (int count=1;count<=arr.length;count++) {
            changeData(0,arr.length-count);
            System.out.println("changeData: "+Arrays.toString(arr));
            downAdjust(0,arr.length-count-1);
        }
    }

    static void changeData (int i,int j) {
        arr[i] = arr[i]^  arr[j] ^ ( arr[j] = arr[i]);
    }

    public static void main(String[] args) {
        becomeHeap();
        sort();
        System.out.println(Arrays.toString(arr));
    }
}
