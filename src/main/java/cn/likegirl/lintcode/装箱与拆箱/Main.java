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
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Object temp = field.get(a);
        field.set(a,b);
        field.set(b,temp);
    }
}
