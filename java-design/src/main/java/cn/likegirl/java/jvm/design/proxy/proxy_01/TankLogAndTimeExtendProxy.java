package cn.likegirl.java.jvm.design.proxy.proxy_01;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: TankTime
 * @date 2019/2/18 10:17
 * @description: 先记录日志，在计算Tank 移动时间
 *
 * 继承实现方式（继承）
 */
public class TankLogAndTimeExtendProxy extends TankTimeExtendProxy {

    @Override
    public void move() {
        System.out.println("Tank start move...........");
        super.move();
        System.out.println("Tank stop move............");
    }
}
