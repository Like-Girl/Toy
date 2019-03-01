package cn.likegirl.design.proxy.proxy_01;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: TankTimeProxy
 * @date 2019/2/18 10:04
 * @description: 计算Tank 移动时长的代理类
 *
 * 接口实现方式（聚合）
 */
public class TankTimeProxy implements Moveable{

    private Moveable moveable;

    public TankTimeProxy(Moveable moveable){
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start: " + start);
        moveable.move();
        long end = System.currentTimeMillis();
        System.out.println("end: " + end + ", move time: " + (end - start));
    }
}
