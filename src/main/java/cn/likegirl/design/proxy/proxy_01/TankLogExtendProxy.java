package cn.likegirl.design.proxy.proxy_01;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: TankLogExtendProxy
 * @description: TODO
 * @date 2019/2/18 11:11
 */
public class TankLogExtendProxy extends Tank {
    
    @Override
    public void move() {
        System.out.println("Tank start move...........");
        super.move();
        System.out.println("Tank stop move............");
    }
}
