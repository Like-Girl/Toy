package cn.likegiirl.lintcode.向上向下类型转换;

/**
 * @author LikeGirl
 */
public class Pet {
    private String name;

    public Pet(){
        this.name = "?";
        System.out.println("Pet init：?");
    }

    public Pet(String name){
        this.name = name;
        System.out.println("Pet init:：" + name);
    }

    public void describe(){
        System.out.println("this is pet class");
    }



}
