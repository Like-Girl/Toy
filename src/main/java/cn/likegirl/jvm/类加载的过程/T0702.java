package cn.likegirl.jvm.类加载的过程;

/**
 * JVM
 * 代码清单 7-2
 * 被动引用的例子之二
 *
 * 被动使用类字段演示二
 * 通过数组定义来引用类，不会触发此类的初始化
 *
 * -XX:+TraceClassLoading 参数观察到操作会导致子类加载
 */
public class T0702 {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}
