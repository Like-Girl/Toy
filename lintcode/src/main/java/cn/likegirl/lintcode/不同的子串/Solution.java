package cn.likegirl.lintcode.不同的子串;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1481. 不同的子串
 * 给出一个字符串 s，找出所有的不同的长度为 k 的它的子串，并将结果按照字典序排序
 * <p>
 * 样例
 * Input: s = "caaab"
 * k = 2
 * Output:["aa","ab","ca"]
 */
public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: all unique substring
     */
    public static List<String> uniqueSubstring(String s, int k) {
        // Write your code here
        Set<String> list = new TreeSet<String>();
        for (int i = 0; i <= s.length() - k; i++) {
            list.add(s.substring(i, i + k));
        }
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        List<String> list = uniqueSubstring("caaab", 2);
        System.out.println(list.size());
        System.out.println("Output:" + Arrays.toString(list.toArray()));
    }
}