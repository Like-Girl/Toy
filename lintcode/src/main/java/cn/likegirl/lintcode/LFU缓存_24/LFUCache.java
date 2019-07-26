package cn.likegirl.lintcode.LFU缓存_24;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 24. LFU缓存
 * 中文English
 * LFU是一个著名的缓存算法
 * 对于容量为k的缓存，如果缓存已满，并且需要逐出其中的密钥，则最少使用的密钥将被踢出。
 * 实现LFU中的set 和 get
 * <p>
 * 样例
 * 输入:
 * LFUCache(3)
 * set(2,2)
 * set(1,1)
 * get(2)
 * get(1)
 * get(2)
 * set(3,3)
 * set(4,4)
 * get(3)
 * get(2)
 * get(1)
 * get(4)
 * <p>
 * 输出:
 * 2
 * 1
 * 2
 * -1
 * 2
 * 1
 * 4
 */
public class LFUCache {

    transient Map<Integer, Node> cache;

    transient int capacity;

    transient int size;

    /*
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        cache = new HashMap<>(this.capacity > 0 ? (this.capacity * 2) : (1 << 4));
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        Node node;
        long timestamp = System.nanoTime();
        if((node = cache.get(key)) == null){
            if(size >= capacity){
                remove();
            }
            node = new Node(value,timestamp,1);
            cache.put(key, node);
            size++;
        }else{
            node.value = value;
            node.timestamp = timestamp;
            node.incrUsed();
        }
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!cache.containsKey(key)) {
            return -1;
        }
        return cache.get(key).getValue();
    }

    public void remove(){
        Set<Map.Entry<Integer, Node>> entries = cache.entrySet();
        Map.Entry<Integer, Node> expire = null;
        for(Map.Entry<Integer, Node> entry :entries){
            if(expire == null){
                expire = entry;
            }else{
                if(expire.getValue().used > entry.getValue().used){
                    expire = entry;
                }else if(expire.getValue().used == entry.getValue().used && expire.getValue().timestamp > entry.getValue().timestamp){
                    expire = entry;
                }
            }
        }
        if(expire != null){
            cache.remove(expire.getKey());
            size--;
        }
    }

    static class Node{
        int value;
        long timestamp;
        int used;
        Node(int value,long timestamp,int used){
            this.value = value;
            this.timestamp = timestamp;
            this.used = used;
        }

        public void incrUsed(){
            used++;
        }

        public int getValue(){
            incrUsed();
            timestamp = System.nanoTime();
            return value;
        }
    }


    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.set(1,10);
        lfuCache.set(2,20);
        lfuCache.set(3,30);
        System.out.println(lfuCache.get(1));
        lfuCache.set(4,40);
        System.out.println(lfuCache.get(4));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        lfuCache.set(5,50);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
        System.out.println(lfuCache.get(5));
    }
}