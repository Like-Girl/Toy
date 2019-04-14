package cn.likegirl.jvm.参数调优;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: T05
 * @description: 线程栈大小
 * @date 2019/3/1 13:40
 *
 * -Xss128K
 * 大 =》 线程递归调用比较深
 * 小 =》 线程数比较多
 */
public class T05 {

    static int count =0;

    static void r(){
        count++;
        r();
    }

    public static void main(String[] args) {
        try {
            r();
        }catch (Throwable t){
            System.out.println(count);
            t.printStackTrace(); //StackOverflow
        }
    }
}
