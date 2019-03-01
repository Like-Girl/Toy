package cn.likegirl.jvm;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: T01
 * @description: 关闭逃逸分析，关闭标量替换，关闭线程本地内存，打印GC
 * @date 2019/3/1 12:07
 *
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB -XX:+PrintGC
 */
public class T01 {

    class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

//    User u;

    void alloc(int i) {
//        User u = new User(i, "name" + i);
        new User(i, "name" + i);
    }

    public static void main(String[] args) {
        T01 t = new T01();
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            t.alloc(i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println(s2 -s1);
    }
}
