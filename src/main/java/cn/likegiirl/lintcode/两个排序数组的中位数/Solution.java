package cn.likegiirl.lintcode.两个排序数组的中位数;

/**
 * 两个排序的数组A和B分别含有m和n个数，找到两个排序数组的中位数，要求时间复杂度应为O(log (m+n))。
 * <p>
 * 样例
 * 给出数组A = [1,2,3,4,5,6] B = [2,3,4,5]，中位数3.5
 * 给出数组A = [1,2,3] B = [4,5]，中位数 3
 *
 * @author LikeGirl
 */
public class Solution {

    /**
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int lenA = A != null ? A.length : 0;
        int lenB = B != null ? B.length : 0;
        int medianIndex = (lenA + lenB) % 2 == 0 ? (lenA + lenB) / 2 - 1 : (lenA + lenB) / 2;
        if ((lenA + lenB) % 2 == 0) {
            return (findMedian(A, 0, B, 0, medianIndex) + findMedian(A, 0, B, 0, medianIndex + 1)) / 2;
//            return (findMedianNotRecursion(A, B, medianIndex) + findMedianNotRecursion(A, B, medianIndex + 1)) / 2;
        } else {
            return findMedian(A, 0, B, 0, medianIndex);
//            return findMedianNotRecursion(A, B, medianIndex);
        }
    }

    public double findMedian(int[] A, int indexA, int[] B, int indexB, int medianIndex) {
        int lenA = A != null ? A.length : 0;
        int lenB = B != null ? B.length : 0;
        if (lenA == 0) {
            return B[medianIndex];
        }
        if (lenB == 0) {
            return A[medianIndex];
        }
        if (indexA + indexB == medianIndex) {
            System.out.println(indexA + "+" + indexB + "=" + medianIndex);
            return A[indexA] < B[indexB] ? A[indexA] : B[indexB];
        }

        if (A[indexA] < B[indexB]) {
            if (indexA == lenA - 1) {
                return B[medianIndex - lenA];
            } else {
                return findMedian(A, indexA + 1, B, indexB, medianIndex);
            }
        } else {
            if (indexB == lenB - 1) {
                return A[medianIndex - lenA];
            } else {
                return findMedian(A, indexA, B, indexB + 1, medianIndex);
            }
        }
    }


    public double findMedianNotRecursion(int[] A, int[] B, int medianIndex) {
        // write your code here
        int lenA = A != null ? A.length : 0;
        int lenB = B != null ? B.length : 0;

        int indexA = 0;
        int indexB = 0;
        while (true) {
            if (lenA == 0) {
                return B[medianIndex];
            }
            if (lenB == 0) {
                return A[medianIndex];
            }
            if (indexA + indexB == medianIndex) {
                return A[indexA] < B[indexB] ? A[indexA] : B[indexB];
            }
            if (A[indexA] < B[indexB]) {
                if (indexA == lenA - 1) {
                    return B[medianIndex - lenA];
                } else {
                    ++indexA;
                }
            } else {
                if (indexB == lenB - 1) {
                    return A[medianIndex - lenA];
                } else {
                    ++indexB;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 2, 3, 4, 5, 6};
        int[] B = {2, 3, 4, 5};
        System.out.println(solution.findMedianSortedArrays(A, B));
    }
}
