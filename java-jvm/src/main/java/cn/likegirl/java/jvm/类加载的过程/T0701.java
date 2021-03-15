package cn.likegirl.java.jvm.类加载的过程;

/**
 * JVM
 * 代码清单 7-1
 * 被动引用的例子之一
 *
 * 非主动使用类字段演示
 *
 * -XX:+TraceClassLoading 参数观察到操作会导致子类加载
 */
public class T0701 {

    /*
     * 当虚拟机启动时，用户需要制定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个类
     */
    static {
        System.out.println(" static main....");
    }

    {
        // 并不会打印
        System.out.println(" ======= >>> main....");
    }

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}

class SuperClass{
    static{
        System.out.println("SuperClass init");
    }

    /**
     * 3. 当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化
     * 修饰 final 的变量
     */
    public static int value = 123;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init");
    }

    public static int old = 123321;

}
