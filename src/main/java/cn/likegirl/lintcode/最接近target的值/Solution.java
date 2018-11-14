package cn.likegirl.lintcode.最接近target的值;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Solution
 * @description: TODO
 * @date 2018/11/12 14:51
 */
public class Solution {

    /**
     * @param target: the target
     * @param array:  an array
     * @return: the closest value
     */
    public static int closestTargetValue(int target, int[] array) {
        // Write your code here
        Integer result = null;
        if (array.length == 1) {
            return target >= array[0] ? array[0] : -1;
        }
        int left = 0, right = array.length - 1;
        sort(array, left, right + 1);
        int temp;
        while (left < right) {
            temp = array[left] + array[right];
            if (temp == target) {
                result = temp;
                break;
            }
            if (temp < target) {
                left++;
                if (result == null) {
                    result = temp;
                } else {
                    result = (target - result) > (target - temp) ? temp : result;
                }
            }
            if (temp > target) {
                if (array[left] == target) {
                    result = array[left];
                    break;
                }
                if (array[right] == target) {
                    result = array[right];
                    break;
                }
                if (result == null) {
                    result = (target - array[left]) > (target - array[right]) ? array[right] : array[left];
                    result = target > result ? result : null;
                } else {
                    result = (target - result) > (target - array[left]) && target > array[left] ? array[left] : result;
                    result = (target - result) > (target - array[right]) && target > array[right] ? array[right] : result;
                }
                right--;
            }
        }
        return result == null ? -1 : result;
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        sort(array, left, p);
        sort(array, p + 1, right);

    }

    public static int partition(int[] array, int left, int right) {
        swap(array, left, (int) (Math.random() * (right - left) + left));
        int j = left;
        int base = array[left];
        for (int i = left + 1; i < right; i++) {
            if (base > array[i]) {
                j++;
                swap(array, j, i);
            }
        }
        swap(array, left, j);
        return j;
    }


    public static void swap(int[] array, int i, int j) {
        if (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }


    public static void main(String[] args) {
//        int[] array = {-12,-5,14,5,0,-16};
//        int[] array = {1, 3, 5, 11, 7};
        int[] array = {-18,-4,-6,13,4,4,16,-8};
        int target = 6;

//        System.out.println(closestTargetValue(target, array));
        sort(array,0,array.length);
        for (int i : array) {
            System.out.print(i);
            System.out.print("\t");
        }
        // 1 2 4 7 8 15 17
    }
}
