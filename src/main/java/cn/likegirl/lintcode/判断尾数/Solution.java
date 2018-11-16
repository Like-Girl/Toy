package cn.likegirl.lintcode.判断尾数;


/**
 * 1459. 判断尾数
 * 有一个01字符串str。其中只可能会出现三个单词，两个字节的单词10或者11，一个字节的单词0。判断字符串中最后一个单词的字节数。
 * <p>
 * 样例
 * Give str="100". Return 1.
 * <p>
 * Explanation:
 * <p>
 * Str consists of two words, 10 and 0.
 * Give str="1110". Return 2.
 * <p>
 * Explanation:
 * Str consists of two words, 11 and 10.
 * 注意事项
 * 字符串长度不超过100000。
 */
public class Solution {
    /**
     * @param str: the str
     * @return: the sum of bytes in the last word
     */
    public static int judgeTheLastNumber(String str) {
        // Write your code here
        if (str.length() == 1) {
            return 1;
        }
        int i = 0;
        for (; ; ) {
            String cur = str.substring(i, i + 1);
            if("1".equals(cur)){
                i += 2;
                if(i >= str.length()){
                    return 2;
                }
            }else{
                i += 1;
                if(i >= str.length()){
                    return 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(judgeTheLastNumber("1110"));
    }
}