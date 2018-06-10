package cn.likegirl.distributed.lock.zk;

import cn.likegirl.distributed.lock.Callback;
import cn.likegirl.utils.ThreadPoolManager;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sunyujia@aliyun.com on 2016/2/24.
 */


public class ZkReentrantLockTemplateTest {

    @Test
    public void testTry() throws InterruptedException {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("118.89.144.30:2181,193.112.133.164:2181,111.231.93.233:2181", retryPolicy);
        client.start();

        final ZkDistributedLockTemplate template=new ZkDistributedLockTemplate(client);
        int size=10;
        final CountDownLatch startCountDownLatch = new CountDownLatch(1);
        final CountDownLatch endDownLatch=new CountDownLatch(size);
        for (int i =0;i<size;i++){
            ThreadPoolManager.newInstance().addExecuteTask(()->{
                try {
                    startCountDownLatch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                final int sleepTime=ThreadLocalRandom.current().nextInt(5)*1000;
                template.execute("test",50000, new Callback() {
                    public Object onGetLock() throws InterruptedException {
                        System.out.println(Thread.currentThread().getName() + ":getLock");
                        Thread.currentThread().sleep(sleepTime);
                        System.out.println(Thread.currentThread().getName() + ":sleeped:"+sleepTime);
                        endDownLatch.countDown();
                        return null;
                    }
                    public Object onTimeout() throws InterruptedException {
                        System.out.println(Thread.currentThread().getName() + ":timeout");
                        endDownLatch.countDown();
                        return null;
                    }
                });
            });
        }
        startCountDownLatch.countDown();
        endDownLatch.await();
    }

public static void main(String[] args){
    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
    client.start();

    final ZkDistributedLockTemplate template=new ZkDistributedLockTemplate(client);//本类多线程安全,可通过spring注入
    template.execute("订单流水号", 5000, new Callback() {
        @Override
        public Object onGetLock() throws InterruptedException {
            //TODO 获得锁后要做的事
            return null;
        }

        @Override
        public Object onTimeout() throws InterruptedException {
            //TODO 获得锁超时后要做的事
            return null;
        }
    });
}
}
