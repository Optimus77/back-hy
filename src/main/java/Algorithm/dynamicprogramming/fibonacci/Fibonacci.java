package Algorithm.dynamicprogramming.fibonacci;

import java.util.HashMap;
import java.util.Map;


/*
        F(n) =   {  1                          , 当  n<3 时
                     {  F(n-1)+F(n-2)   ,  当 n>=3 时
 */
public class Fibonacci {

    public static  int  Solution1_Force (int n) {
        if (n==1 || n==2) {
            return 1;
        }
        return Solution1_Force(n-1)+Solution1_Force(n-2);
    }

    public static  int Solution2_Memo_dp(int n) {
        Map<Integer,Integer > memo =new HashMap<>();
        memo.put(1,1);
        memo.put(2,1);
        for (int i =3; i<=n; i++) {
            memo.put(i,(memo.get(i-1)+memo.get(i-2)));
        }
        return memo.get(n);
    }

    public static void  main (String[] args){
        System.out.println(Solution1_Force(11));
        System.out.println(Solution2_Memo_dp(11));
    }

}
