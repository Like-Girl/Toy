package cn.likegirl.example;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.SimpleTimeZone;

public class Test01 {


    @Test
    public void test01() {
        Map<String,Object> params = new HashMap<>();
        params.put("key","10");

        String key = Optional.ofNullable(params.get("key")).map(obj->{
            System.out.println(obj.toString());
            return obj.toString();
        }).orElse("");

        String key1 = Optional.ofNullable(params.get("key")).map(String::valueOf).orElse("");
        System.out.println(key);
        System.out.println(key1);

    }

    @Test
    public void test02() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = "2018-06-14 - 2018-07-24";
        String[] datas = s.split(" - ");
        for (String data:datas){
            System.out.println(simpleDateFormat.parse(data));
        }

    }
}
