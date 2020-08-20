package cn.likegirl.java.design.proxy.proxy_03;

import cn.likegirl.design.proxy.proxy_02.Moveable;
import cn.likegirl.design.proxy.proxy_02.Tank;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Main
 * @description: TODO
 * @date 2019/2/18 14:01
 */
public class Main {

    public static void main(String[] args) {
        Tank target = new Tank();
        Moveable tank = (Moveable)(Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(proxy.getClass());
                System.out.println("proxy start.....");
                Object returnValue = method.invoke(target, args);
                System.out.println("proxy end.....");
                return returnValue;
            }
        }));
        tank.move(new ArrayList<>());

    }
}
