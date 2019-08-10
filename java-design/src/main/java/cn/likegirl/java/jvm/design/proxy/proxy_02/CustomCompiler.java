package cn.likegirl.java.jvm.design.proxy.proxy_02;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: CustomCompiler
 * @date 2019/2/18 11:32
 * @description: 自定义动态编译
 */
public class CustomCompiler {

    public static void compiler(Class<?> clazz) throws Exception {


        String src = "package cn.likegirl.design.proxy.proxy_02;\n" +
                "\n" +
                "public class TankTimeProxy implements " + clazz.getName() + "{\n" +
                "\n" +
                "    private " + clazz.getName() + " target;\n" +
                "\n" +
                "    public TankTimeProxy(" + clazz.getName() + " target){\n" +
                "        this.target = target;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void move(){\n" +
                "        long start = System.currentTimeMillis();\n" +
                "        System.out.println(\"start: \" + start);\n" +
                "        target.move();\n" +
                "        long end = System.currentTimeMillis();\n" +
                "        System.out.println(\"end: \" + end + \", move time: \" + (end - start));\n" +
                "    }\n" +
                "}";

        String fileName = System.getProperty("user.dir") + "/src/main/java/cn/likegirl/design/proxy/proxy_02/TankTimeProxy.java";
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        fw.write(src);
        fw.flush();
        fw.close();

        // compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 全为null,使用默认配置
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        standardFileManager.close();

        // load into memory and create an instance
        URL[] urls = new URL[]{new URL("file:" + System.getProperty("user.dir") + "/src/main/java/")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class<?> aClazz = urlClassLoader.loadClass("cn.likegirl.design.proxy.proxy_02.TankTimeProxy");
        System.out.println(aClazz);

//        Constructor<?> constructor = aClazz.getConstructor();


    }

    public static void main(String[] args) {
        /*try {
            compiler(Comparable.class);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        Class<Moveable> moveableClass = Moveable.class;
        System.out.println(moveableClass.getName());
//        System.out.println(moveableClass.get);
        Method[] methods = moveableClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter p : parameters) {
                System.out.println(p.getName() + " : " + p.getType().getName());
            }

        }
    }
}
