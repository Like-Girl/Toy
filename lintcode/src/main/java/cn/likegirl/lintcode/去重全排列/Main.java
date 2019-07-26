package cn.likegirl.lintcode.去重全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 去重全排列
 * <p>
 * 思路：
 * 以{1,2,3,4}为例:
 *  -  -  -  -      坑位
 *  1  2  3  4      索引
 * 就像往四个坑里填数字
 *
 * 当给一号坑位填数时，有四种选择 {1,2,3,4}
 * 若给二搞坑位填数字时，去掉一号坑位填写的数字，有三种选择：
 * 例如：
 *      1  -  -  -
 *      1  2  3  4
 * 此时，还有{2,3,4}
 * 剩下位置同理
 *
 * @author LikeGirl
 */
public class Main {

    public static List<String> result = new ArrayList<>();

    /**
     * 去重
     */
    public static boolean isSwap(int[] array, int x, int y) {
        for (; x < y; x++) {
            if (array[y] == array[x]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 交换
     */
    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void arrange(int[] array, int index, int len) {
        if (index == len - 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int n : array) {
                stringBuilder.append(n);
            }
            result.add(stringBuilder.toString());
            System.out.println(stringBuilder.toString());
        }
        for (int i = index; i < len; i++) {
            if (isSwap(array, index, i)) {
                swap(array, index, i);
                arrange(array, index + 1, len);
                swap(array, index, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int len = array.length;
        arrange(array, 0, len);
        System.out.println("排列组合总数："+ result.size());

    }
}
