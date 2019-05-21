package cn.likegirl.example;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.likegirl.网络编程.mina.example.aoyi.model.DeviceVin;
import cn.likegirl.utils.JSONUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    
    @SuppressWarnings("unchecked")
    @Test
    public void test03() {
    	String device = "{\"devicenumber\":\"031887689\",\"devicetype\":3,\"id\":134,\"isMain\":1,\"isdeleted\":1,\"vin\":\"LEFYECG27JHN20021\"}";
//    	System.out.println(JSON.toJSONString(device));
    	DeviceVin map1 = JSON.parseObject(device, DeviceVin.class);
    	System.out.println(map1.toString());
    	Map<String,Object> map = new HashMap<>();
    	map.put("id", 1);
    	map.put("name", "ck");
    	String jsonString = JSONUtils.beanToJson(map);
    	System.out.println(jsonString);
    }
    
    @Test
    public void test04() {
    	String android = "android 6 index 0";
    	System.out.println(android.contains("android 6"));
    	System.out.println(android.matches("^(.*?)android 6(.*?)$"));
    }
    
    static final int MAXIMUM_CAPACITY = 1 << 30;
    
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    
    @Test
    public void test05() {
    	System.out.println(tableSizeFor(240));
    }
    
    
}
