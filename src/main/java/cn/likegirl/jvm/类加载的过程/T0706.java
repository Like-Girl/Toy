package cn.likegirl.jvm.类加载的过程;

public class T0706 {
    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}

class Parent{
    public static int A = 1;

    static{
        A = 2;
    }
}

class Sub extends Parent{
    public static int B = A;
}


