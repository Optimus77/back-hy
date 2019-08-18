package Algorithm.dynamicprogramming.FindGreatestSumOfSubArray;

/**
 *  输入一个整型数组，数组里正负数都可能有，数组中的一个或者连续的多个整数组成一个子数组。
 *  求所有子数组的和的最大值，要求时间复杂度为O(n)
 *
 * */


public class FindGreatestSumOfSubArray {

    /**
     * f(i)是截止到第i个数字时的最大和。
     * f(i) = max(f(i-1)+arr[i] , arr[i])   , i>0
     * f(0) = arr[0]
     * */


}
