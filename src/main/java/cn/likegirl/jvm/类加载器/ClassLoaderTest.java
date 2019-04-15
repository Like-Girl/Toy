package cn.likegirl.jvm.类加载器;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: ClassLoaderTest
 * @description: TODO
 * @date 2019/4/15 11:15
 */



public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoaderTest test = new ClassLoaderTest();
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream stream = getClass().getResourceAsStream(fileName);
                if (stream == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[stream.available()];
                    // 将流写入字节数组b中
                    stream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException();
                }
            }
        };
        Object obj = classLoader.loadClass("cn.likegirl.jvm.类加载器.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
//        Object driver = Class.forName("cn.likegirl.jvm.类加载器.MyDriver").newInstance();
//        System.out.println(driver.getClass());
//        System.out.println(driver instanceof Driver);
        System.out.println(Driver.class.getClassLoader());

        MyDriver myDriver = new MyDriver();
        System.out.println("My Driver ClassLoader [new]:" + myDriver.getClass().getClassLoader());


        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("jdbc.drivers"));
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(test.getClassLoader());

        DriverManager.getConnection("","","");
    }


    public ClassLoader getClassLoader(){
        return getClass().getClassLoader();
    }
}
