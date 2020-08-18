package cn.likegirl.java.jvm.参数调优;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Description :   .
 *
 * @author : LikeGirl
 * @date : Created in 2020/8/11 19:58
 */
public class CMS01 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        List<Object> source = new ArrayList<>();
        for (int i = 0; i < 1800 * 1024; i++){
//            try {
//                if(i > 1024 * 74){
//                    TimeUnit.MILLISECONDS.sleep(1000);
//                }else{
//                    TimeUnit.MILLISECONDS.sleep(1);
//                }
//            } catch (Exception e) {
//                // do something
//            }
//            byte[] b = new byte[1024];
//            System.out.println(i);
            source.add(new byte[1024]);
        }

        countDownLatch.await();
    }
}
