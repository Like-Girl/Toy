package cn.likegirl.lintcode.最长AB子串;


import java.util.*;

/**
 * 1443. 最长AB子串
 * 中文English
 * 给你一个只由字母'A'和'B'组成的字符串s，找一个最长的子串，要求这个子串里面'A'和'B'的数目相等，输出该子串的长度。
 * <p>
 * 样例
 * 样例1
 * <p>
 * 输入: s = "ABAAABBBA"
 * 输出: 8
 * 解释:
 * 子串 s[0,7] 和子串 s[1,8] 满足条件，长度为 8。
 * 样例2
 * <p>
 * 输入: s = "AAAAAA"
 * 输出: 0
 * 解释:
 * s 中除了空字串，不存在 'A' 和 'B' 数目相等的子串。
 * 注意事项
 * 这个子串可以为空。
 * s的长度n满足 2<=n<=1000000。
 */
public class Solution {
    /**
     * @param S: a String consists of a and b
     * @return: the longest of the longest string that meets the condition
     */
    public static int getAns(String S) {
        // Write your code here
        int count = 0, ans = 0;
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ans = i + 1;
            }
            if (d.containsKey(count)) {
                ans = Math.max(ans, i - d.get(count));
            } else {
                d.put(count, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getAns("ABAAABBBA"));
    }
}