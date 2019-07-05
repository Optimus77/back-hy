package Algorithm.dynamicprogramming.coinchange;

/*
题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，再给一个总金额 n，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，则回答 -1 。
比如说，k = 3，面值分别为 1，2，5，总金额 n = 11，那么最少需要 3 枚硬币，即 11 = 5 + 5 + 1 。
*
 */

/*
        F(n) =    0                                                ,  当  n=0 时
        F(n) =    1  +   【 F ( n-Ci )  的min 】  , 当  n>0 时
 */

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    static int[] c ={1,2,5};
    static Map<Integer,Integer> memo2 = new HashMap<>();
    static Map<Integer,Integer> memo3 = new HashMap<>();

    public static  int  Solution1_Force (int n) {
        if (n==0) return 0;
        int min =-2;
        for (int i=0;i<c.length;i++) {
            if (c[i]>n) {
                continue;
            } else if (c[i]==n) {
                return 1;
            } else {
                int temp = Solution1_Force  (n-c[i] );
                if (temp ==-1) continue;
                min = min ==-2 ? temp+1 :Math.min(temp+1,min);
            }
        }
        return min==-2 ? -1 : min ;
    }

    public static  int  Solution2_Force (int n) {
        if ( memo2.containsKey(n) ) return memo2.get(n);
        if (n==0) return 0;
        int min =-2;
        for (int i=0;i<c.length;i++) {
            memo2.put(c[i],1);
            if (c[i]>n) continue;
            int  temp = memo2.containsKey(n) ? memo2.get(n) : Solution2_Force  (n-c[i] );
            if (temp ==-1) continue;
            min = min ==-2 ? temp+1 :Math.min(temp+1,min);
        }
        memo2.put(n,min==-2 ? -1 : min);
        return min==-2 ? -1 : min ;
    }

//    public static  int  Solution3_Force (int n) {
//    }

    public  static void main (String[] args) {
        System.out.println( Solution1_Force (11));
        System.out.println( Solution2_Force (11));
        System.out.println(memo2);

    }
}
