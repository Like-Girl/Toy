package cn.likegirl.lintcode.AB问题;

/**
 * 1. A + B 问题
 * 给出两个整数 aa 和 bb , 求他们的和。
 * <p>
 * 样例
 * 样例  1:
 * 输入:  a = 1, b = 2
 * 输出: 3
 * <p>
 * 样例解释:
 * 返回a+b的结果.
 * <p>
 * 样例 2:
 * 输入:  a = -1, b = 1
 * 输出: 0
 * <p>
 * 样例解释:
 * 返回a+b的结果.
 * <p>
 * 挑战
 * 显然你可以直接 return a + b，但是你是否可以挑战一下不这样做？（不使用++等算数运算符）
 * <p>
 * 说明
 * a和b都是 32位 整数么？
 * <p>
 * 是的
 * 我可以使用位运算符么？
 * <p>
 * 当然可以
 * 注意事项
 * 你不需要从输入流读入数据，只需要根据aplusb的两个参数a和b，计算他们的和并返回就行。
 */
public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public static int aplusb(int a, int b) {
        // write your code here
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(aplusb(3, 2));
    }
}