package cn.likegirl.lintcode.圆形面积;

public class Solution {
    /**
     * @param r: the given radius
     * @return: the area of the given circle
     */
    public static double getArea(double r) {
        // write your code here
        double pi = 3.14D;
        return pi * r * r;
    }

    public static void main(String[] args) {
        System.out.println(getArea(2D));
    }
}