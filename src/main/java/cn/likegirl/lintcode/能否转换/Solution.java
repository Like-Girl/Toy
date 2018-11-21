package cn.likegirl.lintcode.能否转换;


/**
 * 1540. 能否转换
 * 给两个字符串 S 和 T, 判断 S 能不能通过删除一些字母(包括0个)变成 T.
 * <p>
 * 样例
 * input:
 * S = "lintcode"
 * T = "lint"
 * output:
 * true
 */
public class Solution {
    /**
     * @param s: string S
     * @param t: string T
     * @return: whether S can convert to T
     */
    public static boolean canConvert(String s, String t) {
        // Write your code here
        if(s == null || t ==null){
            return  false;
        }
        int i = 0;
        int j = 0;
        for(;;){
            if(i >= s.length()){
                return  false;
            }
            char c = s.charAt(i);
            if(s.charAt(i)  == t.charAt(j)){
                if(j == t.length() -1){
                    return true;
                }
                i++;
                j++;
            }else{
                i++;
            }
        }
    }

    public static void main(String[] args) {
        String s = "lintcode";
        String t = "lint";
        System.out.println(canConvert(s, t));
    }
}