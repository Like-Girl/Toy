package cn.likegirl.java.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: CAS_03
 * @date 2019/3/25 17:55
 * @description: AtomicStampedReference 处理 ABA 问题
 */
public class CAS_03 {

    private static final AtomicStampedReference<Integer> COUNT = new AtomicStampedReference<>(100,0);

    public static void main(String[] args) {

        Thread refT1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                COUNT.compareAndSet(100, 101,
                        COUNT.getStamp(), COUNT.getStamp()+1);
                COUNT.compareAndSet(101, 100,
                        COUNT.getStamp(), COUNT.getStamp()+1);
            }
        });

        Thread refT2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = COUNT.getStamp();
                System.out.println("before sleep : stamp = " + stamp);    // stamp = 0
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after sleep : stamp = " + COUNT.getStamp());//stamp = 2
                boolean c3 = COUNT.compareAndSet(100, 101, stamp, stamp+1);
                System.out.println(c3);        //false
            }
        });

        refT1.start();
        refT2.start();
    }
}
