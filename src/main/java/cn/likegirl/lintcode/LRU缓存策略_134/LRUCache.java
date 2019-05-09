package cn.likegirl.lintcode.LRU缓存策略_134;


import cn.likegirl.lintcode.LFU缓存_24.LFUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 134. LRU缓存策略
 * 中文English
 * 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据（get）和写入数据（set）。
 * <p>
 * 获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 * <p>
 * 写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入：
 * LRUCache(2)
 * set(2, 1)
 * set(1, 1)
 * get(2)
 * set(4, 1)
 * get(1)
 * get(2)
 * 输出：[1,-1,1]
 * 解释：
 * cache上限为2，set(2,1)，set(1, 1)，get(2) 然后返回 1，set(4,1) 然后 delete (1,1)，因为 （1,1）最少使用，get(1) 然后返回 -1，get(2) 然后返回 1。
 * 样例 2:
 * <p>
 * 输入：
 * LRUCache(1)
 * set(2, 1)
 * get(2)
 * set(3, 2)
 * get(2)
 * get(3)
 * 输出：[1,-1,2]
 * 解释：
 * cache上限为 1，set(2,1)，get(2) 然后返回 1，set(3,2) 然后 delete (2,1)，get(2) 然后返回 -1，get(3) 然后返回 2。
 */
public class LRUCache {

    transient Map<Integer, LRUCache.Node> cache;

    transient int capacity;

    transient int size;

    static class Node {
        int value;
        long timestamp;

        public Node(int value) {
            this.value = value;
            setTimestamp();
        }

        public void setTimestamp() {
            timestamp = System.nanoTime();
        }

        public void setValue(int value) {
            setTimestamp();
            this.value = value;
        }

        public int getValue() {
            setTimestamp();
            return value;
        }
    }

    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        cache = new HashMap<>(capacity > 0 ? (capacity * 2) : (1 << 4));
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

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        Node node;
        if ((node = cache.get(key)) == null) {
            if (size >= capacity) {
                remove();
            }
            node = new Node(value);
            cache.put(key, node);
            size++;
        } else {
            node.setValue(value);
        }
    }

    public void remove(){
        // 空间换时间
        Set<Map.Entry<Integer, LRUCache.Node>> entries = cache.entrySet();
        Map.Entry<Integer, LRUCache.Node> expire = null;
        for(Map.Entry<Integer, LRUCache.Node> entry :entries){
            if(expire == null){
                expire = entry;
            }else{
                if(expire.getValue().timestamp > entry.getValue().timestamp){
                    expire = entry;
                }
            }
        }
        if(expire != null){
            cache.remove(expire.getKey());
            size--;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        System.out.println(lruCache.get(2));
        lruCache.set(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}