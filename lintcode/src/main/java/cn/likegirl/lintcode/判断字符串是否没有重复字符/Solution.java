package cn.likegirl.lintcode.判断字符串是否没有重复字符;

/**
 * 157. 判断字符串是否没有重复字符
 * 中文English
 * 实现一个算法确定字符串中的字符是否均唯一出现
 * <p>
 * 样例
 * Example 1:
 * Input: "abc_____"
 * Output: false
 * <p>
 * <p>
 * Example 2:
 * Input:  "abc"
 * Output: true
 * <p>
 * 挑战
 * 如果不使用额外的存储空间，你的算法该如何改变？
 */
public class Solution {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public static boolean isUnique(String str) {
        // write your code here
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(chars[i] == chars[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abc___"));
    }
}