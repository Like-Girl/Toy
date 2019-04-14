package cn.likegirl.lintcode.双胞胎字符串;

import java.util.Arrays;

/**
 * 1472. 双胞胎字符串
 * 给定两个字符串 s和t，每次可以任意交换s的奇数位或偶数位上的字符，即奇数位上的字符能与其他奇数位的字符互换，而偶数位上的字符能与其他偶数位的字符互换，问能否经过若干次交换，使s变成t。
 * <p>
 * 样例
 * 给出 s="abcd"，t="cdab"，返回"Yes"。
 * <p>
 * 解释：
 * 第一次a与c交换，第二次b与d交换。
 * 给出 s="abcd"，t="bcda"，返回"No"。
 * <p>
 * 解释：
 * 无论如何交换，都无法得到bcda。
 * 注意事项
 * 字符串长度均不超过100000100000
 * 字符串可由大写字母、小写字母及数字组成
 *
 * @author LikeGirl
 * @version v1.0
 * @title: Solution
 * @description: TODO
 * @date 2018/11/13 12:36
 */
public class Solution {


    /**
     * @param s: the first string
     * @param t: the second string
     * @return: If they are twin strings
     */
    public static String isTwin(String s, String t) {
        // Write your code here
        if (s.length() != t.length()) {
            return "no";
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        sort(sChars, 0, sChars.length - 1);
        sort(sChars, 1, sChars.length - 1);
        sort(tChars, 0, tChars.length - 1);
        sort(tChars, 1, tChars.length - 1);
        if (Arrays.toString(sChars).equals(Arrays.toString(tChars))) {
            return "yes";
        }
        return "no";
    }

    public static void sort(char[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        sort(array, left, p - 2);
        sort(array, p + 2, right);
    }


    public static int partition(char[] array, int left, int right) {
        int r = random(left, right);
        swap(array, left, r);
        char base = array[left];
        int j = left;
        for (int i = left + 2; i <= right; i += 2) {
            if (base > array[i]) {
                j += 2;
                swap(array, j, i);
            }
        }

        swap(array, left, j);
        return j;
    }

    public static int random(int left, int right) {
        int temp, length = (right - left) / 2 + 1;
        temp = (int) (Math.random() * length);
        return 2 * temp + left;
    }

    public static void swap(char[] array, int i, int j) {
        if (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcda";
        System.out.println(isTwin(s, t));
    }
}
