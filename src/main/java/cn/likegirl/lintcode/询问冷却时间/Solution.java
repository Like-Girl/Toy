package cn.likegirl.lintcode.询问冷却时间;

/**
 * 1467. 询问冷却时间
 * 你有一串的技能需要释放，释放顺序为arr。必须按照顺序释放。每个技能都有长度为n的冷却时间。也就是说，两个同类技能之间至少要间隔n秒。释放每个技能需要1秒,返回放完所有技能所需要的时间。
 *
 * 样例
 * Given arr=[1,1,2,2],n=2.Return 8.
 *
 * The order is [1, _, _, 1, 2, _, _, 2].So return 8.
 * Skill 1 is released in the 1st second, in the 2nd second and the 3rd second enters the cooling time, and the 4th second releases the second time.
 * Skill 2 is released in the 5th second, in the 6th second and the 7th second enters the cooling time, and the 8th second releases the second time.
 *
 * Given arr=[1,2,1,2], n=2. Return 5.
 *
 * The order is [1, 2, _, 1, 2].So return  5.
 * Skill 1 is released in the 1st second, in the 2nd second and the 3rd second enters the cooling time, and the 4th second releases the second time.
 * Skill 2 is released in the 2nd second, in the 3rd second and the 4th second enters the cooling time, and the 5th second releases the second time.
 * 注意事项
 * 数组长度不超过100000。
 * 1 \leq n \leq 201≤n≤20
 * 技能的编号是不超过100的正整数。
 */
public class Solution {
    /**
     * @param arr: The release order
     * @param n: The cooldown
     * @return: Return the time
     */
    public int askForCoolingTime(int[] arr, int n) {
        // Write your code here

        return 0;
    }

    public static void main(String[] args) {

    }
}