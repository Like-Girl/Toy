package cn.likegirl.lintcode.翻转字符串中的单词;

/**
 * 53. 翻转字符串中的单词
 * 中文English
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 样例
 * 给出s = "the sky is blue"，返回"blue is sky the"
 * <p>
 * 说明
 * 单词的构成：无空格字母构成一个单词
 * 输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
 * 如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 */
public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public static String reverseWords(String s) {
        // write your code here
        if(s.length() <= 0){
            return s;
        }
        s = s.replaceAll("\\s+", " ");
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(strings[strings.length - i - 1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "the sky is    blue";
        System.out.println(reverseWords(str));
    }
}