package cn.likegirl.lintcode.二分查找;

import cn.likegirl.algorithm.排序.交换排序.快速排序.Quicksort;
import cn.likegirl.algorithm.排序.插入排序.希尔排序.Shellsort;
import cn.likegirl.algorithm.排序.插入排序.直接插入排序.Insertsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySearch {

    public static int search(Integer[] source, Integer t) {
        if (source == null || source.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = source.length - 1;
        while (begin < end) {
            int median = (begin + end) / 2;
            if (median == begin) {
                if (source[begin].equals(t)) {
                    return begin;
                }
                if (source[end].equals(t)) {
                    return end;
                }
                return -1;
            } else {
                if (source[median].equals(t)) {
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

    public static void main(String[] args) {
        final Integer DATA_LENGTH = 10000;
        List<Integer> datasource = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < DATA_LENGTH; i++) {
            datasource.add(random.nextInt(DATA_LENGTH));
        }
        Integer t1 = random.nextInt(DATA_LENGTH);
        Integer t2 = random.nextInt(DATA_LENGTH);
        Integer t3 = random.nextInt(DATA_LENGTH);
        Integer t4 = random.nextInt(DATA_LENGTH);
        Integer t5 = random.nextInt(DATA_LENGTH);


        // 二分查找效率
        Long begin = System.currentTimeMillis();
        Integer[] source = new Integer[DATA_LENGTH];
        datasource.toArray(source);
        // 快排
        Quicksort.sort(source);
        // 直接插入
//        Insertsort.sort(source);
        // 希尔
//        Shellsort.sort(source);
        System.out.println("目标元素：" + t1 + "," + search(source, t1));
        System.out.println("目标元素：" + t2 + "," + search(source, t2));
        System.out.println("目标元素：" + t3 + "," + search(source, t3));
        System.out.println("目标元素：" + t4 + "," + search(source, t4));
        System.out.println("目标元素：" + t5 + "," + search(source, t5));
        Long end = System.currentTimeMillis();
        System.out.println(end - begin);
        for(Integer num:source){
            System.out.print(num);
            System.out.print("  ");
        }
    }

}