package cn.likegiirl.algorithm.排序.选择排序.简单选择排序;

/**
 * 选择排序
 *
 * @author LikeGirl
 */
public class Main {

    public static void selectSort(int[] a) {
        int length = a.length;
        //循环次数
        for (int i = 0; i < length; i++) {
            int key = a[i];
            int position=i;
            //选出最小的值和位置
            for (int j = i + 1; j < length; j++) {
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            //交换位置
            a[position]=a[i];
            a[i]=key;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,1,2,9,6,7,5,4,0};
        selectSort(a);
        for(int item : a){
            System.out.println(item);
        }

    }

}
