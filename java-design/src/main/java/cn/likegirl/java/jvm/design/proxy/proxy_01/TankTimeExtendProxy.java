package cn.likegirl.java.jvm.design.proxy.proxy_01;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: TankTime
 * @date 2019/2/18 10:17
 * @description: 计算Tank 移动时长的代理类
 *
 * 继承实现方式（继承）
 */
public class TankTimeExtendProxy extends Tank {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start: " + start);
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("end: " + end + ", move time: " + (end - start));
    }
}
