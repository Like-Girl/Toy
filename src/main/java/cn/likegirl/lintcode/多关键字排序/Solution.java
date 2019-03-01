package cn.likegirl.lintcode.多关键字排序;


import java.util.Arrays;

/**
 * 846. 多关键字排序
 * 中文English
 * 给定 n 个学生的学号(从 1 到 n 编号)以及他们的考试成绩，表示为(学号，考试成绩)，请将这些学生按考试成绩降序排序，若考试成绩相同，则按学号升序排序。
 * <p>
 * 样例
 * 样例1
 * <p>
 * 输入: array = [[2,50],[1,50],[3,100]]
 * 输出: [[3,100],[1,50],[2,50]]
 * 样例2
 * <p>
 * 输入: array = [[2,50],[1,50],[3,50]]
 * 输出: [[1,50],[2,50],[3,50]]
 */
public class Solution {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public static int[][] multiSort(int[][] array) {
        // Write your code here
        sort(array, 0, array.length);
        return array;

    }

    public static void sort(int[][] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        sort(array, left, p);
        sort(array, p + 1, right);

    }

    public static int partition(int[][] array, int left, int right) {
        swap(array, left, (int) (Math.random() * (right - left) + left));
        int j = left;
        int base = array[left][1];
        for (int i = left + 1; i < right; i++) {
            if (base > array[i][1]) {
                j++;
                swap(array, j, i);
            }
        }
        swap(array, left, j);
        return j;
    }


    public static void swap(int[][] array, int i, int j) {
        if (i < j) {
            if (array[i][0] < array[j][0]) {
                int no = array[i][0];
                int score = array[i][1];
                array[i][0] = array[j][0];
                array[i][1] = array[j][1];
                array[j][0] = no;
                array[j][1] = score;
            }
        }
    }


    public static void main(String[] args) {
        int[][] array = {
                {1, 100},
                {3, 50},
                {5, 40},
                {2, 50},
                {4, 50}

        };
        multiSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][0] + "," + array[i][1]);
        }

    }
}