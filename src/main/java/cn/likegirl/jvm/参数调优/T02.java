package cn.likegirl.jvm.参数调优;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: T02
 * @description: 关闭逃逸分析，关闭标量替换，关闭线程本地内存，打印GC详细信息
 * @date 2019/3/1 12:40
 *
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB -XX:+PrintGCDetails
 */
public class T02 {

    public static void main(String[] args) {
        byte[] b = new  byte[1024];
    }
}
