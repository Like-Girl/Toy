package cn.likegiirl.algorithm.排序.插入排序.希尔排序;


/**
 * 希尔排序
 *
 * @author LikeGirl
 */
public class Main {
    public static void shellSort(int[] a) {

        int gap = 1;
        while (gap < a.length) {
            // 增量问题 ？
            // 这里使用：3n - 1 => 1，4，13，40，121
            gap = gap * 3 - 1;
        }

        System.out.println(gap);

        while (gap > 0) {
            for (int i = gap; i < a.length; i++) {
                int temp = a[i];

                int currentIndex = i;

                while ((currentIndex -= gap) >= 0 && a[currentIndex] > temp) {
                    a[currentIndex + gap] = a[currentIndex];
                }
                a[currentIndex + gap] = temp;
            }

            gap = (int) Math.floor(gap / 3);

        }

    }


    public static void main(String[] args) {
        int[] a = {3, 1, 2, 9, 6, 7, 5, 4, 0, 8};
        shellSort(a);
        for (int item : a) {
            System.out.println(item);
        }

    }
}
