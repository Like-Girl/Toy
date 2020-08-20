package cn.likegirl.java.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: CAS_02
 * @date 2019/3/25 17:41
 * @description: AtomicInteger 模拟 ABA 问题
 */
public class CAS_02 {

    private static AtomicInteger COUNT = new AtomicInteger(100);

    /**
     * CAS ABA 问题
     */
    public static void aba() throws Exception{

        Thread intT1 = new Thread(new Runnable() {
            @Override
            public void run() {
                COUNT.compareAndSet(100, 101);
                COUNT.compareAndSet(101, 100);
            }
        });

        Thread intT2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean c3 = COUNT.compareAndSet(100, 101);
                System.out.println(c3);        //true
            }
        });

        intT1.start();
        intT2.start();
        intT1.join();
        intT2.join();
    }

    public static void main(String[] args) throws Exception {
        aba();
        System.out.println(COUNT.get());
    }
}
