package cn.likegirl.lintcode.装箱与拆箱;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception {
        Integer a = 1;
        Integer b = 2;
        exchange(a, b);
        // 输出要求：a,b值交换
        System.out.println(a + "," + b);
    }

    public static void exchange(int a, int b) throws Exception {
    	int temp = a;
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.setInt(a,b);
        field.setInt(b,temp);
    }
}
