package cn.likegirl.design.proxy.proxy_01;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: TankLogProxy
 * @date 2019/2/18 10:46
 * @description: 记录Tank 移动日志
 *
 * 接口实现方式（聚合）
 */
public class TankLogProxy implements Moveable {

    private Moveable moveable;

    public TankLogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("Tank start move...........");
        moveable.move();
        System.out.println("Tank stop move............");
    }
}
