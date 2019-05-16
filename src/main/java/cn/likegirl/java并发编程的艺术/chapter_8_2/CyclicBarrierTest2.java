package cn.likegirl.java并发编程的艺术.chapter_8_2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {

    /**
     * 若设置大于2，则主线程和子线程会永远等待
     */
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                    System.out.println(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        c.await();
        System.out.println(2);

    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
