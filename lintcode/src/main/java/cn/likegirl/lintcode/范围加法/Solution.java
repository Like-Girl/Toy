package cn.likegirl.lintcode.范围加法;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Solution
 * @description: TODO
 * @date 2018/11/14 9:51
 */
public class Solution {

    /**
     * @param length:  the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public static int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int startIndex = updates[i][0],
                    endIndex = updates[i][1],
                    inc = updates[i][2];
            for (int j = startIndex; j <= endIndex; j++) {
                result[j] += inc;
            }
        }
        return result;
    }

    /**
     * @param length:  the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public static int[] getModifiedArray2(int length, int[][] updates) {
        // Write your code here
        int[] result = new int[length];
        int[] arr = new int[length + 1];
        for (int i = 0; i < updates.length; i++) {
            int startIndex = updates[i][0],
                    endIndex = updates[i][1],
                    inc = updates[i][2];
            arr[startIndex] += inc;
            arr[endIndex + 1] += 0 - inc;
        }
        result[0] = arr[0];
        for (int i = 1; i < length; i++) {
            result[i] = arr[i] + result[i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int length = 10;
        int[][] updates = {
                {2, 4, 6},
                {5, 6, 8},
                {1, 9, -4}
        };
        int[] modifiedArray = getModifiedArray2(length, updates);
        for (int i = 0; i < length; i++) {
            System.out.print(modifiedArray[i]);
            System.out.print("\t");
        }
    }
}
