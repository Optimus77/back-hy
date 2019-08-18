package Algorithm.dynamicprogramming.cutrope;

import java.util.Arrays;

/**
 * 给你一根长度为n的绳子，把绳子剪成m段（m、n都是整数且m > 1, n > 1）,m段绳子的长度依然是整数，求m段绳子的长度乘积最大为多少？
 * 比如绳子长度为8，我们可以分成2段、3段、4段...8段，只有分成3段且长度分别是2、3、3时能得到最大乘积18
 */

public class CutRope {

    /**
     * f(2) = 2;
     * f(3) = 3;
     * f(n) = Max[f(i) * f(n-i)]; n>4,i>1
     *
     * */

    /**
     * 方案3 ：循环+memo
     * */

    void cut (int n) {
        int[] memo =new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 3;

        for (int i = 4 ; i<=n; i++) {
            int max = 0;
            for (int j=i-1;j>1;j--) {
                max = memo[j]*memo[i-j] > max ? memo[j]*memo[i-j] :max;
            }
            memo[i] = max;
        }
        System.out.println(Arrays.toString(memo));
    }



    public static void main(String[] args) {
        CutRope c= new CutRope();
        c.cut(8);
    }

}
