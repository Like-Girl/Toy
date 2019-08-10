package cn.likegirl.java.jvm.design.factory.ioc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.dom4j.Document;
import org.dom4j.Node;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: XMLPathClassApplication
 * @description: TODO
 * @date 2019/3/1 15:38
 */
public class XMLPathClassApplication implements BeanFactory {

    private final Map<String,Object> BEANS_CONTAINER = new HashMap<>();

    /** bean定义对象的映射，由bean名称键入 */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    /** 单例对象的缓存：bean名称 - > bean实例 */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(256);

    /** 单例和非单例bean名称的映射，由依赖类型键入. */
    private final Map<Class<?>, String[]> allBeanNamesByType = new ConcurrentHashMap<>(64);

    /** 仅依赖于单一的bean名称的映射，由依赖关系类型键入. */
    private final Map<Class<?>, String[]> singletonBeanNamesByType = new ConcurrentHashMap<>(64);

    public XMLPathClassApplication(String path) throws Exception{

        Document document = Dom4jUtils.parse(path);

        List<Node> nodes = document.selectNodes("//beans/bean");

        for(Node node : nodes){
            node.valueOf("class");
        }

    }

    @Override
    public Object getBean(Class<?> clazz) {
        return null;
    }

    @Override
    public Object getBean(String name) {
        return null;
    }
}
