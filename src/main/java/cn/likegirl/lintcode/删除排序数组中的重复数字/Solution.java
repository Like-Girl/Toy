package cn.likegirl.lintcode.删除排序数组中的重复数字;

import java.util.Arrays;

/**
 * 100. 删除排序数组中的重复数字
 * 中文English
 * 给定一个排序数组，在原数组中“删除”重复出现的数字，使得每个元素只出现一次，并且返回“新”的数组的长度。
 * <p>
 * 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
 * <p>
 * 样例
 * 样例 1:
 * 输入:  []
 * 输出: 0
 * <p>
 * <p>
 * 样例 2:
 * 输入:  [1,1,2]
 * 输出: 2
 * <p>
 * 解释:
 * 数字只出现一次的数组为: [1,2]
 */
public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public static int removeDuplicates(int[] nums) {
        // write your code here
        int len;
        if((len = nums.length) <  2){
            return len;
        }
        int ans = 0,fast = 1;
        for(;;){
            if(fast == len){
                ans++;
                break;
            }
            if(nums[ans] != nums[fast]){
                nums[++ans] = nums[fast];
            }
            fast++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 3};
        int[] nums = {-14, -14, -13, -13, -13, -13, -13, -13, -13, -12, -12, -12, -12, -11, -10, -9, -9, -9, -8, -7, -5, -5, -5, -5, -4, -3, -3, -2, -2, -2, -2, -1, -1, -1, -1, -1, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 13, 14, 14, 14, 14, 15, 16, 16, 16, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 23, 23, 24, 25, 25};
        int[] res = {-14, -13, -12, -11, -10, -9, -8, -7, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 24, 25};
        System.out.println(nums.length);
        System.out.println(res.length);
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}