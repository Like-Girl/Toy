package cn.likegirl.java.jvm;

import java.util.ArrayList;
import org.junit.Test;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: JVMTest
 * @description: TODO
 * @date 2019/2/28 18:20
 */
public class JVMTest {

    @Test
    public void test01(){
        Object[] data = new Object[1000000000];
        for(int i=0;i<1000000;i++){
            data[i] = new ArrayList<>();
        }
    }


    @Test
    public void test02(){
        int a = 1;
        if(a > 0){
            System.out.println(1);
        } else if(a == 1){
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
