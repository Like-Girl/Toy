package cn.likegirl.zookeeper.locks.distributedlock;

/**
 * Created by code4wt on 17/8/26.
 */
public interface ReadWriteLock {

    DistributedLock readLock();
    DistributedLock writeLock();
}
