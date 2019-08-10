package cn.likegirl.java.jvm.design.factory.静态工厂;

import cn.likegirl.design.factory.interfaces.Moveable;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Tank
 * @description: TODO
 * @date 2019/3/1 15:29
 */
public class Tank implements Moveable {

    @Override
    public void name() {
        System.out.println("Moveable Name: Tank");
    }

    @Override
    public void move() {
        System.out.println("tank move...............");
    }
}
