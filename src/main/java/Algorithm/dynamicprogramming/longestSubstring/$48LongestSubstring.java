package Algorithm.dynamicprogramming.longestSubstring;

import java.util.Arrays;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含'a'~'z'之间的字符，例如在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr"，长度为4
 */
public class $48LongestSubstring {

    /**
     * n是下标，f（n）返回值是字符串。
     * f（0）= arr【0】；
     * f（n）= f（n-1）+ arr【n】，当! f（n-1）.contains( arr【n】)
     *        	     arr【n】                  ,  当  f（n-1）.contains( arr【n】)
     *
     * */
    void findSubString(String s) {
        String [] memo =new String[s.length()];
        char [] sCharArray = s.toCharArray();
        memo[0] = String.valueOf(sCharArray[0]);
        int max  = 1;
        for (int i = 1 ;i<s.length();i++) {
           String newchar =  String.valueOf(sCharArray[i]);
           boolean flag = memo[i-1].contains(newchar);
           if (flag) {
               memo[i] = newchar;
           } else {
               memo[i] = memo[i-1] +newchar;
               max = memo[i].length() > max ? memo[i].length() : max;
           }
        }
        System.out.println(Arrays.toString(memo));
        System.out.println(max);
    }


    public static void main(String[] args) {
        $48LongestSubstring l = new $48LongestSubstring();
        l.findSubString("arabcacfr");
    }
}
