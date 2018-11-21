package cn.likegirl.lintcode.不同的路径IV;

/**
 * 1543. 不同的路径 IV
 * 给两个整数代表网格的高和宽，起点为左上角以及终点为右上角。你可以往右上角、右或者右下角走。求你可以到达终点的路径数。结果需要 mod 1000000007.
 * <p>
 * 样例
 * input:
 * height = 3
 * width = 3
 * output:
 * 2
 * 注意事项
 * width > 1, height > 1
 */
public class Solution {
    /**
     * @param height: the given height
     * @param width:  the given width
     * @return: the number of paths you can reach the end
     */
    public static int uniquePath(int height, int width) {
        // Write your code here
        if (width <= 1) {
            return 1;
        }
        int i1 = width % 2 == 0 ? width / 2 : width / 2 + 1;
        int maxHeight = i1 > height ? height : i1;
        int[][] arr = new int[maxHeight][width];
        arr[0][1] = 1;
        arr[1][1] = 1;
        for (int i = 2; i < width; i++) {
            int tempHeight = maxHeight;
//            tempHeight = tempHeight < i ? tempHeight : i;
//            tempHeight = tempHeight < width - i ? tempHeight: width - i;
            for (int j = 0; j < tempHeight; j++) {
                if (j - 1 >= 0) {
                    arr[j][i] += arr[j - 1][i - 1] ;
                    arr[j][i] %= 1000000007;
                }
                arr[j][i] += arr[j][i - 1];
                arr[j][i] %= 1000000007;
                if (j + 1 < maxHeight) {
                    arr[j][i] += arr[j + 1][i - 1];
                    arr[j][i] %= 1000000007;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        return arr[0][width - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePath(27, 38));
    }
}