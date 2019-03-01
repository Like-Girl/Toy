package cn.likegirl.design.factory.静态工厂;

import cn.likegirl.design.factory.interfaces.Moveable;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Cart
 * @description: TODO
 * @date 2019/3/1 15:32
 */
public class Cart implements Moveable {

    @Override
    public void name() {
        System.out.println("Moveable Name: Cart");
    }

    @Override
    public void move() {
        System.out.println("cart move...............");
    }
}
