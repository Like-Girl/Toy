package cn.likegirl.lintcode.零钱问题;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Solution
 * @description:
 *      小明是一个销售员，客人在他的地方买了东西，付给了小明一定面值的钱之后，小明需要把多余的钱退给客人。
 *      客人付给了小明n，小明的东西的售价为m，小明能退回给客人的面额只能为[100,50,20,10,5,2,1]的组合。
 *      现在小明想要使纸币数量之和最小，请返回这个最小值。
 * @date 2018/11/12 11:34
 */
public class Solution {

    public static int change(int m, int n, int[] denominations){
        int count = 0;
        int money = n - m;
        for(int denomination: denominations){
            if(money < denomination || money == 0){
                continue;
            }
            count += money / denomination;
            money = money % denomination;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] denominations = {100, 50, 20, 10, 5, 2, 1};
        System.out.println(change(29,100,denominations));
    }
}
