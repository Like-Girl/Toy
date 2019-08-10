package cn.likegirl.java.jvm.类加载的过程;

public class T0705 {


    static {
        i = 1;
        // 非法向前引进
//        System.out.println(i);
    }

    static int i = 0;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
