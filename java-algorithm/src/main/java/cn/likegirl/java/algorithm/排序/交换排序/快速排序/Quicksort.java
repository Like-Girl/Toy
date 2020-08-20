package cn.likegirl.java.algorithm.排序.交换排序.快速排序;

public class Quicksort {

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }

    private static <T extends Comparable<? super T>> int partition(T[] arr, int left, int right) {
        //排序前，先让基准值和随机的一个数进行交换。这样，基准值就有随机性。
        //就不至于在数组相对有序时，导致左右两边的递归规模不一致，产生最坏时间复杂度
        swap(arr,left,(int)(Math.random()*(right - left + 1)+left));

        T base = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (base.compareTo(arr[i]) > 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, left, j);
        return j;//返回一躺排序后，基准值的下角标
    }

    public static void swap(Object[] arr, int i, int j) {
        if (i != j) {
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static void printArr(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o);
            System.out.print("\t");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Integer[] a = {3, 1, 2, 9, 6, 7, 5, 4, 0, 8};
        sort(a,0,a.length - 1);
        printArr(a);

    }

}
