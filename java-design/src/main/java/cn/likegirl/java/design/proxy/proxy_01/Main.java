package cn.likegirl.java.design.proxy.proxy_01;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Main
 * @description: TODO
 * @date 2019/2/18 10:12
 */
public class Main {


    /**
     * 场景一
     */
    public static void scene1() {
        // 聚合
        System.out.println("======================聚 合=======================");
        Tank tank = new Tank();
        Moveable tankTimeProxy = new TankTimeProxy(tank);
        tankTimeProxy.move();

        // 继承
        System.out.println("======================继 承=======================");
        TankTimeExtendProxy tankTimeExtendProxy = new TankTimeExtendProxy();
        tankTimeExtendProxy.move();
    }

    /**
     * 场景二
     */
    public static void scene2() {
        // 聚合
        System.out.println("======================聚 合=======================");
        Tank tank = new Tank();
        Moveable tankTimeProxy = new TankTimeProxy(tank);
        Moveable tankLogProxy = new TankLogProxy(tankTimeProxy);
        tankLogProxy.move();

        // 继承
        System.out.println("======================继 承=======================");
        Moveable tankExtendProxy = new TankLogAndTimeExtendProxy();
        tankExtendProxy.move();
    }

    /**
     * 场景三
     */
    public static void scene3() {
        // 聚合
        System.out.println("======================聚 合=======================");
        Tank tank = new Tank();
        Moveable tankLogProxy = new TankLogProxy(tank);
        Moveable tankTimeProxy = new TankTimeProxy(tankLogProxy);
        tankTimeProxy.move();

        // 继承
        System.out.println("======================继 承=======================");
        Moveable tankExtendProxy = new TankTimeAndLogExtendProxy();
        tankExtendProxy.move();
    }


    public static void main(String[] args) {
        scene3();
    }
}
