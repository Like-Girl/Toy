package cn.likegirl.java.cp;

import java.util.concurrent.TimeUnit;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: ThreadTest
 * @description: TODO
 * @date 2019/3/8 13:22
 */
public class ThreadTest {



    public static void main(String[] args) {
        Object obj = new Object();
        Cart cart = new Cart();
//        new Thread(cart::m1,"t1").start();
//        new Thread(cart::m4,"t2").start();

        // start
        // 申请两个对象，使用同一个锁定对象
        Cart cart1 = new Cart(obj);
        Cart cart2 = new Cart(obj);
//        new Thread(cart1::m3,"t3").start();
//        new Thread(cart2::m3,"t4").start();

//        // m1 synchronized 修饰普通方法， 锁当前对象 this
//        new Thread(cart1::m1,"t3").start();
//        // m3 synchronized 代码块, 锁对象 object
//        new Thread(cart2::m3,"t4").start();

        // m1 synchronized 修饰普通方法， 锁当前对象 this
        // 将cart2中对象，置为 cart1  发现新大陆
//        cart2.setObject(cart1);
//        new Thread(cart1::m1,"t3").start();
//        // m3 synchronized 代码块, 锁对象 object
//        new Thread(cart2::m3,"t4").start();
        // end
        cart1.setObject(cart1);
        new Thread(cart1::m1,"t3").start();
        new Thread(cart1::m3,"t4").start();


        // start
        // 试试静态方法的
        Cart cart3 = new Cart();
//        new Thread(cart3::m1,"t5").start();
//        new Thread(Cart::m2,"t6").start();
//        new Thread(Cart::m2,"t7").start();
        // end

    }
}

class Cart {

    private Object object = new Object();

    public Cart() {
    }

    public Cart(Object object) {
        this.object = object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start move.....");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 start move.....");
    }

    public synchronized static void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start move.....");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 start move.....");
    }

    public void m3() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " m3 start move.....");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m3 start move.....");
        }
    }

    public void m4() {
        System.out.println(Thread.currentThread().getName() + " m4 start move.....");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m4 start move.....");
    }
}
