package cn.likegirl.algorithm.排序.插入排序.直接插入排序;


/**
 * 直接插入排序
 *
 * @author LikeGirl
 */
public class Main {

    public static void insertSort(int[] a){
        // 数组长度，将这个提取出来是为了提高速度。
        int length=a.length;
        // 要插入的数
        int insertNum;
        //插入的次数
        for(int i=1;i<length;i++){
            insertNum = a[i];
            int j =i;
            // 将大于insertNum的数向后移
            while (j > 0 && a[j - 1] > insertNum){
                a[j] = a[j - 1];
                j--;
            }
            a[j] = insertNum;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,1,2,9,6,7,5,4,0,8};
        insertSort(a);
        for(int item : a){
            System.out.println(item);
        }

    }
}
