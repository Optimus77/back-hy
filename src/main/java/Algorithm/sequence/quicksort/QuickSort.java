package Algorithm.sequence.quicksort;

import java.util.Arrays;

public class QuickSort {

    void recursion (int [] arr,int start,int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(arr, start, end);
        recursion(arr, start, mid - 1);
        recursion(arr, mid + 1, end);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        if (startIndex ==endIndex ) {
            return endIndex;
        }

        int pivot = arr[startIndex];
        int p1 = startIndex;
        int p2 = endIndex;

        while ( p1 < p2) {
            while (arr[p2] > pivot && p1 < p2){
                p2--;
            }
            while (arr[p1] <= pivot && p1 < p2) {
                p1++;
            }
            arr[p1] = arr[p1] ^ arr[p2] ^ (arr[p2]=arr[p1]);
        }

        arr[startIndex] = arr[startIndex] ^ arr[p1] ^ (arr[p1] = arr[startIndex]);
        return p1;
    }

    int change (int [] arr ,int p1,int p2) {
        int pivot = arr[p1];
        if (p1==p2) {
            arr[p1] =pivot;
            return p1;
        } else if (arr[p2]> pivot ) {
            change(arr,p1,p2-1);
        } else if (arr[p2]<= pivot && arr[p1]<=pivot){
            change(arr,p1+1,p2);
        } else {
            arr[p2] = arr[p2] ^ arr[p1] ^ (arr[p2]=arr[p1]);
            change(arr,p1+1,p2-1);
        }
        return 0;
    }


    public static void main(String[] args) {
        QuickSort q =new QuickSort();
        int [] arr ={5,3,7,6,4,1,0,2,9,10,8};
        q.recursion(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


}
