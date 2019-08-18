package Algorithm.dynamicprogramming.maxGiftValue;

import java.util.Arrays;

/**
 * 在一个mxn的棋盘的每一格斗放油一个礼物，每个礼物都有一定的价值（大于0）
 * 从棋盘的左上角开始，每次可以往右边或者下边移动一格，知道到达棋盘的右下角。
 * 给定一个棋盘和上面的礼物，计算我们最多可以拿到多少价值的礼物
 */

public class MaxGiftValue {

    /**
     * 已知gift [i][j]，
     * 0 < i < gift.length ，
     * 0 < j < gift[0].length ，
     * f （0，0）= gift（0，0）；
     * f （i，j）=Max 【f（i-1，j）， f（i，j-1）】 + gift（i，j）；
     * */

    static int[][] gift = {
            {1,10,3,8},
            {12,2,9,6},
            {5,7,4,11},
            {3,7,16,5}
    } ;
    static int[][] memo =new int[4][4];
    static int[][] memo3 =new int[4][4];

    /**
     * 方案2：递归+memo
     * */
    public int getMaxFuction2(int i, int j) {
        if(memo[i][j]!=0){
            return memo[i][j];
        }

        if (i==0 && j==0) {
            return memo[i][j] = gift[0][0];
        }
        if (i==0 && j!=0) {
            return memo[i][j] = getMaxFuction2(i,j-1)+gift[i][j];
        }
        if (i!=0 && j==0) {
            return memo[i][j] = getMaxFuction2(i-1,j)+gift[i][j];
        }
        return memo[i][j] = Math.max(getMaxFuction2(i-1,j), getMaxFuction2(i,j-1))+gift[i][j];

    }

    /**
     * 方案3：循环+memo
     * */
    public void getMaxFuction3() {
        for (int m =0 ;m<gift.length;m++) {
            for (int n =0 ;n<gift[0].length;n++) {
                if (m==0 && n==0) {
                    memo3[m][n] = gift[0][0];
                }
                if (m==0 && n!=0) {
                    memo3[m][n] = memo3[m][n-1]+gift[m][n];
                }
                if (m!=0 && n==0) {
                    memo3[m][n] = memo3[m-1][n]+gift[m][n];
                }
                if (m!=0 && n!=0) {
                    memo3[m][n] = Math.max(memo3[m-1][n],memo3[m][n-1])+gift[m][n];
                }
            }
        }

    }

    public static void main(String[] args) {
        MaxGiftValue m =new MaxGiftValue();
        m.getMaxFuction2(3,3);
        System.out.println(Arrays.toString(memo[0]));
        System.out.println(Arrays.toString(memo[1]));
        System.out.println(Arrays.toString(memo[2]));
        System.out.println(Arrays.toString(memo[3]));

        m.getMaxFuction3();
        System.out.println(Arrays.toString(memo3[0]));
        System.out.println(Arrays.toString(memo3[1]));
        System.out.println(Arrays.toString(memo3[2]));
        System.out.println(Arrays.toString(memo3[3]));
    }


}

