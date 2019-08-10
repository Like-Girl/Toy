package cn.likegirl.java.cp.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Lock_01
 * @date 2019/3/26 14:27
 * @description: 交替打印
 */
public class Lock_01 {

    public static class AlternatePrint implements Runnable {
        private static Integer COUNT = 1;

        private final Lock lock = new ReentrantLock(true);
        Condition producer = this.lock.newCondition();
        Condition consumer = this.lock.newCondition();

        @Override
        public void run() {
            boolean lock = false;
            try {
                lock = this.lock.tryLock(5, TimeUnit.SECONDS);
                if (lock) {
                    for (int i = 0; i < 10; i++) {
                        producer.signal();
                        System.out.println(Thread.currentThread().getName() + "：" + COUNT);
                        COUNT++;
                        producer.await();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (lock) {
                    this.lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        AlternatePrint print = new AlternatePrint();
        new Thread(print, "t1").start();
        new Thread(print, "t2").start();
    }
}
