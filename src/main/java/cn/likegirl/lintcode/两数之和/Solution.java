package cn.likegirl.lintcode.两数之和;


import java.util.Arrays;

/**
 * 56. 两数之和
 * 中文English
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * <p>
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 * <p>
 * 样例
 * Example1:
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [0, 1].
 * Example2:
 * 给出 numbers = [15, 2, 7, 11], target = 9, 返回 [1, 2].
 * 挑战
 * Either of the following solutions are acceptable:
 * <p>
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 * 注意事项
 * 你可以假设只有一组答案。
 */
public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        int left = 0, right = numbers.length - 1;
        int[] sortIndex = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            sortIndex[i] = i;
        }
        sort(numbers, sortIndex, left, right + 1);
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            int index;
            if ((index = search(numbers, target - temp)) > -1) {
                return new int[]{sortIndex[i] > sortIndex[index] ? sortIndex[index] : sortIndex[i], sortIndex[i] > sortIndex[index] ? sortIndex[i] : sortIndex[index]};
            }
        }
        return null;
    }

    public static int search(int[] source, Integer t) {
        if (source == null || source.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = source.length - 1;
        while (begin < end) {
            int median = (begin + end) / 2;
            if (median == begin) {
                if (source[begin] == t) {
                    return begin;
                }
                if (source[end] == t) {
                    return end;
                }
                return -1;
            } else {
                if (source[median] == t) {
                    return median;
                }
                if (source[median] > t) {
                    end = median;
                }
                if (source[median] < t) {
                    begin = median;
                }
            }
        }
        return -1;
    }

    public static void sort(int[] array,int[] sortIndex, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, sortIndex, left, right);
        sort(array, sortIndex, left, p);
        sort(array, sortIndex, p + 1, right);

    }

    public static int partition(int[] array,int[] sortIndex, int left, int right) {
        swap(array, sortIndex, left, (int) (Math.random() * (right - left) + left));
        int j = left;
        int base = array[left];
        for (int i = left + 1; i < right; i++) {
            if (base > array[i]) {
                j++;
                swap(array, sortIndex, j, i);
            }
        }
        swap(array, sortIndex, left, j);
        return j;
    }


    public static void swap(int[] array,int[] sortIndex, int i, int j) {
        if (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            int sTemp = sortIndex[i];
            sortIndex[i] = sortIndex[j];
            sortIndex[j] = sTemp;
        }
    }

    public static void main(String[] args) {
        int[] data = {1,0,-1};
        System.out.println(Arrays.toString(twoSum(data, 1)));
    }
}