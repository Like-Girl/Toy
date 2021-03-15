package cn.likegirl.java.jvm.类加载的过程;

/**
 * Description :   .
 *
 * @author : LikeGirl
 * @date : Created in 2021/3/15 9:34
 */
public class Issue_20210315_01 {

    public static void main(String[] args) {
        Speak a = new A();
        a.say("hi");

        Speak b = new B();
        b.say("hi");
    }

}


abstract class Speak {

    protected String name = null;

    // final 可以继承, 无法被重写
    public final void say(String content){
        System.out.println(name + ":" + content);
    }
}


class A extends Speak{

    public A() {
        this.name = "A";
    }
    
}

class B extends Speak{

    public B() {
        this.name = "B";
    }
}


