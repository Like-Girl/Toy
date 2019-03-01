package cn.likegirl;

import org.junit.Test;

import java.util.ArrayList;

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
}
