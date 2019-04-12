package cn.likegirl.lintcode.最大的交换;

/**
 * 1095. 最大的交换
 * 中文English
 * 给定一个非负整数, 你可以选择交换它的两个数位. 返回你能获得的最大的合法的数.
 * <p>
 * 样例
 * 样例1:
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7.
 * 样例2:
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不用交换.
 * 注意事项
 * 给定的数字在 [0, 10^8] 范围内
 */
public class Solution {
    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public static int maximumSwap(int num) {
        // Write your code here
        char[] array = String.valueOf(num).toCharArray();
        int offset = -1;
        int swapset = -1;
        for (int i = 0; i < array.length; i++) {
            if(i + 2 < array.length && array[i] < array[i + 1] && offset < 0){
                offset = i;
                swapset= i;
            }else if(offset > -1){
                if(array[swapset] <= array[i]){
                    swapset = i;
                }
            }
        }
        if(offset > -1){
            for(int i =0; i <= offset;i++){
                if(array[i] < array[swapset]){
                    char temp = array[i];
                    array[i] = array[swapset];
                    array[swapset] = temp;
                    break;
                }
            }
        }
        return Integer.valueOf(String.valueOf(array));
    }

    public static int maximumSwap1(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap1(4422266));
    }
}