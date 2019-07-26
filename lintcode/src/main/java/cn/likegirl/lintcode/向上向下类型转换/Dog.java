package cn.likegirl.lintcode.向上向下类型转换;

/**
 * @author LikeGirl
 */
public class Dog extends Pet {

    @Override
    public void describe() {
        System.out.println("this is a dog");
    }


    public static void main(String[] args) {
        // 向上
        Pet p = new Dog();
        p.describe();
        // 向下
        Dog d = (Dog) p;
        d.describe();

        //不安全的向下转型,编译无错但会运行会出错
        p = new Pet();
        d = (Dog) p;
        d.describe();

    }
}
