package cn.likegirl.lintcode.落单的数;

/**
 * 82. 落单的数
 * 中文English
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 * <p>
 * <p>
 * <p>
 * 样例
 * 给出 [1,2,2,1,3,4,3]，返回 4
 * <p>
 * 挑战
 * 一次遍历，常数级的额外空间复杂度
 */
public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public static int singleNumber(int[] A) {
        // write your code here
        int v = A[0];
        for (int i = 1; i < A.length; i++) {
            v ^= A[i];
        }
        return v;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 3, 4, 3};
        System.out.println(singleNumber(a));
    }
}