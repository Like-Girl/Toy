package cn.likegirl.lintcode.旋转字符串;

import java.util.Arrays;

/**
 * 8. 旋转字符串
 * <p>
 * 给定一个字符串（以字符数组的形式给出）和一个偏移量，根据偏移量原地旋转字符串(从左向右旋转)
 * <p>
 * 样例
 * 样例  1:
 * 输入:  str="abcdefg", offset = 3
 * 输出: "efgabcd"
 * <p>
 * 样例解释:
 * 返回旋转后的字符串。
 * <p>
 * 样例 2:
 * 输入: str="abcdefg", offset = 0
 * 输出: "abcdefg"
 * <p>
 * 样例解释:
 * 返回旋转后的字符串
 * <p>
 * 样例 3:
 * 输入: str="abcdefg", offset = 1
 * 输出: "gabcdef"
 * <p>
 * 样例解释:
 * 返回旋转后的字符串
 * <p>
 * 样例 4:
 * 输入: str="abcdefg", offset =2
 * 输出:"fgabcde"
 * <p>
 * 样例解释:
 * 返回旋转后的字符串
 * 挑战
 * 在数组上原地旋转，使用O(1)的额外空间
 */
public class Solution {
    /**
     * @param str:    An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        // write your code here
        int len = str.length;
        if (offset == 0 || len == 0) {
            return;
        }
        int off = offset % len;
        String s = new String(str);
        s = s.substring(len - off) + s.substring(0, len - off);
        System.arraycopy(s.toCharArray(), 0, str, 0, len);
        System.out.println(Arrays.toString(str));
    }

    public static void main(String[] args) {
        rotateString("".toCharArray(), 25);
    }
}