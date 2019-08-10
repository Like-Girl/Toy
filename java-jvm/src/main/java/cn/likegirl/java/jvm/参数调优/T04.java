package cn.likegirl.java.jvm.参数调优;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: T04
 * @description: 内存溢出
 * @date 2019/3/1 13:24
 * <p>
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\LikeGirl\Desktop\插件\Toy\jvm.dump -XX:+PrintGCDetails -Xloggc:C:\Users\LikeGirl\Desktop\插件\Toy\app.log
 * -Xms10M -Xmx10M
 */
public class T04 {

    public static void main(String[] args) {

        List<Object> lists = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            lists.add(new byte[1024 * 1024]);
        }
    }
}
