package cn.likegirl.design.proxy.proxy_01;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: TankTimeAndLogExtendProxy
 * @description: TODO
 * @date 2019/2/18 11:11
 */
public class TankTimeAndLogExtendProxy extends TankLogExtendProxy {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start: " + start);
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("end: " + end + ", move time: " + (end - start));
    }
}
