package cn.likegirl.lintcode.水仙花数;


import java.util.ArrayList;
import java.util.List;

/**
 * 147. 水仙花数
 * 中文English
 * 水仙花数的定义是，这个数等于他每一位上数的幂次之和 见维基百科的定义
 * <p>
 * 比如一个3位的十进制整数153就是一个水仙花数。因为 153 = 13 + 53 + 33。
 * <p>
 * 而一个4位的十进制数1634也是一个水仙花数，因为 1634 = 14 + 64 + 34 + 44。
 * <p>
 * 给出n，找到所有的n位十进制水仙花数。
 * <p>
 * 样例
 * Example 1:
 * Input: 1
 * Output: [0,1,2,3,4,5,6,7,8,9]
 * <p>
 * <p>
 * Example 2:
 * Input:  2
 * Output: []
 * <p>
 * Explanation:
 * There is no Narcissistic Number with 2 digits.
 * <p>
 * 注意事项
 * 你可以认为n小于8。
 */
public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public static List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        int start = n - 1 == 0 ? 0 : (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n);
        for (int i = start; i < end; i++) {
            String s = String.valueOf(i);
            int temp = 0;
            for (char c : s.toCharArray()) {
                int v = Integer.valueOf(String.valueOf(c));
                temp += (int) Math.pow(v, n);
            }
            if (i == temp) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getNarcissisticNumbers(4));
    }
}