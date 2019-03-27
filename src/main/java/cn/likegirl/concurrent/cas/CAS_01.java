package cn.likegirl.concurrent.cas;

import sun.misc.Unsafe;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: CAS_01
 * @description: TODO
 * @date 2019/3/25 16:24
 */
public class CAS_01 {

    private static Integer COUNT = 0;
    // 获取指针类Unsafe
    private static final Unsafe unsafe = Unsafe.getUnsafe();

    // 下述变量value在AtomicInteger实例对象内的内存偏移量
    private static long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(COUNT.getClass().getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public static class Increment implements Runnable {

        @Override
        public void run() {
            // synchronized
           /* synchronized (this){
                for (int i = 0; i < 100000; i++){
                    COUNT++;
                }
            }*/
            for (int i = 0; i < 100000; i++) {
                for(;;){
                    if(unsafe.compareAndSwapInt(COUNT, valueOffset, COUNT, COUNT + 1)){
                        break;
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        Runnable runnable = new Increment();
        Thread t1 = new Thread(runnable, "t1");
        t1.start();
        Thread t2 = new Thread(runnable, "t2");
        t2.start();
        Thread t3 = new Thread(runnable, "t2");
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(COUNT);
    }
}
