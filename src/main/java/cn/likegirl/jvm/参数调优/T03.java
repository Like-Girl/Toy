package cn.likegirl.jvm.参数调优;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: T03
 * @description: 也可以用过Runtime类“大致”计算内存情况
 * @date 2019/3/1 13:19
 */
public class T03 {

    public static void main(String[] args) {
        printMemoryInfo();
        byte[] b = new byte[1024 * 1024];

        System.out.println("-------------------");

        printMemoryInfo();

    }

    static void printMemoryInfo(){
        System.out.println("total: " + Runtime.getRuntime().totalMemory());
        System.out.println("free: " + Runtime.getRuntime().freeMemory());
    }
}
