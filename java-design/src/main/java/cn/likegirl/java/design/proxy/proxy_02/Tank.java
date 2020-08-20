package cn.likegirl.java.design.proxy.proxy_02;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Tank
 * @description: TODO
 * @date 2019/2/18 9:46
 */
public class Tank implements Moveable {

    @Override
    public void move(List<Integer> n) {
        System.out.println("Tank move ["+ n +"]..............");
        try {
            Long random = (long) new Random().nextInt(5);
            TimeUnit.SECONDS.sleep(random);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
